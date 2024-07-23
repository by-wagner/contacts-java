import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LocalDateTime dateTime = LocalDateTime.parse(input);
        LocalDateTime startOfYear = LocalDateTime.of(dateTime.getYear(), 1, 1, 0, 0, 0);

        long hoursPassed = ChronoUnit.HOURS.between(startOfYear, dateTime);

        System.out.println(hoursPassed);

        scanner.close();
    }
}