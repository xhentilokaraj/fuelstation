package gasandco.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

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
        System.out.println("test");
        System.out.println(this.moneyAmount);
        if (this.fuelAmount != 0) {
            calculateMoneyAmount();
        } else if (this.moneyAmount != null) {
            calculateFuelAmount();
        }

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
        this.fuelAmount = this.moneyAmount.divide(this.fuelPump.getFuelType().getFuelPrice(), 2, RoundingMode.HALF_EVEN).floatValue();
    }

    public void calculateMoneyAmount() {
        this.moneyAmount = new BigDecimal(Float.toString(this.fuelAmount)).multiply(this.fuelPump.getFuelType().getFuelPrice());
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

    public void chargeInProgress() throws InterruptedException {
        BigDecimal price = this.fuelPump.getFuelType().getFuelPrice();
        System.out.println(fuelAmount);
        int iterations = Math.round(fuelAmount);
        for (int i = 0; i < iterations; i++) {
            Timer timer = new Timer();
            final int j = i;

            TimerTask task;
            task = new TimerTask() {
                @Override
                public void run() {
                    setChanged();
                    notifyObservers(j + 1);
                    cancel();
                }
            };
            timer.schedule(task, 500 * (j + 1), 100);
        }
    }

    @Override
    public String toString() {
        return fuelPump.toString() + " ---- " + this.getFuelAmount() + "    " + this.getMoneyAmount(); //To change body of generated methods, choose Tools | Templates.
    }

}
