package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Utils;

public final class Calc {
    public static final int MIN_RANDOM_INT = 10;
    public static final int MAX_RANDOM_INT = 50;
    private static final String NOTE = "What is the result of the expression?";

    public static void startGame() {
        String[][] questionsWithAnswers = new String[2][Engine.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Engine.REPEAT_COUNT; qIndex++) {
            int randomValue1 = Utils.getRandom(MIN_RANDOM_INT, MAX_RANDOM_INT);
            int randomValue2 = Utils.getRandom(MIN_RANDOM_INT, MAX_RANDOM_INT);
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

            questionsWithAnswers[0][qIndex] = randomValue1 + " " + operation + " " + randomValue2;
            questionsWithAnswers[1][qIndex] = Integer.toString(correctAnswerInt);
        }

        Engine.playGame(NOTE, questionsWithAnswers);

    }

    private static String getRandomOperation() {
        String[] operationsList = {"*", "+", "-"};

        return operationsList[Utils.getRandom(0, operationsList.length - 1)];
    }
}
