package data_structures.graph;

public class InboundEdge {
    private Node source;

    private int weight;

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
