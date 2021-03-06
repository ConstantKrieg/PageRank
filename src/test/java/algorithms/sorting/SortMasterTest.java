package algorithms.sorting;

import data_structures.CustomArrayList;
import data_structures.graph.Node;
import org.junit.Test;


import java.util.Random;

import static algorithms.sorting.SortMaster.insertionSort;
import static algorithms.sorting.SortMaster.sort;
import static org.junit.Assert.assertTrue;

public class SortMasterTest {


    @Test
    public void testQuickSort()
    {
        CustomArrayList<Node> list = generateNodeList( 200 );
        sort(list, 0, list.size() - 1);

        for (int i = 1; i < 200; i++) {
            assertTrue( list.get( i-1 ).getCurrentPageRank() <= list.get(i).getCurrentPageRank() );
        }
    }


    @Test
    public void testInsertionSort()
    {
        CustomArrayList<Node> list = generateNodeList( 20 );
        insertionSort(list, 0, list.size() - 1);

        for (int i = 1; i < 20; i++) {
            assertTrue( list.get( i-1 ).getCurrentPageRank() <= list.get(i).getCurrentPageRank() );
        }
    }

    private CustomArrayList<Node> generateNodeList(int size)
    {
        Random random = new Random();
        double randomPR;
        Node<Integer> newNode;

        CustomArrayList<Node> list = new CustomArrayList<>();

        for (int i = 1; i <= size; i++) {
            newNode = new Node<>(i);
            randomPR = random.nextDouble() % 1;

            newNode.setCurrentPageRank(randomPR);

            list.add(newNode);
        }

        return list;
    }
}
