/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagementsystem;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Sultan
 */
public class SellProductForm extends javax.swing.JFrame {

    /**
     * Creates new form SellProductForm
     */
    Connection c = null;
    Statement s = null;
    ResultSet rs = null;
    DefaultTableModel model;

    private void productPopulate() {
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM product ORDER BY productName ASC");
            while (rs.next()) {
                String productName1 = rs.getString("productName");
                this.productSelector.addItem(productName1);
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
    }

    private void customerPopulate() {
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM customer ORDER BY customerName ASC");
            while (rs.next()) {
                int customerID1 = rs.getInt("customerID");
                String customerName1 = rs.getString("customerName");
                this.customerName.addItem(customerName1 + " - " + customerID1);
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
    }

    public void tableCheck() {
        int rowCount = this.model.getRowCount();
        if (rowCount != 0) {
            customerName.setEnabled(true);
            customerName.setFocusable(true);
            selectButton.setEnabled(true);
            selectButton.setFocusable(true);
        } else {
            customerName.setEnabled(false);
            customerName.setFocusable(false);
            selectButton.setEnabled(false);
            selectButton.setFocusable(false);
        }
    }

    private double grandTotalCalculator() {
        int rows = this.model.getRowCount();
        double amount;
        double grandTotal1 = 0;
        for (int i = 0; i < rows; i++) {
            amount = (double) this.model.getValueAt(i, 9);
            grandTotal1 += amount;
        }
        return grandTotal1;
    }
    ButtonGroup rb1 = new ButtonGroup();

    public SellProductForm() {
        initComponents();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        productTable.getColumn("Rate").setCellRenderer(centerRenderer);
        productTable.getColumn("Qty.").setCellRenderer(centerRenderer);
        productTable.getColumn("Taxable Amount").setCellRenderer(centerRenderer);
        productTable.getColumn("CGST %").setCellRenderer(centerRenderer);
        productTable.getColumn("CGST Amount").setCellRenderer(centerRenderer);
        productTable.getColumn("SGST %").setCellRenderer(centerRenderer);
        productTable.getColumn("SGST Amount").setCellRenderer(centerRenderer);
        productTable.getColumn("Total Amount").setCellRenderer(centerRenderer);

        c = DB.java_db();

        this.date.setEditor(new JSpinner.DateEditor(this.date, "dd/MM/yyyy"));
        AutoCompleteDecorator.decorate(this.productSelector);
        AutoCompleteDecorator.decorate(this.customerName);

        //Full Screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //Setting error msgs to null
        this.error1.setText("");
        this.error2.setText("");
        this.error3.setText("");
        this.error4.setText("");
        this.error5.setText("");

        model = (DefaultTableModel) productTable.getModel();

        productPopulate();
        customerPopulate();
        this.grandTotal.setText(String.valueOf(grandTotalCalculator()));
        rb1.add(this.percent);
        rb1.add(this.rupees);

        //Auto Bill Number
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM saletransaction");
            String billNo1 = "0";
            while (rs.next()) {
                billNo1 = rs.getString("billNo");
            }
            int billNo2 = Integer.parseInt(billNo1) + 1;
            this.billNo.setText(String.valueOf(billNo2));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        paidAmount = new javax.swing.JTextField();
        previousBalance = new javax.swing.JTextField();
        grandTotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        error5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        percent = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        rupees = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        quantity = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        customerName = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        streetAddress = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        discount = new javax.swing.JTextField();
        purchaseRate = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        billNo = new javax.swing.JTextField();
        basicPurchaseRate = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        saleRate = new javax.swing.JTextField();
        basicSaleRate = new javax.swing.JTextField();
        error2 = new javax.swing.JLabel();
        date = new javax.swing.JSpinner();
        productSelector = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        quantitySelected = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox<>();
        totalAmount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        gst = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        gstin = new javax.swing.JTextField();
        pan = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        returnedAmount = new javax.swing.JTextField();
        netBalance = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        selectButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SELL PRODUCT");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("PRODUCT SELECTION :");

        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Bill No. :");

        paidAmount.setText("0.0");
        paidAmount.setEnabled(false);
        paidAmount.setFocusable(false);
        paidAmount.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                paidAmountCaretUpdate(evt);
            }
        });

        previousBalance.setText("0.0");
        previousBalance.setEnabled(false);
        previousBalance.setFocusable(false);

        grandTotal.setText("0.0");
        grandTotal.setEnabled(false);
        grandTotal.setFocusable(false);

        jLabel17.setForeground(new java.awt.Color(0, 153, 255));
        jLabel17.setText("Sale Rate/Unit :");

        error4.setForeground(new java.awt.Color(255, 0, 0));
        error4.setText("error4");

        error5.setForeground(new java.awt.Color(255, 0, 0));
        error5.setText("error5");

        jLabel18.setForeground(new java.awt.Color(0, 153, 255));
        jLabel18.setText("In Stock :");

