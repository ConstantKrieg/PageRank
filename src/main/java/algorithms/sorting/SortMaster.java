package algorithms.sorting;

import data_structures.CustomArrayList;
import data_structures.graph.Node;

public class SortMaster {

    /**
     * Swaps the places of two items in the array
     * @param list that contains the two items that are to be swapped
     * @param a First item in the swap
     * @param b Second item in the swap
     */
    private static void swap (CustomArrayList<Node> list, int a, int b)
    {
        Node temporary = list.get(a);

        list.put(a, list.get(b));
        list.put(b, temporary);
    }

    /**
     * Rearranges a list by choosing a pivot and then moves every item larger than the pivot to the right side of it
     * and every item smaller than the pivot to the left side of it
     * @param list The list that is to be partitioned
     * @param a Starting index of the sublist that is going to be partitioned
     * @param b End index of the sublist that is going to be partitioned
     */
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

    /**
     * Sorts the list either by using sort or insertion sort
     * @param list The list that is to be sorted
     * @param a Starting index of the sublist that is going to be sorted
     * @param b End index of the sublist that is going to be sorted
     */
    public static void sort(CustomArrayList<Node> list, int a, int b)
    {
        if (a >= b) return;

        // If size of the subarray is less than 10, an insertion sort is executed
        if (b - a < 10)
        {
            insertionSort(list, a, b);
        } else
        {
            int pivot = partition(list, a, b);
            sort(list, a,pivot-1);
            sort(list, pivot+1, b);
        }

    }

    /**
     * Performs an insertion sort
     * @param list The list that is to be sorted
     * @param a Starting index of the sublist that is going to be sorted
     * @param b End index of the sublist that is going to be sorted
     */
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
