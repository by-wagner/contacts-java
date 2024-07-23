import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        int month = scanner.nextInt();

        YearMonth yearMonth = YearMonth.of(year, month);

        LocalDate firstDayOfMonth = yearMonth.atDay(1);

        LocalDate firstMonday = firstDayOfMonth.with(DayOfWeek.MONDAY);
        if (firstMonday.isBefore(firstDayOfMonth)) {
            firstMonday = firstMonday.plusWeeks(1);
        }

        LocalDate currentMonday = firstMonday;
        while (currentMonday.getMonthValue() == month) {
            System.out.println(currentMonday);
            currentMonday = currentMonday.plusWeeks(1);
        }
    }
}