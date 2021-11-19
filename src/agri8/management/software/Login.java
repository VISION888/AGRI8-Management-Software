
package agri8.management.software;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Conquela
 */
public class Login extends javax.swing.JFrame {
  
        MySQLConnect myConnection;
    
    public Login() {
        myConnection = new MySQLConnect();
        icon();
        initComponents();
      
    }
        
    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUser = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tpPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGRI8 Login Page");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUser.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelUser.setForeground(new java.awt.Color(0, 0, 0));
        labelUser.setText("Username:");
        jPanel1.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 114, 25));

        labelPass.setBackground(new java.awt.Color(0, 0, 0));
        labelPass.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelPass.setForeground(new java.awt.Color(0, 0, 0));
        labelPass.setText("Password:");
        jPanel1.add(labelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        tfUser.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tfUser.setForeground(new java.awt.Color(0, 0, 0));
        tfUser.setOpaque(false);
        tfUser.setRequestFocusEnabled(false);
        tfUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfUserMouseClicked(evt);
            }
        });
        jPanel1.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 322, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AGRI 8 LOGIN PAGE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 450, -1));

        buttonLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Login");
        buttonLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonLogin.setBorderPainted(false);
        buttonLogin.setContentAreaFilled(false);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 98, 32));

        buttonExit.setBackground(new java.awt.Color(255, 0, 255));
        buttonExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit.setText("Exit");
        buttonExit.setBorder(null);
        buttonExit.setBorderPainted(false);
        buttonExit.setContentAreaFilled(false);
        buttonExit.setFocusable(false);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        jPanel1.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 106, -1));

        buttonRegister.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        buttonRegister.setForeground(new java.awt.Color(255, 255, 255));
        buttonRegister.setText("Register");
        buttonRegister.setBorder(null);
        buttonRegister.setBorderPainted(false);
        buttonRegister.setContentAreaFilled(false);
        buttonRegister.setFocusable(false);
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 94, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 90, 110));

        tpPass.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tpPass.setToolTipText("");
        tpPass.setOpaque(false);
        jPanel1.add(tpPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 320, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 570, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agri1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
     
        int exit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "EXIT DIALOGUE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(exit == 0)System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        
        String username = tfUser.getText();
        String password = String.valueOf(tpPass.getPassword());
        
        if(tfUser.getText().trim().isEmpty()|| password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter all Fields!", "USERNAME OR PASSWORD EMPTY", JOptionPane.ERROR_MESSAGE);
            tfUser.setText("");
            tpPass.setText("");
            tfUser.requestFocus();
        } else {

            try {
                   Connection conn = myConnection.getConnect();
                   
                    String sql = "SELECT u_username, u_password FROM tbl_user_reg WHERE u_username = ? and u_password = ?";
                    PreparedStatement psm = conn.prepareStatement(sql);

                    psm.setString(1, username);
                    psm.setString(2, password);

                    ResultSet rs = psm.executeQuery();
                    
                    String sql1 = "SELECT a_user, a_pass FROM tbl_admin_login WHERE a_user = ? and a_pass = ?";
                    PreparedStatement psm1 = conn.prepareStatement(sql1);

                    psm1.setString(1, username);
                    psm1.setString(2, password);

                    ResultSet rs1 = psm1.executeQuery();

                 if(rs.next()) {
                     JOptionPane.showMessageDialog(null, "WELCOME TO AGRI8 MANAGEMENT SOFTWARE");
                        this.dispose();
                        new HomePage().setVisible(true);

                 } else if(rs1.next()) {
                   
                     
                      JOptionPane.showMessageDialog(null, "WELCOME TO AGRI8 MANAGEMENT SOFTWARE");
                        this.dispose();
                        new HomePage().setVisible(true);

                 } else {
       
                    JOptionPane.showMessageDialog(null, "Username or Password incorrect / No User Registered!", "CANT LOGIN", JOptionPane.ERROR_MESSAGE);

                    tfUser.setText("");
                    tpPass.setText("");
                    tfUser.requestFocus();


                 }

                 conn.close();

               } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

               }
          
        }
  
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new Login_Autho().setVisible(true);
        
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void tfUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUserMouseClicked
        // If mouse Clicked then set Focus on JTextField Username
        
        tfUser.requestFocus();
    }//GEN-LAST:event_tfUserMouseClicked

    public static void main(String args[]) {
       
     
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelUser;
    private javax.swing.JTextField tfUser;
    private javax.swing.JPasswordField tpPass;
    // End of variables declaration//GEN-END:variables
}
