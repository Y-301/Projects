public class Main {
    public static void main(String[] args) {
        // Hello World example
        System.out.println("Hello, World!");

        // Variables example
        String name = "John";
        int age = 30;
        double salary = 50000.5;
        boolean isEmployed = true;

        // Data types example
        byte smallNumber = 10;
        short mediumNumber = 1000;
        int largeNumber = 100000;
        long hugeNumber = 1000000000L;
        float decimalNumber = 3.14f;
        double preciseNumber = 2.71828;
        char initial = 'J';
        String message = "Welcome to Java!";

        // Math example
        int x = 10;
        int y = 20;
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        double sqrt = Math.sqrt(x);
        double abs = Math.abs(-5);
        double random = Math.random();

        // Booleans example
        boolean isJavaFun = true;
        boolean isPythonFun = false;

        // If...Else example
        int number = 42;
        if (number > 50) {
            System.out.println("Number is greater than 50");
        } else if (number < 50) {
            System.out.println("Number is less than 50");
        } else {
            System.out.println("Number is equal to 50");
        }

        // Switch example
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            // ... other cases ...
            default:
                System.out.println("Invalid day");
        }

        // Loops example
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + i);
        }

        // Arrays example
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // Methods example
        int sum = addNumbers(5, 7);
        System.out.println("\nSum: " + sum);

        // While loop example
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }

        // Do-While loop example
        int num = 1;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num <= 5);

        // For-each loop with an array
        String[] fruits = {"Apple", "Banana", "Orange", "Grapes"};
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // ... Other concepts (exception handling, classes, inheritance, etc.) ...

        // Calling a static method from another class
        int result = MathOperations.add(10, 20);
        System.out.println("Result: " + result);
    }

    // Method to add two numbers
    public static int addNumbers(int a, int b) {
        return a + b;
    }
}

class MathOperations {
    public static int add(int a, int b) {
        return a + b;
    }
}
