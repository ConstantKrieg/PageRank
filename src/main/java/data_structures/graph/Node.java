package data_structures.graph;

import data_structures.CustomArrayList;

public class Node<T> {


    private T value;

    private CustomArrayList<Edge> edges;


    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CustomArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(CustomArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge e)
    {
        this.edges.add(e);
    }
}
