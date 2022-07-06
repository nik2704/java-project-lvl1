package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Calc {
    private static final String NOTE = "What is the result of the expression?";

    public static void startGame(String userName) {
        String[][] questionsWithAnswers = new String[Settings.REPEAT_COUNT][2];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int randomValue1 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
            int randomValue2 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
            String operation = getRandomOperation();

            int correctAnswerInt = operation.equals("*") ? randomValue1 * randomValue2 : randomValue1 + randomValue2;

            questionsWithAnswers[qIndex][0] = randomValue1 + " " + operation + " " + randomValue2;
            questionsWithAnswers[qIndex][1] = Integer.toString(correctAnswerInt);
        }

        Engine.playGame(userName, NOTE, questionsWithAnswers, true);

    }

    private static String getRandomOperation() {
        String[] arr = {"*", "+"};

        return arr[Settings.getRandom(0, 1)];
    }
}
