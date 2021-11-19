
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
public class ClassBackUpSystem extends javax.swing.JFrame {
  
        MySQLConnect myConnection;
        String path = null;
        String filename;
    
    public ClassBackUpSystem() {
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
        tfbackup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBackUpStart = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnBackUpBrowser1 = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
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
        labelUser.setText("Back-up Path:");
        jPanel1.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 25));

        tfbackup.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tfbackup.setForeground(new java.awt.Color(0, 0, 0));
        tfbackup.setOpaque(false);
        tfbackup.setRequestFocusEnabled(false);
        tfbackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfbackupMouseClicked(evt);
            }
        });
        jPanel1.add(tfbackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 360, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BACK-UP AND RESTORE DATABASE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 620, -1));

        btnBackUpStart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBackUpStart.setForeground(new java.awt.Color(255, 255, 255));
        btnBackUpStart.setText("Start Back-up");
        btnBackUpStart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBackUpStart.setContentAreaFilled(false);
        btnBackUpStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackUpStartActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackUpStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 140, 40));

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
        jPanel1.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 106, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 90, 110));

        btnBackUpBrowser1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBackUpBrowser1.setForeground(new java.awt.Color(255, 255, 255));
        btnBackUpBrowser1.setText("Browser");
        btnBackUpBrowser1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBackUpBrowser1.setContentAreaFilled(false);
        btnBackUpBrowser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackUpBrowser1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackUpBrowser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 120, 40));

        label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 320, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 770, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login_BG.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
     
       this.dispose();
       new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void btnBackUpStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackUpStartActionPerformed
        
           Process p = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec("C:/Program Files/MySQL/MySQL Server 8.0/bin/mysqldump.exe -uroot -proot --add-drop-database -B agri8_database -r" +path);
            
            int processComplete = p.waitFor();
            if(processComplete == 0) {
                label1.setText("Backup Created Successfully");
            }else{
                  label1.setText("Backup Creation Failed");
            }
            
        }catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
     
        }
        
       
    }//GEN-LAST:event_btnBackUpStartActionPerformed

    private void tfbackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfbackupMouseClicked
   
    }//GEN-LAST:event_tfbackupMouseClicked

    private void btnBackUpBrowser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackUpBrowser1ActionPerformed
        
        
         JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try {
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');
            path = path + "_" + date + ".sql";
            tfbackup.setText(path);
        }catch(Exception e) {
               System.err.println(e.getMessage());
             
        }
        
        
    }//GEN-LAST:event_btnBackUpBrowser1ActionPerformed

    public static void main(String args[]) {
       
     
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassBackUpSystem().setVisible(true);
            }
        });
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackUpBrowser1;
    private javax.swing.JButton btnBackUpStart;
    private javax.swing.JButton buttonExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JTextField tfbackup;
    // End of variables declaration//GEN-END:variables
}
