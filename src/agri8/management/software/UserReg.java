
package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class UserReg extends javax.swing.JFrame {

      MySQLConnect myConnection;
    
    public UserReg() {
        icon();
        initComponents();
        jPanel1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
         myConnection = new MySQLConnect();
               
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jcGender = new javax.swing.JComboBox<>();
        tfName = new javax.swing.JTextField();
        tfSurename = new javax.swing.JTextField();
        jcCapacity = new javax.swing.JComboBox<>();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        tfCPassword = new javax.swing.JTextField();
        tfNumber = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        buttonReg = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        tfDate = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        u_id = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGRI8 User Registration");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(223, 164, 73));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("REGISTER NEW USER!");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("User ID:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Surename:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Capacity:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Username:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Password:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Confirm Password:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Contact Number:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setText("Email Address:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setText("Date-of-Birth:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setText("Gender:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jcGender.setSelectedIndex(-1);
        jcGender.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(jcGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 200, -1));

        tfName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 230, -1));

        tfSurename.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfSurename.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(tfSurename, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 230, -1));

        jcCapacity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Director / Owner", "Farm Manager", "Feed and Stock Manager", "Crop Manager", "Farm Hand" }));
        jcCapacity.setSelectedIndex(-1);
        jcCapacity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(jcCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 230, -1));

        tfUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfUsername.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 230, -1));

        tfPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 230, -1));

        tfCPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(tfCPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 230, -1));

        tfNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNumberKeyPressed(evt);
            }
        });
        jPanel2.add(tfNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 200, -1));

        tfEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEmailKeyReleased(evt);
            }
        });
        jPanel2.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 230, -1));

        buttonReg.setBackground(new java.awt.Color(139, 69, 19));
        buttonReg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonReg.setForeground(new java.awt.Color(223, 164, 73));
        buttonReg.setText("Register");
        buttonReg.setBorder(null);
        buttonReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegActionPerformed(evt);
            }
        });
        jPanel2.add(buttonReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 120, 40));

        buttonClose.setBackground(new java.awt.Color(139, 69, 19));
        buttonClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(223, 164, 73));
        buttonClose.setText("Close");
        buttonClose.setBorder(null);
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        jPanel2.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 120, 40));

        tfDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfDate.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(tfDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 200, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("ID Number:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        tfID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfIDKeyPressed(evt);
            }
        });
        jPanel2.add(tfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 230, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setText("First Name:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        u_id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(u_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 230, 25));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 460, 600));

        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Here to make it User Friendly!");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Here, you can");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("register and authorize");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("new users to");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("assist you in your goals!");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AGRI8 Assist,");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 340, 320));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logopng_200px.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 180, 170));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userreg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEmailKeyReleased
        // Set Email address to lower case
        
        int email = tfEmail.getCaretPosition();
                tfEmail.setText(tfEmail.getText().toLowerCase());
                tfEmail.setCaretPosition(email);
    }//GEN-LAST:event_tfEmailKeyReleased

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new Login().setVisible(true);
        
        
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegActionPerformed
        // TODO add your handling code here:
        String uid = u_id.getText().trim();
        String name = tfName.getText().trim();
        String surename = tfSurename.getText().trim();
        String capacity = (String) jcCapacity.getSelectedItem();
        String id = tfID.getText().trim();
        String email = tfEmail.getText().trim();
        String username = tfUsername.getText().trim();
        String password = tfPassword.getText().trim();
        String cpassword = tfCPassword.getText().trim();
        String number = tfNumber.getText().trim();
        Date date = tfDate.getDate();
        String gender = (String) jcGender.getSelectedItem();
       
        if(uid.isEmpty() || name.isEmpty() || surename.isEmpty() || capacity.isEmpty() || id.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() ||
           cpassword.isEmpty() || number.isEmpty() || gender.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Please Complete all Fields", "FIELDS ERROR", JOptionPane.ERROR_MESSAGE);
            tfName.requestFocus();
            
     
        } else if(!password.equals(cpassword)) {
            JOptionPane.showMessageDialog(null, "Password did not match!", "PASSWORD MISMATCH", JOptionPane.ERROR_MESSAGE);
            tfPassword.setText("");
            tfCPassword.setText(""); 
            tfPassword.setBackground(Color.GREEN);
            tfCPassword.setBackground(Color.GREEN);
            
        }else if(date == null) {       //if date of birth is not selected!
            
                JOptionPane.showMessageDialog(null, "Please select Date-of-Birth!", "Date Error!", JOptionPane.ERROR_MESSAGE);
                tfDate.requestFocus();
                tfDate.setBackground(Color.GREEN);
                
        } else {
            
            try {
            //Get Connection
              Connection conn = myConnection.getConnect();
            
            //Check User already exists
                String checkName = ("SELECT id_u, u_id FROM tbl_user_reg WHERE id_u = '" + uid + "' AND u_id = '" + id +"'");
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
               
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, " User: " + name + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
          
                    String saveQuery = "INSERT INTO tbl_user_reg (id_u, u_name, u_surename, u_job_cat, u_id, u_email, u_username, u_password, u_contact, u_dob, u_gender)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                    psm.setString(1, uid);
                    psm.setString(2, name);                
                    psm.setString(3, surename);
                    psm.setString(4, capacity);
                    psm.setString(5, id);
                    psm.setString(6, email);
                    psm.setString(7, username);
                    psm.setString(8, password);
                    psm.setString(9, number);
                    psm.setString(11, gender);
     
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(tfDate.getDate());
                   
                    psm.setString(10, date1);
                                    
                    int i = psm.executeUpdate();
                    if(i >= 1){
                       
                        JOptionPane.showMessageDialog(null, "User " + name + " " + surename + " successfully registered! ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
               
                        tfPassword.setBackground(Color.WHITE);
                        tfCPassword.setBackground(Color.WHITE);
                        tfDate.setBackground(Color.WHITE);
                        u_id.setText("");
                        tfName.setText("");
                        tfSurename.setText("");
                        jcCapacity.setSelectedIndex(-1);
                        tfID.setText("");
                        tfEmail.setText("");
                        tfUsername.setText("");
                        tfPassword.setText("");
                        tfCPassword.setText("");
                        tfNumber.setText("");
                        tfDate.setDate(null);
                        jcGender.setSelectedIndex(-1);
                            
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new User ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
  
            } catch (SQLException | HeadlessException | NullPointerException e) {
                        System.err.println(e.getMessage());
           
                       // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
                   
            }      
    }//GEN-LAST:event_buttonRegActionPerformed

    private void tfNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumberKeyPressed
        // Set JTextfield to accept only Integers of a certain Length
        // for contact number in registration page
        
        String number = tfNumber.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                tfNumber.setEditable(true);
            } else {
                 tfNumber.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfNumber.setEditable(true);
            } else {
                tfNumber.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_tfNumberKeyPressed

    private void tfIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIDKeyPressed
       
        
        // Set JTextfield to accept only Integers of a certain Length
        // for contact number in registration page
        
        String number = tfID.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<13) {
                tfID.setEditable(true);
            } else {
                 tfID.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfID.setEditable(true);
            } else {
                tfID.setEditable(false);
            }
        }
    }//GEN-LAST:event_tfIDKeyPressed

  
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
            java.util.logging.Logger.getLogger(UserReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcCapacity;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JTextField tfCPassword;
    private com.toedter.calendar.JDateChooser tfDate;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNumber;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfSurename;
    private javax.swing.JTextField tfUsername;
    private javax.swing.JTextField u_id;
    // End of variables declaration//GEN-END:variables
}
