package section.sorting;

public class Sorting {

  public static void main(String[] args){
    int[] unsorted = new int[]{354,52,53,5,435,3,454,35,43};
    int[] unsortedAlmostSorted = new int[]{8,1,2,3,4,5,6,7,8,9};
    //bubbleSort(unsortedAlmostSorted);

    selectionSort(unsorted);
  }

  private static void selectionSort(int[] unsorted) {

    printArray(unsorted);
    System.out.println();
    int index = 0;
    boolean noSwap;
    for(int i = 0; i < unsorted.length; i++){
      int temp = unsorted[i];
      for(int j = i; j < unsorted.length; j++){
        if(temp > unsorted[j]){
            temp = unsorted[j];
            index = j;
          }

      }

      unsorted[index] = unsorted[i];
      unsorted[i] = temp;
      printArray(unsorted);
      System.out.println();
    }
  }

  private static void bubbleSort(int[] unsorted) {
    boolean noSwap;
    for(int i = 0; i < unsorted.length; i++){
      noSwap = true;
      for(int j = 0; j < unsorted.length - 1; j++){
        if(unsorted[j] > unsorted[j+1]){
          int temp = unsorted[j];
          unsorted[j] = unsorted[j+1];
          unsorted[j+1] = temp;
          noSwap = false;
        }
        printArray(unsorted);
        System.out.println();
      }
      if(noSwap){break;}
    }
  }

  private static void printArray(int[] nums){
    for (int a:nums) {
      System.out.print(a + ", ");
    }
  }
}
