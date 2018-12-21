package utils;

import data_structures.graph.Graph;
import data_structures.graph.InboundEdge;
import data_structures.graph.Node;
import data_structures.graph.OutboundEdge;

public class GraphConverter {


    public static Graph<Integer> convertMatrixToGraph( boolean[][] matrix)
    {
        Node<Integer> newNode;
        Graph<Integer> graph = new Graph<>();

        for (int i = 0; i < matrix.length; i++) {
            newNode = new Node<>(i + 1);
            graph.addNode(newNode);
        }

        Node<Integer> currentNode;
        Node<Integer> refNode;
        OutboundEdge newOEdge;
        InboundEdge newIEdge;

        for (int i = 0; i < matrix.length; i++) {
            currentNode = graph.getNode(i);
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j])
                {
                    refNode = graph.getNode(j);
                    newOEdge = new OutboundEdge(refNode);
                    newIEdge = new InboundEdge(currentNode);
                    currentNode.addOutboundEdge(newOEdge);
                    refNode.addInboundEdge(newIEdge);
                }
            }
        }

        return graph;
    }

}
