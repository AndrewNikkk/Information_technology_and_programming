import java.math.*;

public class ThirdTasks {
    public static void main(String[] args) {
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(parityAnalysis(3));
        System.out.println(rps("paper", "rock"));
        System.out.println(bugger(999));
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

    public static boolean sucsessShoot(int x, int y, int r, int n, int m) {
        double shootToCenter = Math.pow((Math.pow(n - x, 2) + Math.pow(m - y, 2)), 0.5);
        if (r > shootToCenter) {
            return true;
        }
        return false;
    }

    public static boolean parityAnalysis(int count) {
        String countStr = Integer.toString(count);
        char[] countParts = countStr.toCharArray();
        int partsSum = 0;
        for (char part : countParts) {
            Character.getNumericValue(part);
            partsSum += part;
        }
        if (((count % 2 == 0) && (partsSum % 2 == 0)) || ((count % 2 != 0) && (partsSum % 2 != 0))) {
            return true;
        }
        return false;
    }
    
    public static String rps(String playerFirst, String playerSecond) {
        String firstWins = "Player 1 wins";
        String secondWins = "Player 2 wins";
        String tie = "Tie";
        if ((playerFirst == "rock" && playerSecond == "scissors") || (playerFirst == "scissors" && playerSecond == "paper") || ((playerFirst == "paper" && playerSecond == "rock"))) {
            return firstWins;
        } else if ((playerSecond == "rock" && playerFirst == "scissors") || (playerSecond == "scissors" && playerFirst == "paper") || ((playerSecond == "paper" && playerFirst == "rock"))) {
            return secondWins;
        }
        return tie;
    }

    public static int bugger(int number) {
        int counter = 0;
        if (Integer.toString(number).length() == 1) {
            return counter = 1;
            
        } else {
            while (Integer.toString(number).length() > 1) {
                counter += 1;
                char[] numParts = Integer.toString(number).toCharArray();
                int tempNum = 1;
                for (char part : numParts) {
                    tempNum *= Character.getNumericValue(part);
                }
                number = tempNum;
            }
        }
        return counter;
    }
}