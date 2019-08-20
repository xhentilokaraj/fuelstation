/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FuelPump {

    private int pumpId;
    private String fuelType;
    private String fuelUnit;
    private float totalFuelAmt;

    public FuelPump(int pumpId, String fuelType, String fuelUnit, float totalFuelAmt) {
        this.pumpId = pumpId;
        this.fuelType = fuelType;
        this.fuelUnit = fuelUnit;
        this.totalFuelAmt = totalFuelAmt;
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

    public void setTotalFuelAmt(float totalFuelAmt) {
        if (totalFuelAmt >= 0)
        this.totalFuelAmt = totalFuelAmt;
    }

    @Override
    public String toString() {
        return "FuelPump{" + "pumpId=" + pumpId + ", fuelType=" + fuelType + ", fuelUnit=" + fuelUnit + ", totalFuelAmt=" + totalFuelAmt + '}';
    }

}
