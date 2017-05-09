/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc457.finalproject;
import com.mysql.jdbc.Connection;
import static cosc457.finalproject.NetBeans_connection_test.userName;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
/**
 *
 * @author Kevin
 */
public class Connect 
{
    public Connection con;
    public Statement stat;
    public ResultSet res;
    public PreparedStatement pstat;
    static final String userName = "jrajew1";//put your MySQL user name
    static final String password = "Cosc*2awc";//put your MySQL password
    
   public Connect()
    {
        systemConnection();
    }
    public void systemConnection(){
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jrajew1db", userName, password);
           stat = (Statement) con.createStatement();
           JOptionPane.showMessageDialog(null, "Connected");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Not Connected");
        }
    }
}
