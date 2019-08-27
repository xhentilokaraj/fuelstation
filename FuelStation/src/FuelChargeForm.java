/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FuelChargeForm extends JFrame {

    private JFrame fuelInputFrame;

    private JLabel pumpLabel;
    private JLabel customerLabel;
    private JLabel fuelAmtLabel;
    private JLabel moneyAmtLabel;
    private JScrollPane jScrollPane1;
    private JList pumpList;
    private JTextField customerInput;
    private JTextField fuelAmtInput;
    private JTextField moneyAmtInput;

    public FuelChargeForm() {
        fuelInputFrame = new JFrame("Input Fuel Charge");
        pumpLabel = new JLabel("Select Pump");
        customerLabel = new JLabel();
        fuelAmtLabel = new JLabel();
        moneyAmtLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        pumpList = new JList<>();
        customerInput = new JTextField();
        fuelAmtInput = new JTextField();
        moneyAmtInput = new JTextField();

        pumpLabel.setBounds(0, 0, 200, 30);
        fuelInputFrame.add(pumpLabel);
        fuelInputFrame.setSize(400, 400);
        fuelInputFrame.setLayout(null);
        fuelInputFrame.setVisible(true);
    }

}
