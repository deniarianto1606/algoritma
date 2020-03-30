import java.util.HashMap;

public class BukalapakErik {

    public static void main(String[] args){
//        int bil = 18;
//        String fak = "";
//        for (int i=1; i<=bil; i++){
//            if (bil%i==0){
//                fak+=i+" ";
//            }
//        }
        System.out.print(solution(18, 1));
    }

    public static int solution(int N, int K){

        int round = 0;
        boolean allIn = true;
        while(N != 0){
            if(N > 8) {
                if (allIn) {
                    N = N - 8;
                    round++;
                    allIn = false;
                }
                else {
                    N = N - 1;
                    round++;
                    allIn = true;
                }
            }else{
                N = N - 1;
                round++;
            }
        }
        return round;
    }

}
