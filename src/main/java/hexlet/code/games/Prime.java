package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Prime {
    private static final int MAX_RANDOM_START_PRIME = 50;
    private static final int MIN_RANDOM_START_PRIME = 2;
    private static final String NOTE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame(String userName) {
        String[][] questionsWithAnswers = new String[Settings.REPEAT_COUNT][2];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int randomValue = Settings.getRandom(MIN_RANDOM_START_PRIME, MAX_RANDOM_START_PRIME);
            boolean isPrime = isPrimeNumber(randomValue);

            questionsWithAnswers[qIndex][0] = Integer.toString(randomValue);
            questionsWithAnswers[qIndex][1] = isPrime ? "yes" : "no";
        }

        Engine.playGame(userName, NOTE, questionsWithAnswers, false);
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
