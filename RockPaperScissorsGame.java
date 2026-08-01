import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random RANDOM = new Random();

    // Returns the result from the player's point of view.
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equals("Rock") && computerMove.equals("Scissors"))
                        || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                        || (playerMove.equals("Scissors") && computerMove.equals("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static String normalizeMove(String move) {
        if (move == null || move.isEmpty()) {
            return "";
        }
        return Character.toUpperCase(move.charAt(0)) + move.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 5;
        String[][] results = new String[rounds][4];
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Enter Rock, Paper, or Scissors for each round.");

        for (int round = 1; round <= rounds; round++) {
            String playerMove;
            do {
                System.out.print("Round " + round + " - Player: ");
                playerMove = normalizeMove(scanner.nextLine().trim());
            } while (!isValidMove(playerMove));

            String computerMove = MOVES[RANDOM.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            results[round - 1] = new String[]{String.valueOf(round), playerMove, computerMove, result};
            System.out.println(result);
        }

        System.out.println("\nFinal Summary");
        System.out.printf("%-6s %-15s %-16s %-16s%n", "Round", "Player Move", "Computer Move", "Result");
        for (String[] row : results) {
            System.out.printf("%-6s %-15s %-16s %-16s%n", row[0], row[1], row[2], row[3]);
        }

        double winPercentage = wins * 100.0 / rounds;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }

    private static boolean isValidMove(String move) {
        return move.equals("Rock") || move.equals("Paper") || move.equals("Scissors");
    }
}
