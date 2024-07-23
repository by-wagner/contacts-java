import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDateTime1 = scanner.nextLine();
        String inputDateTime2 = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.parse(inputDateTime1, formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(inputDateTime2, formatter);

        long hoursBetween = ChronoUnit.HOURS.between(dateTime1, dateTime2);

        System.out.println(Math.abs(hoursBetween));

        scanner.close();
    }
}