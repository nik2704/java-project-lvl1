package hexlet.code;

import hexlet.code.env.Settings;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import hexlet.code.games.Game;



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
        Even even = new Even();
        String msg = "Answer 'yes' if number even otherwise answer 'no'.";
        playGame(userName, even, msg);
    }

    public static void startCalc(String userName) {
        Calc calc = new Calc();
        String msg = "What is the result of the expression?";
        playGame(userName, calc, msg);
    }

    public static void startGcd(String userName) {
        Gcd gcd = new Gcd();
        String msg = "Find the greatest common divisor of given numbers.";
        playGame(userName, gcd, msg);
    }

    public static void startProgression(String userName) {
        Progression progression = new Progression();
        String msg = "What number is missing in the progression?";
        playGame(userName, progression, msg);
    }

    public static void startPrime(String userName) {
        Prime prime = new Prime();
        String msg = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        playGame(userName, prime, msg);
    }

    public static void playGame(String userName, Game game, String msg) {
        Scanner scanner = new Scanner(System.in);
        int repeatCount = Settings.REPEAT_COUNT;

        boolean stepResult = true;
        System.out.println(msg);
        while (stepResult && (repeatCount > 0)) {
            stepResult = game.nextStep(scanner, repeatCount);
            if (stepResult) {
                repeatCount--;
            }
        }

        printConclusion(repeatCount, userName);
    }
}
