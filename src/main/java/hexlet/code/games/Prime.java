package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Prime {
    private static final int MAX_RANDOM_START_PRIME = 50;
    private static final int MIN_RANDOM_START_PRIME = 2;
    private static final String NOTE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[] questions = new String[Settings.REPEAT_COUNT];
        String[] answers = new String[Settings.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int randomValue = Settings.getRandom(MIN_RANDOM_START_PRIME, MAX_RANDOM_START_PRIME);
            boolean isPrime = isPrimeNumber(randomValue);

            questions[qIndex] = Integer.toString(randomValue);
            answers[qIndex] = isPrime ? "yes" : "no";
        }

        Engine.playGame(NOTE, questions, answers);
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
