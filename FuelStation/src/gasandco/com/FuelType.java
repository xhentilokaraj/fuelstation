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
public class FuelType {

    private String fuelType;
    private BigDecimal fuelPrice;

    public FuelType(String fuelType, BigDecimal fuelPrice) {
        this.fuelType = fuelType;
        this.fuelPrice = fuelPrice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public BigDecimal getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(BigDecimal fuelPrice) {
        this.fuelPrice = fuelPrice;
    }
}
