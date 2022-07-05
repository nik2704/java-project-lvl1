package hexlet.code.env;

public class Settings {
    public static final int MAX_RANDOM_INT = 50;
    public static final int MIN_RANDOM_INT = 10;
    public static final int REPEAT_COUNT = 3;

    public static void printQuestion(String question) {
        System.out.print("Question: ");
        System.out.println(question);
        System.out.print("Your answer: ");
    }
    public static int getRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
