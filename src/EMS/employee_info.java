
package EMS;

import Database_Connection.DBConnection;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.coobird.thumbnailator.Thumbnails;

import Database_Connection.DBConnection;
import Desig_info.Designation_info;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class employee_info extends javax.swing.JFrame {
    
    Connection con;
    String gender=" ";
    
    
    PreparedStatement prepStmt = null;
    ResultSet res = null;
    
    //variable for image
    
    private ImageIcon format=null;
    String filename=null;
    byte[] person_image=null;

   
    public employee_info() {
        initComponents();
       // this.setResizable(false); // to control screen size;
        try {
            
            
            
            con=DBConnection.DBConnection();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(employee_info.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        Toolkit toolkit = getToolkit(); //we use Toolkit class to know the resulation of window;
        Dimension size = toolkit.getScreenSize();  //toolkit figure out the size of Screen;
        
        
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        
        
        //Designation from database
        
        
        try{
            String sqlSrch = "Select distinct(desig_name) AS Desg from designatation_info";
            prepStmt=con.prepareStatement(sqlSrch);
            res=prepStmt.executeQuery();
            while(res.next())
            {
               
                String dsg=res.getString("Desg");
               jComboBoxDesignation.addItem(dsg);
               
            }
           
        }catch(SQLException e)
        {
        }
        
        
        //Department 
        
        
        try{
            String sqlSrch = "Select distinct(dept_name) AS Dept from department_info";
            prepStmt=con.prepareStatement(sqlSrch);
            res=prepStmt.executeQuery();
            while(res.next())
            {
               
                String dsg=res.getString("Dept");
               jComboBoxDepartment.addItem(dsg);
               
            }
           
        }catch(SQLException e)
        {
        }
        
        //EMP_ID
        
        try{
            String sqlSrch = "Select distinct(id) AS ID from employee_info";
            prepStmt=con.prepareStatement(sqlSrch);
            res=prepStmt.executeQuery();
            while(res.next())
            {
               
                String id=res.getString("ID");
               jComboBoxSelectID.addItem(id);
               
            }
           
        }catch(SQLException e)
        {
        }
        
        
        
        ///Auto Increment Emp_ID
        
        try{
            String sqlSrch = "Select COALESCE(MAX(id),0) AS ID from employee_info";
            prepStmt=con.prepareStatement(sqlSrch);
            res=prepStmt.executeQuery();
            while(res.next())
            {
               
                String id=res.getString("ID");
               int empid = Integer.parseInt(id)+1;
               String emp_id = Integer.toString(empid);
               jTextFieldID.setText(emp_id);
               
            }
           
        }catch(SQLException e)
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

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBirth = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldJoin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxBloodGroup = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxDepartment = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldConact = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxDesignation = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jButtonSave = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxSelectID = new javax.swing.JComboBox();
        jTextFieldCombodeptSearch = new javax.swing.JTextField();
        jTextFielddeptsearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        imageLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emoloyee Informatiion");
        setBackground(new java.awt.Color(0, 153, 153));
        setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Employee Management System");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Employee ID :");

        jTextFieldID.setEditable(false);
        jTextFieldID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Employee Name :");

        jTextFieldName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Gender :");

        jRadioButtonMale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonMale.setText("Male");
        jRadioButtonMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMaleActionPerformed(evt);
            }
        });

        jRadioButtonFemale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonFemale.setText("Female");
        jRadioButtonFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFemaleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Birth Date :");

        jTextFieldBirth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Join  Date :");

        jTextFieldJoin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Blood Group :");

        jComboBoxBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxBloodGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+ (A Positive)", "A - (A Negative)", "B+ (B Positive)", "B - (B Negative)", "AB+ (AB Positive)", "AB - (AB Negative)", "O+ (O Poisitve)", "O - (O Negative)" }));
        jComboBoxBloodGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBloodGroupActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Department :");

        jComboBoxDepartment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBoxDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartmentActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Contact No :");

        jTextFieldConact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Address :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Designation :");

        jComboBoxDesignation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxDesignation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBoxDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDesignationActionPerformed(evt);
            }
        });

        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextAreaAddress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAddress);

        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonEdit.setText("Update");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonRefresh.setText("Refreah");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonCancel.setText("Exit");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jComboBoxSelectID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxSelectID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select ID" }));
        jComboBoxSelectID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectIDActionPerformed(evt);
            }
        });

        jTextFieldCombodeptSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextFielddeptsearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFielddeptsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielddeptsearchActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel12.setText("Search by Employee ID");

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButton3.setText("Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setText("Attach Photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(imageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Add New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldConact, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jTextFieldName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonMale)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonFemale))
                            .addComponent(jTextFieldBirth)
                            .addComponent(jTextFieldJoin)
                            .addComponent(jComboBoxDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDesignation, 0, 213, Short.MAX_VALUE)
                            .addComponent(jComboBoxBloodGroup, 0, 1, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFielddeptsearch, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCombodeptSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxSelectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(jTextField1)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRefresh)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSave)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEdit)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxSelectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonMale)
                            .addComponent(jRadioButtonFemale))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxBloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFielddeptsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCombodeptSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldConact)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonRefresh)
                    .addComponent(jButtonCancel)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void print_emp_Salary_Inforeport() throws SQLException, BadElementException, IOException {
    Document document = new Document(PageSize.A4.rotate());
       // Document document = new Document(PageSize.A4);
        Font ff1 = new Font(Font.BOLD, 13);
        ff1.setStyle(Font.UNDERLINE);
        ff1.setColor(Color.BLACK);
        ff1.setStyle(Font.BOLD);
        
        Font ff5 = new Font(Font.BOLD, 18);
        ff5.setStyle(Font.UNDERLINE);
        ff5.setColor(Color.BLACK);
        ff5.setStyle(Font.BOLD);
        Font ff3 = new Font(Font.NORMAL, 11);
        ff3.setStyle(Font.COURIER);
        ff3.setColor(Color.BLACK);
        Font ff4 = new Font(Font.BOLD, 10);
        ff4.setStyle(Font.NORMAL);
        ff4.setColor(Color.BLACK);
       Paragraph paragraph3 = new Paragraph("\n");         
        paragraph3.setAlignment(Element.ALIGN_CENTER);
       try {

PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("EmplyeeSalaryInfo.pdf"));
            document.open();
      PdfContentByte cb = writer.getDirectContent();
PdfPTable table = new PdfPTable(2);
PdfPCell cell5 = new PdfPCell();
String a = "";
            String a11 = "";
            String amount = "";
            String amount1 = "";
            String amount2 = "";
            float b = 0;
            String dd = "";
            String Age = "";
            String id="",BS="",medical="",HR="",T="",TS="",name="",desig="";

            try {
                String Rsearch=jTextFieldSearch.getText();
            String sqlQry="Select * from employee_info where Emp_ID='"+Rsearch+"'";
            
            prepStmt=con.prepareStatement(sqlQry);
            res=prepStmt.executeQuery();
            while(res.next())
            {
                id=res.getString("Emp_ID");
                BS=res.getString("Basic_Salary");
                medical=res.getString("Medical_A");
                HR=res.getString("House_R");
                T=res.getString("Transport_A");
                TS=res.getString("Total_salary");
                //combo=res.getString("Emp_ID");
             
}
            }catch(Exception e){
            }
            }catch(Exception e)
            {
                
            }

    }
    
    
    
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        
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
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
     
         try{
            
            
            String sqlQry="insert into employee_info(id,name,gender,birthdate,joindate,bloodgroup,department,designation,contact,address,image) values(?,?,?,?,?,?,?,?,?,?,?)";
            
            prepStmt = con.prepareStatement(sqlQry);

                        prepStmt.setString(1, jTextFieldID.getText());
                        prepStmt.setString(2, jTextFieldName.getText());
                        prepStmt.setString(3, gender);
                        prepStmt.setString(4, jTextFieldBirth.getText());
                        prepStmt.setString(5, jTextFieldJoin.getText());
                        prepStmt.setString(6, (String) jComboBoxBloodGroup.getSelectedItem());
                        prepStmt.setString(7, (String) jComboBoxDepartment.getSelectedItem());
                        prepStmt.setString(8, (String) jComboBoxDesignation.getSelectedItem());
                        prepStmt.setString(9, jTextFieldConact.getText());
                        prepStmt.setString(10, jTextAreaAddress.getText());
                        prepStmt.setBytes(11, person_image);
                       
                       int i= prepStmt.executeUpdate();
                       
                       if(i>0){
                           JOptionPane.showMessageDialog(this, "Saved");
                       }
            
        }catch(SQLException e){
            
        }
        
        
        
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jRadioButtonMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMaleActionPerformed
        
        
        try{
            if(jRadioButtonMale.isSelected())
            {
                gender="Male";
                jRadioButtonFemale.setSelected(false);
            }
            
        }catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jRadioButtonMaleActionPerformed

    private void jRadioButtonFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFemaleActionPerformed
       
        
        
        try{
            if(jRadioButtonFemale.isSelected())
            {
                gender="Female";
                jRadioButtonMale.setSelected(false);
            }
            
        }catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jRadioButtonFemaleActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed

        ///Auto Increment Emp_ID
        ///Automatic putdown emp_Id
        
        try{
            String sqlSrch = "Select COALESCE(MAX(id),0) AS ID from employee_info";
            prepStmt=con.prepareStatement(sqlSrch);
            res=prepStmt.executeQuery();
            while(res.next())
            {
               
                String id=res.getString("ID");
               int empid = Integer.parseInt(id)+1;
               String emp_id = Integer.toString(empid);
               jTextFieldID.setText(emp_id);
               
            }
           
        }catch(SQLException e)
        {
        }
        jTextFieldName.setText(null);
        jRadioButtonMale.setSelected(false);
        jRadioButtonFemale.setSelected(false);
        jTextFieldBirth.setText(null);
        jTextFieldJoin.setText(null);
        jComboBoxBloodGroup.setSelectedItem("A+ (A Positive)");
        jComboBoxDepartment.setSelectedItem("Select");
        jComboBoxDesignation.setSelectedItem("Select");
        jTextFieldConact.setText(null);
        jTextAreaAddress.setText(null);
        jTextFieldSearch.setText(null);
        jTextFieldCombodeptSearch.setText(null);
        jTextFielddeptsearch.setText(null);
        jComboBoxSelectID.setSelectedItem("Select ID");
        imageLabel.setIcon(null);

    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jComboBoxBloodGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBloodGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBloodGroupActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
       
        
        
         int test = 1;
        
        try{
            String SearchID = jTextFieldSearch.getText();
            
            String sqlSearch="select * from employee_info where id = '"+SearchID+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                {
                    
                    String ID = res.getString("id");
                    String Name = res.getString("name");
                    String Gender = res.getString("gender");
                    if("Male".equals(Gender)){
                        jRadioButtonMale.setSelected(true);
                        jRadioButtonFemale.setSelected(false);
                    }else if("Female".equals(Gender)){
                        jRadioButtonFemale.setSelected(true);
                        jRadioButtonMale.setSelected(false);
                    } 
                    
                    String BirthDate = res.getString("birthdate");
                    String JoinDate = res.getString("joindate");
                    String BloodGroup = res.getString("bloodgroup");
                    String Department = res.getString("department");
                    String Designation = res.getString("designation");
                    String Contact = res.getString("contact");
                    String Address = res.getString("address");
                    
                    byte[] imagedata=res.getBytes("image");
                   format=new ImageIcon(imagedata);
                   imageLabel.setIcon(format);//here image is jLabel variable name
                    
                    
                    jTextFieldID.setText(ID);
                    jTextFieldName.setText(Name);
                    jTextFieldBirth.setText(BirthDate);
                    jTextFieldJoin.setText(JoinDate);
                    jComboBoxBloodGroup.setSelectedItem(BloodGroup);
                    jComboBoxDepartment.setSelectedItem(Department);
                    jComboBoxDesignation.setSelectedItem(Designation);
                    jTextFieldConact.setText(Contact);
                    jTextAreaAddress.setText(Address);
                    
                    
                    test=0;
                    JOptionPane.showMessageDialog(this, "Weldone"+"\n"+"Searching Completed");
                    
                    break;
            
        }
           
            
          if(test==1){
                JOptionPane.showMessageDialog(this, "Error Occurred!!!"+"\n"+"\n"+"Data Not Found"+"\n"+"Please Try Again Later");
            }  
            
        }
        catch(SQLException e){
            
           
        }
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        
         int test = 1;
        
        try{
            String SearchID = jTextFieldSearch.getText();
            
            String sqlSearch="select * from employee_info where id = '"+SearchID+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                {
                    
                    String ID = res.getString("id");
                    String Name = res.getString("name");
                    String Gender = res.getString("gender");
                    if("Male".equals(Gender)){
                        jRadioButtonMale.setSelected(true);
                        jRadioButtonFemale.setSelected(false);
                    }else if("Female".equals(Gender)){
                        jRadioButtonFemale.setSelected(true);
                        jRadioButtonMale.setSelected(false);
                    } 
                    String BirthDate = res.getString("birthdate");
                    String JoinDate = res.getString("joindate");
                    String BloodGroup = res.getString("bloodgroup");
                    String Department = res.getString("department");
                    String Designation = res.getString("designation");
                    String Contact = res.getString("contact");
                    String Address = res.getString("address");
                    
                    //image search 
                    
                   byte[] imagedata=res.getBytes("image");
                   format=new ImageIcon(imagedata);
                   imageLabel.setIcon(format);//here image is jLabel variable name
                    
                    
                    jTextFieldID.setText(ID);
                    jTextFieldName.setText(Name);
                    //
                    jTextFieldBirth.setText(BirthDate);
                    jTextFieldJoin.setText(JoinDate);
                    jComboBoxBloodGroup.setSelectedItem(BloodGroup);
                    jComboBoxDepartment.setSelectedItem(Department);
                    jComboBoxDesignation.setSelectedItem(Designation);
                    jTextFieldConact.setText(Contact);
                    jTextAreaAddress.setText(Address);
                    
                    test=0;
                    JOptionPane.showMessageDialog(this, "Weldone"+"\n"+"Searching Completed");
                    break;
            
        }
            
            
          if(test==1){
                JOptionPane.showMessageDialog(this, "Error Occurred!!!"+"\n"+"\n"+"Data Not Found"+"\n"+"Please Try Again Later");
            }  
            
        }
        catch(SQLException e){
            
           
        }
        
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
       
        
        
        String UPDATEgender="";
        if(jRadioButtonMale.isSelected()){
                      UPDATEgender="Male";
                    }
        else if(jRadioButtonFemale.isSelected()){
                       UPDATEgender="Female";
                    } 
        
        try{
            
            
            
            
            String sqlQry="UPDATE employee_info SET name= ?,gender = ?, birthdate = ?,joindate = ?, bloodgroup = ?, department = ?, designation = ?, contact=?, address = ? , image = ? WHERE id = ?";
            
            prepStmt = con.prepareStatement(sqlQry);

                        
                        prepStmt.setString(1, jTextFieldName.getText());
                        prepStmt.setString(2, UPDATEgender);
                        prepStmt.setString(3, jTextFieldBirth.getText());
                        prepStmt.setString(4, jTextFieldJoin.getText());
                        prepStmt.setString(5, (String) jComboBoxBloodGroup.getSelectedItem());
                        prepStmt.setString(6, (String) jComboBoxDepartment.getSelectedItem());
                        prepStmt.setString(7, (String) jComboBoxDesignation.getSelectedItem());
                        prepStmt.setString(8, jTextFieldConact.getText());
                        prepStmt.setString(9, jTextAreaAddress.getText());
                        prepStmt.setBytes(10, person_image);
                        
                        prepStmt.setString(11, jTextFieldID.getText());
                       
                       int i= prepStmt.executeUpdate();
                       
                       if(i>0){
                           JOptionPane.showMessageDialog(this, "DATABAE UPDATED");
                       }
            
        }catch(SQLException e){
            
        }
        
        
        
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int msg=JOptionPane.YES_NO_OPTION;
        
        
       int result= JOptionPane.showConfirmDialog(this, "Are You Sure to Delete?","Warning",msg);
        if(result==0){
            System.out.println("Yes Option");
        try{
            String sqlQry="DELETE from employee_info WHERE id= ?";
            
             prepStmt = con.prepareStatement(sqlQry);
            
            prepStmt.setString(1, jTextFieldID.getText());
                       
                       int i= prepStmt.executeUpdate();
                       
                       if(i>0){
                           JOptionPane.showMessageDialog(this, "RECORD DELETED");
                       }
            
        }catch(SQLException | HeadlessException e)
        {
            
        }
        
        
        
        jTextFieldID.setText(null);
        jTextFieldName.setText(null);
        jRadioButtonMale.setSelected(false);
        jRadioButtonFemale.setSelected(false);
        jTextFieldBirth.setText(null);
        jTextFieldJoin.setText(null);
        jComboBoxBloodGroup.setSelectedItem("A+ (A Positive)");
         jComboBoxDepartment.setSelectedItem("Select");
        jComboBoxDesignation.setSelectedItem("Select");
        jTextFieldConact.setText(null);
        jTextAreaAddress.setText(null);
        jTextFieldSearch.setText(null);
        }else{
           System.out.println("No Option");
        }
       
        
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxSelectIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectIDActionPerformed
       
        
        
        
        try{
            
            
            String sqlSearch="select * from employee_info where id = '"+jComboBoxSelectID.getSelectedItem()+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                {
                    
                    String ID = res.getString("id");
                    String Name = res.getString("name");
                    String Gender = res.getString("gender");
                    if("Male".equals(Gender)){
                        jRadioButtonMale.setSelected(true);
                        jRadioButtonFemale.setSelected(false);
                    }else if("Female".equals(Gender)){
                        jRadioButtonFemale.setSelected(true);
                        jRadioButtonMale.setSelected(false);
                    } 
                    
                    byte[] imagedata=res.getBytes("image");
                   format=new ImageIcon(imagedata);
                   imageLabel.setIcon(format);//here image is jLabel variable name
                    
                    String BirthDate = res.getString("birthdate");
                    String JoinDate = res.getString("joindate");
                    String BloodGroup = res.getString("bloodgroup");
                    String Department = res.getString("department");
                    String Designation = res.getString("designation");
                    String Contact = res.getString("contact");
                    String Address = res.getString("address");
                    
                    
                    jTextFieldID.setText(ID);
                    jTextFieldName.setText(Name);
                    jTextFieldBirth.setText(BirthDate);
                    jTextFieldJoin.setText(JoinDate);
                    jComboBoxBloodGroup.setSelectedItem(BloodGroup);
                    jComboBoxDepartment.setSelectedItem(Department);
                    jComboBoxDesignation.setSelectedItem(Designation);
                    jTextFieldConact.setText(Contact);
                    jTextAreaAddress.setText(Address);
                    
                    
                    
            
        }
           
            
          
        }
        catch(SQLException e){
            
           
        }
        
        
    }//GEN-LAST:event_jComboBoxSelectIDActionPerformed

    private void jComboBoxDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDesignationActionPerformed

        try{
        String sqlSearch="select * from designatation_info where desig_name = '"+jComboBoxDesignation.getSelectedItem()+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                {
                    
                    String ID = res.getString("desig_id");
                    
                    
                    
                    jTextFieldCombodeptSearch.setText(ID);
                    
            
        }
           
            
          
        }
        catch(SQLException e){
            
           
        }
    }//GEN-LAST:event_jComboBoxDesignationActionPerformed

    private void jComboBoxDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartmentActionPerformed
        try{
        String sqlSearch="select * from department_info where dept_name = '"+jComboBoxDepartment.getSelectedItem()+"'";
            prepStmt = con.prepareStatement(sqlSearch);
            res=prepStmt.executeQuery();
            
            while(res.next())
                {
                    
                    String ID = res.getString("dept_id");
                    
                    
                    
                    jTextFielddeptsearch.setText(ID);
                    
            
        }
           
            
          
        }
        catch(SQLException e){
            
           
        }
    }//GEN-LAST:event_jComboBoxDepartmentActionPerformed

    private void jTextFielddeptsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFielddeptsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFielddeptsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // attach
        JFileChooser chooser = new JFileChooser();
        //chooser.showOpenDialog(null);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int pic = chooser.showOpenDialog(employee_info.this);
        
        
        if (pic == JFileChooser.APPROVE_OPTION) {
        File f = chooser.getSelectedFile();
        ImageIcon image = new ImageIcon(f.getAbsolutePath());
        Rectangle rect = imageLabel.getBounds();
        Image scaledimage = image.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
        image = new ImageIcon(scaledimage);
        imageLabel.setIcon(image);
        
        filename = f.getAbsolutePath();//declared filename variable
        jTextField1.setText(filename);//location is variable name of textfield with attach button
        
        }
        else{
            JOptionPane.showMessageDialog(null, "Cancelled by User");
        }
        try {
            File image = new File(filename);
        //FileInputStream fis=new FileInputStream(image);
            BufferedImage bufferedimage = ImageIO.read(image);
            BufferedImage thumbnail = Thumbnails.of(bufferedimage).size(200, 200).asBufferedImage();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(thumbnail, "jpeg", bos);
            
            InputStream is = new ByteArrayInputStream(bos.toByteArray());
           // ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = is.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
                System.out.println("Read " + readNum + " bytes");
            }
            person_image = bos.toByteArray();//declared variable person_image
        } catch (IOException e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        ///Auto Increment Emp_ID
        ///Automatic putdown emp_Id
        
        try{
            String sqlSrch = "Select COALESCE(MAX(id),0) AS ID from employee_info";
            prepStmt=con.prepareStatement(sqlSrch);
            res=prepStmt.executeQuery();
            while(res.next())
            {
               
                String id=res.getString("ID");
               int empid = Integer.parseInt(id)+1;
               String emp_id = Integer.toString(empid);
               jTextFieldID.setText(emp_id);
               
            }
           
        }catch(SQLException e)
        {
        }
        jTextFieldName.setText(null);
        jRadioButtonMale.setSelected(false);
        jRadioButtonFemale.setSelected(false);
        jTextFieldBirth.setText(null);
        jTextFieldJoin.setText(null);
        jComboBoxBloodGroup.setSelectedItem("A+ (A Positive)");
        jComboBoxDepartment.setSelectedItem("Select");
        jComboBoxDesignation.setSelectedItem("Select");
        jTextFieldConact.setText(null);
        jTextAreaAddress.setText(null);
        jTextFieldSearch.setText(null);
        jTextFieldCombodeptSearch.setText(null);
        jTextFielddeptsearch.setText(null);
        jComboBoxSelectID.setSelectedItem("Select ID");
        imageLabel.setIcon(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxBloodGroup;
    private javax.swing.JComboBox jComboBoxDepartment;
    private javax.swing.JComboBox jComboBoxDesignation;
    private javax.swing.JComboBox jComboBoxSelectID;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldBirth;
    private javax.swing.JTextField jTextFieldCombodeptSearch;
    private javax.swing.JTextField jTextFieldConact;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldJoin;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFielddeptsearch;
    // End of variables declaration//GEN-END:variables
}
