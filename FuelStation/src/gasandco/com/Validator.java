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
public class Validator {
    
    public static boolean numberInputValidator(String input) {
        if (input.equals(""))
            return false;
        if (!input.matches("[0-9]+"))
            return false;
        return true;
    }
}
