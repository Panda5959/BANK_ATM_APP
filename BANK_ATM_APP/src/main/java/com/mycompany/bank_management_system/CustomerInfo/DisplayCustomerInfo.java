/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_system.CustomerInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamed Ahmed
 */
public class DisplayCustomerInfo {
    private int customerID;
    private int bankNum;
    private int overDraft;
    private String firstName;
    private String midName;
    private String lastName;
    private String SSN;
    private String address;
    private String accType;
    private String accStatus;
    private String openDate;
    private double balance;
    private double income;
    
    private boolean checkCustomerID(int customerID){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           StringBuilder sb = new StringBuilder();
           sb.append("SELECT * from Customer WHERE Customer_ID = ?;");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setInt(1, customerID);
           ResultSet rs = stmt.executeQuery();
           //check if resultset is not empty
           if(rs.next())
               return true; //customer_ID is found
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
        return false; //customer_ID not found
    }
    
    private void setVariables(){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           StringBuilder sb = new StringBuilder();
           sb.append("""
                     SELECT Person.FirstName,Person.MidName,Person.LastName,Person.SSN,Person.Address,Customer.Customer_ID,Customer.Income,Account.Account_Type,Account.Status,Account.Balance,Account.DateOpened,Account.OverDraftLimit,Account.Bank_NO
                     From Customer
                     JOIN Account ON Customer.Customer_ID=Account.Customer_ID
                     JOIN Person ON Person.SSN=Customer.SSN
                     WHERE Customer.Customer_ID = ?""");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setInt(1, customerID);
           ResultSet rs = stmt.executeQuery();
           //move to first row
           rs.next();
           //set customer Information to its corresponding variables
           firstName = rs.getString("FirstName");
           midName = rs.getString("MidName");
           lastName = rs.getString("LastName");
           SSN = rs.getString("SSN");
           address = rs.getString("Address");
           income = rs.getDouble("Income");
           accType = rs.getString("Account_Type");
           accStatus = rs.getString("Status");
           balance = rs.getDouble("Balance");
           openDate = sqlDateToString(rs.getDate("DateOpened"));
           overDraft = rs.getInt("OverDraftLimit");
           bankNum = rs.getInt("Bank_NO");
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
    }
    
    private String sqlDateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String text = df.format(date);
        return text;
    }
    public void setCustomerInfo(){
        setVariables();
    }
    
    public boolean isCustomerIDValid (int customerID){
        return checkCustomerID(customerID);
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    

    public String getCustomerID() {
        return String.valueOf(customerID);
    }

    public String getBankNum() {
        return String.valueOf(bankNum);
    }

    public String getOverDraft() {
        return String.valueOf(overDraft);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidName() {
        return midName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public String getAddress() {
        return address;
    }

    public String getAccType() {
        return accType;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getBalance() {
        return String.valueOf(balance);
    }

    public String getIncome() {
        return String.valueOf(income);
    }
    
}
