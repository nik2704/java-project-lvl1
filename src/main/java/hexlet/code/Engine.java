package hexlet.code;

import hexlet.code.env.Settings;

import java.util.Objects;
import java.util.Scanner;

public final class Engine {

    public static void playGame(String inviteMessage,
                                String[] questions,
                                String[] answers) {
        Scanner scanner = new Scanner(System.in);

        String userName = getUserName(scanner);

        boolean comparisonResult = false;

        System.out.println(inviteMessage);

        for (int step = 0; step < Settings.REPEAT_COUNT; step++) {
            Settings.printQuestion(questions[step]);
            String userAttemptStr = "";

            userAttemptStr = scanner.nextLine().toLowerCase();
            comparisonResult = Objects.equals(userAttemptStr, answers[step]);

            String message = comparisonResult ? "Correct!" : "'" + userAttemptStr
                    + "' is wrong answer ;(. Correct answer was '" + answers[step] + "'.";

            System.out.println(message);

            if (!comparisonResult) {
                break;
            }
        }

        if (comparisonResult) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

    private static String getUserName(Scanner scanner) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
}
