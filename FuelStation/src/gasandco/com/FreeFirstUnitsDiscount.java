/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasandco.com;

/**
 *
 * @author User
 */
public class FreeFirstUnitsDiscount implements DiscountStrategy {
    float firstUnits;

    public FreeFirstUnitsDiscount(float firstUnits) {
        this.firstUnits = firstUnits;
    }
    
    
}
