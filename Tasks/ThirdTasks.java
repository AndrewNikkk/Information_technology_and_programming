public class ThirdTasks {
    public static void main(String[] args) {
        System.out.println(isStrangePair("ratio", "orator"));
    }

    public static boolean isStrangePair(String firstStr, String secondStr) {
        if (firstStr.length() == 0 && secondStr.length() == 0) {
            return true;
        } else if ((firstStr.charAt(0) == secondStr.charAt(secondStr.length() - 1)) && 
        (firstStr.charAt(firstStr.length() - 1) == secondStr.charAt(0))) {
            return true;
        }
        return false;
    }
    
}