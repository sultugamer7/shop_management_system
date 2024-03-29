/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Sultan
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null;

    public LoginForm() {
        initComponents();
        c = DB.java_db();

        this.jLabel5.setVisible(false);
        LoginForm.id.setVisible(false);

        LoginForm.id.setText("");

        String sel = "";
        //Adding shop names from database to combobox
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM shop");
            while (rs.next()) {
                String shopName1 = rs.getString("shopName");
                LoginForm.shopName.addItem(shopName1);
            }
            ResultSet rs2 = s.executeQuery("SELECT * FROM theme");

            while (rs2.next()) {
                String themeName1 = rs2.getString("themeName");
                String themeStatus1 = rs2.getString("themeStatus");
                this.themeSelector.addItem(themeName1);
                if (themeStatus1.equals("active")) {
                    sel = themeName1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(LoginForm.this, e);
        } finally {
            try {
                rs.close();
                s.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(LoginForm.this, e);
            }
        }
        this.themeSelector.setSelectedItem(sel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shopName = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        themeSelector = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        applyThemeButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        shopName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        shopName.setEnabled(false);
        shopName.setFocusable(false);
        shopName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(138, 43, 226));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Shop Name :");

        password.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(219, 112, 147));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(138, 43, 226));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Password :");

        username.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(138, 43, 226));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Username :");

        id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        id.setForeground(new java.awt.Color(0, 102, 255));
        id.setText("id");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Shop ID :");

        themeSelector.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        themeSelector.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Theme :");

        applyThemeButton.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        applyThemeButton.setForeground(new java.awt.Color(219, 112, 147));
        applyThemeButton.setText("Apply");
        applyThemeButton.setFocusable(false);
        applyThemeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyThemeButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setText("*Best viewed under 1366x768 Resolution");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(219, 112, 147));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html><center>SHOP MANAGEMENT<br/>SYSTEM</center></html>");

        jLabel8.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(219, 112, 147));
        jLabel8.setText("Project By :");

        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(219, 112, 147));
        jLabel9.setText("Sultan Shaukat Kazi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4)
                                .addGap(2, 2, 2)
                                .addComponent(themeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(applyThemeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password)
                                    .addComponent(username)
                                    .addComponent(shopName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(applyThemeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id)
                        .addComponent(jLabel5)
                        .addComponent(themeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(shopName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(1, 1, 1)
                .addComponent(jLabel9)
                .addGap(7, 7, 7)
                .addComponent(jLabel6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        //Will be used to login if user presses enter key from password field
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String username1 = LoginForm.username.getText();
            String password1 = this.password.getText();
            int cmpindex = LoginForm.shopName.getSelectedIndex();
            if (cmpindex == -1) {
                JOptionPane.showMessageDialog(this, "No shop available for login. Create a shop first!");
            } else {
                String shopName1 = LoginForm.shopName.getSelectedItem().toString();
                try {
                    s = c.createStatement();
                    String sql = "SELECT * FROM shop";
                    rs = s.executeQuery(sql);
                    int flag = 0;
                    while (rs.next()) {
                        String shopName2 = rs.getString("shopName");
                        String username2 = rs.getString("username");
                        String password2 = rs.getString("password");
                        if (shopName1.equals(shopName2) && username1.equals(username2) && password1.equals(password2)) {
                            flag = 1;
                            c.close();
                            this.dispose();
                            new WelcomeForm().setVisible(true);
                            break;
                        }
                    }
                    if (flag == 0) {
                        JOptionPane.showMessageDialog(this, "Invalid username or password!");
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
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        //Will be used to login if user presses login button
        String username1 = LoginForm.username.getText();
        String password1 = this.password.getText();
        int cmpindex = LoginForm.shopName.getSelectedIndex();
        if (cmpindex == -1) {
            JOptionPane.showMessageDialog(this, "No shop available for login. Create a shop first!");
        } else {
            String shopName1 = LoginForm.shopName.getSelectedItem().toString();
            try {
                s = c.createStatement();
                String sql = "SELECT * FROM shop";
                rs = s.executeQuery(sql);
                int flag = 0;
                while (rs.next()) {
                    String shopName2 = rs.getString("shopName");
                    String username2 = rs.getString("username");
                    String password2 = rs.getString("password");
                    if (shopName1.equals(shopName2) && username1.equals(username2) && password1.equals(password2)) {
                        flag = 1;
                        c.close();
                        this.dispose();
                        new WelcomeForm().setVisible(true);
                        break;
                    }
                }
                if (flag == 0) {
                    JOptionPane.showMessageDialog(this, "Invalid username or password!");
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
    }//GEN-LAST:event_loginButtonActionPerformed

    private void applyThemeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyThemeButtonActionPerformed
        // TODO add your handling code here:
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM theme WHERE themeStatus='active'");
            int themeID = 0;
            while (rs.next()) {
                themeID = rs.getInt("themeID");
            }
            s.executeUpdate("UPDATE theme SET themeStatus='inactive' WHERE themeID=" + themeID);
            String themeName1 = themeSelector.getSelectedItem().toString();
            switch (themeName1) {
                case "Acryl":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Aero":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Aluminium":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Bernstein":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Fast":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Graphite":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "HiFi":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Luna":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "McWin":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Mint":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Noire":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Smart":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                case "Texture":
                    s.executeUpdate("UPDATE theme SET themeStatus='active' WHERE themeName='" + themeName1 + "'");
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Select a theme!");
            }
            rs = s.executeQuery("SELECT * FROM theme WHERE themeName='" + themeName1 + "'");
            String themeQuery1 = "";
            while (rs.next()) {
                themeQuery1 = rs.getString("themeQuery");
            }
            ShopManagementSystem.themeSelector(themeQuery1);
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

        try {
            c.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        this.dispose();
        new LoginForm().setVisible(true);
        JOptionPane.showMessageDialog(this, "Theme Applied!");
    }//GEN-LAST:event_applyThemeButtonActionPerformed

    private void shopNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopNameActionPerformed
        //Will set id of shop on top of screen after a shop is selected from combobox
        String shopName1 = LoginForm.shopName.getSelectedItem().toString();
        try {
            s = c.createStatement();
            String sql = "SELECT * FROM shop WHERE shopName='" + shopName1 + "'";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                int id1 = rs.getInt("id");
                LoginForm.id.setText(String.valueOf(id1));
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
    }//GEN-LAST:event_shopNameActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyThemeButton;
    public static javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField password;
    public static javax.swing.JComboBox<String> shopName;
    private javax.swing.JComboBox<String> themeSelector;
    public static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
