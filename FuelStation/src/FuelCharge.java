
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
    private int fuelPumpId;
    private String status;
    private float fuelAmount;
    private BigDecimal moneyAmount;
    private Customer client;

    public FuelCharge(int chargeId, int fuelPumpId) {
        this.chargeId = chargeId;
        this.fuelPumpId = fuelPumpId;
    }

    public int getChargeId() {
        return chargeId;
    }

    public String getStatus() {
        return status;
    }

    public float getFuelAmount() {
        return fuelAmount;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public Customer getClient() {
        return client;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFuelAmount(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    public BigDecimal getTotal() {
        return this.getMoneyAmount().multiply(new BigDecimal(Float.toString(this.getFuelAmount())));
    }
}
