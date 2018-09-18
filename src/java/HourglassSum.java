import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HourglassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        Integer max = null;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(i - 1 > -1 && i + 1 < arr.length && j - 1 > -1 && j + 1 < arr.length) {
                    int topLeft = arr[i - 1][j - 1];
                    int topMid = arr[i - 1][j];
                    int topRight = arr[i - 1][j + 1];
                    int center = arr[i][j];
                    int btnLeft = arr[i + 1][j - 1];
                    int btnMid = arr[i + 1][j];
                    int btnRight = arr[i + 1][j + 1];
                    int tempSum = topLeft + topMid + topRight + center + btnLeft + btnMid + btnRight;
                    if(max == null || tempSum > max) {
                        max = tempSum;
                    }
                }
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
