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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sultan
 */
public class ShopManagementSystem {

    /**
     * @param args the command line arguments
     */
    static Connection c = null;
    static Statement s = null;
    static ResultSet rs = null;

    public static void main(String[] args) {
        c = DB.java_db();

        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM theme WHERE themestatus='active'");
            String themeQuery = "";
            while (rs.next()) {
                themeQuery = rs.getString("themeQuery");
            }
            UIManager.setLookAndFeel(themeQuery);

            rs = s.executeQuery("SELECT * FROM shop");
            int cnt = 0;
            while (rs.next()) {
                cnt = 1;
            }
            if (cnt == 0) {
                new ShopCreationForm1().setVisible(true);
            } else {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                s.close();
                c.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void themeSelector(String themeQuery1) {
        try {
            UIManager.setLookAndFeel(themeQuery1);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
