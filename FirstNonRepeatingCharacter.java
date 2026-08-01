import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    // Returns '\0' when every character repeats.
    public static char findFirstNonRepeatingChar(String text) {
        // One array position stores the frequency of one possible char value.
        int[] frequency = new int[Character.MAX_VALUE + 1];

        for (char character : text.toCharArray()) {
            frequency[character]++;
        }

        for (char character : text.toCharArray()) {
            if (frequency[character] == 1) {
                return character;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char answer = findFirstNonRepeatingChar(text);

        if (answer == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + answer + "'");
        }
    }
}
