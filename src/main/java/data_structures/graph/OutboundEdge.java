package data_structures.graph;

/**
 * An edge that belong to the node it starts from
 */
public class OutboundEdge {

    private Node destination;

    private int weight;

    public OutboundEdge(Node destination)
    {
     this.destination = destination;
     this.weight = 1;
    }

    public OutboundEdge(Node destination, int weight)
    {
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
