import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpinWords {

    public String spinWords(String sentence) {
        List<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        System.out.println(words);
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j<words.size(); j++) {
            if (words.get(j).length() >= 5){
                for (int i = words.get(j).length() - 1; i >= 0; i--) {
                    sb.append(words.get(j).charAt(i));
                }
                sb.append(" ");
            }else {
                sb.append(words.get(j)).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public String spinWordsCW(String sentence) {
        String[] words = sentence.split(" ");
        for (int i=0; i<words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ",words);
    }
    public String spinWordsStream(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }
}