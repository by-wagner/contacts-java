import java.util.*;

class BankCard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String numbers = scn.nextLine();
        String card = numbers.replaceAll("\\s", "");
        String visaRegex = "^4\\d{12}(\\d{3})?$";
        String masterCardRegex = "^5[1-5]\\d{14}|^2(?:22[1-9]|2[3-9]\\d|[3-6]\\d{2}|7[01]\\d|720)\\d{12}$";
        String americanExpressRegex = "^3[47]\\d{13}$";

        if (card.matches(visaRegex)) {
            System.out.println("Visa");
        } else if (card.matches(masterCardRegex)) {
            System.out.println("MasterCard");
        } else if (card.matches(americanExpressRegex)) {
            System.out.println("AmericanExpress");
        } else {
            System.out.println("Card number does not exist");
        }
    }
}