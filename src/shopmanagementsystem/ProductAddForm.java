/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Sultan
 */
public class ProductAddForm extends javax.swing.JFrame {

    /**
     * Creates new form ProductAddForm
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null;

    public ProductAddForm() {
        initComponents();
        c = DB.java_db();

        //Setting all error msgs to null
        error1.setText("");
        error2.setText("");
        error3.setText("");
        error4.setText("");
        error5.setText("");
        error6.setText("");
        error7.setText("");
        error8.setText("");
        error9.setText("");
        error10.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        hsn = new javax.swing.JTextField();
        measuringUnit = new javax.swing.JComboBox<>();
        gst = new javax.swing.JComboBox<>();
        purchaseRate = new javax.swing.JTextField();
        basicPurchaseRate = new javax.swing.JTextField();
        basicSaleRate = new javax.swing.JTextField();
        saleRate = new javax.swing.JTextField();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        error6 = new javax.swing.JLabel();
        error7 = new javax.swing.JLabel();
        error8 = new javax.swing.JLabel();
        error9 = new javax.swing.JLabel();
        error10 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        safetyStock = new javax.swing.JSpinner();
        quantity = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ADD PRODUCT");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(138, 43, 226));
        jLabel1.setText("Product Name* :");

        jLabel2.setForeground(new java.awt.Color(138, 43, 226));
        jLabel2.setText("HSN SAC :");

        jLabel3.setForeground(new java.awt.Color(138, 43, 226));
        jLabel3.setText("Measuring Unit* :");

        jLabel4.setForeground(new java.awt.Color(138, 43, 226));
        jLabel4.setText("GST %* :");

        jLabel5.setForeground(new java.awt.Color(138, 43, 226));
        jLabel5.setText("Purchase Rate/Unit* :");

        jLabel6.setForeground(new java.awt.Color(138, 43, 226));
        jLabel6.setText("<html>Basic Purchase Rate/Unit :<br/>(Without GST)</html>");

        jLabel8.setForeground(new java.awt.Color(138, 43, 226));
        jLabel8.setText("<html>Basic Sale Rate/Unit :<br/>(Without GST)</html>");

        jLabel9.setForeground(new java.awt.Color(138, 43, 226));
        jLabel9.setText("Sale Rate/Unit* :");

        jLabel11.setForeground(new java.awt.Color(138, 43, 226));
        jLabel11.setText("Safety Stock :");

        jLabel12.setForeground(new java.awt.Color(138, 43, 226));
        jLabel12.setText("Initial Quantity :");

        productName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                productNameCaretUpdate(evt);
            }
        });
        productName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                productNameFocusLost(evt);
            }
        });

        hsn.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                hsnCaretUpdate(evt);
            }
        });
        hsn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hsnFocusLost(evt);
            }
        });

        measuringUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Bag", "Box", "Brass", "Bundle", "Cu. Ft.", "Doz.", "Foot", "Kg.", "Litre.", "m2", "m3", "Mtr.", "Nos.", "Pouch", "Sq. Ft.", "Ton", "rmt" }));
        measuringUnit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                measuringUnitItemStateChanged(evt);
            }
        });
        measuringUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                measuringUnitFocusLost(evt);
            }
        });

        gst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "12", "14", "18", "28" }));
        gst.setToolTipText("");
        gst.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gstItemStateChanged(evt);
            }
        });
        gst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                gstFocusLost(evt);
            }
        });

        purchaseRate.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                purchaseRateCaretUpdate(evt);
            }
        });
        purchaseRate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                purchaseRateFocusLost(evt);
            }
        });

        basicPurchaseRate.setEditable(false);
        basicPurchaseRate.setFocusable(false);

        basicSaleRate.setEditable(false);
        basicSaleRate.setFocusable(false);

        saleRate.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                saleRateCaretUpdate(evt);
            }
        });
        saleRate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                saleRateFocusLost(evt);
            }
        });

        error1.setForeground(new java.awt.Color(255, 0, 0));
        error1.setText("error1");

        error2.setForeground(new java.awt.Color(255, 0, 0));
        error2.setText("error2");

        error3.setForeground(new java.awt.Color(255, 0, 0));
        error3.setText("error3");

        error4.setForeground(new java.awt.Color(255, 0, 0));
        error4.setText("error4");

        error5.setForeground(new java.awt.Color(255, 0, 0));
        error5.setText("error5");

        error6.setForeground(new java.awt.Color(255, 0, 0));
        error6.setText("error6");

        error7.setForeground(new java.awt.Color(255, 0, 0));
        error7.setText("error7");

        error8.setForeground(new java.awt.Color(255, 0, 0));
        error8.setText("error8");

        error9.setForeground(new java.awt.Color(255, 0, 0));
        error9.setText("error9");

        error10.setForeground(new java.awt.Color(255, 0, 0));
        error10.setText("error10");

        addButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(219, 112, 147));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(219, 112, 147));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("Rs.");

        jLabel14.setText("Rs.");

        jLabel15.setText("Rs.");

        jLabel16.setText("Rs.");

        safetyStock.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hsn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(measuringUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(error5)
                                    .addComponent(error4)
                                    .addComponent(error6)
                                    .addComponent(error7)
                                    .addComponent(error8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(quantity)
                                    .addComponent(safetyStock)
                                    .addComponent(saleRate)
                                    .addComponent(basicSaleRate)
                                    .addComponent(basicPurchaseRate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(purchaseRate, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(62, 62, 62)
                                            .addComponent(error9)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(error10))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(measuringUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(purchaseRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error5)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(basicPurchaseRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error6)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(basicSaleRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error7)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(saleRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error8)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(error9)
                    .addComponent(safetyStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(error10)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //Will clear all the textboxes, comboboxes and error msgs
        this.productName.setText("");
        this.hsn.setText("");
        this.measuringUnit.setSelectedItem(" ");
        this.gst.setSelectedItem(" ");
        this.purchaseRate.setText("");
        this.basicPurchaseRate.setText("");
        this.basicSaleRate.setText("");
        this.saleRate.setText("");
        this.safetyStock.setValue(0);
        this.quantity.setValue(0);
        this.error1.setText("");
        this.error2.setText("");
        this.error3.setText("");
        this.error4.setText("");
        this.error5.setText("");
        this.error6.setText("");
        this.error7.setText("");
        this.error8.setText("");
        this.error9.setText("");
        this.error10.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //Will add the product to database

        //Taking all the entered values in their respective strings
        String productName1 = this.productName.getText();
        String hsn1 = this.hsn.getText();
        String measuringUnit1 = this.measuringUnit.getSelectedItem().toString();
        String gst1 = this.gst.getSelectedItem().toString();
        String purchaseRate1 = this.purchaseRate.getText();
        String basicPurchaseRate1 = this.basicPurchaseRate.getText();
        String basicSaleRate1 = this.basicSaleRate.getText();
        String saleRate1 = this.saleRate.getText();
        String safetyStock1 = this.safetyStock.getValue().toString();
        String quantity1 = this.quantity.getValue().toString();

        //Setting all error msg to null
        error1.setText("");
        error2.setText("");
        error3.setText("");
        error4.setText("");
        error5.setText("");
        error6.setText("");
        error7.setText("");
        error8.setText("");
        error9.setText("");
        error10.setText("");

        //Required field validations
        int reqFlag;
        int reqFlag1, reqFlag2, reqFlag3, reqFlag4, reqFlag5;
        if (productName1.equals("")) {
            error1.setText("Product Name Required!");
            reqFlag1 = 1;
        } else {
            reqFlag1 = 0;
        }
        if (measuringUnit1.equals(" ")) {
            error3.setText("Measuring Unit Required!");
            reqFlag2 = 1;
        } else {
            reqFlag2 = 0;
        }
        if (gst1.equals(" ")) {
            error4.setText("GST % Required!");
            reqFlag3 = 1;
        } else {
            reqFlag3 = 0;
        }
        if (purchaseRate1.equals("")) {
            error5.setText("Purchase Rate Required!");
            reqFlag4 = 1;
        } else {
            reqFlag4 = 0;
        }
        if (saleRate1.equals("")) {
            error8.setText("Sale Rate Required!");
            reqFlag5 = 1;
        } else {
            reqFlag5 = 0;
        }
        if (reqFlag1 == 1 || reqFlag2 == 1 || reqFlag3 == 1 || reqFlag4 == 1 || reqFlag5 == 1) {
            reqFlag = 1;
        } else {
            reqFlag = 0;
        }

        //Regular expression validations
        int regFlag;
        int regFlag1, regFlag2, regFlag3;
        Pattern hsnPattern = Pattern.compile("^[0-9.]*$|^$");
        Pattern costPattern = Pattern.compile("^[0-9][0-9.]*$|^$");
        Matcher hsnMatcher = hsnPattern.matcher(hsn1);
        if (!hsnMatcher.matches()) {
            error2.setText("Invalid HSN SAC!");
            regFlag1 = 1;
        } else {
            regFlag1 = 0;
        }
        Matcher purchaseRateMatcher = costPattern.matcher(purchaseRate1);
        if (!purchaseRateMatcher.matches()) {
            error5.setText("Invalid Amount!");
            regFlag2 = 1;
        } else {
            regFlag2 = 0;
        }
        Matcher saleRateMatcher = costPattern.matcher(saleRate1);
        if (!saleRateMatcher.matches()) {
            error8.setText("Invalid Amount!");
            regFlag3 = 1;
        } else {
            regFlag3 = 0;
        }
        if (regFlag1 == 1 || regFlag2 == 1 || regFlag3 == 1) {
            regFlag = 1;
        } else {
            regFlag = 0;
        }

        //Duplicate entries validations
        int dupFlag = 0;
        try {
            s = c.createStatement();
            String sql = "SELECT * FROM product";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String productName2 = rs.getString("productName");
                if (productName1.equalsIgnoreCase(productName2)) {
                    error1.setText("Product Name Already Exists!");
                    dupFlag = 1;
                    break;
                } else {
                    dupFlag = 0;
                }
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

        //Adding data to database only if all the flags are 0
        if (reqFlag == 0 && regFlag == 0 && dupFlag == 0) {
            int ans = JOptionPane.showConfirmDialog(this, "Add Product?", "Adding Product", JOptionPane.YES_NO_OPTION);
            if (ans == 0) {
                try {
                    s = c.createStatement();
                    String sql = "INSERT INTO product(productName,hsn,measuringUnit,gst,purchaseRate,basicPurchaseRate,"
                            + "basicSaleRate,saleRate,safetyStock,quantity) VALUES('" + productName1 + "',"
                            + "'" + hsn1 + "','" + measuringUnit1 + "','" + gst1 + "','" + purchaseRate1 + "','" + basicPurchaseRate1 + "',"
                            + "'" + basicSaleRate1 + "','" + saleRate1 + "'," + safetyStock1 + "," + quantity1 + ")";
                    s.executeUpdate(sql);
                    c.close();
                    JOptionPane.showMessageDialog(this, "Product Added Successfully!");
                    new ProductAddForm().setVisible(true);
                    this.dispose();
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(this, e);
                } finally {
                    try {
                        s.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                }
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void productNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameFocusLost
        // TODO add your handling code here:
        String productName1 = this.productName.getText();
        error1.setText("");
        if (productName1.equals("")) {
            error1.setText("Product Name Required!");
        }
    }//GEN-LAST:event_productNameFocusLost

    private void productNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_productNameCaretUpdate
        // TODO add your handling code here:
        error1.setText("");
    }//GEN-LAST:event_productNameCaretUpdate

    private void measuringUnitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_measuringUnitItemStateChanged
        // TODO add your handling code here:
        String item = this.measuringUnit.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error3.setText("");
        } else {
            error3.setText("Measuring Unit Required!");
        }
    }//GEN-LAST:event_measuringUnitItemStateChanged

    private void gstItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gstItemStateChanged
        // TODO add your handling code here:
        String item = this.gst.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error4.setText("");
            String purchaseRate1 = this.purchaseRate.getText();
            String saleRate1 = this.saleRate.getText();
            Pattern costPattern = Pattern.compile("^[0-9][0-9.]*$|^$");
            Matcher purchaseRateMatcher = costPattern.matcher(purchaseRate1);
            if (!purchaseRate1.equals("") && purchaseRateMatcher.matches()) {
                double n1 = Double.parseDouble(purchaseRate1);
                double n2 = 1 + (Double.parseDouble(item) / 100);
                double n3 = n1 / n2;
                String tax = String.valueOf(n3);
                basicPurchaseRate.setText(tax);
            }
            Matcher saleRateMatcher = costPattern.matcher(saleRate1);
            if (!saleRate1.equals("") && saleRateMatcher.matches()) {
                double n1 = Double.parseDouble(saleRate1);
                double n2 = 1 + (Double.parseDouble(item) / 100);
                double n3 = n1 / n2;
                String tax = String.valueOf(n3);
                basicSaleRate.setText(tax);
            }
        } else {
            error4.setText("GST % Required!");
            basicPurchaseRate.setText("");
            basicSaleRate.setText("");
        }
    }//GEN-LAST:event_gstItemStateChanged

    private void measuringUnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_measuringUnitFocusLost
        // TODO add your handling code here:
        String item = this.measuringUnit.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error3.setText("");
        } else {
            error3.setText("Measuring Unit Required!");
        }
    }//GEN-LAST:event_measuringUnitFocusLost

    private void gstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gstFocusLost
        // TODO add your handling code here:
        String item = this.gst.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error4.setText("");
        } else {
            error4.setText("GST % Required!");
        }
    }//GEN-LAST:event_gstFocusLost

    private void purchaseRateCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_purchaseRateCaretUpdate
        // TODO add your handling code here:
        String purchaseRate1 = this.purchaseRate.getText();
        error5.setText("");
        Pattern costPattern = Pattern.compile("^[0-9][0-9.]*$|^$");
        Matcher purchaseRateMatcher = costPattern.matcher(purchaseRate1);
        if (purchaseRate1.equals("")) {
            basicPurchaseRate.setText("");
        }
        if (!purchaseRateMatcher.matches()) {
            error5.setText("Invalid Amount!");
        }
        if (!purchaseRate1.equals("") && purchaseRateMatcher.matches()) {
            String gst1 = this.gst.getSelectedItem().toString();
            if (!gst1.equals(" ")) {
                error6.setText("");
                double n1 = Double.parseDouble(purchaseRate1);
                double n2 = 1 + (Double.parseDouble(gst1) / 100);
                double n3 = n1 / n2;
                String tax = String.valueOf(n3);
                basicPurchaseRate.setText(tax);
            }
        }
    }//GEN-LAST:event_purchaseRateCaretUpdate

    private void purchaseRateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchaseRateFocusLost
        // TODO add your handling code here:
        String purchaseRate1 = this.purchaseRate.getText();
        if (purchaseRate1.equals("")) {
            error5.setText("Purchase Rate Required!");
        }
    }//GEN-LAST:event_purchaseRateFocusLost

    private void hsnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hsnFocusLost
        // TODO add your handling code here:
        String hsn1 = this.hsn.getText();
        error2.setText("");
        Pattern hsnPattern = Pattern.compile("^[0-9.]*$|^$");
        Matcher hsnMatcher = hsnPattern.matcher(hsn1);
        if (!hsnMatcher.matches()) {
            error2.setText("Invalid HSN SAC!");
        }
    }//GEN-LAST:event_hsnFocusLost

    private void hsnCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_hsnCaretUpdate
        // TODO add your handling code here:
        error2.setText("");
    }//GEN-LAST:event_hsnCaretUpdate

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            //Will dispose ProductAddForm
            c.close();
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_formWindowClosing

    private void saleRateCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_saleRateCaretUpdate
        // TODO add your handling code here:
        String saleRate1 = this.saleRate.getText();
        error8.setText("");
        Pattern costPattern = Pattern.compile("^[0-9][0-9.]*$|^$");
        Matcher saleRateMatcher = costPattern.matcher(saleRate1);
        if (saleRate1.equals("")) {
            basicSaleRate.setText("");
        }
        if (!saleRateMatcher.matches()) {
            error8.setText("Invalid Amount!");
        }
        if (!saleRate1.equals("") && saleRateMatcher.matches()) {
            String gst1 = this.gst.getSelectedItem().toString();
            if (!gst1.equals(" ")) {
                error7.setText("");
                double n1 = Double.parseDouble(saleRate1);
                double n2 = 1 + (Double.parseDouble(gst1) / 100);
                double n3 = n1 / n2;
                String tax = String.valueOf(n3);
                basicSaleRate.setText(tax);
            }
        }
    }//GEN-LAST:event_saleRateCaretUpdate

    private void saleRateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saleRateFocusLost
        // TODO add your handling code here:
        String saleRate1 = this.saleRate.getText();
        if (saleRate1.equals("")) {
            error8.setText("Sale Rate Required!");
        }
    }//GEN-LAST:event_saleRateFocusLost

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
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductAddForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField basicPurchaseRate;
    public javax.swing.JTextField basicSaleRate;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error10;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel error6;
    private javax.swing.JLabel error7;
    private javax.swing.JLabel error8;
    private javax.swing.JLabel error9;
    private javax.swing.JComboBox<String> gst;
    private javax.swing.JTextField hsn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> measuringUnit;
    public javax.swing.JTextField productName;
    public javax.swing.JTextField purchaseRate;
    private javax.swing.JSpinner quantity;
    private javax.swing.JSpinner safetyStock;
    private javax.swing.JTextField saleRate;
    // End of variables declaration//GEN-END:variables
}
