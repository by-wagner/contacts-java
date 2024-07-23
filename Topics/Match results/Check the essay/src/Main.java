import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FindTheKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(?i)the\\s+key\\s+is\\s+([\\w&&[^aeiouAEIOU]]+|[?!#aeiouAEIOU]+)(?=\\s|$)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        while (matcher.find()) {
            System.out.println(matcher.group(1));
            found = true;
        }

        if (!found) {
            System.out.println("No keys found.");
        }
    }
}