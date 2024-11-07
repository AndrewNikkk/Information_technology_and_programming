import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class Orders {
    protected class Order {
        private String date;
        private List<String> products = new ArrayList<>();
        private String status;
    
        public Order(String date, List<String> products, String status) {
            this.date = date;
            this.products = products;
            this.status = status;
        }

        protected void setDate(String date) {
            this.date = date;
        }

        protected String getDate() {
            return date;
        }

        protected void setList(List<String> products) {
            this.products = products;
        }

        protected String getList() {
            return products.toString();
        }

        protected void setStatus(String status) {
            this.status = status;
        }

        protected String getStatus(){
            return status;
        }

        protected String info() {
            return "Дата заказа: " + date + " || Содержание заказа: " + products + " || Статус заказа: " + status;
        }
    }
        HashMap<Integer, Order> orders = new HashMap<>();
    
    public void addOrder(int number, Order order) {
        orders.put(number, order);
    }

    public String getOrder(int number) {
        if (orders.get(number) == null) {
            return "Нет заказа с номером " + number;
        }
        return orders.get(number).info();
    }

    public String getOrderDate(int number) {
        if (orders.get(number) == null) {
            return "Нет заказа с номером " + number;
        }
        return orders.get(number).getDate();
    }

    public void setOrderDate(int number, String date) {
        Order order = orders.get(number);
        if (order != null) {
            order.setDate(date);
            orders.put(number, order);
        } else {
            System.out.println("Нет заказа с номером " + number);
        }
    }

    public String getOrderList(int number) {
        if (orders.get(number) == null) {
            return "Нет заказа с номером " + number;
        }
        return orders.get(number).getList();
    }

    public void setOrderList(int number, List<String> products) {
        Order order = orders.get(number);
        if (order != null) {
            order.setList(products);
            orders.put(number, order);
        } else {
            System.out.println("Нет заказа с номером " + number);
        }
    }

    public String getOrderStatus(int number) {
        if (orders.get(number) == null) {
            return "Нет заказа с номером " + number;
        }
        return orders.get(number).getStatus();
    }

    public void setOrderStatus(int number, String status) {
        Order order = orders.get(number);
        if (order != null) {
            order.setStatus(status);
            orders.put(number, order);
        } else {
            System.out.println("Нет заказа с номером " + number);
        }
    }

    public void removeOrder(int number) {
        orders.remove(number);
    }
     
}