        percent.setText("Percent");
        percent.setEnabled(false);
        percent.setFocusable(false);
        percent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                percentMouseReleased(evt);
            }
        });
        percent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(0, 153, 255));
        jLabel19.setText("Quantity :");

        rupees.setText("Rupees");
        rupees.setEnabled(false);
        rupees.setFocusable(false);
        rupees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rupeesMouseReleased(evt);
            }
        });
        rupees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rupeesActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Discount By :");

        quantity.setValue(1);
        quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        quantity.setEnabled(false);
        quantity.setFocusable(false);

        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Date :");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 153, 153));
        jLabel23.setText("PRODUCT SELECTED & BILL SUMMARY :");

        jLabel35.setForeground(new java.awt.Color(0, 153, 255));
        jLabel35.setText("City :");

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "HSN SAC", "Rate", "Qty.", "Taxable Amount", "CGST %", "CGST Amount", "SGST %", "SGST Amount", "Total Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        jLabel37.setForeground(new java.awt.Color(0, 153, 255));
        jLabel37.setText("State :");

        customerName.setEditable(true);
        customerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        customerName.setEnabled(false);
        customerName.setFocusable(false);
        customerName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerNameItemStateChanged(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Product Name :");

        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("GST % :");

        mobile.setEnabled(false);
        mobile.setFocusable(false);

        streetAddress.setEnabled(false);
        streetAddress.setFocusable(false);

        city.setEnabled(false);
        city.setFocusable(false);

        jLabel26.setForeground(new java.awt.Color(0, 153, 255));
        jLabel26.setText("Discount :");

        discount.setText("0.0");
        discount.setEnabled(false);
        discount.setFocusable(false);
        discount.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                discountCaretUpdate(evt);
            }
        });

        purchaseRate.setEnabled(false);
        purchaseRate.setFocusable(false);
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

        jLabel41.setText("Rs.");

        billNo.setEnabled(false);
        billNo.setFocusable(false);
        billNo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                billNoCaretUpdate(evt);
            }
        });
        billNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                billNoFocusLost(evt);
            }
        });

        basicPurchaseRate.setEnabled(false);
        basicPurchaseRate.setFocusable(false);

        jLabel51.setText("Rs.");

        saleRate.setEnabled(false);
        saleRate.setFocusable(false);

        basicSaleRate.setEnabled(false);
        basicSaleRate.setFocusable(false);
        basicSaleRate.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                basicSaleRateCaretUpdate(evt);
            }
        });
        basicSaleRate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                basicSaleRateFocusLost(evt);
            }
        });

        error2.setForeground(new java.awt.Color(255, 0, 0));
        error2.setText("error2");

        date.setModel(new javax.swing.SpinnerDateModel());

        productSelector.setEditable(true);
        productSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel52.setText("Rs.");

        error3.setForeground(new java.awt.Color(255, 0, 0));
        error3.setText("error3");

        quantitySelected.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        quantitySelected.setEnabled(false);
        quantitySelected.setFocusable(false);
        quantitySelected.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantitySelectedStateChanged(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Total Amount :");

        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Maharashtra", "Goa" }));
        state.setEnabled(false);
        state.setFocusable(false);

        totalAmount.setEnabled(false);
        totalAmount.setFocusable(false);

        jLabel11.setForeground(new java.awt.Color(0, 153, 255));
        jLabel11.setText("Purchase Rate/Unit :");

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        gst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "12", "14", "18", "28" }));
        gst.setEnabled(false);
        gst.setFocusable(false);

        jLabel40.setForeground(new java.awt.Color(0, 153, 255));
        jLabel40.setText("Previous Balance :");

        error1.setForeground(new java.awt.Color(255, 0, 0));
        error1.setText("error1");

        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("<html>Purchase Rate/Unit :<br/>(Without GST)</html>");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel42.setForeground(new java.awt.Color(0, 153, 255));
        jLabel42.setText("Paid Amount :");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel27.setForeground(new java.awt.Color(0, 153, 255));
        jLabel27.setText("Grand Total :");

        jLabel16.setForeground(new java.awt.Color(0, 153, 255));
        jLabel16.setText("<html>Sale Rate/Unit :<br/>(Without GST)</html>");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 153, 153));
        jLabel31.setText("CUSTOMER SELECTION & PAYMENT CALCULATION :");

        jLabel32.setForeground(new java.awt.Color(0, 153, 255));
        jLabel32.setText("Customer Name :");

        jLabel33.setForeground(new java.awt.Color(0, 153, 255));
        jLabel33.setText("Mobile Number :");

        jLabel34.setForeground(new java.awt.Color(0, 153, 255));
        jLabel34.setText("Street Address :");

        jLabel36.setForeground(new java.awt.Color(0, 153, 255));
        jLabel36.setText("GSTIN :");

        gstin.setEnabled(false);
        gstin.setFocusable(false);

        pan.setEnabled(false);
        pan.setFocusable(false);

        jLabel24.setForeground(new java.awt.Color(0, 153, 255));
        jLabel24.setText("PAN Number :");

        jLabel43.setForeground(new java.awt.Color(0, 153, 255));
        jLabel43.setText("Returned Amount :");

        returnedAmount.setText("0.0");
        returnedAmount.setEnabled(false);
        returnedAmount.setFocusable(false);

        netBalance.setText("0.0");
        netBalance.setEnabled(false);
        netBalance.setFocusable(false);

        backButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(219, 112, 147));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        resetButton.setForeground(new java.awt.Color(219, 112, 147));
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(219, 112, 147));
        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Net Balance :");

        jLabel53.setText("Rs.");

        jLabel50.setText("Rs.");

        addButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(219, 112, 147));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        removeButton.setForeground(new java.awt.Color(219, 112, 147));
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        selectButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        selectButton.setForeground(new java.awt.Color(219, 112, 147));
        selectButton.setText("Select");
        selectButton.setEnabled(false);
        selectButton.setFocusable(false);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        selectButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        selectButton1.setForeground(new java.awt.Color(219, 112, 147));
        selectButton1.setText("Select");
        selectButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator9)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel23)
                            .addComponent(jLabel31))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(billNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(productSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(selectButton1))
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(purchaseRate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(basicSaleRate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(basicPurchaseRate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel51)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addGap(18, 18, 18)
                                        .addComponent(error2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel52)
                                        .addGap(18, 18, 18)
                                        .addComponent(error3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(quantitySelected, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(saleRate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel50))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel53)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(selectButton))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(streetAddress)
                                                            .addComponent(city)
                                                            .addComponent(state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(previousBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(netBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(discount)
                                                                    .addComponent(paidAmount)
                                                                    .addComponent(returnedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(error4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(error5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(40, 40, 40)
                                                    .addComponent(percent)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rupees)))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator11))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(billNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(productSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(purchaseRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)
                            .addComponent(error2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(basicPurchaseRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(basicSaleRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(error3)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(saleRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(quantitySelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel10)))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(percent)
                            .addComponent(rupees)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(previousBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(paidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(returnedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(netBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void paidAmountCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_paidAmountCaretUpdate
        // TODO add your handling code here:
        error5.setText("");
        String paidAmount1 = this.paidAmount.getText();

        double grandTotal1 = Double.parseDouble(this.grandTotal.getText());
        double previousBalance1 = Double.parseDouble(this.previousBalance.getText());
        double totalPayableAmount = grandTotal1 + previousBalance1;
        this.netBalance.setText(String.valueOf(totalPayableAmount));
        if (paidAmount1.equals("")) {
            error5.setText("Paid Amount Required!");
        } else {
            Pattern costPattern = Pattern.compile("^\\d{0,10}(\\.\\d{1,15})? *%?$|^$");
            Matcher costMatcher = costPattern.matcher(paidAmount1);
            if (!costMatcher.matches()) {
                error5.setText("Invalid Amount!");
            } else {
                double paidAmount2 = Double.parseDouble(paidAmount1);
                double balance = paidAmount2 - totalPayableAmount;
                if (paidAmount2 <= totalPayableAmount) {
                    this.netBalance.setText(String.valueOf(Math.abs(balance)));
                } else {
                    double neg = 0 - balance;
                    this.netBalance.setText(String.valueOf(neg));
                }
                double netBalance1 = Double.parseDouble(this.netBalance.getText());
                if (netBalance1 < 0) {
                    this.returnedAmount.setText(String.valueOf(Math.abs(netBalance1)));
                    this.netBalance.setText("0.0");
                } else {
                    this.returnedAmount.setText("0.0");
                }
            }
        }
    }//GEN-LAST:event_paidAmountCaretUpdate

    private void percentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_percentMouseReleased
        // TODO add your handling code here:
        error4.setText("");
        this.grandTotal.setText(String.valueOf(grandTotalCalculator()));
        String discount1 = this.discount.getText();
        if (discount1.equals("")) {
            error4.setText("Field Required!");
        } else {
            if (this.percent.isSelected()) {
                Pattern percentPattern = Pattern.compile("^\\d{0,2}(\\.\\d{1,4})? *%?$|[1][0][0]|^$");
                Matcher percentMatcher = percentPattern.matcher(discount1);
                if (!percentMatcher.matches()) {
                    error4.setText("Invalid %!");
                } else {
                    double discountPercent1 = Double.parseDouble(discount1);
                    double grandTotal1 = Double.parseDouble(this.grandTotal.getText());
                    double discountRupees1 = grandTotal1 * (discountPercent1 / 100);
                    this.grandTotal.setText(String.valueOf(grandTotal1 - discountRupees1));

                    double grandTotal2 = Double.parseDouble(this.grandTotal.getText());
                    double previousBalance1 = Double.parseDouble(this.previousBalance.getText());
                    double totalPayableAmount = grandTotal2 + previousBalance1;
                    double paidAmount1 = Double.parseDouble(this.paidAmount.getText());
                    double balance = paidAmount1 - totalPayableAmount;
                    if (paidAmount1 <= totalPayableAmount) {
                        this.netBalance.setText(String.valueOf(Math.abs(balance)));
                    } else {
                        double neg = 0 - balance;
                        this.netBalance.setText(String.valueOf(neg));
                    }
                    double netBalance1 = Double.parseDouble(this.netBalance.getText());
                    if (netBalance1 < 0) {
                        this.returnedAmount.setText(String.valueOf(Math.abs(netBalance1)));
                        this.netBalance.setText("0.0");
                    } else {
                        this.returnedAmount.setText("0.0");
                    }
                }
            }
        }
    }//GEN-LAST:event_percentMouseReleased

    private void percentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentActionPerformed
        // TODO add your handling code here:
        if (!this.discount.isEnabled()) {
            this.discount.setEnabled(true);
            this.discount.setFocusable(true);
        }
    }//GEN-LAST:event_percentActionPerformed

    private void rupeesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rupeesMouseReleased
        // TODO add your handling code here:
        error4.setText("");
        this.grandTotal.setText(String.valueOf(grandTotalCalculator()));
        String discount1 = this.discount.getText();
        if (discount1.equals("")) {
            error4.setText("Field Required!");
        } else {
            if (this.rupees.isSelected()) {
                Pattern rupeesPattern = Pattern.compile("^\\d{0,10}(\\.\\d{1,15})? *%?$|^$");
                Matcher rupeesMatcher = rupeesPattern.matcher(discount1);
                if (!rupeesMatcher.matches()) {
                    error4.setText("Invalid Amount!");
                } else {
                    double discountRupees1 = Double.parseDouble(discount1);
                    double grandTotal1 = Double.parseDouble(this.grandTotal.getText());
                    if (discountRupees1 > grandTotal1) {
                        error4.setText("Amount > Total!");
                    } else {
                        this.grandTotal.setText(String.valueOf(grandTotal1 - discountRupees1));
                        double grandTotal2 = Double.parseDouble(this.grandTotal.getText());
                        double previousBalance1 = Double.parseDouble(this.previousBalance.getText());
                        double totalPayableAmount = grandTotal2 + previousBalance1;
                        double paidAmount1 = Double.parseDouble(this.paidAmount.getText());
                        double balance = paidAmount1 - totalPayableAmount;
                        if (paidAmount1 <= totalPayableAmount) {
                            this.netBalance.setText(String.valueOf(Math.abs(balance)));
                        } else {
                            double neg = 0 - balance;
                            this.netBalance.setText(String.valueOf(neg));
                        }
                        double netBalance1 = Double.parseDouble(this.netBalance.getText());
                        if (netBalance1 < 0) {
                            this.returnedAmount.setText(String.valueOf(Math.abs(netBalance1)));
                            this.netBalance.setText("0.0");
                        } else {
                            this.returnedAmount.setText("0.0");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_rupeesMouseReleased

    private void rupeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rupeesActionPerformed
        // TODO add your handling code here:
        if (!this.discount.isEnabled()) {
            this.discount.setEnabled(true);
            this.discount.setFocusable(true);
        }
    }//GEN-LAST:event_rupeesActionPerformed

    private void discountCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_discountCaretUpdate
        // TODO add your handling code here:
        error4.setText("");
        this.grandTotal.setText(String.valueOf(grandTotalCalculator()));
        String discount1 = this.discount.getText();
        if (discount1.equals("")) {
            error4.setText("Field Required!");
        } else {
            if (this.percent.isSelected()) {
                Pattern percentPattern = Pattern.compile("^\\d{0,2}(\\.\\d{1,4})? *%?$|[1][0][0]|^$");
                Matcher percentMatcher = percentPattern.matcher(discount1);
                if (!percentMatcher.matches()) {
                    error4.setText("Invalid %!");
                } else {
                    double discountPercent1 = Double.parseDouble(discount1);
                    double grandTotal1 = Double.parseDouble(this.grandTotal.getText());
                    double discountRupees1 = grandTotal1 * (discountPercent1 / 100);
                    this.grandTotal.setText(String.valueOf(grandTotal1 - discountRupees1));
                    double grandTotal2 = Double.parseDouble(this.grandTotal.getText());
                    double previousBalance1 = Double.parseDouble(this.previousBalance.getText());
                    double totalPayableAmount = grandTotal2 + previousBalance1;
                    double paidAmount1 = Double.parseDouble(this.paidAmount.getText());
                    double balance = paidAmount1 - totalPayableAmount;
                    if (paidAmount1 <= totalPayableAmount) {
                        this.netBalance.setText(String.valueOf(Math.abs(balance)));
                    } else {
                        double neg = 0 - balance;
                        this.netBalance.setText(String.valueOf(neg));
                    }
                    double netBalance1 = Double.parseDouble(this.netBalance.getText());
                    if (netBalance1 < 0) {
                        this.returnedAmount.setText(String.valueOf(Math.abs(netBalance1)));
                        this.netBalance.setText("0.0");
                    } else {
                        this.returnedAmount.setText("0.0");
                    }
                }
            } else {
                Pattern rupeesPattern = Pattern.compile("^\\d{0,10}(\\.\\d{1,15})? *%?$|^$");
                Matcher rupeesMatcher = rupeesPattern.matcher(discount1);
                if (!rupeesMatcher.matches()) {
                    error4.setText("Invalid Amount!");
                } else {
                    double discountRupees1 = Double.parseDouble(discount1);
                    double grandTotal1 = Double.parseDouble(this.grandTotal.getText());
                    if (discountRupees1 > grandTotal1) {
                        error4.setText("Amount > Total!");
                    } else {
                        this.grandTotal.setText(String.valueOf(grandTotal1 - discountRupees1));
                        double grandTotal2 = Double.parseDouble(this.grandTotal.getText());
                        double previousBalance1 = Double.parseDouble(this.previousBalance.getText());
                        double totalPayableAmount = grandTotal2 + previousBalance1;
                        double paidAmount1 = Double.parseDouble(this.paidAmount.getText());
                        double balance = paidAmount1 - totalPayableAmount;
                        if (paidAmount1 <= totalPayableAmount) {
                            this.netBalance.setText(String.valueOf(Math.abs(balance)));
                        } else {
                            double neg = 0 - balance;
                            this.netBalance.setText(String.valueOf(neg));
                        }
                        double netBalance1 = Double.parseDouble(this.netBalance.getText());
                        if (netBalance1 < 0) {
                            this.returnedAmount.setText(String.valueOf(Math.abs(netBalance1)));
                            this.netBalance.setText("0.0");
                        } else {
                            this.returnedAmount.setText("0.0");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_discountCaretUpdate

    private void purchaseRateCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_purchaseRateCaretUpdate
        // TODO add your handling code here:
        String purchaseRate1 = this.purchaseRate.getText();
        this.error2.setText("");
        Pattern costPattern = Pattern.compile("^[0-9][0-9.]*$|^$");
        Matcher purchaseRateMatcher = costPattern.matcher(purchaseRate1);
        if (purchaseRate1.equals("")) {
            this.error2.setText("Amount Required!");
            this.basicPurchaseRate.setText("");
            this.totalAmount.setText("0.0");
        }
        if (!purchaseRateMatcher.matches()) {
            this.error2.setText("Invalid Amount!");
        }
        if (!purchaseRate1.equals("") && purchaseRateMatcher.matches()) {
            String gst1 = this.gst.getSelectedItem().toString();
            if (!gst1.equals(" ")) {
                double n1 = Double.parseDouble(purchaseRate1);
                double n2 = 1 + (Double.parseDouble(gst1) / 100);
                double n3 = n1 / n2;
                String tax = String.valueOf(n3);
                this.basicPurchaseRate.setText(tax);
            }
        }
    }//GEN-LAST:event_purchaseRateCaretUpdate

    private void purchaseRateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchaseRateFocusLost
        // TODO add your handling code here:
        String productName1 = (String) this.productSelector.getSelectedItem();
        String purchaseRate1 = this.purchaseRate.getText();
        String basicPurchaseRate1 = this.basicPurchaseRate.getText();
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM product WHERE productName='" + productName1 + "'");
            String purchaseRate2 = "";
            while (rs.next()) {
                purchaseRate2 = rs.getString("purchaseRate");
            }
            if (!purchaseRate1.equals(purchaseRate2)) {
                if (error2.getText().equals("")) {
                    int ans = JOptionPane.showConfirmDialog(this, "Update Purchase Rate?", "Purchase Rate Updation", JOptionPane.YES_NO_OPTION);
                    if (ans == 0) {
                        s.executeUpdate("UPDATE product SET purchaseRate='" + purchaseRate1 + "' WHERE productName='" + productName1 + "'");
                        s.executeUpdate("UPDATE product SET basicPurchaseRate='" + basicPurchaseRate1 + "' WHERE productName='" + productName1 + "'");
                        JOptionPane.showMessageDialog(this, "Purchase Rate Updated!");
                    }
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
    }//GEN-LAST:event_purchaseRateFocusLost

    private void billNoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_billNoCaretUpdate
        // TODO add your handling code here:
        this.error1.setText("");
    }//GEN-LAST:event_billNoCaretUpdate

    private void billNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billNoFocusLost
        // TODO add your handling code here:
        this.error1.setText("");
        String billNo1 = this.billNo.getText();
        billNo1 = billNo1.replaceAll(" ", "");
        if (billNo1.equals("")) {
            this.error1.setText("Bill No. Required!");
        }
    }//GEN-LAST:event_billNoFocusLost

    private void basicSaleRateCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_basicSaleRateCaretUpdate
        // TODO add your handling code here:
        String basicSaleRate1 = this.basicSaleRate.getText();
        this.error3.setText("");
        Pattern costPattern = Pattern.compile("^[0-9][0-9.]*$|^$");
        Matcher basicSaleRateMatcher = costPattern.matcher(basicSaleRate1);
        if (basicSaleRate1.equals("")) {
            this.error3.setText("Amount Required!");
            this.saleRate.setText("");
        }
        if (!basicSaleRateMatcher.matches()) {
            this.error3.setText("Invalid Amount!");
        }
        if (!basicSaleRate1.equals("") && basicSaleRateMatcher.matches()) {
            String gst1 = this.gst.getSelectedItem().toString();
            if (!gst1.equals(" ")) {
                double n1 = Double.parseDouble(basicSaleRate1);
                double n2 = 1 + (Double.parseDouble(gst1) / 100);
                double n3 = n1 * n2;
                String tax = String.valueOf(n3);
                this.saleRate.setText(tax);
                int n5 = (int) this.quantitySelected.getValue();
                double n6 = n3 * n5;
                String val = String.valueOf(n6);
                this.totalAmount.setText(val);
            }
        }
    }//GEN-LAST:event_basicSaleRateCaretUpdate

    private void basicSaleRateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_basicSaleRateFocusLost
        // TODO add your handling code here:
        String productName1 = (String) this.productSelector.getSelectedItem();
        String basicSaleRate1 = this.basicSaleRate.getText();
        String saleRate1 = this.saleRate.getText();
        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM product WHERE productName='" + productName1 + "'");
            String basicSaleRate2 = "";
            while (rs.next()) {
                basicSaleRate2 = rs.getString("basicSaleRate");
            }
            if (!basicSaleRate1.equals(basicSaleRate2)) {
                if (error3.getText().equals("")) {
                    int ans = JOptionPane.showConfirmDialog(this, "Update Sale Rate?", "Sale Rate Updation", JOptionPane.YES_NO_OPTION);
                    if (ans == 0) {
                        s.executeUpdate("UPDATE product SET basicSaleRate='" + basicSaleRate1 + "' WHERE productName='" + productName1 + "'");
                        s.executeUpdate("UPDATE product SET saleRate='" + saleRate1 + "' WHERE productName='" + productName1 + "'");
                        JOptionPane.showMessageDialog(this, "Sale Rate Updated!");
                    }
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
    }//GEN-LAST:event_basicSaleRateFocusLost

    private void quantitySelectedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantitySelectedStateChanged
        // TODO add your handling code here:
        if (!this.saleRate.getText().equals("")) {
            int quantitySelected1 = (int) this.quantitySelected.getValue();
            int quantity1 = (int) this.quantity.getValue();
            if (quantitySelected1 <= quantity1) {
                double saleRate1 = Double.parseDouble(this.saleRate.getText());
                double totalAmount1 = saleRate1 * quantitySelected1;
                this.totalAmount.setText(String.valueOf(totalAmount1));
            } else {
                this.quantitySelected.setValue(quantitySelected1 - 1);
                JOptionPane.showMessageDialog(this, "Out Of Stock!");
            }
        }
    }//GEN-LAST:event_quantitySelectedStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String productName1 = (String) this.productSelector.getSelectedItem();
        String val = productName1.replaceAll(" ", "");
        if (val.equals("")) {
            JOptionPane.showMessageDialog(this, "No Product Selected!");
        } else {
            int flag1 = 0;
            for (int i = 0; i < productSelector.getItemCount(); i++) {
                String productName2 = (String) this.productSelector.getItemAt(i);
                if (productName1.equals(productName2)) {
                    flag1 = 1;
                }
            }
            if (flag1 == 0) {
                JOptionPane.showMessageDialog(this, "Product '" + productName1 + "' Not Found!");
            } else {
                if (this.error1.getText().equals("") && this.error2.getText().equals("") && this.error3.getText().equals("")) {
                    try {
                        s = c.createStatement();
                        rs = s.executeQuery("SELECT * FROM product WHERE productName='" + productName1 + "'");
                        String hsn1, gst1;
                        int safetyStock1 = 0;
                        hsn1 = gst1 = "";
                        while (rs.next()) {
                            hsn1 = rs.getString("hsn");
                            gst1 = rs.getString("gst");
                            safetyStock1 = rs.getInt("safetyStock");
                        }
                        double basicSaleRate1 = Double.parseDouble(this.basicSaleRate.getText());
                        double gst2 = Double.parseDouble(gst1);
                        int quantity1 = (int) this.quantity.getValue();
                        int quantitySelected1 = (int) this.quantitySelected.getValue();
                        if ((quantity1 - quantitySelected1) <= safetyStock1) {
                            JOptionPane.showMessageDialog(this, "WARNING! Stock Remaining :" + (quantity1 - quantitySelected1));
                        }
                        double taxableAmount1 = basicSaleRate1 * quantitySelected1;
                        double cgst = gst2 / 2;
                        double totalAmount1 = Double.parseDouble(this.totalAmount.getText());
                        double sgst = gst2 / 2;
                        double cgstAmount = (totalAmount1 - taxableAmount1) / 2;
                        double sgstAmount = (totalAmount1 - taxableAmount1) / 2;

                        String productName2;
                        int flag2 = 0;
                        int rowIndex = 0;
                        for (int i = 0; i < model.getRowCount(); i++) {
                            productName2 = (String) model.getValueAt(i, 0);
                            if (productName2.equals(productName1)) {
                                flag2 = 1;
                                rowIndex = i;
                            }
                        }
                        if (flag2 == 1) {
                            int quantityOld = (int) model.getValueAt(rowIndex, 3);
                            int quantityNew = quantityOld + quantitySelected1;
                            double taxableAmountOld = (double) model.getValueAt(rowIndex, 4);
                            double taxableAmountNew = taxableAmountOld + taxableAmount1;
                            double totalAmountOld = (double) model.getValueAt(rowIndex, 9);
                            double totalAmountNew = totalAmountOld + totalAmount1;
                            double sgstAmountNew = (totalAmountNew - taxableAmountNew) / 2;
                            double cgstAmountNew = (totalAmountNew - taxableAmountNew) / 2;
                            model.setValueAt(quantityNew, rowIndex, 3);
                            model.setValueAt(taxableAmountNew, rowIndex, 4);
                            model.setValueAt(totalAmountNew, rowIndex, 9);
                            model.setValueAt(sgstAmountNew, rowIndex, 6);
                            model.setValueAt(cgstAmountNew, rowIndex, 8);
                        } else {
                            Object[] row = {productName1, hsn1, basicSaleRate1, quantitySelected1, taxableAmount1, cgst,
                                cgstAmount, sgst, sgstAmount, totalAmount1};
                            model.addRow(row);
                        }
                        this.quantitySelected.setValue(1);

                        JOptionPane.showMessageDialog(this, "Product Added!");
                        this.grandTotal.setText(String.valueOf(grandTotalCalculator()));
                        tableCheck();
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
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int[] selectedRow = SellProductForm.productTable.getSelectedRows();
        if (selectedRow.length != 0) {
            int temp;
            for (int i = 0; i < selectedRow.length; i++) {
                for (int j = i + 1; j < selectedRow.length; j++) {
                    if (selectedRow[i] < selectedRow[j]) {
                        temp = selectedRow[i];
                        selectedRow[i] = selectedRow[j];
                        selectedRow[j] = temp;
                    }
                }
            }
            for (int i = 0; i < selectedRow.length; i++) {
                model.removeRow(selectedRow[i]);
            }
            this.productSelector.setSelectedItem(" ");
            this.customerName.setSelectedItem(" ");
            JOptionPane.showMessageDialog(this, "Product(s) Removed!");
            this.grandTotal.setText(String.valueOf(grandTotalCalculator()));
            tableCheck();
        } else {
            JOptionPane.showMessageDialog(this, "No Product Selected!");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        try {
            // TODO add your handling code here:
            c.close();
            new SellProductForm().setVisible(true);
            this.dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(SellProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resetButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            c.close();
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        String productName1 = (String) this.productSelector.getSelectedItem();
        int a = this.productSelector.getItemCount();
        for (int i = a - 1; i > 0; i--) {
            this.productSelector.removeItemAt(i);
        }
        productPopulate();

        this.productSelector.setSelectedItem(productName1);

        int b = this.customerName.getItemCount();
        for (int i = b - 1; i > 0; i--) {
            this.customerName.removeItemAt(i);
        }
        customerPopulate();

    }//GEN-LAST:event_formWindowGainedFocus

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // TODO add your handling code here:
        String customerName1 = (String) this.customerName.getEditor().getItem();
        int flag = 0;
        int count = this.customerName.getItemCount();
        for (int i = 1; i < count; i++) {
            String customerName2 = this.customerName.getItemAt(i);
            if (customerName1.equals(customerName2)) {
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }
        this.error4.setText("");
        this.error5.setText("");

        this.mobile.setText("");
        this.streetAddress.setText("");
        this.city.setText("");
        this.state.setSelectedItem(" ");
        this.gstin.setText("");
        this.pan.setText("");
        this.discount.setText("0.0");
        this.previousBalance.setText("0.0");
        this.paidAmount.setText("0.0");
        this.returnedAmount.setText("0.0");
        this.netBalance.setText("0.0");

        this.percent.setEnabled(false);
        this.rupees.setEnabled(false);
        this.discount.setEnabled(false);
        this.paidAmount.setEnabled(false);
        this.saveButton.setEnabled(false);

        this.percent.setFocusable(false);
        this.rupees.setFocusable(false);
        this.discount.setFocusable(false);
        this.paidAmount.setFocusable(false);
        this.saveButton.setFocusable(false);

        rb1.clearSelection();
        if (flag == 1) {
            String val = customerName1.replaceAll(" ", "");

            if (!val.equals("")) {
                String sID = customerName1.replaceAll("[^0-9]", "");
                int customerID1 = Integer.parseInt(sID);
                try {
                    this.percent.setEnabled(true);
                    this.rupees.setEnabled(true);
                    this.paidAmount.setEnabled(true);
                    this.saveButton.setEnabled(true);

                    this.percent.setFocusable(true);
                    this.rupees.setFocusable(true);
                    this.paidAmount.setFocusable(true);
                    this.saveButton.setFocusable(true);

                    s = c.createStatement();
                    rs = s.executeQuery("SELECT * FROM customer WHERE customerID=" + customerID1);
                    String mobile1, streetAddress1, city1, state1, gstin1, pan1, customerBalancePayment1;
                    mobile1 = streetAddress1 = city1 = state1 = gstin1 = pan1 = customerBalancePayment1 = "";
                    while (rs.next()) {
                        mobile1 = rs.getString("mobile");
                        streetAddress1 = rs.getString("streetAddress");
                        city1 = rs.getString("city");
                        state1 = rs.getString("state");
                        gstin1 = rs.getString("gstin");
                        pan1 = rs.getString("pan");
                        customerBalancePayment1 = rs.getString("customerBalancePayment");
                    }
                    this.mobile.setText(mobile1);
                    this.streetAddress.setText(streetAddress1);
                    this.city.setText(city1);
                    this.state.setSelectedItem(state1);
                    this.gstin.setText(gstin1);
                    this.pan.setText(pan1);
                    this.previousBalance.setText(customerBalancePayment1);

                    double grandTotal1 = Double.parseDouble(this.grandTotal.getText());

                    double balance = grandTotal1 + Double.parseDouble(customerBalancePayment1);
                    this.netBalance.setText(String.valueOf(balance));
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
            JOptionPane.showMessageDialog(this, "Customer Not Added/Selected!");
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    private void customerNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerNameItemStateChanged
        // TODO add your handling code here:
        this.error4.setText("");
        this.error5.setText("");

        this.mobile.setText("");
        this.streetAddress.setText("");
        this.city.setText("");
        this.state.setSelectedItem(" ");
        this.gstin.setText("");
        this.pan.setText("");
        this.discount.setText("0.0");
        this.previousBalance.setText("0.0");
        this.paidAmount.setText("0.0");
        this.returnedAmount.setText("0.0");
        this.netBalance.setText("0.0");

        this.percent.setEnabled(false);
        this.rupees.setEnabled(false);
        this.discount.setEnabled(false);
        this.paidAmount.setEnabled(false);
        this.saveButton.setEnabled(false);

        this.percent.setFocusable(false);
        this.rupees.setFocusable(false);
        this.discount.setFocusable(false);
        this.paidAmount.setFocusable(false);
        this.saveButton.setFocusable(false);

        rb1.clearSelection();
    }//GEN-LAST:event_customerNameItemStateChanged

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if (this.error4.getText().equals("") && this.error5.getText().equals("")) {
            //getting all the values to enter in purchaseTransaction table
            String billNo1 = this.billNo.getText();
            String date1 = new SimpleDateFormat("dd/MM/yyyy").format(this.date.getValue());
            String customerName1 = (String) this.customerName.getSelectedItem();
            int customerID1 = Integer.parseInt(customerName1.replaceAll("[^0-9]", ""));
            double totalAmount1 = grandTotalCalculator();
            double discountP1 = 0.0;
            double discountR1 = 0.0;
            if (this.percent.isSelected()) {
                discountP1 = Double.parseDouble(this.discount.getText());
            } else {
                discountR1 = Double.parseDouble(this.discount.getText());
            }
            double grandTotal1 = Double.parseDouble(this.grandTotal.getText());
            double paidAmount1 = Double.parseDouble(this.paidAmount.getText());
            try {
                s = c.createStatement();
                String sql1 = "INSERT INTO saleTransaction(billNo,tdate,customerID"
                        + ",totalAmount,discountP,discountR,grandTotal,paidAmount) "
                        + "VALUES('" + billNo1 + "','" + date1 + "'," + customerID1 + "," + totalAmount1 + "," + discountP1 + "," + discountR1 + "," + grandTotal1 + "," + paidAmount1 + ")";
                s.executeUpdate(sql1);

                int rows = this.model.getRowCount();
                String productName1;
                int productID1 = 0, quantity1;
                double taxableAmount1, cgstp1, cgsta1, sgstp1, sgsta1, totalAmount2;
                for (int i = 0; i < rows; i++) {
                    int newQuantity1 = 0;
                    productName1 = (String) this.model.getValueAt(i, 0);
                    quantity1 = (int) this.model.getValueAt(i, 3);
                    rs = s.executeQuery("SELECT * FROM product WHERE productName='" + productName1 + "'");
                    while (rs.next()) {
                        productID1 = rs.getInt("productID");
                        int tempQuantity = rs.getInt("quantity");
                        newQuantity1 = tempQuantity - quantity1;
                    }

                    taxableAmount1 = (double) this.model.getValueAt(i, 4);
                    cgstp1 = (double) this.model.getValueAt(i, 5);
                    cgsta1 = (double) this.model.getValueAt(i, 6);
                    sgstp1 = (double) this.model.getValueAt(i, 7);
                    sgsta1 = (double) this.model.getValueAt(i, 8);
                    totalAmount2 = (double) this.model.getValueAt(i, 9);
                    String sql2 = "INSERT INTO stdetails(billNo,tDate,customerID,productID,quantity"
                            + ",taxableAmount,cgstp,cgsta,sgstp,sgsta,totalAmount) "
                            + "VALUES('" + billNo1 + "','" + date1 + "'," + customerID1 + "," + productID1 + "," + quantity1 + "," + taxableAmount1 + "," + cgstp1 + "," + cgsta1 + "," + sgstp1 + "," + sgsta1 + "," + totalAmount2 + ")";
                    s.executeUpdate(sql2);

                    String sql3 = "UPDATE product SET quantity=" + newQuantity1 + " WHERE productName='" + productName1 + "'";
                    s.executeUpdate(sql3);

                    double customerBalancePayment1 = Double.parseDouble(this.netBalance.getText());
                    String sql4 = "UPDATE customer SET customerBalancePayment=" + customerBalancePayment1 + " WHERE customerID=" + customerID1;
                    s.executeUpdate(sql4);
                }
                JOptionPane.showMessageDialog(this, "Successfully Saved!");
                int ans = JOptionPane.showConfirmDialog(this, "Do You Want To Print?", "Print Bill", JOptionPane.YES_NO_OPTION);
                if (ans == 0) {
                    String customerName2 = "";
                    String city1 = "";
                    String state1 = "";
                    String gstin1 = "";

                    try {
                        s = c.createStatement();
                        rs = s.executeQuery("SELECT * FROM customer WHERE customerID=" + customerID1);
                        while (rs.next()) {
                            customerName2 = rs.getString("customerName");
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

                    pf.customerName.setText("Name : " + customerName2);
                    pf.customerName1.setText("Name : " + customerName2);
                    pf.customerAddress.setText("Address : " + city1);
                    pf.customerAddress1.setText("Address : " + city1);
                    pf.customerGSTIN.setText("GSTIN : " + gstin1);
                    pf.customerGSTIN1.setText("GSTIN : " + gstin1);
                    pf.customerState.setText("State : " + state1);
                    pf.customerState1.setText("State : " + state1);
                    String stateCode1 = pf.stateCodeGen(state1);
                    pf.customerStateCode.setText("State Code : " + stateCode1);
                    pf.customerStateCode1.setText("State Code : " + stateCode1);
                    double taxableAmount2, cgsta2, sgsta2;
                    taxableAmount2 = cgsta2 = sgsta2 = 0.0;
                    for (int i = 0; i < rows; i++) {
                        taxableAmount2 += (double) this.model.getValueAt(i, 4);
                        cgsta2 += (double) this.model.getValueAt(i, 6);
                        sgsta2 += (double) this.model.getValueAt(i, 8);
                    }
                    pf.taxableAmount.setText("Total Amount Before Tax : " + new DecimalFormat("##.##").format(taxableAmount2) + " Rs.");
                    pf.totalCGST.setText("Add : CGST : " + new DecimalFormat("##.##").format(cgsta2) + " Rs.");
                    pf.totalSGST.setText("Add : SGST : " + new DecimalFormat("##.##").format(sgsta2) + " Rs.");
                    pf.totalGST.setText("Tax Amount : GST : " + new DecimalFormat("##.##").format((cgsta2 + sgsta2)) + " Rs.");
                    double afterTax = Double.parseDouble(this.grandTotal.getText());
                    pf.amountWithTax.setText("Total Amount After Tax : " + new DecimalFormat("##.##").format(afterTax) + " Rs.");
                    if (discountP1 != 0.0) {
                        pf.discount.setText("Discount : " + discountP1 + " %");
                    } else {
                        pf.discount.setText("Discount : " + discountR1 + " Rs.");
                    }
                    
                    int num1 = (int) grandTotal1;
                    double rf = grandTotal1-num1;
                    pf.roundoff.setText("Round Off : "+ new DecimalFormat("##.##").format(rf) + " Rs.");
                    pf.totalAmount.setText("Total Amount : " + new DecimalFormat("##.##").format(num1) + ".00 Rs.");
                    int rows2 = this.model.getRowCount();
                    int SrNo = 1;
                    for (int i = 0; i < rows2; i++) {
                        String productName2 = (String) this.model.getValueAt(i, 0);
                        String hsn2 = (String) this.model.getValueAt(i, 1);
                        double rate2 = (double) this.model.getValueAt(i, 2);
                        int quantity2 = (int) this.model.getValueAt(i, 3);
                        double taxableAmt = (double) this.model.getValueAt(i, 4);
                        double cgstp2 = (double) this.model.getValueAt(i, 5);
                        double cgsta3 = (double) this.model.getValueAt(i, 6);
                        double sgstp2 = (double) this.model.getValueAt(i, 7);
                        double sgsta3 = (double) this.model.getValueAt(i, 8);
                        double totalAmount3 = (double) this.model.getValueAt(i, 9);
                        Object[] rowData = {SrNo, productName2, hsn2, Double.parseDouble(new DecimalFormat("##.##").format(rate2)),
                            quantity2, Double.parseDouble(new DecimalFormat("##.##").format(taxableAmt)), cgstp2, Double.parseDouble(new DecimalFormat("##.##").format(cgsta3)),
                            sgstp2, Double.parseDouble(new DecimalFormat("##.##").format(sgsta3)), Double.parseDouble(new DecimalFormat("##.##").format(totalAmount3))};
                        pf.model.addRow(rowData);
                        SrNo++;
                    }
                    int num = (int) grandTotal1;
                    String words1 = (NumberFormat.getInstance().format(grandTotal1) + "='" + PrintForm.convert(num) + "'");
                    words1 = words1.replaceAll("[^a-zA-Z ]", "");
                    pf.words.setText(words1 + " Rs.");
                    pf.printOnPaper();
                }
                c.close();
                new SellProductForm().setVisible(true);
                this.dispose();
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
    }//GEN-LAST:event_saveButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            c.close();
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_formWindowClosing

    private void selectButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButton1ActionPerformed
        // TODO add your handling code here:
        String productName1 = (String) this.productSelector.getEditor().getItem();
        int flag = 0;
        int count = this.productSelector.getItemCount();
        for (int i = 1; i < count; i++) {
            String productName2 = this.productSelector.getItemAt(i);
            if (productName1.equals(productName2)) {
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }

        this.error2.setText("");
        this.error3.setText("");
        this.gst.setSelectedIndex(0);
        this.purchaseRate.setText("");
        this.basicPurchaseRate.setText("");
        this.basicSaleRate.setText("");
        this.saleRate.setText("");
        this.quantity.setValue(0);
        this.quantitySelected.setValue(1);
        this.totalAmount.setText("");
        this.gst.setEnabled(false);
        this.purchaseRate.setEnabled(false);
        this.basicSaleRate.setEnabled(false);
        this.quantitySelected.setEnabled(false);

        this.gst.setFocusable(false);
        this.purchaseRate.setFocusable(false);
        this.basicSaleRate.setFocusable(false);
        this.quantitySelected.setFocusable(false);
        if (flag == 1) {
            try {
                s = c.createStatement();
                rs = s.executeQuery("SELECT * FROM product WHERE productName='" + productName1 + "'");
                int quantity3 = 0;
                while (rs.next()) {
                    quantity3 = rs.getInt("quantity");
                }
                if (quantity3 == 0) {
                    this.error2.setText("");
                    this.error3.setText("");
                    JOptionPane.showMessageDialog(this, "Stock Is Empty!");
                } else {
                    String val = productName1.replaceAll(" ", "");
                    if (!val.equals("")) {
                        try {
                            this.purchaseRate.setEnabled(true);
                            this.basicSaleRate.setEnabled(true);
                            this.quantitySelected.setEnabled(true);

                            this.purchaseRate.setFocusable(true);
                            this.basicSaleRate.setFocusable(true);
                            this.quantitySelected.setFocusable(true);

                            s = c.createStatement();
                            rs = s.executeQuery("SELECT * FROM product WHERE productName='" + productName1 + "'");
                            String gst1, purchaseRate1, basicPurchaseRate1, basicSaleRate1, saleRate1;
                            gst1 = purchaseRate1 = basicPurchaseRate1 = basicSaleRate1 = saleRate1 = "";
                            int quantity1 = 0;
                            while (rs.next()) {
                                gst1 = rs.getString("gst");
                                purchaseRate1 = rs.getString("purchaseRate");
                                basicPurchaseRate1 = rs.getString("basicPurchaseRate");
                                basicSaleRate1 = rs.getString("basicSaleRate");
                                saleRate1 = rs.getString("saleRate");
                                quantity1 = rs.getInt("quantity");
                            }

                            this.quantity.setValue(quantity1);
                            int rows = this.model.getRowCount();
                            for (int i = 0; i < rows; i++) {
                                String productName2 = (String) this.model.getValueAt(i, 0);
                                if (productName2.equals(productName1)) {
                                    int quantity2 = (int) this.model.getValueAt(i, 3);
                                    this.quantity.setValue(quantity1 - quantity2);
                                }
                            }
                            this.gst.setSelectedItem(gst1);
                            this.purchaseRate.setText(purchaseRate1);
                            this.basicPurchaseRate.setText(basicPurchaseRate1);
                            this.basicSaleRate.setText(basicSaleRate1);
                            this.saleRate.setText(saleRate1);
                            this.quantitySelected.setValue(2);
                            this.quantitySelected.setValue(1);

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
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

        } else {
            this.error2.setText("");
            this.error3.setText("");
            JOptionPane.showMessageDialog(this, "Product Not Added/Selected!");
        }
    }//GEN-LAST:event_selectButton1ActionPerformed

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
                new SellProductForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField basicPurchaseRate;
    private javax.swing.JTextField basicSaleRate;
    private javax.swing.JTextField billNo;
    private javax.swing.JTextField city;
    private javax.swing.JComboBox<String> customerName;
    private javax.swing.JSpinner date;
    private javax.swing.JTextField discount;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JTextField grandTotal;
    private javax.swing.JComboBox<String> gst;
    private javax.swing.JTextField gstin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField netBalance;
    private javax.swing.JTextField paidAmount;
    private javax.swing.JTextField pan;
    private javax.swing.JRadioButton percent;
    private javax.swing.JTextField previousBalance;
    private javax.swing.JComboBox<String> productSelector;
    private static javax.swing.JTable productTable;
    private javax.swing.JTextField purchaseRate;
    private javax.swing.JSpinner quantity;
    private javax.swing.JSpinner quantitySelected;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField returnedAmount;
    private javax.swing.JRadioButton rupees;
    private javax.swing.JTextField saleRate;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JButton selectButton1;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JTextField streetAddress;
    private javax.swing.JTextField totalAmount;
    // End of variables declaration//GEN-END:variables
}
