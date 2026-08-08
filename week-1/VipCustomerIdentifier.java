import java.util.Scanner;

public class VipCustomerIdentifier {
    public static String validateCustomerId(String customerId) {
        return customerId.startsWith("VIP-") ? "VIP Customer" : "Regular Customer";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String customerId = scanner.nextLine().trim();
        System.out.println(validateCustomerId(customerId));
    }
}
