package gasandco.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

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

    // AtomicInteger count is used to auto-increment the chargeId on each fuel charge submission
    private static final AtomicInteger count = new AtomicInteger(0);
    private int chargeId;
    private FuelPump fuelPump;
    private float fuelAmount;
    private BigDecimal moneyAmount;
    private Customer customer;
    private BigDecimal moneyDiscount;
    private float fuelDiscount;
    
    public FuelCharge(FuelPump fuelPump, float fuelAmount, BigDecimal moneyAmount, Customer customer, DiscountStrategy discountStrategy) {
        chargeId = count.incrementAndGet();
        this.fuelPump = fuelPump;
        this.fuelAmount = fuelAmount;
        this.moneyAmount = moneyAmount;
        this.customer = customer;
        System.out.println(this.moneyAmount);
        System.out.println("Charge id is: " + this.chargeId);
        
        if (this.fuelAmount != 0) {
            calculateMoneyAmount(discountStrategy);
        } else if (this.moneyAmount != null) {
            calculateFuelAmount(discountStrategy);
        }
    }
    
    public int getChargeId() {
        return chargeId;
    }
    
    public float getFuelAmount() {
        return fuelAmount;
    }
    
    public FuelPump getFuelPump() {
        return fuelPump;
    }
    
    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }
    
    public void setFuelAmount(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    
    private void calculateFuelAmount(DiscountStrategy discountStrategy) {
        this.fuelAmount = this.moneyAmount.divide(this.fuelPump.getFuelType().getFuelPrice(), 2, RoundingMode.HALF_EVEN).floatValue();
        this.fuelDiscount = discountStrategy.applyDiscountFuelAmt(moneyAmount);
    }
    
    private void calculateMoneyAmount(DiscountStrategy discountStrategy) {
        this.moneyAmount = new BigDecimal(Float.toString(this.fuelAmount)).multiply(this.fuelPump.getFuelType().getFuelPrice());
        this.moneyDiscount = discountStrategy.applyDiscountMoneyAmt(fuelAmount);
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
    
    public BigDecimal getMoneyDiscount() {
        return moneyDiscount;
    }
    
    public float getFuelDiscount() {
        return fuelDiscount;
    }

//    public BigDecimal getTotal() {
//        return this.getMoneyAmount().multiply(new BigDecimal(Float.toString(this.getFuelAmount())));
//    }
    public void chargeInProgress() throws InterruptedException {
        fuelPump.setStatus("Dispensing");
        BigDecimal price = this.fuelPump.getFuelType().getFuelPrice();
        System.out.println(this.fuelAmount);
        int iterations = Math.round(this.fuelAmount);
        
        System.out.println("=========================");
        System.out.println(this.getMoneyDiscount());
        System.out.println("=========================");
        System.out.println(this.getFuelDiscount());
        final boolean isInteger = (iterations - this.fuelAmount == 0);
        if (this.getMoneyDiscount() == null && this.getFuelDiscount() > 0) {
            iterations = Math.round(this.getFuelDiscount() + this.fuelAmount);
        }
        if (iterations - this.fuelAmount > 0) {
            iterations--;
        }
        final int lastIteration = iterations;
        TimerTask task;
        for (int i = 0; i < iterations; i++) {
            BigDecimal currentPrice;
            String currentPriceString;
            String currentFuelAmount;
            currentPrice = new BigDecimal(String.valueOf(Math.round((i + 1) - this.getFuelDiscount()))).multiply(price);
            if (this.getMoneyDiscount() == null && this.getFuelDiscount() >= (i + 1)) {
                currentPrice = BigDecimal.ZERO;
            } else if (this.getMoneyDiscount() != null && currentPrice.compareTo(this.getMoneyDiscount()) <= 0 && this.getFuelDiscount() == 0) {
                currentPrice = BigDecimal.ZERO;
            } else if (this.getMoneyDiscount() != null && this.getFuelDiscount() == 0) {
                currentPrice = currentPrice.subtract(this.getMoneyDiscount());
            }
            currentFuelAmount = String.valueOf(i + 1);
            currentPriceString = currentPrice.toString();
            final String[] values = {currentPriceString, currentFuelAmount};
            Timer timer = new Timer();
            final int j = i;
            
            task = new TimerTask() {
                @Override
                public void run() {
                    setChanged();
                    notifyObservers(values);
                    if (isInteger && (j + 1) == lastIteration) {
                        fuelPump.setTotalFuelAmt(fuelAmount);
                        fuelPump.setStatus("Free");
                    }
                    cancel();
                }
            };
            timer.schedule(task, 500 * (j + 1), 100);
        }
        if (iterations < (this.fuelAmount + this.getFuelDiscount())) {
            String currentPrice = this.moneyAmount.toString();
            String currentFuelAmount = String.valueOf(this.fuelAmount);
            if (this.getMoneyDiscount() == null && this.getFuelDiscount() > 0) {
                currentFuelAmount = String.valueOf(this.getFuelDiscount() + this.fuelAmount);
            }
            final String[] values = {currentPrice, currentFuelAmount};
            Timer timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    setChanged();
                    notifyObservers(values);
                    fuelPump.setStatus("Free");
                    cancel();
                }
            };
            timer.schedule(task, 500 * (iterations + 1), 100);
        }
        
    }
    
    @Override
    public String toString() {
        return fuelPump.toString() + " ---- " + this.getFuelAmount() + "    " + this.getMoneyAmount();        
    }
    
}
