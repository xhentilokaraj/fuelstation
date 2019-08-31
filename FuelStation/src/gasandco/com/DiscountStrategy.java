package gasandco.com;


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
public interface DiscountStrategy {

 BigDecimal applyDiscount(BigDecimal amount);
 
}
