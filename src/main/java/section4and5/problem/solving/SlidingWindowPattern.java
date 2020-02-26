package section4and5.problem.solving;

public class SlidingWindowPattern {

    public static void main(String[] args){
        System.out.println(maxSum(new int[]{2,6,9,2,1,8,5,6,3}, 3));
        System.out.println(maxSum(new int[]{1,2,5,2,8,1,5}, 2));
        System.out.println(maxSum(new int[]{4,2,1,6}, 1));
        System.out.println(maxSum(new int[]{4,2,1,6,2}, 4));
        System.out.println(maxSum(new int[]{}, 4));
    }

    public static int maxSum(int[] arr, int k){
        if(arr.length == 0){
            return 0;
        }
        int total = 0;
        int temp = 0;
        int lowest = 0;
        //tambahin digit sebelum terakhir
        for(int i = 0; i < k - 1; i++){
            temp = temp + arr[i];
        }
        //loop untuk nambahin sum index tarkhir
        for(int i = k - 1; i < arr.length; i++){
            temp = temp + arr[i];
            if(temp > total){
                total = temp;
            }
            //kurangin dengan index terakhir untuk sum selanjutnya
            temp = temp - arr[lowest];
            lowest++;
        }

        return total;
    }
}
