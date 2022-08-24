
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.toBinaryString;
import static java.lang.String.valueOf;

public class HammeringCode {

    public String encodeCW(String text) {
        StringBuilder ret = new StringBuilder();
        for (char c : text.toCharArray()) ret.append(String.format("%08d", parseInt(toBinaryString(c))));
        return ret.toString().replace("0", "000").replace("1", "111");
    }

    public String decodeCW(String bits) {
        StringBuilder sb = new StringBuilder(), ret = new StringBuilder();
        for (String t : bits.split("(?<=\\G...)")) sb.append("000|001|010|100".contains(t) ? "0" : "1");
        for (String c : sb.toString().split("(?<=\\G.{8})")) ret.append(valueOf((char)parseInt(c, 2)));
        return ret.toString();
    }

    public static String encode(String text) {
        List<String> lst = Arrays.asList(text.split(""));
        StringBuilder base = new StringBuilder();
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < lst.size(); i++) {
            //int ascii = lst.get(i).charAt(0);
            String ascii = Integer.toBinaryString(lst.get(i).charAt(0));
            while(ascii.length()<8){
                ascii = "0"+ ascii;
            }
            base.append(ascii);
        }
        for (int i = 0; i < base.length(); i++) {
            bits.append(base.charAt(i)).append(base.charAt(i)).append(base.charAt(i));
        }
        //System.out.println(bits.toString());
        return bits.toString();
        //"000111111000111000000000000111111000000111000111000111111111111000000111"
    }
    public static String decode(String bits) {
        //"100111111000111001000010000111111000000111001111000111110110111000010111" -> hey
        StringBuilder result = new StringBuilder();
        StringBuilder base = new StringBuilder();
        //System.out.println(bits.length());
        for (int i = 2; i < bits.length(); i+=3) {
            char x = bits.charAt(i-2);
            char y = bits.charAt(i-1);
            char z = bits.charAt(i);
            if((x != y) && (y == z)){ //first flipped
               base.append(z);
            } else if (x == z) {  //second flipped
                base.append(x);
            } else if (x==y) { //third flipped
                base.append(x);
            }
        }
        System.out.println(base);
        for (int i = 0; i < base.length(); i+=8) {
            int a = (parseInt(base.substring(i,i+8), 2));
            char b = (char) a;
            result.append(b);
        }
        return result.toString();
    }
}

