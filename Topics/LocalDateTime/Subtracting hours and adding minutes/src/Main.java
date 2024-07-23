import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDateTime = scanner.nextLine();

        int hoursToSubtract = scanner.nextInt();
        int minutesToAdd = scanner.nextInt();

        LocalDateTime dateTime;
        DateTimeFormatter formatterWithSeconds = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter formatterWithoutSeconds = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        try {
            dateTime = LocalDateTime.parse(inputDateTime, formatterWithSeconds);
        } catch (Exception e) {
            dateTime = LocalDateTime.parse(inputDateTime, formatterWithoutSeconds);
        }

        dateTime = dateTime.minusHours(hoursToSubtract).plusMinutes(minutesToAdd);

        if (inputDateTime.length() == 16) {
            System.out.println(dateTime.format(formatterWithoutSeconds));
        } else {
            System.out.println(dateTime.format(formatterWithSeconds));
        }

        scanner.close();
    }
}