package algorithms;

import data_structures.CustomArrayList;
import data_structures.graph.Graph;
import data_structures.graph.Node;

import static utils.NumberUtils.countDifference;
import static utils.NumberUtils.round;
import static algorithms.sorting.SortMaster.sort;

public class PageRanker {


    private final double dampingFactor = 0.65;
    private double convergenceThreshold;

    private CustomArrayList<Node> sinks;
    private double combinedSinkPageRank;

    private boolean hasNotConverged;


    /**
     * Performs PageRank
     * @param g Graph that is going to be PageRanked
     * @return number of iterations PageRank took to finish
     */
    public int pageRank( Graph g )
    {
        sinks = new CustomArrayList<>();
        convergenceThreshold = 1.0 / (g.nodeCount() * 1000.0);
        hasNotConverged = true;
        combinedSinkPageRank = 0.0;
        collectSinks(g);
        initializePageRankValueForNodes(g.getNodes());

        int iterations = 1;
        while ( hasNotConverged )
        {
            for (int i = 0; i < g.nodeCount(); i++) {
                updatePageRankScore(g.getNode(i));
            }

            double combinedSinksPR = 0.0;
            for (int i = 0; i < sinks.size(); i++) {
                combinedSinksPR += sinks.get(i).getCurrentPageRank() / g.nodeCount() ;
            }
            updatePageRankScoresAfterIteration(g.getNodes(), combinedSinksPR);
            iterations++;
        }

        sort(g.getNodes(), 0, g.nodeCount() - 1);
        return iterations;
    }

    private void collectSinks(Graph graph)
    {
        Node currentNode;
        for (int i = 0; i < graph.nodeCount(); i++) {
            currentNode = graph.getNode(i);
            if (currentNode.getReferenceCount() == 0.0) sinks.add(currentNode);
        }
    }

    /**
     * After completing the PageRank counts the final PageRank-value using the
     * PageRank formula
     * @param nodeList list of nodes that need to be assigned final PR
     */
    private void finalizePageRankValues(CustomArrayList<Node> nodeList)
    {
        double finalPageRank;
        Node node;
        for (int i = 0; i < nodeList.size(); i++) {
            node = nodeList.get(i);
            finalPageRank = ((1 - dampingFactor) / nodeList.size()) + ( dampingFactor * node.getCurrentPageRank()) + (dampingFactor * (combinedSinkPageRank / sinks.size()));
            node.setCurrentPageRank(finalPageRank);
        }
    }

    /**
     * Assigns every node the PageRank-value of 1 / n where n is the size of nodelist
     * @param nodeList List of nodes that are initialized
     */
    private void initializePageRankValueForNodes(CustomArrayList<Node>  nodeList)
    {
        // Assigns every node the initial PR which is 1/n, when n is the number of nodes

        int divider = nodeList.size();
        double initialPageRankValue = 1.0 / divider;

        for (int i = 0; i < divider; i++) {
            Node node = nodeList.get(i);
            node.setCurrentPageRank(initialPageRankValue);
            nodeList.put(i, node);
        }

    }

    /**
     * After every iteration reinitializes next PageRank value and updates the current PageRank to be
     * the one that was marked the next value in previous iteration
     * @param nodeList List of nodes that are updated
     */
    private void updatePageRankScoresAfterIteration(CustomArrayList<Node>  nodeList, double combinedSinksPR)
    {
        //Updates the scores for every node and compares new score to the old one
        //This difference is used to determine if the graph has converged

        boolean noConvergence = false;

        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);

            double oldPR = node.getCurrentPageRank();

            node.setCurrentPageRank(((1 - dampingFactor) / nodeList.size()) + ( dampingFactor * node.getNextPageRank()) + (dampingFactor * combinedSinksPR));
            node.setNextPageRank(0.0);
            nodeList.put(i, node);

            double difference = countDifference(node.getCurrentPageRank(), oldPR);
            if (difference > convergenceThreshold) noConvergence = true;
        }

        hasNotConverged = noConvergence;
    }

    /**
     * Searches for sinks which are nodes with no outgoing edges
     * and combines their PageRank divided by size of the list to a
     * single value that is added to every other nodes PageRank later
     * @param nodeList List of nodes where sinks are to be searched
     */
    private void handleSinks(CustomArrayList<Node>  nodeList)
    {

        for (int i = 0; i < nodeList.size(); i++) {
            Node currentNode = nodeList.get(i);

            if (currentNode.getOutboundEdges().size() == 0)
            {
                // This node is a sink
                combinedSinkPageRank += currentNode.getCurrentPageRank() / nodeList.size();
            }
        }
    }

    /**
     * Takes a node and updates its PageRank value by  combining PR(X) / C(X)
     * to every X where X is a node that references n and C(X) is the number
     * of outgoing edges in X
     * @param n Node that is updated
     */
    private void updatePageRankScore(Node n)
    {
        double newPR = 0;

        // Goes through every node that references current one
        for (int i = 0; i < n.getInboundEdgeCount(); i++)
        {
            // For every referencing node, count the percentage of reference to this node in the referencing node
            Node reference = n.getInboundEdge(i).getSource();
            double refPercentage = 1 / reference.getReferenceCount();

            // Count the cumulative sum of pageranks in every referencing node
            newPR += reference.getCurrentPageRank() * refPercentage;
        }

        n.setNextPageRank(newPR);

    }

    /**
     * Prints out every nodes PageRank and sums them together.
     * If the combined value is 1, PageRank has been succesful
     * @param g Graph that has been PageRanked
     * @return boolean value based on if combined PageRank-value is 1
     */
    public boolean validatePageRankResult( Graph g )
    {
        double result = 0.0;

        CustomArrayList<Node>  nodeList = g.getNodes();

        for (int i = 0; i < nodeList.size(); i++)
        {
            System.out.println("PageRank of node " + nodeList.get(i).getValue() + "  is: " + round(nodeList.get(i).getCurrentPageRank(), 6) );
            result += nodeList.get(i).getCurrentPageRank();

        }

        System.out.println("Combined pagerank:  " + round(result, 7));

        //PageRank should form a probability distribution so combined PageRank should always be 1
        return round(result, 7) == 1.0;
    }

}
