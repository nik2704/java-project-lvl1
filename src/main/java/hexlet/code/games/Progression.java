package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

public final class Progression {
    private static final int MAX_RANDOM_SQUENCE_LENGTH = 15;
    private static final int MIN_RANDOM_SEQUENCE_LENGTH = 6;
    private static final int MAX_RANDOM_SEQUENCE_INCREMENT = 10;
    private static final int MIN_RANDOM_SEQUENCE_INCREMENT = 2;
    private static final int MAX_RANDOM_START_SEQUENCE_POINT = 50;
    private static final int MIN_RANDOM_START_SEQUENCE_POINT = 2;

    private static final String NOTE = "What number is missing in the progression?";

    public static void startGame(String userName) {
        String[][] questionsWithAnswers = new String[Settings.REPEAT_COUNT][2];

        for (int qIndex = 0; qIndex < Settings.REPEAT_COUNT; qIndex++) {
            int[][] sequence = getSequence();

            questionsWithAnswers[qIndex][0] = getQuestionString(sequence);
            questionsWithAnswers[qIndex][1] = Integer.toString(getCorrectAnswer(sequence));
        }

        Engine.playGame(userName, NOTE, questionsWithAnswers, true);

    }

    private static int[][] getSequence() {

        int length =  Settings.getRandom(MIN_RANDOM_SEQUENCE_LENGTH,
                MAX_RANDOM_SQUENCE_LENGTH);

        int maskedSymbolIndex = (int) (Math.random() * length);
        int increment = Settings.getRandom(MIN_RANDOM_SEQUENCE_INCREMENT,
                MAX_RANDOM_SEQUENCE_INCREMENT);

        int[][] sequence = new int[length][2];
        sequence[0][0] = Settings.getRandom(MIN_RANDOM_START_SEQUENCE_POINT,
                MAX_RANDOM_START_SEQUENCE_POINT);

        for (int i = 1; i < length; i++) {
            sequence[i][0] = sequence[i - 1][0] + increment;
            sequence[i][1] = 0;
        }

        sequence[maskedSymbolIndex][1] = 1;

        return sequence;
    }

    private static int getCorrectAnswer(int[][] sequence) {
        for (int[] column : sequence) {
            if (column[1] == 1) {
                return column[0];
            }
        }
        return -1;
    }

    private static String getQuestionString(int[][] sequence) {
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < sequence.length; i++) {

            line.append(sequence[i][1] == 0 ? sequence[i][0] : "..");
            if (i < sequence.length - 1) {
                line.append(" ");
            }
        }

        return line.toString();
    }

}
