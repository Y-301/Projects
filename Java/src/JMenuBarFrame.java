import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuBarFrame extends JFrame {
    // These variables should be auto-generated by IntelliJ IDEA GUI Designer
    private JPanel menuBarPanel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu viewMenu;
    private JMenu helpMenu;
    private JMenuItem cutMenuItem;
    private JMenuItem copyMenuItem;
    private JMenuItem pasteMenuItem;
    private JTextArea copyTextArea;
    private JTextArea pasteTextArea;
    private JMenuItem openMenuItem;
    private JMenuItem newMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem saveAsMenuItem;
    private String clipboard;

    public JMenuBarFrame() {
        // Initialize clipboard
        clipboard = "";

        // Set up the JFrame
        setTitle("JMenuBar Example");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setContentPane(menuBarPanel);

        // Action listeners for the menu items
        cutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clipboard = copyTextArea.getSelectedText();
                copyTextArea.replaceSelection("");
                JOptionPane.showMessageDialog(null, "Cut action performed");
            }
        });

        copyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clipboard = copyTextArea.getSelectedText();
                JOptionPane.showMessageDialog(null, "Copy action performed");
            }
        });

        pasteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasteTextArea.insert(clipboard, pasteTextArea.getCaretPosition());
                JOptionPane.showMessageDialog(null, "Paste action performed");
            }
        });

        // Action listeners for File menu items (optional functionality)
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Open action performed");
            }
        });

        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "New action performed");
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Save action performed");
            }
        });

        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Save As action performed");
            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JMenuBarFrame().setVisible(true);
            }
        });
    }
}
