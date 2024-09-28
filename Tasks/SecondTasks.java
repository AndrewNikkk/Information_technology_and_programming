import java.util.*;

public class SecondTasks {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));
        int[] arr = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(arr));
        System.out.println(getInitials("simonov sergei evgenievich"));
        double[] numbers = {3.5, 7.0, 1.5, 9.0, 5.5};
        System.out.println(Arrays.toString(normalizator(numbers)));
        double[] arrNums = {1.6, 0, 212.3, 34.8, 0, 27.5};
        System.out.println(Arrays.toString(compressedNums(arrNums)));
        System.out.println(camelToSnake("HelloWorld"));
        int[] secondArr = {1, 6, 3, 6, 7, 9, 11, 0};
        System.out.println(secondBiggest(secondArr));
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
        System.out.println(equals(3, 3, 1));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
    }

   public static String duplicateChars(String firstStr, String secondStr) {
    firstStr = firstStr.toLowerCase();
    secondStr = secondStr.toLowerCase();
    String chars = "";
    for (int i = 0; i < firstStr.length(); i++) {
        char s = firstStr.charAt(i);
        if (secondStr.indexOf(s) == -1) {
            chars += s;
        }
    }
    return chars; 
   }

   public static int dividedByThree(int[] arr) {
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if ((arr[i] % 2 != 0) && (arr[i] % 3) == 0) {
                count++;
            }
        }
        return count;
   }

   public static String getInitials(String str) {
        String initials = "";
        String[] parts = str.split(" ");
        String name = "" + parts[1].toUpperCase().charAt(0);
        String patronymic = "" + parts[2].toUpperCase().charAt(0);
        String surname = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
        initials = String.format("%s. %s. %s", name, patronymic, surname);
        return initials;
   }

   public static double[] normalizator(double[] arr) {
    double min = Double.POSITIVE_INFINITY;
    double max = Double.NEGATIVE_INFINITY;
    for (double x : arr) {
        if (x < min) {
            min = x;
        }
        if (x > max) {
            max = x;
        }
    }
    int lenght = arr.length;
    double[] normalizedArr = new double[lenght];
    for (int i = 0; i < lenght; i++) {
        if (min == max) {
            normalizedArr[i] = 0.0;
        } 
        else {
            normalizedArr[i] = (arr[i] - min) / (max - min);
        }
    }
    return normalizedArr;
   }

   public static int[] compressedNums(double[] arr) {
    int counter = 0;
    int index = 0;
    for (double x : arr) {
        if (x != 0.0) {
            counter++;
        }
    }
    int[] compressedArr = new int[counter];
    for (double x : arr) {
        if (x != 0) {
            int y = (int) x;
            compressedArr[index] = y;
            index++;
        }
    }
    Arrays.sort(compressedArr);
    return compressedArr;
    }

    public static String camelToSnake(String str) {
        String[] words = str.split("(?=[A-ZА-Я])");
        int length = words.length;
        String newStr = "";
        for (int i = 0; i < length; i++) {
            newStr += words[i];
            if (i < (length - 1)) {
               newStr += "_"; 
            }
        }
        newStr = newStr.toLowerCase();
        return newStr;
    }

    public static int secondBiggest(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        return arr[length - 2];
    }

    public static String localReverse(String str, char marker) {
        StringBuilder result = new StringBuilder();
        int start = 0;

        while (start < str.length()) {
            int firstMarker = str.indexOf(marker, start);
            if (firstMarker == -1) {
                result.append(str.substring(start));
                break;
            }

            result.append(str.substring(start, firstMarker + 1));
            start = firstMarker + 1;

            int secondMarker = str.indexOf(marker, start);
            if (secondMarker == -1) {
                result.append(str.substring(firstMarker + 1));
                break;
            }
            
            String toReverse = str.substring(firstMarker + 1, secondMarker);
            result.append(new StringBuilder(toReverse).reverse());
            result.append(marker);
            start = secondMarker + 1;
        }
        return result.toString();
    }

    public static int equals(int a, int b, int c) {
        if (a == b && a == c) {
            return 3;
        }
        else if (a != b && b != c) {
            return 0;
        }
        return 2;
    }

    public static boolean isAnagram(String firstString, String secondString) {
        firstString = firstString.replaceAll("[^\\w]", "").toLowerCase();
        secondString = secondString.replaceAll("[^\\w]", "").toLowerCase();
        if (firstString.length() != secondString.length()) {
            return false;
        }

        char[] firstArray = firstString.toCharArray();
        char[] secondArray = secondString.toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }
}

