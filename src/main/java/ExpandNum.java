import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpandNum {
    public static String expandedForm(int num) {
        StringBuilder sb = new StringBuilder();
        String[] s = (num+"").split("");
        for (int i = 0; i < s.length; i++) {
            if(!s[i].equals("0")){
                sb.append(s[i]);
                if(i != s.length-1){
                    sb.append("0".repeat(Math.max(0, s.length - 1 - i)));
                    if (!s[s.length-1].equals("0")) {
                        sb.append(" + ");
                    }
                }
            }
        }
        return sb.toString();
    }
    public static String expandedFormCW(int num)
    {
        return IntStream.range(0, String.valueOf(num).length())
                .mapToObj(x -> String.valueOf( Character.getNumericValue(String.valueOf(num).charAt(x) ) * (int)Math.pow(10, String.valueOf(num).substring(x).length()-1)))
                .filter(x -> !x.equals("0"))
                .collect(Collectors.joining(" + "));
    }
}
