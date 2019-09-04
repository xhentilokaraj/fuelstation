package gasandco.com;

import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<FuelType> fuelTypes = new ArrayList<FuelType>();
        fuelTypes.add(new FuelType("diesel 10ppm", BigDecimal.valueOf(1.5)));
        fuelTypes.add(new FuelType("diesel unleaded", BigDecimal.valueOf(2.5)));
        fuelTypes.add(new FuelType("gasoline", BigDecimal.valueOf(0.50)));

        ArrayList<FuelPump> fuelpumps = new ArrayList<FuelPump>();
        fuelpumps.add(new FuelPump(1, fuelTypes.get(0), "liters", 20));
        fuelpumps.add(new FuelPump(2, fuelTypes.get(1), "gallons", 3000));
        fuelpumps.add(new FuelPump(3, fuelTypes.get(2), "liters", 3000));

        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(4875, "John", "Snow"));
        customers.add(new Customer(9065, "Eddard", "Stark"));
        customers.add(new Customer(2845, "Robert", "Baratheon"));
        customers.add(new Customer(8561, "Cersey", "Lannister"));

        ArrayList<FuelCharge> fuelcharges = new ArrayList<FuelCharge>();

        //System.out.println(fuelpumps.get(0).toString());
        PumpDisplay pumpDisplay = new PumpDisplay();
        FuelChargeForm fuelForm = new FuelChargeForm(fuelpumps, customers, fuelcharges, pumpDisplay, fuelTypes);
        fuelForm.setVisible(true);
        pumpDisplay.setVisible(true);

    }
}
