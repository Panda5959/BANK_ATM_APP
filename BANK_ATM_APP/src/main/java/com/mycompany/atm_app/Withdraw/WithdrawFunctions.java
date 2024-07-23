/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_app.Withdraw;
import com.mycompany.atm_app.DatabaseHandler;
import javax.swing.JTextField;
/**
 *
 * @author Mohamed Ahmed
 */
public class WithdrawFunctions extends DatabaseHandler{
    
    public void insertWithdrawProcess(int amount){
        double newBalance = balance - amount;
        int newOverDraft = overDraftLimit - amount;
        updateOverDraft(newOverDraft);
        updateBalance(newBalance, accNum);
        insertTransaction(-amount, contactNum, accNum, "Withdraw");
    }

    public void CheckAndUpdate (JTextField textField){
        String text = textField.getText();
                if (!text.isEmpty()) {
                    try {
                        int value = Integer.parseInt(text);
                        if (value > maxValue) {
                            textField.setText(String.valueOf(maxValue));
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Hello World!");
                    }
                }
    }
    
    public int isValidAmount (JTextField textField){
        String text = textField.getText().trim();
        if (text.isEmpty())
            return 2;
        else {
            int value = Integer.parseInt(text);
            if(value<50)
                return 3;
        }
        return 1;
    }
            
    public WithdrawFunctions(int charLimit) {
        this.charLimit = charLimit;
        updateCurrentDate();
    }
    
    public void loadVariables(){
        this.contactNum = super.checkPhoneNumber(accNum);
        this.balance = super.checkBalance(String.valueOf(accNum));
    }
    
    private void updateCurrentDate(){
        java.util.Date date = new java.util.Date();
        this.currentDate = new java.sql.Date(date.getTime());
    }
    

    public void setWithdrawAmount(String amount) {
        int value = Integer.parseInt(amount);
        value = (value/50)*50;
        amount = String.valueOf(value);
        this.amount = amount;
    }

    public String getWithdrawAmount() {
        return amount;
    }

    public String getContactNum() {
        return contactNum;
    }
    
}
