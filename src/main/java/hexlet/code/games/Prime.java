package hexlet.code.games;

import hexlet.code.env.Settings;

import java.util.Scanner;

public class Prime {
    public static boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue = Engine.getRandom(Settings.MIN_RANDOM_START_PRIME, Settings.MAX_RANDOM_START_PRIME);
        boolean isPrime = isPrimeNumber(randomValue);

        Engine.printQuestion(Integer.toString(randomValue));
        String answer = scanner.nextLine().toLowerCase();

        String correctAnswer = isPrime ? "yes" : "no";
        boolean result = (answer.equals(correctAnswer));

        return Engine.analyzeAnswer(result, answer, correctAnswer);
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
