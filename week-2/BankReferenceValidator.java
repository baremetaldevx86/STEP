import java.util.Scanner;

public class BankReferenceValidator {

    static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() >= 3) {
            reference = reference.substring(0, 3).toUpperCase()
                       + reference.substring(3);
        }

        return reference;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);
        String bankCode = reference.substring(0, 3);

        return "[" + bankCode + "] DATE: " + day + "/" + month + "/" + year
                + " | SEQ: " + sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String normalized = normalizeReference(scanner.nextLine());
        System.out.println(validateAndFormat(normalized));
    }
}
