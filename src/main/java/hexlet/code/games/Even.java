package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Even implements Game {

    public boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue = Engine.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        boolean isEven = randomValue % 2 == 0;

        Engine.printQuestion(Integer.toString(randomValue));
        String answer = scanner.nextLine().toLowerCase();

        String correctAnswer = isEven ? "yes" : "no";
        boolean result = (answer.equals(correctAnswer));

        return Engine.analyzeAnswer(result, answer, correctAnswer);
    }

}
