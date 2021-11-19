
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
public class Login_Autho extends javax.swing.JFrame {
  
        MySQLConnect myConnection;
    
    public Login_Autho() {
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
        labelUser.setForeground(new java.awt.Color(255, 255, 255));
        labelUser.setText("Username:");
        jPanel1.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 114, 25));

        labelPass.setBackground(new java.awt.Color(0, 0, 0));
        labelPass.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelPass.setForeground(new java.awt.Color(255, 255, 255));
        labelPass.setText("Password:");
        jPanel1.add(labelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        tfUser.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tfUser.setForeground(new java.awt.Color(255, 255, 255));
        tfUser.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tfUser.setOpaque(false);
        tfUser.setRequestFocusEnabled(false);
        tfUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfUserMouseClicked(evt);
            }
        });
        jPanel1.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 360, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AUTHORIZATION REQUIRED");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 490, -1));

        buttonLogin.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
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
        jPanel1.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 120, 50));

        buttonExit.setBackground(new java.awt.Color(255, 0, 255));
        buttonExit.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit.setText("Close");
        buttonExit.setBorder(null);
        buttonExit.setBorderPainted(false);
        buttonExit.setContentAreaFilled(false);
        buttonExit.setFocusable(false);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        jPanel1.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 106, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 90, 110));

        tpPass.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tpPass.setForeground(new java.awt.Color(255, 255, 255));
        tpPass.setToolTipText("");
        tpPass.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tpPass.setOpaque(false);
        jPanel1.add(tpPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 360, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 630, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login_BG.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
     
       this.dispose();
       new Login().setVisible(true);
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
                   
                    String sql = "SELECT a_user, a_pass FROM tbl_admin_login WHERE a_user= ? and a_pass = ?";
                    PreparedStatement psm = conn.prepareStatement(sql);

                    psm.setString(1, username);
                    psm.setString(2, password);

                    ResultSet rs = psm.executeQuery();

                 if(rs.next()) {
                  
                        this.dispose();
                        new UserReg().setVisible(true);

                 } else {
                     
                    JOptionPane.showMessageDialog(null, "INFORMATION INCORRECT, AUTHORIZATION NOT GRANTED", "ACCESS DENIED", JOptionPane.ERROR_MESSAGE);

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

    private void tfUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUserMouseClicked
        // If mouse Clicked then set Focus on JTextField Username
        
        tfUser.requestFocus();
    }//GEN-LAST:event_tfUserMouseClicked

    public static void main(String args[]) {
       
     
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Autho().setVisible(true);
            }
        });
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonLogin;
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
