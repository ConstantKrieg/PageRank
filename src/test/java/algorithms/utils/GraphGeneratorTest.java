package algorithms.utils;

import data_structures.graph.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static utils.GraphGenerator.generateGraphWithSpecificAmountOfNodesAndEdges;

public class GraphGeneratorTest {


    @Test
    public void testGenerateGraphWithSpecificAmountOfNodesAndEdges()
    {
        Graph g = generateGraphWithSpecificAmountOfNodesAndEdges(20, 50);

        int edgeAmount = 0;
        for (int i = 0; i < g.nodeCount(); i++) {
            edgeAmount += g.getNode(i).getInboundEdgeCount();
        }

        assertEquals(20, g.nodeCount());
        assertEquals(50, edgeAmount);
    }
}
