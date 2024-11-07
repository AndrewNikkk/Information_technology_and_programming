public class Bed extends Chair {
    private static int bedCount = 0;
    private String mattressType = "Не указан";

    public Bed() {
        super();
        bedCount++;
    }

    public Bed(String material, double weight, double length, double width, double height) {
        super(material, weight, length, width, height);
        bedCount++;
    }

    public Bed(String material, double weight, double length, double width, double height, String mattressType) {
        super(material, weight, length, width, height);
        this.mattressType = mattressType;
        bedCount++;
    }

    public void makeBed() {
        System.out.println("Застелаем кровать.");
    }
    
    @Override
    public void toAssemble() {
        System.out.println("Кровать собрана");
    }

    public void setMattressType(String mattressType) {
        this.mattressType = mattressType;
    }

    public String getMattressType() {
        return mattressType;
    }

    public static int getBedCount() {
        return bedCount;
    }
}

