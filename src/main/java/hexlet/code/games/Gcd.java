package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Gcd {
    private static final String NOTE = "What is the result of the expression?";

    public static void startGame(String userName) {
        String[][] questionsWithAnswers = new String[Settings.REPEAT_COUNT][2];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int randomValue1 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
            int randomValue2 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);

            questionsWithAnswers[qIndex][0] = randomValue1 + " " + randomValue2;
            questionsWithAnswers[qIndex][1] = Integer.toString(Gcd.gcd(randomValue1, randomValue2));
        }

        Engine.playGame(userName, NOTE, questionsWithAnswers, true);

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
