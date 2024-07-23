import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputTime = scanner.nextLine();

        LocalTime time;
        if (inputTime.length() == 8) {
            time = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
        } else {
            time = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm"));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(time.format(formatter));
    }
}