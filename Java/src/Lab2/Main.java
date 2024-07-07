package Lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting student details from the user
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student surname: ");
        String surname = scanner.nextLine();

        // Creating a Student object and setting its details
        Student student = new Student();
        student.setStudentDetails(studentId, name, surname);

        // Displaying student details
        System.out.println("\nStudent Details:");
        student.displayStudentDetails();

        // Creating a Faculty object
        Faculty faculty = new Faculty();

        // Loop until a valid department is entered
        String department;
        while (true) {
            // Getting faculty department from the user
            System.out.print("\nEnter faculty department (CEN/SEN): ");
            department = scanner.nextLine();

            // Direct to the appropriate department or display an error
            if (department.equalsIgnoreCase("CEN") || department.equalsIgnoreCase("SEN")) {
                faculty.directToDepartment(department);
                break;
            } else {
                System.out.println("Error: Invalid department. Please enter CEN or SEN.");
            }
        }

        // Closing the scanner
        scanner.close();
    }
}
