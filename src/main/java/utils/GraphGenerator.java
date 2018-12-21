package utils;

import data_structures.graph.Graph;
import data_structures.graph.InboundEdge;
import data_structures.graph.Node;
import data_structures.graph.OutboundEdge;

import java.util.Random;

public class GraphGenerator {

    public static Graph<Character> generateExampleGraph()
    {
        Node<Character> aNode = new Node<>('A');
        Node<Character> bNode = new Node<>('B');
        Node<Character> cNode = new Node<>('C');
        Node<Character> dNode = new Node<>('D');
        Node<Character> eNode = new Node<>('E');

        OutboundEdge aoEdge = new OutboundEdge(bNode,1);
        OutboundEdge aoEdge2 = new OutboundEdge(cNode,1);
        InboundEdge aiEdge = new InboundEdge(cNode, 1);
        aNode.addOutboundEdge(aoEdge);
        aNode.addOutboundEdge(aoEdge2);
        aNode.addInboundEdge(aiEdge);

        OutboundEdge boEdge = new OutboundEdge(eNode,1);
        InboundEdge biEdge = new InboundEdge(aNode, 1);

        bNode.addOutboundEdge(boEdge);
        bNode.addInboundEdge(biEdge);

        OutboundEdge coEdge = new OutboundEdge(aNode,1);
        OutboundEdge coEdge2 = new OutboundEdge(dNode,1);
        OutboundEdge coEdge3 = new OutboundEdge(eNode,1);
        InboundEdge ciEdge = new InboundEdge(dNode, 1);
        InboundEdge ciEdge2 = new InboundEdge(aNode, 1);

        cNode.addOutboundEdge(coEdge);
        cNode.addOutboundEdge(coEdge2);
        cNode.addOutboundEdge(coEdge3);
        cNode.addInboundEdge(ciEdge);
        cNode.addInboundEdge(ciEdge2);

        OutboundEdge doEdge = new OutboundEdge(eNode,1);
        OutboundEdge doEdge2 = new OutboundEdge(cNode,1);
        InboundEdge diEdge = new InboundEdge(eNode, 1);
        InboundEdge diEdge2 = new InboundEdge(cNode, 1);

        dNode.addOutboundEdge(doEdge);
        dNode.addOutboundEdge(doEdge2);
        dNode.addInboundEdge(diEdge);
        dNode.addInboundEdge(diEdge2);

        OutboundEdge eoEdge = new OutboundEdge(dNode,1);
        InboundEdge eiEdge = new InboundEdge(bNode, 1);
        InboundEdge eiEdge2 = new InboundEdge(cNode, 1);
        InboundEdge eiEdge3 = new InboundEdge(dNode, 1);

        eNode.addOutboundEdge(eoEdge);
        eNode.addInboundEdge(eiEdge);
        eNode.addInboundEdge(eiEdge2);
        eNode.addInboundEdge(eiEdge3);

        Graph<Character> g = new Graph<>();
        g.addNode(aNode);
        g.addNode(bNode);
        g.addNode(cNode);
        g.addNode(dNode);
        g.addNode(eNode);

        return g;
    }

    public static Graph<Integer> generateGraphWithSpecificAmountOfNodesAndEdges(int nodeCount, int edgeCount)
    {
        Graph<Integer> graph = new Graph<>();
        Node<Integer> newNode;
        Random random = new Random();

        for (int i = 0; i < nodeCount; i++)
        {
            newNode = new Node<>(i);
            graph.addNode(newNode);
        }

        Node aNode;
        Node bNode;
        InboundEdge iEdge;
        OutboundEdge oEdge;

        for (int i = 0; i < edgeCount; i++)
        {
            aNode = graph.getNode(random.nextInt(nodeCount));
            bNode = graph.getNode(random.nextInt(nodeCount));

            while (containsReferenceToNode(aNode, bNode)) bNode = graph.getNode(random.nextInt(nodeCount));

            iEdge = new InboundEdge(aNode);
            oEdge = new OutboundEdge(bNode);

            aNode.addOutboundEdge(oEdge);
            bNode.addInboundEdge(iEdge);

        }
        return graph;
    }



    private static boolean containsReferenceToNode(Node<Integer> a, Node<Integer> b)
    {

        for (int i = 0; i < a.getOutboundEdges().size(); i++) {
            if (a.getOutboundEdges().get(i).getDestination().getValue() == b.getValue()) return true;
        }

        for (int i = 0; i < b.getOutboundEdges().size(); i++) {
            if (b.getOutboundEdges().get(i).getDestination().getValue() == a.getValue()) return true;
        }

        return false;
    }


}
