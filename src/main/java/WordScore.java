import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WordScore {
    public static String high(String s) {
        List<String> words = new ArrayList<>(Arrays.asList(s.toLowerCase().split(" ")));
        int score = 0;
        String high = "";
        for (int i = 0; i < words.size(); i++) {
            int wordScore = 0;
            for (int j = 0; j < words.get(i).length(); j++) {
                wordScore += words.get(i).charAt(j)-96;
            }
            if(wordScore > score){
                score = wordScore;
                high = words.get(i);
            }
        }

        return high;
    }

    public static String highCW(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }
}

