import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine();

        String regNumRegex = "^[ABEKMHOPCTYX]\\d{3}[ABEKMHOPCTYX]{2}$";

        boolean isValidRegNum = regNum.matches(regNumRegex);

        System.out.println(isValidRegNum);
    }
}