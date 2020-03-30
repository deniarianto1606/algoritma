import java.util.LinkedList;

public class Rubik {

  public static void main(String[] args) {
    printArray(3, rotate(3, 1));
  }

  private static int[][] rotate(int N, int R) {
    int k = 1;
    int[][] rubik = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        rubik[i][j] = k;
        k++;
      }
    }

    printArray(N, rubik);
    LinkedList<Integer> a = new LinkedList<Integer>();
    a.add(1);
    a.add(2);
    a.n
    return rubik;
  }

  private static void printArray(int N, int[][] rubik) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(" | " + rubik[i][j] + " | ");
      }
      System.out.println();
    }
  }
}
