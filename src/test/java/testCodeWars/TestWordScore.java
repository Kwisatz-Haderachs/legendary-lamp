package testCodeWars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWordScore {

    @Test
    public void sampleTests() {
        assertEquals("taxi", WordScore.high("man i need a taxi up to ubud"));
        assertEquals("volcano", WordScore.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", WordScore.high("take me to semynak"));
    }
}
