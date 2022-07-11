package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Arrays;

public final class Progression {
    private static final int MAX_RANDOM_SEQUENCE_LENGTH = 15;
    private static final int MIN_RANDOM_SEQUENCE_LENGTH = 6;
    private static final int MAX_RANDOM_SEQUENCE_INCREMENT = 10;
    private static final int MIN_RANDOM_SEQUENCE_INCREMENT = 2;
    private static final int MAX_RANDOM_START_SEQUENCE_POINT = 50;
    private static final int MIN_RANDOM_START_SEQUENCE_POINT = 2;

    private static final String NOTE = "What number is missing in the progression?";

    public static void startGame() {
        String[] questions = new String[Settings.REPEAT_COUNT];
        String[] answers = new String[Settings.REPEAT_COUNT];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int[] sequence = getSequence();
            int answerIndex = Settings.getRandom(0, sequence.length - 1);

            answers[qIndex] = String.valueOf(sequence[answerIndex]);
            questions[qIndex] = getQuestionString(sequence, answerIndex);
        }

        System.out.println(Arrays.toString(questions));
        System.out.println(Arrays.toString(answers));
        Engine.playGame(NOTE, questions, answers);

    }

    private static int[] getSequence() {
        int length =  Settings.getRandom(MIN_RANDOM_SEQUENCE_LENGTH,
                MAX_RANDOM_SEQUENCE_LENGTH);

        int increment = Settings.getRandom(MIN_RANDOM_SEQUENCE_INCREMENT,
                MAX_RANDOM_SEQUENCE_INCREMENT);

        int[] sequence = new int[length];
        sequence[0] = Settings.getRandom(MIN_RANDOM_START_SEQUENCE_POINT,
                MAX_RANDOM_START_SEQUENCE_POINT);

        for (int i = 1; i < length; i++) {
            sequence[i] = sequence[i - 1] + increment;
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
