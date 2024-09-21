public class SecondTasks {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));
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
}
