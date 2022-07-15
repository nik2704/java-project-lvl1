package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Utils;

public final class Gcd {
    public static final int MIN_RANDOM_INT = 10;
    public static final int MAX_RANDOM_INT = 50;
    private static final String NOTE = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] questionsWithAnswers = new String[2][Engine.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Engine.REPEAT_COUNT; qIndex++) {
            int randomValue1 = Utils.getRandom(MIN_RANDOM_INT, MAX_RANDOM_INT);
            int randomValue2 = Utils.getRandom(MIN_RANDOM_INT, MAX_RANDOM_INT);

            questionsWithAnswers[0][qIndex] = randomValue1 + " " + randomValue2;
            questionsWithAnswers[1][qIndex] = Integer.toString(Gcd.gcd(randomValue1, randomValue2));
        }

        Engine.playGame(NOTE, questionsWithAnswers);

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
