import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rainfall {

    public static double mean(String town, String strng) {
        String[] data = strng.split("\n");
        HashMap<String, List<Double>> cityRain = new HashMap<>();
        for (String s: data) {
            String[] line = s.split(":");
            String[] temp = line[1].replaceAll(",", " ").split(" ");
            List<Double> rainMonth = new ArrayList<>();
            for (int j = 1; j < temp.length; j+=2) {
                rainMonth.add(Double.parseDouble(temp[j]));
            }
            cityRain.put(line[0], rainMonth);
        }
        float mean = 0.0f;
        for (Double d:cityRain.get(town)) {
            mean += d;
        }
        return (!cityRain.get(town).isEmpty()) ? (mean/12.0f) : -1.0f;
    }
    public static double variance(String town, String strng) {
        String[] data = strng.split("\n");
        HashMap<String, List<Double>> cityRain = new HashMap<>();
        for (String s: data) {
            String[] line = s.split(":");
            String[] temp = line[1].replaceAll(",", " ").split(" ");
            List<Double> rainMonth = new ArrayList<>();
            for (int j = 1; j < temp.length; j+=2) {
                rainMonth.add(Double.parseDouble(temp[j]));
            }
            cityRain.put(line[0], rainMonth);
        }
        if(!cityRain.containsKey(town)) return -1.0f;
        float mean = 0.0f;
        for (Double d:cityRain.get(town)) {
            mean += d;
        }
        float var = 0.0f;
        for (Double d:cityRain.get(town)) {
            var += Math.pow(d-(mean/12.0f),2);
        }
        return (!cityRain.get(town).isEmpty()) ? (var/cityRain.get(town).size()) : -1.0f;
    }
}
/*

class Rainfall {
    static double mean(String town, String strng) {
        return stream(town, strng).average().orElse(-1);
    }

    static double variance(String town, String strng) {
        return stream(town, strng).map(m -> Math.pow(m - mean(town, strng), 2)).average().orElse(-1);
    }

    private static DoubleStream stream(String town, String data) {
        return of(data.split("\n")).filter(s -> s.startsWith(town + ":"))
                .flatMapToDouble(s -> of(s.replaceAll("[^\\d.]", " ").trim().split("\\s+")).mapToDouble(Double::parseDouble));
    }
}

 */