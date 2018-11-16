package algorithms;

import data_structures.CustomArrayList;
import data_structures.graph.Graph;
import data_structures.graph.Node;

public class PageRanker {


    public void pageRank( Graph g )
    {
        initializePageRankValueForNodes(g.getNodes());
    }


    public void initializePageRankValueForNodes(CustomArrayList<Node>  nodeList)
    {
        int divider = nodeList.size();
        double initialPageRankValue = 1.0 / divider;

        for (int i = 0; i < divider; i++) {
            Node node = nodeList.get(i);
            node.setPageRank(initialPageRankValue);
            nodeList.put(i, node);
        }

    }

    public void updatePageRankScore(Node n)
    {
    }

}
