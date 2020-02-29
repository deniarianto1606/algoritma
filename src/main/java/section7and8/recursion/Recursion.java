package section7and8.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    public static void main(String[] args){
        printNum(5);
        System.out.println(sumRange(5));

        Recursion rec = new Recursion();
        rec.collectOddValue(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)));
        System.out.println(rec.resultOddValue);

        System.out.println(rec.collectOddValuePureRecursion(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9))));

        System.out.println(power(2,0));
        System.out.println(factorial(7));

        System.out.println(rec.productOfArray(new int[]{1,2,3,4}));
        System.out.println(rec.productOfArray(new int[]{1,2,3,10}));

        System.out.println(recursiveRange(6));
        System.out.println(recursiveRange(10));


        System.out.println(fibonacci(4));
    }

    private static int fibonacci(int i) {
        int result = 0;
        if(i == 0 || i == 1){
            return 1;
        }
        return result + fibonacci(i + 1);
    }

    private static int recursiveRange(int i) {
        if(1 == i){
            return 1;
        }
        return i + (recursiveRange(--i));
    }

    private int productOfArray(int[] nums) {
        return product(nums, 0);
    }

    private int product(int[] nums, int index){
        if(index == (nums.length -1)){
            return nums[index];
        }
        return nums[index] * product(nums, ++index);
    }
    private static int factorial(int num) {
        if(num == 1){
            return 1;
        }
        return num * factorial(num - 1);
    }

    private static int power(int num, int power) {
        if(power == 0){
            return 1;
        }
        return num * power(num, power - 1);
    }

    List<Integer> resultOddValue = new ArrayList<Integer>();

    private List<Integer> collectOddValuePureRecursion(ArrayList<Integer> integers){
        List<Integer> result = new ArrayList<Integer>();
        if(integers.isEmpty()){
            return result;
        }
        if(integers.get(0) % 2 != 0){
            result.add(integers.get(0));
        }
        integers.remove(0);
        result.addAll(collectOddValuePureRecursion(integers));
        return result;
    }

    private void collectOddValue(ArrayList<Integer> integers) {
        if(integers.isEmpty()){
            System.out.println("finish");
            return;
        }
        if(integers.get(0) % 2 != 0){
            resultOddValue.add(integers.get(0));
        }
        integers.remove(0);
        collectOddValue(integers);
    }

    private static void printNum(int i) {
        if(i <= 0){
            System.out.println("All done!");
            return;
        }
        System.out.println(i);
        i--;
        printNum(i);
    }

    private static int sumRange(int i) {
        if(i == 1){
            return 1;
        }

        return i  + sumRange(i - 1);
    }
}
