import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lab3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a question to execute:");
        System.out.println("1. Question 1: ArrayList operations");
        System.out.println("2. Question 2: List to HashSet operations");
        System.out.print("Enter 1 or 2: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                executeQuestion1();
                break;
            case 2:
                executeQuestion2(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        scanner.close();
    }

    public static void executeQuestion1() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Add 10 random integers between 10 and 100
        for (int i = 0; i < 10; i++) {
            int number = 10 + random.nextInt(91); // Generates a random number between 10 and 100
            numbers.add(number);
        }

        // Sum all the elements
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Calculate the average
        double average = sum / (double) numbers.size();

        // Display the results
        System.out.println("ArrayList: " + numbers);
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);
    }

    public static void executeQuestion2(Scanner scanner) {
        List<String> userList = new ArrayList<>();

        // Get 5 values from the user
        System.out.println("Enter 5 values:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            userList.add(scanner.nextLine());
        }

        // Display the List
        System.out.println("List: " + userList);

        // Add the List to a HashSet and display the HashSet
        Set<String> hashSet = addListToHashSet(userList);
        System.out.println("HashSet: " + hashSet);
    }

    public static Set<String> addListToHashSet(List<String> list) {
        return new HashSet<>(list);
    }
}
