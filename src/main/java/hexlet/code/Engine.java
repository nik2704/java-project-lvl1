package hexlet.code;

import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Engine {
    public static final String MSG_CORRECT_TEMPLATE = "Correct!";

    public static void playGame(String inviteMessage,
                                String[] questions,
                                String[] answers) {
        Scanner scanner = new Scanner(System.in);

        String userName = Cli.greeting();

        boolean comparisonResult = false;

        System.out.println(inviteMessage);

        for (int step = 0; step < Settings.REPEAT_COUNT; step++) {
            Settings.printQuestion(questions[step]);
            String userAttemptStr = "";

            if (isNumeric(answers[step])) {
                int userAttemptInt = scanner.nextInt();
                userAttemptStr = Integer.toString(userAttemptInt);
                comparisonResult = userAttemptInt == Integer.parseInt(answers[step]);
            } else {
                userAttemptStr = scanner.nextLine().toLowerCase();
                comparisonResult = userAttemptStr.equals(answers[step]);
            }

            String message = comparisonResult ? MSG_CORRECT_TEMPLATE : "'" + userAttemptStr
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

    private static boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }

        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }

        return false;
    }
}
