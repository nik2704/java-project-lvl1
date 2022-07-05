package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;
import java.util.Scanner;

public final class Progression extends Game {
    public static final int MAX_RANDOM_SQUENCE_LENGTH = 15;
    public static final int MIN_RANDOM_SEQUENCE_LENGTH = 6;
    public static final int MAX_RANDOM_SEQUENCE_INCREMENT = 10;
    public static final int MIN_RANDOM_SEQUENCE_INCREMENT = 2;
    public static final int MAX_RANDOM_START_SEQUENCE_POINT = 50;
    public static final int MIN_RANDOM_START_SEQUENCE_POINT = 2;
    public static void start(String userName) {
        Engine.playGame(userName, new Progression(), "What number is missing in the progression?");
    }
    public boolean nextStep(Scanner scanner, int repeatCount) {

        int[][] sequence = this.getSequence();
        int correctAnswerInt = this.getCorrectAnswer(sequence);

        Settings.printQuestion(this.getQuestionString(sequence));
        int userAttempt = scanner.nextInt();

        this.setCorrectAnswer(Integer.toString(correctAnswerInt));
        this.setUserAnswer(Integer.toString(userAttempt));

        return (userAttempt == correctAnswerInt);
    }

    private int[][] getSequence() {

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

    private int getCorrectAnswer(int[][] sequence) {
        for (int[] column : sequence) {
            if (column[1] == 1) {
                return column[0];
            }
        }
        return -1;
    }

    private String getQuestionString(int[][] sequence) {
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
