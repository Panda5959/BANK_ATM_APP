/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_app.CashTracker;

import com.mycompany.atm_app.DatabaseHandler;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohamed Ahmed
 */
public class cashTrackerFunctions extends DatabaseHandler{

    public cashTrackerFunctions() {}
    
    public void loadVariables(){
        this.balance = super.checkBalance(String.valueOf(super.accNum));
    }
    
    public void dateSetter(JDateChooser calender, String date){
        try {
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            calender.setDate(date2);
        }catch (ParseException e) {
            System.out.println(e);
        }
    }
    
    public void currentDateSetter(JDateChooser calender){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = dateFormat.format(new java.util.Date());
        dateSetter(calender, currentDateString);
    }
    
    private java.sql.Date javaDateToSqlDate(java.util.Date date){
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    
    private DefaultTableModel returnTranscationHistory(JDateChooser startCalender, JDateChooser endCalender){
        java.sql.Date startDate = javaDateToSqlDate(startCalender.getDate());
        java.sql.Date endDate = javaDateToSqlDate(endCalender.getDate());
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
           //gets Customer_ID of the Account
           StringBuilder sb = new StringBuilder();
           sb.append("""
                     SELECT 
                     \tTransaction_ID, AmountOfTransaction as 'Amount', Date, Transaction_Type as Type, ATM_ID
                     \tFROM Transactionn WHERE Account_NO = ? AND (Date BETWEEN ? AND ?);""");
           PreparedStatement stmt = conn.prepareStatement(sb.toString());
           stmt.setInt(1, super.accNum);
           stmt.setDate(2, startDate);
           stmt.setDate(3, endDate);
           ResultSet rs = stmt.executeQuery();
           DefaultTableModel history;
           history = resultsetToTableModel(rs);
           return history;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
        return null;
    }
    
    //Converts SQL ResultSet into a DefaultTableModel
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
    
    public DefaultTableModel transcationsModel(JDateChooser startCalender, JDateChooser endCalender){
        return returnTranscationHistory(startCalender, endCalender);
    }
    
    private class CenteredTableCellRenderer extends DefaultTableCellRenderer {
        @Override
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

    public void updateBalance() {
        this.balance = super.checkBalance(String.valueOf(super.accNum));
    }

    
    public double getBalance() {
        return balance;
    }
    
}
