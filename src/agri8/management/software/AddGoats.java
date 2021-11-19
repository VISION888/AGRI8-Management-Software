package agri8.management.software;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddGoats extends javax.swing.JFrame {

    MySQLConnect myConnection;
  
    public AddGoats() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        labelImage.setIcon(resizeImage("Resources/addgoat.jpg", null));
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
 
     
     private void paddock() {
           // Populate JCombobox in Paddock
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock ORDER BY pname ASC");
                 
                 while(rs.next()){
                     
                     gseven.addItem(rs.getString("pname"));
                    
                } 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, " Paddock System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
     
     private void breedingStatues() {
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT breeding FROM tbl_breeding ORDER BY breeding ASC");
                 
                 while(rs.next()){
                     
                     gten.addItem(rs.getString("breeding"));
                    
                } 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException  e) {
                System.err.println(e.getMessage());
             //   JOptionPane.showMessageDialog(null, " Breeding System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
     
     private void Herdgroup() {
         
           try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     geight.addItem(rs.getString("herdtype"));
                    
                } 
                 conn.close();
                 
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Herd Group System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
     
   
      
     String photopath = null;
    //javax.swing.ImageIcon to resize image
    
    public ImageIcon resizeImage(String photopath, byte[] photo) {
        
       ImageIcon myPhoto = null;
       if(photopath != null){
           myPhoto = new ImageIcon(photopath);
       } else {
           myPhoto = new ImageIcon(photo);
       }
       
       Image img = myPhoto.getImage();
       Image img1 = img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ph = new ImageIcon(img1);
       return ph;
               
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        gone = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        gtwo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        gthree = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        gfive = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        gseven = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        geight = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        gnine = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        gten = new javax.swing.JComboBox<>();
        buttonUpload = new javax.swing.JButton();
        buttonCloseAdd = new javax.swing.JButton();
        buttonSaveG = new javax.swing.JButton();
        gfour = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAddHerd = new javax.swing.JButton();
        btnDeleteHerd = new javax.swing.JButton();
        btnAddBreed = new javax.swing.JButton();
        btnDeleteBreed = new javax.swing.JButton();
        gsixs = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        geleven = new javax.swing.JTextField();
        gtwelve = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        gthirteen = new javax.swing.JTextField();
        gfourteen = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gfifteen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gsixsteen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 530, 280));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Save Goat Information");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1070, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()), "Mandatory Information"));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("*Tag ID Nr:");

        gone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Name:");

        gtwo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("*Breed:");

        gthree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Angora", "Boer Goat", "British Alpine", "Indigenous Veld Goat ", "Kalahari Red", "Milch Goat", "Saanen", "Savannah White ", "Tankwa", "Toggenburg" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("*Date-of-Birth:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("*Gender:");

        gfive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Ewe (Female)", "Ram (Male)", "Other" }));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("*Stud / Commercial:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("*Current Paddock:");

        gseven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        gseven.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gsevenFocusGained(evt);
            }
        });
        gseven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gsevenActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("*Herd Group Name:");

        geight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        geight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                geightFocusGained(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("*Birth Weight:");

        gnine.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gnine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gnineKeyPressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("*Breeding Status:");

        gten.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        gten.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gtenFocusGained(evt);
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

        gfour.setDateFormatString("yyyy-MM-dd");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Add / Delete Herd Group:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Add / Delete Breeding Statues:");

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

        gsixs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Commercial Ewe)", "Stud / Com (Stud Ewe, Commercial Ram)" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gfour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gfive, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gthree, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gone, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCloseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSaveG, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gseven, 0, 198, Short.MAX_VALUE)
                                    .addComponent(gsixs, 0, 1, Short.MAX_VALUE))))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(51, 51, 51)
                                .addComponent(btnAddHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel42))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gnine, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(geight, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(gone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gthree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(gfour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gfive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gsixs, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gseven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(geight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gnine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(gten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSaveG, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddHerd)
                    .addComponent(jLabel8)
                    .addComponent(btnDeleteHerd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(btnAddBreed))
                    .addComponent(btnDeleteBreed))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 420, 600));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        geleven.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        geleven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gelevenKeyPressed(evt);
            }
        });

        gtwelve.setDateFormatString("yyyy-MM-dd");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Weaning Weight:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("*Weaning Date:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("12 Month Weight:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("*12 Month Date:");

        gthirteen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gthirteen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gthirteenKeyPressed(evt);
            }
        });

        gfourteen.setDateFormatString("yyyy-MM-dd");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("If no weight data, can be left empty!");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setText("Optional to leave Ram and Ewe Empty!");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("1st gen Ram nr:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("1st gen Ewe nr:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setText("If no weight data, can be left empty!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel37))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(geleven)
                            .addComponent(gtwelve, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(26, 26, 26)
                                .addComponent(gthirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gfifteen)
                                    .addComponent(gfourteen, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(gsixsteen))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(geleven, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(gtwelve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gthirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gfourteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gfifteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gsixsteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 540, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgmoney.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1070, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUploadActionPerformed
        // Resize image and fetch image
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*images", "jpg", "png");
        chooser.addChoosableFileFilter(fnef);
        int ans = chooser.showSaveDialog(null);
        if(ans == JFileChooser.APPROVE_OPTION) {
        File selectedPhoto = chooser.getSelectedFile();
        String path = selectedPhoto.getAbsolutePath();
        labelImage.setIcon(resizeImage(path, null));
        this.photopath = path;
        
        } else {
            System.out.println("Photo not selected!");
        }        
    }//GEN-LAST:event_buttonUploadActionPerformed

    private void buttonSaveGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveGActionPerformed
         // Save new animale to database
        
         String GTAG = gone.getText().trim();
         String GNAME = gtwo.getText().trim();
         String GBREED = (String) gthree.getSelectedItem();
         Date GDOB =  gfour.getDate();
         String GGENDER = (String) gfive.getSelectedItem();
         String GSTUD = (String) gsixs.getSelectedItem();
         String GPADDOCK = (String) gseven.getSelectedItem();
         String GHERD = (String) geight.getSelectedItem();
      
         String GSTATUES = (String) gten.getSelectedItem();
         Date GWEANDATE = gtwelve.getDate();
         Date GTWDATE = gfourteen.getDate();
         String GRAM = gfifteen.getText().trim();
         String GEWE = gsixsteen.getText().trim();
         
        //Validation to check if controls are empty or not
        if(GTAG.isEmpty() || GBREED.isEmpty() || GGENDER.isEmpty() || GSTUD.isEmpty() || GPADDOCK.isEmpty() ||
           GHERD.isEmpty() || GSTATUES.isEmpty())  {
        
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed, other fields can be left empty but may cause inaccurate data!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        } else if (GDOB == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter Date of Birth!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        } else if(GWEANDATE == null ){
            
                JOptionPane.showMessageDialog(null, "Please enter 60 - 100 Days WeaninG Date to check that Animal is Eligable for Weaning records!!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        
        } else if(GTWDATE == null ){
            
                JOptionPane.showMessageDialog(null, "Please enter 10 - 12 Month Date to check that Animal is Eligable for mating records!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        
        } else {   
            try {
                
                Connection conn = myConnection.getConnect();
                
                //Check if cattle ID already exists
                String checkName = "SELECT g_tag_id FROM tbl_goat_info WHERE g_tag_id = '" + GTAG + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If animal tag has already been taken
                if(rs.next() == true) {
                
                        JOptionPane.showMessageDialog(null, "Ram / Ewe ID: " + GTAG + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else {
                
                    //Save new Animale
                    String saveQuery = "INSERT INTO tbl_goat_info(g_tag_id, g_name, g_breed, g_dob, g_gender, g_studcom, g_paddock, g_herdtype, g_birthweight, "
                            + "g_breedingstatues, g_weanweight, g_weandate, g_12monthweight, g_12monthweightdate, g_ram1stgen, g_ewe1stgen, g_picture)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                      
                    
                    try {                 
                    psm.setString(1, GTAG);                
                    psm.setString(2, GNAME);
                    psm.setString(3, GBREED);
                    psm.setString(5, GGENDER);
                    psm.setString(6, GSTUD);
                    psm.setString(7, GPADDOCK);
                    psm.setString(8, GHERD);
                   
                    psm.setString(10, GSTATUES);
                    
                     // Accept Null excption from string to Integer
                     if ( gnine.getText().isEmpty() ) {
                        psm.setNull(9, Types.INTEGER);
                      } else {
                    psm.setInt(9, Integer.parseInt(gnine.getText()));
                      }
                    
                    
                    
                    // Accept Null excption from string to Integer
                     if ( geleven.getText().isEmpty() ) {
                        psm.setNull(11, Types.INTEGER);
                      } else {
                    psm.setInt(11, Integer.parseInt(geleven.getText()));
                      }
                     
                    }catch (NullPointerException | NumberFormatException e)  {
                        
                    }
                     
                   try {  
                  
                  if ( gthirteen.getText().isEmpty() ) {
                        psm.setNull(13, Types.INTEGER);
                      } else {
                    psm.setInt(13, Integer.parseInt(gthirteen.getText()));
                      }
                   } catch (NullPointerException | NumberFormatException e)  {
                        
                    }
                    
                    psm.setString(15, GRAM);
                    psm.setString(16, GEWE);
                    
                    try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(gfour.getDate());
                    String date2 = sdf.format(gtwelve.getDate());
                    String date3 = sdf.format(gfourteen.getDate());
                    
                    psm.setString(4, date1);
                    psm.setString(12, date2);
                    psm.setString(14, date3);
                    
                    } catch (NullPointerException | NumberFormatException e){
                        
                    }
                     try{
                        
                    if(photopath != null) {
                    InputStream img = new FileInputStream(new File(photopath));
                    psm.setBlob(17, img);
                    
                    } else {
                        psm.setNull(17, Types.BLOB);
                    }   
                        
                    } catch (NullPointerException | NumberFormatException e) {
                        System.out.print(" Null Pointer for Blob Caught: " + e + "");
                    }
                    
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Animale Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                        gone.setText("");
                        gtwo.setText("");
                        gthree.setSelectedItem("SELECT");
                        gfive.setSelectedItem("SELECT");
                        gsixs.setSelectedItem("SELECT");
                        gseven.setSelectedItem("SELECT");;
                        geight.setSelectedItem("SELECT");
                        gnine.setText("");
                        gten.setSelectedItem("SELECT");
                        geleven.setText("");
                        gthirteen.setText("");
                        gfifteen.setText("");
                        gsixsteen.setText("");
                        gfour.setDate(null);
                        gtwelve.setDate(null);
                        gfourteen.setDate(null);
                        labelImage.setIcon(resizeImage("Resources/addgoat.jpg", null));

                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Animale to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
  
            } catch (SQLException | HeadlessException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                      //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }    catch (FileNotFoundException ex) {
                 Logger.getLogger(AddGoats.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        }
    }//GEN-LAST:event_buttonSaveGActionPerformed

    private void buttonCloseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseAddActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new ClassLivestock().setVisible(true);
        
    }//GEN-LAST:event_buttonCloseAddActionPerformed

    private void gsevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gsevenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gsevenActionPerformed

    private void gsevenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gsevenFocusGained
          paddock();
        
    }//GEN-LAST:event_gsevenFocusGained

    private void btnAddHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHerdActionPerformed
        // Add Herd Group
      
         boolean flag = false;    

         //Prompt User
        String herd = JOptionPane.showInputDialog(null, "Please enter Herd Group Name", "Input new Herd Group", JOptionPane.QUESTION_MESSAGE);
      
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
                    new AddGoats().setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    conn.close();
                  
               
            } catch (SQLException | HeadlessException | NullPointerException e) {
                    //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }
         }
    }//GEN-LAST:event_btnAddHerdActionPerformed

    private void btnAddBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBreedActionPerformed
        // Add Breeding Statues to Database
        
        boolean flag = false;    

         //Prompt User
       String Breed = JOptionPane.showInputDialog(null, "Please enter Breeding Statues", "Input new Breeding Statues", JOptionPane.QUESTION_MESSAGE);
       
    if(Breed == null) 
         {
         JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
         flag = false;
         
    } else {
         flag = true;
 
            
        try {
                
                Connection conn = myConnection.getConnect();
               
                 //Save new Item / String
                 
                    String saveQuery = "INSERT INTO tbl_breeding(breeding)" +
                            "values(?)";
                    
                  PreparedStatement psm = conn.prepareStatement(saveQuery);    
                  psm.setString(1, Breed);                   
                  psm.executeUpdate();
                  this.dispose();
                  new AddGoats().setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    conn.close();
                
            } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                      //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }  
        }
    }//GEN-LAST:event_btnAddBreedActionPerformed

    private void btnDeleteHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHerdActionPerformed
        // Remove Herd Group
      
       try {  
         Connection conn = myConnection.getConnect();
         String herdtype = (String) geight.getSelectedItem();
        
        if(herdtype.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please select Herd Type in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);
           
        } else {
            
            String sqldelete = "DELETE FROM tbl_herdtype WHERE herdtype = '" + herdtype+ "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            this.dispose();
            new AddGoats().setVisible(true);
        }   
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
                       // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
    }//GEN-LAST:event_btnDeleteHerdActionPerformed

    private void btnDeleteBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBreedActionPerformed
        try {  
         Connection conn = myConnection.getConnect();
         String breeding = (String) gten.getSelectedItem();
        
        if(breeding.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please select Breeding Statues in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);
           
        } else {
            
            String sqldelete = "DELETE FROM tbl_breeding WHERE breeding = '" + breeding+ "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
            this.dispose();
            new AddGoats().setVisible(true);
        }   
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
               System.err.println(e.getMessage());
                       // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
    }//GEN-LAST:event_btnDeleteBreedActionPerformed

    private void geightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_geightFocusGained
       Herdgroup();
    }//GEN-LAST:event_geightFocusGained

    private void gtenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gtenFocusGained
        
         breedingStatues();     
    }//GEN-LAST:event_gtenFocusGained

    private void gnineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gnineKeyPressed
        // Set JTextfield to accept only Integers of a certain Length
        
        String size = gnine.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                gnine.setEditable(true);
            } else {
                 gnine.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                gnine.setEditable(true);
            } else {
                gnine.setEditable(false);
            }
        }
    }//GEN-LAST:event_gnineKeyPressed

    private void gelevenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gelevenKeyPressed
     //Set textfield to accept only Integers
     
        String size = geleven.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                geleven.setEditable(true);
            } else {
                 geleven.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                geleven.setEditable(true);
            } else {
                geleven.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_gelevenKeyPressed

    private void gthirteenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gthirteenKeyPressed
        // Set textfield to accept only Integers
        
        String size = gthirteen.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                gthirteen.setEditable(true);
            } else {
                 gthirteen.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                gthirteen.setEditable(true);
            } else {
                gthirteen.setEditable(false);
            }
        }
    }//GEN-LAST:event_gthirteenKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGoats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBreed;
    private javax.swing.JButton btnAddHerd;
    private javax.swing.JButton btnDeleteBreed;
    private javax.swing.JButton btnDeleteHerd;
    private javax.swing.JButton buttonCloseAdd;
    private javax.swing.JButton buttonSaveG;
    private javax.swing.JButton buttonUpload;
    private javax.swing.JComboBox<String> geight;
    private javax.swing.JTextField geleven;
    private javax.swing.JTextField gfifteen;
    private javax.swing.JComboBox<String> gfive;
    private com.toedter.calendar.JDateChooser gfour;
    private com.toedter.calendar.JDateChooser gfourteen;
    private javax.swing.JTextField gnine;
    private javax.swing.JTextField gone;
    private javax.swing.JComboBox<String> gseven;
    private javax.swing.JComboBox<String> gsixs;
    private javax.swing.JTextField gsixsteen;
    private javax.swing.JComboBox<String> gten;
    private javax.swing.JTextField gthirteen;
    private javax.swing.JComboBox<String> gthree;
    private com.toedter.calendar.JDateChooser gtwelve;
    private javax.swing.JTextField gtwo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelImage;
    // End of variables declaration//GEN-END:variables
}
