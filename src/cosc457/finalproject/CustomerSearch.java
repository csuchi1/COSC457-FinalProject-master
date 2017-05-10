/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc457.finalproject;

import static cosc457.finalproject.NetBeans_connection_test.userName;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class CustomerSearch extends javax.swing.JFrame {

    static final String userName = "jrajew1";//put your MySQL user name
    static final String password = "Cosc*2awc";//put your MySQL password
    Connect connect = new Connect();
    

    /**
     * Creates new form CustomerSearch
     */
    public CustomerSearch() {
        initComponents();
        showTable();

    }

    public void showTable() {
        try {
            /////////
//            clearJtable();
            deleteAllRows();
            /////////
            connect.stat = connect.con.createStatement();
            String s1 = jTextField2.getText().trim();
            System.out.print(s1);
            String s2 = "select Customer.`Customer#`, Customer.`Name`, Job.JobName,Job.Location,Job.`Function`,Job.Edge,Job.`Date`, Job.`Color/Grade`, \n"
                    + "Job.`Granite/Quartz`, Job.`Granite/Quartz_Repair`,\n"
                    + "Job.SolidSurfaces, Job.SolidSurfaces_Repair, Job.L_Install, Job.Cabinet, Job.`Dropoff/Pickups`, Job.Tile,\n"
                    + "Quotes.QuoteID, Quotes.FollowUpDate, Quotes.Awarded, Quotes.Reason, Quotes.Price, Quotes.ContactLocation, \n"
                    + "Quotes.`Date`, Quotes.`Open/Closed`, Inventory.InventoryID, Invoices.`Invoice#`, Invoices.Install_date, Invoices.Due_date, Invoices.Check_Date,\n"
                    + "Invoices.Business, Invoices.Amount_due, Invoices.Total_Amount, Invoices.`PONum`\n"
                    + "from Customer \n"
                    + "join Invoices on Customer.`Customer#`=Invoices.`Customer#`\n"
                    + "join Inventory on Invoices.`Invoice#`=Inventory.`Invoice#`\n"
                    + "join Job on Invoices.`Invoice#`=Job.`Invoice#` \n"
                    + "join Quotes on Customer.`Customer#` = Quotes.`Customer#`";

            String s3 = " where Customer.Name like '%" + s1 + "%'";
            if (null != s1) {
                s2 = s2.concat(s3);
            }
            System.out.print(s2);

            connect.res = connect.stat.executeQuery(s2);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        try {
            while (connect.res.next()) {
                String CustomerNum = connect.res.getString(1);
                String Customer_Name = connect.res.getString(2);
                String JobName = connect.res.getString(3);
                String JobLocation = connect.res.getString(4);
                String Function = connect.res.getString(5);
                String Edge = connect.res.getString(6);
                String JobDate = connect.res.getString(7);
                String ColorGrade = connect.res.getString(8);
                String GraniteQuartz = connect.res.getString(9);
                String GraniteQuartzR = connect.res.getString(10);
                String SS = connect.res.getString(11);
                String SS_R = connect.res.getString(12);
                String L_Install = connect.res.getString(13);
                String Cabinet = connect.res.getString(14);
                String DropPickup = connect.res.getString(15);
                String Tile = connect.res.getString(16);
                String QuoteID = connect.res.getString(17);
                String FollowUpDate = connect.res.getString(18);
                String Awarded = connect.res.getString(19);
                String Reason = connect.res.getString(20);
                String Price = connect.res.getString(21);
                String ContactLocation = connect.res.getString(22);
                String QuoteDate = connect.res.getString(23);
                String OpenClosed = connect.res.getString(24);
                String InventoryID = connect.res.getString(25);
                String InvoiceNum = connect.res.getString(26);
                String Install_date = connect.res.getString(27);
                String Due_Date = connect.res.getString(28);
                String Check_Date = connect.res.getString(29);
                String Business = connect.res.getString(30);
                String Amount_Due = connect.res.getString(31);
                String Total_Amount = connect.res.getString(32);
                String PONum = connect.res.getString(33);

                Object[] content = {CustomerNum, Customer_Name, JobName, JobLocation, Function, Edge, JobDate, ColorGrade, GraniteQuartz, GraniteQuartzR, SS,
                    SS_R, L_Install, Cabinet, DropPickup, Tile, QuoteID, FollowUpDate, Awarded, Reason, Price, ContactLocation, QuoteDate, OpenClosed,
                    InventoryID, InvoiceNum, Install_date, Due_Date, Check_Date, Business, Amount_Due, Total_Amount, PONum};

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(content);

            }
            connect.ps.executeQuery();
            new CustomerSearch().setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Customer Search");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Customer Name: ");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Return to Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setText(" ");

        jScrollPane2.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer#", "Customer Name", "Job Name", "Job Location", "Function", "Edge", "Job Date", "Color/Grade", "G&Q", "G&Q Repair", "SS", "SS Repair", "L Install", "Cabinet", "Dropoff/Pickup", "Tile", "QuoteID", "Follow-up Date", "Awarded", "Reason", "Price", "Contact/Location", "Quote Date", "Open/Closed", "Inventory ID", "Invoice#", "Install Date", "Due Date", "Check Date", "Business", "Amount Due", "Total Amount", "PO#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(553, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Search Button TODO add your handling code here:
        //showTable();
        /**
         * try { String s2 = jTextField2.getText();
         *
         * connect.ps = connect.con.prepareStatement("select
         * Customer.`Customer#`, Customer.`Name`,
         * Job.JobName,Job.Location,Job.`Function`,Job.Edge,Job.`Date`,
         * Job.`Color/Grade`, \n" + "Job.`Granite/Quartz`,
         * Job.`Granite/Quartz_Repair`,\n" + "Job.SolidSurfaces,
         * Job.SolidSurfaces_Repair, Job.L_Install, Job.Cabinet,
         * Job.`Dropoff/Pickups`, Job.Tile,\n" + "Quotes.QuoteID,
         * Quotes.FollowUpDate, Quotes.Awarded, Quotes.Reason, Quotes.Price,
         * Quotes.ContactLocation, \n" + "Quotes.`Date`, Quotes.`Open/Closed`,
         * Inventory.InventoryID, Invoices.`Invoice#`, Invoices.Install_date,
         * Invoices.Due_date, Invoices.Check_Date,\n" + "Invoices.Business,
         * Invoices.Amount_due, Invoices.Total_Amount, Invoices.`PONum`\n" +
         * "from Customer \n" + "join Invoices on
         * Customer.`Customer#`=Invoices.`Customer#`\n" + "join Inventory on
         * Invoices.`Invoice#`=Inventory.`Invoice#`\n" + "join Job on
         * Invoices.`Invoice#`=Job.`Invoice#` \n" + "join Quotes on
         * Customer.`Customer#` = Quotes.`Customer#`\n" + "where
         * Customer.`Name`like '%"+s2+"%'");
         *
         * connect.ps.executeQuery(); new CustomerSearch().setVisible(true);
         * this.dispose(); } catch(Exception e) { System.out.println(e); } /**
         * while(connect.res.next()){ String CustomerNum =
         * connect.res.getString(1); String Customer_Name =
         * connect.res.getString(2); String JobName = connect.res.getString(3);
         * String JobLocation = connect.res.getString(4); String Function =
         * connect.res.getString(5); String Edge = connect.res.getString(6);
         * String JobDate = connect.res.getString(7); String ColorGrade =
         * connect.res.getString(8); String GraniteQuartz =
         * connect.res.getString(9); String GraniteQuartzR =
         * connect.res.getString(10); String SS = connect.res.getString(11);
         * String SS_R = connect.res.getString(12); String L_Install =
         * connect.res.getString(13); String Cabinet =
         * connect.res.getString(14); String DropPickup =
         * connect.res.getString(15); String Tile = connect.res.getString(16);
         * String QuoteID = connect.res.getString(17); String FollowUpDate =
         * connect.res.getString(18); String Awarded =
         * connect.res.getString(19); String Reason = connect.res.getString(20);
         * String Price = connect.res.getString(21); String ContactLocation =
         * connect.res.getString(22); String QuoteDate =
         * connect.res.getString(23); String OpenClosed =
         * connect.res.getString(24); String InventoryID =
         * connect.res.getString(25); String InvoiceNum =
         * connect.res.getString(26); String Install_date =
         * connect.res.getString(27); String Due_Date =
         * connect.res.getString(28); String Check_Date =
         * connect.res.getString(29); String Business =
         * connect.res.getString(30); String Amount_Due =
         * connect.res.getString(31); String Total_Amount =
         * connect.res.getString(32); String PONum = connect.res.getString(33);
         *
         * Object[] content = {CustomerNum, Customer_Name,
         * JobName,JobLocation,Function, Edge, JobDate, ColorGrade,
         * GraniteQuartz,GraniteQuartzR, SS, SS_R, L_Install, Cabinet,
         * DropPickup, Tile, QuoteID, FollowUpDate, Awarded, Reason, Price,
         * ContactLocation, QuoteDate, OpenClosed, InventoryID, InvoiceNum,
         * Install_date, Due_Date, Check_Date, Business, Amount_Due,
         * Total_Amount, PONum};
         *
         * DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
         * model.addRow(content);
         *
         * }
         * }
         * catch(Exception e) { // System.out.println("FAILED TO UPDATE");
         * System.out.println(e); }
         *
         */

        showTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Menu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void deleteAllRows() {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
//        for (int i = jTable1.getModel().getRowCount() - 1; i >= 0; i--) {
//            for (int j = jTable1.getModel().getColumnCount()-1; j>=0;j--)
//            jTable1.getModel().setValueAt(null, i, j);
//        }
    }

    private void clearJtable() {

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                jTable1.setValueAt("", i, j);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
