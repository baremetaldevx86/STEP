import java.util.Scanner;

public class MaskedPhoneNumber {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        return "XXXXXX-" + phone.substring(6);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(maskPhoneNumber(scanner.nextLine()));
    }
}
