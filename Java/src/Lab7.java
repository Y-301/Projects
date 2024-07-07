import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Lab7 {
    private JPanel panel1;
    private JRadioButton JRadioButton1;
    private JRadioButton JRadioButton2;
    private JButton SHOWButton;
    private JTextField textField1;

    public Lab7() {

        ButtonGroup group = new ButtonGroup();
        group.add(JRadioButton1);
        group.add(JRadioButton2);


        SHOWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JRadioButton1.isSelected() && JRadioButton2.isSelected()) {
                    textField1.setText("Error: Select only one option.");
                } else if (JRadioButton1.isSelected()) {
                    textField1.setText(getNumbersDivisibleBy3And5());
                } else if (JRadioButton2.isSelected()) {
                    textField1.setText(getPrimeNumbers());
                } else {
                    textField1.setText("Error: Select an option.");
                }
            }
        });
    }

    private String getNumbersDivisibleBy3And5() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                numbers.add(i);
            }
        }
        return listToString(numbers);
    }

    private String getPrimeNumbers() {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return listToString(primes);
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 7");
        frame.setTitle("Lab 7");
        frame.setSize(600, 400);
        Lab7 lab7 = new Lab7();
        frame.add(lab7.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}