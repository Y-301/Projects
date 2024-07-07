package YahiaMounibAmamra;

public class Student {
    int studentId;
    String name;
    String surname;

    // Constructor to assign values to studentId, name, and surname
    public Student(int studentId, String name, String surname) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
    }

    // Function to display student details
    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
    }
}
