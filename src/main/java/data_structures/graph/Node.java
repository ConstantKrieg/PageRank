package data_structures.graph;

import data_structures.CustomArrayList;

/**
 * An implementation of a single node/vertex in a graph
 * @param <T> Type of the attribute node has as an value
 */
public class Node<T> {


    private T value;

    private CustomArrayList<OutboundEdge> outboundEdges;

    private CustomArrayList<InboundEdge> inboundEdges;

    private double currentPageRank;

    private double nextPageRank;


    public Node(T value) {
        this.value = value;
        this.currentPageRank = 0.0;
        this.nextPageRank = 0.0;
        this.outboundEdges = new CustomArrayList<>();
        this.inboundEdges = new CustomArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CustomArrayList<OutboundEdge> getOutboundEdges() {
        return outboundEdges;
    }

    public void setOutboundEdges(CustomArrayList<OutboundEdge> outboundEdges) {
        this.outboundEdges = outboundEdges;
    }

    public void getOutboundEdge(int index)
    {
        this.outboundEdges.get(index);
    }

    public InboundEdge getInboundEdge(int index)
    {
        return this.inboundEdges.get(index);
    }

    public void addOutboundEdge( OutboundEdge e ) {
        this.outboundEdges.add(e);
    }

    public void addInboundEdge( InboundEdge e )
    {
        this.inboundEdges.add(e);
    }


    public double getCurrentPageRank() {
        return currentPageRank;
    }

    public void setCurrentPageRank(double currentPageRank) {
        this.currentPageRank = currentPageRank;
    }

    public double getNextPageRank() {
        return nextPageRank;
    }

    public void setNextPageRank(double nextPageRank) {
        this.nextPageRank = nextPageRank;
    }

    public double getReferenceCount() { return this.outboundEdges.size();  }

    public int getInboundEdgeCount() { return this.inboundEdges.size(); }
}
