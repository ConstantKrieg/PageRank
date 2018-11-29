package algorithms;

import data_structures.CustomArrayList;
import data_structures.graph.Graph;
import data_structures.graph.Node;

import static algorithms.NumberUtils.round;
import static algorithms.sorting.QuickSorter.quicksort;

public class PageRanker {


    private double dampingFactor = 0.85;

    public void pageRank( Graph g )
    {
        initializePageRankValueForNodes(g.getNodes());

        //Currently just does this 14 times, convergence check not implemented yet
        for (int j = 0; j < 14; j++)
        {
            for (int i = 0; i < g.nodeCount(); i++) {
                updatePageRankScore(g.getNode(i));
            }
            updatePageRankScoresAfterIteration(g.getNodes());
        }

        quicksort(g.getNodes(), 0, g.nodeCount() - 1);

    }


    private void initializePageRankValueForNodes(CustomArrayList<Node>  nodeList)
    {
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
        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            node.setCurrentPageRank(node.getNextPageRank());
            node.setNextPageRank(0.0);
            nodeList.put(i, node);
        }
    }

    private void updatePageRankScore(Node n)
    {
        double newPR = 0;

        for (int i = 0; i < n.getInboundEdgeCount(); i++)
        {
            Node reference = n.getInboundEdge(i).getSource();
            double ps = 1 / reference.getReferenceCount();
            newPR += reference.getCurrentPageRank() * ps;
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

        System.out.println("Combined pagerank:  " + result);

        //PageRank should form a probability distribution so combined PageRank should always be 1
        return round(result, 4) == 1.0;
    }

}
