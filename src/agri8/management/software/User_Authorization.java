
package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class User_Authorization extends javax.swing.JFrame {
  
        MySQLConnect myConnection;
    
    public User_Authorization() {
        myConnection = new MySQLConnect();
        icon();
        initComponents();
        TableUser();
        jPanel2.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
      
    }
        
    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
    
    
           private void UserID() {
        
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT id_u FROM tbl_user_reg");
                 
                 while(rs.next()){
                     
                   userID.addItem(rs.getString("id_u"));
                    
                } 
                 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                userID.requestFocus(false);   
       
            }   
    }
           
           
           
      private void TableUser() {
         
           Connection conn = myConnection.getConnect();
      
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_user_reg ORDER BY id_u ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String uid = rs.getString("id_u");
              String name = rs.getString("u_name");
              String surname = rs.getString("u_surename");     
              String username = rs.getString("u_username");
              String contact = rs.getString("u_contact");
              String id_nr = rs.getString("u_id");
              String email = rs.getString("u_email");
              
              String dob = null;
              
             try {
             
               dob = String.valueOf(sdf.format(rs.getDate("u_dob")));
      
         }catch (NullPointerException e) {
                        System.out.print("Null pointer expection: " + e + "");
         }
              
      
           
              //String array to store data into jTable
              String tblDataP[] = {uid, name, surname, dob, username, contact, id_nr, email} ;
              DefaultTableModel tblModel = (DefaultTableModel)tableUsers.getModel();
              
              //Add string array data into table
              tblModel.addRow(tblDataP);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "User Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
           
           
     }      
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
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
        userID = new javax.swing.JComboBox<>();
        labelUser1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGRI8 Login Page");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Name", "Surname", "Date-of-Birth", "Username", "Contact Nr", "ID Number", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUsers);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 860, 220));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUser.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelUser.setForeground(new java.awt.Color(255, 255, 255));
        labelUser.setText("USER ID:");
        jPanel1.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 114, 30));

        labelPass.setBackground(new java.awt.Color(0, 0, 0));
        labelPass.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelPass.setForeground(new java.awt.Color(255, 255, 255));
        labelPass.setText("Password:");
        jPanel1.add(labelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        tfUser.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tfUser.setForeground(new java.awt.Color(255, 255, 255));
        tfUser.setOpaque(false);
        tfUser.setRequestFocusEnabled(false);
        tfUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfUserMouseClicked(evt);
            }
        });
        jPanel1.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 322, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AGRI 8 USER AUTHORIZATION");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 840, -1));

        buttonLogin.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Authorize");
        buttonLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonLogin.setBorderPainted(false);
        buttonLogin.setContentAreaFilled(false);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 160, 32));

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
        jPanel1.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 106, -1));

        buttonRegister.setFont(new java.awt.Font("Segoe UI", 3, 26)); // NOI18N
        buttonRegister.setForeground(new java.awt.Color(0, 0, 0));
        buttonRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonRegister.setText("Delete Users");
        buttonRegister.setBorder(null);
        buttonRegister.setBorderPainted(false);
        buttonRegister.setContentAreaFilled(false);
        buttonRegister.setFocusable(false);
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 190, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 100, 110));

        tpPass.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tpPass.setForeground(new java.awt.Color(255, 255, 255));
        tpPass.setToolTipText("");
        tpPass.setOpaque(false);
        jPanel1.add(tpPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 320, 30));

        userID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        userID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userIDFocusGained(evt);
            }
        });
        jPanel1.add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 320, 25));

        labelUser1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelUser1.setForeground(new java.awt.Color(255, 255, 255));
        labelUser1.setText("Username:");
        jPanel1.add(labelUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 114, 25));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Select  User ID, Insert a new Username and Password that will be used for Authorization sections, Click Authorize.");
        jPanel2.add(jLabel3);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 840, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 890, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/authorization_BG.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
     
       this.dispose();
       new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        
        String u_id = (String) userID.getSelectedItem();
        String username = tfUser.getText();
        String password = String.valueOf(tpPass.getPassword());
        
        if(tfUser.getText().trim().isEmpty()|| password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter all Fields!", "USERNAME OR PASSWORD EMPTY", JOptionPane.ERROR_MESSAGE);
            tfUser.setText("");
            tpPass.setText("");
            tfUser.requestFocus();
                        
  
        } else {
            
            try {
            //Get Connection
              Connection conn = myConnection.getConnect();
            
            //Check User already exists
                String checkName = ("SELECT a_id FROM tbl_admin_login WHERE a_id = '" + u_id +"'");
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
               
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, " User: already authorized!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
        
                    String saveQuery = "INSERT INTO tbl_admin_login (a_id, a_user, a_pass)" +
                            "values(?, ?, ?)";
                    //
                    psm = conn.prepareStatement(saveQuery);
                    psm.setString(1, u_id);                
                    psm.setString(2, username);
                    psm.setString(3, password);
            
                                    
                    int i = psm.executeUpdate();
                    if(i >= 1){
                       
                        JOptionPane.showMessageDialog(null, "User successfully Authorized! ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                     
                        tfUser.setText("");
                        tpPass.setText("");
                        userID.setSelectedItem("SELECT");
       
                            
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new User ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
  
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
           
                     // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
  
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        // TODO add your handling code here:
        
       // Delete Users
        
        Connection conn = myConnection.getConnect();
        String UID =  (String) userID.getSelectedItem();
        String USER = tfUser.getText().trim();
        
        if(UID.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, " Please select User ID and Username to Delete!", "SELECT USER ID!", JOptionPane.ERROR_MESSAGE);
            userID.grabFocus();
        
        } else { 
         
         
        try {
            
           String sql = "DELETE FROM tbl_user_reg WHERE id_u = ? ";
           String sql1 =  "DELETE FROM tbl_admin_login WHERE a_id = ? ";            
           
           PreparedStatement psm = conn.prepareStatement(sql);
           PreparedStatement psm1 = conn.prepareStatement(sql1);
           
           psm.setString(1,UID);
           psm1.setString(1,USER);  
           
            psm.execute();
            psm1.execute();
      
              JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.DEFAULT_OPTION);
          
      
            this.dispose();
            new HomePage().setVisible(true);
          
  
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);   
        }
      }
        
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void tfUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUserMouseClicked
        // If mouse Clicked then set Focus on JTextField Username
        
        tfUser.requestFocus();
    }//GEN-LAST:event_tfUserMouseClicked

    private void userIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userIDFocusGained
        UserID();
    }//GEN-LAST:event_userIDFocusGained

    public static void main(String args[]) {
       
     
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Authorization().setVisible(true);
            }
        });
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelUser1;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTextField tfUser;
    private javax.swing.JPasswordField tpPass;
    private javax.swing.JComboBox<String> userID;
    // End of variables declaration//GEN-END:variables
}
