package gasandco.com;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class FuelCharge extends Observable {

    private int chargeId;
    private FuelPump fuelPump;
    private float fuelAmount;
    private BigDecimal moneyAmount;
    private Customer customer;

    public FuelCharge(FuelPump fuelPump, float fuelAmount, BigDecimal moneyAmount, Customer customer) {
//        this.chargeId = chargeId;
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

    public void calculateFuelAmount() {
        this.fuelAmount = this.moneyAmount.divide(this.fuelPump.getFuelPrice()).setScale(2, RoundingMode.DOWN).floatValue();
    }

    public void calculateMoneyAmount() {
        this.moneyAmount =  new BigDecimal(Float.toString(this.fuelAmount)).multiply(this.fuelPump.getFuelPrice());
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    public BigDecimal getTotal() {
        return this.getMoneyAmount().multiply(new BigDecimal(Float.toString(this.getFuelAmount())));
    }

    public public void chargeInProgress() {
        int setChanged
        ();
        String changes[
        2] = [];
        notifyObservers(this.status);
    }

    @Override
    public String toString() {
        return fuelPump.toString() + " ---- " + this.getFuelAmount() + "    " + this.getMoneyAmount(); //To change body of generated methods, choose Tools | Templates.
    }

}
