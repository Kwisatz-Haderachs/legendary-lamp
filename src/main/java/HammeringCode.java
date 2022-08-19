import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HammeringCode {
    public String encode(String text) {
        IntStream intStream = text.chars();
        intStream.mapToObj(i->text.chars().toString().getBytes(StandardCharsets.US_ASCII));
        // IntStream = Arrays.asList(text.split("")).stream().tomapToObj(i -> l1.get(i) + l2.get(i)).collect(Collectors.toList()));
        return bits;
    }
    public String decode(String bits) {
        return text;
    }
}
