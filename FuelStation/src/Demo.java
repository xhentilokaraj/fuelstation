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
    public static void main (String[] args) {
        FuelPump[] fuelpumps = new FuelPump[3];
        fuelpumps[0] = new FuelPump(1, "diesel 10ppm", "liters", 3000);
        fuelpumps[1] = new FuelPump(1, "diesel unleaded", "gallons", 3000);
        fuelpumps[2] = new FuelPump(1, "gasoline", "liters", 3000);
        
        Customer[] customers = new Customer[4];
        customers[0] = new Customer(1234, "John", "Snow");
        customers[1] = new Customer(1224, "Eddard", "Stark");
        customers[2] = new Customer(1223, "Robert", "Baratheon");
        customers[3] = new Customer(1123, "Cersey", "Lannister");
        
        System.out.println(fuelpumps[0].toString());
        
        new FuelChargeForm();
        new FuelChargeForm();
        
    }
}
