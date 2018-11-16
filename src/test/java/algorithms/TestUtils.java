package algorithms;

import data_structures.CustomArrayList;
import data_structures.graph.InboundEdge;
import data_structures.graph.OutboundEdge;
import data_structures.graph.Graph;
import data_structures.graph.Node;

class TestUtils {


    static Graph<Integer> generateIntegerGraph(int size)
    {
        Graph<Integer> g = new Graph<>();

        CustomArrayList<Node<Integer>> nodes = new CustomArrayList<>();

        for (int i = 0; i < size; i++) {
            Node<Integer> node = new Node<>(i);
            nodes.add(node);
        }

        Node<Integer> currentNode;
        Node<Integer> reference1;
        Node<Integer> reference2;
        Node<Integer> reference3;
        OutboundEdge edge;
        OutboundEdge edge2;
        OutboundEdge edge3;
        InboundEdge iedge;
        InboundEdge iedge2;
        InboundEdge iedge3;

        for (int i = 0; i < nodes.size(); i++) {

            currentNode = nodes.get(i);

            reference1 = nodes.get((i + 3) % size);
            reference2 = nodes.get((i + 7) % size);
            reference3 = nodes.get((i+11) % size);
            edge = new OutboundEdge(reference1, 1);
            edge2 = new OutboundEdge(reference2, 1);
            edge3 = new OutboundEdge(reference3, 1);
            iedge = new InboundEdge(currentNode, 1);



            if( i != 1 && i % 12 == 0)
            {
                currentNode.addOutboundEdge(edge3);
                reference3.addInboundEdge(iedge);
            }
            else if ( i != 1 && i % 3 == 0)
            {
                currentNode.addOutboundEdge(edge);
                reference1.addInboundEdge(iedge);
            } else if ( i != 1 && i % 4 == 0)
            {
                currentNode.addOutboundEdge(edge2);
                reference2.addInboundEdge(iedge);
            } else
            {
                currentNode.addOutboundEdge(edge);
                currentNode.addOutboundEdge(edge2);
                reference1.addInboundEdge(iedge);
                reference2.addInboundEdge(iedge);
            }

            g.addNode(currentNode);
        }

        return g;

    }
}
