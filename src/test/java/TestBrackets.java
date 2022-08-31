import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBrackets {
    @Test
    void isFalse(){
        Brackets b = new Brackets();
        assertFalse(b.isValid("{{{{}}}"));
        assertFalse(b.isValid("[({})](]"));
    }
    @Test
    void isTrue(){
        Brackets b = new Brackets();
        assertTrue(b.isValid("([{}])"));
        assertTrue(b.isValid("[]{}()"));
    }
}
