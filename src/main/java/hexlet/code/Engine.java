package hexlet.code;

import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Engine {
    public static final String MSG_CORRECT_TEMPLATE = "Correct!";

    public static void playGame(String userName,
                                String inviteMessage,
                                String[][] questionsWithAnswers,
                                boolean compareInteger) {
        Scanner scanner = new Scanner(System.in);
        boolean comparisonResult = false;

        System.out.println(inviteMessage);

        for (int step = 0; step < Settings.REPEAT_COUNT; step++) {
            Settings.printQuestion(questionsWithAnswers[step][0]);
            String userAttemptStr = "";

            if (compareInteger) {
                int userAttemptInt = scanner.nextInt();
                userAttemptStr = Integer.toString(userAttemptInt);
                comparisonResult = userAttemptInt == Integer.parseInt(questionsWithAnswers[step][1]);
            } else {
                userAttemptStr = scanner.nextLine().toLowerCase();
                comparisonResult = userAttemptStr.equals(questionsWithAnswers[step][1]);
            }

            String message = comparisonResult ? MSG_CORRECT_TEMPLATE : "'" + userAttemptStr
                    + "' is wrong answer ;(. Correct answer was '" + questionsWithAnswers[step][1] + "'.";

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
}
