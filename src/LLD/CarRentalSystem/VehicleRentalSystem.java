package LLD.CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> stores;
    List<User> users;

    VehicleRentalSystem(List<Store> stores, List<User> users) {

        this.stores = stores;
        this.users = users;
    }


    public Store getStore(Location location){

        //based on location, we will filter out the Store from storeList.
        return stores.get(0);
    }



    //addUsers

    //remove users


    //add stores

    //remove stores

}
