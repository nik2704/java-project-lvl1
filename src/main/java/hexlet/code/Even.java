package hexlet.code;

import java.util.Scanner;

public final class Even {
    public static final int MAX_RANDOM_INT = 1000;
    public static final int MIN_RANDOM_INT = 10;
    public static final int REPEAT_COUNT = 3;

    private int getRandom() {
        int max = Even.MAX_RANDOM_INT;
        int min = Even.MIN_RANDOM_INT;

        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public void start(String userName) {
        int repeatCount = Even.REPEAT_COUNT;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        while (repeatCount > 0) {
            int randomValue = getRandom();
            System.out.print("Question: ");
            System.out.println(randomValue);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().toLowerCase();

            boolean isEven = randomValue % 2 == 0;
            boolean result = isEven == (answer.equals("yes"));
            String correctAnswer = isEven ? "yes" : "no";

            if (result) {
                System.out.println("Correct!");
                repeatCount--;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                break;
            }
        }

        if (repeatCount == 0) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
