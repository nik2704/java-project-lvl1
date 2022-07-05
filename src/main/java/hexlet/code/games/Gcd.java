package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Gcd extends Game {
    public static void start(String userName) {
        Engine.playGame(userName, new Gcd(), "Find the greatest common divisor of given numbers.");
    }
    public boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue1 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        int randomValue2 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);

        int correctAnswerInt = Gcd.gcd(randomValue1, randomValue2);
        Settings.printQuestion(randomValue1 + " " + randomValue2);

        int userAttempt = scanner.nextInt();

        this.setCorrectAnswer(Integer.toString(correctAnswerInt));
        this.setUserAnswer(Integer.toString(userAttempt));

        return userAttempt == correctAnswerInt;
    }

    private static int gcd(int n1, int n2) {
        int result = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                result = i;
            }
        }
        return result;
    }
}
