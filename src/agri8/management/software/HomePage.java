
package agri8.management.software;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class HomePage extends javax.swing.JFrame {
       
    public HomePage() {
        icon();
        initComponents();    
    }
    
    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonLivestock = new javax.swing.JButton();
        buttonInv = new javax.swing.JButton();
        buttonFinance = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonPaddock = new javax.swing.JButton();
        buttonReports1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLabel.setForeground(new java.awt.Color(204, 204, 204));
        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo Banner.png"))); // NOI18N
        getContentPane().add(imgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 400));

        jPanel1.setBackground(new java.awt.Color(139, 69, 19));

        buttonLivestock.setBackground(new java.awt.Color(46, 204, 113));
        buttonLivestock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonLivestock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonLivestock.png"))); // NOI18N
        buttonLivestock.setText("LIVESTOCK");
        buttonLivestock.setToolTipText("");
        buttonLivestock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonLivestock.setFocusable(false);
        buttonLivestock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonLivestock.setIconTextGap(2);
        buttonLivestock.setPreferredSize(new java.awt.Dimension(130, 130));
        buttonLivestock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonLivestock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLivestockActionPerformed(evt);
            }
        });

        buttonInv.setBackground(new java.awt.Color(223, 164, 73));
        buttonInv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonBarn.png"))); // NOI18N
        buttonInv.setText("INVENTORY");
        buttonInv.setToolTipText("");
        buttonInv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonInv.setFocusable(false);
        buttonInv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonInv.setIconTextGap(2);
        buttonInv.setMaximumSize(new java.awt.Dimension(130, 130));
        buttonInv.setMinimumSize(new java.awt.Dimension(130, 130));
        buttonInv.setPreferredSize(new java.awt.Dimension(130, 130));
        buttonInv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInvActionPerformed(evt);
            }
        });

        buttonFinance.setBackground(new java.awt.Color(46, 112, 56));
        buttonFinance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonFinance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N
        buttonFinance.setText("FINANCIAL");
        buttonFinance.setToolTipText("");
        buttonFinance.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonFinance.setFocusable(false);
        buttonFinance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonFinance.setIconTextGap(2);
        buttonFinance.setMaximumSize(new java.awt.Dimension(130, 130));
        buttonFinance.setMinimumSize(new java.awt.Dimension(130, 130));
        buttonFinance.setPreferredSize(new java.awt.Dimension(130, 130));
        buttonFinance.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonFinance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFinanceActionPerformed(evt);
            }
        });

        buttonExit.setBackground(new java.awt.Color(204, 204, 204));
        buttonExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonExit.png"))); // NOI18N
        buttonExit.setText("LOG-OUT");
        buttonExit.setToolTipText("");
        buttonExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonExit.setFocusable(false);
        buttonExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonExit.setIconTextGap(2);
        buttonExit.setMaximumSize(new java.awt.Dimension(130, 130));
        buttonExit.setMinimumSize(new java.awt.Dimension(130, 130));
        buttonExit.setPreferredSize(new java.awt.Dimension(130, 130));
        buttonExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonPaddock.setBackground(new java.awt.Color(26, 188, 156));
        buttonPaddock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPaddock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonPaddock.png"))); // NOI18N
        buttonPaddock.setText("PADDOCK");
        buttonPaddock.setToolTipText("");
        buttonPaddock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPaddock.setFocusable(false);
        buttonPaddock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPaddock.setIconTextGap(2);
        buttonPaddock.setMaximumSize(new java.awt.Dimension(130, 130));
        buttonPaddock.setMinimumSize(new java.awt.Dimension(130, 130));
        buttonPaddock.setPreferredSize(new java.awt.Dimension(130, 130));
        buttonPaddock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonPaddock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPaddockActionPerformed(evt);
            }
        });

        buttonReports1.setBackground(new java.awt.Color(223, 187, 251));
        buttonReports1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonReports1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonReport.png"))); // NOI18N
        buttonReports1.setText("REPORTS");
        buttonReports1.setToolTipText("");
        buttonReports1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonReports1.setFocusable(false);
        buttonReports1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonReports1.setIconTextGap(2);
        buttonReports1.setMaximumSize(new java.awt.Dimension(130, 130));
        buttonReports1.setMinimumSize(new java.awt.Dimension(130, 130));
        buttonReports1.setPreferredSize(new java.awt.Dimension(130, 130));
        buttonReports1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonReports1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReports1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGRI8 Assist: Here you can select one of the buttons to take you to the category that your heart desires, LOL!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(buttonLivestock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(buttonInv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(buttonFinance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(buttonPaddock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(buttonReports1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonPaddock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonFinance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonInv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonLivestock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonReports1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 1190, 290));

        jMenu1.setText("System");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem1.setText("Farm Info");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem2.setText("Back-Up");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem5.setText("Restore Database");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("User");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("User Authorization");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // Back Button
        
        this.dispose();
        new Login().setVisible(true);
        
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonPaddockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPaddockActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ClassPasture().setVisible(true);
        
    }//GEN-LAST:event_buttonPaddockActionPerformed

    private void buttonReports1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReports1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login_AuthoR().setVisible(true);
    }//GEN-LAST:event_buttonReports1ActionPerformed

    private void buttonLivestockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLivestockActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonLivestockActionPerformed

    private void buttonInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInvActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new ClassInventory().setVisible(true);
    }//GEN-LAST:event_buttonInvActionPerformed

    private void buttonFinanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFinanceActionPerformed
        // TODO add your handling code here:
          
        this.dispose();
        new Login_AuthoF().setVisible(true);
    }//GEN-LAST:event_buttonFinanceActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       this.dispose();
       new ClassFarmInfo().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
              int exit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "EXIT DIALOGUE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(exit == 0)System.exit(0);
  
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
        new Login_AuthoMenuItem().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
        new ClassBackUpSystem().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.dispose();
        new ClassRestoreDatabase().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    public static void main(String args[]) {
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonFinance;
    private javax.swing.JButton buttonInv;
    private javax.swing.JButton buttonLivestock;
    private javax.swing.JButton buttonPaddock;
    private javax.swing.JButton buttonReports1;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
