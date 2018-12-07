package algorithms.sorting;

import data_structures.CustomArrayList;
import data_structures.graph.Node;

public class SortMaster {

    private static void swap (CustomArrayList<Node> list, int a, int b)
    {
        Node temporary = list.get(a);

        list.put(a, list.get(b));
        list.put(b, temporary);
    }

    private static int partition(CustomArrayList<Node> list, int a, int b)
    {

        // Chooses the first element as pivot
        int k = a;

        // Goes through every node between a and b and counts the correct position for pivot
        for (int i = a + 1; i <= b; i++)
        {
            if ( list.get(i).getCurrentPageRank() < list.get(a).getCurrentPageRank() )
            {
                k++;
                swap(list, i, k);
            }
        }

        //Puts the pivot into the right slot
        swap(list, a, k);

        //Returns the current index of pivot in this partition
        return k;
    }


    public static void quicksort(CustomArrayList<Node> list, int a, int b)
    {
        if (a >= b) return;

        // If size of the subarray is less than 10, an insertion sort is executed
        if (b - a < 10)
        {
            insertionSort(list, a, b);
        } else
        {
            int pivot = partition(list, a, b);
            quicksort(list, a,pivot-1);
            quicksort(list, pivot+1, b);
        }

    }

    public static void insertionSort(CustomArrayList<Node> list, int a, int b)
    {
        for (int i = a; i <= b; i++)
        {
            //Stores the current node
            Node current = list.get(i);

            int j = i - 1;

            //Starts traversing the array backwards from current node to the beginning as long as the previous node has higher rank than the current one
            while ( j >= a
                    && list.get(j).getCurrentPageRank() > current.getCurrentPageRank()  )
            {
                // Moves every node one slot to the right
                list.put(j + 1, list.get(j));
                j--;
            }

            // Puts the current node into the right slot after moving every node that is larger one slot to the right
            list.put(j+1, current);
        }

    }

}
