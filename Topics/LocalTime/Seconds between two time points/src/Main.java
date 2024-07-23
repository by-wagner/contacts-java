import java.time.LocalTime;
import java.util.Scanner;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String time1String = scanner.nextLine();
        String time2String = scanner.nextLine();

        LocalTime time1 = LocalTime.parse(time1String);
        LocalTime time2 = LocalTime.parse(time2String);

        System.out.println(secondsBetween(time1, time2));
    }

    public static long secondsBetween(LocalTime time1, LocalTime time2) {
        Duration duration = Duration.between(time1, time2);
        return Math.abs(duration.getSeconds());
    }
}