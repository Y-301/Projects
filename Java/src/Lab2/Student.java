package Lab2;

public class Student {
    private int studentId;
    private String name;
    private String surname;

    // Function to assign values to the variables
    public void setStudentDetails(int studentId, String name, String surname) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
    }

    // Function to print the student details
    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
    }
}
