public class Chair extends Furniture {
    private static int chairCount = 0;
    private String chairColor = "Не указан";


    public Chair() {
        super();
        chairCount++;
    }

    public Chair(String material, double weight, double length, double width, double height) {
        super(material, weight, length, width, height);
        chairCount++;
    }

    public Chair(String material, double weight, double length, double width, double height, String chairColor) {
        super(material, weight, length, width, height);
        this.chairColor = chairColor;
        chairCount++;
    }
    
    @Override
    public void toAssemble() {
        System.out.println("Стул собран");
    }

    public void addCushion() {
        System.out.println("Добавляем подушку для большего комфорта.");
    }

    public void setChaireColor(String chairColor) {
        this.chairColor = chairColor;
    }
    
    public String getChairColor() {
        return chairColor;
    }

    public static int getChairCount() {
        return chairCount;
    }
}

