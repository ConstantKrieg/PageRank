package data_structures.graph;

import data_structures.CustomArrayList;

/**
 * Implementation of a graph data structure
 * @param <T> Type of objects in the nodes
 */
public class Graph<T> {

    private CustomArrayList<Node<T>> nodes;

    public Graph() {
        this.nodes = new CustomArrayList<Node<T>>();
    }

    /**
     * Returns nodes of this graph as an arraylist
     * @return Nodes as an arraylist
     */
    public CustomArrayList<Node<T>> getNodes()
    {
        return nodes;
    }

    /**
     * Adds a node in to the graph
     * @param node Node to be added
     */
    public void addNode( Node<T> node )
    {
        this.nodes.add( node );
    }

    /**
     * Returns the amount of nodes in the graph
     * @return amount of nodes in the graph
     */
    public int nodeCount()
    {
        return this.nodes.size();
    }

    /**
     * Returns a specific node from a specific index
     * @param index Index of the wanted node
     * @return Node in the index
     */
    public Node getNode(int index) { return this.nodes.get(index); }
}
