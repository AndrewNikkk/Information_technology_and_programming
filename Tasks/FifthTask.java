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

        System.out.println("--------------------------[ 3 ]--------------------------");

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));    

        System.out.println("--------------------------[ 4 ]--------------------------");

        String[] strArr1 = {"cat", "create", "sat"};
        String[] strArr2 = {"trance", "recant"};
        String[] strArr3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};


        System.out.println(totalPoints(strArr1, "caster"));
        System.out.println(totalPoints(strArr2, "recant"));
        System.out.println(totalPoints(strArr3, "tossed"));

        System.out.println("--------------------------[ 5 ]--------------------------");

        int[] numArr1 = {1, 2, 3, 5, 6, 7, 8, 9};
        int[] numArr2 = {1, 2, 3, 10, 11, 15};
        int[] numArr3 = {5, 4, 2, 1};
        int[] numArr4 = {3, 5, 7, 10, 15};

        System.out.println(longestRun(numArr1));
        System.out.println(longestRun(numArr2));
        System.out.println(longestRun(numArr3));
        System.out.println(longestRun(numArr4));

        System.out.println("--------------------------[ 6 ]--------------------------");

        String[] avrArr1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] avrArr2 = {"10%"};
        String[] avrArr3 = {"53%", "79%"};

        System.out.println(takeDownAverage(avrArr1));
        System.out.println(takeDownAverage(avrArr2));
        System.out.println(takeDownAverage(avrArr3));




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

        StringBuilder res = new StringBuilder();
        int result = 0;

        for (int i = Math.max(str1.length(), str2.length()); i > 0; i--) {
            int index1 = i - 1;
            int digit1 = (index1 < str1.length() ? Character.getNumericValue(str1.charAt(index1)) : 0);
            
            int index2 = i - 1;
            int digit2 = (index2 < str2.length() ? Character.getNumericValue(str2.charAt(index2)) : 0);
        
            res.insert(0, String.valueOf(digit1 + digit2));
        }

        result = Integer.parseInt(res.toString());
        return result;
        
    }

    public static int digitsCount(long count) {
        int counter = 0;

        if (count == 0) return 1;

        count /= 10;
        counter++;

        if (count > 0) {
            counter += digitsCount(count);
        }

        return counter;
    }

    public static int totalPoints(String[] words, String key) {
        int score = 0;
        int countInKey = 0;
        int countInWord = 0;

        char[] keyChars= key.toCharArray();
        Map<Character, Integer> keyFreq= new HashMap<>();

        for (char c : keyChars) {
            keyFreq.put(c, keyFreq.getOrDefault(c, 0) + 1);
        }


        for (String word : words) {

            char[] wordChars = word.toCharArray();
            Map<Character, Integer> wordFreq= new HashMap<>();

            for (char c : wordChars) {
                wordFreq.put(c, wordFreq.getOrDefault(c, 0) +1 );
            }

            for (char c : wordFreq.keySet()) {
                countInKey = keyFreq.get(c);
                countInWord = wordFreq.getOrDefault(c, 0); 
            }

            if (countInKey < countInWord) {
                System.err.println("Invalid word - " + word + " - количество символов не то");
            } else {
                switch (word.length()) {
                    case 3:
                        score += 1;
                        break;
                    case 4:
                        score += 2;
                        break;
                    case 5:
                        score += 3;
                        break;
                    case 6:
                        score += 54;
                        break;
                    default:
                        System.out.println("Invalid word - " + word);
                }
            }
        }
        return score;
    }

    public static int longestRun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[i - 1] == 1) || (arr[i] - arr[i - 1] == -1)) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        
        return maxLength;
    }

    public static String takeDownAverage(String[] marks) {
        int sum = 0;
        for (String mark : marks) {
            sum += Integer.parseInt(mark.replace("%", ""));
        }
        int count = marks.length;
        double currentAvg = sum / (double) count;
        double newAvg = currentAvg * 0.95;
        double newSum = newAvg * (count + 1);
        int newMark = (int) Math.round(newSum - sum);
        return newMark + "%";
    }


}




