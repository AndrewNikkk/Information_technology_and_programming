import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FourthTasks {
    public static void main(String[] args) {
        System.out.println("==============================<task 1>==================================");

        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));

        System.out.println("==============================<task 2>==================================");

        System.out.println(bruteForce(1,5));
        System.out.println(bruteForce(2,2));
        System.out.println(bruteForce(5,3));

        System.out.println("==============================<task 3>==================================");

        int[] arr = {0, 31, 28, 10, 29};
        System.out.println(encode(arr, "MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI","MKIIT")));

        System.out.println("==============================<task 4>==================================");

        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        System.out.println("==============================<task 5>==================================");

        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));

        System.out.println("==============================<task 6>==================================");

        System.out.println(convertToRome(8));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));

        System.out.println("==============================<task 7>==================================");

        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));

        System.out.println("==============================<task 8>==================================");

        System.out.println(labirint(new int[][]{{1, 3, 1}, {1, -1, 1}, {4, 2, 1}}));
        System.out.println(labirint(new int[][]{{2, -7, 3}, {-4, -1, 8}, {4, 5, 9}}));

        System.out.println("==============================<task 9>==================================");

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); 
        System.out.println( numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("==============================<task 10>==================================");

        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));

    }

    // ==============================================< 1 >==========================================================

    public static String nonRepeat(String str) {
        return nonRepeatHelper(str.toLowerCase(), new HashMap<>());
    }

    private static String nonRepeatHelper(String str, HashMap<Character, Integer> countMap) {
        if (str.isEmpty()) return "";

        char currentChar = str.charAt(0);
        countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);

        String result = nonRepeatHelper(str.substring(1), countMap);
        
        return (countMap.get(currentChar) > 3 ? "" : currentChar) + result;
    }

    // ==============================================< 2 >==========================================================

    public static List<String> bruteForce(int n, int k) {
        List<String> combinations = new ArrayList<>();
        if (n > k) {
            return combinations;
        }
        generateCombinations(combinations, "", 0, n, k);
        return combinations;
    }

    private static void generateCombinations(List<String> combinations, String current, int index, int n, int k) {
        if (index == n) {
            combinations.add(current);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!current.contains(String.valueOf(i))) {
                generateCombinations(combinations, current + i, index + 1, n, k);
            }
        }
    }

    // ==============================================< 3 >==========================================================

    public static String encode(int[] message, String key) {
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < message.length; i++) {
            int encryptedChar = message[i] ^ key.charAt(i % key.length());
            encodedMessage.append((char)encryptedChar);
        }
        return encodedMessage.toString();
    }

    public static int[] decode(String message, String key) {
        int[] decodedMessage = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            int decryptedChar = message.charAt(i) ^ key.charAt(i % key.length());
            decodedMessage[i] = decryptedChar;
        }
        return decodedMessage;
    }

    // ==============================================< 4 >==========================================================

    public static List<String> split(String s) {
        List<String> clusters = new ArrayList<>();
        int balance = 0;
        StringBuilder currentCluster = new StringBuilder();

        for (char c : s.toCharArray()) {
            currentCluster.append(c);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance == 0) {
                clusters.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }

        return clusters;
    }

    // ==============================================< 5 >==========================================================

    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(str.charAt(i));
            if (count > 1) result.append('*').append(count);
        }
        return result.toString();
    }

    // ==============================================< 6 >==========================================================

    public static String convertToRome(int num) {
        if (num <= 0 || num > 1502) return "Неверный ввод, убедитесь, что 0 < number <= 1502";
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                result.append(romanNumerals[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    // ==============================================< 7 >==========================================================

    public static String uniqueSubstring(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            charCounts.put(str.charAt(i), charCounts.getOrDefault(str.charAt(i), 0) + 1);
        }
        int maxCount = 0;
        char maxChar = ' ';
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        int index = str.indexOf(maxChar);
        return index % 2 == 0 ? "чет" : "нечет";
    }

    // ==============================================< 8 >==========================================================

    public static List<String> labirint(int[][] grid) {
        int n = grid.length;
        List<int[]> path = new ArrayList<>();
        if (findPath(grid, n - 1, n - 1, path)) {
            return List.of(
                    path.stream().map(cell -> String.valueOf(grid[cell[0]][cell[1]])).collect(Collectors.joining("-")),
                    String.valueOf(path.stream().mapToInt(cell -> grid[cell[0]][cell[1]]).sum())
            );
        }
        return List.of("Прохода нет");
    }

    private static boolean findPath(int[][] grid, int x, int y, List<int[]> path) {
        if (x < 0 || y < 0 || grid[x][y] < 0) return false;
        path.add(new int[]{x, y});

        if (x == 0 && y == 0) return true;

        if (findPath(grid, x - 1, y, path) || findPath(grid, x, y - 1, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    // ==============================================< 9 >==========================================================

    public static String numericOrder(String s) {
        String[] words = s.split("\\s+");
        String[] orderedWords = new String[words.length];
        for (String word : words) {
            int position = Integer.parseInt(word.replaceAll("\\D", "")) - 1;
            orderedWords[position] = word.replaceAll("\\d", "");
        }
        return String.join(" ", orderedWords);
    }

    // ==============================================< 10 >==========================================================

    public static boolean fibString(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        int[] counts = charCounts.values().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(counts);
        for (int i = 2; i < counts.length; i++) {
            if (counts[i] != counts[i - 1] + counts[i - 2]) {
                return false;
            }
        }
        return true;
    }
}