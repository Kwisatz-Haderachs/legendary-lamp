import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Unique {

    public static double findUniq(double arr[]) {
        HashMap<Double, Integer> uniq = new HashMap<>();
        for (double d: arr) {
            uniq.merge(d, 1, Integer::sum);
        }
        for (Map.Entry<Double, Integer> values : uniq.entrySet()){
            if(values.getValue() == 1){
                return values.getKey();
            }
        }
        return 0.0;

//        return Arrays.stream(array).boxed()
//                .collect(groupingBy(identity(), counting()))
//                .entrySet().stream()
//                .filter(e -> e.getValue() == 1)
//                .findFirst()
//                .map(Entry::getKey)
//                .orElse(0.0);
    }

    public static double findUniqCW(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }
}

//Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet().stream().filter(e->e.getValue() == 1).findFirst().get().getKey();