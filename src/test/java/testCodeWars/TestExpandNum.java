package testCodeWars;

import org.junit.jupiter.api.Test;

import static codeWars.codeWars.expandedForm;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExpandNum {
    @Test
    public void testSomething() {
        assertEquals("10 + 2", expandedForm(12));
        assertEquals("40 + 2", expandedForm(42));
        assertEquals("90000000", expandedForm(90000000));
        assertEquals("70000 + 300 + 4", expandedForm(70304));
    }
}
