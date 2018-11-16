package algorithms;

import data_structures.graph.Graph;
import org.junit.Test;

import static algorithms.TestUtils.generateIntegerGraph;

public class PageRankerTest {



    @Test
    public void testPageRanker()
    {
        Graph<Integer> g = generateIntegerGraph(30);


        System.out.println(g.nodeCount());
        PageRanker pageRanker = new PageRanker();

        pageRanker.pageRank(g);



    }
}
