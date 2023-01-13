import java.util.Random;
import java.util.Scanner;

public class passGenerator {
    String[] generated_pass;
    char decision;
    public passGenerator() {
        int totRndPasswords;
        int passwordsLen;
        Scanner scanner = new Scanner(System.in); //Scanner to take in user input.
        System.out.println("Welcome! Please Choose one of the following options:");
        System.out.println("G - Generate and store passwords | R - Retrieve Passwords | Q - Quit");
        decision = scanner.next().charAt(0);
        if (decision == 'G') {
            System.out.println("Welcome! How many passwords would you like to generate?");
            totRndPasswords = scanner.nextInt();
            generated_pass = new String[totRndPasswords]; //Creates an array of size equal to the amount of passwords entered by the user,
            System.out.println("How long should the passwords be? (12-15 words is ideal!)");
            passwordsLen = scanner.nextInt();

            if (passwordsLen < 12) { // Check on password length.
                System.out.println("Caution: The password length you have entered is below the recommended password Length!");
            }
            for (int passDone = 0; passDone < totRndPasswords; passDone++) {
                generated_pass[passDone] = "";
                for (int i = 0; i < passwordsLen; i++) {
                    generated_pass[passDone] += char_generator(); //Calls the char_generator function to generate a random ASCII character.
                }
                System.out.println(generated_pass[passDone]);
            }
        } else if (decision == 'R') {
            return;
        } else if (decision == 'Q') {
            java.lang.System.exit(0);
        } else {
            System.out.println("Invalid Input.");
            java.lang.System.exit(0);
        }
    }
    static char char_generator() { //Generating random characters to make up the password.
        char ranChar;
        Random random = new Random();
        ranChar = (char) (random.nextInt(0, 61) + '0'); // Random Character from ASCII set.
        return ranChar;
    }

    public String[] getPass() {
        return generated_pass;
    }

    public char getDecision() {
        return decision;
    }

}
