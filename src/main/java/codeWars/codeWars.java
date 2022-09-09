package codeWars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.Stack;

import static java.lang.Integer.parseInt;
import static java.lang.Long.toBinaryString;
import static java.lang.String.valueOf;

public class codeWars {

    public double[] tribonacci(double[] s, int n) {
        // hackonacci me
        ArrayList<Double> exp = new ArrayList<>();
        double[] xb = new double[n];
        for (int i = 0; i < s.length; i++) {
            exp.add(s[i]);
        }
        for (int i = s.length-1; i < n; i++) {
            exp.add(exp.get(i-2) + exp.get(i-1) + exp.get(i));
        }
        for (int i = 0; i < xb.length; i++) {
            xb[i] = exp.get(i);
        }
        return xb;
    }

    public double[] tribonacciCW(double[] s, int n) {

        double[] tritab= Arrays.copyOf(s, n);
        for(int i=3;i<n;i++){
            tritab[i]=tritab[i-1]+tritab[i-2]+tritab[i-3];
        }
        return tritab;

    }
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

//Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//

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
    public class Brackets {
        String[] openingBrackets = {"(", "[", "{"};


        public boolean isValid(String braces) {
            String[] brakes = braces.split("");
            HashMap<String, String> openClose = new HashMap<>();
            openClose.put("(", ")");
            openClose.put("{", "}");
            openClose.put("[", "]");
            if(!isOpening(brakes[0])){return false;}
            //check paren
            for (String openingBracket : openingBrackets) {
                for (int j = 0; j < brakes.length; j++) {
                    if (brakes[j].equals(openingBracket)) {
                        String close = openClose.get(openingBracket);
                        int c = numOpening(j, brakes);
                        if(j+c*2 - 1 > brakes.length-1){
                            return false;
                        }
                        if (!brakes[j+c*2-1].equals(close)) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }
        public int numOpening(int i, String[] b){
            int count = 0;
            for (int j = i; j < b.length; j++) {
                if(!isOpening(b[j])){
                    return count;
                }
                count++;
            }
            return count;
        }

        private boolean isOpening(String j) {
            return j.equals(openingBrackets[0]) || j.equals(openingBrackets[1]) || j.equals(openingBrackets[2]);
        }

        public boolean isValidCW(String braces) {
            Stack<Character> s = new Stack<>();
            for (char c : braces.toCharArray())
            if (s.size() > 0 && isClosing(s.peek(), c)) s.pop();
                else s.push(c);
            return s.size() == 0;
        }

        public boolean isClosing(char x, char c) {
            return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
        }
    }


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

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] tills = new int[n];
        for (int i = 0; i < customers.length; i++) {
            tills[0] += customers[i];
            Arrays.sort(tills);
        }
        return tills[n-1];
    }
}
