
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FixedPctDiscountPerUnit implements DiscountStrategy {
    
    private static final double pctDiscount = 20.0;

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(pctDiscount/100));
    }
}
