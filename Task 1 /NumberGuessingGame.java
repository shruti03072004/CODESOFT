import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to play a single round of the game
    public static int playRound() {
        // Step 1: Generate a random number between 1 and 100
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        
        // Step 2: Allow the user to guess the number with a limit of 10 attempts
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int maxAttempts = 10;
        int guess = -1;
        
        while (attempts < maxAttempts) {
            // Prompt the user for their guess
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Guess the number between 1 and 100: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();  // Clear the invalid input
                System.out.print("Guess the number between 1 and 100: ");
            }
            guess = scanner.nextInt();
            attempts++;
            
            // Step 3: Compare the guess to the target number
            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts!");
                return attempts;  // Return the number of attempts it took
            }
        }
        System.out.println("Sorry, you've used all your attempts! The correct number was " + targetNumber + ".");
        return maxAttempts;  // Return the maximum attempts if the user fails
    }

    // Method to play the game with multiple rounds
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int totalScore = 0;
        boolean playAgain = true;
        
        // Step 6: Option for multiple rounds
        while (playAgain) {
            System.out.println("\nStarting a new round!");
            int attemptsTaken = playRound();
            totalRounds++;
            
            // Step 7: Score system
            int roundScore = Math.max(1, 10 - attemptsTaken);  // Give more points if guessed correctly in fewer attempts
            totalScore += roundScore;
            
            System.out.println("Your score for this round is: " + roundScore + " points");
            
            // Ask the user if they want to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String userInput = scanner.next().toLowerCase();
            if (!userInput.equals("yes")) {
                playAgain = false;
            }
        }

        // Display the final score
        System.out.println("\nGame Over! You played " + totalRounds + " rounds and scored " + totalScore + " points.");
    }

    public static void main(String[] args) {
        playGame();
    }
}
