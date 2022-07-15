package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Utils;

public final class Progression {
    private static final int MAX_RANDOM_SEQUENCE_LENGTH = 15;
    private static final int MIN_RANDOM_SEQUENCE_LENGTH = 6;
    private static final int MAX_RANDOM_SEQUENCE_INCREMENT = 10;
    private static final int MIN_RANDOM_SEQUENCE_INCREMENT = 2;
    private static final int MAX_RANDOM_START_SEQUENCE_POINT = 50;
    private static final int MIN_RANDOM_START_SEQUENCE_POINT = 2;

    private static final String NOTE = "What number is missing in the progression?";

    public static void startGame() {
        String[][] questionsWithAnswers = new String[2][Engine.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Engine.REPEAT_COUNT; qIndex++) {
            int[] sequence = getSequence(
                    Utils.getRandom(MIN_RANDOM_START_SEQUENCE_POINT, MAX_RANDOM_START_SEQUENCE_POINT),
                    Utils.getRandom(MIN_RANDOM_SEQUENCE_INCREMENT, MAX_RANDOM_SEQUENCE_INCREMENT),
                    Utils.getRandom(MIN_RANDOM_SEQUENCE_LENGTH, MAX_RANDOM_SEQUENCE_LENGTH)
            );
            int answerIndex = Utils.getRandom(0, sequence.length - 1);

            questionsWithAnswers[0][qIndex] = getQuestionString(sequence, answerIndex);
            questionsWithAnswers[1][qIndex] = String.valueOf(sequence[answerIndex]);
        }

        Engine.playGame(NOTE, questionsWithAnswers);
    }

    private static int[] getSequence(int firstValue, int step, int length) {
        int[] sequence = new int[length];
        sequence[0] = firstValue;

        for (int i = 1; i < length; i++) {
            sequence[i] = sequence[i - 1] + step;
        }

        return sequence;
    }

    private static String getQuestionString(int[] sequence, int answerIndex) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sequence.length; i++) {
            result.append(answerIndex != i ? String.valueOf(sequence[i]) : "..");

            if (i < sequence.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

}
