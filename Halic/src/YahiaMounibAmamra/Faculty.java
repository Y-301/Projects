package YahiaMounibAmamra;

public class Faculty {
    // Function to determine department based on parameter value
    public void determineDepartment(String departmentCode) {
        if (departmentCode.equals("CEN")) {
            System.out.println("You are directed to the Department of Computer Engineering.");
        } else if (departmentCode.equals("SEN")) {
            System.out.println("You are directed to the Department of Software Engineering.");
        } else {
            System.out.println("You are directed to the Faculty Secretariat.");
        }
    }
}
