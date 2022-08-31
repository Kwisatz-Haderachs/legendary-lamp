import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Brackets {
    String[] openingBrackets = {"(", "[", "{"};

    public boolean isValid(String braces) {
        String[] brakes = braces.split("");

        //check paren
        for (String openingBracket : openingBrackets) {
            for (int j = 0; j < brakes.length; j++) {
                if (brakes[j].equals(openingBracket)) {
                    int x = (numOpening(j, brakes) * 2) +1;
                    if (x >= brakes.length) {
                        return false;
                    }
                    System.out.println("X is: " + x);
                    if (!brakes[j + x].equals(openingBracket)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public int numOpening(int i, String[] b){
        int count = 0;
        for (int j = i; j < b.length; j++) {
            if(!isOpening(b[j])){
                return count;
            }
            count++;
        }
        return count;
    }

    private boolean isOpening(String j) {
        return j.equals(openingBrackets[0]) || j.equals(openingBrackets[1]) || j.equals(openingBrackets[2]);
    }
}
