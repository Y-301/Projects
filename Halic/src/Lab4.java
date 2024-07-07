import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import static java.lang.System.*;

public class Lab4 {

    public static void main(String[] args) {

        //scannner

        Scanner scanner = new Scanner(System.in);
        System.out.println("write your text here :");
        String userName = scanner.nextLine();

        //create file

        File myFile = new File("C:\\Users\\amamr\\OneDrive\\Desktop\\myFile.txt");
        try {
            if(myFile.createNewFile())
            {
                out.println("File created");
            }else {
                out.println("File already exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //write file

        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("myFile.txt", true));
            myWriter.write(userName);
            myWriter.close();
            System.out.println("Data successfully appended at the end of file.");
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        //read file

        try {
            File file = new File("myFile.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("reading: "+data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //get info

        File file = new File("myFile.txt");
        if (file.exists()) {
            System.out.println("The name of the file is: " + file.getName());
            System.out.println("The absolute path of the file is: " + file.getAbsolutePath());
            System.out.println("Is file writeable: " + file.canWrite());
            System.out.println("Is file readable: " + file.canRead());
            System.out.println("The size of the file in bytes is: " + file.length());
        } else {
            System.out.println("The file does not exist.");
        }
        //choice to delete the file

        Scanner deleteScanner = new Scanner(System.in);
        System.out.println("Do you want to delete the file? (1 = Yes / 2 = No)");
        int choice = deleteScanner.nextInt();

        if (choice == 1) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File not deleted.");
        }
    }
    }