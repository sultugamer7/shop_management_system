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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Sultan
 */
public class SupplierSearchForm extends javax.swing.JFrame {

    /**
     * Creates new form SupplierSearchForm
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null;

    public SupplierSearchForm() {
        initComponents();
        c = DB.java_db();

        AutoCompleteDecorator.decorate(supplierName);

        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM supplier ORDER BY supplierName ASC");
            while (rs.next()) {
                int supplierID1 = rs.getInt("supplierID");
                String supplierName1 = rs.getString("supplierName");
                this.supplierName.addItem(supplierName1 + " - " + supplierID1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SupplierSearchForm.this, e);
        } finally {
            try {
                rs.close();
                s.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(SupplierSearchForm.this, e);
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

        jLabel1 = new javax.swing.JLabel();
        supplierName = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mobile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        streetAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        state = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        gstin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        supplierBalancePayment = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SEARCH SUPPLIER");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(138, 43, 226));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Supplier Name :");

        supplierName.setEditable(true);
        supplierName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel8.setForeground(new java.awt.Color(138, 43, 226));
        jLabel8.setText("Balance Payment :");

        mobile.setEditable(false);
        mobile.setFocusable(false);

        jLabel2.setForeground(new java.awt.Color(138, 43, 226));
        jLabel2.setText("Mobile Number :");

        streetAddress.setEditable(false);
        streetAddress.setFocusable(false);

        jLabel3.setForeground(new java.awt.Color(138, 43, 226));
        jLabel3.setText("Street Address :");

        city.setEditable(false);
        city.setFocusable(false);

        jLabel4.setForeground(new java.awt.Color(138, 43, 226));
        jLabel4.setText("City :");

        state.setEditable(false);
        state.setFocusable(false);

        jLabel5.setForeground(new java.awt.Color(138, 43, 226));
        jLabel5.setText("State :");

        gstin.setEditable(false);
        gstin.setFocusable(false);

        jLabel6.setForeground(new java.awt.Color(138, 43, 226));
        jLabel6.setText("GSTIN");

        pan.setEditable(false);
        pan.setFocusable(false);

        jLabel7.setForeground(new java.awt.Color(138, 43, 226));
        jLabel7.setText("PAN Number :");

        supplierBalancePayment.setEditable(false);
        supplierBalancePayment.setFocusable(false);

        searchButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(219, 112, 147));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supplierBalancePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(supplierBalancePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String supplierName1 = (String) this.supplierName.getEditor().getItem();
        int flag = 0;
        int count = this.supplierName.getItemCount();
        for (int i = 1; i < count; i++) {
            String supplierName2 = this.supplierName.getItemAt(i);
            if (supplierName1.equals(supplierName2)) {
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }
        mobile.setText("");
        streetAddress.setText("");
        city.setText("");
        state.setText("");
        gstin.setText("");
        pan.setText("");
        supplierBalancePayment.setText("");
        if (flag == 1) {
            String str = this.supplierName.getSelectedItem().toString();
            String val = str.replaceAll("\\s", "");

            if (!val.equals("")) {
                String cID = str.replaceAll("[^0-9]", "");
                int supplierID1 = Integer.parseInt(cID);
                try {
                    s = c.createStatement();
                    String sql = "SELECT * FROM supplier WHERE supplierID=" + supplierID1;
                    rs = s.executeQuery(sql);
                    String mobile1, streetAddress1, city1, state1,
                            gstin1, pan1, supplierBalancePayment1;
                    mobile1 = streetAddress1 = city1 = state1
                            = gstin1 = pan1 = supplierBalancePayment1 = "";
                    while (rs.next()) {
                        mobile1 = rs.getString("mobile");
                        streetAddress1 = rs.getString("streetAddress");
                        city1 = rs.getString("city");
                        state1 = rs.getString("state");
                        gstin1 = rs.getString("gstin");
                        pan1 = rs.getString("pan");
                        supplierBalancePayment1 = rs.getString("supplierBalancePayment");
                    }
                    mobile.setText(mobile1);
                    streetAddress.setText(streetAddress1);
                    city.setText(city1);
                    state.setText(state1);
                    gstin.setText(gstin1);
                    pan.setText(pan1);
                    supplierBalancePayment.setText(supplierBalancePayment1);
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
        } else {
            JOptionPane.showMessageDialog(this, "Supplier Not Added/Selected!");
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            //Will dispose CustomerAddForm
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
                new SupplierSearchForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField city;
    private javax.swing.JTextField gstin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField pan;
    public javax.swing.JButton searchButton;
    private javax.swing.JTextField state;
    private javax.swing.JTextField streetAddress;
    private javax.swing.JTextField supplierBalancePayment;
    public javax.swing.JComboBox<String> supplierName;
    // End of variables declaration//GEN-END:variables
}
