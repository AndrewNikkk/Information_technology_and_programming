import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> products = new ArrayList<>();
        products.add("Apple");
        products.add("Banana");
        products.add("Cherry");

        List<String> products2 = new ArrayList<>();
        products2.add("Laptop");
        products2.add("Mouse");
        products2.add("Screen");

        List<String> products3 = new ArrayList<>();
        products3.add("Jacket");
        products3.add("Cap");
        products3.add("scarf");


        Orders orders = new Orders();

        orders.addOrder(123, orders.new Order("11.10.2024", products, "выполнен"));
        orders.addOrder(215, orders.new Order("15.10.2024", products2, "активный"));
        orders.addOrder(347, orders.new Order("25.10.2024", products3, "активный"));

        System.out.println("Выведем заказ под номером 123 - " + orders.getOrder(123));
        orders.removeOrder(123);
        System.out.println("Заказ под номером 123 удален - " + orders.getOrder(123));
        System.out.println("Статус заказа 215 до изменения - " + orders.getOrder(215));
        orders.setOrderStatus(215, "выполнен");
        System.out.println("Статус заказа 215 после изменения - " + orders.getOrderStatus(215));
        orders.setOrderDate(123, "12.12.2012");
        System.out.println("Попытаемся получить статус удаленного заказа - " + orders.getOrderStatus(123));
        System.out.println("Дата заказа 347 до изменения - " + orders.getOrderDate(347));
        orders.setOrderDate(347, "23.10.2024");
        System.out.println("Дата заказа 347 после изменения - " + orders.getOrderDate(347));
        System.out.println("Список товаров заказа 347 - " + orders.getOrderList(347));
        orders.setOrderList(347, products);
        System.out.println("Список товаров заказа 347 после изменения - " + orders.getOrderList(347));    
    }
}
