package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class AddMating extends javax.swing.JFrame {

    MySQLConnect myConnection;
  
    public AddMating() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        populatePaddock();
        herdGroup();
    
    }
    
    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }

  private void herdGroup() {
        // Fill Textfield when choosing cattle ID in JComboBox
       
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype");
                 
                 while(rs.next()){
                   
                     jcHerdType.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
         //       JOptionPane.showMessageDialog(null, "Herdgroup - sSystem got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }
   
   private void populatePaddock() {
       
       // Populate JCombobox
        
         try {
                 
                 Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     jcPaddock.addItem(rs.getString("pname"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException  e) {
                System.err.println(e.getMessage());
          //      JOptionPane.showMessageDialog(null, "Paddock - system got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
   }
   
   
   private void addName(){
    
      String cattleID = (String) jcTagID.getSelectedItem();
        
         try {
                 
                 Connection conn = myConnection.getConnect();
                String sql = ("SELECT c_name FROM tbl_cattle_info WHERE c_tag_id = ?");
                
                PreparedStatement psm = conn.prepareStatement(sql);
                psm.setString(1, cattleID);
                ResultSet rs = psm.executeQuery();
                 
                if(rs.next()){
                    
                     jcName.setText(rs.getString("c_name"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
           //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                 
       
            }
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcPaddock = new javax.swing.JComboBox<>();
        jcTagID = new javax.swing.JComboBox<>();
        jcHerdType = new javax.swing.JComboBox<>();
        jcMatingSire = new javax.swing.JComboBox<>();
        jcMethod = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcStudCom = new javax.swing.JComboBox<>();
        tfWeaningDate = new com.toedter.calendar.JDateChooser();
        jcEnds = new javax.swing.JComboBox<>();
        jcStart = new javax.swing.JComboBox<>();
        jcBullsin = new javax.swing.JComboBox<>();
        jcBullsout = new javax.swing.JComboBox<>();
        buttonSaveMating = new javax.swing.JButton();
        buttonCloseMating = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfNextMating = new com.toedter.calendar.JDateChooser();
        jcName = new javax.swing.JTextField();
        buttonCloseMating1 = new javax.swing.JButton();
        labelHeading = new javax.swing.JLabel();
        labelBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Tag ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Paddock:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Herd Group:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Mating Sire:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Method:");

        jcPaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        jcTagID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcTagID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcTagIDFocusGained(evt);
            }
        });
        jcTagID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTagIDActionPerformed(evt);
            }
        });

        jcHerdType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        jcMatingSire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Multi-sire (1 Sire - 30 / 50 Cows)" }));
        jcMatingSire.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcMatingSireFocusGained(evt);
            }
        });

        jcMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Artificial Insemination", "Embryo Transfer", "Natural" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Bulls-in:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Bulls-out:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Calving - Start:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Stud / Com:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Calving - Ends:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Weaning Date:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Next Mating Date:");

        jcStudCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Sire Commercial Dam)", "Stud / Com (Stud Dam, Commercial Sire)" }));

        tfWeaningDate.setDateFormatString("yyyy-MM-dd");

        jcEnds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Sept - Oct - Nov (Highveld Calving)", "Oct- Nov - Dec (Lowveld Calving)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));

        jcStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Sept - Oct - Nov (Highveld Calving)", "Oct - Nove - Dec (Lowveld Calving)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));

        jcBullsin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Nov 15 - Feb 13 (Highveld Bulling)", "Dec 15 - Mar 16 (Lowveld Bulling)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));

        jcBullsout.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Nov 15 - Feb 13 (Highveld Bulling)", "Dec 15 - Mar 16 (Lowveld Bulling)", "January", "February", "March", "April", "May", "June", "July", "August", "Septebmer", "October", "November", "December" }));

        buttonSaveMating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        buttonSaveMating.setText("SAVE");
        buttonSaveMating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveMatingActionPerformed(evt);
            }
        });

        buttonCloseMating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonCloseMating.setText("CLOSE");
        buttonCloseMating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseMatingActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AGRI8 Assist - Here the farmer adds Individual records of each mating with every Dam / Heifers");

        tfNextMating.setDateFormatString("yyyy-MM-dd");

        jcName.setEditable(false);

        buttonCloseMating1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear16.png"))); // NOI18N
        buttonCloseMating1.setText("CLEAR");
        buttonCloseMating1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseMating1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcHerdType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcStudCom, 0, 1, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcPaddock, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcName)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcTagID, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcMatingSire, 0, 1, Short.MAX_VALUE)
                                    .addComponent(jcMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcEnds, 0, 1, Short.MAX_VALUE)
                                    .addComponent(tfWeaningDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNextMating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcBullsin, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcBullsout, 0, 1, Short.MAX_VALUE)
                                    .addComponent(jcStart, 0, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonSaveMating, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(buttonCloseMating1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonCloseMating, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcTagID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jcPaddock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jcStudCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcHerdType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcMatingSire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcBullsin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jcBullsout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcEnds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(tfNextMating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfWeaningDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jcMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonSaveMating, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCloseMating, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(buttonCloseMating1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))))
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 750, 390));

        labelHeading.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelHeading.setForeground(new java.awt.Color(0, 0, 0));
        labelHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeading.setText("Add Mating Information");
        getContentPane().add(labelHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 50));

        labelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addCattle.jpg"))); // NOI18N
        getContentPane().add(labelBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseMatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseMatingActionPerformed
        // Close Mating Frame
        
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonCloseMatingActionPerformed

    private void buttonSaveMatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveMatingActionPerformed
        // Save new mating record to database
       
        Connection conn = myConnection.getConnect();
        
         String mid = (String) jcTagID.getSelectedItem();
         String mname = jcName.getText().trim();
         String mpaddock = (String) jcPaddock.getSelectedItem();
         String mstud = (String) jcStudCom.getSelectedItem();
         String  mherd = (String) jcHerdType.getSelectedItem();
         String  msire= (String) jcMatingSire.getSelectedItem();
         String  mmethod= (String) jcMethod.getSelectedItem();
         String  mbullsin= (String) jcBullsin.getSelectedItem();
         String  mbullsout = (String) jcBullsout.getSelectedItem();
         String  mcstarts = (String) jcStart.getSelectedItem();
         String  mcends = (String) jcEnds.getSelectedItem();
         Date mnextm =  tfNextMating.getDate();
         Date mweandate =  tfWeaningDate.getDate();
         
        //Validation to check if controls are empty or not
        if(mid.equals("SELECT") || mpaddock.equals("SELECT")  || mstud.equals("SELECT")  || mherd.equals("SELECT") || msire.equals("SELECT")  ||
           mmethod.equals("SELECT")  || mbullsin.equals("SELECT")  || mbullsout.equals("SELECT")  || mcstarts.equals("SELECT")  || mcends.equals("SELECT") )  {
        
           JOptionPane.showMessageDialog(null, "All fields must be completed!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        } else if (mnextm == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter Next Mating Date!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        }else if (mweandate == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter Weaning Date!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        }  else {
            try {
                
                
                
                //Check if mating record ID already exists
                String checkName = "SELECT m_tag_id FROM tbl_mating_groups WHERE m_tag_id = '" + mid + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If animal tag has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Cow mating record: " + mid + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new record
                    String saveQuery = "INSERT INTO tbl_mating_groups(m_tag_id, m_name, m_herdgroup, m_paddock, m_stud , m_sire, m_method,   "
                            + "m_bullsin, m_bullsout, m_c_start, m_c_ends, m_nextmating, m_weaningdate)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                                      
                    psm.setString(1, mid);                
                    psm.setString(2, mname);
                    psm.setString(3, mherd);
                    psm.setString(4, mpaddock);
                    psm.setString(5, mstud);
                    psm.setString(6, msire);
                    psm.setString(7, mmethod);
                    psm.setString(8, mbullsin);
                    psm.setString(9, mbullsout);
                    psm.setString(10, mcstarts);
                    psm.setString(11, mcends);
                    
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(tfNextMating.getDate());
                    String date2 = sdf.format(tfWeaningDate.getDate());
                  
                    psm.setString(12, date1);
                    psm.setString(13, date2);
                   
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Mating record added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        
                        this.dispose();
                        new AddMating().setVisible(true);
                        
                       
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Mating record!", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
            
  
            } catch (SQLException | HeadlessException | NullPointerException  e) {
                  System.err.println(e.getMessage());
                  //JOptionPane.showMessageDialog(null, "Save Mating - system got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }
            
        }
    }//GEN-LAST:event_buttonSaveMatingActionPerformed

    private void jcTagIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcTagIDFocusGained

        Connection conn = myConnection.getConnect();
      
        try {

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT c_tag_id FROM tbl_cattle_info");
        
        
        while(rs.next()){

            jcTagID.addItem(rs.getString("c_tag_id"));
            
            }
        
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jcTagIDFocusGained

    private void jcTagIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTagIDActionPerformed
       
        addName();
    }//GEN-LAST:event_jcTagIDActionPerformed

    private void jcMatingSireFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcMatingSireFocusGained
         Connection conn = myConnection.getConnect();
      
        try {

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT c_tag_id FROM tbl_cattle_info");
        
        
        while(rs.next()){

            jcMatingSire.addItem(rs.getString("c_tag_id"));
            
            }
        
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jcMatingSireFocusGained

    private void buttonCloseMating1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseMating1ActionPerformed
            this.dispose();
            new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonCloseMating1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddMating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMating().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCloseMating;
    private javax.swing.JButton buttonCloseMating1;
    private javax.swing.JButton buttonSaveMating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JComboBox<String> jcBullsin;
    private javax.swing.JComboBox<String> jcBullsout;
    private javax.swing.JComboBox<String> jcEnds;
    private javax.swing.JComboBox<String> jcHerdType;
    private javax.swing.JComboBox<String> jcMatingSire;
    private javax.swing.JComboBox<String> jcMethod;
    private javax.swing.JTextField jcName;
    private javax.swing.JComboBox<String> jcPaddock;
    private javax.swing.JComboBox<String> jcStart;
    private javax.swing.JComboBox<String> jcStudCom;
    private javax.swing.JComboBox<String> jcTagID;
    private javax.swing.JLabel labelBg;
    private javax.swing.JLabel labelHeading;
    private com.toedter.calendar.JDateChooser tfNextMating;
    private com.toedter.calendar.JDateChooser tfWeaningDate;
    // End of variables declaration//GEN-END:variables
}
