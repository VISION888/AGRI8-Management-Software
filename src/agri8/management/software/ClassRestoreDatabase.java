
package agri8.management.software;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Conquela
 */
public class ClassRestoreDatabase extends javax.swing.JFrame {
  
        MySQLConnect myConnection;
        String path = null;
        String filename;
    
    public ClassRestoreDatabase() {
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
        jLabel2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRestore = new javax.swing.JButton();
        labelR = new javax.swing.JLabel();
        tfRestorePath = new javax.swing.JTextField();
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
        labelUser.setText("Restore Path:");
        jPanel1.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RESTORE DATABASE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 620, -1));

        btnStart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("Start Restore");
        btnStart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnStart.setContentAreaFilled(false);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 140, 40));

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
        jPanel1.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 106, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 90, 110));

        btnRestore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRestore.setForeground(new java.awt.Color(255, 255, 255));
        btnRestore.setText("Browser");
        btnRestore.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRestore.setContentAreaFilled(false);
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestore, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 120, 40));

        labelR.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelR.setForeground(new java.awt.Color(255, 255, 255));
        labelR.setText("jLabel3");
        jPanel1.add(labelR, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 170, -1));

        tfRestorePath.setEditable(false);
        tfRestorePath.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(tfRestorePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 350, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 770, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login_BG.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
     
       this.dispose();
       new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        
        String user = "root" ;
        String pass = "root";
        String[] restoreCmd = new String[]{"C:/Program Files/MySQL/MySQL Server 8.0/bin/mysql.exe", "--user=" + user, "--password=" + pass, "-e", "source " +path };
        
        Process process;
             
        try {
            
            process = Runtime.getRuntime().exec(restoreCmd);
            int proCom = process.waitFor();
            if (proCom == 0) {
                labelR.setText("Restored Successfully!");
            } else {
                   labelR.setText("Restore Failed!");
            }
            
        }catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
     
        }
        
       
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        
        
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);

        try {
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');
  
            tfRestorePath.setText(path);
        }catch(Exception e) {
               System.err.println(e.getMessage());
             
        }
        
        
    }//GEN-LAST:event_btnRestoreActionPerformed

    public static void main(String args[]) {
       
     
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassRestoreDatabase().setVisible(true);
            }
        });
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton buttonExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelR;
    private javax.swing.JLabel labelUser;
    private javax.swing.JTextField tfRestorePath;
    // End of variables declaration//GEN-END:variables
}
