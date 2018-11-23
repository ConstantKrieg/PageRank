package algorithms;

import data_structures.graph.Graph;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
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
}
