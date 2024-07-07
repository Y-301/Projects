import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_form extends JFrame {
    private JTextField txtNumber1, txtNumber2, txtOperation, txtResult;
    private JButton btnCalculate, SQUAREButton;
    private JLabel lblNumber1, lblNumber2;
    private JPanel panel1;

    public Calculator_form() {
        setTitle("Simple Calculator");
        setSize(600, 400);
        add(panel1);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = txtOperation.getText();
                int number1 = Integer.parseInt(txtNumber1.getText());
                int number2 = Integer.parseInt(txtNumber2.getText());
                int result;
                switch (s) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            txtResult.setText("Cant divide by zero");
                            return;
                        }
                        break;
                    default:
                        txtResult.setText("Invalid operation");
                        return;
                }
                txtResult.setText(Integer.toString(result));

            }
        });


        SQUAREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number1 = Integer.parseInt(txtNumber1.getText());
                    int result = number1 * number1;
                    txtResult.setText(Integer.toString(result));
                } catch (NumberFormatException ex) {
                    txtResult.setText("Please enter a valid number");
                }
            }
        });
    }

    public static void main(String[] args) {
        Calculator_form bs = new Calculator_form();
        bs.setVisible(true);
    }
}
