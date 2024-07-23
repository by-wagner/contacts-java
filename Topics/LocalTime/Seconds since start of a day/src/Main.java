import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        printTimeFromSeconds(seconds);
    }

    public static void printTimeFromSeconds(int seconds) {
        LocalTime time = LocalTime.ofSecondOfDay(seconds);

        if (time.getSecond() == 0) {
            DateTimeFormatter formatterWithoutSeconds = DateTimeFormatter.ofPattern("HH:mm");
            System.out.println(time.format(formatterWithoutSeconds));
        } else {
            DateTimeFormatter formatterWithSeconds = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println(time.format(formatterWithSeconds));
        }
    }
}