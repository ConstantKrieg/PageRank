package data_structures.graph;

import data_structures.CustomArrayList;

public class Node<T> {


    private T value;

    private CustomArrayList<OutboundEdge> outboundEdges;

    private CustomArrayList<InboundEdge> inboundEdges;

    private double pageRank;


    public Node(T value) {
        this.value = value;
        this.pageRank = 0.0;
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

    public void getOutboundEdge(OutboundEdge e)
    {
        this.outboundEdges.add(e);
    }

    public OutboundEdge getInboundEdge(int index)
    {
        return this.outboundEdges.get(index);
    }

    public void addOutboundEdge( OutboundEdge e ) {
        this.outboundEdges.add(e);
    }

    public void addInboundEdge( InboundEdge e )
    {
        this.inboundEdges.add(e);
    }


    public double getPageRank() {
        return pageRank;
    }

    public void setPageRank(double pageRank) {
        this.pageRank = pageRank;
    }
}
