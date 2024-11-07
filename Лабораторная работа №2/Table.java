public class Table extends Furniture {
    private static int tableCount = 0;
    private int numberOfLegs = 4; 

    public Table() {
        super();
        tableCount++;
    }

    public Table(String material, double weight, double length, double width, double height) {
        super(material, weight, length, width, height);
        tableCount++;
    }

    public Table(String material, double weight, double length, double width, double height, int numberOfLegs) {
        super(material, weight, length, width, height);
        this.numberOfLegs = numberOfLegs;
        tableCount++;
    }
    
    public Table(String material, int numberOfLegs) {
        super(material, 10.0, 1200.0, 600.0, 600.0);
        this.numberOfLegs = numberOfLegs;
        tableCount++;
    }
    
    @Override
    public void toAssemble() {
        System.out.println("Стол собран");
    }

    public void toClean() {
        System.out.println("Протираем стол...");
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public static int getTableCount() {
        return tableCount;
    }
}
