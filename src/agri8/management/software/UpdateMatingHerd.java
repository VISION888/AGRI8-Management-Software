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


public class UpdateMatingHerd extends javax.swing.JFrame {

    MySQLConnect myConnection;    
    
    public UpdateMatingHerd() {
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
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c_tag_id, c_herdtype FROM tbl_cattle_info");
                 
                 while(rs.next()){
                   
                     JCHERD.addItem(rs.getString("c_herdtype"));
                     JCMATING.addItem(rs.getString("c_tag_id"));
                    
                } 
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }
   
   private void Paddock() {
       
       // Populate JCombobox
        
         try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     JCPADDOCK.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
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
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("UPDATE MATING RECORDS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("TAG ID:");

        TFID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        TFID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFIDFocusGained(evt);
            }
        });

        buttonSearchRecord.setBackground(new java.awt.Color(204, 204, 255));
        buttonSearchRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchRecord.setText("SEARCH");
        buttonSearchRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchRecordActionPerformed(evt);
            }
        });

        buttonUpdateRecord.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateRecord.setText("UPDATE");
        buttonUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateRecordActionPerformed(evt);
            }
        });

        buttonCloseM.setBackground(new java.awt.Color(204, 204, 255));
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
        jLabel5.setText("Bulls In:");

        tffour.setEditable(false);

        tfthree.setEditable(false);

        tftwo.setEditable(false);

        tfone.setEditable(false);

        JCHERD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCPADDOCK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCMATING.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCBULLSIN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Nov 15 - Feb 13 (Highveld Bulling)", "Dec 15 - Mar 16 (Lowveld Bulling)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Calving - Start:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Weaning Date:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Next Mating Date:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Calving - Ends:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Bulls-out:");

        tffive.setEditable(false);
        tffive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffiveActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonUpdateRecord)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCloseM, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(28, 28, 28)
                                    .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(219, 219, 219))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(6, 6, 6)
                                            .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(JCMATING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel9))
                                            .addGap(25, 25, 25)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tffour, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                                .addComponent(tffive))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(JCBULLSIN, 0, 0, Short.MAX_VALUE)
                                                .addComponent(JCBULLSOUT, 0, 1, Short.MAX_VALUE))))
                                    .addGap(46, 46, 46)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JCPADDOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(6, 6, 6)
                                        .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCHERD, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel10))
                                    .addGap(39, 39, 39)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(40, 40, 40)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfnine, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(tfeight)
                            .addComponent(tfseven)
                            .addComponent(tfsixs))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCSTART, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCENDS, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFWEANING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JCHERD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(JCSTART, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfsixs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfseven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCENDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TFNEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfnine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFWEANING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCPADDOCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCMATING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(tffour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(JCBULLSIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tffive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBULLSOUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1030, 420));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/matingBG.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tffiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tffiveActionPerformed

    private void buttonSearchRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchRecordActionPerformed

        Connection conn = myConnection.getConnect();
        String searchID = (String)TFID.getSelectedItem();
      
     if(searchID.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            TFID.setBackground(Color.LIGHT_GRAY);
            
        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT m_herdgroup, m_paddock, m_sire, m_bullsin, m_bullsout, m_c_start, m_c_ends, "
                        + "m_nextmating, m_weaningdate FROM tbl_mating_groups WHERE m_tag_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, searchID);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {

                    tfone.setText(rs.getString("m_herdgroup"));                         
                    tftwo.setText(rs.getString("m_paddock"));                           
                    tfthree.setText(rs.getString("m_sire"));                        
                    tffour.setText(rs.getString("m_bullsin"));                     
                    tffive.setText(rs.getString("m_bullsout"));                       
                    tfsixs.setText(rs.getString("m_c_start"));             
                    tfseven.setText(rs.getString("m_c_ends"));                      
                    tfeight.setText(rs.getString("m_nextmating"));
                    tfnine.setText(rs.getString("m_weaningdate"));
                    herdGroup();
                    Paddock();
                    TFID.setBackground(Color.WHITE);
            

                } else {

                    JOptionPane.showMessageDialog(null, "ID not Found, Please try again!");
                    TFID.setSelectedItem("SELECT");
                 
                }

                conn.close();

            } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

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
          
 

        if(searchID.equals("SELECT")) {

            JOptionPane.showMessageDialog(null, " Please Enter ID to Update!", "ID / Name Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            TFID.grabFocus();
            TFID.setBackground(Color.LIGHT_GRAY);
          
          } else if(TFONE.equals("SELECT") || TFTWO.equals("SELECT") || TFTHREE.equals("SELECT") || TFFOUR.equals("SELECT") || TFFIVE.equals("SELECT") ||
           TFSIX.equals("SELECT") || TFSEVEN.equals("SELECT"))  {
        
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
   
        } else {

            try {

                String query = "UPDATE tbl_mating_groups SET " +
                "m_herdgroup ='" + TFONE + "', m_paddock= '" + TFTWO + "', m_sire = '" + TFTHREE + "', m_bullsin= '" + TFFOUR + "', m_bullsout = '"
                + TFFIVE + "', m_c_start = '" + TFSIX + "', m_c_ends = '" + TFSEVEN + "', m_nextmating = ?, m_weaningdate = ?" + " WHERE m_tag_id= '" + searchID + "'";

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
                    new UpdateMatingHerd().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
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
                ResultSet rs = stm.executeQuery("SELECT m_tag_id FROM tbl_mating_groups");
                 
                 while(rs.next()){
                   
                     TFID.addItem(rs.getString("m_tag_id"));
                 
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
             //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_TFIDFocusGained

    private void JCSTARTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCSTARTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCSTARTActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateMatingHerd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateMatingHerd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateMatingHerd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateMatingHerd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateMatingHerd().setVisible(true);
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
