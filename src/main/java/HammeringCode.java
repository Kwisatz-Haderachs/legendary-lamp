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
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < lst.size(); i++) {
            ByteBuffer buf = ByteBuffer.allocate(Integer.BYTES);
            buf.put(lst.get(i).getBytes(StandardCharsets.US_ASCII));
            buf.rewind();
            int value = buf.getInt();
            bits.append(value).append(value).append(value);
        }
        System.out.println(bits.toString());
//        IntStream intStream;
//        sb.collect(lst.stream().forEach(i ->i.getBytes(StandardCharsets.US_ASCII)));
//        IntStream intStream = text.chars();
//        intStream.mapToObj(i->text.chars().toString().getBytes(StandardCharsets.US_ASCII));

        // IntStream = Arrays.asList(text.split("")).stream().tomapToObj(i -> l1.get(i) + l2.get(i)).collect(Collectors.toList()));
        return bits.toString();
    }
    public String decode(String bits) {
        String text = " ";
        return text;
    }
}
