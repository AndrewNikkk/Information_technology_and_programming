import java.util.Arrays;

public class SecondTasks {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));
        int[] arr = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(arr));
        System.out.println(getInitials("simonov sergei evgenievich"));
        double[] numbers = {3.5, 7.0, 1.5, 9.0, 5.5};
        System.out.println(Arrays.toString(normalizator(numbers)));
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
        int lenght = arr.length;
        int count = 0;
        for (int i = 0; i < lenght; i++) {
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

}

