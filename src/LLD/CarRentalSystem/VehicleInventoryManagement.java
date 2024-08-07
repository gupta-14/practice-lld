package LLD.CarRentalSystem;

import LLD.DesignPatterns.StrategyPattern.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

//    public void addVehicle(Vehicle vehicle){
//        vehicles.add(vehicle);
//    }
//
//    public void removeVehicle(Vehicle vehicle){
//        vehicles.remove(vehicle);
//    }

}
