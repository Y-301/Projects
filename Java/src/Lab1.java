import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the dimension of the array
        System.out.print("Enter the dimension of the array: ");
        int dimension = scanner.nextInt();

        // Initialize the array with the given dimension
        int[] array = new int[dimension];

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Fill the array with random values between 10 and 100
        for (int i = 0; i < dimension; i++) {
            array[i] = 10 + random.nextInt(91); // Generates a random number between 10 and 100
        }

        // Print the array
        System.out.println("Array values:");
        for (int i = 0; i < dimension; i++) {
            System.out.println("Element " + i + ": " + array[i]);
        }

        // Close the scanner
        scanner.close();
    }
}
