import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Call introduction() to introduce the minigame from the UI class
        UI.introduction();
        // Call startSpin() to spin the jackpot from the Jackpot class with two sample characters, MC & Enemy
        Jackpot j = new Jackpot();
        Character MC = new MC(10, 10, "MC");
        Character enemy = new Enemy(10, 10, "Enemy");
        while(enemy.getHealth() > 0 && MC.getHealth() > 0) {
            j.startSpin();
            if (j.state == JackpotState.SPINNING) {
                UI.displaySpin(j.RandomSymbols, j.TargetSymbol, j.StartingTime);
                j.endSpin();
            } if (j.state == JackpotState.HIT) {
                UI.displayHit(j.EndTime, j.SecondsElapsed, j.HitSymbol);
            } if (j.state == JackpotState.MISS) {
                UI.displayHit(j.EndTime, j.SecondsElapsed, j.HitSymbol);
            }

            j.callAttack(MC, enemy);
            if(enemy.getHealth() > 0) {
                enemy.attack(MC);
                UI.attackDisplay(enemy.getSkill(), enemy, MC);
            }
        }
        if (MC.getHealth() <= 0)
            System.out.println("\nYou lost!");
        else
            System.out.println("\nYou won!");
    }
}