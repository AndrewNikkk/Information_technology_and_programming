import java.util.Arrays;
import java.util.List;

public class ThirdTasks {
    public static void main(String[] args) {
        System.out.println("#1 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("#2 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(Arrays.deepToString(sale(new String[][]{{"Laptop", "124200"}, {"Phone", "51450"}, {"Headphones", "13800"}}, 25)));

        System.out.println("#3 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));

        System.out.println("#4 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));

        System.out.println("#5 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        System.out.println("#6 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        System.out.println("#7 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        List<List<Object>> inventory = List.of(
            List.of("Скакалка", 550, 8),
            List.of("Шлем", 3750, 4),
            List.of("Мяч", 2900, 10)
        );
        System.out.println(mostExpensive(inventory));

        System.out.println("#8 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));

        System.out.println("#9 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("#10 =-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));

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

    public static String[][] sale(String[][] products, int discount) {
        for (String[] product : products) {
            int price = Integer.parseInt(product[1]);
            int discountedPrice = (int) Math.max(1, Math.round(price * (1 - (discount / 100.0f))));
            product[1] = String.valueOf(discountedPrice);
        }
        return products;
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
            return counter = 0;
            
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

    public static String mostExpensive(List<List<Object>> inventory) {
        String mostExpensiveItem = "";
        int maxPrice = 0;

        for (List<Object> item : inventory) {
            String nameItem = (String) item.get(0);
            int price = (int) item.get(1);
            int quantity = (int) item.get(2);
            int totalPrice = price * quantity;

            if (totalPrice > maxPrice) {
                maxPrice = totalPrice;
                mostExpensiveItem = nameItem;
            }
        }
        return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxPrice;
    }

    public static String longestUnique(String str) {
        String logest = "";

        for (int i = 0; i < str.length(); i++) {
            StringBuilder current = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if (current.toString().indexOf(c) == -1) {
                    current.append(c);
                    if (current.length() > logest.length()) {
                        logest = current.toString();
                    }
                } else {
                    break;
                }
            }
        }
        return logest;
    }

public static boolean isPrefix(String word, String prefix) {
    prefix = prefix.replace("-", "");
    return word.startsWith(prefix);
}

public static boolean isSuffix(String word, String suffix) {
    suffix = suffix.replace("-", "");
    return word.endsWith(suffix);
}

public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
    return (a <= w && b <= h) || (a <= h && b <= w) ||
         (a <= w && c <= h) || (a <= h && c <= w) ||
         (b <= w && c <= h) || (b <= h && c <= w);
}

}