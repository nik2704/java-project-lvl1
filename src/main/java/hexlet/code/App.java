package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static final int GAME_EVEN = 2;
    public static final int GAME_CALC = 3;
    public static final int GAME_GCD = 4;
    public static final int GAME_PROGRESSION = 5;
    public static final int GAME_PRIME = 6;
    private static final String[] GAMES = {
        "1 - Greet",
        "2 - Even",
        "3 - Calc",
        "4 - GCD",
        "5 - Progression",
        "6 - Prime",
        "0 - Exit"
    };

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        for (String game : GAMES) {
            System.out.println(game);
        }

        int gameNumber = getGameNumber(GAMES);
        if (gameNumber > 0) {
            if (gameNumber > 0) {
                String userName = Cli.greeting();
                gameSwitcher(gameNumber, userName);
            }
        }

    }

    private static int getGameNumber(String[] games) {
        int gameNumber;

        while (true) {
            System.out.print("Your choice: ");
            Scanner scanner = new Scanner(System.in);
            gameNumber = scanner.nextInt();
            if (gameNumber >= 0 && gameNumber < games.length) {
                break;
            } else {
                System.out.println("There if no such game");
            }
        }

        return gameNumber;
    }

    public static void gameSwitcher(int gameNumber, String userName) {
        switch (gameNumber) {
            case (GAME_EVEN):
                Even.start(userName);
                break;
            case (GAME_CALC):
                Calc.start(userName);
                break;
            case (GAME_GCD):
                Gcd.start(userName);
                break;
            case (GAME_PROGRESSION):
                Progression.start(userName);
                break;
            case (GAME_PRIME):
                Prime.start(userName);
                break;
            default:
        }
    }

}
