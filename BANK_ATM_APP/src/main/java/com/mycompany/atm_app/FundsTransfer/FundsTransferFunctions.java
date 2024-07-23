/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_app.FundsTransfer;

import com.mycompany.atm_app.DatabaseHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Mohamed Ahmed
 */
public class FundsTransferFunctions extends DatabaseHandler{
    private String targetAccNum;
    private String targetAccContactNum;
    private double targetAccBalance;

    public void CheckAndUpdate (JTextField textField){
        String text = textField.getText();
                if (!text.isEmpty()) {
                    try {
                        int value = Integer.parseInt(text);
                        if (value > maxValue) {
                            textField.setText(String.valueOf(maxValue));
                        }
                    } catch (NumberFormatException ex) {
                    }
                }
    }
    
    private int checkTargetAccNumber(String targetAccNum){
        try{
           String sqlQuery = "SELECT * FROM Account WHERE Account_NO='" + targetAccNum + "'";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           PreparedStatement stmt = conn.prepareStatement(sqlQuery);
           ResultSet rs = stmt.executeQuery();
           rs.next();
           targetAccNum = rs.getString("Account_NO");
           if(targetAccNum.equals(String.valueOf(accNum))){
               return 1; //targetAccNum is the same account
           }else{
               return 2; //targetAccNum exists
           }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return 3; //targetAccNum doesn't exist
    }
    
    public int isTargetAccountValid(String targetAccNum){
        return checkTargetAccNumber(targetAccNum);
    }
    
    private void insertOutgoingTransaction(){
        double newBalance = balance - Integer.parseInt(amount);
        updateBalance(newBalance, accNum);
        insertTransaction(-Integer.parseInt(amount), contactNum, accNum, "Outgoing Transaction");
    }
    
    private void insertIngoingTransaction(){
        setTargetAccBalance();
        double newBalance = targetAccBalance + Integer.parseInt(amount);
        updateBalance(newBalance, Integer.parseInt(targetAccNum));
        insertTransaction(Integer.parseInt(amount), checkPhoneNumber(Integer.parseInt(targetAccNum)), Integer.parseInt(targetAccNum), "Ingoing Transaction");
    }
    
    public void insertTransferProcess(){
        insertOutgoingTransaction();
        insertIngoingTransaction();
    }

    public boolean isValidAmount (JTextField textField){
        boolean valid = true;
        String text = textField.getText().trim();
        if (text.isEmpty())
            valid = false;
        else {
            int value = Integer.parseInt(text);
            if(value<50)
                valid = false;
        }
        return valid;
    }
    
    public FundsTransferFunctions (int charLimit) {
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

    public void setTargetAccNumber(String targetAccNum) {
        this.targetAccNum = targetAccNum;
    }

    public String getTargetAccNumber() {
        return targetAccNum;
    }
    
    public void setTransferAmount(String widrawAmount) {
        this.amount = widrawAmount;
    }
    
    public void setTargetAccContactNum(String targetAccContactNum) {
        this.targetAccContactNum = checkPhoneNumber(Integer.parseInt(targetAccNum));
    }

    public void setTargetAccBalance() {
        this.targetAccBalance = checkBalance(targetAccNum);
    }
    
    public String getTransferAmount() {
        return amount;
    }

    public String getContactNumber() {
        return contactNum;
    }
    
}
