package algorithms;

import data_structures.graph.Graph;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static utils.GraphGenerator.generateExampleGraph;
import static utils.GraphGenerator.generateRandomGraph;

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
    public void testPageRanker2()
    {
        Graph<Integer> g = generateRandomGraph(50000);
        PageRanker pageRanker = new PageRanker();
        int iterations = pageRanker.pageRank(g);
        System.out.println("Took " + iterations + " iterations");
        assertTrue(pageRanker.validatePageRankResult(g));

    }
}
