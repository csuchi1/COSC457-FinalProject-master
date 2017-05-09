/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc457.finalproject;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author csuchite95
 */ 
public class NetBeans_connection_test {

    static final String userName = "jrajew1";//put your MySQL user name
    static final String password = "Cosc*2awc";//put your MySQL password
    private static Connection connection = null;

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    
   public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SQLException {

        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jrajew1db", userName, password);// Please use your database name here
        PreparedStatement updateP;
        Statement queryStatement = connection.createStatement();
        updateP = null;
        String querys = "select * from jrajew1db.Customer;";
        ResultSet results = queryStatement.executeQuery(querys);
        while (results.next()) {
            System.out.print(results.getString("Customer#"));
            System.out.print("    ");
            System.out.print(results.getString("name"));
            System.out.println();
        }
        //querys = "UPDATE csuchi1db.P SET pname = 'Test' WHERE pname = 'Nut';";
        //updateP = connection.prepareStatement(querys);
        //updateP.executeUpdate();

    }

}
