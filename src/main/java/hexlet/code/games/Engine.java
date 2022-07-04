package hexlet.code.games;

public final class Engine {
    public static final int MAX_RANDOM_INT = 20;
    public static final int MIN_RANDOM_INT = 1;
    public static final int REPEAT_COUNT = 3;
    public static final int GAME_EVEN = 2;
    public static final int GAME_CALC = 3;

    public static void printQuestion(String question) {
        System.out.print("Question: ");
        System.out.println(question);
        System.out.print("Your answer: ");
    }
    public static int getRandom() {
        int max = Engine.MAX_RANDOM_INT;
        int min = Engine.MIN_RANDOM_INT;

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

    public static int analyzeAnswer(boolean result, String userAnswer, String correctAnswer, int repeatCount) {
        if (result) {
            System.out.println("Correct!");
            repeatCount--;
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            repeatCount = -1;
        }

        return repeatCount;
    }
}
