package algorithms;

import data_structures.graph.Graph;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.GraphConverter.convertMatrixToGraph;
import static utils.GraphGenerator.generateExampleGraph;

public class PageRankerTest {

    @Test
    public void testPageRanker()
    {
        Graph<Character> g = generateExampleGraph();
        PageRanker pageRanker = new PageRanker();
        pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));
    }

    @Test
    public void testPageRankerWithPreDefinedGraph()
    {
        boolean[][] graphMatrice = {
                {false, true, false, false, false},
                {false, false, false, false, true},
                {true, true, false, true, true},
                {false, false, true, false, true},
                {false, false, false, true, false}
        };

        Graph<Integer> g = convertMatrixToGraph(graphMatrice);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));
    }

    @Test
    public void testPageRankerIsValidWithARandomGraph()
    {

        boolean[][] graphMatrice = new boolean[1000][1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                graphMatrice[i][j] = random.nextBoolean();
            }
        }

        Graph<Integer> g = convertMatrixToGraph(graphMatrice);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));

        for (int i = 1; i < g.nodeCount(); i++) {
            assertTrue(g.getNode(i).getCurrentPageRank() >= g.getNode(i-1).getCurrentPageRank());
        }

    }

    @Test
    public void testPageRankWithSink()
    {
        boolean[][] graphMatrice = {
                {false, true, true, false, false},
                {true, false, true, true, true},
                {false, false, false, false, false},
                {false, true, false, false, true},
                {true, true, false, true, false}
        };

        Graph<Integer> g = convertMatrixToGraph(graphMatrice);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));
    }

    @Test
    public void testPageRankWithNoEdges()
    {
        boolean[][] graphMatrice = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        Graph<Integer> g = convertMatrixToGraph(graphMatrice);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));
        assertEquals(2, iterations);
        assertEquals(0.2, g.getNode(0).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(1).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(2).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(3).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(4).getCurrentPageRank(), 0);
    }

    @Test
    public void testPageRankWithOnlyEdgesToThemselves()
    {
        boolean[][] graphMatrice = {
                {true, false, false, false, false},
                {false, true, false, false, false},
                {false, false, true, false, false},
                {false, false, false, true, false},
                {false, false, false, false, true}
        };

        Graph<Integer> g = convertMatrixToGraph(graphMatrice);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));
        assertEquals(2, iterations);
        assertEquals(0.2, g.getNode(0).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(1).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(2).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(3).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(4).getCurrentPageRank(), 0);
    }

    @Test
    public void testPageRankWithOneNodeLinksToOthers()
    {
        boolean[][] graphMatrice = {
                {false, true, true, true, true},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        Graph<Integer> g = convertMatrixToGraph(graphMatrice);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));
        assertTrue(g.getNode(0).getCurrentPageRank() < g.getNode(1).getCurrentPageRank());
        assertTrue(g.getNode(0).getCurrentPageRank() < g.getNode(2).getCurrentPageRank());
        assertTrue(g.getNode(0).getCurrentPageRank() < g.getNode(3).getCurrentPageRank());
        assertTrue(g.getNode(0).getCurrentPageRank() < g.getNode(4).getCurrentPageRank());
        assertEquals(g.getNode(1).getCurrentPageRank(), g.getNode(2).getCurrentPageRank(), 0);
        assertEquals(g.getNode(1).getCurrentPageRank(), g.getNode(3).getCurrentPageRank(), 0);
        assertEquals(g.getNode(1).getCurrentPageRank(), g.getNode(4).getCurrentPageRank(), 0);
        assertEquals(g.getNode(2).getCurrentPageRank(), g.getNode(3).getCurrentPageRank(), 0);
        assertEquals(g.getNode(2).getCurrentPageRank(), g.getNode(4).getCurrentPageRank(), 0);
        assertEquals(g.getNode(3).getCurrentPageRank(), g.getNode(4).getCurrentPageRank(), 0);
    }

    @Test
    public void testPageRankWithEdgesToEverything()
    {
        boolean[][] graphMatrice = {
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true}
        };

        Graph<Integer> g = convertMatrixToGraph(graphMatrice);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        assertTrue(pageRanker.validatePageRankResult(g));
        assertEquals(2, iterations);
        assertEquals(0.2, g.getNode(0).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(1).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(2).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(3).getCurrentPageRank(), 0);
        assertEquals(0.2, g.getNode(4).getCurrentPageRank(), 0);
    }
}
