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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static shopmanagementsystem.PurchaseProductForm.c;

/**
 *
 * @author Sultan
 */
public class SaleDetails extends javax.swing.JFrame {

    /**
     * Creates new form SaleDetails
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null, rs2 = null;
    DefaultTableModel model;

    String billNo2, date2, customerName2, discount2;
    int customerID2;
    double totalAmount2, paidAmount2;

    public SaleDetails() {
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
        billNo2 = SaleReportForm.billNo1;
        date2 = SaleReportForm.date1;
        customerName2 = SaleReportForm.customerName1;
        discount2 = SaleReportForm.discount1;
        customerID2 = SaleReportForm.customerID1;
        totalAmount2 = SaleReportForm.totalAmount1;
        paidAmount2 = SaleReportForm.paidAmount1;
        model = (DefaultTableModel) jTable1.getModel();

        this.billNo.setText(billNo2);
        this.date.setText(date2);
        this.customerName.setText(customerName2);
        this.discount.setText(discount2);
        this.customerID.setText(String.valueOf(customerID2));
        this.totalAmount.setText(String.valueOf(totalAmount2) + " Rs.");
        this.paidAmount.setText(String.valueOf(paidAmount2) + " Rs.");
        try {
            s = c.createStatement();
            String sql = "SELECT * FROM stdetails WHERE billNo='" + billNo2 + "' AND tdate='" + date2 + "' AND customerID=" + customerID2;
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
                double basicSaleRate1 = rs.getDouble("basicSaleRate");
                this.model.setValueAt(productName1, i, 0);
                this.model.setValueAt(hsn1, i, 1);
                this.model.setValueAt(measuringUnit1, i, 3);
                this.model.setValueAt(basicSaleRate1, i, 4);
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

        totalGST = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        grandTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        paidAmount = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        totalTaxableAmount = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalCGST = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        billNo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerID = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalSGST = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SALE DETAILS");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        totalGST.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalGST.setForeground(new java.awt.Color(0, 153, 255));
        totalGST.setText("jLabel16");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 255));
        jLabel18.setText("Total Amount :");

        totalAmount.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(0, 153, 255));
        totalAmount.setText("jLabel19");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Grand Total :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Customer Name :");

        customerName.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        customerName.setForeground(new java.awt.Color(0, 153, 255));
        customerName.setText("jLabel5");

        grandTotal.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        grandTotal.setForeground(new java.awt.Color(0, 153, 255));
        grandTotal.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Paid Amount :");

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

        paidAmount.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        paidAmount.setForeground(new java.awt.Color(0, 153, 255));
        paidAmount.setText("jLabel14");

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("SALE BILL DETAILS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Bill No. :");

        billNo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        billNo.setForeground(new java.awt.Color(0, 153, 255));
        billNo.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Customer ID :");

        customerID.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        customerID.setForeground(new java.awt.Color(0, 153, 255));
        customerID.setText("jLabel5");

        date.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        date.setForeground(new java.awt.Color(0, 153, 255));
        date.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Date :");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 255));
        jLabel15.setText("Total GST :");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 255));
        jLabel13.setText("Added SGST :");

        totalSGST.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        totalSGST.setForeground(new java.awt.Color(0, 153, 255));
        totalSGST.setText("jLabel14");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 255));
        jLabel17.setText("Discount :");

        discount.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        discount.setForeground(new java.awt.Color(0, 153, 255));
        discount.setText("jLabel20");

        printButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        printButton.setForeground(new java.awt.Color(219, 112, 147));
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

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
                .addComponent(customerID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerName)
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
                    .addGroup(layout.createSequentialGroup()
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discount)
                            .addComponent(grandTotal)
                            .addComponent(totalGST))
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paidAmount)
                                    .addComponent(totalAmount)))))
                    .addComponent(jLabel1))
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
                    .addComponent(customerID)
                    .addComponent(date)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(customerName))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(totalSGST)
                        .addComponent(jLabel17)
                        .addComponent(discount)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
        int ans = JOptionPane.showConfirmDialog(this, "Do You Want To Print?", "Print Bill", JOptionPane.YES_NO_OPTION);
        if (ans == 0) {
            String city1 = "";
            String state1 = "";
            String gstin1 = "";
            String billNo1 = this.billNo.getText();
            String date1 = this.date.getText();
            String customerID1 = this.customerID.getText();
            String customerName1 = this.customerName.getText();
            try {
                s = c.createStatement();
                rs = s.executeQuery("SELECT * FROM customer WHERE customerID=" + customerID1);
                while (rs.next()) {
                    city1 = rs.getString("city");
                    state1 = rs.getString("state");
                    gstin1 = rs.getString("gstin");
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
            PrintForm pf = new PrintForm();
            pf.billNo.setText("Invoice No. : " + billNo1);
            pf.date.setText("Invoice Date : " + date1);
            pf.supplyDate.setText("Date Of Supply : " + date1);

            pf.customerName.setText("Name : " + customerName1);
            pf.customerName1.setText("Name : " + customerName1);
            pf.customerAddress.setText("Address : " + city1);
            pf.customerAddress1.setText("Address : " + city1);
            pf.customerGSTIN.setText("GSTIN : " + gstin1);
            pf.customerGSTIN1.setText("GSTIN : " + gstin1);
            pf.customerState.setText("State : " + state1);
            pf.customerState1.setText("State : " + state1);
            String stateCode1 = pf.stateCodeGen(state1);
            pf.customerStateCode.setText("State Code : " + stateCode1);
            pf.customerStateCode1.setText("State Code : " + stateCode1);
            
            int rows2 = this.model.getRowCount();
            double taxableAmount2 = 0.0;
            double afterTax = 0.0;
            double cgsta1 = 0.0;
            double sgsta1 = 0.0;
            int SrNo = 1;
            for (int i = 0; i < rows2; i++) {
                String productName2 = (String) this.model.getValueAt(i, 0);
                String hsn2 = (String) this.model.getValueAt(i, 1);
                double rate2 = (double) this.model.getValueAt(i, 4);
                int quantity2 = (int) this.model.getValueAt(i, 2);
                double taxableAmt = (double) this.model.getValueAt(i, 5);
                taxableAmount2 += taxableAmt;
                double cgstp2 = (double) this.model.getValueAt(i, 6);
                double cgsta3 = (double) this.model.getValueAt(i, 7);
                cgsta1 += cgsta3;
                double sgstp2 = (double) this.model.getValueAt(i, 8);
                double sgsta3 = (double) this.model.getValueAt(i, 9);
                sgsta1 += sgsta3;
                double totalAmount3 = (double) this.model.getValueAt(i, 10);
                afterTax += totalAmount3;
                Object[] rowData = {SrNo, productName2, hsn2, Double.parseDouble(new DecimalFormat("##.##").format(rate2)),
                    quantity2,Double.parseDouble(new DecimalFormat("##.##").format(taxableAmt)), cgstp2, Double.parseDouble(new DecimalFormat("##.##").format(cgsta3)),
                    sgstp2, Double.parseDouble(new DecimalFormat("##.##").format(sgsta3)), Double.parseDouble(new DecimalFormat("##.##").format(totalAmount3))};
                pf.model.addRow(rowData);
                SrNo++;
            }
            pf.taxableAmount.setText("Total Amount Before Tax : " + new DecimalFormat("##.##").format(taxableAmount2) + " Rs.");
            pf.totalCGST.setText("Add : CGST : " + new DecimalFormat("##.##").format(cgsta1) + " Rs.");
            pf.totalSGST.setText("Add : SGST : " + new DecimalFormat("##.##").format(sgsta1) + " Rs.");
            pf.totalGST.setText("Tax Amount : GST : " + new DecimalFormat("##.##").format((cgsta1 + sgsta1)) + " Rs.");
            pf.amountWithTax.setText("Total Amount After Tax : " + new DecimalFormat("##.##").format(afterTax) + " Rs.");
            String discount1 = this.discount.getText();
            String grandTotal1 = this.totalAmount.getText();
            grandTotal1 = grandTotal1.replace(" Rs.", "");
            double grandTotal2 = Double.parseDouble(grandTotal1);
            pf.discount.setText("Discount : " + discount1);
            int num1 = (int) grandTotal2;
            double rf = grandTotal2 - num1;
            pf.roundoff.setText("Round Off : " + new DecimalFormat("##.##").format(rf) + " Rs.");
            pf.totalAmount.setText("Total Amount : " + new DecimalFormat("##.##").format(num1) + ".00 Rs.");
            int num = (int) grandTotal2;
            String words1 = (NumberFormat.getInstance().format(grandTotal2) + "='" + PrintForm.convert(num) + "'");
            words1 = words1.replaceAll("[^a-zA-Z ]", "");
            pf.words.setText(words1+" Rs.");
            pf.printOnPaper();
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
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
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel billNo;
    public javax.swing.JLabel customerID;
    public javax.swing.JLabel customerName;
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
    private javax.swing.JButton printButton;
    public javax.swing.JLabel totalAmount;
    public javax.swing.JLabel totalCGST;
    public javax.swing.JLabel totalGST;
    public javax.swing.JLabel totalSGST;
    public javax.swing.JLabel totalTaxableAmount;
    // End of variables declaration//GEN-END:variables

}
