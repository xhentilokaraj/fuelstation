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
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JComboBox pumpList;
    private JTextField customerInput;
    private JTextField fuelAmtInput;
    private JTextField moneyAmtInput;
    private JButton submitBtn;

    public FuelChargeForm() {
        fuelInputFrame = new JFrame("Input Fuel Charge");

        pumpLabel = new JLabel("Select Pump");
        pumpLabel.setBounds(10, 0, 200, 30);
        fuelInputFrame.add(pumpLabel);

        String pumps[] = {"1", "2", "3"};
        pumpList = new JComboBox(pumps);
        pumpList.setBounds(140, 0, 50, 30);
        fuelInputFrame.add(pumpList);

        customerLabel = new JLabel("Customer ID");
        customerLabel.setBounds(10, 40, 200, 30);
        fuelInputFrame.add(customerLabel);

        customerInput = new JTextField();
        customerInput.setBounds(140, 40, 120, 30);
        fuelInputFrame.add(customerInput);

        fuelAmtLabel = new JLabel("Fuel Amount");
        fuelAmtLabel.setBounds(10, 70, 200, 30);
        fuelInputFrame.add(fuelAmtLabel);

        fuelAmtInput = new JTextField();
        fuelAmtInput.setBounds(140, 70, 120, 30);
        fuelInputFrame.add(fuelAmtInput);

        moneyAmtLabel = new JLabel("Amuont in Euros");
        moneyAmtLabel.setBounds(10, 100, 200, 30);
        fuelInputFrame.add(moneyAmtLabel);

        moneyAmtInput = new JTextField();
        moneyAmtInput.setBounds(140, 100, 120, 30);
        fuelInputFrame.add(moneyAmtInput);

        submitBtn = new JButton("OK");
        submitBtn.setBounds(10, 170, 200, 20);
        fuelInputFrame.add(submitBtn);

        jScrollPane1 = new JScrollPane();

        fuelInputFrame.setSize(400, 400);
        fuelInputFrame.setLayout(null);
        fuelInputFrame.setVisible(true);
    }

}
