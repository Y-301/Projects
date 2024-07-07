import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab8 extends JFrame {
    private JPanel panel1, JPanel2, JPanel3;
    private JList<String> list1, list2;
    private JButton JButton1, JButton2;
    private JTextField textField1;
    private JLabel JLabel1;


    private final DefaultListModel<String> listModel1;
    private final DefaultListModel<String> listModel2;

    public Lab8() {
        add(panel1);

        // Initialize the frame
        setTitle("JList App");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the list models
        listModel1 = new DefaultListModel<>();
        listModel2 = new DefaultListModel<>();

        // Assign list models to JLists
        list1.setModel(listModel1);
        list2.setModel(listModel2);

        // Add button listeners
        JButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = textField1.getText().trim();
                if (courseName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a course name");
                } else {
                    listModel1.addElement(courseName);
                    textField1.setText("");
                    list1.setBackground(Color.BLUE);
                    list2.setBackground(Color.YELLOW);
                }
            }
        });

        JButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listModel1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "There are no courses to be removed");
                } else {
                    String courseName = listModel1.remove(0);
                    listModel2.addElement(courseName);
                    list1.setBackground(Color.RED);
                    list2.setBackground(Color.GREEN);
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab8().setVisible(true);
            }
        });
    }
}
