package hexlet.code.games;

import java.util.Scanner;

public final class Even {

    public void start(String userName) {
        int repeatCount = Engine.REPEAT_COUNT;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        while (repeatCount > 0) {
            int randomValue = Engine.getRandom();
            System.out.print("Question: ");
            System.out.println(randomValue);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().toLowerCase();

            boolean isEven = randomValue % 2 == 0;

            boolean result = isEven ? (answer.equals("yes")) : false;

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
