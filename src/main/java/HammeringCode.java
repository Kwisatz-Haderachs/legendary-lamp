import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HammeringCode {

    public static void main(String[] args) {
        encode("hey");
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
    public String decode(String bits) {
        String text = " ";
        return text;
    }
}
