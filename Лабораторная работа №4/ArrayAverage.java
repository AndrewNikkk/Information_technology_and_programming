public class ArrayAverage {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        calculateAverage(arr);

    }

    public static void calculateAverage(Object arr) {
        int sum = 0;

        try {
            int[] arrInt = (int[]) arr;
            
            if (arrInt.length == 0) {
                System.out.println("Ошибка: пустой массив");
                return;
            }

            for (int i = 0; i < arrInt.length; i++) {
                sum += arrInt[i];
            }

            double result = (double) sum / arrInt.length;

            System.out.println("Среднее арифметическое значение массива = " + result);
        } catch (ClassCastException e) {
            System.out.println("Ошибка: введенный параметр не может быть приведен к типу int");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        }
    }
}


