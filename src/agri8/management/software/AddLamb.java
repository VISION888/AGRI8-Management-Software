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


public class AddLamb extends javax.swing.JFrame {

    MySQLConnect myConnection;
  
    public AddLamb() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        HERDTYPE();
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
     private void HERDTYPE() {
           try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     jcherdtype.addItem(rs.getString("herdtype"));
                    
                } 
                 conn.close();
                 
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Herd Group System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
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
        jcRam = new javax.swing.JComboBox<>();
        jcEwe = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jcBirthStatues = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jcHealthStatues = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jcHorned = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        buttonCSave = new javax.swing.JButton();
        buttonCloseKid = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Lamb Information and Records");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1110, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Calf Information"));

        jLabel24.setBackground(new java.awt.Color(255, 204, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setText("*Tag ID Nr:");

        tftagid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tftagid.setNextFocusableComponent(tfname);
        tftagid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftagidActionPerformed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(255, 204, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setText("Name:");

        tfname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfname.setNextFocusableComponent(jcbreed);

        jLabel26.setBackground(new java.awt.Color(255, 204, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("*Breed:");

        jcbreed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrino", "Black-head Persian", "Corriedale", "Dohne Merino", "Dormer", "Dorper Sheep", "Dorset Horn", "Hampshire Down", "ile de France", "Karakul", "Meatmaster", "SA Mutton Merino", "SA Wool Merino", "Suffolk", "Vandor", "Van Rooyen", "Witlshire" }));
        jcbreed.setNextFocusableComponent(cdobdate);

        jLabel27.setBackground(new java.awt.Color(255, 204, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setText("*Date-of-Birth:");

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setText("*Gender:");

        jcgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Ewe (Female)", "Ram (Male)", "Other" }));
        jcgender.setNextFocusableComponent(tfbirthweight);

        jLabel29.setBackground(new java.awt.Color(255, 204, 255));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setText("*Stud / Com:");

        jcstud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Commercial Ewe)", "Stud / Com (Stud Ewe, Commercial Ram)" }));
        jcstud.setNextFocusableComponent(jcgender);

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel30.setText("*Paddock:");

        jcPaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcPaddock.setNextFocusableComponent(jcherdtype);
        jcPaddock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcPaddockFocusGained(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setText("*Herd Group:");

        jcherdtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcherdtype.setNextFocusableComponent(tfWeanWeight);

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setText("Birth Weight:");

        tfbirthweight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfbirthweight.setNextFocusableComponent(jcPaddock);
        tfbirthweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfbirthweightKeyPressed(evt);
            }
        });

        cdobdate.setDateFormatString("yyyy-MM-dd");
        cdobdate.setNextFocusableComponent(jcstud);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Wean Weight:");

        tfWeanWeight.setNextFocusableComponent(tfWeanDate);
        tfWeanWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfWeanWeightKeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("*Wean Date:");

        tfWeanDate.setNextFocusableComponent(jcRam);

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel33.setText("*Lamb Ram ID:");

        jLabel42.setBackground(new java.awt.Color(0, 0, 0));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel42.setText("*Lamb Ewe ID:");

        jcRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "UNKNOWN", "MULTI-SIRE" }));
        jcRam.setNextFocusableComponent(jcEwe);
        jcRam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcRamFocusGained(evt);
            }
        });
        jcRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcRamActionPerformed(evt);
            }
        });

        jcEwe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "UNKNOWN" }));
        jcEwe.setNextFocusableComponent(jcBirthStatues);
        jcEwe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcEweFocusGained(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel37.setText("*Birth Statues:");

        jcBirthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Alive", "Dead (Born Dead)", "Dead (Calving Difficulty)", "Dead (Scavanger animal)", "Dead (Other)" }));
        jcBirthStatues.setNextFocusableComponent(jcHealthStatues);

        jLabel34.setBackground(new java.awt.Color(0, 0, 0));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel34.setText("*Health Statues:");

        jcHealthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Healthy (Above average)", "Healthy", "Poor Condition", "Sick", " " }));
        jcHealthStatues.setNextFocusableComponent(jcHorned);

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
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
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel24))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tftagid)
                            .addComponent(jcbreed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cdobdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcstud, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel32)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcherdtype, 0, 168, Short.MAX_VALUE)
                    .addComponent(tfWeanWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jcPaddock, 0, 168, Short.MAX_VALUE)
                    .addComponent(jcgender, 0, 168, Short.MAX_VALUE)
                    .addComponent(tfbirthweight, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel33))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfWeanDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcRam, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel34)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jcEwe, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcHealthStatues, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcHorned, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jcBirthStatues, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(tftagid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(tfname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jcbreed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cdobdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcstud, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(tfWeanDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(jcRam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42)
                                    .addComponent(jcEwe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel37)
                                    .addComponent(jcBirthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcHealthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jcgender, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(tfbirthweight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcPaddock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(jcherdtype, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfWeanWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jcHorned, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jLabel3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1080, 340));

        buttonCSave.setBackground(new java.awt.Color(255, 204, 255));
        buttonCSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonCSave.setText("SAVE");
        buttonCSave.setNextFocusableComponent(buttonCloseKid);
        buttonCSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 100, 31));

        buttonCloseKid.setBackground(new java.awt.Color(255, 204, 255));
        buttonCloseKid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseKid.setText("CLOSE");
        buttonCloseKid.setFocusable(false);
        buttonCloseKid.setNextFocusableComponent(tftagid);
        buttonCloseKid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseKidActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCloseKid, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 101, 31));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgsheep.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tftagidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftagidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftagidActionPerformed

    private void buttonCSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCSaveActionPerformed
         // Save new animale to database
       
         String idtag = tftagid.getText().trim();
         String gname = tfname.getText().trim();
         String gbreed = (String) jcbreed.getSelectedItem();
         Date gdob =  cdobdate.getDate();
         String gstud = (String) jcstud.getSelectedItem();
         String ggender = (String) jcgender.getSelectedItem();
         //Integer gbirthweight =  Integer.valueOf(tfbirthweight.getText());
         String gpaddock = (String) jcPaddock.getSelectedItem();
         String gherd = (String) jcherdtype.getSelectedItem();
         //Integer gweanweight = Integer.valueOf(tfWeanWeight.getText());
         Date weandate = tfWeanDate.getDate();
         String gram = (String) jcRam.getSelectedItem();
         String gewe = (String) jcEwe.getSelectedItem();
         String gbirthstatues = (String) jcBirthStatues.getSelectedItem();
         String ghealth = (String) jcHealthStatues.getSelectedItem();
         String ghorn = (String) jcHorned.getSelectedItem();
    
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
        if(idtag.isEmpty() || gbreed.equals("SELECT") || ggender.equals("SELECT") || gstud.isEmpty() || gstud.equals("SELECT") || gpaddock.equals("SELECT") ||
           gherd.equals("SELECT") || tfbirthweight.toString().isEmpty() || gram.equals("SELECT") || gewe.equals("SELECT")|| gbirthstatues.equals("SELECT") ||
           ghealth.equals("SELECT") || ghorn.equals("SELECT"))  {
        
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed, other fields can be left empty but may cause inaccurate data!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        } else if (weandate == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter current or expected wean date in order to keep date accurate!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
    
        } else {
            
            try {
                
                Connection conn = myConnection.getConnect();
                
                //Check if Kid ID already exists
                String checkName = "SELECT s_tag_id FROM tbl_sheep_info WHERE s_tag_id = '" + idtag + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If animal tag has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Lamb ID: " + idtag + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new Animale
                    String saveQuery = "INSERT INTO tbl_lamb_info(s_tag_id, s_name, s_breed, s_dob, s_studcom, s_gender, s_birthweight, s_paddock, s_herdgroup, "
                            + "s_weanweight, s_weandate, s_ramID, s_eweID, s_birthstatues, s_healthstatues, s_hornstatues)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                                      
                    psm.setString(1, idtag);                
                    psm.setString(2, gname);
                    psm.setString(3, gbreed);
                    psm.setString(5, gstud);
                    psm.setString(6, ggender);
                    psm.setString(8, gpaddock);
                    psm.setString(9, gherd);
                    psm.setString(12, gram);
                    psm.setString(13, gewe);
                    psm.setString(14, gbirthstatues);
                    psm.setString(15, ghealth);
                    psm.setString(16, ghorn);
                    psm.setString(4, date1);
                    psm.setString(11, date2);
                   

                     // Accept Null excption from string to Integer
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
                        jcbreed.setSelectedItem("SELECT");
                        jcgender.setSelectedItem("SELECT");
                        jcstud.setSelectedItem("SELECT");
                        jcPaddock.setSelectedItem("SELECT");
                        jcherdtype.setSelectedItem("SELECT");
                        tfbirthweight.setText("");
                        jcBirthStatues.setSelectedItem("SELECT");
                        tfWeanWeight.setText("");
                        jcRam.setSelectedItem("SELECT");
                        jcEwe.setSelectedItem("SELECT");
                        jcBirthStatues.setSelectedItem("SELECT");;
                        jcHealthStatues.setSelectedItem("SELECT");
                        jcHorned.setSelectedItem("SELECT");
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

    private void buttonCloseKidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseKidActionPerformed
       
        this.dispose();
        new ClassLivestock().setVisible(true);
        
    }//GEN-LAST:event_buttonCloseKidActionPerformed

    private void jcEweFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcEweFocusGained
        // Ewe ID
        
         try {
                 
                Connection conn = myConnection.getConnect();
           
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s_tag_id FROM tbl_sheep_info");
                 
                 while(rs.next()){
                     
                     jcEwe.addItem(rs.getString("s_tag_id"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_jcEweFocusGained

    private void jcPaddockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcPaddockFocusGained
        // Populate JCombobox
        
         try {
                 
                Connection conn = myConnection.getConnect();
           
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     jcPaddock.addItem(rs.getString("pname"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            } 
        
    }//GEN-LAST:event_jcPaddockFocusGained

    private void jcRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcRamActionPerformed

    private void jcRamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcRamFocusGained
        // Sire ID

        try {

         Connection conn = myConnection.getConnect();
           
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT s_tag_id FROM tbl_sheep_info");

        while(rs.next()){

            jcRam.addItem(rs.getString("s_tag_id"));

        }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jcRamFocusGained

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
                new AddLamb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCSave;
    private javax.swing.JButton buttonCloseKid;
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
    private javax.swing.JComboBox<String> jcEwe;
    private javax.swing.JComboBox<String> jcHealthStatues;
    private javax.swing.JComboBox<String> jcHorned;
    private javax.swing.JComboBox<String> jcPaddock;
    private javax.swing.JComboBox<String> jcRam;
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
