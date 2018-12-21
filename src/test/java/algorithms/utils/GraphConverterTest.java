package algorithms.utils;

import data_structures.graph.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static utils.GraphConverter.convertMatrixToGraph;

public class GraphConverterTest {

    @Test
    public void testConvertMatrixToGraph()
    {
        boolean[][] graphMatrix = {
                {false, true, false, false, false},
                {false, false, false, false, true},
                {true, true, false, true, true},
                {false, false, true, false, true},
                {false, false, false, true, false}
        };

        Graph resultGraph = convertMatrixToGraph(graphMatrix);

        assertEquals(5,resultGraph.nodeCount());
        assertEquals(1, resultGraph.getNode(0).getOutboundEdges().size());
        assertEquals(1, resultGraph.getNode(1).getOutboundEdges().size());
        assertEquals(4, resultGraph.getNode(2).getOutboundEdges().size());
        assertEquals(2, resultGraph.getNode(3).getOutboundEdges().size());
        assertEquals(1, resultGraph.getNode(4).getOutboundEdges().size());

        assertEquals(1, resultGraph.getNode(0).getInboundEdgeCount());
        assertEquals(2, resultGraph.getNode(1).getInboundEdgeCount());
        assertEquals(1, resultGraph.getNode(2).getInboundEdgeCount());
        assertEquals(2, resultGraph.getNode(3).getInboundEdgeCount());
        assertEquals(3, resultGraph.getNode(4).getInboundEdgeCount());

    }
}
