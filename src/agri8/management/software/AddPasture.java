package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddPasture extends javax.swing.JFrame {
    
    MySQLConnect myConnection;
  
    public AddPasture() {
        icon();
        initComponents();
        jPanel1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        myConnection = new MySQLConnect();
  
       
    }
    
    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
  
     String photopath = null;
    //javax.swing.ImageIcon to resize image
    
    public ImageIcon resizeImage(String photopath, byte[] photo) {
        
       ImageIcon myPhoto = null;
       if(photopath != null){
           myPhoto = new ImageIcon(photopath);
       } else {
           myPhoto = new ImageIcon(photo);
       }
       
       Image img = myPhoto.getImage();
       Image img1 = img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ph = new ImageIcon(img1);
       return ph;
               
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfArea = new javax.swing.JTextField();
        jcStatues = new javax.swing.JComboBox<>();
        tfCrop = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        jcType = new javax.swing.JComboBox<>();
        datein = new com.toedter.calendar.JDateChooser();
        dateout = new com.toedter.calendar.JDateChooser();
        tfRate = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonImage = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnAddHerd = new javax.swing.JButton();
        btnDeleteHerd = new javax.swing.JButton();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD NEW PASTURE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 19, 829, 26));

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logopng_200px.png"))); // NOI18N
        labelImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 270, 230));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Paddock Name: *");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Arable grazing area:*");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Crop / Veld Type:*");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Pasture Statues:*");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Herd Size:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Herd Group:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Stocking Rate:*");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        tfName.setBackground(new java.awt.Color(204, 204, 204));
        tfName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfName.setNextFocusableComponent(tfArea);
        getContentPane().add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 200, 25));

        tfArea.setBackground(new java.awt.Color(204, 204, 204));
        tfArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfArea.setNextFocusableComponent(jcStatues);
        tfArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfAreaKeyPressed(evt);
            }
        });
        getContentPane().add(tfArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 123, 25));

        jcStatues.setBackground(new java.awt.Color(204, 204, 204));
        jcStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Grazing", "Planted (growing stage)", "Resting (Planted)", "Resting (Backgrounding)" }));
        jcStatues.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jcStatues.setNextFocusableComponent(tfCrop);
        getContentPane().add(jcStatues, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 200, 25));

        tfCrop.setBackground(new java.awt.Color(204, 204, 204));
        tfCrop.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfCrop.setNextFocusableComponent(tfTotal);
        getContentPane().add(tfCrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 200, 25));

        tfTotal.setBackground(new java.awt.Color(204, 204, 204));
        tfTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfTotal.setNextFocusableComponent(jcType);
        tfTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTotalKeyPressed(evt);
            }
        });
        getContentPane().add(tfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 130, 25));

        jcType.setBackground(new java.awt.Color(204, 204, 204));
        jcType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Other" }));
        jcType.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jcType.setNextFocusableComponent(datein);
        jcType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcTypeFocusGained(evt);
            }
        });
        getContentPane().add(jcType, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 150, 25));

        datein.setBackground(new java.awt.Color(204, 204, 204));
        datein.setDateFormatString("yyyy-MM-dd");
        datein.setNextFocusableComponent(dateout);
        getContentPane().add(datein, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 130, 25));

        dateout.setBackground(new java.awt.Color(204, 204, 204));
        dateout.setDateFormatString("yyyy-MM-dd");
        dateout.setNextFocusableComponent(tfRate);
        getContentPane().add(dateout, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 130, 25));

        tfRate.setBackground(new java.awt.Color(204, 204, 204));
        tfRate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRateActionPerformed(evt);
            }
        });
        tfRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfRateKeyPressed(evt);
            }
        });
        getContentPane().add(tfRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 130, 25));

        buttonSave.setBackground(new java.awt.Color(204, 204, 204));
        buttonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 100, 30));

        buttonClose.setBackground(new java.awt.Color(204, 204, 204));
        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 100, 30));

        buttonClear.setBackground(new java.awt.Color(204, 204, 204));
        buttonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClear.setText("Clear");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });
        getContentPane().add(buttonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 100, 30));

        buttonImage.setBackground(new java.awt.Color(204, 204, 204));
        buttonImage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonImage.setText("Select Image");
        buttonImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageActionPerformed(evt);
            }
        });
        getContentPane().add(buttonImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 190, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Date-in:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Date-out:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Heads");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 50, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("LSU/Head");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Hectar's");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agri8 Assist - In this sections you can add new paddocks / pastures");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 850, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Add / Delete Herd Group:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        btnAddHerd.setForeground(new java.awt.Color(153, 153, 153));
        btnAddHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnAddHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHerdActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddHerd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        btnDeleteHerd.setForeground(new java.awt.Color(153, 153, 153));
        btnDeleteHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHerdActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteHerd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vertical-background.jpg"))); // NOI18N
        getContentPane().add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRateActionPerformed

    private void buttonImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageActionPerformed
          // Resize image and fetch image
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        // Fileter Files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        
        //If user clicks on save in Jfilechooser
        int results = file.showSaveDialog(null);
        if(results == JFileChooser.APPROVE_OPTION) {
        File selectedFile = file.getSelectedFile();
        String path = selectedFile.getAbsolutePath();
        labelImage.setIcon(resizeImage(path, null));
        photopath = path;
        
        } else if (results == JFileChooser.CANCEL_OPTION) {
            System.out.println("Photo not selected!");
        }
         
    }//GEN-LAST:event_buttonImageActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
       
         this.dispose();
         new ClassPasture().setVisible(true);
         
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        // TODO add your handling code here:
        
                this.dispose();
                new AddPasture().setVisible(true);
        
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // Save new paddock to database
        
        String name = tfName.getText();
        String grazingarea = tfArea.getText();
        String statues = (String) jcStatues.getSelectedItem();
        String crop = tfCrop.getText();
        //Integer herdsize = Integer.parseInt(tfTotal.getText());
        String type = (String) jcType.getSelectedItem();
        //Integer rate = Integer.parseInt(tfRate.getText().trim());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datesin1 = null;
        String datesout1 = null;
        
          try {
             datesin1 = sdf.format(datein.getDate());
             datesout1 = sdf.format(dateout.getDate());
               
         }catch (NullPointerException e) {
                        System.out.print("null pointer expection" + e);
         }
        
        //Validation to check if controls are empty or not
        if(name.trim().isEmpty() || grazingarea.trim().isEmpty() || crop.trim().isEmpty() || statues.trim().isEmpty()) {
            
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed, other fields can be left empty but may cause inaccurate data!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        } else {
            
            try {
                
                Connection conn = myConnection.getConnect();
                
                //Check Paddock already exists
                String checkName = "SELECT pname FROM tbl_paddock WHERE pname = '" + name + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                if(rs.next() == true) {// If paddock name has already been taken
                    JOptionPane.showMessageDialog(null, "Paddock/Pasture name: " + name + " already used!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new Paddock
                    String saveQuery = "INSERT INTO tbl_paddock(pname, psize, pstatues, ptype, pherdsize, pherdtype, datein, dateout, stockingrate, img)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                    
                    
                    
          
                    psm.setString(1, name);             //Paddock Name  1   
                    psm.setString(2, grazingarea);      //Grazing Area  2
                    psm.setString(3, statues);          //Pasture Stautes 3
                    psm.setString(4, crop);             //Crop / Veld 4
                    psm.setString(6, type);                  
                    psm.setString(7, datesin1);
                    psm.setString(8, datesout1);

                         // Accept Null excption from string to Integer
                     if ( tfTotal.getText().isEmpty()  ) {
                        psm.setNull(5, Types.INTEGER);
                      } else {
                        psm.setInt(5, Integer.parseInt(tfTotal.getText()));
                      }
                    
                    
                       // Accept Null excption from string to Integer
                     if ( tfRate.getText().isEmpty()  ) {
                      JOptionPane.showMessageDialog(null, "Please enter Stocking rate amount, example 13 Head of Cattle per Hectar's (LSU)!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                        psm.setNull(9, Types.INTEGER);
                      } else {
                        psm.setInt(9, Integer.parseInt(tfRate.getText()));
                      }
                    
                    try{
                        
                    if(photopath != null) {
                    InputStream img = new FileInputStream(new File(photopath));
                    psm.setBlob(10, img);
                    
                    } else {
                        psm.setNull(10, Types.BLOB);
                    }   
                        
                    } catch (NullPointerException e) {
                        System.out.print(" Null Pointer for Blob Caught: " + e + "");
                    }
                    
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "New Paddock Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                      this.dispose();
                      new AddPasture().setVisible(true);
                      
                        
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Paddock/Pasture ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
  
            } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddPasture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void tfAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAreaKeyPressed
          // Set JTextfield to accept only Integers of a certain Length
        // for contact number in registration page
        
        String number = tfArea.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<6) {
                tfArea.setEditable(true);
            } else {
                 tfArea.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfArea.setEditable(true);
            } else {
                tfArea.setEditable(false);
            }
        }
    }//GEN-LAST:event_tfAreaKeyPressed

    private void tfTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTotalKeyPressed
       // Set JTextfield to accept only Integers of a certain Length
        // for contact number in registration page
        
        String number = tfTotal.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                tfTotal.setEditable(true);
            } else {
                 tfTotal.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfTotal.setEditable(true);
            } else {
                tfTotal.setEditable(false);
            }
        }
    }//GEN-LAST:event_tfTotalKeyPressed

    private void tfRateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRateKeyPressed
            // Set JTextfield to accept only Integers of a certain Length
        // for contact number in registration page
        
        String number = tfRate.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                tfRate.setEditable(true);
            } else {
                 tfRate.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfRate.setEditable(true);
            } else {
                tfRate.setEditable(false);
            }
        }
    }//GEN-LAST:event_tfRateKeyPressed

    private void jcTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcTypeFocusGained
        // Fill Textfield when choosing herdgroup in JComboBox
       
         try {
                 
                Connection conn = myConnection.getConnect();
                
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                   
                     jcType.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_jcTypeFocusGained

    private void btnAddHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHerdActionPerformed
        // Add Herd Group

        //Prompt User
          
            boolean flag = false;    

         //Prompt User
         String herd = JOptionPane.showInputDialog(null, "Please enter Herd Group Name", "Input new Herd Group", JOptionPane.QUESTION_MESSAGE);
       
         if(herd == null) 
            {
             JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
             flag = false;
         
     } else {
             flag = true;
 
            try {
                  
                   
                Connection conn = myConnection.getConnect();

                //Save new Item / String
                String saveQuery = "INSERT INTO tbl_herdtype(herdtype)" +
                "values(?)";

                PreparedStatement psm = conn.prepareStatement(saveQuery);
               
                psm.setString(1, herd);
                psm.executeUpdate();

                JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new AddPasture().setVisible(true);
                conn.close();
                 
            } catch (SQLException | HeadlessException | NullPointerException e) {
               System.out.print("System Error: " + e);
        }
      }  
    }//GEN-LAST:event_btnAddHerdActionPerformed

    private void btnDeleteHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHerdActionPerformed
        // Remove Herd Group

        try {
            Connection conn = myConnection.getConnect();
            String herdtype = (String) jcType.getSelectedItem();

            if(herdtype.isEmpty()) {

                JOptionPane.showMessageDialog(null, " Please select Herd Type in ComboBox to delete!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);

            } else {

                String sqldelete = "DELETE FROM tbl_herdtype WHERE herdtype = '" + herdtype+ "'";

                PreparedStatement pst=conn.prepareStatement(sqldelete);
                pst.executeUpdate(sqldelete);
                JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                this.dispose();
                new AddPasture().setVisible(true);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnDeleteHerdActionPerformed

   
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
            java.util.logging.Logger.getLogger(AddPasture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPasture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPasture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPasture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPasture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel;
    private javax.swing.JButton btnAddHerd;
    private javax.swing.JButton btnDeleteHerd;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonImage;
    private javax.swing.JButton buttonSave;
    private com.toedter.calendar.JDateChooser datein;
    private com.toedter.calendar.JDateChooser dateout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcStatues;
    private javax.swing.JComboBox<String> jcType;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField tfArea;
    private javax.swing.JTextField tfCrop;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfRate;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
