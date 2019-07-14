/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sultan
 */
public class PrintForm extends javax.swing.JFrame {

    Connection c = null;
    Statement s = null;
    ResultSet rs = null;
    DefaultTableModel model;

    /**
     * Creates new form PrintForm
     */
    public String stateCodeGen(String state) {
        String stateCode = "";
        if (state.equals("Jammu & Kashmir")) {
            stateCode = "01";
        } else if (state.equals("Himachal Pradesh")) {
            stateCode = "02";
        } else if (state.equals("Punjab")) {
            stateCode = "03";
        } else if (state.equals("Chandigarh")) {
            stateCode = "04";
        } else if (state.equals("Uttarakhand")) {
            stateCode = "05";
        } else if (state.equals("Haryana")) {
            stateCode = "06";
        } else if (state.equals("Delhi")) {
            stateCode = "07";
        } else if (state.equals("Rajasthan")) {
            stateCode = "08";
        } else if (state.equals("Uttar Pradesh")) {
            stateCode = "09";
        } else if (state.equals("Bihar")) {
            stateCode = "10";
        } else if (state.equals("Sikkim")) {
            stateCode = "11";
        } else if (state.equals("Arunachal Pradesh")) {
            stateCode = "12";
        } else if (state.equals("Nagaland")) {
            stateCode = "13";
        } else if (state.equals("Manipur")) {
            stateCode = "14";
        } else if (state.equals("Mizoram")) {
            stateCode = "15";
        } else if (state.equals("Tripura")) {
            stateCode = "16";
        } else if (state.equals("Meghalaya")) {
            stateCode = "17";
        } else if (state.equals("Assam")) {
            stateCode = "18";
        } else if (state.equals("West Bengal")) {
            stateCode = "19";
        } else if (state.equals("Jharkhand")) {
            stateCode = "20";
        } else if (state.equals("Orissa")) {
            stateCode = "21";
        } else if (state.equals("Chhattisgarh")) {
            stateCode = "22";
        } else if (state.equals("Madhya Pradesh")) {
            stateCode = "23";
        } else if (state.equals("Gujarat")) {
            stateCode = "24";
        } else if (state.equals("Daman & Diu")) {
            stateCode = "25";
        } else if (state.equals("Dadra & Nagar Haveli")) {
            stateCode = "26";
        } else if (state.equals("Maharashtra")) {
            stateCode = "27";
        } else if (state.equals("	Andhra Pradesh")) {
            stateCode = "28";
        } else if (state.equals("Karnataka")) {
            stateCode = "29";
        } else if (state.equals("Goa")) {
            stateCode = "30";
        } else if (state.equals("Lakshadweep")) {
            stateCode = "31";
        } else if (state.equals("Kerala")) {
            stateCode = "32";
        } else if (state.equals("Tamil Nadu")) {
            stateCode = "33";
        } else if (state.equals("Puducherry")) {
            stateCode = "34";
        } else if (state.equals("Andaman & Nicobar Islands")) {
            stateCode = "35";
        } else if (state.equals("Telengana")) {
            stateCode = "36";
        } else if (state.equals("Andrapradesh(New)")) {
            stateCode = "37";
        }
        return stateCode;
    }

    public void printOnPaper() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print!");
        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
//                Graphics2D g2 = (Graphics2D) pg;
//                g2.setColor(Color.WHITE);
//                Font myFont = new Font ("Segoe UI Symbol", 1, 14);
//                g2.setFont(myFont);
//                g2.translate(pf.getImageableX(), pf.getImageableY());
//
////                g2.scale(0.707,0.757);
//                g2.scale(0.70, 0.70);
//
//                jPanel1.paint(g2);
//                return Printable.PAGE_EXISTS;
// get the bounds of the component
                Dimension dim = jPanel1.getSize();
                double cHeight = dim.getHeight();
                double cWidth = dim.getWidth();

                // get the bounds of the printable area
                double pHeight = pf.getImageableHeight();
                double pWidth = pf.getImageableWidth();

                double pXStart = pf.getImageableX();
                double pYStart = pf.getImageableY();

