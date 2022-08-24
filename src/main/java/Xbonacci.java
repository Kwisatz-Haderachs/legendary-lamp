import java.util.ArrayList;
import java.util.Arrays;

public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {
        // hackonacci me
        ArrayList<Double> exp = new ArrayList<>();
        double[] xb = new double[n];
        for (int i = 0; i < s.length; i++) {
            exp.add(s[i]);
        }
        for (int i = s.length-1; i < n; i++) {
            exp.add(exp.get(i-2) + exp.get(i-1) + exp.get(i));
        }
        for (int i = 0; i < xb.length; i++) {
            xb[i] = exp.get(i);
        }
        return xb;
    }

    public double[] tribonacciCW(double[] s, int n) {

        double[] tritab= Arrays.copyOf(s, n);
        for(int i=3;i<n;i++){
            tritab[i]=tritab[i-1]+tritab[i-2]+tritab[i-3];
        }
        return tritab;

    }
}
