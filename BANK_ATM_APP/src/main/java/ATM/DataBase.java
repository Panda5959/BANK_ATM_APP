/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM;

/**
 *
 * @author pc2
 */
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

public class DataBase {

    // JDBC URL for SQL Server connection
    private static final String JDBC_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=BANKSYSDB;encrypt=true;trustServerCertificate=true;";
    // Database credentials
    private static final String USERNAME = "loop";
    private static final String PASSWORD = "1234";

    public static String getValue(String columnName, String table, String condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String value = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for searching
            String sql = "SELECT " + columnName + " FROM " + table + " WHERE " + condition;

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Execute the search query
            resultSet = preparedStatement.executeQuery();

            // Check if the result set contains any rows
            if (resultSet.next()) {
                // Retrieve the value from the result set
                value = resultSet.getString(columnName);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to retrieve value. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return value;
    }

    public static boolean check_over_draft(int id, int fastcash) {
        int x = Integer.parseInt(getValue("OverDraftLimit", "Account", "Account_NO = " + id));
        if (fastcash <= x) {
            return true;
        }
        return false;
    }

    public static void Deposit(int id, double inc) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for updating
            String sql = "UPDATE Account SET Balance = ? WHERE Account_NO = ?;";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            preparedStatement.setDouble(1, inc + Double.parseDouble(getValue("Balance", "Account", "Account_NO = " + id)));
            preparedStatement.setInt(2, id);

            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " row(s) updated successfully.");

            JOptionPane.showMessageDialog(null, "Updated Successfully");
            String checkPhoneNumber = checkPhoneNumber(id);
            insertDataToTransaction((int) inc, checkPhoneNumber, id, "Deposit");
            
            try {
                SMTP.sendmail("you made a Deposit of $ " + inc);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to update data. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void FastCash(int id, int dec) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for updating
            String sql = "UPDATE Account SET Balance = ? WHERE Account_NO = ?;";
            String sql1 = "UPDATE Account SET OverDraftLimit = ? WHERE Account_NO = ?;";

            double balance = Double.parseDouble(getValue("Balance", "Account", "Account_NO = " + id));
            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);
            // Set parameters for the PreparedStatement
            preparedStatement.setDouble(1, balance - dec);
            preparedStatement.setInt(2, id);

            // Create a PreparedStatement object
            preparedStatement1 = connection.prepareStatement(sql1);

            // Set parameters for the PreparedStatement
            preparedStatement1.setInt(1, (int) (Integer.parseInt(getValue("OverDraftLimit", "Account", "Account_NO = " + id)) - dec));
            preparedStatement1.setInt(2, id);

            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();
            int rowsAffected1 = preparedStatement1.executeUpdate();

            System.out.println(rowsAffected + " row(s) updated successfully.");
            System.out.println(rowsAffected1 + " row(1) updated successfully.");
            JOptionPane.showMessageDialog(null, "Updated Successfully");
            String checkPhoneNumber = checkPhoneNumber(id);
            insertDataToTransaction((int) dec, checkPhoneNumber, id, "FastCash");
            try {
                SMTP.sendmail("you made a FastCash for $ " + dec);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to update data. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void Change_PIN(int id, String new_PIN) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for updating
            String sql = "UPDATE Customer SET Password = ? WHERE Customer_ID = ?";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            preparedStatement.setString(1, new_PIN);
            preparedStatement.setString(2, getValue("Account_NO", "Account INNER JOIN Customer ON Account.Customer_ID = Customer.Customer_ID", "Account_NO = " + id));
            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " row(s) updated successfully.");
            JOptionPane.showMessageDialog(null, "Updated Successfully");
            try {
                SMTP.sendmail("you Change your PIN");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to update data. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    // Method to insert data into the database
    public static void insertDataToTransaction(int amount, String contactNum, int accNum, String transType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        LocalDate localDate = now.toLocalDate();
        Date sqlDate = Date.valueOf(localDate);
        try {

            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for insertion
            String sql = """
                     INSERT INTO Transactionn (ContactNumber, AmountOfTransaction, Date, Transaction_Type, Account_NO)
                     Values 
                     ( ?, ?, ?, ?, ?);""";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            preparedStatement.setString(1, contactNum);
            preparedStatement.setInt(2, amount);
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, transType);
            preparedStatement.setInt(5, accNum);
            // Execute the insertion query
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " row(s) inserted successfully.");

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to insert data. Error message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static String checkPhoneNumber(int accNum) {
        try {
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
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e); //prints sqlException in jOptionPane
        }
        return null; //phone number not found
    }

    public static void main(String[] args) {
        // Test the insert, search, and update methods

    }
}
