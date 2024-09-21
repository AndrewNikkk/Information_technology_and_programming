public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
        String s = args[i];
        if (isPalindrome(s)) {
                System.out.println(s + " - is a palindrome");
            } else {
                System.out.println(s + " - is not a palindrome");
            }
        }
    } 
    public static String reverseString(String s) {
        String s2 = "";
        for (int index = (s.length() - 1); index >= 0; index--) {
            s2 = s2 + s.charAt(index);
        }
        return s2;
    }
    public static Boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
