package hexlet.code;

import java.util.Objects;
import java.util.Scanner;

public final class Engine {
    public static final int REPEAT_COUNT = 3;

    public static void playGame(String inviteMessage, String[][] questionsWithAnswers) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        boolean comparisonResult = false;

        System.out.println(inviteMessage);

        for (int step = 0; step < REPEAT_COUNT; step++) {
            System.out.print("Question: " + questionsWithAnswers[0][step] + "\nYour answer: ");
            String userAttemptStr = "";

            userAttemptStr = scanner.nextLine().toLowerCase();
            comparisonResult = Objects.equals(userAttemptStr, questionsWithAnswers[1][step]);

            String message = comparisonResult ? "Correct!" : "'" + userAttemptStr
                    + "' is wrong answer ;(. Correct answer was '" + questionsWithAnswers[1][step] + "'.";

            System.out.println(message);

            if (!comparisonResult) {
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
