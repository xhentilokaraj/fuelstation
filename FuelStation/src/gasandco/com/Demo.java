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

        ArrayList<FuelPump> fuelpumps = new ArrayList<FuelPump>();
        fuelpumps.add(new FuelPump(1, "diesel 10ppm", "liters", 3000, BigDecimal.valueOf(10)));
        fuelpumps.add(new FuelPump(2, "diesel unleaded", "gallons", 3000, BigDecimal.valueOf(10)));
        fuelpumps.add(new FuelPump(3, "gasoline", "liters", 3000, BigDecimal.valueOf(10)));

        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(4875, "John", "Snow"));
        customers.add(new Customer(9065, "Eddard", "Stark"));
        customers.add(new Customer(2845, "Robert", "Baratheon"));
        customers.add(new Customer(8561, "Cersey", "Lannister"));
        
        ArrayList<FuelCharge> fuelcharges = new ArrayList<FuelCharge>();

        System.out.println(fuelpumps.get(0).toString());

        FuelDisplayForm fuelForm = new FuelDisplayForm(fuelpumps, customers, fuelcharges);

        fuelForm.setVisible(true);

    }

}
