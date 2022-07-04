package hexlet.code.games;

import java.util.Scanner;

public class Gcd {
    public static boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue1 = Engine.getRandom();
        int randomValue2 = Engine.getRandom();

        int correctAnswer = gcd(randomValue1, randomValue2);
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
