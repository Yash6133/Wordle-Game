import java.util.*;
public class Wordlegame {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        String[] words = {"HELLO", "WORLD", "LEARN", "ERROR"};
        String answer = words[new Random().nextInt(words.length)].toUpperCase();
        Scanner input = new Scanner(System.in);
        // System.out.print("Enter your guess: ");
        // String guess=input.nextLine().toUpperCase();
        int attempts = 4;

        System.out.println("Welcome to Wordle! You have 4 attempts to guess the correct 5-letter word.");

        while (attempts > 0) {
            System.out.print("Enter your guess (5 letters): ");
            String guess = input.nextLine().toUpperCase();

            // Check if the guess length is valid
            if (guess.length() != 5) {
                System.out.println("Your guess must be 5 letters long.");
                continue;
            }

            StringBuilder feedback = new StringBuilder();

            for (int i = 0; i < guess.length(); i++) {
                char a = guess.charAt(i);
                if (answer.charAt(i) == a) {
                    feedback.append(ANSI_GREEN + a + ANSI_RESET);
                } else if (answer.contains(Character.toString(a))) {
                    feedback.append(ANSI_YELLOW + a + ANSI_RESET);
                } else {
                    feedback.append(a);
                }
            }
            System.out.println(feedback.toString());


            if (guess.equals(answer)) {
                System.out.println("Congratulations, you guessed correctly");
                return;
            }else {
                attempts--;
                System.out.println("Incorrect guess. Attempts remaining: " + attempts);
            }
            System.out.println("Sorry ,you did not guess correctly");
            //System.out.println("The answer was " + answer);
        }
    }
    }

