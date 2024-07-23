/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamed Ahmed
 */
public class DatabaseHandler {
    protected int maxValue;
    protected double balance;
    protected int overDraftLimit;
    protected int charLimit = 0;
    protected String amount;
    protected int accNum;
    protected String contactNum = null;
    protected java.sql.Date currentDate;
    
    protected double checkBalance(String accNum){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           //gets balance of the Account
           PreparedStatement stmt = conn.prepareStatement("SELECT Balance FROM Account WHERE Account_NO =" + Integer.parseInt(accNum) + ";");
           ResultSet rs = stmt.executeQuery();
           rs.next();
           double balance = rs.getDouble("Balance");
           return balance;
           }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
        return -1;
    }
    
    protected int checkOverDraft(){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           //gets balance of the Account
           PreparedStatement stmt = conn.prepareStatement("SELECT OverDraftLimit FROM Account WHERE Account_NO =" + accNum + ";");
           ResultSet rs = stmt.executeQuery();
           rs.next();
           int overDraft = rs.getInt("OverDraftLimit");
           return overDraft;
           }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
        return -1;
    }
    
    protected String checkPhoneNumber(int accNum){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           StringBuilder sb = new StringBuilder();
           sb.append("""
                     SELECT person.ContactNumber, Account_NO
                     From Customer
                     JOIN Person on Person.SSN = Customer.SSN
                     JOIN Account on Customer.Customer_ID = Account.Customer_ID
                     Where Account.Account_NO = ?;""");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setInt(1, accNum);
           ResultSet rs = stmt.executeQuery();
           rs.next();
           String contactNumber = rs.getString("ContactNumber");
           return contactNumber; //phone number retrieved
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
        return null; //phone number not found
    }
    
    protected void updateBalance(double newBalance, int accNum){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           //Update balance in Account Table
           StringBuilder sb = new StringBuilder();
           sb.append("UPDATE Account SET Balance = ? WHERE Account_NO = ?;");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setDouble(1, newBalance);
           stmt.setInt(2, accNum);
           stmt.executeUpdate();
           }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
    }
    
    protected void updateOverDraft(int newOverDraft){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           //Update balance in Account Table
           StringBuilder sb = new StringBuilder();
           sb.append("update Account set OverDraftLimit = ? where Account_NO = ?;");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setInt(1, newOverDraft);
           stmt.setInt(2, accNum);
           stmt.executeUpdate();
           }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
    }
    
    protected void insertTransaction(int amount, String contactNum, int accNum, String transType){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           //Insert withdrawl process in Transactionn table
           StringBuilder sb = new StringBuilder();
           sb.append("""
                     INSERT INTO Transactionn (ContactNumber, AmountOfTransaction, Date, Transaction_Type, Account_NO)
                     Values 
                     ( ?, ?, ?, ?, ?);""");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setString(1, contactNum);
           stmt.setInt(2, amount);
           stmt.setDate(3, currentDate);
           stmt.setString(4, transType);
           stmt.setInt(5, accNum);
           stmt.executeUpdate();
           }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
    }
    
    public void setMaxLimit(){
        setOverDraft();
        setBalance();
        if(overDraftLimit <= balance)
            maxValue = overDraftLimit;
        else
            maxValue =  (int) balance;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }
    

    public int getCharLimit() {
        return charLimit;
    }

    public void setCharLimit(int charLimit) {
        this.charLimit = charLimit;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
    
    protected void setBalance() {
        this.balance = checkBalance(String.valueOf(accNum));
    }
    
    protected void setOverDraft(){
        this.overDraftLimit = checkOverDraft();
    }
}
