package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Prime extends Game {
    public static final int MAX_RANDOM_START_PRIME = 50;
    public static final int MIN_RANDOM_START_PRIME = 2;
    public static void start(String userName) {
        Engine.playGame(userName, new Prime(), "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
    public boolean nextStep(Scanner scanner, int repeatCount) {
        int randomValue = Settings.getRandom(MIN_RANDOM_START_PRIME, MAX_RANDOM_START_PRIME);
        boolean isPrime = this.isPrimeNumber(randomValue);

        Settings.printQuestion(Integer.toString(randomValue));
        String userAttempt = scanner.nextLine().toLowerCase();

        this.setCorrectAnswer(isPrime ? "yes" : "no");
        this.setUserAnswer(userAttempt);

        return (userAttempt.equals(this.getCorrectAnswer()));
    }

    private boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
