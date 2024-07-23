import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();

        System.out.println(isValidIPAddress(ipAddress) ? "YES" : "NO");
    }

    public static boolean isValidIPAddress(String ipAddress) {
        if (ipAddress.endsWith(".")) {
            return false;
        }

        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (!isValidPart(part)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPart(String part) {
        if (part.isEmpty()) {
            return false;
        }
        try {
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }
            if (part.startsWith("0") && part.length() > 1) {
                return false; // To avoid cases like "01", "001", etc.
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}