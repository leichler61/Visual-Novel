import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class UI {

    public static void introduction() {
        System.out.println("Welcome to a minigame!");
        System.out.println("To attack your opponent, you will need to play the jackpot...");
        System.out.println("...and hit the target!");
        System.out.println("<Stop the spinning jackpot at the right time to land on the intended target.>");
    }

    public static void attackDisplay(int a, Character c1, Character c2) {
        System.out.println(c1.getName() + " now has a skill level of " + a + ".");
        System.out.println(c1.getName() + " attacked " + c2.getName() + " with skill " + a + "!");
        System.out.println(c2.getName() + " now has " + c2.getHealth() + " health!\n");
    }

    public static void displaySpin(char[] randomSymbols, char targetSymbol, LocalDateTime startingTime){
        Scanner s = new Scanner(System.in);

        System.out.println("\nJackpot Spins!");
        System.out.println("Symbols rotate every 3 seconds.");
        System.out.println("This is the list of random symbols:");
        System.out.println(Arrays.toString(randomSymbols));
        System.out.println("Target Symbol: " + targetSymbol);
        System.out.println("Starting Time: " + startingTime.toString());
        System.out.println("Press s + Enter to stop the spin.");
        s.nextLine();

    }
    public static void displayHit(LocalDateTime endTime, int secondsElapsed, char hitSymbol){
        System.out.println("Ending Time: " + endTime.toString());
        System.out.println("Seconds Elapsed: " + secondsElapsed);
        System.out.println("Hit Symbol: " + hitSymbol);
        System.out.println("Hit!\n");
    }

    public static void displayMiss(LocalDateTime endTime, int secondsElapsed, char hitSymbol){
        System.out.println("Ending Time: " + endTime.toString());
        System.out.println("Seconds Elapsed: " + secondsElapsed);
        System.out.println("Hit Symbol: " + hitSymbol);
        System.out.println("Miss!\n");
    }
}
