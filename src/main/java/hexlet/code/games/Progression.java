package hexlet.code.games;

import hexlet.code.env.Settings;

import java.util.Scanner;

public class Progression {
    public static boolean nextStep(Scanner scanner, int repeatCount) {

        int[][] sequence = Progression.getSequence();
        int correctAnswer = getCorrectAnswer(sequence);

        Engine.printQuestion(getQuestionString(sequence));
        int answer = scanner.nextInt();

        boolean result = (answer == correctAnswer);

        return Engine.analyzeAnswer(result, Integer.toString(answer), Integer.toString(correctAnswer));
    }

    public static int getCorrectAnswer(int[][] sequence) {

        for (int[] column : sequence) {
            if (column[1] == 1) {
                return column[0];
            }
        }
        return -1;
    }

    public static String getQuestionString(int[][] sequence) {
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < sequence.length; i++) {

            line.append(sequence[i][1] == 0 ? sequence[i][0] : "..");
            if (i < sequence.length - 1) {
                line.append(" ");
            }
        }

        return line.toString();
    }
    public static int[][] getSequence() {

        int length =  Engine.getRandom(Settings.MIN_RANDOM_SEQUENCE_LENGTH,
                Settings.MAX_RANDOM_SQUENCE_LENGTH);

        int maskedSymbolIndex = (int) (Math.random() * length);
        int increment = Engine.getRandom(Settings.MIN_RANDOM_SEQUENCE_INCREMENT,
                Settings.MAX_RANDOM_SEQUENCE_INCREMENT);

        int[][] sequence = new int[length][2];
        sequence[0][0] = Engine.getRandom(Settings.MIN_RANDOM_START_SEQUENCE_POINT,
                Settings.MAX_RANDOM_START_SEQUENCE_POINT);

        for (int i = 1; i < length; i++) {
            sequence[i][0] = sequence[i - 1][0] + increment;
            if (i == maskedSymbolIndex) {
                sequence[i][1] = 1;
            } else {
                sequence[i][1] = 0;
            }

        }

        return sequence;
    }

}
