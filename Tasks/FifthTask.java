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

        System.out.println("--------------------------[ 2 ]--------------------------");

        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));
    
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

    public static int memeSum(int num1, int num2) {
        StringBuilder str1 = new StringBuilder(String.valueOf(Math.max(num1, num2)));
        StringBuilder str2 = new StringBuilder(String.valueOf(Math.min(num1, num2)));
        str2.insert(0, "0".repeat(str1.length() - str2.length()));

        System.out.println(str1);
        System.out.println(str2);

        

        StringBuilder res = new StringBuilder();
        int result = 0;

        for (int i = Math.max(str1.length(), str2.length()); i > 0; i--) {
            int index1 = i - 1;
            int digit1 = (index1 < str1.length() ? Character.getNumericValue(str1.charAt(index1)) : 0);
            
            int index2 = i - 1;
            int digit2 = (index2 < str2.length() ? Character.getNumericValue(str2.charAt(index2)) : 0);
        
            res.insert(0, String.valueOf(digit1 + digit2)); // Добавляем цифры в начало строки
        }

        result = Integer.parseInt(res.toString());
        return result;
        
    }
}


