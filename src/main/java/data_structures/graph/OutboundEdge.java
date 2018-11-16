package data_structures.graph;

public class OutboundEdge {

    private Node destination;

    private int weight;

    public OutboundEdge(Node destination, int weight) {
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
