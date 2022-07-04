package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String[] games = {"1 - Greet", "2 - Even", "3 - Calc", "0 - Exit"};
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
            case (2):
                Even even = new Even();
                even.start(userName);
                break;
//               case (3):
//                   break;
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
