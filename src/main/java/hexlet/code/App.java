package hexlet.code;

import hexlet.code.env.Settings;

import java.util.Scanner;

public class App {
    public static String[] getGamesArr() {
        String[] games = {"1 - Greet", "2 - Even", "3 - Calc", "4 - GCD", "5 - Progression", "6 - Prime", "0 - Exit"};

        return games;
    }
    public static void main(String[] args) {
        String[] games = App.getGamesArr();
        printMainMenu(games);
        int gameNumber = getGameNumber(games);
        if (gameNumber > 0) {
            if (gameNumber > 0) {
                String userName = Cli.greeting();
                gameSwitcher(gameNumber, userName);
            }
        }

    }

    public static void gameSwitcher(int gameNumber, String userName) {
        switch (gameNumber) {
            case (Settings.GAME_EVEN):
                Engine.startEven(userName);
                break;
            case (Settings.GAME_CALC):
                Engine.startCalc(userName);
                break;
            case (Settings.GAME_GCD):
                Engine.startGcd(userName);
                break;
            case (Settings.GAME_PROGRESSION):
                Engine.startProgression(userName);
                break;
            case (Settings.GAME_PRIME):
                Engine.startPrime(userName);
                break;
            default:
        }
    }
    public static void printMainMenu(String[] games) {
        System.out.println("Please enter the game number and press Enter.");
        for (String game : games) {
            System.out.println(game);
        }
    }
    public static int getGameNumber(String[] games) {
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
}
