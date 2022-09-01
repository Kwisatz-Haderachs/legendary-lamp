import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExpandNum {
    @Test
    public void testSomething() {
        assertEquals("10 + 2", ExpandNum.expandedForm(12));
        assertEquals("40 + 2", ExpandNum.expandedForm(42));
        assertEquals("90000000", ExpandNum.expandedForm(90000000));
        assertEquals("70000 + 300 + 4", ExpandNum.expandedForm(70304));
    }
}
