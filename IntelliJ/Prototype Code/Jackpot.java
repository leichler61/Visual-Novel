import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Jackpot{
    char[] RandomSymbols = new char[10];
    char TargetSymbol;
    char HitSymbol;
    LocalDateTime StartingTime;
    LocalDateTime EndTime;
    int SecondsElapsed;
    Scanner s = new Scanner(System.in);
    JackpotState state;

    public void startSpin() {
        StartingTime = LocalDateTime.now();

        int[] AsciiTable = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 1117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127};

        // list of created 10 random symbols
        for (int i = 0; i < 10; i++) {
            RandomSymbols[i] = ((char) AsciiTable[(int) (Math.random() * AsciiTable.length)]);
        }

        // target symbol that player must hit for the jackpot selected from the 10 RandomSymbols
        TargetSymbol = RandomSymbols[(int) (Math.random() * RandomSymbols.length)];

        this.state = JackpotState.SPINNING;
    }

    public void endSpin() {

        EndTime = LocalDateTime.now();
        Duration TimeElapsed = Duration.between(StartingTime, EndTime);
        SecondsElapsed = (int) (TimeElapsed.getSeconds());

        int TotalIterationThroughRandomSymbols = (SecondsElapsed / 3);
        int FinalIndexForRandomSymbols = ((TotalIterationThroughRandomSymbols % 10));
        HitSymbol = RandomSymbols[FinalIndexForRandomSymbols];

        if (TargetSymbol == HitSymbol) {
            this.state = JackpotState.HIT;
        } else {
            this.state = JackpotState.MISS;
        }
    }
    public void callAttack(Character c1, Character c2) {
        if(this.state == JackpotState.HIT)
            c1.changeSkill(5);
        else
            c1.changeSkill(-5);
        c1.attack(c2);
        UI.attackDisplay(c1.getSkill(), c1, c2);
    }
}