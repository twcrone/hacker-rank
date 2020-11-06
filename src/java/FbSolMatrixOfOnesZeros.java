public class FbSolMatrixOfOnesZeros {

  // dimension of matrix D x D
  private static final int D = 6;

  private static final int[][] M = {
      {1, 0, 0, 1, 0, 1},
      {0, 0, 0, 0, 1, 0},
      {0, 1, 0, 1, 0, 1},
      {1, 0, 1, 1, 0, 0},
      {1, 1, 1, 1, 1, 1},
      {0, 1, 0, 1, 0, 1}
  };

  // one dim array for storing sums of 'squares' from (0, 0) to (x2, y2)
  private static final int[] M2 = new int[D*D];

  // load sums with O(rc) sum method first time
  private static void loadM2() {
    for(int i = 0; i < D; i++) {
      for(int j = 0; j < D; j++) {
        M2[i + (j * D)] = sum(0, 0, i, j);
      }
    }
  }

  private static int sum(int x1, int y1, int x2, int y2) {
    int sum = 0;
    for(int i = x1; i <= x2; i++) {
      for(int j = y1; j <= y2; j++) {
        sum += M[i][j];
      }
    }
    return sum;
  }

  private static int sum2(int x1, int y1, int x2, int y2) {
    // sum of (0, 0) to (x2, y2) area
    int fullArea = M2[x2 + (y2 * D)];
    // sum of rect area excluded "above"
    int a1 = 0;
    // sum of rec area excluded to "left"
    int a2 = 0;
    // union of both excluded areas that was subtracted twice and must be added back once IF needed
    int union = 0;

    if(x1 > 0) {
      a1 = M2[x1 - 1 + (y2 * D)];
    }

    if(y1 > 0) {
      a2 = M2[x2 + (y1 - 1) * D];
    }

    if(x1 > 0 && y1 > 0) {
      union = M2[(x1 - 1) + (y1 - 1) * D];
    }

    return fullArea - a1 - a2 + union;
  }

  private static void printSums(int x1, int y1, int x2, int y2) {
    System.out.println(sum(x1, y1, x2, y2) + " = " + sum2(x1, y1, x2, y2));
  }

  public static void main(String[] args) {
    loadM2();
    for (int element: M2) {
      System.out.print(element + " ");
    }
    System.out.println();
    System.out.println("Compared solutions [brute-force]=[optimized]");
    System.out.println("--------------------------------------------");
    printSums(0, 0, 1, 3);
    printSums(0, 0, 3, 3);
    printSums(1, 1, 2, 2);
    printSums(2, 3, 4, 5);
    printSums(1, 4, 2, 4);
  }
}
