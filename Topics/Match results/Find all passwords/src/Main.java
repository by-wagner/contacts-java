import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(?i)password\\s*[:\\s]*([a-zA-Z0-9]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            if (!found) {
                found = true;
            }

            System.out.println(matcher.group(1));
        }

        if (!found) {
            System.out.println("No passwords found.");
        }
    }
}