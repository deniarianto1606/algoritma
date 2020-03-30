package section10.searching;

public class Searching {
    public static void main(String[] args) {
//        System.out.println(linearSearchInt(new int[]{3, 2, 3}, 3));
//        int[] sortedNums = new int[]{1,2,3,4,5,6,7,8,9,10,11,13,14,15};
//        System.out.println(binarySearchInt(sortedNums, 12));
//        System.out.println(binarySearchIntRecursive(sortedNums, 0, sortedNums.length, 12));
//
//        System.out.println(matchedString("lorie loled","loled"));

        //mergedArray(new int[]{10,60,90,100}, new int[]{1,2,50});
        int[] result = mergedSortedRecursion(new int[]{10,50,2,90,100,60,1});
        printArray(result);
    }

    private static int[] mergedSortedRecursion(int[] nums) {
        int shortest = nums.length / 2;
        int longest = nums.length - shortest;
        int[] left = new int[shortest];
        int[] right = new int[longest];
        int indexShort = 0;
        int indexLong = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < shortest){
                left[indexShort] = nums[i];
                indexShort++;
            }else{
                right[indexLong] = nums[i];
                indexLong++;
            }
        }

        if(nums.length == 1){
            return nums;
        }
        if(left.length == 1 && right.length == 1){
            return mergedArray(left, right);
        }
        int[] num1Sorted = mergedSortedRecursion(left);
        int[] num2Sorted = mergedSortedRecursion(right);
        return mergedArray(num1Sorted, num2Sorted);
    }

    private static int[] mergedSortedRecursion(int[] nums, int[] nums2){
        return null;
    }

    private static int[] mergedArray(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int[] result = new int[nums1.length + nums2.length];
        int length = nums1.length + nums2.length;
        for(int i = 0; i < length; i++){
            //when both array is inbound
            if(left < nums1.length && right < nums2.length) {
                if (nums1[left] < nums2[right]) {
                    result[i] = nums1[left];
                    left++;
                } else {
                    result[i] = nums2[right];
                    right++;
                }
                continue;
            }

            // when one of the array reach its limit
            if(left == nums1.length){
                result[i] = nums2[right];
                right++;
            }else if(right == nums2.length){
                result[i] = nums1[left];
                left++;
            }
        }
        return result;
    }

    private static void printArray(int[] nums){
        for (int a:nums) {
            System.out.print(a + ", ");
        }
    }

    private static int matchedString(String str1, String str2) {
        int jLeft = 0;
        int result = 0;
        for(int i = 0; i < str1.length(); i++){
            for(int j = jLeft; j < str2.length(); j++){
                if(jLeft == (str2.length() - 1)){
                    jLeft=0;
                    result++;
                }
                if(Character.toString(str1.charAt(i)).equals(Character.toString(str2.charAt(j)))){
                    jLeft++;
                    break;
                }else{
                    jLeft = 0;
                    break;
                }
            }
        }
        return result;
    }

    private static int binarySearchInt(int[] nums, int searchValue) {
        int left = 0;
        int right = nums.length - 1;
        if(searchValue < nums[left]  || searchValue > nums[right]){
            return -1;
        }
        while(left != right){
            int mid = (left + right) / 2;
            if(nums[mid] == searchValue){
                return nums[mid];
            } else if(nums[mid] < searchValue){
                left = mid + 1;
            } else if (nums[mid] > searchValue){
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchIntRecursive(int[] nums, int left, int right, int searchValue){
        int mid = left + (right-1);
        if(searchValue < nums[left]  || searchValue > nums[right-1]){
            return -1;
        }
        if(nums[mid] == searchValue){
            return nums[mid];
        }else if(nums[mid] < searchValue){
            return binarySearchIntRecursive(nums, mid, right, searchValue);
        }else if(nums[mid] > searchValue){
            return binarySearchIntRecursive(nums, left, mid, searchValue);
        }
        return -1;
    }

    private static int linearSearchInt(int[] nums, int searchValue) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == searchValue) {
                return nums[i];
            }
        }
        return -1;
    }
}
