package data_structures.graph;

/**
 * An edge that belongs to the node it reaches
 */
public class InboundEdge {
    private Node source;

    private int weight;

    public InboundEdge(Node source) {
        this.source = source;
        this.weight = 1;
    }
    public InboundEdge(Node source, int weight) {
        this.source = source;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
