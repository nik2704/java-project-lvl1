package hexlet.code;

import hexlet.code.env.Settings;
import hexlet.code.games.GameInterface;

import java.util.Scanner;

public final class Engine {
    public static final String MSG_CORRECT_TEMPLATE = "Correct!";

    public static void playGame(String userName, GameInterface game, String msg) {
        Scanner scanner = new Scanner(System.in);
        int repeatCount = Settings.REPEAT_COUNT;

        boolean stepResult = true;
        System.out.println(msg);
        while (stepResult && (repeatCount > 0)) {
            stepResult = game.nextStep(scanner, repeatCount);
            if (stepResult) {
                System.out.println(MSG_CORRECT_TEMPLATE);
                repeatCount--;
            } else {
                System.out.println("'" + game.getUserAnswer()
                        + "' is wrong answer ;(. Correct answer was '"
                        + game.getCorrectAnswer() + "'.");
            }
        }

        if (repeatCount == 0) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

}
