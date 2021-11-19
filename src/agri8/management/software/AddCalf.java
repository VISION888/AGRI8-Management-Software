package agri8.management.software;

import com.mysql.cj.util.StringUtils;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class AddCalf extends javax.swing.JFrame {

    MySQLConnect myConnection;
  
    public AddCalf() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        HERDTYPE();
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
     private void HERDTYPE() {
        // Fill Textfield when choosing cattle ID in JComboBox
       
         try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c_herdtype FROM tbl_cattle_info");
                 
                 while(rs.next()){
                     
                     jcherdtype.addItem(rs.getString("c_herdtype"));
                } 
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }

       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        tftagid = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jcbreed = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jcgender = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jcstud = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jcPaddock = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jcherdtype = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        tfbirthweight = new javax.swing.JTextField();
        cdobdate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        tfWeanWeight = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfWeanDate = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jcSire = new javax.swing.JComboBox<>();
        jcDam = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jcBirthStatues = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jcHealthStatues = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jcHorned = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        buttonCSave = new javax.swing.JButton();
        buttonCloseAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Calf information");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 990, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Calf Information"));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setText("*Tag ID Nr:");

        tftagid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tftagid.setNextFocusableComponent(tfname);
        tftagid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftagidActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setText("Name:");

        tfname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfname.setNextFocusableComponent(jcbreed);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("*Breed:");

        jcbreed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrikaner", "Angus", "Ankole", "Beefmaster", "Bonsmara", "Boran", "Brahman", "Braunivieh", "Charolais", "Drakensberger", "Hereford", "Limousin", "Nguni", "Other", "Santa Gertrudis", "Shorthorn", "Simbra", "Simmentaler", "Susses", "Tuli", "Wagyu" }));
        jcbreed.setNextFocusableComponent(cdobdate);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setText("*Date-of-Birth:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setText("*Gender:");

        jcgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Dam (Female)", "Sire (Male)", "Other" }));
        jcgender.setNextFocusableComponent(tfbirthweight);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setText("*Stud / Com:");

        jcstud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Other" }));
        jcstud.setNextFocusableComponent(jcgender);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel30.setText("*Paddock:");

        jcPaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcPaddock.setNextFocusableComponent(jcherdtype);
        jcPaddock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcPaddockFocusGained(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setText("*Herd Group:");

        jcherdtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcherdtype.setNextFocusableComponent(tfWeanWeight);
        jcherdtype.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcherdtypeFocusGained(evt);
            }
        });
        jcherdtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcherdtypeActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setText("*Birth Weight:");

        tfbirthweight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfbirthweight.setNextFocusableComponent(jcPaddock);
        tfbirthweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfbirthweightKeyPressed(evt);
            }
        });

        cdobdate.setDateFormatString("yyyy-MM-dd");
        cdobdate.setNextFocusableComponent(jcstud);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Wean Weight:");

        tfWeanWeight.setNextFocusableComponent(tfWeanDate);
        tfWeanWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfWeanWeightKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("*Wean Date:");

        tfWeanDate.setNextFocusableComponent(jcSire);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel33.setText("*Calf Sire ID:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel42.setText("*Calf Dam ID:");

        jcSire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "UNKNOWN", "MULTI-SIRE" }));
        jcSire.setNextFocusableComponent(jcDam);
        jcSire.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcSireFocusGained(evt);
            }
        });
        jcSire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSireActionPerformed(evt);
            }
        });

        jcDam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "UNKNOWN" }));
        jcDam.setNextFocusableComponent(jcBirthStatues);
        jcDam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcDamFocusGained(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel37.setText("*Birth Statues:");

        jcBirthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Alive", "Dead (Born Dead)", "Dead (Calving Difficulty)", "Dead (Scavanger animal)", "Dead (Other)" }));
        jcBirthStatues.setNextFocusableComponent(jcHealthStatues);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel34.setText("*Health Statues:");

        jcHealthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Healthy (Above average)", "Healthy", "Poor Condition", "Sick", " " }));
        jcHealthStatues.setNextFocusableComponent(jcHorned);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel38.setText("*Horned/ Polled:");

        jcHorned.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Horned", "Polled", "Scurs" }));
        jcHorned.setNextFocusableComponent(buttonCSave);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AGRI8 Assist - All field names with a (*) are mandetory, Please complete all fields for accurate data and reports.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addGap(69, 69, 69))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcstud, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cdobdate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbreed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tftagid, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel32))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel31)
                        .addComponent(jLabel6)
                        .addComponent(jLabel30)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfbirthweight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcgender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcPaddock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcherdtype, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfWeanWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel33))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcSire, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfWeanDate, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel34)
                            .addComponent(jLabel42)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcDam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcBirthStatues, 0, 1, Short.MAX_VALUE)
                            .addComponent(jcHealthStatues, 0, 0, Short.MAX_VALUE)
                            .addComponent(jcHorned, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jLabel7))
                            .addComponent(tfWeanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tftagid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(jLabel33)
                                .addComponent(jcSire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26)
                                .addComponent(jLabel42)
                                .addComponent(jcDam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcbreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cdobdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel37)
                                .addComponent(jcBirthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcHealthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcstud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jcgender, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(tfbirthweight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jcPaddock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jcherdtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfWeanWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jcHorned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 950, 340));

        buttonCSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        buttonCSave.setText("SAVE");
        buttonCSave.setNextFocusableComponent(buttonCloseAdd);
        buttonCSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 100, 31));

        buttonCloseAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseAdd.setText("CLOSE");
        buttonCloseAdd.setFocusable(false);
        buttonCloseAdd.setNextFocusableComponent(tftagid);
        buttonCloseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseAddActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCloseAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 101, 31));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addCattle.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcherdtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcherdtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcherdtypeActionPerformed

    private void tftagidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftagidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftagidActionPerformed

    private void jcSireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcSireActionPerformed

    private void buttonCSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCSaveActionPerformed
         // Save new animale to database
       
         String idtag = tftagid.getText().trim();
         String cname = tfname.getText().trim();
         String cbreed = (String) jcbreed.getSelectedItem();
         Date cdob =  cdobdate.getDate();
         String cstud = (String) jcstud.getSelectedItem();
         String cgender = (String) jcgender.getSelectedItem();
         //Integer cbirthweight =  Integer.valueOf(tfbirthweight.getText());
         String cpaddock = (String) jcPaddock.getSelectedItem();
         String cherd = (String) jcherdtype.getSelectedItem();
         //Integer cweanweight = Integer.valueOf(tfWeanWeight.getText());
         Date weandate = tfWeanDate.getDate();
         String csire = (String) jcSire.getSelectedItem();
         String cdam = (String) jcDam.getSelectedItem();
         String cbirthstatues = (String) jcBirthStatues.getSelectedItem();
         String chealth = (String) jcHealthStatues.getSelectedItem();
         String chorn = (String) jcHorned.getSelectedItem();
    
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date1 = null;
         String date2 = null;
         
         try {
                
                   date1 = sdf.format(cdobdate.getDate());
                   date2 =  sdf.format(tfWeanDate.getDate());
                   
         }catch (NullPointerException e) {
                        System.out.print("null pointer expection" + e);
         }
                    
         
         
        //Validation to check if controls are empty or not
        if(idtag.isEmpty() || cbreed.isEmpty() || cbreed.equals("SELECT") || cgender.isEmpty() || cgender.equals("SELECT") || cstud.isEmpty() || cstud.equals("SELECT") || cpaddock.isEmpty() || cpaddock.equals("SELECT") ||
           cherd.isEmpty() || cherd.equals("SELECT") || tfbirthweight.toString().isEmpty() || csire.isEmpty()|| csire.equals("SELECT") || cdam.isEmpty() || cdam.equals("SELECT")|| cbirthstatues.isEmpty() || cbirthstatues.equals("SELECT") ||
           chealth.isEmpty() || chealth.equals("SELECT") || chorn.isEmpty() || chorn.equals("SELECT"))  {
        
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed, other fields can be left empty but may cause inaccurate data!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        } else if (weandate == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter current or expceted wean date in order to keep date accurate!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
    
        } else {
            
            try {
                
                Connection conn = myConnection.getConnect();
                
                //Check if calf ID already exists
                String checkName = "SELECT cc_tag_id FROM tbl_calf_info WHERE cc_tag_id = '" + tftagid + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If animal tag has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Calf ID: " + idtag + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new Animale
                    String saveQuery = "INSERT INTO tbl_calf_info(cc_tag_id, cc_name, cc_breed, cc_dob, cc_studcom, cc_gender, cc_birthweight, cc_paddock, cc_herdgroup,  "
                            + "cc_weanweight, cc_weandate, cc_sireID, cc_damID, cc_birthstatues, cc_healthstatues, cc_hornstatues)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                                      
                    psm.setString(1, idtag);                
                    psm.setString(2, cname);
                    psm.setString(3, cbreed);
                    psm.setString(5, cstud);
                    psm.setString(6, cgender);
                    psm.setString(8, cpaddock);
                    psm.setString(9, cherd);
                    psm.setString(12, csire);
                    psm.setString(13, cdam);
                    psm.setString(14, cbirthstatues);
                    psm.setString(15, chealth);
                    psm.setString(16, chorn);
                    psm.setString(4, date1);
                    psm.setString(11, date2);
                   

                       try {       
                  if ( tfbirthweight.getText().isEmpty() ) {
                        psm.setNull(7, Types.INTEGER);
                      } else {
                    psm.setInt(7, Integer.parseInt(tfbirthweight.getText()));
                      }
                   } catch (NullPointerException | NumberFormatException e)  {
                        
                    }
                     
                            
                // Accept Null excption from string to Integer
                 try {       
                  if ( tfWeanWeight.getText().isEmpty() ) {
                        psm.setNull(10, Types.INTEGER);
                      } else {
                    psm.setInt(10, Integer.parseInt(tfWeanWeight.getText()));
                      }
                   } catch (NullPointerException | NumberFormatException e)  {
                        
                    }
                  
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Animale Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                        tftagid.setText("");
                        tfname.setText("");
                        jcbreed.setSelectedIndex(-1);
                        jcgender.setSelectedIndex(-1);
                        jcstud.setSelectedIndex(-1);
                        jcPaddock.setSelectedIndex(-1);
                        jcherdtype.setSelectedIndex(-1);
                        tfbirthweight.setText("");
                        jcBirthStatues.setSelectedIndex(-1);
                        tfWeanWeight.setText("");
                        jcSire.setSelectedIndex(-1);
                        jcDam.setSelectedIndex(-1);
                        jcBirthStatues.setSelectedIndex(-1);
                        jcHealthStatues.setSelectedIndex(-1);
                        jcHorned.setSelectedIndex(-1);
                        cdobdate.setDate(null);
                        tfWeanDate.setDate(null);
                       
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Animale to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
  
            } catch (SQLException | HeadlessException e) {
                  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);  
            }
        }
        
    }//GEN-LAST:event_buttonCSaveActionPerformed

    private void buttonCloseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseAddActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new ClassLivestock().setVisible(true);
        
    }//GEN-LAST:event_buttonCloseAddActionPerformed

    private void jcSireFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcSireFocusGained
        // Sire ID
        
         try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c_tag_id FROM tbl_cattle_info");
                 
                 while(rs.next()){
                     
                     jcSire.addItem(rs.getString("c_tag_id"));
                    
                } 
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }  
    }//GEN-LAST:event_jcSireFocusGained

    private void jcDamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcDamFocusGained
        // Dam ID
        
         try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c_tag_id FROM tbl_cattle_info");
                 
                 while(rs.next()){
                     
                     jcDam.addItem(rs.getString("c_tag_id"));
                    
                } 
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_jcDamFocusGained

    private void jcPaddockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcPaddockFocusGained
        // Populate JCombobox
        
         try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     jcPaddock.addItem(rs.getString("pname"));
                    
                } 
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            } 
        
    }//GEN-LAST:event_jcPaddockFocusGained

    private void jcherdtypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcherdtypeFocusGained
      
        try {
                 
                Connection conn = myConnection.getConnect();
                
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                   
                     jcherdtype.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_jcherdtypeFocusGained

    private void tfbirthweightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfbirthweightKeyPressed
        
         String number = tfbirthweight.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<5) {
                tfbirthweight.setEditable(true);
            } else {
                 tfbirthweight.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfbirthweight.setEditable(true);
            } else {
                tfbirthweight.setEditable(false);
            }
        
        }  
    }//GEN-LAST:event_tfbirthweightKeyPressed

    private void tfWeanWeightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfWeanWeightKeyPressed
        
         String number = tfWeanWeight.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<5) {
                tfWeanWeight.setEditable(true);
            } else {
                 tfWeanWeight.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfWeanWeight.setEditable(true);
            } else {
                tfWeanWeight.setEditable(false);
            }
        
        }  
    }//GEN-LAST:event_tfWeanWeightKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCalf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCSave;
    private javax.swing.JButton buttonCloseAdd;
    private com.toedter.calendar.JDateChooser cdobdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcBirthStatues;
    private javax.swing.JComboBox<String> jcDam;
    private javax.swing.JComboBox<String> jcHealthStatues;
    private javax.swing.JComboBox<String> jcHorned;
    private javax.swing.JComboBox<String> jcPaddock;
    private javax.swing.JComboBox<String> jcSire;
    private javax.swing.JComboBox<String> jcbreed;
    private javax.swing.JComboBox<String> jcgender;
    private javax.swing.JComboBox<String> jcherdtype;
    private javax.swing.JComboBox<String> jcstud;
    private com.toedter.calendar.JDateChooser tfWeanDate;
    private javax.swing.JTextField tfWeanWeight;
    private javax.swing.JTextField tfbirthweight;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tftagid;
    // End of variables declaration//GEN-END:variables
}
