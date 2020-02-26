package section4and5.problem.solving;

import java.util.HashMap;

public class FrequencyPattern {

    public static void main(String[] args){
        FrequencyPattern frequencyPattern = new FrequencyPattern();
        System.out.println(frequencyPattern.same(new int[]{1,2,3,2,5}, new int[]{9,1,4,4,11}));
        System.out.println(frequencyPattern.validAnagram("aaz", "zza"));
        System.out.println(frequencyPattern.validAnagram("anagram", "nagaram"));
        System.out.println(frequencyPattern.validAnagram("rat", "car"));
        System.out.println(frequencyPattern.validAnagram("awesome", "awesom"));
        System.out.println(frequencyPattern.validAnagram("qwerty", "qeywrt"));
    }

    private boolean same(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }

        HashMap<Integer, Integer> key = new HashMap<Integer, Integer>();
        for(Integer ar1 : arr1){
            if(key.get(ar1 * ar1) == null){
                key.put(ar1 * ar1, 1);
            }else{
                key.put(ar1 * ar1, key.get(ar1 * ar1) + 1);
            }
        }

        for(Integer integer : arr2){
            if(key.get(integer) == null || key.get(integer) == 0){
                return false;
            }
            key.put(integer, key.get(integer) - 1);
        }
        return true;
    }

    public boolean validAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        HashMap<String, Integer> key = new HashMap<String, Integer>();
        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");
        for(String ar1 : arr1){
            if(key.get(ar1) == null){
                key.put(ar1, 1);
            }else{
                key.put(ar1, key.get(ar1) + 1);
            }
        }
        for(String ar2 : arr2){
            if(key.get(ar2) == null || key.get(ar2) == 0){
                return false;
            }
            key.put(ar2, key.get(ar2) - 1);
        }
        return true;
    }
}
