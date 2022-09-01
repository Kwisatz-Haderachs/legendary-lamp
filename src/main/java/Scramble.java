import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Scramble {

    public boolean scramble(String str1, String str2) {
        List<String> first = new ArrayList<>(Arrays.asList(str1.split("")));
        List<String> second = new ArrayList<>(Arrays.asList(str2.split("")));
        Stack<String> stack = new Stack<>();
        for (String search : second) {
            for (String find: first) {
                if(search.equals(find)){
                    stack.push(search);
                    first.remove(find);
                    break;
                }
            }
        }
        return stack.size() == str2.length();
    }

    public static boolean scrambleCW(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        for (String s: str2.split("")) {
            if (!str1.contains(s))  return false;
            str1 = str1.replaceFirst(s,"");
        }

        return true;
    }
}
