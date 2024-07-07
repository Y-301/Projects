import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        // Get the user-provided dimension (size) for the array
        int dimension = getUserInput();

        // Create an array with the specified dimension
        int[] myArray = new int[dimension];

        // Assign random values between 10 and 100 to the array
        Random random = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(91) + 10; // Generates a random number between 10 and 100
        }

        // Print the array
        System.out.println("Randomly generated array:");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array dimension: ");
        return scanner.nextInt();
    }
}
