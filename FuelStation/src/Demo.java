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
        FuelPump fuelPump1 = new FuelPump(1, "diesel 10ppm", "liters", 3000);
        
        System.out.println(fuelPump1.toString());
        
    }
}
