
package UserSetting;

import Database_Connection.DBConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Department_info_user extends javax.swing.JFrame {

    Connection con;
   
     PreparedStatement prepStmt = null;
     ResultSet res = null;
    
    public Department_info_user() {
        
        
        try {
            
            initComponents();
            
            con=DBConnection.DBConnection();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Department_info_user.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try{
            String sqlSrch = "Select distinct(dept_id) AS DeptID from department_info";
            prepStmt=con.prepareStatement(sqlSrch);
            res=prepStmt.executeQuery();
            while(res.next())
            {
               
                String dsg=res.getString("DeptID");
               jComboBox1.addItem(dsg);
               
            }
           
        }catch(SQLException e)
        {
            
        }
        
        //to show table at starting
        
        
        DefaultTableModel tb = (DefaultTableModel)jTable1.getModel();
        
        
        try{
            
            
            String sqlSearch="select * from department_info";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                
                {
                    
                    String ID = res.getString("dept_id");
                    String Name = res.getString("dept_name");
                    
                    tb.addRow(new Object[]{ID,Name});
                    
                    
                    
            
        }
            
            
           
            
        }catch(Exception e)
        {
            
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

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldDeptID = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDeptName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldsearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Showtable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Employee Management System");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Department Information");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jButtonDelete.setText("Delete");
        jButtonDelete.setEnabled(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.setEnabled(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Exit");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButton1)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonEdit)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldDeptID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDeptIDActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select ID" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Department Name :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Department ID :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldDeptID)
                    .addComponent(jTextFieldDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDeptID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));

        jTextFieldsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldsearchActionPerformed(evt);
            }
        });

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Showtable.setText("Show Table");
        Showtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowtableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(151, 151, 151)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Showtable)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Showtable)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
        try{
            
           String sqlQry = "INSERT INTO department_info(dept_id,dept_name) VALUES(?,?)";
           
           prepStmt = con.prepareStatement(sqlQry);
           
           
           prepStmt.setString(1, jTextFieldDeptID.getText());
           prepStmt.setString(2, jTextFieldDeptName.getText());
            
            int i= prepStmt.executeUpdate();
                       
            if(i>0){
                
            JOptionPane.showMessageDialog(this, "Saved");
            
            }
        }catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
       
       int test = 1;
        
        try{
            
            String Search = jTextFieldsearch.getText();
            String sqlSearch="select * from department_info where dept_id = '"+Search+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                
                {
                    
                    String ID = res.getString("dept_id");
                    String Name = res.getString("dept_name");
                    
                    
                    jTextFieldDeptID.setText(ID);
                    jTextFieldDeptName.setText(Name);
                    
                    test=0;
                    JOptionPane.showMessageDialog(this, "Weldone"+"\n"+"Searching Completed");
                    break;
            
        }
            
            
          if(test==1){
                JOptionPane.showMessageDialog(this, "Error Occurred!!!"+"\n"+"\n"+"Data Not Found"+"\n"+"Please Try Again Later");
            }  
            
        }catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jTextFieldDeptIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDeptIDActionPerformed
        
    }//GEN-LAST:event_jTextFieldDeptIDActionPerformed

    private void jTextFieldsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldsearchActionPerformed
        int test = 1;
        
        try{
            
            String Search = jTextFieldsearch.getText();
            String sqlSearch="select * from department_info where dept_id = '"+Search+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                
                {
                    
                    String ID = res.getString("dept_id");
                    String Name = res.getString("dept_name");
                    
                    
                    jTextFieldDeptID.setText(ID);
                    jTextFieldDeptName.setText(Name);
                    
                    test=0;
                    JOptionPane.showMessageDialog(this, "Weldone"+"\n"+"Searching Completed");
                    break;
            
        }
            
            
          if(test==1){
                JOptionPane.showMessageDialog(this, "Error Occurred!!!"+"\n"+"\n"+"Data Not Found"+"\n"+"Please Try Again Later");
            }  
            
        }catch(HeadlessException | SQLException e)
        {
            
        }
    }//GEN-LAST:event_jTextFieldsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         DefaultTableModel tb = (DefaultTableModel)jTable1.getModel();
         int row=jTable1.getRowCount();
         for(int i=row-1;i>=0;i--)
         {
             tb.removeRow(i);
         }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        int msg = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are You Sure to Exit?","Warning",msg);
        if (result==0)
        {
        System.exit(0);
        }
        else
        {
            System.out.println(" ");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        int test = 1;
        
        try{
            String idnumber = JOptionPane.showInputDialog("Enter ID :");
            
            String sqlSearch="select * from department_info where dept_id = '"+idnumber+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                {
                    
                    String ID = res.getString("dept_id");
                    String Name = res.getString("dept_name");
                    
                    
                    
                    jTextFieldDeptID.setText(ID);
                    jTextFieldDeptName.setText(Name);
                    
                    test=0;
                    JOptionPane.showMessageDialog(this, "Edit Your Information"+"\n"+"And Click on Update Button");
                    break;
            
        }
            
            
          if(test==1){
                JOptionPane.showMessageDialog(this, "Error Occurred!!!"+"\n"+"\n"+"Data Not Found"+"\n"+"Please Try Again Later");
            }  
            
        }
        catch(SQLException e){
            
           
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
       try{
            
            
            String sqlQry="UPDATE department_info SET dept_name= ? WHERE dept_id = ?";
            
            prepStmt = con.prepareStatement(sqlQry);

                        
                        prepStmt.setString(1, jTextFieldDeptName.getText());
                        
                        prepStmt.setString(2, jTextFieldDeptID.getText());
                       
                       int i= prepStmt.executeUpdate();
                       
                       if(i>0){
                           JOptionPane.showMessageDialog(this, "DATABAE UPDATED");
                       }
            
        }catch(SQLException e){
            
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        int msg=JOptionPane.YES_NO_OPTION;
        
        
       int result= JOptionPane.showConfirmDialog(this, "Are You Sure to Delete?","Warning",msg);
        if(result==0){
            
        try{
            String sqlQry="DELETE from department_info WHERE dept_id= ?";
            
             prepStmt = con.prepareStatement(sqlQry);
            
            prepStmt.setString(1, jTextFieldDeptID.getText());
                       
                       int i= prepStmt.executeUpdate();
                       
                       if(i>0){
                           JOptionPane.showMessageDialog(this, "RECORD DELETED");
                       }
            
        }catch(SQLException | HeadlessException e)
        {
            
        }
        
        
        
        jTextFieldDeptID.setText(null);
        jTextFieldDeptName.setText(null);
        
        }else{
           System.out.println("No Option");
        }
        
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
        try{
            
            
            String sqlSearch="select * from department_info where dept_id = '"+jComboBox1.getSelectedItem()+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                {
                    
                    String ID = res.getString("dept_id");
                    String Name = res.getString("dept_name");
                    
                    
                    
                    
                    jTextFieldDeptID.setText(ID);
                    jTextFieldDeptName.setText(Name);
                   
                    
           
        }
       
        }
        catch(SQLException e){
            
           
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ShowtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowtableActionPerformed
       
        
         DefaultTableModel tb = (DefaultTableModel)jTable1.getModel();
         int row=jTable1.getRowCount();
         for(int i=row-1;i>=0;i--)
         {
             tb.removeRow(i);
         }
        
       // DefaultTableModel tb = (DefaultTableModel)jTable1.getModel();
        
        
        try{
            
            
            String sqlSearch="select * from department_info";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                
                {
                    
                    String ID = res.getString("dept_id");
                    String Name = res.getString("dept_name");
                    
                    tb.addRow(new Object[]{ID,Name});
                    
                    
                    
            
        }
            
            
           
            
        }catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_ShowtableActionPerformed

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
            java.util.logging.Logger.getLogger(Department_info_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Department_info_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Department_info_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Department_info_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Department_info_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Showtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDeptID;
    private javax.swing.JTextField jTextFieldDeptName;
    private javax.swing.JTextField jTextFieldsearch;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

}
