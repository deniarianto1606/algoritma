import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Section5Quiz {
    public static void main(String[] args){
        System.out.println("frequency pattern");
        System.out.println(sameFrequency(182, 281));
        System.out.println(sameFrequency(34, 14));
        System.out.println(sameFrequency(3589578, 5879385));
        System.out.println(sameFrequency(22, 222));


        System.out.println(areThereDuplicatesWithFreq(new int[]{1,2,3}));
        System.out.println(areThereDuplicatesWithFreq(new int[]{1,2,2}));

        System.out.println("multiple pointer pattern");
        System.out.println(areThereDuplicatesWithPointer(new int[]{1,2,3}));
        System.out.println(areThereDuplicatesWithPointer(new int[]{1,2,2}));

        System.out.println(averagePair(new int[]{1,2,3}, 2.5));
        System.out.println(averagePair(new int[]{1,3,3,5,6,7,10,12,19}, 8.0));
        System.out.println(averagePair(new int[]{-1,0,3,4,5,6}, 4.1));
        System.out.println(averagePair(new int[]{}, 4.0));

        System.out.println(isSubsequence("hello","hello world"));
        System.out.println(isSubsequence("sing","sting"));
        System.out.println(isSubsequence("abc","abracadabra"));
        System.out.println(isSubsequence("abc","acb"));

        System.out.println("sliding window pattern integer");
        System.out.println(maxSubarraySum(new int[]{100,200,300,400},2));
        System.out.println(maxSubarraySum(new int[]{1,4,2,10,23,3,1,0,20},4));
        System.out.println(maxSubarraySum(new int[]{-3,4,0,-2,6,-1},2));
        System.out.println(maxSubarraySum(new int[]{3,-2,7,-4,1,-1,4,-2,1},2));
        System.out.println(maxSubarraySum(new int[]{2,3},3));

        System.out.println(minSubarrayLen(new int[]{2,3,1,2,4,3},7));
        System.out.println(minSubarrayLen(new int[]{2,1,6,5,4},9));
        System.out.println(minSubarrayLen(new int[]{3,1,7,11,2,9,8,21,62,33,19},52));
        System.out.println(minSubarrayLen(new int[]{1,4,16,22,5,7,8,9,10},39));
        System.out.println(minSubarrayLen(new int[]{1,4,16,22,5,7,8,9,10},55));
        System.out.println(minSubarrayLen(new int[]{4,3,3,8,1,2,3},11));
        System.out.println(minSubarrayLen(new int[]{1,4,16,22,5,7,8,9,10},95));

        System.out.println("sliding window string");
        System.out.println(findLongestSubstring("rithmschool"));
        System.out.println(findLongestSubstring("thisisawesome"));
        System.out.println(findLongestSubstring("thecatinthehat"));
        System.out.println(findLongestSubstring("bbbbbb"));
        System.out.println(findLongestSubstring("longestsubstring"));
        System.out.println(findLongestSubstring("thisishowwedoit"));
    }

    private static int findLongestSubstring(String word) {
        if(word.length() == 0) return 0;
        Set<String> set = new HashSet<String>();
        String[] a = word.split("");
        int right = 0;
        int left = 0;
        int longetst = 0;
        int tempLongest = 0;
        while(right < a.length){
            if(left == right){
                right++;
                tempLongest++;
                if(!set.contains(a[left])){
                    set.add(a[left]);
                }
            }else{
                if(!set.contains(a[right])){
                    set.add(a[right]);
                    tempLongest++;
                    right++;
                }else{
                    left++;
                    right = left;
                    set.clear();
                    tempLongest = 0;
                }
            }
            if(longetst < tempLongest){
                longetst = tempLongest;
            }
        }
        return longetst;
    }

    private static int minSubarrayLen(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int digit = Integer.MAX_VALUE;
        int total = 0;
        int tempDigit = 0;
        while(right < nums.length){
            if(nums[left] >= k){
                return 1;
            }
                if (left == right) {
                    total = nums[left];
                    right++;
                    tempDigit++;
                } else {
                    total = total + nums[right];
                    tempDigit++;
                    right++;
                }
                if (total >= k) {
                    left++;
                    right=left;
                    if (digit > tempDigit) {
                        digit = tempDigit;
                    }
                    tempDigit = 0;
                }
        }
        if(digit == Integer.MAX_VALUE){
            return 0;
        }
        return digit;
    }

    private static int maxSubarraySum(int[] arr, int k) {
        if(arr.length == 0){
            return 0;
        }
        //Arrays.sort(arr);
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


    private static boolean isSubsequence(String str1, String str2) {

        if(str1.length() > str2.length()){
            return false;
        }

        int index1 = 0;
        int index2 = 0;
        String[] s = str1.split("");
        String[] s2 = str2.split("");
        boolean result = false;
        while(s.length > index1 && s2.length > index2){
            if((s.length-1) == index1 || (s2.length-1) == index2){
                break;
            }

            if(s[index1].equals(s2[index2])){
                index1++;
                index2++;
                result = true;
            }else{
                index2++;
                result = false;
            }
        }
        return result;
    }

    private static boolean averagePair(int[] nums, double k) {
        if(nums.length == 0){
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        boolean result = false;
        for(int i = 0; i < nums.length; i++){
            if(left == right){
                break;
            }
            double numRes = (nums[left] + nums[right]) / 2.0;
            if(numRes == k){
                result = true;
                break;
            }
            if(numRes < k){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }

    public static boolean sameFrequency(int num1, int num2){
        String[] number1 = String.valueOf(num1).split("");
        String[] number2 = String.valueOf(num2).split("");
        if(number1.length != number2.length){
            return false;
        }
        HashMap<String, Integer> total = new HashMap<String , Integer>();
        for(String num : number1){
            if(total.get(num) == null){
                total.put(num, 1);
            }else{
                total.put(num, total.get(num) + 1);
            }
        }

        for(String num : number2){
            if(total.get(num) == null || total.get(num) == 0){
                return false;
            }

            if(total.get(num) != null){
                total.put(num, total.get(num) -1);
            }
        }
        return true;
    }

    public static boolean areThereDuplicatesWithFreq(int[] arr){
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(Integer num : arr){
            if(freq.get(num) == null){
                freq.put(num, 1);
            }else {
                return true;
            }
        }
        return false;
    }

    public static boolean areThereDuplicatesWithPointer(int[] arr){
        int min = 0;
        int max = 1;
        boolean result = false;
        for(int i = 0; i < arr.length; i++){
            if(max < arr.length && arr[min] == arr[max]){
                result = true;
            }else{
                min = max;
                max++;
            }

        }
        return result;
    }
}
