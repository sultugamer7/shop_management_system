/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Desktop
 */
public class ShopCreationForm2 extends javax.swing.JFrame {

    /**
     * Creates new form ShopCreationForm2
     */
    public static String firstName2, middleName2, lastName2, streetAddress2, city2, state2, email2, phone2, mobile2;

    private void clearError() {
        this.error1.setText("");
        this.error2.setText("");
        this.error3.setText("");
        this.error4.setText("");
        this.error5.setText("");
        this.error6.setText("");
        this.error7.setText("");
        this.error8.setText("");
    }

    public ShopCreationForm2() {
        initComponents();

        clearError();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        firstName = new javax.swing.JTextField();
        middleName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        streetAddress = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        state = new javax.swing.JComboBox<>();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        error6 = new javax.swing.JLabel();
        error7 = new javax.swing.JLabel();
        error8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADD SHOP");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("SHOP OWNER'S PERSONAL INFORMATION :");

        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("First Name* :");

        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Middle Name* :");

        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Last Name* :");

        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Street Address :");

        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("City* :");

        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("State* :");

        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("E-Mail* :");

        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("Phone Number :");

        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Mobile Number* :");

        nextButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        nextButton.setForeground(new java.awt.Color(219, 112, 147));
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        firstName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                firstNameCaretUpdate(evt);
            }
        });
        firstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameFocusLost(evt);
            }
        });

        middleName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                middleNameCaretUpdate(evt);
            }
        });
        middleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                middleNameFocusLost(evt);
            }
        });

        lastName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                lastNameCaretUpdate(evt);
            }
        });
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameFocusLost(evt);
            }
        });

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

        email.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                emailCaretUpdate(evt);
            }
        });
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });

        phone.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                phoneCaretUpdate(evt);
            }
        });
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneFocusLost(evt);
            }
        });

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

        resetButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        resetButton.setForeground(new java.awt.Color(219, 112, 147));
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(middleName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(middleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if (this.firstName.getText().equals("") || this.middleName.getText().equals("")
                || this.lastName.getText().equals("") || this.city.getText().equals("")
                || this.state.getSelectedItem().toString().equals(" ")
                || this.email.getText().equals("") || this.mobile.getText().equals("")) {
            if (this.firstName.getText().equals("")) {
                this.error1.setText("First Name Required!");
            }
            if (this.middleName.getText().equals("")) {
                this.error2.setText("Middle Name Required!");
            }
            if (this.lastName.getText().equals("")) {
                this.error3.setText("Last Name Required!");
            }
            if (this.city.getText().equals("")) {
                this.error4.setText("City Name Required!");
            }
            if (this.state.getSelectedItem().equals("")) {
                this.error5.setText("State Required!");
            }
            if (this.email.getText().equals("")) {
                this.error6.setText("E-Mail Address Required!");
            }
            if (this.mobile.getText().equals("")) {
                this.error8.setText("Mobile Number Required!");
            }
            JOptionPane.showMessageDialog(this, "Enter All The Required Information!");
        } else {
            if (this.error1.getText().equals("") && this.error2.getText().equals("")
                    && this.error3.getText().equals("") && this.error4.getText().equals("")
                    && this.error5.getText().equals("") && this.error6.getText().equals("")
                    && this.error7.getText().equals("") && this.error8.getText().equals("")) {
                int ans = JOptionPane.showConfirmDialog(this, "Are You Sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (ans == 0) {
                    firstName2 = this.firstName.getText();
                    middleName2 = this.middleName.getText();
                    lastName2 = this.lastName.getText();
                    streetAddress2 = this.streetAddress.getText();
                    city2 = this.city.getText();
                    state2 = (String) this.state.getSelectedItem();
                    email2 = this.email.getText();
                    phone2 = this.phone.getText();
                    mobile2 = this.mobile.getText();
                    new ShopCreationForm3().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Details!");
                }
            }
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void firstNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_firstNameCaretUpdate
        //Will display error msg if incorrect name
        error1.setText("");
        String firstName1 = this.firstName.getText();
        Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher m = p.matcher(firstName1);
        if (!m.matches()) {
            error1.setText("Invalid First Name!");
        }
    }//GEN-LAST:event_firstNameCaretUpdate

    private void firstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFocusLost
        // TODO add your handling code here:
        String firstName1 = this.firstName.getText();
        error1.setText("");
        if (firstName1.equals("")) {
            error1.setText("First Name Required!");
        } else {
            Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
            Matcher m = p.matcher(firstName1);
            if (!m.matches()) {
                error1.setText("Invalid First Name!");
            }
        }
    }//GEN-LAST:event_firstNameFocusLost

    private void middleNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_middleNameCaretUpdate
        //Will display error msg if if incorrect name
        error2.setText("");
        String middleName1 = this.middleName.getText();
        Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher m = p.matcher(middleName1);
        if (!m.matches()) {
            error2.setText("Invalid Middle Name!");
        }
    }//GEN-LAST:event_middleNameCaretUpdate

    private void middleNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middleNameFocusLost
        // TODO add your handling code here:
        String middleName1 = this.middleName.getText();
        error2.setText("");
        if (middleName1.equals("")) {
            error2.setText("Middle Name Required!");
        } else {
            Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
            Matcher m = p.matcher(middleName1);
            if (!m.matches()) {
                error2.setText("Invalid Middle Name!");
            }
        }
    }//GEN-LAST:event_middleNameFocusLost

    private void lastNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_lastNameCaretUpdate
        // TODO add your handling code here:
        error3.setText("");
        String lastName1 = this.lastName.getText();
        Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher m = p.matcher(lastName1);
        if (!m.matches()) {
            error3.setText("Invalid Last Name!");
        }
    }//GEN-LAST:event_lastNameCaretUpdate

    private void lastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusLost
        // TODO add your handling code here:
        String lastName1 = this.lastName.getText();
        error3.setText("");
        if (lastName1.equals("")) {
            error3.setText("Last Name Required!");
        } else {
            Pattern p = Pattern.compile("^[a-zA-Z\\s]*$");
            Matcher m = p.matcher(lastName1);
            if (!m.matches()) {
                error3.setText("Invalid Last Name!");
            }
        }
    }//GEN-LAST:event_lastNameFocusLost

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

    private void cityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFocusLost
        // TODO add your handling code here:
        String city1 = this.city.getText();
        error4.setText("");
        if (city1.equals("")) {
            error4.setText("City Required!");
        } else {
            Pattern p = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$|^$");
            Matcher m = p.matcher(city1);
            if (!m.matches()) {
                error4.setText("Invalid City Name!");
            }
        }
    }//GEN-LAST:event_cityFocusLost

    private void stateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stateFocusLost
        // TODO add your handling code here:
        String item = this.state.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error5.setText("");
        } else {
            error5.setText("State Required!");
        }
    }//GEN-LAST:event_stateFocusLost

    private void stateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stateItemStateChanged
        // TODO add your handling code here:
        String item = this.state.getSelectedItem().toString();
        if (!item.equals(" ")) {
            error5.setText("");
        } else {
            error5.setText("State Required!");
        }
    }//GEN-LAST:event_stateItemStateChanged

    private void emailCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_emailCaretUpdate
        // TODO add your handling code here:
        error6.setText("");
    }//GEN-LAST:event_emailCaretUpdate

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:
        error6.setText("");
        String email1 = this.email.getText();
        if (email1.equals("")) {
            error6.setText("E-Mail Address Required!");
        } else {
            Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$|^$", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(email1);
            if (!m.matches()) {
                error6.setText("Invalid E-Mail Address!");
            }
        }
    }//GEN-LAST:event_emailFocusLost

    private void phoneCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_phoneCaretUpdate
        // TODO add your handling code here:
        error7.setText("");
    }//GEN-LAST:event_phoneCaretUpdate

    private void phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneFocusLost
        // TODO add your handling code here:
        error7.setText("");
        String phone1 = this.phone.getText();
        Pattern p = Pattern.compile("\\d{11}|\\(\\d{5}\\)\\d{6}|(?:\\d{5}-)\\d{6}|^$");
        Matcher m = p.matcher(phone1);
        if (!m.matches()) {
            error7.setText("Invalid Phone Number!");
        }
    }//GEN-LAST:event_phoneFocusLost

    private void mobileCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_mobileCaretUpdate
        // TODO add your handling code here:
        error8.setText("");
    }//GEN-LAST:event_mobileCaretUpdate

    private void mobileFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileFocusLost
        // TODO add your handling code here:
        error8.setText("");
        String mobile1 = this.mobile.getText();
        if (mobile1.equals("")) {
            error8.setText("Mobile Number Required!");
        } else {
            Pattern p = Pattern.compile("^[6-9]\\d{9}$|^$");
            Matcher m = p.matcher(mobile1);
            if (!m.matches()) {
                error8.setText("Invalid Mobile Number!");
            }
        }
    }//GEN-LAST:event_mobileFocusLost

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        clearError();

        this.firstName.setText("");
        this.middleName.setText("");
        this.lastName.setText("");
        this.streetAddress.setText("");
        this.city.setText("");
        this.state.setSelectedItem(" ");
        clearError();
        this.email.setText("");
        this.phone.setText("");
        this.mobile.setText("");


    }//GEN-LAST:event_resetButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ShopCreationForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShopCreationForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShopCreationForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShopCreationForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShopCreationForm2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField city;
    private javax.swing.JTextField email;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel error6;
    private javax.swing.JLabel error7;
    private javax.swing.JLabel error8;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField middleName;
    private javax.swing.JTextField mobile;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField phone;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JTextField streetAddress;
    // End of variables declaration//GEN-END:variables
}