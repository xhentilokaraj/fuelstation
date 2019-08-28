/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class PumpDisplay {

    private JFrame pumpDisplayFrame;

    private JLabel pumpStatusLbl;
    private JTextField pumpStatus;
    private JLabel fuelAmtLbl;
    private JTextField fuelAmt;
    private JLabel moneyAmtLbl;
    private JTextField moneyAmt;

    public PumpDisplay() {
        pumpDisplayFrame = new JFrame("Fuel Pump");

        pumpStatusLbl = new JLabel("Fuel Pump Status");
        pumpStatusLbl.setBounds(10, 0, 200, 30);
        pumpDisplayFrame.add(pumpStatusLbl);
        
        pumpStatus = new JTextField();
        pumpStatus.setBounds(140, 0, 100, 30);
        pumpDisplayFrame.add(pumpStatus);
        
        fuelAmtLbl = new JLabel("Fuel Amount");
        fuelAmtLbl.setBounds(10, 40, 200, 30);
        pumpDisplayFrame.add(fuelAmtLbl);
        
        fuelAmt = new JTextField();
        fuelAmt.setBounds(140, 40, 120, 30);
        pumpDisplayFrame.add(fuelAmt);
        
        moneyAmtLbl = new JLabel("Amount in Euro");
        moneyAmtLbl.setBounds(10, 70, 200, 30);
        pumpDisplayFrame.add(moneyAmtLbl);
        
        moneyAmt = new JTextField();
        moneyAmt.setBounds(140, 70, 120, 30);
        pumpDisplayFrame.add(moneyAmt);

        pumpDisplayFrame.setSize(400, 400);
        pumpDisplayFrame.setLayout(null);
        pumpDisplayFrame.setVisible(true);

    }

}
