/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasandco.com;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author User
 */
public class FreeFirstUnitsDiscount implements DiscountStrategy {

    BigDecimal freeFirstEuros;
    float freeFirstFuelUnits;
    BigDecimal price;

    public FreeFirstUnitsDiscount(BigDecimal freeFirstEuros, float freeFirstFuelUnits, BigDecimal price) {
        this.freeFirstEuros = freeFirstEuros;
        this.freeFirstFuelUnits = freeFirstFuelUnits;
        this.price = price;
        this.arrangeData();
    }

    public float applyDiscountFuelAmt(BigDecimal moneyAmount) {
        if (moneyAmount.compareTo(this.freeFirstEuros) > 0) {
            return this.freeFirstEuros.divide(this.price, 2, RoundingMode.HALF_EVEN).floatValue();
        } else {
            return 0;
        }
    }

    public BigDecimal applyDiscountMoneyAmt(float fuelAmount) {
        if (fuelAmount > this.freeFirstFuelUnits) {
            return new BigDecimal(Float.toString(this.freeFirstFuelUnits)).multiply(this.price);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private void arrangeData() {
        if (this.freeFirstEuros != null && this.freeFirstEuros.compareTo(BigDecimal.ZERO) > 0) {
            this.freeFirstFuelUnits = this.freeFirstEuros.divide(this.price, 2, RoundingMode.HALF_EVEN).floatValue();
        } else if (this.freeFirstFuelUnits > 0) {
            this.freeFirstEuros = new BigDecimal(Float.toString(this.freeFirstFuelUnits)).multiply(this.price);
        }
    }

    @Override
    public String toString() {
        return "Free First Units: " + this.freeFirstEuros + " Euros --- " + this.freeFirstFuelUnits + " units ";

    }

}
