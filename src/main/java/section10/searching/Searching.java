package section10.searching;

public class Searching {
    public static void main(String[] args) {
//        System.out.println(linearSearchInt(new int[]{3, 2, 3}, 3));
//        int[] sortedNums = new int[]{1,2,3,4,5,6,7,8,9,10,11,13,14,15};
//        System.out.println(binarySearchInt(sortedNums, 12));
//        System.out.println(binarySearchIntRecursive(sortedNums, 0, sortedNums.length, 12));

        System.out.println(matchedString("wowomgzomg","omg"));
    }

    private static boolean matchedString(String str1, String str2) {
        boolean match = false;
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(Character.toString(str1.charAt(i)).equals(Character.toString(str2.charAt(j)))){
                    match = true;
                    System.out.print(Character.toString(str2.charAt(j)));
                }
            }
            System.out.println();
        }
        return true;
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
