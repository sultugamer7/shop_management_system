/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

/**
 *
 * @author Desktop
 */
import java.sql.*;
import javax.swing.*;

public class DB {
    
    Connection conn = null;

    public static Connection java_db() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database\\shopInfo.sqlite");
            //JOptionPane.showMessageDialog(null, "Connection to database is successful");
            return conn;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }

//        public static void main(String[] g) {
//        java_db();
//        try {
//            Connection c = java_db();
//            Statement s = c.createStatement();
//            s.execute("DROP TABLE shop");
//            String sql1 = "CREATE TABLE shop(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "FIRSTNAME TEXT,MIDDLENAME TEXT,LASTNAME TEXT,STREETADDRESS TEXT,CITY TEXT,"
//                    + "STATE TEXT,EMAIL TEXT,PHONE TEXT,MOBILE INTEGER,BANKNAME TEXT,BANKBRANCH TEXT,"
//                    + "BANKACNUMBER INTEGER,BANKIFSC TEXT,SHOPNAME TEXT,GSTIN TEXT,USERNAME TEXT,"
//                    + "PASSWORD TEXT)";
//            s.execute(sql1);
//                

//            String sql = "DELETE FROM shop";
//            s.execute(sql);
//            s.executeUpdate("INSERT INTO shop(FIRSTNAME,MIDDLENAME,LASTNAME,STREETADDRESS,CITY,STATE,"
//                    + "EMAIL,PHONE,MOBILE,BANKNAME,BANKBRANCH,BANKACNUMBER,BANKIFSC,SHOPNAME,GSTIN,USERNAME,"
//                    + "PASSWORD) VALUES('Sultan','Shaukat','Kazi','Kalkai Kond','Dapoli','Maharashtra','sultugamer7@gmail.com',"
//                    + "02358282446,8605915392,'IDBI Bank','Dapoli',1234567890,'LLLL1234568',"
//                    + "'SUL CORP','21ADSKP3131A1ZQ','s','s')");

//            s.execute("DROP TABLE customer");
//            String sql2 = "CREATE TABLE customer(CUSTOMERID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "CUSTOMERNAME TEXT,MOBILE INTEGER,STREETADDRESS TEXT,CITY TEXT,"
//                    + "STATE TEXT,GSTIN TEXT,PAN TEXT,CUSTOMERBALANCEPAYMENT REAL)";
//            s.executeUpdate(sql2);
//            
//            s.execute("DROP TABLE supplier");
//            String sql3 = "CREATE TABLE supplier(SUPPLIERID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "SUPPLIERNAME TEXT,MOBILE INTEGER,STREETADDRESS TEXT,CITY TEXT,"
//                    + "STATE TEXT,GSTIN TEXT,PAN TEXT,SUPPLIERBALANCEPAYMENT REAL)";
//            s.executeUpdate(sql3);
//            
//            s.execute("DROP TABLE product");
//            String sql4 = "CREATE TABLE product(PRODUCTID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "PRODUCTNAME TEXT,HSN TEXT,MEASURINGUNIT TEXT,GST TEXT,"
//                    + "PURCHASERATE REAL,BASICPURCHASERATE REAL,BASICSALERATE REAL,SALERATE REAL,"
//                    + "SAFETYSTOCK INTEGER DEFAULT 0,QUANTITY INTEGER DEFAULT 0)";
//            s.executeUpdate(sql4);
//            
//            s.execute("DROP TABLE ptdetails");
//            String sql5 = "CREATE TABLE ptdetails(PTDID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "BILLNO TEXT,TDATE TEXT,SUPPLIERID INTEGER,PRODUCTID INTEGER,QUANTITY INTEGER,"
//                    + "TAXABLEAMOUNT REAL,CGSTP REAL,CGSTA REAL,SGSTP REAL,"
//                    + "SGSTA REAL,TOTALAMOUNT REAL)";
//            s.executeUpdate(sql5);
//            
//            s.execute("DROP TABLE stdetails");
//            String sql6 = "CREATE TABLE stdetails(STDID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "BILLNO TEXT,TDATE TEXT,CUSTOMERID INTEGER,PRODUCTID INTEGER,QUANTITY INTEGER,"
//                    + "TAXABLEAMOUNT REAL,CGSTP REAL,CGSTA REAL,SGSTP REAL,"
//                    + "SGSTA REAL,TOTALAMOUNT REAL)";
//            s.executeUpdate(sql6);
//    
//            s.execute("DROP TABLE purchasetransaction");
//            String sql7 = "CREATE TABLE purchasetransaction(TID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "BILLNO TEXT,TDATE TEXT,SUPPLIERID INTEGER,TOTALAMOUNT REAL,"
//                    + "DISCOUNTP REAL,DISCOUNTR REAL,GRANDTOTAL REAL,PAIDAMOUNT REAL)";
//            s.executeUpdate(sql7);
//            
//            s.execute("DROP TABLE saletransaction");
//            String sql8 = "CREATE TABLE saletransaction(TID INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "BILLNO TEXT,TDATE TEXT,CUSTOMERID INTEGER,TOTALAMOUNT REAL,"
//                    + "DISCOUNTP REAL,DISCOUNTR REAL,GRANDTOTAL REAL,PAIDAMOUNT REAL)";
//            s.executeUpdate(sql8);
            
//////            String sql9 = "CREATE TABLE theme(THEMEID INTEGER PRIMARY KEY AUTOINCREMENT,"
//////                    + "THEMENAME TEXT,THEMEQUERY TEXT,THEMESTATUS TEXT)";
//////            s.executeUpdate(sql9);
////            
////            //Inserting themes
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Acryl','com.jtattoo.plaf.acryl.AcrylLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Aero','com.jtattoo.plaf.aero.AeroLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Aluminium','com.jtattoo.plaf.aluminium.AluminiumLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Bernstein','com.jtattoo.plaf.bernstein.BernsteinLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Fast','com.jtattoo.plaf.fast.FastLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Graphite','com.jtattoo.plaf.graphite.GraphiteLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('HiFi','com.jtattoo.plaf.hifi.HiFiLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Luna','com.jtattoo.plaf.luna.LunaLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('McWin','com.jtattoo.plaf.mcwin.McWinLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Mint','com.jtattoo.plaf.mint.MintLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Noire','com.jtattoo.plaf.noire.NoireLookAndFeel','inactive')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Smart','com.jtattoo.plaf.smart.SmartLookAndFeel','active')");
//////            s.executeUpdate("INSERT INTO THEME(THEMENAME,THEMEQUERY,THEMESTATUS)"
//////                    + " VALUES('Texture','com.jtattoo.plaf.texture.TextureLookAndFeel','inactive')");
////            
////
//        ResultSet rs = s.executeQuery("Select * from ptdetails");
//        while(rs.next()){
//            System.out.print(rs.getInt("billNo")+"  "+rs.getInt("productID")+"  "+rs.getInt("supplierID"));
//            System.out.println();
//        }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
}
