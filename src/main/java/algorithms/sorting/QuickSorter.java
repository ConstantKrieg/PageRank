package algorithms.sorting;

import data_structures.CustomArrayList;
import data_structures.graph.Node;

public class QuickSorter {

    private static void swap (CustomArrayList<Node> list, int a, int b)
    {
        Node temporary = list.get(a);

        list.put(a, list.get(b));
        list.put(b, temporary);
    }

    private static int partition(CustomArrayList<Node> list, int a, int b)
    {
        int k = a;

        for (int i = a + 1; i <= b; i++)
        {

            if ( list.get(i).getCurrentPageRank() < list.get(a).getCurrentPageRank() )
            {
                k++;
                swap(list, i, k);
            }
        }
        swap(list, a, k);
        return k;
    }


    public static void quicksort(CustomArrayList<Node> list, int a, int b)
    {
        if (a >= b) return;

        int pivot = partition(list, a, b);
        quicksort(list, a,pivot-1);
        quicksort(list, pivot+1, b);
    }

}
