package utils;

import data_structures.CustomArrayList;
import data_structures.graph.Graph;
import data_structures.graph.InboundEdge;
import data_structures.graph.Node;
import data_structures.graph.OutboundEdge;

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


    public static Graph<Integer> generateIntegerGraph(int size)
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
