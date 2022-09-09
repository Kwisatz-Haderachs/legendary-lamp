package testCodeWars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSpinWords {
    public SpinWords spin;
    @BeforeEach
    public void init(){
        spin = new SpinWords();
    }
    @Test
    public void test() {
        assertEquals("emocleW", spin.spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", spin.spinWords("Hey fellow warriors"));
    }
}
