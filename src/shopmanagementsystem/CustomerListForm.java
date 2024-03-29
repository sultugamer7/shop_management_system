/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sultan
 */
public class CustomerListForm extends javax.swing.JFrame {

    /**
     * Creates new form CustomerListForm
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null;
    DefaultTableModel model;

    public CustomerListForm() {
        initComponents();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        customerTable.getColumn("ID").setCellRenderer(centerRenderer);
        customerTable.getColumn("Mobile No.").setCellRenderer(centerRenderer);
        customerTable.getColumn("City").setCellRenderer(centerRenderer);
        customerTable.getColumn("Balance Payment (Rs.)").setCellRenderer(centerRenderer);

        c = DB.java_db();

        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = (DefaultTableModel) customerTable.getModel();
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM customer");
            double balPayment = 0.0;
            while (rs.next()) {
                String customerID1 = rs.getString("customerID");
                String customerName1 = rs.getString("customerName");
                String mobile1 = rs.getString("mobile");
                String city1 = rs.getString("city");
                double customerBalancePayment1 = rs.getInt("customerBalancePayment");
                balPayment += customerBalancePayment1;
                Object[] row = {customerID1, customerName1, mobile1, city1, customerBalancePayment1};
                model.addRow(row);
            }
            this.totalBalancePayment.setText("Total Balance Payment : "+String.valueOf(balPayment)+" Rs.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(CustomerListForm.this, e);
        } finally {
            try {
                rs.close();
                s.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(CustomerListForm.this, e);
            }
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        detailsButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        customerSelector = new javax.swing.JTextField();
        totalBalancePayment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CUSTOMER LIST");
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(138, 43, 226));
        jLabel2.setText("Customer Name :");

        detailsButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        detailsButton.setForeground(new java.awt.Color(219, 112, 147));
        detailsButton.setText("Full Details");
        detailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsButtonActionPerformed(evt);
            }
        });

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Mobile No.", "City", "Balance Payment (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setMaxWidth(60);
            customerTable.getColumnModel().getColumn(1).setMinWidth(250);
            customerTable.getColumnModel().getColumn(2).setMinWidth(100);
            customerTable.getColumnModel().getColumn(3).setMinWidth(150);
            customerTable.getColumnModel().getColumn(4).setMinWidth(120);
        }

        customerSelector.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                customerSelectorCaretUpdate(evt);
            }
        });

        totalBalancePayment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalBalancePayment.setForeground(new java.awt.Color(138, 43, 226));
        totalBalancePayment.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jSeparator4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(customerSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 346, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(totalBalancePayment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(customerSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalBalancePayment)
                .addGap(12, 12, 12))
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

    private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = this.customerTable.getSelectedRow();
            String ID = (String) this.customerTable.getValueAt(selectedRow, 0);
            String customerSelector1 = (String) this.customerTable.getValueAt(selectedRow, 1);
            if (customerSelector1.equals("")) {
                JOptionPane.showMessageDialog(this, "No Product Selected!");
            } else {
                CustomerSearchForm csf = new CustomerSearchForm();
                csf.setVisible(true);
                csf.customerName.setSelectedItem(customerSelector1 + " - " + ID);
                csf.searchButton.doClick();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Customer Selected!");
        }
    }//GEN-LAST:event_detailsButtonActionPerformed

    private void customerSelectorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_customerSelectorCaretUpdate
        // TODO add your handling code here:
        String customerSelector1 = this.customerSelector.getText();
        model.setRowCount(0);
        if (!customerSelector1.equals("")) {
            try {
                s = c.createStatement();
                rs = s.executeQuery("SELECT * FROM customer WHERE customerName LIKE '" + customerSelector1 + "%'");
                while (rs.next()) {
                    String customerID1 = rs.getString("customerID");
                    String customerName1 = rs.getString("customerName");
                    String mobile1 = rs.getString("mobile");
                    String city1 = rs.getString("city");
                    int customerBalancePayment1 = rs.getInt("customerBalancePayment");
                    Object[] row = {customerID1, customerName1, mobile1, city1, customerBalancePayment1};
                    model.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            } finally {
                try {
                    rs.close();
                    s.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            }
        } else {
            try {
                s = c.createStatement();
                rs = s.executeQuery("SELECT * FROM customer");
                while (rs.next()) {
                    String customerID1 = rs.getString("customerID");
                    String customerName1 = rs.getString("customerName");
                    String mobile1 = rs.getString("mobile");
                    String city1 = rs.getString("city");
                    int customerBalancePayment1 = rs.getInt("customerBalancePayment");
                    Object[] row = {customerID1, customerName1, mobile1, city1, customerBalancePayment1};
                    model.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            } finally {
                try {
                    rs.close();
                    s.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            }
        }
    }//GEN-LAST:event_customerSelectorCaretUpdate

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerListForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customerSelector;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton detailsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel totalBalancePayment;
    // End of variables declaration//GEN-END:variables
}
