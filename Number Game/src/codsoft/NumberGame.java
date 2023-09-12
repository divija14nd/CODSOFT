/**
 * Task 1: Number Game
 */
package codsoft;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

      
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalAttempts = 0; // Initialize total attempts counter
        int totalRounds = 0; // Initialize total rounds counter
	        

        while (playAgain) {
        	
            int attempts = play(); // Call the play method to start a new round and get the number of attempts
            totalAttempts += attempts; // Update total attempts counter
            totalRounds++; // Increment total rounds counter


            // Ask the user if they want to play again only when the guess is correct
            System.out.print("\nPlay again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }
        
        // Calculate and display the user's score based on the average attempts per round
        double avgAttemptsPerRound = (double) totalAttempts / totalRounds;
        System.out.printf("\nGame Over! \nYour average score based on attempts was %.2f.%n", avgAttemptsPerRound);

        // Close the scanner
        scanner.close();
    }

	
    // Method to play a single round of the game and return the number of attempts
    public static int play() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; //Generate a random number between 1 and 100

        System.out.println("------------------------------------");
        System.out.println("             Number Game            ");
        System.out.println("------------------------------------");
        System.out.println("Guess the a number between 1 to 100!");
        System.out.println("  You get only 10 chances to guess  ");
        System.out.println("             ----------             ");

        boolean correctGuess = false;
        int attempts = 0;
        int maxAttempts = 10; // Initialize maximum attempts the user gets

        while (!correctGuess && attempts < maxAttempts) {
            int userGuess = guess(); // Call the guess method to get the user's guess
            attempts++; // Increment attempts counter

            // Check the user's guess and provide feedback using the check method
            String result = check(userGuess, randomNumber);
            System.out.println(result);

            if (result.equals("Correct!")) {
                correctGuess = true;
            }
        }
        if(!correctGuess){
            System.out.println("\nSorry, you have reached the attempt limit!");
        }
        return attempts;
    }


    // Method to get the user's guess
    public static int guess() {
        System.out.print("\nEnter your guess: "); // Moved the prompt here
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    // Method to check the user's guess and provide feedback
    public static String check(int userGuess, int randomNumber) {
        if (userGuess == randomNumber) {
            return "Correct!";
        } else if (userGuess < randomNumber) {
            return "Too low. Try again.";
        } else {
            return "Too high. Try again.";
        }
    }
}
    






	




