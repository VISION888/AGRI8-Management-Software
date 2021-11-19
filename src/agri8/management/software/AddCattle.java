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

public class AddCattle extends javax.swing.JFrame {

    MySQLConnect myConnection;
  
    public AddCattle() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
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
                     
                     jcpaddock.addItem(rs.getString("pname"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println("Paddock System got an error: " + e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
     
     private void breedingStatues() {
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT breeding FROM tbl_breeding ORDER BY breeding ASC");
                 
                 while(rs.next()){
                     
                     jcstatues.addItem(rs.getString("breeding"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println("Breeding Statues System got an error: " + e.getMessage());
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
     
     private void Herdgroup() {
         
           try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     jcherdtype.addItem(rs.getString("herdtype"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e ) {
                System.err.println( "Herd Group System got an error: " + e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
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
        tftagid = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jcbreed = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jcgender = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jcpaddock = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jcherdtype = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        tfbirthweight = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jcstatues = new javax.swing.JComboBox<>();
        buttonCloseAdd = new javax.swing.JButton();
        buttonCSave = new javax.swing.JButton();
        cdobdate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAddHerd = new javax.swing.JButton();
        btnDeleteHerd = new javax.swing.JButton();
        btnAddBreed = new javax.swing.JButton();
        btnDeleteBreed = new javax.swing.JButton();
        jcstud = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        tfweanweight = new javax.swing.JTextField();
        tfweandate = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        tf12weight = new javax.swing.JTextField();
        tftwdate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfgensire = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfgendam = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        buttonUpload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/defaultcattle.jpg"))); // NOI18N
        jPanel1.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 530, 280));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Cattle Information");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1000, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()), "Mandatory Information"));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("*Tag ID Nr:");

        tftagid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("*Name:");

        tfname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("*Breed:");

        jcbreed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrikaner", "Angus", "Ankole", "Beefmaster", "Bonsmara", "Boran", "Brahman", "Braunivieh", "Charolais", "Drakensberger", "Hereford", "Limousin", "Nguni", "Other", "Santa Gertrudis", "Shorthorn", "Simbra", "Simmentaler", "Susses", "Tuli", "Wagyu" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("*Date-of-Birth:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("*Gender:");

        jcgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Dam (Female)", "Sire (Male)", "Other" }));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("*Stud / Commercial:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("*Current Paddock:");

        jcpaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcpaddock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcpaddockFocusGained(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("*Herd Group Name:");

        jcherdtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcherdtype.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcherdtypeFocusGained(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Birth Weight:");

        tfbirthweight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfbirthweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfbirthweightKeyPressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("*Breeding Status:");

        jcstatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcstatues.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcstatuesFocusGained(evt);
            }
        });

        buttonCloseAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonCloseAdd.setText("CLOSE");
        buttonCloseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseAddActionPerformed(evt);
            }
        });

        buttonCSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        buttonCSave.setText("SAVE");
        buttonCSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCSaveActionPerformed(evt);
            }
        });

        cdobdate.setDateFormatString("yyyy-MM-dd");

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

        jcstud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Sire Commercial Dam)", "Stud / Com (Stud Dam, Commercial Sire)" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tftagid, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcgender, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cdobdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbreed, javax.swing.GroupLayout.Alignment.TRAILING, 0, 189, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcpaddock, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcstud, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(btnAddBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDeleteBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(51, 51, 51)
                            .addComponent(btnAddHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDeleteHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel42)
                            .addComponent(buttonCSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(buttonCloseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfbirthweight, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcherdtype, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcstatues, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tftagid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbreed, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(cdobdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcgender, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcstud, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcpaddock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jcherdtype, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfbirthweight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jcstatues, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCloseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddHerd)
                    .addComponent(jLabel8)
                    .addComponent(btnDeleteHerd))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(btnAddBreed))
                    .addComponent(btnDeleteBreed))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 420, 630));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        tfweanweight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfweanweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfweanweightKeyPressed(evt);
            }
        });

        tfweandate.setDateFormatString("yyyy-MM-dd");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Weaning Weight:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("*Weaning Date:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("12 Month Weight:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("*12 Month Date:");

        tf12weight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tf12weight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf12weightKeyPressed(evt);
            }
        });

        tftwdate.setDateFormatString("yyyy-MM-dd");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("If no weight data, can be left empty!");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Optional to leave Sire and Dam Empty!");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("1st gen Sire nr:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("1st gen Dam nr:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
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
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfweanweight)
                            .addComponent(tfweandate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(26, 26, 26)
                                .addComponent(tf12weight, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tftwdate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfgensire, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfgendam, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(tfweanweight, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(tfweandate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf12weight, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(tftwdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfgensire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(tfgendam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 540, 260));

        buttonUpload.setText("UPLOAD IMAGE");
        buttonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUploadActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 123, 31));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgmoney.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1070, 750));

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

    private void buttonCSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCSaveActionPerformed
         // Save new animale to database
        
         String idtag = tftagid.getText().trim();
         String cname = tfname.getText().trim();
         String cbreed = (String) jcbreed.getSelectedItem();
         Date cdob =  cdobdate.getDate();
         String cgender = (String) jcgender.getSelectedItem();
         String cstud = (String) jcstud.getSelectedItem();
         String cpaddock = (String) jcpaddock.getSelectedItem();
         String cherd = (String) jcherdtype.getSelectedItem();
       
             
         String cstatus = (String) jcstatues.getSelectedItem();
         Date weandate = tfweandate.getDate();
         Date twdate = tftwdate.getDate();
         String csire = tfgensire.getText().trim();
         String cdam = tfgendam.getText().trim();
         
        //Validation to check if controls are empty or not
        if(idtag.isEmpty() || cbreed.equals("SELECT") || cgender.equals("SELECT") || cstud.equals("SELECT") || cpaddock.equals("SELECT") ||
           cherd.equals("SELECT") || cstatus.equals("SELECT"))  {
        
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed, other fields can be left empty but may cause inaccurate data!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        } else if (cdob == null) {
            
                JOptionPane.showMessageDialog(null, "Please enter Date of Birth!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        } else if(weandate == null ){
            
                JOptionPane.showMessageDialog(null, "Please enter Wean Date to check that Animal is Eligable for Weaning records!!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        
        } else if(twdate == null ){
            
                JOptionPane.showMessageDialog(null, "Please enter 12 Month Date to check that Animal is Eligable for mating records!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        
        } else {   
            try {
                
                Connection conn = myConnection.getConnect();
                
                //Check if cattle ID already exists
                String checkName = "SELECT c_tag_id FROM tbl_cattle_info WHERE c_tag_id = '" + idtag + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If animal tag has already been taken
                if(rs.next() == true) {
                
                        JOptionPane.showMessageDialog(null, "Dam / Sire ID: " + idtag + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else {
                
                    //Save new Animale
                    String saveQuery = "INSERT INTO tbl_cattle_info(c_tag_id, c_name, c_breed, c_dateofbirth, c_gender, c_studcom, c_paddock, c_herdtype, c_birthweight, "
                            + "c_breedingstatus, c_weanweight, c_weandate, c_12monthweight, c_12monthweightdate, c_sire1stgen, c_dam1stgen, c_picture)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                                      
                    psm.setString(1, idtag);                
                    psm.setString(2, cname);
                    psm.setString(3, cbreed);
                    psm.setString(5, cgender);
                    psm.setString(6, cstud);
                    psm.setString(7, cpaddock);
                    psm.setString(8, cherd);
                    psm.setString(10, cstatus);
                    
                        // Accept Null excption from string to Integer
                     if ( tfbirthweight.getText().isEmpty() ) {
                        psm.setNull(9, Types.INTEGER);
                      } else {
                    psm.setInt(9, Integer.parseInt(tfbirthweight.getText()));
                      }
                    
                    // Accept Null excption from string to Integer
                     if ( tfweanweight.getText().isEmpty() ) {
                        psm.setNull(11, Types.INTEGER);
                      } else {
                    psm.setInt(11, Integer.parseInt(tfweanweight.getText()));
                      }
                  
                  if ( tf12weight.getText().isEmpty() ) {
                        psm.setNull(13, Types.INTEGER);
                      } else {
                    psm.setInt(13, Integer.parseInt(tf12weight.getText()));
                      }
                    
                    psm.setString(15, csire);
                    psm.setString(16, cdam);
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(cdobdate.getDate());
                    String date2 = sdf.format(tfweandate.getDate());
                    String date3 = sdf.format(tftwdate.getDate());
                    
                    psm.setString(4, date1);
                    psm.setString(12, date2);
                    psm.setString(14, date3);
                    
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
                    
                      this.dispose();
                      new AddCattle().setVisible(true);

                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Animale to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
  
            } catch (SQLException | HeadlessException | NumberFormatException e) {
                System.err.println("System got an error: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }    catch (FileNotFoundException ex) {
                 Logger.getLogger(AddCattle.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        }
    }//GEN-LAST:event_buttonCSaveActionPerformed

    private void buttonCloseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseAddActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new ClassLivestock().setVisible(true);
        
    }//GEN-LAST:event_buttonCloseAddActionPerformed

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
                    new AddCattle().setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    conn.close();
               
            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.println("System got an error: " + e.getMessage());
                  //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
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
                   
                    JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new AddCattle().setVisible(true);
                    conn.close();
                
            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.println("System got an error: " + e.getMessage());
                        //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }  
        }
    }//GEN-LAST:event_btnAddBreedActionPerformed

    private void btnDeleteHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHerdActionPerformed
        // Remove Herd Group
      
       try {  
         Connection conn = myConnection.getConnect();
         String herdtype = (String) jcherdtype.getSelectedItem();
        
        if(herdtype.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please select Herd Type in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);
           
        } else {
            
            String sqldelete = "DELETE FROM tbl_herdtype WHERE herdtype = '" + herdtype+ "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            this.dispose();
            new AddCattle().setVisible(true);
        }   
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println("System got an error: " + e.getMessage());
               //         JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
    }//GEN-LAST:event_btnDeleteHerdActionPerformed

    private void btnDeleteBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBreedActionPerformed
        try {  
         Connection conn = myConnection.getConnect();
         String breeding = (String) jcstatues.getSelectedItem();
        
        if(breeding.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please select Breeding Statues in ComboBox!", "PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);
           
        } else {
            
            String sqldelete = "DELETE FROM tbl_breeding WHERE breeding = '" + breeding+ "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
            this.dispose();
            new AddCattle().setVisible(true);
        }   
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println("System got an error: " + e.getMessage());
                        //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
    }//GEN-LAST:event_btnDeleteBreedActionPerformed

    private void tfbirthweightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfbirthweightKeyPressed
        // Set JTextfield to accept only Integers of a certain Length
        
        String size = tfbirthweight.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
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

    private void tfweanweightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfweanweightKeyPressed
     //Set textfield to accept only Integers
     
        String size = tfweanweight.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                tfweanweight.setEditable(true);
            } else {
                 tfweanweight.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tfweanweight.setEditable(true);
            } else {
                tfweanweight.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_tfweanweightKeyPressed

    private void tf12weightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf12weightKeyPressed
        // Set textfield to accept only Integers
        
        String size = tf12weight.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                tf12weight.setEditable(true);
            } else {
                 tf12weight.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tf12weight.setEditable(true);
            } else {
                tf12weight.setEditable(false);
            }
        }
    }//GEN-LAST:event_tf12weightKeyPressed

    private void jcpaddockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcpaddockFocusGained
       
        paddock();
    }//GEN-LAST:event_jcpaddockFocusGained

    private void jcherdtypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcherdtypeFocusGained
        
         Herdgroup();
        
    }//GEN-LAST:event_jcherdtypeFocusGained

    private void jcstatuesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcstatuesFocusGained
        breedingStatues();
    }//GEN-LAST:event_jcstatuesFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCattle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBreed;
    private javax.swing.JButton btnAddHerd;
    private javax.swing.JButton btnDeleteBreed;
    private javax.swing.JButton btnDeleteHerd;
    private javax.swing.JButton buttonCSave;
    private javax.swing.JButton buttonCloseAdd;
    private javax.swing.JButton buttonUpload;
    private com.toedter.calendar.JDateChooser cdobdate;
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
    private javax.swing.JComboBox<String> jcbreed;
    private javax.swing.JComboBox<String> jcgender;
    private javax.swing.JComboBox<String> jcherdtype;
    private javax.swing.JComboBox<String> jcpaddock;
    private javax.swing.JComboBox<String> jcstatues;
    private javax.swing.JComboBox<String> jcstud;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField tf12weight;
    private javax.swing.JTextField tfbirthweight;
    private javax.swing.JTextField tfgendam;
    private javax.swing.JTextField tfgensire;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tftagid;
    private com.toedter.calendar.JDateChooser tftwdate;
    private com.toedter.calendar.JDateChooser tfweandate;
    private javax.swing.JTextField tfweanweight;
    // End of variables declaration//GEN-END:variables
}
