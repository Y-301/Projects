package Lab2;

public class Faculty {
    // Function to direct to the appropriate department based on the parameter
    public void directToDepartment(String department) {
        if (department.equalsIgnoreCase("CEN")) {
            System.out.println("You are directed to the Department of Computer Engineering");
        } else if (department.equalsIgnoreCase("SEN")) {
            System.out.println("You are directed to the Department of Software Engineering");
        } else {
            System.out.println("Error: Invalid department. Please enter CEN or SEN.");
        }
    }
}
