import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int randNum = rand.nextInt(100) + 1;
        int userNum = 0;
        boolean validInput = false;

        // Get valid initial input
        while (!validInput) {
            System.out.println("Enter a number between 1 and 100: ");
            try {
                userNum = scanner.nextInt();

                if (userNum >= 1 && userNum <= 100) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between 1 and 100.");
                }

            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        // Main guessing loop
        while (userNum != randNum) {
            if (userNum > randNum) {
                System.out.println("Number was too high! Enter another number:");
            } else {
                System.out.println("Number was too low! Enter another number:");
            }

            // Keep checking for valid input inside loop
            validInput = false;
            while (!validInput) {
                try {
                    userNum = scanner.nextInt();
                    if (userNum >= 1 && userNum <= 100) {
                        validInput = true;
                    } else {
                        System.out.println("Please enter a number between 1 and 100.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid number. Please enter an integer.");
                    scanner.next(); // Clear the invalid input
                }
            }

            count++;
        }

        System.out.println("You guessed it in " + (count + 1) + " guesses!");
    }
}