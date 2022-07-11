package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Calc {
    private static final String NOTE = "What is the result of the expression?";

    public static void startGame() {
        String[] questions = new String[Settings.REPEAT_COUNT];
        String[] answers = new String[Settings.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int randomValue1 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
            int randomValue2 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
            String operation = getRandomOperation();

            int correctAnswerInt = 0;

            switch (operation) {
                case ("*"):
                    correctAnswerInt = randomValue1 * randomValue2;
                    break;
                case ("-"):
                    correctAnswerInt = randomValue1 - randomValue2;
                    break;
                default:
                    correctAnswerInt = randomValue1 + randomValue2;
            }

            questions[qIndex] = randomValue1 + " " + operation + " " + randomValue2;
            answers[qIndex] = Integer.toString(correctAnswerInt);
        }

        Engine.playGame(NOTE, questions, answers);

    }

    private static String getRandomOperation() {
        String[] arr = {"*", "+", "-"};

        return arr[Settings.getRandom(0, 2)];
    }
}
