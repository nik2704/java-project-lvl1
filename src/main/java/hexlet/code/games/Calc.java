package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Calc implements Game {
    public boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue1 = Engine.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        int randomValue2 = Engine.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        String operation = Calc.getRandomOperation();

        int correctAnswer = operation.equals("*") ? randomValue1 * randomValue2 : randomValue1 + randomValue2;

        Engine.printQuestion(randomValue1 + " " + operation + " " + randomValue2);
        int answer = scanner.nextInt();

        boolean result = answer == correctAnswer;
        return Engine.analyzeAnswer(result,
                Integer.toString(answer),
                Integer.toString(correctAnswer));
    }

    public static String getRandomOperation() {
        int max = 1;
        int min = 0;
        String[] arr = {"*", "+"};
        int res =  (int) (Math.random() * ++max) + min;

        return arr[res];
    }
}
