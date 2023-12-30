import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Rock, Paper, Scissors Game!");

        int roundsToPlay = 3;
        int userScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= roundsToPlay; round++) {
            System.out.println("\nRound " + round + ": Choose your move - Rock, Paper, or Scissors");
            String userMove = scanner.nextLine().toLowerCase();

            String computerMove = generateComputerMove(random);

            System.out.println("Computer chose: " + computerMove);

            String result = determineWinner(userMove, computerMove);
            System.out.println(result);

            if (result.equals("You win!")) {
                userScore++;
            } else if (result.equals("Computer wins!")) {
                computerScore++;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your score: " + userScore);
        System.out.println("Computer's score: " + computerScore);

        if (userScore > computerScore) {
            System.out.println("Congratulations! You are the winner!");
        } else if (computerScore > userScore) {
            System.out.println("Computer wins! Better luck next time.");
        } else {
            System.out.println("It's a tie! No winner this time.");
        }

        scanner.close();
    }

    private static String generateComputerMove(Random random) {
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "";
        }
    }

    private static String determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "It's a tie!";
        } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
                   (userMove.equals("paper") && computerMove.equals("rock")) ||
                   (userMove.equals("scissors") && computerMove.equals("paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
