package interviewpreparation;

import java.util.*;

public class TravelokaPreparation {
    public static void main(String[] args){
        int total = 8, k = 2;
        TravelokaPreparation t = new TravelokaPreparation();
        System.out.println(t.ways(total, k));
        System.out.println(t.result);
        t.jungleBook();

//        int temp = 0;
//        if(temp == 0 && --temp == -1){
//            System.out.println("hehe");
//        }
//        System.out.println(temp);
//        System.out.println(parseInt("325"));
//        System.out.println(countingValley());

    }

    public static int countingValley(){
        String path = "DDUUDDDUDUUDUDDDUUDDUDDDUDDDUDUUDDUUDDDUDDDUDDDUUUDUDDDUDUDUDUUDDUDUDUDUDUUUUDDUDDUUDUUDUUDUUUUUUUUU";
        int result = 0;
        int seaLevel = 1;
        int temp = seaLevel;
        boolean isInValley = false;
        for(int i = 0; i < path.length(); i++){
            char step = path.charAt(i);
            if(step == 'D'){
                temp--;
            }else{
                if(temp < seaLevel){
                    if(++temp == seaLevel){
                        result++;
                    }
                }else{
                    temp++;
                }
            }
        }
        return result;
    }

    public static int parseInt(String num){
        int result = 0;
        for(int i = 0; i < num.length(); i++){
            if(!((int) num.charAt(i) >= 48 && (int) num.charAt(i) <= 57)){
                throw new NumberFormatException();
            }
            result = result*10 + ((int) num.charAt(i) - 48);
        }
        return result;
    }

    public static void evaluateArithmatic(){
        String operational = "2 4 + 4 6 + *";
        List<Integer> calculateResult = new ArrayList<>();
        String operation = "+-/*";
        for(int i = 0; i < operational.length(); i++){
            if(Character.toString(operational.charAt(i)).equalsIgnoreCase(" ")){
                continue;
            }

            if(operation.contains(Character.toString(operational.charAt(i)))){
                int temp = calculateResult.get(0);
                for(int j = 1; j < calculateResult.size(); j++){
                    if(Character.toString(operational.charAt(i)).equalsIgnoreCase("*")){
                        temp = temp * calculateResult.get(j);
                    }
                    if(Character.toString(operational.charAt(i)).equalsIgnoreCase("+")){
                        temp = temp + calculateResult.get(j);
                    }
                    calculateResult.remove(j);
                }
                calculateResult.remove(0);
                calculateResult.add(temp);
            }else{
                calculateResult.add(Integer.valueOf(Character.toString(operational.charAt(i))));
            }
        }

        System.out.println(calculateResult);
    }

    private int waysSum = 0;
    private List<List<Integer>> posibleSolution = new ArrayList<>();
    public int ways(int total, int k){
        //generate possibility
        List<Integer> numPos = new ArrayList<>();
        for(int i = 1; i <= k; i++){
            numPos.add(i);
        }

        calculateWays(total, numPos);
        return waysSum;
    }

    private Map<String, String> result = new HashMap<>();
    private List<Integer> combination = new ArrayList<>();

    public List<Integer> calculateWays(int total, List<Integer> numPos){
        if(total == 0) {
            waysSum++;
            List<Integer> a = new ArrayList<>(combination);
            Collections.sort(a);
            posibleSolution.add(a);
            result.putIfAbsent(a.toString(), a.toString());
            return combination;
        }
        if(total < 0){
            return combination;
        }
        for(Integer i : numPos){
            combination.add(i);
            int result = total - i;
            calculateWays(result, numPos);
            combination.remove(i);
        }

        return combination;
    }

    public void jungleBook(){
        int[] array = {-1, 8, 6, 0, 7, 3, 8, 9, -1, 6, 1};
        //int[] array = {-1, 0, 1};
        int level = 0;
        for(int i = 0; i < array.length; i++){
            int currentIndex = i;
            int tempLevel = 0;
            while(array[currentIndex] >= 0){
                if(array[currentIndex] == -1){
                    break;
                }
                currentIndex = array[currentIndex];
                tempLevel++;
            }
            if(tempLevel > level){
                level = tempLevel;
            }
        }

        System.out.println(++level);
    }
}
