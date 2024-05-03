package edu.vassar.cmpu203.batonpass;

import org.junit.Test;

import static org.junit.Assert.*;

import edu.vassar.cmpu203.batonpass.model.Character;
import edu.vassar.cmpu203.batonpass.model.Enemy;
import edu.vassar.cmpu203.batonpass.model.Jackpot;
import edu.vassar.cmpu203.batonpass.model.JackpotState;
import edu.vassar.cmpu203.batonpass.model.MainCharacter;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SpinnerUnitTest {

    /**
     * Play through route where player defeats Vin and is given a choice about what to say to vin.
     */
    @Test
    public void TargetSymbolTest() {

        final Jackpot j = new Jackpot();

        j.startSpin();
        char[] arr = j.getRandomSymbols();
        String symbol;
        for(int i = 0; i < arr.length; i++) {
            symbol = String.valueOf(arr[i]);
            if (symbol.equals(String.valueOf(j.getTargetSymbol()))){
                assertTrue(symbol.equals(String.valueOf(j.getTargetSymbol())));
            }
        }
    }
    @Test
    public void CharacterSkillTest() {

        Character MC = new MainCharacter(10, 10, "MC");

        Character enemy = new Enemy(10, 10, "Enemy");

        assertEquals(MC.getSkill(), 10);
        assertEquals(MC.getHealth(), 10);
        assertEquals(enemy.getSkill(), 10);
        assertEquals(enemy.getSkill(), 10);

        MC.changeSkill(5);
        assertEquals(MC.getSkill(), 15);

        MC.changeSkill(-10);
        assertEquals(MC.getSkill(), 5);

        MC.decreaseHealth(5);
        assertEquals(MC.getHealth(), 5);

        MC.attack(enemy);

        assertEquals(enemy.getHealth(), 5);
        //attack for enemy is random, we do not know how to test

    }

    @Test
    public void JackpotStateTest(){
        final Jackpot j = new Jackpot();

        Character MC = new MainCharacter(10, 10, "MC");

        Character enemy = new Enemy(10, 10, "Enemy");

        j.startSpin();
        assertEquals(j.getState(), JackpotState.SPINNING);
        //end spin rely on mainactivity
        //call attack is based on end spin
        //have to make a method to change state, but are afraid of side effect
    }
}