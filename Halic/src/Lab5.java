import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {

        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {
            randomNumbers.add(random.nextInt(101));
        }


        System.out.println("ArrayList with 100 random integer numbers between 1-100:");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.println("Print 10 numbers: ");
        for (int j=1 ; j<11; j++) {
            if (j % 2 == 1) {
                System.out.print(j);
            }
        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search for: ");
        int specificNumber = scanner.nextInt();

        int specificCount = 0;
        int oddCount = 0;
        int evenCount = 0;

        for (int num : randomNumbers) {
            if (num == specificNumber) {
                specificCount++;
            }
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("\n");
        System.out.println("The number (" + specificNumber + ") occurred " + specificCount + " times in the ArrayList");
        System.out.println("Number of odd numbers: " + oddCount);
        System.out.println("Number of even numbers: " + evenCount);
    }
}

