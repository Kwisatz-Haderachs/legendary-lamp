import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QueueCalc {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] tills = new int[n];
        for (int i = 0; i < customers.length; i++) {
            tills[0] += customers[i];
            Arrays.sort(tills);
        }
        return tills[n-1];
    }

}
