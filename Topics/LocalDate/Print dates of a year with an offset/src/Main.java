import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate startDate = LocalDate.parse(scanner.next());
        int offset = scanner.nextInt();

        LocalDate currentDate = startDate;

        while (currentDate.getYear() == startDate.getYear()) {
            System.out.println(currentDate);
            currentDate = currentDate.plusDays(offset);
        }
    }
}