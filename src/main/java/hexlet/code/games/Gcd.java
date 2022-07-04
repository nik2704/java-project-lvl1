package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Gcd implements Game {
    public boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue1 = Engine.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        int randomValue2 = Engine.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);

        int correctAnswer = Gcd.gcd(randomValue1, randomValue2);
        Engine.printQuestion(randomValue1 + " " + randomValue2);

        int answer = scanner.nextInt();

        boolean result = answer == correctAnswer;
        return Engine.analyzeAnswer(result,
                Integer.toString(answer),
                Integer.toString(correctAnswer));
    }

    private static int gcd(int n1, int n2) {
        int result = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                result = i;
            }
        }
        return result;
    }
}
