import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Brackets {
    String[] openingBrackets = {"(", "[", "{"};


    public boolean isValid(String braces) {
        String[] brakes = braces.split("");
        HashMap<String, String>  openClose = new HashMap<>();
        openClose.put("(", ")");
        openClose.put("{", "}");
        openClose.put("[", "]");
        if(!isOpening(brakes[0])){return false;}
        //check paren
        for (String openingBracket : openingBrackets) {
            for (int j = 0; j < brakes.length; j++) {
                if (brakes[j].equals(openingBracket)) {
                    String close = openClose.get(openingBracket);
                    int c = numOpening(j, brakes);
                    if(j+c*2 - 1 > brakes.length-1){
                        return false;
                    }
                    if (!brakes[j+c*2-1].equals(close)) {
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

    public boolean isValidCW(String braces) {
        Stack<Character> s = new Stack<>();
        for (char c : braces.toCharArray())
            if (s.size() > 0 && isClosing(s.peek(), c)) s.pop();
            else s.push(c);
        return s.size() == 0;
    }

    public boolean isClosing(char x, char c) {
        return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
    }
}
