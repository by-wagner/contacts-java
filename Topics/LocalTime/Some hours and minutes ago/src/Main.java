import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialTimeString = scanner.nextLine();
        LocalTime initialTime = LocalTime.parse(initialTimeString, DateTimeFormatter.ofPattern("HH:mm"));

        int hoursToSubtract = scanner.nextInt();
        int minutesToSubtract = scanner.nextInt();

        LocalTime newTime = initialTime.minusHours(hoursToSubtract).minusMinutes(minutesToSubtract);

        System.out.println(newTime.format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}