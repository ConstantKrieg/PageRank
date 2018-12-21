package algorithms;

import data_structures.CustomArrayList;
import data_structures.graph.Graph;
import org.junit.Ignore;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

import static utils.GraphGenerator.generateGraphWithSpecificAmountOfNodesAndEdges;

public class PageRankPerformanceTest {

    private PageRanker pageRanker = new PageRanker();

    @Ignore
    @Test
    public void testPerformance()
    {

        CustomArrayList<Long> times5000x50000 = new CustomArrayList<>();
        int iterations = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("Current round: " + (i + 1));
            Graph<Integer> g5000x50000 = generateGraphWithSpecificAmountOfNodesAndEdges(5000, 50000);
            Instant start = Instant.now();
            iterations += pageRanker.pageRank(g5000x50000);
            Instant end = Instant.now();
            Duration executionTime = Duration.between(start, end);
            times5000x50000.add(executionTime.abs().toMillis());
        }

        CustomArrayList<Long> times10000x100000 = new CustomArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("Current round: " + (i + 1));
            Graph<Integer> g10000x100000 = generateGraphWithSpecificAmountOfNodesAndEdges(10000, 100000);
            Instant start = Instant.now();
            iterations += pageRanker.pageRank(g10000x100000);
            Instant end = Instant.now();
            Duration executionTime = Duration.between(start, end);
            times10000x100000.add(executionTime.abs().toMillis());
        }

        CustomArrayList<Long> times25000x250000 = new CustomArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("Current round: " + (i + 1));
            Graph<Integer> g25000x250000 = generateGraphWithSpecificAmountOfNodesAndEdges(25000, 250000);
            Instant start = Instant.now();
            iterations += pageRanker.pageRank(g25000x250000);
            Instant end = Instant.now();
            Duration executionTime = Duration.between(start, end);
            times25000x250000.add(executionTime.abs().toMillis());
        }

        CustomArrayList<Long> times50000x500000 = new CustomArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("Current round: " + (i + 1));
            Graph<Integer> g50000x500000 = generateGraphWithSpecificAmountOfNodesAndEdges(50000, 500000);
            Instant start = Instant.now();
            iterations += pageRanker.pageRank(g50000x500000);
            Instant end = Instant.now();
            Duration executionTime = Duration.between(start, end);
            times50000x500000.add(executionTime.abs().toMillis());
        }

        CustomArrayList<Long> times100000x1000000 = new CustomArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("Current round: " + (i + 1));
            Graph<Integer> g100000x1000000 = generateGraphWithSpecificAmountOfNodesAndEdges(100000, 1000000);
            Instant start = Instant.now();
            iterations += pageRanker.pageRank(g100000x1000000);
            Instant end = Instant.now();
            Duration executionTime = Duration.between(start, end);
            times100000x1000000.add(executionTime.abs().toMillis());
        }

        CustomArrayList<Long> times250000x2500000 = new CustomArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("Current round: " + (i + 1));
            Graph<Integer> g250000x2500000 = generateGraphWithSpecificAmountOfNodesAndEdges(250000, 2500000);
            Instant start = Instant.now();
            iterations += pageRanker.pageRank(g250000x2500000);
            Instant end = Instant.now();
            Duration executionTime = Duration.between(start, end);
            times250000x2500000.add(executionTime.abs().toMillis());
        }

        CustomArrayList<Long> times500000x5000000 = new CustomArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("Current round: " + (i + 1));
            Graph<Integer> g500000x5000000 = generateGraphWithSpecificAmountOfNodesAndEdges(500000, 5000000);
            Instant start = Instant.now();
            iterations += pageRanker.pageRank(g500000x5000000);
            Instant end = Instant.now();
            Duration executionTime = Duration.between(start, end);
            times500000x5000000.add(executionTime.abs().toMillis());
        }

        long combined5000x50000Time = 0;
        long combined10000x100000Time = 0;
        long combined25000x250000Time = 0;
        long combined50000x500000Time = 0;
        long combined100000x1000000Time = 0;
        long combined250000x2500000Time = 0;
        long combined500000x5000000Time = 0;



        for (int i = 0; i < 100; i++) {
            combined5000x50000Time += times5000x50000.get(i);
            combined10000x100000Time += times10000x100000.get(i);
            combined25000x250000Time += times25000x250000.get(i);
            combined50000x500000Time += times50000x500000.get(i);
            combined100000x1000000Time += times100000x1000000.get(i);
            combined250000x2500000Time += times250000x2500000.get(i);
            combined500000x5000000Time += times500000x5000000.get(i);
        }

        System.out.println("Average iterations: " + (iterations / 700));
        System.out.println("Average time with 5000 nodes and 50000 edges was: " + (combined5000x50000Time / 100));
        System.out.println("Average time with 10000 nodes and 100000 edges was: " + (combined10000x100000Time / 100));
        System.out.println("Average time with 25000 nodes and 250000 edges was: " + (combined25000x250000Time / 100));
        System.out.println("Average time with 50000 nodes and 500000 edges was: " + (combined50000x500000Time / 100));
        System.out.println("Average time with 100000 nodes and 1000000 edges was: " + (combined100000x1000000Time / 100));
        System.out.println("Average time with 250000 nodes and 2500000 edges was: " + (combined250000x2500000Time / 100));
        System.out.println("Average time with 500000 nodes and 5000000 edges was: " + (combined500000x5000000Time / 100));


    }
}
