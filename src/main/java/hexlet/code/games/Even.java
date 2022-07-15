package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Utils;

public final class Even {
    public static final int MIN_RANDOM_INT = 10;
    public static final int MAX_RANDOM_INT = 50;
    private static final String NOTE = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void startGame() {
        String[][] questionsWithAnswers = new String[2][Engine.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Engine.REPEAT_COUNT; qIndex++) {
            int randomValue = Utils.getRandom(MIN_RANDOM_INT, MAX_RANDOM_INT);
            boolean isEven = randomValue % 2 == 0;

            questionsWithAnswers[0][qIndex] = Integer.toString(randomValue);
            questionsWithAnswers[1][qIndex] = isEven ? "yes" : "no";
        }

        Engine.playGame(NOTE, questionsWithAnswers);
    }
}
