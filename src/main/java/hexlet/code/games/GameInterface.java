package hexlet.code.games;

import java.util.Scanner;

public interface GameInterface {
    boolean nextStep(Scanner scanner);
    String getUserAnswer();

    String getCorrectAnswer();

    void setUserAnswer(String answer);

    void setCorrectAnswer(String correctAnswer);
}
