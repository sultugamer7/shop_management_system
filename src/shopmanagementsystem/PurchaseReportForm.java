/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sultan
 */
public class PurchaseReportForm extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseReportForm
     */
    static String billNo1, date1, supplierName1, discount1;
    static int supplierID1;
    static double totalAmount1, paidAmount1;
    Connection c = null;
    Statement s = null;
    ResultSet rs = null;
    DefaultTableModel model;

    private void populate() {
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM purchaseTransaction");
            String billNo1 = "", date1 = "", discount1 = "";
            int supplierID1 = 0;
            double totalAmount1 = 0, netBill1 = 0, paidAmount1 = 0;
            while (rs.next()) {
                billNo1 = rs.getString("billNo");
                date1 = rs.getString("tdate");
                supplierID1 = rs.getInt("supplierID");
                totalAmount1 = rs.getDouble("totalAmount");
                double discountP1 = rs.getDouble("discountP");
                double discountR1 = rs.getDouble("discountR");
                if (discountP1 == 0.0 && discountR1 == 0.0) {
                    discount1 = "0.0 Rs.";
                } else {
                    if (discountP1 == 0.0) {
                        discount1 = discountR1 + " Rs.";
                    } else {
                        discount1 = discountP1 + " %";
                    }
                }
                netBill1 = rs.getDouble("grandtotal");
                paidAmount1 = rs.getDouble("paidAmount");
                Object[] row = {billNo1, date1, supplierID1, totalAmount1, discount1, netBill1, paidAmount1};
                model.addRow(row);
            }
            int rows = this.purchaseDetailsTable.getRowCount();
            for (int i = 0; i < rows; i++) {
                int supplierID2 = (int) this.purchaseDetailsTable.getValueAt(i, 2);
                rs = s.executeQuery("SELECT * FROM supplier WHERE supplierID=" + supplierID2);
                String supplierName1 = "";
                while (rs.next()) {
                    supplierName1 = rs.getString("supplierName");
                }
                this.purchaseDetailsTable.setValueAt(supplierName1, i, 2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        } finally {
            try {
                rs.close();
                s.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }

    public PurchaseReportForm() {
        initComponents();
        c = DB.java_db();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        purchaseDetailsTable.getColumn("Bill No.").setCellRenderer(centerRenderer);
        purchaseDetailsTable.getColumn("Date").setCellRenderer(centerRenderer);
        purchaseDetailsTable.getColumn("Total Amount (Rs.)").setCellRenderer(centerRenderer);
        purchaseDetailsTable.getColumn("Discount").setCellRenderer(centerRenderer);
        purchaseDetailsTable.getColumn("Net Bill (Rs.)").setCellRenderer(centerRenderer);
        purchaseDetailsTable.getColumn("Paid Amount (Rs.)").setCellRenderer(centerRenderer);

        this.fromDate.setEditor(new JSpinner.DateEditor(this.fromDate, "dd/MM/yyyy"));
        this.toDate.setEditor(new JSpinner.DateEditor(this.toDate, "dd/MM/yyyy"));
        this.purchaseDetailsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = (DefaultTableModel) purchaseDetailsTable.getModel();

        populate();

        //Full Screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseDetailsTable = new javax.swing.JTable();
        supplierSelector = new javax.swing.JTextField();
        fromDate = new javax.swing.JSpinner();
        toDate = new javax.swing.JSpinner();
        fullDetailsButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PURCHASE REPORT");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("SEARCH CRITERIA :");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Supplier Name :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Search Duration - From : ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("To :");

        purchaseDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill No.", "Date", "Supplier Name", "Total Amount (Rs.)", "Discount", "Net Bill (Rs.)", "Paid Amount (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(purchaseDetailsTable);
        if (purchaseDetailsTable.getColumnModel().getColumnCount() > 0) {
            purchaseDetailsTable.getColumnModel().getColumn(0).setMaxWidth(100);
            purchaseDetailsTable.getColumnModel().getColumn(1).setMaxWidth(120);
            purchaseDetailsTable.getColumnModel().getColumn(2).setMaxWidth(320);
            purchaseDetailsTable.getColumnModel().getColumn(3).setMinWidth(120);
            purchaseDetailsTable.getColumnModel().getColumn(3).setMaxWidth(200);
            purchaseDetailsTable.getColumnModel().getColumn(4).setMaxWidth(150);
            purchaseDetailsTable.getColumnModel().getColumn(5).setMinWidth(120);
            purchaseDetailsTable.getColumnModel().getColumn(5).setMaxWidth(200);
            purchaseDetailsTable.getColumnModel().getColumn(6).setMinWidth(120);
            purchaseDetailsTable.getColumnModel().getColumn(6).setMaxWidth(200);
        }

        fromDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(-19800000L), new java.util.Date(-19800000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        toDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(-19800000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        fullDetailsButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        fullDetailsButton.setForeground(new java.awt.Color(219, 112, 147));
        fullDetailsButton.setText("Full Details");
        fullDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullDetailsButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(219, 112, 147));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(supplierSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(fullDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 262, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1)
                                .addGap(40, 40, 40))
                            .addComponent(jSeparator4))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(supplierSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fullDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullDetailsButtonActionPerformed
        // TODO add your handling code here:

        try {
            int selectedRow = this.purchaseDetailsTable.getSelectedRow();
            supplierName1 = (String) this.model.getValueAt(selectedRow, 2);
            if (supplierName1.equals("")) {
                JOptionPane.showMessageDialog(this, "No Bill Selected!");
            } else {
                billNo1 = (String) this.model.getValueAt(selectedRow, 0);
                date1 = (String) this.model.getValueAt(selectedRow, 1);
                discount1 = (String) this.model.getValueAt(selectedRow, 4);
                totalAmount1 = (double) this.model.getValueAt(selectedRow, 5);
                paidAmount1 = (double) this.model.getValueAt(selectedRow, 6);
                supplierID1 = 0;
                s = c.createStatement();
                String sql1 = "SELECT * FROM purchasetransaction WHERE billNo='" + billNo1 + "' AND tdate='" + date1 + "'";
                rs = s.executeQuery(sql1);
                while (rs.next()) {
                    supplierID1 = rs.getInt("supplierID");
                }
                PurchaseDetails pd = new PurchaseDetails();

                pd.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Bill Selected!");
        } finally {
            try {
                rs.close();
                s.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_fullDetailsButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        this.model.setRowCount(0);
        String supplierSelector1 = this.supplierSelector.getText();
        Date fromDate1 = (Date) this.fromDate.getValue();
        Date toDate1 = (Date) this.toDate.getValue();
//        String fromDate2 = (fromDate1.getYear())+1900+"-"+(fromDate1.getMonth()+1)+"-"+fromDate1.getDate();
//        String toDate2 = (toDate1.getYear()+1900)+"-"+(toDate1.getMonth()+1)+"-"+toDate1.getDate();
        String fromDateYear = (fromDate1.getYear() + 1900) + "";
        String fromDateMonth = "";
        if ((fromDate1.getMonth() + 1) < 10) {
            fromDateMonth = "0" + (fromDate1.getMonth() + 1);
        } else {
            fromDateMonth = +(fromDate1.getMonth() + 1) + "";
        }
        String fromDateDate = "";
        if ((fromDate1.getDate()) < 10) {
            fromDateDate = "0" + (fromDate1.getDate());
        } else {
            fromDateDate = +(fromDate1.getDate()) + "";
        }
        String fromDate2 = fromDateYear + "-" + fromDateMonth + "-" + fromDateDate;

        String toDateYear = (toDate1.getYear() + 1900) + "";
        String toDateMonth = "";
        if ((toDate1.getMonth() + 1) < 10) {
            toDateMonth = "0" + (toDate1.getMonth() + 1);
        } else {
            toDateMonth = +(toDate1.getMonth() + 1) + "";
        }
        String toDateDate = "";
        if ((toDate1.getDate()) < 10) {
            toDateDate = "0" + (toDate1.getDate());
        } else {
            toDateDate = +(toDate1.getDate()) + "";
        }
        String toDate2 = toDateYear + "-" + toDateMonth + "-" + toDateDate;

        ResultSet rs2 = null;
        if (!supplierSelector1.equals("")) {
            try {
                s = c.createStatement();
                rs = s.executeQuery("SELECT * FROM supplier WHERE supplierName LIKE '" + supplierSelector1 + "%'");
                while (rs.next()) {
                    int supplierID3 = rs.getInt("supplierID");
                    try {
                        rs2 = s.executeQuery("SELECT * FROM purchaseTransaction WHERE supplierID='" + supplierID3 + "' AND (substr(tdate, 7, 4) || '-' || substr(tdate, 4, 2) || '-' || substr(tdate, 1, 2)) between '" + fromDate2 + "' and '" + toDate2 + "'");
                        String billNo1 = "", date1 = "", discount1 = "";
                        int supplierID1 = 0;
                        double totalAmount1 = 0, netBill1 = 0, paidAmount1 = 0;
                        while (rs2.next()) {
                            billNo1 = rs2.getString("billNo");
                            date1 = rs2.getString("tdate");
                            supplierID1 = rs2.getInt("supplierID");
                            totalAmount1 = rs2.getDouble("totalAmount");
                            double discountP1 = rs2.getDouble("discountP");
                            double discountR1 = rs2.getDouble("discountR");
                            if (discountP1 == 0.0 && discountR1 == 0.0) {
                                discount1 = "0.0 Rs.";
                            } else {
                                if (discountP1 == 0.0) {
                                    discount1 = discountR1 + " Rs.";
                                } else {
                                    discount1 = discountP1 + " %";
                                }
                            }
                            netBill1 = rs2.getDouble("grandtotal");
                            paidAmount1 = rs2.getDouble("paidAmount");
                            Object[] row = {billNo1, date1, supplierID1, totalAmount1, discount1, netBill1, paidAmount1};
                            model.addRow(row);
                        }
                        int rows = this.purchaseDetailsTable.getRowCount();
                        for (int i = 0; i < rows; i++) {
                            int supplierID2 = (int) this.purchaseDetailsTable.getValueAt(i, 2);
                            rs = s.executeQuery("SELECT * FROM supplier WHERE supplierID=" + supplierID2);
                            String supplierName1 = "";
                            while (rs.next()) {
                                supplierName1 = rs.getString("supplierName");
                            }
                            this.purchaseDetailsTable.setValueAt(supplierName1, i, 2);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    } finally {
                        try {
                            rs2.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e);
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            } finally {
                try {
                    rs.close();
                    s.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            }
        } else {
            try {
                s = c.createStatement();
                rs = s.executeQuery("SELECT * FROM supplier");
                while (rs.next()) {
                    try {
                        rs2 = s.executeQuery("SELECT * FROM purchaseTransaction WHERE (substr(tdate, 7, 4) || '-' || substr(tdate, 4, 2) || '-' || substr(tdate, 1, 2)) between '" + fromDate2 + "' and '" + toDate2 + "'");
                        String billNo1 = "", date1 = "", discount1 = "";
                        int supplierID1 = 0;
                        double totalAmount1 = 0, netBill1 = 0, paidAmount1 = 0;
                        while (rs2.next()) {
                            billNo1 = rs2.getString("billNo");
                            date1 = rs2.getString("tdate");
                            supplierID1 = rs2.getInt("supplierID");
                            totalAmount1 = rs2.getDouble("totalAmount");
                            double discountP1 = rs2.getDouble("discountP");
                            double discountR1 = rs2.getDouble("discountR");
                            if (discountP1 == 0.0 && discountR1 == 0.0) {
                                discount1 = "0.0 Rs.";
                            } else {
                                if (discountP1 == 0.0) {
                                    discount1 = discountR1 + " Rs.";
                                } else {
                                    discount1 = discountP1 + " %";
                                }
                            }
                            netBill1 = rs2.getDouble("grandtotal");
                            paidAmount1 = rs2.getDouble("paidAmount");
                            Object[] row = {billNo1, date1, supplierID1, totalAmount1, discount1, netBill1, paidAmount1};
                            model.addRow(row);
                        }
                        int rows = this.purchaseDetailsTable.getRowCount();
                        for (int i = 0; i < rows; i++) {
                            int supplierID2 = (int) this.purchaseDetailsTable.getValueAt(i, 2);
                            rs = s.executeQuery("SELECT * FROM supplier WHERE supplierID=" + supplierID2);
                            String supplierName1 = "";
                            while (rs.next()) {
                                supplierName1 = rs.getString("supplierName");
                            }
                            this.purchaseDetailsTable.setValueAt(supplierName1, i, 2);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    } finally {
                        try {
                            rs2.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e);
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            } finally {
                try {
                    rs.close();
                    s.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            c.close();
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(PurchaseReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseReportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner fromDate;
    private javax.swing.JButton fullDetailsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable purchaseDetailsTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField supplierSelector;
    private javax.swing.JSpinner toDate;
    // End of variables declaration//GEN-END:variables
}
