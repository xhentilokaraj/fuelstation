package gasandco.com;

import java.math.BigDecimal;
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class FuelPump extends Observable {

    private int pumpId;
    private String fuelType;
    private String fuelUnit;
    private String status;
    private float totalFuelAmt;
    private BigDecimal fuelPrice;

    public FuelPump(int pumpId, String fuelType, String fuelUnit, float totalFuelAmt, BigDecimal fuelPrice) {
        this.pumpId = pumpId;
        this.fuelType = fuelType;
        this.fuelUnit = fuelUnit;
        this.status = "Free";
        this.totalFuelAmt = totalFuelAmt;
        this.fuelPrice = fuelPrice;
    }

    public int getPumpId() {
        return pumpId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getFuelUnit() {
        return fuelUnit;
    }

    public float getTotalFuelAmt() {
        return totalFuelAmt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        setChanged();
        notifyObservers(this.status);
    }

    public BigDecimal getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(BigDecimal fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public void setTotalFuelAmt(float totalFuelAmt) {
        if (totalFuelAmt >= 0) {
            this.totalFuelAmt = totalFuelAmt;
        }
    }

    @Override
    public String toString() {
        return this.getPumpId() + "- " + this.getFuelType();
    }

}
