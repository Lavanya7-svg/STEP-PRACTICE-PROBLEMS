import java.util.*;

public class Q1
 {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();

        int wins = 0, losses = 0, draws = 0;

        for (int round = 1; round <= 5; round++) {
            System.out.print("Round " + round + " - Enter Rock/Paper/Scissors: ");
            String playerMove = sc.nextLine();
            String computerMove = moves[rand.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            System.out.println("Computer: " + computerMove + " → " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercent = (wins * 100.0) / 5;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercent);
    }
}

