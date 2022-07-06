package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Calc extends Game {
    public static void start(String userName) {
        Engine.playGame(userName, new Calc(), "What is the result of the expression?");
    }
    public boolean nextStep(Scanner scanner) {
        int randomValue1 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        int randomValue2 = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        String operation = this.getRandomOperation();

        int correctAnswerInt = operation.equals("*") ? randomValue1 * randomValue2 : randomValue1 + randomValue2;

        Settings.printQuestion(randomValue1 + " " + operation + " " + randomValue2);
        int userAttempt = scanner.nextInt();


        this.setCorrectAnswer(Integer.toString(correctAnswerInt));
        this.setUserAnswer(Integer.toString(userAttempt));

        return userAttempt == correctAnswerInt;
    }

    private String getRandomOperation() {
        String[] arr = {"*", "+"};

        return arr[Settings.getRandom(0, 1)];
    }
}
