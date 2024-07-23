package contacts.util;

public class ValidationUtil {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*";
        if (!phoneNumber.matches(regex)) {
            return false;
        }

        String[] groups = phoneNumber.split("[\\s-]");
        for (int i = 0; i < groups.length; i++) {
            if (i == 0 && groups[i].isEmpty()) {
                return false;
            } else if (i > 0 && groups[i].length() < 2) {
                return false;
            }
        }
        return true;
    }
}