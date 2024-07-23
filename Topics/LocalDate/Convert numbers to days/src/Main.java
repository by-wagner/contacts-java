import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        int[] daysOfYear = new int[3];

        for (int i = 0; i < 3; i++) {
            daysOfYear[i] = scanner.nextInt();
        }

        for (int dayOfYear : daysOfYear) {
            LocalDate date = LocalDate.ofYearDay(year, dayOfYear);
            System.out.println(date);
        }
    }
}