package hexlet.code.games;

public final class Engine {
    public static final int MAX_RANDOM_INT = 1000;
    public static final int MIN_RANDOM_INT = 10;
    public static final int REPEAT_COUNT = 3;

    public static int getRandom() {
        int max = Engine.MAX_RANDOM_INT;
        int min = Engine.MIN_RANDOM_INT;

        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
