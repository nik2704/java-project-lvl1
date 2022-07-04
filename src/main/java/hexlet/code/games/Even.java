package hexlet.code.games;

import java.util.Scanner;

public final class Even {

    public static void start(String userName) {
        int repeatCount = Engine.REPEAT_COUNT;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");

        while (repeatCount > 0) {
            int randomValue = Engine.getRandom();
            boolean isEven = randomValue % 2 == 0;

            Engine.printQuestion(Integer.toString(randomValue));

            String answer = scanner.nextLine().toLowerCase();

            boolean result = isEven ? (answer.equals("yes")) : (answer.equals("no"));

            String correctAnswer = isEven ? "yes" : "no";

            repeatCount = Engine.analyzeAnswer(result,
                    answer,
                    correctAnswer,
                    repeatCount);
        }

        Engine.printConclusion(repeatCount, userName);
    }
}
