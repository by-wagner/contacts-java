import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        String regex = "\\b\\d{10,}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringWithNumbers);

        boolean found = false;
        while (matcher.find()) {
            if (!found) {
                found = true;
            }

            String bigNumber = matcher.group();
            int length = bigNumber.length();
            System.out.println(bigNumber + ":" + length);
        }

        if (!found) {
            System.out.println("No big numbers found.");
        }
    }
}