package sorting;

import java.util.Arrays;

public class Sorting {

  public static void main(String[] args){
    int[] unsorted = new int[]{354,52,53,5,435,3,454,35,43};
    int[] mergeSort = mergeSort(unsorted, 0, unsorted.length);
  }

  /**
   * Merge Sort
   * 1. Create merge array method
   * 2. Implement logic mergeSort
   */
  public static int[] mergeArray(int[] left, int[] right){
    int indexRight = 0;
    int indexLeft = 0;
    int[] result = new int[right.length  + left.length];
    int index = 0;
    while(index < result.length){
      if(indexRight >= right.length || indexLeft >= left.length){
        break;
      }
      if(left[indexLeft] < right[indexRight]){
        result[index] = left[indexLeft];
        indexLeft++;
      } else {
        result[index] = right[indexRight];
        indexRight++;
      }
      index++;
    }

    //insert remaining array
    for(int i = indexLeft; i < left.length; i++){
      result[index] = left[i];
      index++;
    }

    for(int i = indexRight; i < right.length; i++){
      result[index] = right[i];
      index++;
    }
    return result;
  }

  public static int[] mergeSort(int[] arr, int start, int end) {

    if(arr.length <= 1){
      return arr;
    }
    int mid = arr.length / 2;
    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), 0, mid);
    int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), mid, end);
    return mergeArray(left, right);
  }

  public static int[] mergeSortWithCopyArrayManualImpl(int[] arr, int start, int end) {

    if(arr.length <= 1){
      return arr;
    }
    int mid = arr.length / 2;
    int[] left = mergeSort(copyArray(arr, 0, mid), 0, mid);
    int[] right = mergeSort(copyArray(arr, mid, arr.length), mid, end);
    return mergeArray(left, right);
  }


  /**
   * Bubble Sort
   * Just compare between inner loop (j) with (j-1) starting from index 1 for all variable to avoid indexArrayOutOfBound
   * Placing large values into sorted position
   */
  public static int[] bubbleSort(int[] arr){
    boolean isSwap = false;
    for(int i = 1; i < arr.length; i++){
      for(int j = 1; j < arr.length; j++){
        if(arr[j-1] > arr[j]){
         swap(arr, j-1, j);
          isSwap = true;
        }
      }
      if(!isSwap){break;}
    }
    return arr;
  }

  /**
   * Selection Sort
   * search minimum value first in an array then swap to correct position
   */
  public static int[] selectionSort(int[] arr){
    for(int i = 0; i < arr.length; i++){
      int minIndex = i;
      for(int j = i + 1; j < arr.length; j++){
        if(arr[minIndex] > arr[j]){
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
    }
    return arr;
  }

  private static void swap(int[] arr, int from, int to){
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }

  private static int[] copyArray(int[] arr, int start, int end){
    int[] result = new int[end - start];
    int index = 0;
    for(int i = start; i < end; i++){
      result[index] = arr[i];
      index++;
    }
    return result;
  }

  private static void printArray(int[] nums){
    for (int a:nums) {
      System.out.print(a + ", ");
    }
  }
}
