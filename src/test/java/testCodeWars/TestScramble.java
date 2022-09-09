package testCodeWars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestScramble {

    @Test
    void testOne(){
        Scramble s = new Scramble();
        assertFalse(s.scramble("oooommmmm", "ooooom"));
        assertTrue(s.scramble("rkqodlw", "world"));
        assertTrue(s.scramble("codeagadwars","codewars"));
        assertFalse(s.scramble("katas", "steak"));
    }
}
