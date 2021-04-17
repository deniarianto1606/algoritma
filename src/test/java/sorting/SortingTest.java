package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortingTest {

    @Test
    public void mergeSort_mergeArray(){
        int[] left = new int[]{4,7,9};
        int[] right = new int[]{2,5};
        int[] result = Sorting.mergeArray(left, right);
        printArray(result);
        Assertions.assertArrayEquals(new int[]{2,4,5,7,9}, result);
    }

    @Test
    public void mergeSort_doMergeSort(){
        int[] unsorted = new int[]{9,4,7,5,2};
        int[] result = Sorting.mergeSort(unsorted, 0, unsorted.length);
        printArray(result);
        Assertions.assertArrayEquals(new int[]{2,4,5,7,9}, result);
    }

    @Test
    public void mergeSort_doMergeSortCopyManual(){
        int[] unsorted = new int[]{9,4,7,5,2};
        int[] result = Sorting.mergeSortWithCopyArrayManualImpl(unsorted, 0, unsorted.length);
        printArray(result);
        Assertions.assertArrayEquals(new int[]{2,4,5,7,9}, result);
    }

    @Test
    public void mergeSort_bubbleSort(){
        int[] unsorted = new int[]{9,4,7,5,2};
        int[] result = Sorting.bubbleSort(unsorted);
        printArray(result);
        Assertions.assertArrayEquals(new int[]{2,4,5,7,9}, result);
    }

    @Test
    public void mergeSort_bubbleSortWithSortedArray(){
        int[] unsorted = new int[]{2,4,5,7,9};
        int[] result = Sorting.bubbleSort(unsorted);
        printArray(result);
        Assertions.assertArrayEquals(new int[]{2,4,5,7,9}, result);
    }

    @Test
    public void mergeSort_selectionSort(){
        int[] unsorted = new int[]{9,4,7,5,2};
        int[] result = Sorting.selectionSort(unsorted);
        printArray(result);
        Assertions.assertArrayEquals(new int[]{2,4,5,7,9}, result);
    }


    private static void printArray(int[] nums){
        for (int a:nums) {
            System.out.print(a + ", ");
        }
    }
}
