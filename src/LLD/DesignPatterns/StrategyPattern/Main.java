package LLD.DesignPatterns.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new OffRoadVehicle();
        vehicle1.drive();
        Vehicle vehicle2 = new GoodsVehicle();
        vehicle2.drive();
    }
}