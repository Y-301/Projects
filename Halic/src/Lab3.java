import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {
    private static final Logger LOGGER = Logger.getLogger(Lab3.class.getName());

    public static void main(String[] args) {
        try {
            // Create a folder on the desktop
            File folder = new File(System.getProperty("user.home") + "/Desktop/Lab3Folder");
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("Folder created successfully.");
            }

            // Create a text file inside the folder
            File file = new File(folder, "output.txt");

            // Create a FileWriter object to write to the file
            FileWriter writer = new FileWriter(file);

            // Create a Scanner object to read input from the user
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter data
            System.out.println("Enter data to write to the file:");

            // Read the input from the user
            String data = scanner.nextLine();

            // Write the input to the file
            writer.write(data);

            // Close the FileWriter
            writer.close();

            // Reopen the file for reading
            scanner = new Scanner(file);

            System.out.println("Contents of the file:");

            // Read and print the contents of the file
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            // Close the Scanner object
            scanner.close();

            // Display information about the file
            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println("File size: " + file.length() + " bytes");

            // Delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while performing file operations", e);
        }
    }
}
