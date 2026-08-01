import java.util.Scanner;

public class ShortestLongestWord {
    // Returns {shortest word, longest word}; punctuation is treated as a separator.
    public static String[] findShortestAndLongestWord(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return new String[]{"", ""};
        }

        String[] words = trimmed.split("[^\\p{L}\\p{Nd}]+");
        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] answer = findShortestAndLongestWord(text);

        if (answer[0].isEmpty()) {
            System.out.println("No words found");
        } else {
            System.out.printf("Shortest: \"%s\" (%d) | Longest: \"%s\" (%d)%n",
                    answer[0], answer[0].length(), answer[1], answer[1].length());
        }
    }
}
