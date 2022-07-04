package hexlet.code.games;

import java.util.Scanner;

public final class Even {

    public static boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue = Engine.getRandom();
        boolean isEven = randomValue % 2 == 0;

        Engine.printQuestion(Integer.toString(randomValue));
        String answer = scanner.nextLine().toLowerCase();

        boolean result = isEven ? (answer.equals("yes")) : (answer.equals("no"));

        String correctAnswer = isEven ? "yes" : "no";

        return Engine.analyzeAnswer(result, answer, correctAnswer);
    }

}
