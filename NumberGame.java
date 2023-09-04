/**
 * 
 */
package codsoft;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

      
	public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        boolean playAgain = true;

	        while (playAgain) {
	            
	        	// Call the play method to start a new round and get if it's a correct guess
	        	boolean correctGuess = play(); 

	            if (correctGuess) {
	                // Ask the user if they want to play again only when the guess is correct
	            	System.out.print("\n");
	            	System.out.print("Do you want to play again? (yes/no): ");
	                System.out.print("\n");
	                String playAgainInput = scanner.next().toLowerCase();
	                if (!playAgainInput.equals("yes")) {
	                    playAgain = false;
	                }
	            } else {
	                System.out.println("You can play again after making a correct guess.");
	            }
	        }
	        // Close the scanner
	        scanner.close();
	     
	}
	
	//Method to play a single round of game
	
	public static boolean play() {
        Random random = new Random();
        
     // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1; 

        System.out.println("---------------------------------");
        System.out.println("           NUMBER GAME           ");
        System.out.println("Guess the number between 1 to 100");
        System.out.println("---------------------------------");

        boolean correctGuess = false;

        while (!correctGuess) {
            
        	// Call the guess method to get the user's guess
        	int userGuess = guess(); 

            // Check the user's guess and provide feedback using the check method
            String result = check(userGuess, randomNumber);
            System.out.println(result);

            if (result.equals("Correct!")) {
                correctGuess = true;
            }
        }

        return correctGuess;
    }

	
	//Method to get the users input/guess
	public static int guess() {
		
		System.out.print("\n");
		System.out.print("Enter your Guess: ");
		Scanner scanner = new Scanner(System.in);

		return scanner.nextInt();
	}
	
	//Method to check the user guess and random number and giving feedback
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
