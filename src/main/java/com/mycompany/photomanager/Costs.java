/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.photomanager;

import com.mycompany.dbConnector.ConnectionCost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author aleks
 */
public class Costs extends javax.swing.JFrame {
    
    
    ConnectionCost sqlConn = new ConnectionCost();
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;

    /** Creates new form Costs */
    public Costs() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        upDateDB();
    }

    //=========================================================Function=========================================================
    
    public void upDateDB()
    {
        try
        {
            Connection sqlConn = ConnectionCost.getCon();
            pst = sqlConn.prepareStatement("Select * from Costs");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTableCost.getModel();
                    RecordTable.setRowCount(0);
                    
                    while(rs.next()){
                    Vector columnData = new Vector();
                    
                    for(i = 1; i <= q; i++)
                    {
                        columnData.add(rs.getString("Number"));
                        columnData.add(rs.getString("CostKind"));
                        columnData.add(rs.getString("Year"));
                        columnData.add(rs.getString("Month"));
                        columnData.add(rs.getString("Value"));
                        columnData.add(rs.getString("Comments"));
                    }
                    RecordTable.addRow(columnData);
     
                    }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        
        }

    }

    //=========================================================End Function=========================================================
    
    public void search (String str)
    {
    
        DefaultTableModel model = (DefaultTableModel)jTableCost.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTableCost.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnHome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboCostKind = new javax.swing.JComboBox<>();
        jComboYear = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboMonth = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtxtComments = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtValue = new javax.swing.JTextField();
        jAddButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCost = new javax.swing.JTable();
        jtxtSearchBar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jbtnUpdate = new javax.swing.JButton();
        jbtnPrint = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnHome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnHome.setText("Home");
        jbtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHomeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel2.setText("Costs");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Cost kind:");

        jComboCostKind.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jComboCostKind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fuel", "Advertisment", "Polish Taxes", "World Taxes", "Accountant", "Photoshop", "Equipment", "Health Contribution", "Photos", "Office Supplies", "Other" }));

        jComboYear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jComboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Year:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Month:");

        jComboMonth.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jComboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "Septemper", "October", "November", "December" }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Comments:");

        jtxtComments.setBackground(new java.awt.Color(255, 255, 204));
        jtxtComments.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Value:");

        jtxtValue.setBackground(new java.awt.Color(255, 255, 204));
        jtxtValue.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N

        jAddButton.setBackground(new java.awt.Color(204, 255, 204));
        jAddButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jAddButton.setForeground(new java.awt.Color(0, 0, 0));
        jAddButton.setText("Add");
        jAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddButtonActionPerformed(evt);
            }
        });

        jTableCost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Number", "CostKind", "Year", "Month", "Value", "Comments"
            }
        ));
        jTableCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCostMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCost);
        if (jTableCost.getColumnModel().getColumnCount() > 0) {
            jTableCost.getColumnModel().getColumn(0).setMaxWidth(90);
            jTableCost.getColumnModel().getColumn(1).setMinWidth(280);
            jTableCost.getColumnModel().getColumn(1).setMaxWidth(280);
            jTableCost.getColumnModel().getColumn(2).setMaxWidth(90);
            jTableCost.getColumnModel().getColumn(3).setMinWidth(180);
            jTableCost.getColumnModel().getColumn(3).setMaxWidth(180);
            jTableCost.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        jtxtSearchBar.setBackground(new java.awt.Color(255, 255, 204));
        jtxtSearchBar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtxtSearchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtSearchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtSearchBarMouseClicked(evt);
            }
        });
        jtxtSearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtSearchBarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtSearchBarKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Search here:");

        jbtnUpdate.setBackground(new java.awt.Color(204, 255, 255));
        jbtnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnPrint.setBackground(new java.awt.Color(204, 255, 255));
        jbtnPrint.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnPrint.setForeground(new java.awt.Color(0, 0, 0));
        jbtnPrint.setText("Print");
        jbtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintActionPerformed(evt);
            }
        });

        jbtnDelete.setBackground(new java.awt.Color(255, 51, 51));
        jbtnDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnDelete.setForeground(new java.awt.Color(0, 0, 0));
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnPrint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnDelete))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1469, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnUpdate)
                    .addComponent(jbtnPrint)
                    .addComponent(jbtnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnReset.setBackground(new java.awt.Color(204, 255, 255));
        jbtnReset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnReset.setForeground(new java.awt.Color(0, 0, 0));
        jbtnReset.setText("Reset");
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboCostKind, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtComments, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jAddButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(484, 484, 484)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnReset)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jbtnReset)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCostKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddButton))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHomeActionPerformed

        setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_jbtnHomeActionPerformed

    private void jtxtSearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtSearchBarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSearchBarMouseClicked

    private void jtxtSearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchBarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSearchBarKeyPressed

    private void jtxtSearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchBarKeyReleased

        String searchString = jtxtSearchBar.getText();
        search(searchString);

    }//GEN-LAST:event_jtxtSearchBarKeyReleased

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        jComboCostKind.setSelectedIndex(0);  
        jComboYear.setSelectedIndex(0);
        jComboMonth.setSelectedIndex(0);
        jtxtValue.setText("");
        jtxtComments.setText("");
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        
        int row1 = jTableCost.getSelectedRow();
        String value = jTableCost.getModel().getValueAt(row1, 0).toString();
        
        try
        {
            Connection sqlConn = ConnectionCost.getCon();
            
            pst = sqlConn.prepareStatement("update costs set CostKind = ?,Year = ?,Month = ?,Value = ?,Comments = ? where Number = " + value);
            
            pst.setString(1, jComboCostKind.getSelectedItem().toString());
            pst.setString(2, jComboYear.getSelectedItem().toString());
            pst.setString(3, jComboMonth.getSelectedItem().toString());
            pst.setString(4, jtxtValue.getText());
            pst.setString(5, jtxtComments.getText());

            pst.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel)jTableCost.getModel();
            model.setRowCount(0);
            
            JOptionPane.showMessageDialog(this, "Record Updated");
            upDateDB();
        }
        catch (SQLException ex){
        java.util.logging.Logger.getLogger(ConnectionCost.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintActionPerformed
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
    
        try
        {
        jTableCost.print(JTable.PrintMode.NORMAL,header, footer);
        }
        catch(Exception exception)
        {
        System.err.format("No printer found", exception.getMessage());
    }//GEN-LAST:event_jbtnPrintActionPerformed
    }
    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        DefaultTableModel RecordTable = (DefaultTableModel)jTableCost.getModel();
        int SelectedRows = jTableCost.getSelectedRow();
    
        try
        {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete",
            "Warning",JOptionPane.YES_NO_OPTION);
            if (deleteItem==JOptionPane.YES_OPTION){
            
            Connection sqlConn = ConnectionCost.getCon();
            pst = sqlConn.prepareStatement("delete from costs where Number=?");
            
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Deleted");
            upDateDB();
            
            jComboCostKind.setSelectedIndex(0);  
            jComboYear.setSelectedIndex(0);
            jComboMonth.setSelectedIndex(0);
            jtxtValue.setText("");
            jtxtComments.setText("");
    
        }
    }
        catch(SQLException e){
        System.err.println(e);
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jTableCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCostMouseClicked
                DefaultTableModel RecordTable = (DefaultTableModel)jTableCost.getModel();
                 int SelectedRows = jTableCost.getSelectedRow();
                 
                 jComboCostKind.setSelectedItem(RecordTable.getValueAt(SelectedRows, 1));
                 jComboMonth.setSelectedItem(RecordTable.getValueAt(SelectedRows, 2));
                 jComboYear.setSelectedItem(RecordTable.getValueAt(SelectedRows, 3));
                 jtxtValue.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
                 jtxtComments.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    }//GEN-LAST:event_jTableCostMouseClicked

    private void jAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddButtonActionPerformed
        
        try
       {
            Connection sqlConn = ConnectionCost.getCon();
            pst = sqlConn.prepareStatement("insert into costs(CostKind,Year,Month,Value,Comments)value (?,?,?,?,?)");
            
            pst.setString(1, jComboCostKind.getSelectedItem().toString());
            pst.setString(2, jComboYear.getSelectedItem().toString());
            pst.setString(3, jComboMonth.getSelectedItem().toString());
            pst.setString(4, jtxtValue.getText());
            pst.setString(5, jtxtComments.getText());
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record added");
            upDateDB();
       }
       
                catch (SQLException ex){
                java.util.logging.Logger.getLogger(ConnectionCost.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
                JOptionPane.showMessageDialog(this, "Connection problem or incorrect datas");
               }
        
    }//GEN-LAST:event_jAddButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Costs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Costs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Costs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Costs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Costs().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddButton;
    private javax.swing.JComboBox<String> jComboCostKind;
    private javax.swing.JComboBox<String> jComboMonth;
    private javax.swing.JComboBox<String> jComboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCost;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnHome;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JTextField jtxtComments;
    private javax.swing.JTextField jtxtSearchBar;
    private javax.swing.JTextField jtxtValue;
    // End of variables declaration//GEN-END:variables

}
