package data_structures.graph;

import data_structures.CustomArrayList;

public class Graph<T> {

    private CustomArrayList<Node<T>> nodes;

    public Graph() {
        this.nodes = new CustomArrayList<Node<T>>();
    }

    public CustomArrayList<Node<T>> getNodes()
    {
        return nodes;
    }

    public void addNode( Node<T> node )
    {
        this.nodes.add( node );
    }

    public int nodeCount()
    {
        return this.nodes.size();
    }

    public Node getNode(int index) { return this.nodes.get(index); }
}
