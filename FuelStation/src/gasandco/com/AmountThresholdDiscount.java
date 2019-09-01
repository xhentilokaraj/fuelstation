/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasandco.com;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class AmountThresholdDiscount implements DiscountStrategy {

    BigDecimal amountThreshold;

    public AmountThresholdDiscount(BigDecimal amountThreshold) {
        this.amountThreshold = amountThreshold;
    }
    
    public float applyDiscountFuelAmt(BigDecimal moneyAmount) {
        
    }
    
    

}
