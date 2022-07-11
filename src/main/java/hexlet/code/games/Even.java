package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Even {
    private static final String NOTE = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void startGame() {
        String[] questions = new String[Settings.REPEAT_COUNT];
        String[] answers = new String[Settings.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int randomValue = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
            boolean isEven = randomValue % 2 == 0;

            questions[qIndex] = Integer.toString(randomValue);
            answers[qIndex] = isEven ? "yes" : "no";
        }

        Engine.playGame(NOTE, questions, answers);
    }
}
