import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FifthTask {
    public static void main(String[] args) {
        System.out.println("--------------------------[ 1 ]--------------------------");

        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

    
    }

    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger count2 = new AtomicInteger(0);


        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] arr1 = new int[str1.length()];
        int[] arr2 = new int[str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            arr1[i] = map1.computeIfAbsent(chars1[i], k -> count.incrementAndGet());
            arr2[i] = map2.computeIfAbsent(chars2[i], k -> count2.incrementAndGet());
        }
        return Arrays.equals(arr1, arr2);
    }
}


