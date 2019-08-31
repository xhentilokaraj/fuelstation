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
public class FuelCharge {

    private int chargeId;
    private FuelPump fuelPump;
    private float fuelAmount;
    private BigDecimal moneyAmount;
    private Customer customer;

    public FuelCharge(int chargeId, FuelPump fuelPump, float fuelAmount, BigDecimal moneyAmount, Customer customer) {
        this.chargeId = chargeId;
        this.fuelPump = fuelPump;
        this.fuelAmount = fuelAmount;
        this.moneyAmount = moneyAmount;
        this.customer = customer;
    }
    

    public int getChargeId() {
        return chargeId;
    }

    public float getFuelAmount() {
        return fuelAmount;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }



    public void setFuelAmount(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }



    public BigDecimal getTotal() {
        return this.getMoneyAmount().multiply(new BigDecimal(Float.toString(this.getFuelAmount())));
    }
}
