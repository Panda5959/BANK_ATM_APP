package com.mycompany.bank_management_system;

import ATM.LogIn;
import com.mycompany.bank_management_system.Loans.LoanApplicationFrame;
import com.mycompany.bank_management_system.Loans.LoansRecordFrame;
import com.mycompany.bank_management_system.CustomerInfo.CustomerInfoFrame;
import com.mycompany.bank_management_system.CustomerInfo.DisplayCustomerInfo;
import javax.swing.JOptionPane;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Employee extends javax.swing.JFrame {

    public Employee() {
        initComponents();
    }
    public static DisplayCustomerInfo info = new DisplayCustomerInfo();

    public Employee(int id) {
        initComponents();
        int Mid = id;
        idlbl.setText("" + Mid);
    }

    public void Cust_Table() {
        try {
            String sqlQuery = """
                   SELECT Person.*, Customer.Customer_ID,Customer.Income,Customer.Password,Loan.LoanID
                   FROM Person JOIN Customer ON Person.SSN = Customer.SSN 
                   join Loan on Customer.Customer_ID=Loan.Customer_ID;""";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();
            tbl_data.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        idlbl = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        addField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        emailF = new javax.swing.JTextField();
        ssnF = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addBTN = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        INCfield = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        passField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        LoanField = new javax.swing.JTextField();
        clearBTN = new javax.swing.JButton();
        filterBTN = new javax.swing.JButton();
        filterField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 72, 92));

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manager");

        update_btn.setBackground(new java.awt.Color(4, 72, 92));
        update_btn.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update Account");
        update_btn.setFocusable(false);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(4, 72, 92));
        delete_btn.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn.setText("delete Account");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(4, 72, 92));
        jButton4.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Display All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(4, 72, 92));
        jButton5.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Transactions");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(4, 72, 92));
        jButton6.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View Loans");
        jButton6.setPreferredSize(new java.awt.Dimension(149, 45));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 51, 0));
        jButton7.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Back");
        jButton7.setPreferredSize(new java.awt.Dimension(149, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID");

        idlbl.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        idlbl.setForeground(new java.awt.Color(255, 255, 255));

        jButton8.setBackground(new java.awt.Color(4, 72, 92));
        jButton8.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Apply for Loans");
        jButton8.setPreferredSize(new java.awt.Dimension(149, 45));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(delete_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(idlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jPanel2.setBackground(new java.awt.Color(4, 72, 92));

        jPanel5.setBackground(new java.awt.Color(4, 72, 92));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Customer Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        addField.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address");

        phoneField.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone");

        emailF.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        ssnF.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        jDateChooser1.setMinimumSize(new java.awt.Dimension(82, 28));
        jDateChooser1.setPreferredSize(new java.awt.Dimension(64, 28));

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DOB");

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SSN");

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("E-mail");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        addBTN.setBackground(new java.awt.Color(4, 72, 92));
        addBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        addBTN.setForeground(new java.awt.Color(255, 255, 255));
        addBTN.setText("Create New Account");
        addBTN.setFocusable(false);
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });

        nameField.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Income");

        INCfield.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Password");

        passField.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 21)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Loan_ID");

        LoanField.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N

        clearBTN.setBackground(new java.awt.Color(0, 0, 0));
        clearBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        clearBTN.setForeground(new java.awt.Color(255, 255, 255));
        clearBTN.setText("Clear");
        clearBTN.setFocusable(false);
        clearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTNActionPerformed(evt);
            }
        });

        filterBTN.setBackground(new java.awt.Color(0, 105, 139));
        filterBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        filterBTN.setForeground(new java.awt.Color(255, 255, 255));
        filterBTN.setText("Filter by ID");
        filterBTN.setFocusable(false);
        filterBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBTNActionPerformed(evt);
            }
        });

        filterField.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        filterField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterFieldActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 105, 139));
        searchButton.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search by ID");
        searchButton.setFocusable(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(ssnF, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailF, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(nameField))))
                .addGap(84, 84, 84)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(filterBTN))
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(INCfield, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(passField)
                    .addComponent(LoanField)
                    .addComponent(filterField))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(clearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(addBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addComponent(searchButton)
                        .addGap(18, 18, 18)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INCfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LoanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ssnF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addBTN)
                        .addComponent(clearBTN)
                        .addComponent(filterBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        tbl_data.setBorder(new javax.swing.border.MatteBorder(null));
        tbl_data.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tbl_data.setForeground(new java.awt.Color(51, 51, 51));
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_data.setGridColor(new java.awt.Color(220, 221, 222));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel3.setBackground(new java.awt.Color(4, 72, 92));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(4, 72, 92));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new LoansRecordFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        LOGIN SigninFrame = null;
        SigninFrame = new LOGIN();
        SigninFrame.setVisible(true);
        SigninFrame.pack();
        SigninFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Cust_Table();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void clearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTNActionPerformed
        nameField.setText("");
        emailF.setText("");
        ssnF.setText("");
        INCfield.setText("");
        passField.setText("");
        LoanField.setText("");
        phoneField.setText("");
        addField.setText("");
        filterField.setText("");
    }//GEN-LAST:event_clearBTNActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        int r = tbl_data.getSelectedRow();
        String click = (tbl_data.getModel().getValueAt(r, 8).toString());
        String sqlQuery;
        StringBuilder sb = new StringBuilder();
        sb.append("""
                   SELECT Person.*, Customer.Customer_ID,Customer.Income,Customer.Password,Loan.LoanID
                   FROM Person JOIN Customer ON Person.SSN = Customer.SSN 
                   join Loan on Customer.Customer_ID=Loan.Customer_ID
                   WHERE Customer.Customer_ID = ? ;""");
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
            PreparedStatement pst = conn.prepareStatement(sb.toString());
            pst.setInt(1, Integer.parseInt(click));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String SSN = rs.getString(1);
                String phone = rs.getString(2);
                String fname = rs.getString(3);
                String mname = rs.getString(4);
                String lname = rs.getString(5);
                String email = rs.getString(6);
                String add = rs.getString(7);
                Date dob = rs.getDate(8);
                String id = rs.getString(9);
                String income = rs.getString(10);
                String pass = rs.getString(11);
                String loan = rs.getString(12);
                String name = fname + " " + mname + " " + lname;
                nameField.setText(name);
                emailF.setText(email);
                ssnF.setText(SSN);
                INCfield.setText(income);
                passField.setText(pass);
                LoanField.setText(loan);
                phoneField.setText(phone);
                addField.setText(add);
                jDateChooser1.setDate(dob);
                filterField.setText(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tbl_dataMouseClicked

    private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNActionPerformed
        String SSN = ssnF.getText();
        String phone = phoneField.getText();
        String name = nameField.getText();
        String[] fullName = name.split(" ");
        String email = emailF.getText();
        String address = addField.getText();
        String income = INCfield.getText();
        String pass = passField.getText();
        String loan = LoanField.getText();
        java.util.Date selectedDate = jDateChooser1.getDate();
        java.sql.Date sqlDate = null;
        if (selectedDate != null) {
            // Convert java.util.Date to java.sql.Date
            sqlDate = new java.sql.Date(selectedDate.getTime());
        } else {
            // Handle the case when no date is selected
            JOptionPane.showMessageDialog(null, "Please select a valid date of birth.");
            return;
        }
        if (SSN.equals("") || phone.equals("") || name.equals("") || email.equals("") || address.equals("") || income.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "All data must be added!");
        } else if (SSN.length() != 9) {
            JOptionPane.showMessageDialog(null, "SSN must be 9 characters!");
        } else if (phone.length() != 10) {
            JOptionPane.showMessageDialog(null, "phone number must be 10 characters!");
        } else if (pass.length() != 4) {
            JOptionPane.showMessageDialog(null, "password must be 4 characters!");
        } else {
            try {
                String sql1 = "INSERT INTO Person (SSN, ContactNumber, FirstName, MidName, LastName, E_Mail, Address, DateOfBirth) VALUES('" + SSN + "','" + phone + "','" + fullName[0] + "','" + fullName[1] + "','" + fullName[2] + "','" + email + "','" + address + "','" + sqlDate + "')";
                String sql2 = "INSERT INTO Customer (Income,Password,SSN ,LoanID) VALUES('" + income + "','" + pass + "','" + SSN + "','" + loan + "')";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
                PreparedStatement pst1 = conn.prepareStatement(sql1);
                PreparedStatement pst2 = conn.prepareStatement(sql2);
                pst1.execute();
                pst2.execute();
                JOptionPane.showMessageDialog(null, "Customer added successfully !");
                Cust_Table();
                nameField.setText("");
                emailF.setText("");
                ssnF.setText("");
                INCfield.setText("");
                passField.setText("");
                LoanField.setText("");
                phoneField.setText("");
                addField.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_addBTNActionPerformed

    private void filterBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBTNActionPerformed
        String id = filterField.getText();
        String sqlQuery = """
        SELECT Person.*, 
        Customer.Customer_ID,Customer.Income,Customer.Password,Loan.LoanID
        FROM Person JOIN Customer ON Person.SSN = Customer.SSN 
        join Loan on Customer.Customer_ID=Loan.Customer_ID
        WHERE Customer.Customer_ID = '""" + id + "'";
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String SSN = rs.getString(1);
                String phone = rs.getString(2);
                String fname = rs.getString(3);
                String mname = rs.getString(4);
                String lname = rs.getString(5);
                String email = rs.getString(6);
                String add = rs.getString(7);
                Date dob = rs.getDate(8);
                String idd = rs.getString(9);
                String income = rs.getString(10);
                String pass = rs.getString(11);
                String loan = rs.getString(12);
                String name = fname + " " + mname + " " + lname;
                nameField.setText(name);
                emailF.setText(email);
                ssnF.setText(SSN);
                INCfield.setText(income);
                passField.setText(pass);
                LoanField.setText(loan);
                phoneField.setText(phone);
                addField.setText(add);
                filterField.setText(idd);
                jDateChooser1.setDate(dob);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_filterBTNActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        String SSN = ssnF.getText();
        String id = filterField.getText();
        String phone = phoneField.getText();
        String name = nameField.getText();
        String[] fullName = name.split(" ");
        String email = emailF.getText();
        String address = addField.getText();
        String income = INCfield.getText();
        String pass = passField.getText();
        String loan = LoanField.getText();
        java.util.Date selectedDate = jDateChooser1.getDate();
        java.sql.Date sqlDate = null;
        if (selectedDate != null) {
            // Convert java.util.Date to java.sql.Date
            sqlDate = new java.sql.Date(selectedDate.getTime());
        } else {
            // Handle the case when no date is selected
            JOptionPane.showMessageDialog(null, "Please select a valid date of birth.");
            return;
        }
        if (SSN.equals("") || phone.equals("") || name.equals("") || email.equals("") || address.equals("") || income.equals("") || pass.equals("") || loan.equals("")) {
            JOptionPane.showMessageDialog(null, "All data must be added!");
        } else if (SSN.length() != 9) {
            JOptionPane.showMessageDialog(null, "SSN must be 9 characters!");
        } else if (phone.length() != 10) {
            JOptionPane.showMessageDialog(null, "phone number must be 10 characters!");
        } else if (pass.length() != 4) {
            JOptionPane.showMessageDialog(null, "password must be 4 characters!");
        } else {
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
                String sql1 = "UPDATE Person SET ContactNumber = '" + phone
                        + "' ,FirstName = '" + fullName[0]
                        + "' ,MidName = '" + fullName[1]
                        + "' ,LastName = '" + fullName[2]
                        + "' ,E_Mail = '" + email
                        + "' ,Address = '" + address
                        + "' ,DateOfBirth = '" + sqlDate
                        + "' where SSN = '" + SSN + "'";

                String sql2 = "UPDATE Customer SET Income = '" + income
                        + "' ,Password = '" + pass
                        + "'WHERE SSN = '" + SSN + "'";

                PreparedStatement pst1 = conn.prepareStatement(sql1);
                PreparedStatement pst2 = conn.prepareStatement(sql2);

                pst1.execute();
                pst2.execute();
                JOptionPane.showMessageDialog(null, "Updated Successfully :)");
                Cust_Table();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        String SSN = ssnF.getText();
        String id = filterField.getText();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;", "Loop", "1234");
            String sq0 = "DELETE FROM Account WHERE Customer_ID = '" + id + "'";
            String sql = "DELETE FROM Customer WHERE Customer_ID = '" + id + "'";
            String sq2 = "DELETE FROM Person WHERE SSN = '" + SSN + "'";
            PreparedStatement pst0 = conn.prepareStatement(sq0);
            PreparedStatement pst1 = conn.prepareStatement(sql);
            PreparedStatement pst2 = conn.prepareStatement(sq2);
            pst0.execute();
            pst1.execute();
            pst2.execute();
            JOptionPane.showMessageDialog(null, "Customer deleted successfully :( ");
            Cust_Table();
            nameField.setText("");
            emailF.setText("");
            ssnF.setText("");
            INCfield.setText("");
            passField.setText("");
            LoanField.setText("");
            phoneField.setText("");
            addField.setText("");
            filterField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_delete_btnActionPerformed

    private void filterFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        int customerID = Integer.parseInt(searchField.getText());
        info.setCustomerID(customerID);
        if(info.isCustomerIDValid(customerID)){
            info.setCustomerID(customerID);
            info.setCustomerInfo();
            new CustomerInfoFrame().setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Customer ID not Found!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new LoanApplicationFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField INCfield;
    private javax.swing.JTextField LoanField;
    private javax.swing.JButton addBTN;
    private javax.swing.JTextField addField;
    private javax.swing.JButton clearBTN;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField emailF;
    private javax.swing.JButton filterBTN;
    private javax.swing.JTextField filterField;
    private javax.swing.JLabel idlbl;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField ssnF;
    private javax.swing.JTable tbl_data;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
