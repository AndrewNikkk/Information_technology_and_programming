public class Main {
    public static void main(String[] args) {
        Table desk = new Table("Древесина", 11.0, 1100.0, 500.0, 400.0);
        desk.Info();
        desk.toClean();
        System.out.println(Table.getTableCount());
        System.out.println(desk.getNumberOfLegs());
        System.out.println("------------------------------");
        Chair classicChair = new Chair();
        classicChair.setChaireColor("Зеленый");
        System.out.println(classicChair.getChairColor());
        classicChair.Info();
        classicChair.info("Стул только вчера поступил в продажу");
        System.out.println("------------------------------");
        Bed comfortableBed = new Bed("Древесина", 50.0, 2000.0, 1600.0, 500.0, "Пружинный");
        System.out.println(comfortableBed.getMattressType());
        comfortableBed.addCushion();
        System.out.println(Bed.getCount());
    }
}

