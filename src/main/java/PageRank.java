import algorithms.PageRanker;
import data_structures.graph.Graph;

import static utils.GraphGenerator.generateExampleGraph;

public class PageRank {


    public static void main (String[] args)
    {
        PageRanker ranker = new PageRanker();
        Graph<Character> exampleGraph = generateExampleGraph();

        ranker.pageRank(exampleGraph);
        boolean success = ranker.validatePageRankResult(exampleGraph);

        if (success) System.out.println("PageRank completed succesfully");
        else System.out.println("PageRank failed");
    }
}
