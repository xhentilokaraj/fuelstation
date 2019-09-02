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
public class FixedAmtThresholdDiscount implements DiscountStrategy {

    BigDecimal moneyAmtThreshold;
    BigDecimal moneyAmtDiscount;
    float fuelAmtThreshold;
    float fuelAmtDiscount;
    BigDecimal price;

    public FixedAmtThresholdDiscount(BigDecimal moneyAmtThreshold, BigDecimal moneyAmtDiscount, float fuelAmtThreshold, float fuelAmtDiscount, BigDecimal price) {
        this.moneyAmtThreshold = moneyAmtThreshold;
        this.moneyAmtDiscount = moneyAmtDiscount;
        this.fuelAmtThreshold = fuelAmtThreshold;
        this.fuelAmtDiscount = fuelAmtDiscount;
        this.price = price;
        this.arrangeData();
    }

    public float applyDiscountFuelAmt(BigDecimal moneyAmount) {
        if (moneyAmount.compareTo(this.moneyAmtThreshold.add(moneyAmtDiscount)) > 0) {
            return this.moneyAmtDiscount.divide(this.price,
                    2, RoundingMode.HALF_EVEN).floatValue();
        } else if (moneyAmount.compareTo(this.moneyAmtThreshold) > 0) {
            return (moneyAmount.subtract(this.moneyAmtThreshold)).divide(this.price,
                    2, RoundingMode.HALF_EVEN).floatValue();
        } else {
            return BigDecimal.ZERO.floatValue();
        }
    }

    public BigDecimal applyDiscountMoneyAmt(float fuelAmount) {
        if (fuelAmount > (this.fuelAmtThreshold + this.fuelAmtDiscount)) {
            return new BigDecimal(Float.toString(this.fuelAmtDiscount)).multiply(this.price);
        } else if (fuelAmount > this.fuelAmtThreshold) {
            return new BigDecimal(Float.toString(fuelAmount - this.fuelAmtThreshold)).multiply(this.price);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public String toString() {
        return "Amount Threshold: " + this.fuelAmtThreshold + " Units --- " + this.moneyAmtThreshold + " Euros" +
                " Discount: " + this.fuelAmtDiscount + " Units --- " + this.moneyAmtDiscount + " Euros";
    }

    private void arrangeData() {
        if (this.moneyAmtThreshold != null && this.moneyAmtThreshold.compareTo(BigDecimal.ZERO) > 0) {
            this.fuelAmtThreshold = this.moneyAmtThreshold.divide(this.price, 2, RoundingMode.HALF_EVEN).floatValue();
        } else if (this.fuelAmtThreshold > 0) {
            this.moneyAmtThreshold = new BigDecimal(Float.toString(this.fuelAmtThreshold)).multiply(this.price);
        }
    }

}
