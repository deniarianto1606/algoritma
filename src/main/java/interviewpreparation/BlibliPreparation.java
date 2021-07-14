package interviewpreparation;

public class BlibliPreparation {
    public static void main(String[] args){
        System.out.println(primeLoop(7));
        System.out.println(primeRecursive(7));

        System.out.println(reverse("Hello, World!"));
        System.out.println(anagramLoop("kodok"));
        System.out.println(anagramLoop(" "));
        System.out.println(anagramLoop("deni"));
        System.out.println(anagramImproved("kodok"));
        System.out.println(anagramImproved(" "));
        System.out.println(anagramImproved("deni"));
        System.out.println(fib(6));
        System.out.println(fibLoop(6));

        int[] arr = new int[]{1,5,8,10, 15, 40, 60, 88, 100};
        System.out.println(binarySearch(new int[]{1,5,8,10, 15, 40, 60, 88, 100}, 0, arr.length - 1, 88));
        System.out.println(binarySearchLoop(new int[]{1,5,8,10, 15, 40, 60, 88, 100}, 1));
    }

    static String primeLoop(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return "Not a prime number.";
            }
        }
        return "Prime number.";
    }

    static String primeRecursive(int num){
        return primeRecursive(num, 2);
    }

    static String primeRecursive(int num, int devider){
        if(devider > num){
            return "Prime number.";
        }
        if(num != devider && num % devider == 0){
            return "Not a prime number.";
        }
        return primeRecursive(num, ++devider);
    }

    private static boolean binarySearch(int[] nums, int first, int end, int target) {
        if(end >= first) {
            int mid = (first + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (target > nums[mid]) {
                return binarySearch(nums, mid+1, end, target);
            }
            return binarySearch(nums, first, mid-1, target);
        }
        return false;
    }

    private static boolean binarySearchLoop(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(right >= left){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    public static String reverse(String word){
        if(word.length() == 0){
            return word;
        }
        return word.substring(word.length()-1) + reverse( word.substring(0, word.length()-1));
    }

    public static boolean anagramLoop(String word){
        String reverse = "";

        for(int i = word.length() - 1; i >= 0; i--){
            reverse += word.charAt(i);
        }
        return word.equalsIgnoreCase(reverse);
    }

    public static boolean anagramImproved(String word){
        int mid = word.length() / 2;
        int lastIndex = word.length() - 1;
        for(int i = 0; i <= mid; i++){
            if(word.charAt(i) != word.charAt(lastIndex)){
                return false;
            }
            lastIndex--;
        }
        return true;
    }

    public static int fib(int num){
        if(num <= 2){
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }

    public static int fibLoop(int num){
        int current = 1;
        int prevNum = 0;
        for(int i = 1; i < num; i++){
            int temp = current;
            current = current + prevNum;
            prevNum = temp;
        }
        return current;
    }
}
