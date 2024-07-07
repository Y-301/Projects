import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab9 extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel homePanel;
    private JPanel aboutUsPanel;
    private JPanel loginPanel;
    private JPanel infoPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton enterButton;
    private JButton goToJMenuBarButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public Lab9() {
        // Set the content pane and default close operation
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        // Action listener for the enter button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                // Replace with your actual validation logic
                if ("admin".equals(username) && "1234".equals(password)) {
                    tabbedPane.setSelectedIndex(0); // Switch to Home tab
                    goToJMenuBarButton.setVisible(true); // Show the "GO to JMENUBAR" button

                    // Clear the username and password fields
                    usernameTextField.setText("");
                    passwordField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });

        // Initially hide the "GO to JMENUBAR" button
        goToJMenuBarButton.setVisible(false);

        // Action listener for the "GO to JMENUBAR" button
        goToJMenuBarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuBarFrame menuBarFrame = new JMenuBarFrame();
                menuBarFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Lab9 frame = new Lab9();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // Set up the login panel
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(enterButton);

        // Set up the home panel
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        homePanel.add(goToJMenuBarButton);

        // Add panels to the tabbed pane
        tabbedPane.addTab("Home", homePanel);
        tabbedPane.addTab("About Us", aboutUsPanel);
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Info", infoPanel);

        // Add tabbed pane to the main panel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(tabbedPane);
    }
}
