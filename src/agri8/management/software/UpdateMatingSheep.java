package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UpdateMatingSheep extends javax.swing.JFrame {

    MySQLConnect myConnection;    
    
    public UpdateMatingSheep() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        TFID.requestFocus();
        
    }

     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
       private void herdGroup() {
        // Fill Textfield when choosing cattle ID in JComboBox
       
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s_tag_id, s_herdtype FROM tbl_sheep_info");
                 
                 while(rs.next()){
                   
                     JCHERD.addItem(rs.getString("s_herdtype"));
                     JCMATING.addItem(rs.getString("s_tag_id"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, "Herdgroup - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }
   
   private void Paddock() {
       
       // Populate JCombobox
        
         try {
                 
              Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     JCPADDOCK.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException  | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, " Paddock - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TFID = new javax.swing.JComboBox<>();
        buttonSearchRecord = new javax.swing.JButton();
        buttonUpdateRecord = new javax.swing.JButton();
        buttonCloseM = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tffour = new javax.swing.JTextField();
        tfthree = new javax.swing.JTextField();
        tftwo = new javax.swing.JTextField();
        tfone = new javax.swing.JTextField();
        JCHERD = new javax.swing.JComboBox<>();
        JCPADDOCK = new javax.swing.JComboBox<>();
        JCMATING = new javax.swing.JComboBox<>();
        JCBULLSIN = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tffive = new javax.swing.JTextField();
        tfsixs = new javax.swing.JTextField();
        tfseven = new javax.swing.JTextField();
        tfeight = new javax.swing.JTextField();
        tfnine = new javax.swing.JTextField();
        TFWEANING = new com.toedter.calendar.JDateChooser();
        TFNEXT = new com.toedter.calendar.JDateChooser();
        JCENDS = new javax.swing.JComboBox<>();
        JCSTART = new javax.swing.JComboBox<>();
        JCBULLSOUT = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("UPDATE SHEEP MATING RECORDS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("TAG ID:");

        TFID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        TFID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFIDFocusGained(evt);
            }
        });

        buttonSearchRecord.setBackground(new java.awt.Color(204, 204, 255));
        buttonSearchRecord.setForeground(new java.awt.Color(0, 0, 0));
        buttonSearchRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchRecord.setText("SEARCH");
        buttonSearchRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchRecordActionPerformed(evt);
            }
        });

        buttonUpdateRecord.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateRecord.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateRecord.setText("UPDATE");
        buttonUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateRecordActionPerformed(evt);
            }
        });

        buttonCloseM.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseM.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseM.setText("CLOSE");
        buttonCloseM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseMActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Herd Group:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Paddock:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Mating Sire:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Rams In:");

        tffour.setEditable(false);

        tfthree.setEditable(false);

        tftwo.setEditable(false);

        tfone.setEditable(false);

        JCHERD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCPADDOCK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCMATING.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCBULLSIN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Nov 15 - Feb 13 (Highveld Bulling)", "Dec 15 - Mar 16 (Lowveld Bulling)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));
        JCBULLSIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBULLSINActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Calving - Start:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Weaning Date:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Next Mating Date:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Calving - Ends:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Rams-out:");

        tffive.setEditable(false);

        tfsixs.setEditable(false);

        tfseven.setEditable(false);

        tfeight.setEditable(false);

        tfnine.setEditable(false);

        TFWEANING.setDateFormatString("yyyy-MM-dd");

        TFNEXT.setDateFormatString("yyyy-MM-dd");

        JCENDS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Sept - Oct - Nov (Highveld Calving)", "Oct- Nov - Dec (Lowveld Calving)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));

        JCSTART.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Sept - Oct - Nov (Highveld Calving)", "Oct - Nove - Dec (Lowveld Calving)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));
        JCSTART.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCSTARTActionPerformed(evt);
            }
        });

        JCBULLSOUT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Nov 15 - Feb 13 (Highveld Bulling)", "Dec 15 - Mar 16 (Lowveld Bulling)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tffour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addComponent(tfthree, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tftwo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tffive))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonUpdateRecord))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(184, 184, 184)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JCPADDOCK, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JCMATING, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JCBULLSIN, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                            .addComponent(JCBULLSOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JCHERD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel12))
                                                    .addComponent(jLabel13))
                                                .addGap(27, 27, 27))
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfeight, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfseven, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfsixs, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfnine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buttonCloseM, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCENDS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCSTART, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNEXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFWEANING, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonCloseM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tffour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tffive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfseven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfsixs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfeight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfnine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(JCSTART, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(JCENDS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(TFNEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(TFWEANING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JCHERD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCPADDOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCMATING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCBULLSIN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCBULLSOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1220, 420));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goatsbg.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSearchRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchRecordActionPerformed

        Connection conn = myConnection.getConnect();
        String searchID = (String)TFID.getSelectedItem();
      
     if(searchID.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            TFID.setBackground(Color.LIGHT_GRAY);
            
        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT sm_herdgroup, sm_paddock, sm_ram, sm_ramsin, sm_ramsout, sm_k_start, sm_l_ends, "
                        + "sm_nextmating, sm_weaningdate FROM tbl_mating_sheep WHERE sm_tag_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, searchID);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    TFID.setEnabled(false);
                    tfone.setText(rs.getString("sm_herdgroup"));                         
                    tftwo.setText(rs.getString("sm_paddock"));                           
                    tfthree.setText(rs.getString("sm_ram"));                        
                    tffour.setText(rs.getString("sm_ramsin"));                     
                    tffive.setText(rs.getString("sm_ramsout"));                       
                    tfsixs.setText(rs.getString("sm_k_start"));             
                    tfseven.setText(rs.getString("sm_l_ends"));                      
                    tfeight.setText(rs.getString("sm_nextmating"));
                    tfnine.setText(rs.getString("sm_weaningdate"));
                    herdGroup();
                    Paddock();
                    TFID.setBackground(Color.WHITE);
            

                } else {

                    JOptionPane.showMessageDialog(null, "ID not Found, Please try again!");
                    TFID.setSelectedItem("SELECT");
                 
                }

                conn.close();

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, "Save - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonSearchRecordActionPerformed

    private void buttonUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateRecordActionPerformed
        // Update Calf Records

        Connection conn = myConnection.getConnect();

        String searchID = (String)TFID.getSelectedItem();
        String TFONE = (String) JCHERD.getSelectedItem();
        String TFTWO = (String) JCPADDOCK.getSelectedItem();
        String TFTHREE = (String) JCMATING.getSelectedItem();
        String TFFOUR = (String) JCBULLSIN.getSelectedItem();
        String TFFIVE = (String) JCBULLSOUT.getSelectedItem();
        String TFSIX = (String) JCSTART.getSelectedItem();
        String TFSEVEN = (String) JCENDS.getSelectedItem();
     
        if(searchID.isEmpty()) {

            JOptionPane.showMessageDialog(null, " Please Enter ID to Update!", "ID Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            TFID.grabFocus();
            TFID.setBackground(Color.LIGHT_GRAY);
          } else if(TFONE.equals("SELECT") || TFTWO.equals("SELECT") || TFTHREE.equals("SELECT") || TFFOUR.equals("SELECT") || TFFIVE.equals("SELECT") ||
           TFSIX.equals("SELECT") || TFSEVEN.equals("SELECT"))  {
        
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        
        } else {

            try {

                String query = "UPDATE tbl_mating_sheep SET sm_herdgroup ='" + TFONE + "', sm_paddock= '" + TFTWO + "', sm_ram = '" + TFTHREE + "', sm_ramsin= '" 
                        + TFFOUR + "', sm_ramsout = '" + TFFIVE + "', sm_k_start = '" + TFSIX + "', sm_l_ends = '" + TFSEVEN + "', sm_nextmating = ?, sm_weaningdate = ?" + " WHERE sm_tag_id= '" + searchID + "'";

                PreparedStatement psm = conn.prepareStatement(query);

                        try{
                      // Accept Null excption from string to Integer
                     if ( TFNEXT.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(TFNEXT.getDate());
                          
                            psm.setString(1, Date1);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter Next Mating Date!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          psm.setNull(1, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
                
                      try{
                      // Accept Null excption from string to Integer
                     if ( TFWEANING.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(TFWEANING.getDate());
                          
                            psm.setString(2, Date2);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter Weaning Date!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          psm.setNull(2, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }

                int i = psm.executeUpdate();

                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + searchID + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new UpdateMatingSheep().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Update - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonUpdateRecordActionPerformed

    private void buttonCloseMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseMActionPerformed
        // Close frame
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonCloseMActionPerformed

    private void TFIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFIDFocusGained
       try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT sm_tag_id FROM tbl_mating_sheep");
                 
                 while(rs.next()){
                   
                     TFID.addItem(rs.getString("sm_tag_id"));
                 
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_TFIDFocusGained

    private void JCSTARTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCSTARTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCSTARTActionPerformed

    private void JCBULLSINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBULLSINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBULLSINActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateMatingSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateMatingSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateMatingSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateMatingSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateMatingSheep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBULLSIN;
    private javax.swing.JComboBox<String> JCBULLSOUT;
    private javax.swing.JComboBox<String> JCENDS;
    private javax.swing.JComboBox<String> JCHERD;
    private javax.swing.JComboBox<String> JCMATING;
    private javax.swing.JComboBox<String> JCPADDOCK;
    private javax.swing.JComboBox<String> JCSTART;
    private javax.swing.JComboBox<String> TFID;
    private com.toedter.calendar.JDateChooser TFNEXT;
    private com.toedter.calendar.JDateChooser TFWEANING;
    private javax.swing.JButton buttonCloseM;
    private javax.swing.JButton buttonSearchRecord;
    private javax.swing.JButton buttonUpdateRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfeight;
    private javax.swing.JTextField tffive;
    private javax.swing.JTextField tffour;
    private javax.swing.JTextField tfnine;
    private javax.swing.JTextField tfone;
    private javax.swing.JTextField tfseven;
    private javax.swing.JTextField tfsixs;
    private javax.swing.JTextField tfthree;
    private javax.swing.JTextField tftwo;
    // End of variables declaration//GEN-END:variables
}
