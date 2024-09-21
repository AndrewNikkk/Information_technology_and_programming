public class Tasks {
    public static void main(String[] args) { 
        System.out.println(convert(5));
        System.out.println(fitCalc(41, 3));
        System.out.println(containers(4, 1, 4));
        System.out.println(triangleType(5, 5, 5));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(factorial(3));
        System.out.println(gcd(48, 18));
        System.out.println(ticketSaler(70, 1500));
        System.out.println(tables(5, 2));
    }

    public static double convert(int gallons) {
        return (gallons * 3.78541);
    }

    public static int fitCalc(int k, int i) {
        return k * i;
    
    }

    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "Not a triangle";
        } else if (x == y && y == z) {
            return "equilateral";
        } else if (x == y || x == z || y == z) {
            return "isosceles";
        } else {
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }

    public static int howManyItems(double n, double w, double h) {
        return (int) ((n*2)/(w*h)); 
    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        } 
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int i = b;
            b = a % b;
            a = i;
        }
        return a;
    }

    public static int ticketSaler(int ticketsSold, double ticetPrice) {
        double comissionRate = 0.10;
        return (int) (ticketsSold * ticetPrice * (1 - comissionRate));
    }

    public static int tables(int students, int desks) {
        int neededDesks = (students + 1) / 2;
        return neededDesks - desks;
    }
}
