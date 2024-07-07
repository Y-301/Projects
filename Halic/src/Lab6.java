import javax.swing.JOptionPane;
import java.sql.*;

public class Lab6 {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab6_oop", "root", "#Yahia2003");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String[] options = {"Addition", "Subtraction", "Multiplication", "Division"};
        int operationChoice = JOptionPane.showOptionDialog(null, "Select an operation:", "Four Operations",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (operationChoice == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Operation canceled.", "Four Operations", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String num1Str = JOptionPane.showInputDialog(null, "Enter the first number:", "Four Operations",
                JOptionPane.QUESTION_MESSAGE);

        if (num1Str == null) {
            JOptionPane.showMessageDialog(null, "Operation canceled.", "Four Operations", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double num1 = parseNumber(num1Str);

        String num2Str = JOptionPane.showInputDialog(null, "Enter the second number:", "Four Operations",
                JOptionPane.QUESTION_MESSAGE);

        if (num2Str == null) {
            JOptionPane.showMessageDialog(null, "Operation canceled.", "Four Operations", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double num2 = parseNumber(num2Str);

        double result = 0;
        String operator = "";

        try {
            result = performOperation(operationChoice, num1, num2);
            operator = getOperator(operationChoice);


            JOptionPane.showMessageDialog(null, "Result: " + num1 + " " + operator + " " + num2 + " = " + result,
                    "Four Operations", JOptionPane.INFORMATION_MESSAGE);

        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Cannot divide by zero!", "Four Operations", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format!", "Four Operations", JOptionPane.ERROR_MESSAGE);
        }
    }


    private static double parseNumber(String input) {
        return Double.parseDouble(input);
    }


    private static double performOperation(int operationChoice, double num1, double num2) {
        if (operationChoice == 0) {
            return num1 + num2;
        } else if (operationChoice == 1) {
            return num1 - num2;
        } else if (operationChoice == 2) {
            return num1 * num2;
        } else if (operationChoice == 3) {
            if (num2 == 0) {
                throw new ArithmeticException();
            } else {
                return num1 / num2;
            }
        } else {
            throw new IllegalArgumentException("Invalid operation choice");
        }
    }


    private static String getOperator(int operationChoice) {
        if (operationChoice == 0) {
            return "+";
        } else if (operationChoice == 1) {
            return "-";
        } else if (operationChoice == 2) {
            return "*";
        } else if (operationChoice == 3) {
            return "/";
        } else {
            throw new IllegalArgumentException("Invalid operation choice");
        }
    }
}
