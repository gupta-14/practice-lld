package LLD.CarRentalSystem.Product;

public class Vehicle {
    int vehicleId;
    int vehicleNumber;
    int kmDriven;
    int dailyRentalCost;
    int monthlyRentalCost;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;

    // Getters
    public int getVehicleId() {
        return vehicleId;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public int getDailyRentalCost() {
        return dailyRentalCost;
    }

    public int getMonthlyRentalCost() {
        return monthlyRentalCost;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    // Setters
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public void setDailyRentalCost(int dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public void setMonthlyRentalCost(int monthlyRentalCost) {
        this.monthlyRentalCost = monthlyRentalCost;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
