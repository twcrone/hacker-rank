import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapRansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> words = new HashMap<>();
        for(String word : magazine) {
            Integer count = words.get(word);
            if(count == null) {
                words.put(word, 1);
            }
            else {
                words.put(word, count + 1);
            }
        }

        String message = "Yes";

        for(String wordNeed : note) {
            Integer count = words.get(wordNeed);
            if(count == null || count == 0) {
                message = "No";
                break;
            }
            else {
                words.put(wordNeed, count - 1);
            }
        }

        System.out.println(message);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
