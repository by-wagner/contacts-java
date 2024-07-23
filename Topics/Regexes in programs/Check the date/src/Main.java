import java.util.Scanner;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();

        String yearPart = "(?:19|20)\\d{2}";
        String monthPart = "(0[1-9]|1[0-2])";
        String dayPart = "(0[1-9]|[12]\\d|3[01])";
        String separatorPart = "[-/.]";

        String yyyyMMdd = yearPart + separatorPart + monthPart + separatorPart + dayPart;
        String ddMMyyyy = dayPart + separatorPart + monthPart + separatorPart + yearPart;

        String dateRegex = "^(?:" + yyyyMMdd + "|" + ddMMyyyy + ")$";

        boolean isValidDate = date.matches(dateRegex);

        System.out.println(isValidDate ? "Yes" : "No");
    }
}