                double xRatio = pWidth / cWidth;
                double yRatio = pHeight / cHeight;

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pXStart, pYStart);
                g2.scale(xRatio, yRatio);
                jPanel1.paint(g2);

                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static String convert(int n) {
        String[] units = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};
        String[] tens = {
            "", // 0
            "", // 1
            "Twenty", // 2
            "Thirty", // 3
            "Forty", // 4
            "Fifty", // 5
            "Sixty", // 6
            "Seventy", // 7
            "Eighty", // 8
            "Ninety" // 9
        };
        if (n < 0) {
            return "Minus " + convert(-n);
        }

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }

        if (n < 100000) {
            return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
        }

        if (n < 10000000) {
            return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
        }

        return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
    }

    public PrintForm() {
        initComponents();
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        productTable.getColumn("Sr.").setCellRenderer(centerRenderer);
        productTable.getColumn("Rate").setCellRenderer(centerRenderer);
        productTable.getColumn("Qty.").setCellRenderer(centerRenderer);
        productTable.getColumn("Taxable Amt.").setCellRenderer(centerRenderer);
        productTable.getColumn("CGST %").setCellRenderer(centerRenderer);
        productTable.getColumn("CGST Rs.").setCellRenderer(centerRenderer);
        productTable.getColumn("SGST %").setCellRenderer(centerRenderer);
        productTable.getColumn("SGST Rs.").setCellRenderer(centerRenderer);
        productTable.getColumn("Total Amt.").setCellRenderer(centerRenderer);
        
        model = (DefaultTableModel) productTable.getModel();

        c = DB.java_db();
        //Adding Bill Data
        try {
            s = c.createStatement();
            String sql = "SELECT * FROM shop";
            rs = s.executeQuery(sql);
            String shopName1, streetAddress1, city1, state1, phone1, mobile1, email1, gstin1,
                    bankName1, bankBranch1, bankACNumber1, bankIFSC1;
            shopName1 = streetAddress1 = city1 = state1 = phone1 = mobile1 = email1 = gstin1
                    = bankName1 = bankBranch1 = bankACNumber1 = bankIFSC1 = "";
            while (rs.next()) {
                shopName1 = rs.getString("shopName");
                streetAddress1 = rs.getString("streetAddress");
                city1 = rs.getString("city");
                state1 = rs.getString("state");
                phone1 = rs.getString("phone");
                mobile1 = rs.getString("mobile");
                email1 = rs.getString("email");
                gstin1 = rs.getString("gstin");
                bankName1 = rs.getString("bankName");
                bankBranch1 = rs.getString("bankBranch");
                bankACNumber1 = rs.getString("bankACNumber");
                bankIFSC1 = rs.getString("bankIFSC");
            }
            this.shopName.setText(shopName1);
            String address1;
            if (streetAddress1.equals("")) {
                address1 = "Address : " + city1 + ", " + state1;
            } else {
                address1 = "Address : " + streetAddress1 + ", " + city1 + ", " + state1;
            }
            this.address.setText(address1);
            String contact1;
            if (phone1.equals("")) {
                contact1 = "Phone/Mobile  :  "+mobile1;
            } else {
                contact1 = "Phone/Mobile  :  "+phone1 + " / " + mobile1;
            }
            this.jLabel23.setText("Orginal "+" for "+" Receipients");
            this.jLabel24.setText("Duplicate "+" for "+" Supplier/Transporter");
            this.jLabel25.setText("Triplicate "+" for "+" Supplier");
            this.contact.setText(contact1);
            this.email.setText("E-Mail Address : " + email1);
            this.gstin.setText("GSTIN : " + gstin1);
            this.state.setText("State : " + state1);
            String stateCode1 = stateCodeGen(state1);
            this.stateCode.setText("State Code : " + stateCode1);
            String bankInfo = "Bank Name : " + bankName1 + " " + bankBranch1 + " Branch";
            this.bankName.setText(bankInfo);
            this.bankACNumber.setText("Bank Account Number : " + bankACNumber1);
            this.bankIFSC.setText("Bank Branch IFSC : " + bankIFSC1);
            this.forComp.setText("FOR, " + shopName1);

            this.supplyPlace.setText("Place Of Supply : " + stateCode1 + " - " + state1);
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

        //Printing
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
        shopName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        address = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        gstin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        billNo = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        supplyDate = new javax.swing.JLabel();
        supplyPlace = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        customerName = new javax.swing.JLabel();
        customerAddress = new javax.swing.JLabel();
        customerGSTIN = new javax.swing.JLabel();
        customerState = new javax.swing.JLabel();
        customerStateCode = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        bankName = new javax.swing.JLabel();
        bankACNumber = new javax.swing.JLabel();
        bankIFSC = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        taxableAmount = new javax.swing.JLabel();
        totalCGST = new javax.swing.JLabel();
        totalGST = new javax.swing.JLabel();
        totalSGST = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        amountWithTax = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        forComp = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        state = new javax.swing.JLabel();
        stateCode = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        words = new javax.swing.JLabel();
        customerStateCode1 = new javax.swing.JLabel();
        customerState1 = new javax.swing.JLabel();
        customerGSTIN1 = new javax.swing.JLabel();
        customerAddress1 = new javax.swing.JLabel();
        customerName1 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        discount = new javax.swing.JLabel();
        roundoff = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        shopName.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        shopName.setForeground(new java.awt.Color(0, 204, 255));
        shopName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shopName.setText("SHOP NAME");

        jSeparator1.setForeground(new java.awt.Color(0, 204, 255));

        jSeparator2.setForeground(new java.awt.Color(0, 204, 255));

        address.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        address.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        address.setText("Address");

        contact.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contact.setText("Phone/Mobile");

        email.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("E-Mail");

        gstin.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        gstin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gstin.setText("GSTIN");

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("TAX INVOICE");

        jSeparator3.setForeground(new java.awt.Color(0, 204, 255));

        billNo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        billNo.setText("Invoice No. :");

        date.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        date.setText("Invoice Date :");

        jSeparator4.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        supplyDate.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        supplyDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        supplyDate.setText("Date Of Supply :");

        supplyPlace.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        supplyPlace.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        supplyPlace.setText("Place Of Supply :");

        jSeparator5.setForeground(new java.awt.Color(0, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 13)); // NOI18N
        jLabel2.setText("Details Of Receiver | Billed To :");

        jSeparator7.setForeground(new java.awt.Color(0, 204, 255));

        customerName.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerName.setText("Name :");

        customerAddress.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerAddress.setText("Address :");

        customerGSTIN.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerGSTIN.setText("GSTIN :");

        customerState.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerState.setText("State :");

        customerStateCode.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerStateCode.setText("State Code :");

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.", "Name Of Product/Service", "HSN", "Rate", "Qty.", "Taxable Amt.", "CGST %", "CGST Rs.", "SGST %", "SGST Rs.", "Total Amt."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setMinWidth(25);
            productTable.getColumnModel().getColumn(0).setMaxWidth(25);
            productTable.getColumnModel().getColumn(1).setMinWidth(160);
            productTable.getColumnModel().getColumn(2).setMinWidth(60);
            productTable.getColumnModel().getColumn(2).setMaxWidth(70);
            productTable.getColumnModel().getColumn(3).setMinWidth(65);
            productTable.getColumnModel().getColumn(4).setMinWidth(32);
            productTable.getColumnModel().getColumn(4).setMaxWidth(35);
            productTable.getColumnModel().getColumn(5).setMinWidth(80);
            productTable.getColumnModel().getColumn(6).setMinWidth(58);
            productTable.getColumnModel().getColumn(6).setMaxWidth(60);
            productTable.getColumnModel().getColumn(7).setMinWidth(65);
            productTable.getColumnModel().getColumn(8).setMinWidth(58);
            productTable.getColumnModel().getColumn(8).setMaxWidth(60);
            productTable.getColumnModel().getColumn(9).setMinWidth(65);
            productTable.getColumnModel().getColumn(10).setMinWidth(75);
        }

        jSeparator6.setForeground(new java.awt.Color(0, 204, 255));

        bankName.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        bankName.setText("Bank Name :");

        bankACNumber.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        bankACNumber.setText("Bank A/C No. :");

        bankIFSC.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        bankIFSC.setText("Bank Branch IFSC :");

        jSeparator8.setForeground(new java.awt.Color(0, 204, 255));

        jSeparator9.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        taxableAmount.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        taxableAmount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        taxableAmount.setText("Total Amount Before Tax :");

        totalCGST.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        totalCGST.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalCGST.setText("Add : CGST :");

        totalGST.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        totalGST.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalGST.setText("Tax Amount : GST :");

        totalSGST.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        totalSGST.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalSGST.setText("Add : SGST :");

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jLabel15.setText("Invoice Amount (In Words) :");

        jSeparator11.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        amountWithTax.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        amountWithTax.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        amountWithTax.setText("Total Amount After Tax :");

        totalAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalAmount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalAmount.setText("Total Amount After Tax & Discount :");

        jSeparator12.setForeground(new java.awt.Color(0, 204, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI Symbol", 1, 13)); // NOI18N
        jLabel18.setText(": TERMS AND CONDITIONS :");

        jLabel19.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("100% PAYMENT AGAINST MATERIAL BILL");

        jLabel20.setFont(new java.awt.Font("Segoe UI Symbol", 0, 10)); // NOI18N
        jLabel20.setText("Certified that the particulars given above are true and correct");

        forComp.setFont(new java.awt.Font("Segoe UI Symbol", 1, 13)); // NOI18N
        forComp.setText("FOR,");

        jLabel22.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Authorised Signatory");

        jSeparator10.setForeground(new java.awt.Color(0, 204, 255));

        jSeparator13.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator14.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel23.setFont(new java.awt.Font("Segoe UI Symbol", 0, 10)); // NOI18N
        jLabel23.setForeground(java.awt.Color.red);
        jLabel23.setText("A");

        jLabel24.setFont(new java.awt.Font("Segoe UI Symbol", 0, 10)); // NOI18N
        jLabel24.setForeground(java.awt.Color.red);
        jLabel24.setText("B");

        jLabel25.setFont(new java.awt.Font("Segoe UI Symbol", 0, 10)); // NOI18N
        jLabel25.setForeground(java.awt.Color.red);
        jLabel25.setText("C");

        state.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        state.setText("State :");

        stateCode.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        stateCode.setText("State Code :");

        jSeparator15.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        words.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        words.setText("jLabel3");

        customerStateCode1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerStateCode1.setText("State Code :");

        customerState1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerState1.setText("State :");

        customerGSTIN1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerGSTIN1.setText("GSTIN :");

        customerAddress1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerAddress1.setText("Address :");

        customerName1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        customerName1.setText("Name :");

        jSeparator16.setForeground(new java.awt.Color(0, 204, 255));
        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);

        discount.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        discount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        discount.setText("Discount :");

        roundoff.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        roundoff.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        roundoff.setText("Round Off :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator10)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator6)
                            .addComponent(jSeparator8)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                            .addComponent(forComp)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(customerName))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(address, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shopName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(contact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gstin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(words, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                    .addComponent(amountWithTax, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                    .addComponent(discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(roundoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bankACNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bankIFSC, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(taxableAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalCGST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalSGST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalGST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(state)
                                                .addGap(18, 18, 18)
                                                .addComponent(stateCode))
                                            .addComponent(billNo, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(customerState)
                                                .addGap(18, 18, 18)
                                                .addComponent(customerStateCode))
                                            .addComponent(customerGSTIN)
                                            .addComponent(customerAddress))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(supplyDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(customerState1)
                                        .addGap(18, 18, 18)
                                        .addComponent(customerStateCode1))
                                    .addComponent(customerGSTIN1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(customerAddress1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(customerName1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(supplyPlace, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator13)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(shopName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel24)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel25))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(billNo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(state)
                                    .addComponent(stateCode)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(supplyDate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(supplyPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(customerName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerAddress1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerGSTIN1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(customerState1)
                                    .addComponent(customerStateCode1)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(customerName)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(customerAddress)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(customerGSTIN)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(customerState)
                                        .addComponent(customerStateCode)))
                                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bankName)
                                .addGap(15, 15, 15)
                                .addComponent(bankACNumber)
                                .addGap(15, 15, 15)
                                .addComponent(bankIFSC)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator9)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(taxableAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCGST)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalSGST)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalGST)))
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(words))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(amountWithTax)
                                .addGap(2, 2, 2)
                                .addComponent(discount)
                                .addGap(2, 2, 2)
                                .addComponent(roundoff)
                                .addGap(2, 2, 2)
                                .addComponent(totalAmount))
                            .addComponent(jSeparator11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(forComp))
                                .addGap(24, 24, 24)
                                .addComponent(jLabel22))
                            .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    public javax.swing.JLabel amountWithTax;
    private javax.swing.JLabel bankACNumber;
    private javax.swing.JLabel bankIFSC;
    private javax.swing.JLabel bankName;
    public javax.swing.JLabel billNo;
    private javax.swing.JLabel contact;
    public javax.swing.JLabel customerAddress;
    public javax.swing.JLabel customerAddress1;
    public javax.swing.JLabel customerGSTIN;
    public javax.swing.JLabel customerGSTIN1;
    public javax.swing.JLabel customerName;
    public javax.swing.JLabel customerName1;
    public javax.swing.JLabel customerState;
    public javax.swing.JLabel customerState1;
    public javax.swing.JLabel customerStateCode;
    public javax.swing.JLabel customerStateCode1;
    public javax.swing.JLabel date;
    public javax.swing.JLabel discount;
    private javax.swing.JLabel email;
    private javax.swing.JLabel forComp;
    private javax.swing.JLabel gstin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JTable productTable;
    public javax.swing.JLabel roundoff;
    private javax.swing.JLabel shopName;
    private javax.swing.JLabel state;
    private javax.swing.JLabel stateCode;
    public javax.swing.JLabel supplyDate;
    private javax.swing.JLabel supplyPlace;
    public javax.swing.JLabel taxableAmount;
    public javax.swing.JLabel totalAmount;
    public javax.swing.JLabel totalCGST;
    public javax.swing.JLabel totalGST;
    public javax.swing.JLabel totalSGST;
    public javax.swing.JLabel words;
    // End of variables declaration//GEN-END:variables

}
