package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    public static void start(String userName) {
        int repeatCount = Engine.REPEAT_COUNT;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the result of the expression?");

        while (repeatCount > 0) {
            int randomValue1 = Engine.getRandom();
            int randomValue2 = Engine.getRandom();
            String operation = getRandomOperation();

            int correctAnswer = operation.equals("*") ? randomValue1 * randomValue2 : randomValue1 + randomValue2;

            Engine.printQuestion(randomValue1 + " " + operation + " " + randomValue2);
            int answer = scanner.nextInt();

            boolean result = answer == correctAnswer;

            repeatCount = Engine.analyzeAnswer(result,
                    Integer.toString(answer),
                    Integer.toString(correctAnswer),
                    repeatCount);
        }

        Engine.printConclusion(repeatCount, userName);
    }

    public static String getRandomOperation() {
        int max = 1;
        int min = 0;
        String[] arr = {"*", "+"};
        int res =  (int) (Math.random() * ++max) + min;

        return arr[res];
    }
}
