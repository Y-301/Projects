package YahiaMounibAmamra;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get student details from the user
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student surname: ");
        String surname = scanner.nextLine();

        // Create a Student object
        Student student = new Student(studentId, name, surname);

        // Display student details
        System.out.println("\nStudent Details:");
        student.displayStudentDetails();

        // Get department code from the user
        System.out.print("\nEnter department code (CEN/SEN): ");
        String departmentCode = scanner.nextLine();

        // Create a Faculty object
        Faculty faculty = new Faculty();

        // Determine department based on input
        faculty.determineDepartment(departmentCode);

        scanner.close();


    }
}
