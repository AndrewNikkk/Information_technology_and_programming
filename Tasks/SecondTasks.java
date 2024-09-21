public class SecondTasks {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));
        int[] arr = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(arr));
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
}
