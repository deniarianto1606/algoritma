package section4and5.problem.solving;

import java.util.HashMap;

public class MultiplePointerPattern {

    public static void main(String[] args){
//        System.out.println(sumZero(new int[]{-3,-2,-1,0,1,2,3}));
//
//        System.out.println(sumZero(new int[]{-4,-3,-2,-1,0,1,2,3,4,5,6,7}));
//
//        System.out.println(sumZero(new int[]{-2,0,1,3}));
//
//        System.out.println(sumZero(new int[]{1,2,3}));

        System.out.println(countUniqueValues(new int[]{1,1,1,2,3,3,4,4,5,6}));
        System.out.println(countUniqueValues(new int[]{1,1,1,1,1,2}));
        System.out.println(countUniqueValues(new int[]{1,2,3,4,4,4,7,7,12,12,13}));
        System.out.println(countUniqueValues(new int[]{1}));
        System.out.println(countUniqueValues(new int[]{}));
    }

    public static boolean sumZero(int[] arr1){
        int min = 0;
        int max = arr1.length - 1;
        for(int i = 0; i < arr1.length; i++){
            if(min == max){
                return false;
            }
            if(arr1[max] + arr1[min] == 0){
                return true;
            } else if (arr1[max] + arr1[min] < 0){
                min++;
            } else {
                max--;
            }
        }
        return false;
    }

    public static int countUniqueValues(int[] arr1){
        int unique = 0;
        if(arr1.length == 0){
            return unique;
        }
        unique++;
        int min = 0;
        int max = 1;
        while(max != arr1.length){
            if(arr1[min] != arr1[max]){
                min = max;
                max++;
                unique++;
            }
            //max reach max array size
            if(max == arr1.length){
                return unique;
            }
            if(arr1[min] == arr1[max]){
                max++;
            }
        }
        return unique;
    }
}
