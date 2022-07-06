package hexlet.code;

import hexlet.code.env.Settings;
import hexlet.code.games.GameInterface;

import java.util.Scanner;

public final class Engine {
    public static final String MSG_CORRECT_TEMPLATE = "Correct!";

    public static void playGame(String userName, GameInterface game, String inviteMessage) {
        Scanner scanner = new Scanner(System.in);

        boolean result = false;
        System.out.println(inviteMessage);

        for (int step = 0; step < Settings.REPEAT_COUNT; step++) {
            result = game.nextStep(scanner);

            String message = result ? MSG_CORRECT_TEMPLATE : "'" + game.getUserAnswer()
                    + "' is wrong answer ;(. Correct answer was '" + game.getCorrectAnswer() + "'.";

            System.out.println(message);

            if (!result) {
                break;
            }
        }

        if (result) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

}
