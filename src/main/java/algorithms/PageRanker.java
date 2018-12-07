package algorithms;

import data_structures.CustomArrayList;
import data_structures.graph.Graph;
import data_structures.graph.Node;

import static algorithms.NumberUtils.countDifference;
import static algorithms.NumberUtils.round;
import static algorithms.sorting.SortMaster.quicksort;

public class PageRanker {


    private final double dampingFactor = 0.85;
    private final double convergenceThreshold = 0.01;

    private boolean hasNotConverged;


    public void pageRank( Graph g )
    {
        hasNotConverged = true;
        initializePageRankValueForNodes(g.getNodes());

        int j = 1;
        while ( hasNotConverged )
        {
            for (int i = 0; i < g.nodeCount(); i++) {
                updatePageRankScore(g.getNode(i));
            }
            updatePageRankScoresAfterIteration(g.getNodes());
            j++;
        }

        System.out.println("Took " + j + " iterations");
        quicksort(g.getNodes(), 0, g.nodeCount() - 1);

    }


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

    private void updatePageRankScoresAfterIteration(CustomArrayList<Node>  nodeList)
    {
        //Updates the scores for every node and compares new score to the old one
        //This difference is used to determine if the graph has converged

        boolean noConvergence = false;

        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);

            double difference = countDifference(node.getCurrentPageRank(), node.getNextPageRank());
            if (difference > convergenceThreshold) noConvergence = true;

            node.setCurrentPageRank(node.getNextPageRank());
            node.setNextPageRank(0.0);
            nodeList.put(i, node);
        }

        hasNotConverged = noConvergence;
    }

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

    public boolean validatePageRankResult( Graph g )
    {
        double result = 0.0;

        CustomArrayList<Node>  nodeList = g.getNodes();

        for (int i = 0; i < nodeList.size(); i++)
        {
            System.out.println("PageRank of node " + nodeList.get(i).getValue() + "  is: " + round(nodeList.get(i).getCurrentPageRank(), 4) );
            result += nodeList.get(i).getCurrentPageRank();

        }

        System.out.println("Combined pagerank:  " + round(result, 4));

        //PageRank should form a probability distribution so combined PageRank should always be 1
        return round(result, 4) == 1.0;
    }

}
