import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Homework {
    private JTable table1;
    private JPanel panel1;
    private JTextField NameTextField;
    private JTextField SurnameTextField;
    private JTextField CourseTextField;
    private JRadioButton studentRadioButton;
    private JRadioButton academicianRadioButton;
    private JButton UPDATEButton;
    private JButton INSERTButton;
    private JButton DELETEButton;

    private final Connection connection;
    private DefaultTableModel tableModel;

    public Homework() {
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(studentRadioButton);
        radioButtonGroup.add(academicianRadioButton);

        INSERTButton.addActionListener(e -> {
            if (!studentRadioButton.isSelected() && !academicianRadioButton.isSelected()) {
                showError("Please select either 'Student' or 'Academician' before inserting.");
                return;
            }

            if (!validateInput()) {
                showError("Please fill in all fields before inserting.");
                return;
            }

            if (studentRadioButton.isSelected()) {
                insertStudent();
            } else if (academicianRadioButton.isSelected()) {
                insertAcademician();
            }

            // Clear text fields after inserting
            NameTextField.setText("");
            SurnameTextField.setText("");
            CourseTextField.setText("");
        });

        DELETEButton.addActionListener(e -> deleteSelectedRow());

        UPDATEButton.addActionListener(e -> updateRecord());

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String name = table1.getValueAt(selectedRow, 1).toString();
                    String surname = table1.getValueAt(selectedRow, 2).toString();
                    String course = table1.getValueAt(selectedRow, 3).toString();
                    NameTextField.setText(name);
                    SurnameTextField.setText(surname);
                    CourseTextField.setText(course);
                }
            }
        });

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "1234");
            initializeTable(); // Call initializeTable() before populateTable()
            populateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        studentRadioButton.addActionListener(e -> populateTable());
        academicianRadioButton.addActionListener(e -> populateTable());
    }

    private boolean validateInput() {
        String name = NameTextField.getText();
        String surname = SurnameTextField.getText();
        String course = CourseTextField.getText();

        return !name.isEmpty() && !surname.isEmpty() && !course.isEmpty();
    }

    private void insertStudent() {
        String name = NameTextField.getText();
        String surname = SurnameTextField.getText();
        String course = CourseTextField.getText();

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Student (Name, Surname, CourseCode) VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, course);
            statement.executeUpdate();
            populateTable();
        } catch (SQLException e) {
            showError("Error inserting student: " + e.getMessage());
        }
    }

    private void insertAcademician() {
        String name = NameTextField.getText();
        String surname = SurnameTextField.getText();
        String course = CourseTextField.getText();

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Academician (Name, Surname, CourseCode) VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, course);
            statement.executeUpdate();
            populateTable();
        } catch (SQLException e) {
            showError("Error inserting academician: " + e.getMessage());
        }
    }

    private void deleteSelectedRow() {
        if (!studentRadioButton.isSelected() && !academicianRadioButton.isSelected()) {
            showError("Please select either 'Student' or 'Academician' before deleting, then choose a row.");
            return;
        }

        int selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            String id = table1.getValueAt(selectedRow, 0).toString();
            String tableName = studentRadioButton.isSelected() ? "Student" : "Academician";
            String idColumnName = studentRadioButton.isSelected() ? "StudentID" : "AcademicianID";
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?")) {
                statement.setString(1, id);
                statement.executeUpdate();
                populateTable();
            } catch (SQLException e) {
                showError("Error deleting record: " + e.getMessage());
            }
        } else {
            showError("Please select a row to delete.");
        }
    }

    private void updateRecord() {
        if (!studentRadioButton.isSelected() && !academicianRadioButton.isSelected()) {
            showError("Please select either 'Student' or 'Academician' before updating, then choose a row.");
            return;
        }

        int selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            String id = table1.getValueAt(selectedRow, 0).toString();
            String name = NameTextField.getText();
            String surname = SurnameTextField.getText();
            String course = CourseTextField.getText();
            if (name.isEmpty() || surname.isEmpty() || course.isEmpty()) {
                showError("Please fill in all fields before updating.");
                return;
            }
            String tableName = studentRadioButton.isSelected() ? "Student" : "Academician";
            String idColumnName = studentRadioButton.isSelected() ? "StudentID" : "AcademicianID";
            try (PreparedStatement statement = connection.prepareStatement("UPDATE " + tableName + " SET Name = ?, Surname = ?, CourseCode = ? WHERE " + idColumnName + " = ?")) {
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, course);
                statement.setString(4, id);
                statement.executeUpdate();
                populateTable();

                // Clear text fields after update
                NameTextField.setText("");
                SurnameTextField.setText("");
                CourseTextField.setText("");
            } catch (SQLException ex) {
                showError("Error updating record: " + ex.getMessage());
            }
        } else {
            showError("Please select a row to update.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(panel1, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void initializeTable() {
        String[] columnNames = {"ID", "Name", "Surname", "Course"};
        tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setColumnIdentifiers(columnNames);
        table1.setModel(tableModel); // Add this line to associate tableModel with table1
    }

    private void populateTable() {
        try {
            String sql;
            if (studentRadioButton.isSelected()) {
                sql = "SELECT StudentID as ID, Name, Surname, CourseCode as Course FROM Student";
            } else if (academicianRadioButton.isSelected()) {
                sql = "SELECT AcademicianID as ID, Name, Surname, CourseCode as Course FROM Academician";
            } else {
                return;
            }

            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();

                tableModel.setRowCount(0);

                while (resultSet.next()) {
                    Object[] row = new Object[metaData.getColumnCount()];
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        row[i - 1] = resultSet.getObject(i);
                    }
                    tableModel.addRow(row);
                }
            }
        } catch (SQLException e) {
            showError("Error populating table: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Homework");
        frame.setContentPane(new Homework().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
