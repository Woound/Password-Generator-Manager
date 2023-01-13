import java.io.*;
import java.util.Scanner;

public class passManager {
    public passManager() {
        Scanner scanner = new Scanner(System.in);
        passGenerator passGen = new passGenerator();

        if (passGen.getDecision() == 'G') {
            String userDirectory = System.getProperty("user.dir"); // Gets the current working directory.
            File passManager = new File(userDirectory + "//passwordManager.txt"); // Path to generate the file in.
            try {
                if (passManager.createNewFile()) {
                    System.out.println("File '" + passManager.getName() + "' has been created.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            try {
                FileWriter writeToFile = new FileWriter("passwordManager.txt", true);
                String[] passwords = passGen.getPass();
                for (String password : passwords) {
                    writeToFile.write(password + "\n");
                }
                writeToFile.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (passGen.getDecision() == 'R') { //Retrieves the passwords from the file.
            String userDirectory = System.getProperty("user.dir");
            File passManager = new File(userDirectory + "//passwordManager.txt");
            try {
                Scanner fileReader = new Scanner(passManager);
                System.out.println("Here are your passwords:");
                while (fileReader.hasNextLine()) {
                    String passwords = fileReader.nextLine();
                    System.out.println(passwords);
                }
                fileReader.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

}





