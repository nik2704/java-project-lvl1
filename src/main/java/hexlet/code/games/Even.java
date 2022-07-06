package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Even {
    private static final String NOTE = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void startGame(String userName) {
        String[][] questionsWithAnswers = new String[Settings.REPEAT_COUNT][2];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int randomValue = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
            boolean isEven = randomValue % 2 == 0;

            questionsWithAnswers[qIndex][0] = Integer.toString(randomValue);
            questionsWithAnswers[qIndex][1] = isEven ? "yes" : "no";
        }

        Engine.playGame(userName, NOTE, questionsWithAnswers, false);
    }
}
