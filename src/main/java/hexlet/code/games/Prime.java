package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Utils;

public final class Prime {
    public static final int MIN_RANDOM_INT = 2;
    public static final int MAX_RANDOM_INT = 50;
    private static final String NOTE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] questionsWithAnswers = new String[2][Engine.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Engine.REPEAT_COUNT; qIndex++) {
            int randomValue = Utils.getRandom(MIN_RANDOM_INT, MAX_RANDOM_INT);
            boolean isPrime = isPrimeNumber(randomValue);

            questionsWithAnswers[0][qIndex] = Integer.toString(randomValue);
            questionsWithAnswers[1][qIndex] = isPrime ? "yes" : "no";
        }

        Engine.playGame(NOTE, questionsWithAnswers);
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
