import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] parts = input.split(" ");
        String dateTimeString = parts[0];
        int daysToAdd = Integer.parseInt(parts[1]);
        int hoursToSubtract = Integer.parseInt(parts[2]);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        dateTime = dateTime.plusDays(daysToAdd).minusHours(hoursToSubtract);

        System.out.println(dateTime.format(formatter));

        scanner.close();
    }
}