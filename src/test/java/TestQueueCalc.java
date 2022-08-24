import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQueueCalc {
    @Test
    public void testNormalCondition() {
        assertEquals(9, QueueCalc.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, QueueCalc.solveSuperMarketQueue(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, QueueCalc.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
    }
}
