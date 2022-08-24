import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestXbonacci {
    @Test
    public void basicFib(){
        Xbonacci xbonacci = new Xbonacci();
        assertEquals(105.0, xbonacci.tribonacci(new double[]{1,1,1},10)[9]);
    }
}
