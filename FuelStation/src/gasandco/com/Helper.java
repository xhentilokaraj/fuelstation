/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasandco.com;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class Helper {

    public static Customer getCustomerById(ArrayList<Customer> customers, int id) {
        Iterator<Customer> iter = customers.iterator();
        while (iter.hasNext()) {
            Customer customer = iter.next();
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return null;
    }

    public static FuelType getFuelTypeByFuel(ArrayList<FuelType> fuelTypes, String fuel) {
        Iterator<FuelType> iter = fuelTypes.iterator();
        while (iter.hasNext()) {
            FuelType fuelType = iter.next();
            if (fuelType.getFuelType() == fuel) {
                return fuelType;
            }
        }
        return null;
    }
    
    public static FuelPump getFuelPumpByName(ArrayList<FuelPump> fuelPumps, String fuelPumpName) {
        Iterator<FuelPump> iter = fuelPumps.iterator();
        while (iter.hasNext()) {
            FuelPump fuelPump = iter.next();
            if (fuelPump.toString().equals(fuelPumpName)) {
                return fuelPump;
            }
        }
        return null;
    }

}
