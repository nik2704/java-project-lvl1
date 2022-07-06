package hexlet.code.games;

import java.util.Scanner;

public abstract class Game implements GameInterface {
    private String correctAnswer;
    private String answer;

    public abstract boolean nextStep(Scanner scanner);

    public final String getUserAnswer() {
        return this.answer;
    }

    public final String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public final void setUserAnswer(String userAnswer) {
        this.answer = userAnswer;
    }

    public final void setCorrectAnswer(String correctAnswerSystem) {
        this.correctAnswer = correctAnswerSystem;
    }
}
