package agri8.management.software;

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


public class AddWeanerSheep extends javax.swing.JFrame {

    MySQLConnect myConnection;
  
    public AddWeanerSheep() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        HERDTYPE();
        populatePaddock();
      
    }
    
    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }

   private void HERDTYPE() {
        // Fill Textfield when choosing cattle ID in JComboBox
       
          try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     JCHERDW.addItem(rs.getString("herdtype"));
                    
                } 
                 conn.close();
                 
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Herd Group System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }
   
   private void populatePaddock() {
       
       // Populate JCombobox
        
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     JCPADDOCKW.addItem(rs.getString("pname"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        sone = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        stwo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        sthree = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        sfive = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        sseven = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        seight = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        snine = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        sten = new javax.swing.JComboBox<>();
        buttonUpload = new javax.swing.JButton();
        buttonCloseAdd = new javax.swing.JButton();
        buttonSaveG = new javax.swing.JButton();
        sfour = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnAddHerd = new javax.swing.JButton();
        btnDeleteHerd = new javax.swing.JButton();
        btnAddBreed = new javax.swing.JButton();
        btnDeleteBreed = new javax.swing.JButton();
        ssixs = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        seleven = new javax.swing.JTextField();
        stwelve = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        sthirteen = new javax.swing.JTextField();
        sfourteen = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        sfifteen = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        ssixsteen = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCPADDOCKW = new javax.swing.JComboBox<>();
        JCHERDW = new javax.swing.JComboBox<>();
        JCTYPE = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JCSTUDW = new javax.swing.JComboBox<>();
        TFWDATE = new com.toedter.calendar.JDateChooser();
        buttonSaveW = new javax.swing.JButton();
        buttonClearW = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        TFSALEDATE = new com.toedter.calendar.JDateChooser();
        TFIDW = new javax.swing.JTextField();
        TFNAMEW = new javax.swing.JTextField();
        JCGENDERW = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        TFWEIGHT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TFSIRE = new javax.swing.JTextField();
        TFDAM = new javax.swing.JTextField();
        buttonCloseW = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        JCBREED = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TFBIRTHWEIGHT = new javax.swing.JTextField();
        TFDOB = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        btnAddHerdG = new javax.swing.JButton();
        btnAddBreedG = new javax.swing.JButton();
        btnDeleteH = new javax.swing.JButton();
        btnDeleteBreedS = new javax.swing.JButton();
        labelHeading = new javax.swing.JLabel();
        labelBg = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setUndecorated(true);
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 260));

        jFrame1.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 530, 280));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Save Goat Information");
        jFrame1.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1070, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()), "Mandatory Information"));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("*Tag ID Nr:");

        sone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Name:");

        stwo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("*Breed:");

        sthree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrino", "Black-head Persian", "Corriedale", "Dohne Merino", "Dormer", "Dorper Sheep", "Dorset Horn", "Hampshire Down", "ile de France", "Karakul", "Meatmaster", "SA Mutton Merino", "SA Wool Merino", "Suffolk", "Vandor", "Van Rooyen", "Witlshire" }));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("*Date-of-Birth:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("*Gender:");

        sfive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Ewe (Female)", "Ram (Male)", "Other" }));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("*Stud / Commercial:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("*Current Paddock:");

        sseven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        sseven.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ssevenFocusGained(evt);
            }
        });
        sseven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssevenActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("*Herd Group Name:");

        seight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        seight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                seightFocusGained(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("*Birth Weight:");

        snine.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        snine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                snineKeyPressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("*Breeding Status:");

        sten.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        sten.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stenFocusGained(evt);
            }
        });

        buttonUpload.setText("UPLOAD IMAGE");
        buttonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUploadActionPerformed(evt);
            }
        });

        buttonCloseAdd.setText("CLOSE");
        buttonCloseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseAddActionPerformed(evt);
            }
        });

        buttonSaveG.setText("SAVE");
        buttonSaveG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveGActionPerformed(evt);
            }
        });

        sfour.setDateFormatString("yyyy-MM-dd");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Add / Delete Herd Group:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Add / Delete Breeding Statues:");

        btnAddHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnAddHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHerdActionPerformed(evt);
            }
        });

        btnDeleteHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHerdActionPerformed(evt);
            }
        });

        btnAddBreed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnAddBreed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBreedActionPerformed(evt);
            }
        });

        btnDeleteBreed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteBreed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBreedActionPerformed(evt);
            }
        });

        ssixs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Commercial Ewe)", "Stud / Com (Stud Ewe, Commercial Ram)" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel28))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sfour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sfive, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sthree, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stwo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sone, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(buttonUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCloseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSaveG, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sseven, 0, 198, Short.MAX_VALUE)
                                    .addComponent(ssixs, 0, 1, Short.MAX_VALUE))))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(51, 51, 51)
                                .addComponent(btnAddHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel42))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(snine, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seight, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(sone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stwo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sthree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(sfour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sfive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssixs, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sseven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(seight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(snine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(sten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSaveG, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddHerd)
                    .addComponent(jLabel19)
                    .addComponent(btnDeleteHerd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel20)
                        .addComponent(btnAddBreed))
                    .addComponent(btnDeleteBreed))
                .addContainerGap())
        );

        jFrame1.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 420, 600));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        seleven.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seleven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                selevenKeyPressed(evt);
            }
        });

        stwelve.setDateFormatString("yyyy-MM-dd");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Weaning Weight:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("*Weaning Date:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("12 Month Weight:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("*12 Month Date:");

        sthirteen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sthirteen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sthirteenKeyPressed(evt);
            }
        });

        sfourteen.setDateFormatString("yyyy-MM-dd");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel21.setText("If no weight data, can be left empty!");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel22.setText("Optional to leave Ram and Ewe Empty!");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("1st gen Ram nr:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("1st gen Ewe nr:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel39.setText("If no weight data, can be left empty!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seleven)
                            .addComponent(stwelve, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(26, 26, 26)
                                .addComponent(sthirteen))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel23))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ssixsteen)
                                    .addComponent(sfourteen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sfifteen))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel22))))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(seleven, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(stwelve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sthirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sfourteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sfifteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssixsteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(21, 21, 21))
        );

        jFrame1.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 540, 270));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgmoney.jpg"))); // NOI18N
        jLabel40.setText("jLabel1");
        jFrame1.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1070, 690));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("*Tag ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("*Paddock:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("*Herd Group:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("*Weaner type:");

        JCPADDOCKW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCHERDW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        JCTYPE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "1. Mating Ram - Farm keep (Stud)", "2. Mating Ram - Sale (Stud)", "3.Commercial Ram - Farm keep", "4. Commerical Ram - Sales", "5. Wether - Sales (Feedlot)", "6. Wether- Sales (Backgrounding)", "7. Wether - Sales (Backgrouding + Feedlot)", "8. Stud Ram - Commercial Sale", "9. Stud Ram - Stud Sale", "10. Open Mating Ewe - Farm keep", "11. Open Mating Ewe - Sale", "12. Commercial Ewe - Farm keep", "13. Commerical Ewe - Sales", "14. Stud Ewe - Commercial Sale", "15. Stud Ewe - Stud Sale", "16. Other", " ", " " }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Weaning Weight:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("*Wean Date:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("*Sale / Mating Date:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("*Stud / Com:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ram ID:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Ewe ID:");

        JCSTUDW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Com  Ewe)", "Stud / Com (Stud Ewe, Com Ram )" }));

        TFWDATE.setDateFormatString("yyyy-MM-dd");

        buttonSaveW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        buttonSaveW.setText("SAVE");
        buttonSaveW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveWActionPerformed(evt);
            }
        });

        buttonClearW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear16.png"))); // NOI18N
        buttonClearW.setText("CLEAR");
        buttonClearW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearWActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AGRI8 Assist - Here the farmer add records of each Weaner which if for sale, showing or mating");

        TFSALEDATE.setDateFormatString("yyyy-MM-dd");

        JCGENDERW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Ewe (Female)", "Ram (Male)", "Other" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("*Gender:");

        TFWEIGHT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFWEIGHTKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Kg");

        buttonCloseW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonCloseW.setText("CLOSE");
        buttonCloseW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseWActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("*Breed:");

        JCBREED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrino", "Black-head Persian", "Corriedale", "Dohne Merino", "Dormer", "Dorper Sheep", "Dorset Horn", "Hampshire Down", "ile de France", "Karakul", "Meatmaster", "SA Mutton Merino", "SA Wool Merino", "Suffolk", "Vandor", "Van Rooyen", "Witlshire" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("*Date of Birth:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Birth Weight:");

        TFBIRTHWEIGHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFBIRTHWEIGHTActionPerformed(evt);
            }
        });
        TFBIRTHWEIGHT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFBIRTHWEIGHTKeyPressed(evt);
            }
        });

        TFDOB.setDateFormatString("yyyy-MM-dd");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Kg");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Add / Delete Herd Group:");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Add / Delete Breeding Statues:");

        btnAddHerdG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnAddHerdG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHerdGActionPerformed(evt);
            }
        });

        btnAddBreedG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnAddBreedG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBreedGActionPerformed(evt);
            }
        });

        btnDeleteH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHActionPerformed(evt);
            }
        });

        btnDeleteBreedS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteBreedS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBreedSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TFNAMEW, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFIDW, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCPADDOCKW, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(JCGENDERW, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30)
                        .addComponent(JCSTUDW, 0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(JCHERDW, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBREED, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(27, 27, 27)
                            .addComponent(TFSALEDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14))
                            .addGap(121, 121, 121)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFSIRE)
                                .addComponent(TFDAM)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel16)
                                .addComponent(jLabel5))
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFWDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TFWEIGHT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFBIRTHWEIGHT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(47, 47, 47)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddHerdG, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddBreedG, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteBreedS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSaveW, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearW, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFIDW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JCTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFNAMEW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFBIRTHWEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JCGENDERW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TFWEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(JCBREED, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(JCPADDOCKW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TFDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(TFSALEDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(TFSIRE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(JCSTUDW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(JCHERDW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFDAM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(btnAddHerdG)
                                    .addComponent(btnDeleteH))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDeleteBreedS)
                                    .addComponent(jLabel43)
                                    .addComponent(btnAddBreedG)))))
                    .addComponent(jLabel9)
                    .addComponent(TFWDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(buttonSaveW, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearW, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 890, 540));

        labelHeading.setBackground(new java.awt.Color(255, 255, 255));
        labelHeading.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelHeading.setForeground(new java.awt.Color(0, 0, 0));
        labelHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeading.setText("Sheep - Add Weaner Information");
        getContentPane().add(labelHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 960, 50));

        labelBg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgfarm.jpg"))); // NOI18N
        getContentPane().add(labelBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 960, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearWActionPerformed
        // Clear Mating Frame
        
          TFIDW.setText("");
          TFNAMEW.setText("");
          JCGENDERW.setSelectedItem("SELECT");
          JCBREED.setSelectedItem("SELECT");
          TFDOB.setDate(null);
          JCPADDOCKW.setSelectedItem("SELECT");
          JCSTUDW.setSelectedItem("SELECT");
          JCHERDW.setSelectedItem("SELECT");
          JCTYPE.setSelectedItem("SELECT");
          TFBIRTHWEIGHT.setText("");
          TFWEIGHT.setText("");
          TFWDATE.setDate(null);
          TFSALEDATE.setDate(null);
          TFSIRE.setText("");
          TFDAM.setText("");
    }//GEN-LAST:event_buttonClearWActionPerformed

    private void buttonSaveWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveWActionPerformed
        // Save new mating record to database
       
        
        Connection conn = myConnection.getConnect();
        
         String swid = TFIDW.getText().trim();
         String swname = TFNAMEW.getText().trim();
         String  swgender= (String) JCGENDERW.getSelectedItem();
         String  swbreed= (String) JCBREED.getSelectedItem();
         Date sdob = TFDOB.getDate();
         String swpaddock = (String) JCPADDOCKW.getSelectedItem();
         String swstud = (String) JCSTUDW.getSelectedItem();
         String  swherd = (String) JCHERDW.getSelectedItem();
         String  swtype= (String) JCTYPE.getSelectedItem();
         //Integer sbweight = Integer.parseInt(TFBIRTHWEIGHT.getText().trim());
         //Integer swweight = Integer.parseInt(TFWEIGHT.getText().trim());
         Date swweandate =  TFWDATE.getDate();
         Date swsales =  TFSALEDATE.getDate();
         String swram = TFSIRE.getText().trim();
         String swewe = TFDAM.getText().trim();
         
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          
         String date1 = null;
         String date2 = null;
         String date3 = null;
                  
           try {
                
                date1 = sdf.format(TFWDATE.getDate());
                date2 = sdf.format(TFSALEDATE.getDate());
                date3 = sdf.format(TFDOB.getDate());
                   
         }catch (NullPointerException e) {
                System.out.print("null pointer expection" + e);
         }
         
        //Validation to check if controls are empty or not
        if(swid.isEmpty() || swgender.equals("SELECT") || swbreed.equals("SELECT")  || swpaddock.equals("SELECT")  || swstud.equals("SELECT")  || swherd.equals("SELECT")  ||
           swtype.equals("SELECT"))  {
        
           JOptionPane.showMessageDialog(null, "All (*) mandatory fields must be completed!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        } else if (date3 == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter Date-of-Birth!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        }else if (date1 == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter Weaning Date!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        } else if (date2 == null) {
                JOptionPane.showMessageDialog(null, "Please enter Sales / Mating Date!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                
           
                
                //Check if weaner ID already exists
                String checkName = "SELECT sw_id FROM tbl_weaner_lambs WHERE sw_id = '" + swid + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If animal tag has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Weaner ID: " + swid + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new record
                    String saveQuery = "INSERT INTO tbl_weaner_lambs(sw_id, sw_name, sw_gender, sw_breed, sw_dob, sw_paddock, sw_studcom, sw_herdtype, sw_type, sw_birthweight, sw_weanweight, "
                            + "sw_weandate, sw_salemate, sw_ram, sw_ewe)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                      
                             // Accept Null excption from string to Integer
                 try {       
                  if ( TFBIRTHWEIGHT.getText().isEmpty() ) {
                        psm.setNull(10, Types.INTEGER);
                      } else {
                    psm.setInt(10, Integer.parseInt(TFBIRTHWEIGHT.getText()));
                      }
                   } catch (NullPointerException | NumberFormatException e)  {
                        
                    }
                    
        
                         // Accept Null excption from string to Integer
                 try {       
                  if ( TFWEIGHT.getText().isEmpty() ) {
                        psm.setNull(11, Types.INTEGER);
                      } else {
                    psm.setInt(11, Integer.parseInt(TFWEIGHT.getText()));
                      }
                   } catch (NullPointerException | NumberFormatException e)  {
                        
                    }
                    
                    psm.setString(1, swid);                
                    psm.setString(2, swname);
                    psm.setString(3, swgender);
                    psm.setString(4, swbreed);
                    psm.setString(5, date3);
                    psm.setString(6, swpaddock);
                    psm.setString(7, swstud);
                    psm.setString(8, swherd);
                    psm.setString(9, swtype);
                    //psm.setString(10, bweight.toString());
                   // psm.setString(11, wweight.toString());
                    psm.setString(12, date1);
                    psm.setString(13, date2);
                    psm.setString(14, swram);
                    psm.setString(15, swewe);
                    
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Weaner added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                        TFIDW.setText("");
                        TFNAMEW.setText("");
                        JCGENDERW.setSelectedItem("SELECT");
                        JCBREED.setSelectedItem("SELECT");
                        TFDOB.setDate(null);
                        JCPADDOCKW.setSelectedItem("SELECT");
                        JCSTUDW.setSelectedItem("SELECT");
                        JCHERDW.setSelectedItem("SELECT");
                        JCTYPE.setSelectedItem("SELECT");;
                        TFBIRTHWEIGHT.setText("");
                        TFWEIGHT.setText("");
                        TFWDATE.setDate(null);
                        TFSALEDATE.setDate(null);
                        TFSIRE.setText("");
                        TFDAM.setText("");
                        
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Weaner record!", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
            
  
            } catch (SQLException | HeadlessException | NullPointerException e) {
                         System.err.println(e.getMessage());
                      //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }
            
        }
    }//GEN-LAST:event_buttonSaveWActionPerformed

    private void buttonCloseWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseWActionPerformed
        // Close frame
        
       this.dispose();
       new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonCloseWActionPerformed

    private void TFBIRTHWEIGHTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBIRTHWEIGHTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFBIRTHWEIGHTKeyPressed

    private void TFBIRTHWEIGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFBIRTHWEIGHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFBIRTHWEIGHTActionPerformed

    private void TFWEIGHTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFWEIGHTKeyPressed
        // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups

        String size = TFWEIGHT.getText().trim();
        int length = size.length();

        char c = evt.getKeyChar();

        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){

            //Check Length
            if(length<4) {
                TFWEIGHT.setEditable(true);
            } else {
                TFWEIGHT.setEditable(false);
            }

        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                TFWEIGHT.setEditable(true);
            } else {
                TFWEIGHT.setEditable(false);
            }
        
        }
    }//GEN-LAST:event_TFWEIGHTKeyPressed

    private void ssevenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ssevenFocusGained


    }//GEN-LAST:event_ssevenFocusGained

    private void ssevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssevenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssevenActionPerformed

    private void seightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seightFocusGained
    
    }//GEN-LAST:event_seightFocusGained

    private void snineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_snineKeyPressed
     
    }//GEN-LAST:event_snineKeyPressed

    private void stenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stenFocusGained


    }//GEN-LAST:event_stenFocusGained

    private void buttonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUploadActionPerformed
        // Resize image and fetch image

   
    }//GEN-LAST:event_buttonUploadActionPerformed

    private void buttonCloseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseAddActionPerformed
        // TODO add your handling code here:

        this.dispose();
        new ClassLivestock().setVisible(true);

    }//GEN-LAST:event_buttonCloseAddActionPerformed

    private void buttonSaveGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveGActionPerformed
       
    }//GEN-LAST:event_buttonSaveGActionPerformed

    private void btnAddHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHerdActionPerformed
        // Add Herd Group

        //Prompt User
        String herd = JOptionPane.showInputDialog(null, "Please enter Herd Group Name", "Input new Herd Group", JOptionPane.QUESTION_MESSAGE);

        if(herd.equals("")) {
            JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!");
        } else {

            try {

                Connection conn = myConnection.getConnect();

                //Save new Item / String
                String saveQuery = "INSERT INTO tbl_herdtype(herdtype)" +
                "values(?)";

                PreparedStatement psm = conn.prepareStatement(saveQuery);
                psm.setString(1, herd);
                psm.executeUpdate();
                this.dispose();
                new AddSheep().setVisible(true);

                JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                conn.close();

            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.println(e.getMessage());
                //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
    }//GEN-LAST:event_btnAddHerdActionPerformed

    private void btnDeleteHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHerdActionPerformed
        // Remove Herd Group

        try {
            Connection conn = myConnection.getConnect();
            String herdtype = (String) seight.getSelectedItem();

            if(herdtype.isEmpty()) {

                JOptionPane.showMessageDialog(null, " Please select Herd Type in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);

            } else {

                String sqldelete = "DELETE FROM tbl_herdtype WHERE herdtype = '" + herdtype+ "'";

                PreparedStatement pst=conn.prepareStatement(sqldelete);
                pst.executeUpdate(sqldelete);
                JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                this.dispose();
                new AddSheep().setVisible(true);
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
              System.err.println(e.getMessage());
            // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnDeleteHerdActionPerformed

    private void btnAddBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBreedActionPerformed
        // Add Breeding Statues to Database

        //Prompt User
        String Breed = JOptionPane.showInputDialog(null, "Please enter Breeding Statues", "Input new Breeding Statues", JOptionPane.QUESTION_MESSAGE);
        if(Breed.equals("")) {
            JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!");
        } else {

            try {

                Connection conn = myConnection.getConnect();

                //Save new Item / String

                String saveQuery = "INSERT INTO tbl_breeding(breeding)" +
                "values(?)";

                PreparedStatement psm = conn.prepareStatement(saveQuery);
                psm.setString(1, Breed);
                psm.executeUpdate();
                this.dispose();
                new AddSheep().setVisible(true);

                JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                conn.close();

            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.println(e.getMessage());
                //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
    }//GEN-LAST:event_btnAddBreedActionPerformed

    private void btnDeleteBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBreedActionPerformed
        try {
            Connection conn = myConnection.getConnect();
            String breeding = (String) sten.getSelectedItem();

            if(breeding.isEmpty()) {

                JOptionPane.showMessageDialog(null, " Please select Breeding Statues in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);

            } else {

                String sqldelete = "DELETE FROM tbl_breeding WHERE breeding = '" + breeding+ "'";

                PreparedStatement pst=conn.prepareStatement(sqldelete);
                pst.executeUpdate(sqldelete);
                JOptionPane.showMessageDialog(null, "Successfully Deleted!");
                this.dispose();
                new AddSheep().setVisible(true);
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
              System.err.println(e.getMessage());
            // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnDeleteBreedActionPerformed

    private void selevenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_selevenKeyPressed
        //Set textfield to accept only Integers

        String size = seleven.getText().trim();
        int length = size.length();

        char c = evt.getKeyChar();

        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){

            //Check Length
            if(length<4) {
                seleven.setEditable(true);
            } else {
                seleven.setEditable(false);
            }

        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                seleven.setEditable(true);
            } else {
                seleven.setEditable(false);
            }
        }

    }//GEN-LAST:event_selevenKeyPressed

    private void sthirteenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sthirteenKeyPressed
        // Set textfield to accept only Integers

        String size = sthirteen.getText().trim();
        int length = size.length();

        char c = evt.getKeyChar();

        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){

            //Check Length
            if(length<4) {
                sthirteen.setEditable(true);
            } else {
                sthirteen.setEditable(false);
            }

        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                sthirteen.setEditable(true);
            } else {
                sthirteen.setEditable(false);
            }
        }
    }//GEN-LAST:event_sthirteenKeyPressed

    private void btnAddHerdGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHerdGActionPerformed
        // Add Herd Group
   boolean flag = false;
   
    String  herd = JOptionPane.showInputDialog(null, "Please enter Herd Group Name", "Input new Herd Group", JOptionPane.QUESTION_MESSAGE);
       
    if(herd == null) 
    {
         JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
         flag = false;
         
    } else {
         flag = true;
        try {
                
                Connection conn = myConnection.getConnect();
                
                 //Save new Item / String 
                    String saveQuery = "INSERT INTO tbl_herdtype(herdtype)" +
                            "values(?)";
                    
                   PreparedStatement psm = conn.prepareStatement(saveQuery);  
                           psm.setString(1, herd); 
                  
                    
                    psm.executeUpdate();
                    this.dispose();
                    new AddSheep().setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    conn.close();
                  
               
            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.println(e.getMessage());
                    //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }
         }
  
    }//GEN-LAST:event_btnAddHerdGActionPerformed

    private void btnDeleteHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHActionPerformed
          // Remove Herd Group
      
       try {  
         Connection conn = myConnection.getConnect();
         String herdtype = (String) seight.getSelectedItem();
        
        if(herdtype.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please select Herd Type in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);
           
        } else {
            
            String sqldelete = "DELETE FROM tbl_herdtype WHERE herdtype = '" + herdtype+ "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            this.dispose();
            new AddSheep().setVisible(true);
        }   
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
                       // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
    }//GEN-LAST:event_btnDeleteHActionPerformed

    private void btnDeleteBreedSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBreedSActionPerformed
          try {  
         Connection conn = myConnection.getConnect();
         String breeding = (String) sten.getSelectedItem();
        
        if(breeding.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please select Breeding Statues in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);
           
        } else {
            
            String sqldelete = "DELETE FROM tbl_breeding WHERE breeding = '" + breeding+ "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
            this.dispose();
            new AddSheep().setVisible(true);
        }   
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
                       // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
    }//GEN-LAST:event_btnDeleteBreedSActionPerformed

    private void btnAddBreedGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBreedGActionPerformed
        
         // Add Breeding Statues to Database
         
    boolean flag1 = false;
   
    String Breed = JOptionPane.showInputDialog(null, "Please enter Breeding Statues", "Input new Breeding Statues", JOptionPane.QUESTION_MESSAGE);
        
    if(Breed == null) 
    {
         JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
         flag1 = false;
         
    } else {
         flag1 = true;
            
        try {
                
                Connection conn = myConnection.getConnect();
               
                 //Save new Item / String
                 
                    String saveQuery = "INSERT INTO tbl_breeding(breeding)" +
                            "values(?)";
                    
                  PreparedStatement psm = conn.prepareStatement(saveQuery);    
                  psm.setString(1, Breed);                   
                  psm.executeUpdate();
                  this.dispose();
                  new AddSheep().setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    conn.close();
                
            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.println(e.getMessage());
                      //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }  
        }
    }//GEN-LAST:event_btnAddBreedGActionPerformed

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
            java.util.logging.Logger.getLogger(AddWeanerSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWeanerSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWeanerSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWeanerSheep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWeanerSheep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBREED;
    private javax.swing.JComboBox<String> JCGENDERW;
    private javax.swing.JComboBox<String> JCHERDW;
    private javax.swing.JComboBox<String> JCPADDOCKW;
    private javax.swing.JComboBox<String> JCSTUDW;
    private javax.swing.JComboBox<String> JCTYPE;
    private javax.swing.JTextField TFBIRTHWEIGHT;
    private javax.swing.JTextField TFDAM;
    private com.toedter.calendar.JDateChooser TFDOB;
    private javax.swing.JTextField TFIDW;
    private javax.swing.JTextField TFNAMEW;
    private com.toedter.calendar.JDateChooser TFSALEDATE;
    private javax.swing.JTextField TFSIRE;
    private com.toedter.calendar.JDateChooser TFWDATE;
    private javax.swing.JTextField TFWEIGHT;
    private javax.swing.JButton btnAddBreed;
    private javax.swing.JButton btnAddBreedG;
    private javax.swing.JButton btnAddHerd;
    private javax.swing.JButton btnAddHerdG;
    private javax.swing.JButton btnDeleteBreed;
    private javax.swing.JButton btnDeleteBreedS;
    private javax.swing.JButton btnDeleteH;
    private javax.swing.JButton btnDeleteHerd;
    private javax.swing.JButton buttonClearW;
    private javax.swing.JButton buttonCloseAdd;
    private javax.swing.JButton buttonCloseW;
    private javax.swing.JButton buttonSaveG;
    private javax.swing.JButton buttonSaveW;
    private javax.swing.JButton buttonUpload;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelBg;
    private javax.swing.JLabel labelHeading;
    private javax.swing.JLabel labelImage;
    private javax.swing.JComboBox<String> seight;
    private javax.swing.JTextField seleven;
    private javax.swing.JTextField sfifteen;
    private javax.swing.JComboBox<String> sfive;
    private com.toedter.calendar.JDateChooser sfour;
    private com.toedter.calendar.JDateChooser sfourteen;
    private javax.swing.JTextField snine;
    private javax.swing.JTextField sone;
    private javax.swing.JComboBox<String> sseven;
    private javax.swing.JComboBox<String> ssixs;
    private javax.swing.JTextField ssixsteen;
    private javax.swing.JComboBox<String> sten;
    private javax.swing.JTextField sthirteen;
    private javax.swing.JComboBox<String> sthree;
    private com.toedter.calendar.JDateChooser stwelve;
    private javax.swing.JTextField stwo;
    // End of variables declaration//GEN-END:variables
}
