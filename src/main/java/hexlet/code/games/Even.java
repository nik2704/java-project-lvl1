package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.env.Settings;

import java.util.Scanner;

public final class Even extends Game {
    public static void start(String userName) {
        Engine.playGame(userName, new Even(), "Answer 'yes' if number even otherwise answer 'no'.");
    }
    public boolean nextStep(Scanner scanner) {
        int randomValue = Settings.getRandom(Settings.MIN_RANDOM_INT, Settings.MAX_RANDOM_INT);
        boolean isEven = randomValue % 2 == 0;

        Settings.printQuestion(Integer.toString(randomValue));
        String userAttempt = scanner.nextLine().toLowerCase();

        this.setCorrectAnswer(isEven ? "yes" : "no");
        this.setUserAnswer(userAttempt);

        return (userAttempt.equals(this.getCorrectAnswer()));
    }
}
