import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine().toLowerCase();
        String line = scanner.nextLine().toLowerCase();

        String[] words = line.split("\\W+");

        boolean found = false;

        for (String word : words) {
            if (word.contains(part) && !word.startsWith(part) && !word.endsWith(part)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}