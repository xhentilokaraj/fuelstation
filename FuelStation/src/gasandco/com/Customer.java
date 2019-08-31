package gasandco.com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Customer {

    private int customerId;
    private String firstname;
    private String lastname;

    public Customer(int customerId, String firstname, String lastname) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
