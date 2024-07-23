/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_system.Loans;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mohamed Ahmed
 */
public class LoanDBManager {
    private int customerID;
    private double amount;
    private double interestRate;
    private Date startDate;
    private Date endDate;
    
    public boolean isValidAmount (JTextField textField){
        boolean valid = true;
        String text = textField.getText().trim();
        if (text.isEmpty())
            valid = false;
        else {
            int value = Integer.parseInt(text);
            if(value<2000)
                valid = false;
        }
        return valid;
    }
    
    private void insertLoan() {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           StringBuilder sb = new StringBuilder();
           sb.append("""
                     INSERT INTO Loan ( Amount, StartDate, EndDate, Status, Avail, Customer_ID)
                     VALUES 
                         ( ?, ?, ?, 'Pending', ?, ?);""");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setDouble(1, amount);
           stmt.setDate(2, dateToSqlDate(startDate));
           stmt.setDate(3, dateToSqlDate(endDate));
           stmt.setDouble(4, interestRate);
           stmt.setInt(5, customerID);
           stmt.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
    }
    
    private java.sql.Date dateToSqlDate(Date date){
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    
    public void applyForLoan(){
        insertLoan();
    }
    
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
    
    public boolean isCustomerIDValid (int customerID){
        return checkCustomerID(customerID);
    }
    
    private String sqlDateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String text = df.format(date);
        return text;
    }
    
    private ResultSet loansRS() throws Exception{
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           StringBuilder sb = new StringBuilder();
           sb.append("""
                     SELECT Loan.LoanID, Loan.Amount, Loan.StartDate, Loan.EndDate, Loan.Status, Loan.Avail, Loan.Customer_ID
                     From Loan
                     Where Customer_ID=?;""");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setInt(1, customerID);
           ResultSet rs = stmt.executeQuery();
           if(!rs.isBeforeFirst())
               JOptionPane.showMessageDialog(null, "No Loans found!", "Warning", JOptionPane.WARNING_MESSAGE);
           return rs; //return resultset with all loans information about the customer
           }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
        return null;
    }
    
    private DefaultTableModel resultsetToTableModel (ResultSet rs) throws SQLException{
            // create an uneditable DefaultTablemodel
            DefaultTableModel TableModel = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                    return false;
                    }
            };
            // create ResultSetMetaData to retrive data from the ResultSet
            ResultSetMetaData metaData = rs.getMetaData();
            // Add the column names to the model
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
            TableModel.addColumn(metaData.getColumnName(i));
            }
            // Add the rows to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                TableModel.addRow(row);
            }

        return TableModel;
    }
    
    public TableModel loansTableModel(){
        TableModel model = null;
        try {
            model = resultsetToTableModel(loansRS());
        } catch (Exception ex) {
            Logger.getLogger(LoanDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    private class CenteredTableCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            ((JLabel) cellComponent).setHorizontalAlignment(SwingConstants.CENTER);
            return cellComponent;
        }
    }
    
    public void centerTableCells(JTable table) {
        CenteredTableCellRenderer renderer = new CenteredTableCellRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
}
