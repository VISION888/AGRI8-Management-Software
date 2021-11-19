package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class UpdateCattle extends javax.swing.JFrame {

    MySQLConnect myConnection;    
    
    public UpdateCattle() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        tagId();
        tfone.requestFocus();
        
        
    }

    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }

     String photopath = null;
    //javax.swing.ImageIcon to resize image
    
    public ImageIcon resizeImage(String photopath, byte[] pic) {
        
       ImageIcon myImage = null;
       if(photopath != null){
           myImage = new ImageIcon(photopath);
       } else {
           myImage = new ImageIcon(pic);
       }
       
       Image img = myImage.getImage();
       Image newImg = img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon image = new ImageIcon(newImg);
       return image;
           
    }
    
    private void tagId() {
        // Populate Tag ID Combobox
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT c_tag_id FROM tbl_cattle_info");

        while(rs.next()){

            JCID.addItem(rs.getString("c_tag_id"));

        }
        conn.close();
        } catch (SQLException | HeadlessException | ClassNotFoundException | NullPointerException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    }
    
    
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonSearchRecord = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfone = new javax.swing.JTextField();
        TFNAME = new javax.swing.JTextField();
        JCGENDERW = new javax.swing.JComboBox<>();
        tffour = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfsixs = new javax.swing.JTextField();
        tfthree = new javax.swing.JTextField();
        tffive = new javax.swing.JTextField();
        JCPADDOCK = new javax.swing.JComboBox<>();
        JCSTUDW = new javax.swing.JComboBox<>();
        JCHERD = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        tftwo = new javax.swing.JTextField();
        JCBREED = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tfseven = new javax.swing.JTextField();
        JCSTATUES = new javax.swing.JComboBox<>();
        buttonCloseW = new javax.swing.JButton();
        buttonUpdateRecord = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        buttonChangeImage = new javax.swing.JButton();
        JCID = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        buttonCloseW1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("UPDATE CATTLE RECORDS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1260, -1));

        buttonSearchRecord.setBackground(new java.awt.Color(204, 204, 255));
        buttonSearchRecord.setForeground(new java.awt.Color(0, 0, 0));
        buttonSearchRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchRecord.setText("SEARCH");
        buttonSearchRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchRecordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("TAG ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Name:");

        tfone.setEditable(false);
        tfone.setNextFocusableComponent(JCGENDERW);

        TFNAME.setNextFocusableComponent(JCGENDERW);

        JCGENDERW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Dam (Female)", "Sire (Male)", "Other" }));
        JCGENDERW.setNextFocusableComponent(JCPADDOCK);

        tffour.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Gender:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Paddock:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Stud / Com:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Herd Group:");

        tfsixs.setEditable(false);
        tfsixs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfsixsActionPerformed(evt);
            }
        });

        tfthree.setEditable(false);

        tffive.setEditable(false);

        JCPADDOCK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        JCPADDOCK.setNextFocusableComponent(JCSTUDW);
        JCPADDOCK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCPADDOCKFocusGained(evt);
            }
        });

        JCSTUDW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Sire Commercial Dam)", "Stud / Com (Stud Dam, Commercial Sire)" }));
        JCSTUDW.setNextFocusableComponent(JCHERD);

        JCHERD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        JCHERD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCHERDFocusGained(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setText("Breed:");

        tftwo.setEditable(false);

        JCBREED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrikaner", "Angus", "Ankole", "Beefmaster", "Bonsmara", "Boran", "Brahman", "Braunivieh", "Charolais", "Drakensberger", "Hereford", "Limousin", "Nguni", "Other", "Santa Gertrudis", "Shorthorn", "Simbra", "Simmentaler", "Susses", "Tuli", "Wagyu" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Breeding Statues:");

        tfseven.setEditable(false);

        JCSTATUES.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        JCSTATUES.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCSTATUESFocusGained(evt);
            }
        });

        buttonCloseW.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseW.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseW.setText("CLOSE");
        buttonCloseW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseWActionPerformed(evt);
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

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/defaultcattle.jpg"))); // NOI18N
        jPanel2.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 260));

        buttonChangeImage.setBackground(new java.awt.Color(204, 204, 255));
        buttonChangeImage.setForeground(new java.awt.Color(0, 0, 0));
        buttonChangeImage.setText("Change Image");
        buttonChangeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeImageActionPerformed(evt);
            }
        });

        JCID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("AGRI8 Assist: \"First search animal before attempting to update otherwise incorrect data may be stored! All Combobox's must be selected and filled in order to update animal. \" Name field may be left empty!");

        buttonCloseW1.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseW1.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseW1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonCloseW1.setText("CLEAR");
        buttonCloseW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseW1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCID, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonChangeImage)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCloseW1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tftwo)
                                                .addComponent(tfone))
                                            .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tffour, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfsixs)
                                            .addComponent(tffive, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(tfseven, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JCBREED, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JCSTUDW, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TFNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JCSTATUES, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JCGENDERW, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JCPADDOCK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JCHERD, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChangeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseW1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel17)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel4)
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JCSTUDW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JCGENDERW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tffour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JCPADDOCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tffive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JCHERD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfsixs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JCSTATUES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfseven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(TFNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JCBREED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(5, 5, 5)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1210, 450));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgfarm.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSearchRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchRecordActionPerformed

        Connection conn = myConnection.getConnect();
        String searchID = (String) JCID.getSelectedItem();
      
     if(searchID.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            JCID.setBackground(Color.LIGHT_GRAY);
            JCID.requestFocus();
            
        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT c_name, c_breed, c_studcom, c_gender, c_paddock, c_herdtype, c_breedingstatus, c_picture FROM tbl_cattle_info WHERE c_tag_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, searchID);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();
                
                byte[] image = null;
               

                if (rs.next()) {

                    tfone.setText(rs.getString("c_name"));                         
                    tftwo.setText(rs.getString("c_breed"));                           
                    tfthree.setText(rs.getString("c_studcom"));                        
                    tffour.setText(rs.getString("c_gender"));                     
                    tffive.setText(rs.getString("c_paddock"));                       
                    tfsixs.setText(rs.getString("c_herdtype"));             
                    tfseven.setText(rs.getString("c_breedingstatus")); 
                    image = (rs.getBytes("c_picture"));
                    
                    if(image != null) {
                        Image img = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon icon = new ImageIcon(img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH));
                        labelImage.setIcon(icon);
                    } else {
                        statement.setNull(1, Types.BLOB);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "ID not Found / Selected, Please try again!");
                 
                }
                
                conn.close();

            } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonSearchRecordActionPerformed

    private void buttonUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateRecordActionPerformed
        // Update Records

        Connection conn = myConnection.getConnect();
        
        String searchID = (String) JCID.getSelectedItem();
        String TFONE = TFNAME.getText().trim();
        String TFTWO = (String) JCBREED.getSelectedItem();
        String TFTHREE = (String) JCSTUDW.getSelectedItem();
        String TFFOUR = (String) JCGENDERW.getSelectedItem();
        String TFFIVE = (String) JCPADDOCK.getSelectedItem();
        String TFSIX = (String) JCHERD.getSelectedItem();
        String TFSEVEN = (String) JCSTATUES.getSelectedItem();
      
        if(searchID.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select ID!", "AGRI8 ASSIST: ID NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        
        } else if(TFTWO.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select BREED!", "AGRI8 ASSIST: BREED NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        
        } else if(TFTHREE.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select Stud or Commercial!", "AGRI8 ASSIST: STUD OR COMMERCIAL NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFFOUR.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select GENDER!", "AGRI8 ASSIST: GENDER NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFFIVE.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select PADDOCK!", "AGRI8 ASSIST: PADDOCK NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFSIX.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select HERD GROUP!", "AGRI8 ASSIST: HERD GROUP NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFSEVEN.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select BREEDING STATUES!", "AGRI8 ASSIST: BREEDING STATUES NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        }else {
           
            try {

                String query = "UPDATE tbl_cattle_info SET " +
                "c_name ='" + TFONE + "', c_breed= '" + TFTWO + "', c_studcom = '" + TFTHREE + "', c_gender= '" + TFFOUR + "', c_paddock = '" + TFFIVE + "', c_herdtype = '" 
                        + TFSIX + "', c_breedingstatus = '" + TFSEVEN + "', c_picture=? " + " WHERE c_tag_id= '" + searchID + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
                
                InputStream img = null;
                
            if (photopath != null) {  
                  
                    try {
                        img = new FileInputStream(photopath);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(UpdateCattle.class.getName()).log(Level.SEVERE, null, ex);
                    }
             statement.setBlob(1, img);
                         
             }  else {
             
            statement.setNull(1, Types.NULL);
            }
               
                int i = statement.executeUpdate();
                
                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + searchID + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new UpdateCattle().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, " Cattle update - system got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
            
         }
    }//GEN-LAST:event_buttonUpdateRecordActionPerformed

    private void buttonCloseWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseWActionPerformed
        // Close frame
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonCloseWActionPerformed

    private void JCSTATUESFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCSTATUESFocusGained

        try {

        Connection conn = myConnection.getConnect();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT breeding FROM tbl_breeding");

        while(rs.next()){

            JCSTATUES.addItem(rs.getString("breeding"));

        }
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
        //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }

    }//GEN-LAST:event_JCSTATUESFocusGained

    private void tfsixsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfsixsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfsixsActionPerformed

    private void buttonChangeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeImageActionPerformed
        // Resize image and fetch image

        // Browse Image
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        //Filter Image formate selection
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*images", "jpg", "png");
        file.addChoosableFileFilter(fnef);
        int result = file.showSaveDialog(null);
        
        // If the user clicks save button in JChooser
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedPhoto = file.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();
            labelImage.setIcon(resizeImage(path, null));
            this.photopath = path;

        } else {
            System.out.println("Photo not selected!");
        }
    }//GEN-LAST:event_buttonChangeImageActionPerformed

    private void JCPADDOCKFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCPADDOCKFocusGained
        // TODO add your handling code here:
         // Populate JCombobox
        
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     JCPADDOCK.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException  e) {
                System.err.println(e.getMessage());
           //     JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_JCPADDOCKFocusGained

    private void JCHERDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCHERDFocusGained
         // Fill Textfield when choosing cattle ID in JComboBox
       
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c_herdtype FROM tbl_cattle_info");
                 
                 while(rs.next()){
                   
                     JCHERD.addItem(rs.getString("c_herdtype"));
                } 
            } catch (SQLException | HeadlessException  e) {
                System.err.println(e.getMessage());
           //     JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_JCHERDFocusGained

    private void buttonCloseW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseW1ActionPerformed
        // Clear Fields
        this.dispose();
        new UpdateCattle().setVisible(true);
    }//GEN-LAST:event_buttonCloseW1ActionPerformed

 
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
            java.util.logging.Logger.getLogger(UpdateCattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCattle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBREED;
    private javax.swing.JComboBox<String> JCGENDERW;
    private javax.swing.JComboBox<String> JCHERD;
    private javax.swing.JComboBox<String> JCID;
    private javax.swing.JComboBox<String> JCPADDOCK;
    private javax.swing.JComboBox<String> JCSTATUES;
    private javax.swing.JComboBox<String> JCSTUDW;
    private javax.swing.JTextField TFNAME;
    private javax.swing.JButton buttonChangeImage;
    private javax.swing.JButton buttonCloseW;
    private javax.swing.JButton buttonCloseW1;
    private javax.swing.JButton buttonSearchRecord;
    private javax.swing.JButton buttonUpdateRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField tffive;
    private javax.swing.JTextField tffour;
    private javax.swing.JTextField tfone;
    private javax.swing.JTextField tfseven;
    private javax.swing.JTextField tfsixs;
    private javax.swing.JTextField tfthree;
    private javax.swing.JTextField tftwo;
    // End of variables declaration//GEN-END:variables
}
