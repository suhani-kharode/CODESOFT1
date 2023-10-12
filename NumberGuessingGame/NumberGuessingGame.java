import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.playGame();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber;
        int userGuess;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            randomNumber = random.nextInt(100) + 1;
            attempts = 0;

            while (true) {
                System.out.print("Enter your guess between 1 and 100: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }

                if (attempts >= 7) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was " + randomNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Your final score is " + score + ".");
    }
}