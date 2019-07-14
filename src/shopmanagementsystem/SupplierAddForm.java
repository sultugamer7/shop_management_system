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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Sultan
 */
public class SupplierAddForm extends javax.swing.JFrame {

    /**
     * Creates new form SupplierAddForm
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null;

    public SupplierAddForm() {
        initComponents();
        c = DB.java_db();

        //Setting all error msgs to null
        error1.setText("");
        error3.setText("");
        error4.setText("");
        error5.setText("");
        error2.setText("");
        error6.setText("");
        error7.setText("");
        error8.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        error6 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        error7 = new javax.swing.JLabel();
        JLabel1 = new javax.swing.JLabel();
        gstin = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        pan = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        supplierName = new javax.swing.JTextField();
        state = new javax.swing.JComboBox<>();
        supplierBalancePayment = new javax.swing.JTextField();
        error1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        streetAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        error8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ADD SUPPLIER");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(138, 43, 226));
        jLabel5.setText("PAN No. :");

        error4.setForeground(new java.awt.Color(255, 0, 0));
        error4.setText("error4");

        jLabel6.setForeground(new java.awt.Color(138, 43, 226));
        jLabel6.setText("State* :");

        error5.setForeground(new java.awt.Color(255, 0, 0));
        error5.setText("error5");

        jLabel7.setForeground(new java.awt.Color(138, 43, 226));
        jLabel7.setText("Balance Payment :");

        error6.setForeground(new java.awt.Color(255, 0, 0));
        error6.setText("error6");

        mobile.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                mobileCaretUpdate(evt);
            }
        });
        mobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobileFocusLost(evt);
            }
        });

        error7.setForeground(new java.awt.Color(255, 0, 0));
        error7.setText("error7");

        JLabel1.setForeground(new java.awt.Color(138, 43, 226));
        JLabel1.setText("Supplier Name* :");

        gstin.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                gstinCaretUpdate(evt);
            }
        });
        gstin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                gstinFocusLost(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(219, 112, 147));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        pan.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                panCaretUpdate(evt);
            }
        });
        pan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panFocusLost(evt);
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

        supplierName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                supplierNameCaretUpdate(evt);
            }
        });
        supplierName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                supplierNameFocusLost(evt);
            }
        });

        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Jammu & Kashmir", "Himachal Pradesh", "Punjab", "Chandigarh", "Uttarakhand", "Haryana", "Delhi", "Rajasthan", "Uttar Pradesh", "Bihar", "Sikkim", "Arunachal Pradesh", "Nagaland", "Manipur", "Mizoram", "Tripura", "Meghalaya", "Assam", "West Bengal", "Jharkhand", "Orissa", "Chhattisgarh", "Madhya Pradesh", "Gujarat", "Daman & Diu", "Dadra & Nagar Haveli", "Maharashtra", "Andhra Pradesh", "Karnataka", "Goa", "Lakshadweep", "Kerala", "Tamil Nadu", "Puducherry", "Andaman & Nicobar Islands", "Telengana", "Andrapradesh(New)" }));
        state.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stateItemStateChanged(evt);
            }
        });
        state.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stateFocusLost(evt);
            }
        });

        supplierBalancePayment.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                supplierBalancePaymentCaretUpdate(evt);
            }
        });

        error1.setForeground(new java.awt.Color(255, 0, 0));
        error1.setText("error1");

        jLabel3.setForeground(new java.awt.Color(138, 43, 226));
        jLabel3.setText("Mobile :");

        error3.setForeground(new java.awt.Color(255, 0, 0));
        error3.setText("error3");

        jLabel4.setForeground(new java.awt.Color(138, 43, 226));
        jLabel4.setText("GSTIN :");

        error2.setForeground(new java.awt.Color(255, 0, 0));
        error2.setText("error2");

        jLabel1.setForeground(new java.awt.Color(138, 43, 226));
        jLabel1.setText("Street Address :");

        streetAddress.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                streetAddressCaretUpdate(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(138, 43, 226));
        jLabel8.setText("City* :");

        city.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                cityCaretUpdate(evt);
            }
        });
        city.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cityFocusLost(evt);
            }
        });

        error8.setForeground(new java.awt.Color(255, 0, 0));
        error8.setText("error8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(mobile, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(streetAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(city, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(error2)
                                    .addComponent(error1)
                                    .addComponent(error3)
                                    .addComponent(error4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(supplierBalancePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error8))))
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
                    .addComponent(JLabel1)
                    .addComponent(supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(supplierBalancePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error8))
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
        //Will clear all textboxes, comboboxes and error msgs
        error1.setText("");
        error3.setText("");
        error4.setText("");
        error5.setText("");
        error2.setText("");
        error6.setText("");
        error7.setText("");
        error8.setText("");
        supplierName.setText("");
        mobile.setText("");
        streetAddress.setText("");
        city.setText("");
        state.setSelectedItem(" ");
        gstin.setText("");
        pan.setText("");
        supplierBalancePayment.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //Will add the product to database

        //Taking all the entered values in their respective strings
        String supplierName1 = this.supplierName.getText();
        String mobile1 = this.mobile.getText();
        String streetAddress1 = this.streetAddress.getText();
        String city1 = this.city.getText();
        String state1 = this.state.getSelectedItem().toString();
        String gstin1 = this.gstin.getText();
        String pan1 = this.pan.getText();
        String supplierBalancePayment1 = this.supplierBalancePayment.getText();

        //Setting all error msg to null
        error1.setText("");
        error2.setText("");
        error3.setText("");
        error4.setText("");
        error5.setText("");
        error6.setText("");
        error7.setText("");
        error8.setText("");

        //Required field validations
        int reqFlag;
        int reqFlag1, reqFlag2, reqFlag3;
        if (supplierName1.equals("")) {
            error1.setText("Supplier Name Required!");
            reqFlag1 = 1;
        } else {
            reqFlag1 = 0;
        }
        if (city1.equals("")) {
            error4.setText("City Required!");
            reqFlag2 = 1;
        } else {
            reqFlag2 = 0;
        }
        if (state1.equals(" ")) {
            error5.setText("State Required!");
            reqFlag3 = 1;
        } else {
            reqFlag3 = 0;
        }
        if (reqFlag1 == 1 || reqFlag2 == 1 || reqFlag3 == 1) {
            reqFlag = 1;
        } else {
            reqFlag = 0;
        }

        //Regular expression validations
        int regFlag;
        int regFlag1, regFlag2, regFlag3, regFlag4, regFlag5, regFlag6;
        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]*$");
        Pattern mobilePattern = Pattern.compile("^[6-9]\\d{9}$|^$");
        Pattern cityPattern = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$|^$");
        Pattern gstinPattern = Pattern.compile("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{3}$|^$");
        Pattern panPattern = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}|^$");
        Pattern costPattern = Pattern.compile("^[0-9.]*$|^$");
        Matcher nameMatcher = namePattern.matcher(supplierName1);
        if (!nameMatcher.matches()) {
            error1.setText("Invalid Supplier Name!");
            regFlag1 = 1;
        } else {
            regFlag1 = 0;
        }
        Matcher mobileMatcher = mobilePattern.matcher(mobile1);
        if (!mobileMatcher.matches()) {
            error2.setText("Invalid Mobile Number!");
            regFlag2 = 1;
        } else {
            regFlag2 = 0;
        }
        Matcher cityMatcher = cityPattern.matcher(city1);
        if (!cityMatcher.matches()) {
            error4.setText("Invalid City Name!");
            regFlag3 = 1;
        } else {
            regFlag3 = 0;
        }
        Matcher gstinMatcher = gstinPattern.matcher(gstin1);
        if (!gstinMatcher.matches()) {
            error6.setText("Invalid GSTIN!");
            regFlag4 = 1;
        } else {
            regFlag4 = 0;
        }
        Matcher panMatcher = panPattern.matcher(pan1);
        if (!panMatcher.matches()) {
            error7.setText("Invalid PAN Number!");
            regFlag5 = 1;
        } else {
            regFlag5 = 0;
        }
        Matcher costMatcher = costPattern.matcher(supplierBalancePayment1);
        if (!costMatcher.matches()) {
            error8.setText("Invalid Amount!");
            regFlag6 = 1;
        } else {
            regFlag6 = 0;
        }
        if (regFlag1 == 1 || regFlag2 == 1 || regFlag3 == 1 || regFlag4 == 1 || regFlag5 == 1 || regFlag6 == 1) {
            regFlag = 1;
        } else {
            regFlag = 0;
        }

        //Duplicate entries validations
        int dupFlag = 0;
        int dupFlag1, dupFlag2, dupFlag3;
        try {
            s = c.createStatement();
            String sql = "SELECT * FROM supplier";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String mobile2 = rs.getString("mobile");
                String gstin2 = rs.getString("gstin");
                String pan2 = rs.getString("pan");
                if (mobile1.equals(mobile2) && !mobile2.equals("")) {
                    error2.setText("Mobile Number Already Exists!");
                    dupFlag1 = 1;
                } else {
                    dupFlag1 = 0;
                }
                if (gstin1.equals(gstin2) && !gstin2.equals("")) {
                    error6.setText("GSTIN Already Exists!");
                    dupFlag2 = 1;
                } else {
                    dupFlag2 = 0;
                }
                if (pan1.equals(pan2) && !pan2.equals("")) {
                    error7.setText("PAN Number Already Exists!");
                    dupFlag3 = 1;
                } else {
                    dupFlag3 = 0;
                }
                if (dupFlag1 == 1 || dupFlag2 == 1 || dupFlag3 == 1) {
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
            int ans = JOptionPane.showConfirmDialog(this, "Add Supplier?", "Adding Supplier", JOptionPane.YES_NO_OPTION);
            if (ans == 0) {
                try {
                    s = c.createStatement();
                    if (supplierBalancePayment1.equals("")) {
                        supplierBalancePayment1 = "0.0";
                    }
                    String sql = "INSERT INTO supplier(supplierName,mobile,streetAddress,city,state,gstin,"
                            + "pan,supplierBalancePayment) VALUES('" + supplierName1 + "',"
                            + "'" + mobile1 + "','" + streetAddress1 + "','" + city1 + "','" + state1 + "','" + gstin1 + "',"
                            + "'" + pan1 + "'," + supplierBalancePayment1 + ")";
                    s.executeUpdate(sql);
                    c.close();
                    JOptionPane.showMessageDialog(this, "Supplier Added Successfully!");
                    new SupplierAddForm().setVisible(true);
                    this.dispose();
                } catch (SQLException e) {
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

    private void supplierNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplierNameFocusLost
        // TODO add your handling code here:
        String supplierName1 = this.supplierName.getText();
        error1.setText("");
        Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher m = p.matcher(supplierName1);
        if (supplierName1.equals("")) {
            error1.setText("Supplier Name Required!");
        }
        if (!m.matches()) {
            error1.setText("Invalid Supplier Name!");
        }
    }//GEN-LAST:event_supplierNameFocusLost

    private void supplierNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_supplierNameCaretUpdate
        // TODO add your handling code here:
        error1.setText("");
        String supplierName1 = this.supplierName.getText();
        Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher m = p.matcher(supplierName1);
        if (!m.matches()) {
            error1.setText("Invalid Supplier Name!");
        }
    }//GEN-LAST:event_supplierNameCaretUpdate

    private void cityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFocusLost
        // TODO add your handling code here:
        String city1 = this.city.getText();
        error4.setText("");
        Pattern p = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$|^$");
        Matcher m = p.matcher(city1);
        if (city1.equals("")) {
            error4.setText("City Required!");
        }
        if (!m.matches()) {
            error4.setText("Invalid City Name!");
        }
    }//GEN-LAST:event_cityFocusLost

    private void cityCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_cityCaretUpdate
        // TODO add your handling code here:
        error4.setText("");
        String city1 = this.city.getText();
        Pattern p = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$|^$");
        Matcher m = p.matcher(city1);
        if (!m.matches()) {
            error4.setText("Invalid City Name!");
        }
    }//GEN-LAST:event_cityCaretUpdate

    private void stateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stateItemStateChanged
        // TODO add your handling code here:
        String item = this.state.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error5.setText("");
        } else {
            error5.setText("State Required!");
        }
    }//GEN-LAST:event_stateItemStateChanged

    private void mobileCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_mobileCaretUpdate
        // TODO add your handling code here:
        error2.setText("");
    }//GEN-LAST:event_mobileCaretUpdate

    private void streetAddressCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_streetAddressCaretUpdate
        // TODO add your handling code here:
        error3.setText("");
    }//GEN-LAST:event_streetAddressCaretUpdate

    private void gstinCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_gstinCaretUpdate
        // TODO add your handling code here:
        error6.setText("");
    }//GEN-LAST:event_gstinCaretUpdate

    private void panCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_panCaretUpdate
        // TODO add your handling code here:
        error7.setText("");
    }//GEN-LAST:event_panCaretUpdate

    private void supplierBalancePaymentCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_supplierBalancePaymentCaretUpdate
        // TODO add your handling code here:
        String supplierBalancePayment1 = this.supplierBalancePayment.getText();
        error8.setText("");
        Pattern costPattern = Pattern.compile("^[0-9.]*$|^$");
        Matcher balancePaymentMatcher = costPattern.matcher(supplierBalancePayment1);
        if (!balancePaymentMatcher.matches()) {
            error8.setText("Invalid Amount!");
        }
    }//GEN-LAST:event_supplierBalancePaymentCaretUpdate

    private void mobileFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileFocusLost
        // TODO add your handling code here:
        error2.setText("");
        String mobile1 = this.mobile.getText();
        Pattern p = Pattern.compile("^[6-9]\\d{9}$|^$");
        Matcher m = p.matcher(mobile1);
        if (!m.matches()) {
            error2.setText("Invalid Mobile Number!");
        }
    }//GEN-LAST:event_mobileFocusLost

    private void gstinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gstinFocusLost
        // TODO add your handling code here:
        error6.setText("");
        String gstin1 = this.gstin.getText();
        Pattern p = Pattern.compile("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{3}$|^$");
        Matcher m = p.matcher(gstin1);
        if (!m.matches()) {
            error6.setText("Invalid GSTIN!");
        }
    }//GEN-LAST:event_gstinFocusLost

    private void panFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panFocusLost
        // TODO add your handling code here:
        error7.setText("");
        String pan1 = this.pan.getText();
        Pattern p = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}|^$");
        Matcher m = p.matcher(pan1);
        if (!m.matches()) {
            error7.setText("Invalid GSTIN!");
        }
    }//GEN-LAST:event_panFocusLost

    private void stateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stateFocusLost
        // TODO add your handling code here:
        String item = this.state.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error5.setText("");
        } else {
            error5.setText("State Required!");
        }
    }//GEN-LAST:event_stateFocusLost

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupplierAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierAddForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel1;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField city;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel error6;
    private javax.swing.JLabel error7;
    private javax.swing.JLabel error8;
    private javax.swing.JTextField gstin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField pan;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JTextField streetAddress;
    private javax.swing.JTextField supplierBalancePayment;
    private javax.swing.JTextField supplierName;
    // End of variables declaration//GEN-END:variables
}