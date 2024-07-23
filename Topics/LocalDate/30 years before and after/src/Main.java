import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate inputDate = LocalDate.parse(scanner.next());

        LocalDate dateBefore = inputDate.minusYears(30);
        LocalDate dateAfter = inputDate.plusYears(30);

        System.out.println(dateBefore);
        System.out.println(dateAfter);
    }
}