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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sultan
 */
public class PurchaseDetails extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseDetails
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null, rs2 = null;
    DefaultTableModel model;

    String billNo2, date2, supplierName2, discount2;
    int supplierID2;
    double totalAmount2, paidAmount2;

    public PurchaseDetails() {
        initComponents();
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTable1.getColumn("Quantity").setCellRenderer(centerRenderer);
        jTable1.getColumn("UOM").setCellRenderer(centerRenderer);
        jTable1.getColumn("Basic Purchase Cost (Rs.)").setCellRenderer(centerRenderer);
        jTable1.getColumn("Taxable Amount (Rs.)").setCellRenderer(centerRenderer);
        jTable1.getColumn("CGST (%)").setCellRenderer(centerRenderer);
        jTable1.getColumn("CGST (Rs.)").setCellRenderer(centerRenderer);
        jTable1.getColumn("SGST (%)").setCellRenderer(centerRenderer);
        jTable1.getColumn("SGST (Rs.)").setCellRenderer(centerRenderer);
        jTable1.getColumn("Grand Total (Rs.)").setCellRenderer(centerRenderer);
        
        c = DB.java_db();
        billNo2 = PurchaseReportForm.billNo1;
        date2 = PurchaseReportForm.date1;
        supplierName2 = PurchaseReportForm.supplierName1;
        discount2 = PurchaseReportForm.discount1;
        supplierID2 = PurchaseReportForm.supplierID1;
        totalAmount2 = PurchaseReportForm.totalAmount1;
        paidAmount2 = PurchaseReportForm.paidAmount1;
        model = (DefaultTableModel) jTable1.getModel();

        this.billNo.setText(billNo2);
        this.date.setText(date2);
        this.supplierName.setText(supplierName2);
        this.discount.setText(discount2);
        this.supplierID.setText(String.valueOf(supplierID2));
        this.totalAmount.setText(String.valueOf(totalAmount2) + " Rs.");
        this.paidAmount.setText(String.valueOf(paidAmount2) + " Rs.");
        try {
            s = c.createStatement();
            String sql = "SELECT * FROM ptdetails WHERE billNo='" + billNo2 + "' AND tdate='" + date2 + "' AND supplierID=" + supplierID2;
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String productID1 = rs.getString("productID");
                int quantity1 = rs.getInt("quantity");
                double taxableAmount1 = rs.getDouble("taxableAmount");
                double cgstp1 = rs.getDouble("cgstp");
                double cgsta1 = rs.getDouble("cgsta");
                double sgstp1 = rs.getDouble("sgstp");
                double sgsta1 = rs.getDouble("sgsta");
                double totalAmount1 = rs.getDouble("totalAmount");
                Object[] row = {productID1, "temp", quantity1, "temp", 0.0, taxableAmount1,
                    cgstp1, cgsta1, sgstp1, sgsta1, totalAmount1};
                this.model.addRow(row);
            }
            int rows = this.model.getRowCount();

            for (int i = 0; i < rows; i++) {
                int productID1 = Integer.parseInt((String) this.model.getValueAt(i, 0));
                rs = s.executeQuery("SELECT * FROM product WHERE productID=" + productID1);
                String productName1 = rs.getString("productName");
                String hsn1 = rs.getString("hsn");
                String measuringUnit1 = rs.getString("measuringUnit");
                double basicPurchaseRate1 = rs.getDouble("basicPurchaseRate");
                this.model.setValueAt(productName1, i, 0);
                this.model.setValueAt(hsn1, i, 1);
                this.model.setValueAt(measuringUnit1, i, 3);
                this.model.setValueAt(basicPurchaseRate1, i, 4);
            }
            double totalCGST1 = 0.0;
            double totalSGST1 = 0.0;
            double taxableAmount2 = 0.0;
            double totalAmount3 = 0.0;
            for (int i = 0; i < rows; i++) {
                double cgst2 = (double) this.model.getValueAt(i, 7);
                totalCGST1 += cgst2;
                double sgst2 = (double) this.model.getValueAt(i, 9);
                totalSGST1 += sgst2;
                double taxableAmount3 = (double) this.model.getValueAt(i, 5);
                taxableAmount2 += taxableAmount3;
                double totalAmount4 = (double) this.model.getValueAt(i, 10);
                totalAmount3 += totalAmount4;
            }
            String taxableAmount4 = taxableAmount2 + " Rs.";
            String totalCGST2 = totalCGST1 + " Rs.";
            String totalSGST2 = totalSGST1 + " Rs.";
            String totalGST2 = (totalCGST1 + totalSGST1) + " Rs.";
            String totalAmount5 = totalAmount3 + " Rs.";
            this.totalTaxableAmount.setText(taxableAmount4);
            this.totalCGST.setText(totalCGST2);
            this.totalSGST.setText(totalSGST2);
            this.totalGST.setText(totalGST2);
            this.grandTotal.setText(totalAmount5);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                s.close();
                c.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

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

        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        billNo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        supplierID = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        totalTaxableAmount = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalCGST = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalSGST = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        totalGST = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        supplierName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        grandTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        paidAmount = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PURCHASE DETAILS");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("PURCHASE BILL DETAILS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Bill No. :");

        billNo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        billNo.setForeground(new java.awt.Color(0, 153, 255));
        billNo.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Supplier ID :");

        supplierID.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        supplierID.setForeground(new java.awt.Color(0, 153, 255));
        supplierID.setText("jLabel5");

        date.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        date.setForeground(new java.awt.Color(0, 153, 255));
        date.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Date :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "HSN SAC", "Quantity", "UOM", "Basic Purchase Cost (Rs.)", "Taxable Amount (Rs.)", "CGST (%)", "CGST (Rs.)", "SGST (%)", "SGST (Rs.)", "Grand Total (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(150);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(4).setMinWidth(150);
            jTable1.getColumnModel().getColumn(5).setMinWidth(150);
            jTable1.getColumnModel().getColumn(6).setMinWidth(60);
            jTable1.getColumnModel().getColumn(7).setMinWidth(60);
            jTable1.getColumnModel().getColumn(8).setMinWidth(60);
            jTable1.getColumnModel().getColumn(9).setMinWidth(60);
            jTable1.getColumnModel().getColumn(10).setMinWidth(150);
        }

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("Total Amount Before Tax :");

        totalTaxableAmount.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalTaxableAmount.setForeground(new java.awt.Color(0, 153, 255));
        totalTaxableAmount.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 255));
        jLabel11.setText("Added CGST :");

        totalCGST.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalCGST.setForeground(new java.awt.Color(0, 153, 255));
        totalCGST.setText("jLabel12");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 255));
        jLabel13.setText("Added SGST :");

        totalSGST.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalSGST.setForeground(new java.awt.Color(0, 153, 255));
        totalSGST.setText("jLabel14");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 255));
        jLabel15.setText("Total GST :");

        totalGST.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalGST.setForeground(new java.awt.Color(0, 153, 255));
        totalGST.setText("jLabel16");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 255));
        jLabel17.setText("Discount :");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 255));
        jLabel18.setText("Total Amount :");

        totalAmount.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(0, 153, 255));
        totalAmount.setText("jLabel19");

        discount.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        discount.setForeground(new java.awt.Color(0, 153, 255));
        discount.setText("jLabel20");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Supplier Name :");

        supplierName.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        supplierName.setForeground(new java.awt.Color(0, 153, 255));
        supplierName.setText("jLabel5");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Grand Total :");

        grandTotal.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        grandTotal.setForeground(new java.awt.Color(0, 153, 255));
        grandTotal.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Paid Amount :");

        paidAmount.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        paidAmount.setForeground(new java.awt.Color(0, 153, 255));
        paidAmount.setText("jLabel14");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(billNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalTaxableAmount)
                    .addComponent(totalCGST)
                    .addComponent(totalSGST))
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(grandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalGST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(discount))
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalAmount)
                    .addComponent(paidAmount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(billNo)
                    .addComponent(jLabel4)
                    .addComponent(supplierID)
                    .addComponent(date)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(supplierName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(totalTaxableAmount)
                    .addComponent(jLabel15)
                    .addComponent(totalGST)
                    .addComponent(jLabel18)
                    .addComponent(totalAmount))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(totalCGST)
                    .addComponent(jLabel5)
                    .addComponent(grandTotal)
                    .addComponent(jLabel7)
                    .addComponent(paidAmount))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(totalSGST)
                    .addComponent(jLabel17)
                    .addComponent(discount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel billNo;
    public javax.swing.JLabel date;
    public javax.swing.JLabel discount;
    private javax.swing.JLabel grandTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel paidAmount;
    public javax.swing.JLabel supplierID;
    public javax.swing.JLabel supplierName;
    public javax.swing.JLabel totalAmount;
    public javax.swing.JLabel totalCGST;
    public javax.swing.JLabel totalGST;
    public javax.swing.JLabel totalSGST;
    public javax.swing.JLabel totalTaxableAmount;
    // End of variables declaration//GEN-END:variables

}
