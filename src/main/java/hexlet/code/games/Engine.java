package hexlet.code.games;

import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Engine {

    public static void printQuestion(String question) {
        System.out.print("Question: ");
        System.out.println(question);
        System.out.print("Your answer: ");
    }
    public static int getRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static void printConclusion(int repeatCount, String userName) {
        if (repeatCount == 0) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

    public static boolean analyzeAnswer(boolean result, String userAnswer, String correctAnswer) {
        if (result) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            return false;
        }
    }

    public static void startEven(String userName) {
        Scanner scanner = new Scanner(System.in);
        int repeatCount = Settings.REPEAT_COUNT;

        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");

        boolean stepResult = true;
        while (stepResult && (repeatCount > 0)) {
            stepResult = Even.nextStep(scanner, repeatCount);
            if (stepResult) {
                repeatCount--;
            }
        }

        printConclusion(repeatCount, userName);
    }

    public static void startCalc(String userName) {
        Scanner scanner = new Scanner(System.in);
        int repeatCount = Settings.REPEAT_COUNT;

        System.out.println("What is the result of the expression?");

        boolean stepResult = true;
        while (stepResult && (repeatCount > 0)) {
            stepResult = Calc.nextStep(scanner, repeatCount);
            if (stepResult) {
                repeatCount--;
            }
        }

        printConclusion(repeatCount, userName);
    }

    public static void startGcd(String userName) {
        Scanner scanner = new Scanner(System.in);
        int repeatCount = Settings.REPEAT_COUNT;

        System.out.println("Find the greatest common divisor of given numbers.");

        boolean stepResult = true;
        while (stepResult && (repeatCount > 0)) {
            stepResult = Gcd.nextStep(scanner, repeatCount);
            if (stepResult) {
                repeatCount--;
            }
        }

        printConclusion(repeatCount, userName);
    }

    public static void startProgression(String userName) {
        Scanner scanner = new Scanner(System.in);
        int repeatCount = Settings.REPEAT_COUNT;

        boolean stepResult = true;
        System.out.println("What number is missing in the progression?");
        while (stepResult && (repeatCount > 0)) {
            stepResult = Progression.nextStep(scanner, repeatCount);
            if (stepResult) {
                repeatCount--;
            }
        }

        printConclusion(repeatCount, userName);
    }

    public static void startPrime(String userName) {
        Scanner scanner = new Scanner(System.in);
        int repeatCount = Settings.REPEAT_COUNT;

        boolean stepResult = true;
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (stepResult && (repeatCount > 0)) {
            stepResult = Prime.nextStep(scanner, repeatCount);
            if (stepResult) {
                repeatCount--;
            }
        }

        printConclusion(repeatCount, userName);
    }
}
