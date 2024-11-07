public abstract class Furniture {
    private String material;
    private double weight;
    private double length;
    private double width;
    private double height;
    protected static int counter = 0;
    
    public Furniture() {
        material = "Не указан";
        weight = 0.0;
        length = 0.0;
        width = 0.0;
        height = 0.0;
        counter++;
    }

    public Furniture(String material, double weight, double length, double width, double height) {
        this.material = material;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        counter++;
    }

    public void Info() {
        System.out.println("Материал: " + material + "; Вес: " + weight + "; Длина: " + 
         length + "; Ширина: " + width + "; Высота: " + height);
    }

    public void Info(String additionalInfo) {
        System.out.println("Материал: " + material + "; Вес: " + weight + "; Длина: " + 
         length + "; Ширина: " + width + "; Высота: " + height + "; Дополнительная информация: " + additionalInfo);
    }

    public abstract void toAssemble();

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static int getCount() {
        return counter;
    }
}

