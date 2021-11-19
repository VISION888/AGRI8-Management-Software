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
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UpdateWeaner extends javax.swing.JFrame {

    MySQLConnect myConnection;    
    
    public UpdateWeaner() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        TFID.requestFocus();
    }

     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
       private void herdGroup() {
        // Fill Textfield when choosing herdgroup in JComboBox
       
         try {
                 
               
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype");
                 
                 while(rs.next()){
                   
                     JCHERD.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
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
            } catch (SQLException | HeadlessException | NullPointerException e) {
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
        tftwo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfEight = new javax.swing.JTextField();
        tfSeven = new javax.swing.JTextField();
        tfSixs = new javax.swing.JTextField();
        tfthree = new javax.swing.JTextField();
        JCPADDOCK = new javax.swing.JComboBox<>();
        JCSTUDW = new javax.swing.JComboBox<>();
        JCHERD = new javax.swing.JComboBox<>();
        JCTYPE = new javax.swing.JComboBox<>();
        TFID = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        TFSALE = new com.toedter.calendar.JDateChooser();
        tfEleven = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TFSIRE = new javax.swing.JTextField();
        tfTwelve = new javax.swing.JTextField();
        TFDAM = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        buttonCloseW = new javax.swing.JButton();
        buttonUpdateRecord = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        JCBREED = new javax.swing.JComboBox<>();
        tfFour = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TFDOB = new com.toedter.calendar.JDateChooser();
        tfFive = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfNine = new javax.swing.JTextField();
        TFBW = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfww = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        TFWW = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        weandate = new javax.swing.JTextField();
        WeanDate = new com.toedter.calendar.JDateChooser();
        buttonCloseW1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("UPDATE WEANER RECORDS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1160, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("*TAG ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Name:");

        tfone.setEditable(false);
        tfone.setNextFocusableComponent(JCGENDERW);

        TFNAME.setNextFocusableComponent(JCGENDERW);

        JCGENDERW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Dam (Female)", "Sire (Male)", "Other" }));
        JCGENDERW.setNextFocusableComponent(JCPADDOCK);

        tftwo.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("*Gender:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("*Paddock:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("*Stud / Com:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("*Herd Group:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("*Weaner Type:");

        tfEight.setEditable(false);

        tfSeven.setEditable(false);

        tfSixs.setEditable(false);

        tfthree.setEditable(false);

        JCPADDOCK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        JCPADDOCK.setNextFocusableComponent(JCSTUDW);

        JCSTUDW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Sire Commercial Dam)", "Stud / Com (Stud Dam, Commercial Sire)" }));
        JCSTUDW.setNextFocusableComponent(JCHERD);

        JCHERD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        JCHERD.setNextFocusableComponent(JCTYPE);
        JCHERD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCHERDFocusGained(evt);
            }
        });

        JCTYPE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "1. Mating Bulls - Farm keep (Stud)", "2. Mating Bulls - Sale (Stud)", "3.Commercial Bulls - Farm keep", "4. Commerical Bulls - Sales", "5. Steers - Sales (Feedlot)", "6. Steers - Sales (Backgrounding)", "7. Steers - Sales (Backgrouding + Feedlot)", "8. Stud Bull - Commercial Sale", "9. Stud Bull - Stud Sale", "10. Open Mating Heifers - Farm keep", "11. Open Mating Heifers - Sale", "12. Commercial Heifers - Farm keep", "13. Commerical Heifers - Sales", "14. Stud Heifers - Commercial Sale", "15. Stud Heifers - Stud Sale", "16. Other", " ", " " }));

        TFID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        TFID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFIDFocusGained(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Sale / Mating Date:");

        tfTen.setEditable(false);
        tfTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenActionPerformed(evt);
            }
        });

        TFSALE.setDateFormatString("yyyy-MM-dd");
        TFSALE.setNextFocusableComponent(TFSIRE);

        tfEleven.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Sire ID:");

        TFSIRE.setNextFocusableComponent(TFDAM);
        TFSIRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFSIREActionPerformed(evt);
            }
        });

        tfTwelve.setEditable(false);
        tfTwelve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTwelveActionPerformed(evt);
            }
        });

        TFDAM.setNextFocusableComponent(buttonUpdateRecord);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Dam ID:");

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

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("*Breed:");

        JCBREED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrikaner", "Angus", "Ankole", "Beefmaster", "Bonsmara", "Boran", "Brahman", "Braunivieh", "Charolais", "Drakensberger", "Hereford", "Limousin", "Nguni", "Other", "Santa Gertrudis", "Shorthorn", "Simbra", "Simmentaler", "Susses", "Tuli", "Wagyu" }));

        tfFour.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("*Date of Birth:");

        TFDOB.setDateFormatString("yyyy-MM-dd");

        tfFive.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Birth Weight:");

        tfNine.setEditable(false);
        tfNine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNineKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("AGRI8 Assist: All fields marked with (*) are Mandatory before updating!");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Kg");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Kg");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Wean Weight:");

        tfww.setEditable(false);
        tfww.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfwwActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Kg");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Kg");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Wean Date:");

        weandate.setEditable(false);

        WeanDate.setDateFormatString("yyyy-MM-dd");

        buttonCloseW1.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseW1.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseW1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear16.png"))); // NOI18N
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCloseW1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(54, 54, 54)
                                    .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfFour, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfFive, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSixs, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JCGENDERW, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .addComponent(JCPADDOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel15)))
                        .addGap(230, 230, 230)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBREED, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(242, 242, 242)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCSTUDW, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCHERD, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEight, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfww, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNine, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21)))
                    .addComponent(weandate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFSIRE)
                    .addComponent(TFDAM)
                    .addComponent(JCTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFBW, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFWW, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(TFSALE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WeanDate, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCloseW1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(tfEight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCGENDERW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(tfNine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(TFBW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCPADDOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addComponent(JCBREED, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfFour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfFive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfSixs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JCSTUDW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(tfSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JCHERD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(tfww, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFWW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(weandate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23))
                            .addComponent(WeanDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(TFSALE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFSIRE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFDAM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1150, 470));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgmoneybale.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1270, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSearchRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchRecordActionPerformed

        Connection conn = myConnection.getConnect();
        String searchID = (String) TFID.getSelectedItem();
      
     if(searchID.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            TFID.setBackground(Color.LIGHT_GRAY);
            TFID.requestFocus();
            
        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT w_name, w_gender, w_breed, w_dob, w_paddock, w_studcom, w_herdtype, w_type, w_birthweight, w_weanweight, w_weandate, "
                        + "w_salemate, w_sire, w_dam FROM tbl_weaner_info WHERE w_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, searchID);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {

                    tfone.setText(rs.getString("w_name"));                         
                    tftwo.setText(rs.getString("w_gender"));                           
                    tfthree.setText(rs.getString("w_paddock"));
                    tfFour.setText(rs.getString("w_breed"));                     
                    tfFive.setText(rs.getString("w_dob")); 
                    tfSixs.setText(rs.getString("w_studcom"));                     
                    tfSeven.setText(rs.getString("w_herdtype"));                       
                    tfEight.setText(rs.getString("w_type"));
                    tfNine.setText(rs.getString("w_birthweight"));
                    tfww.setText(rs.getString("w_weanweight"));
                    weandate.setText(rs.getString("w_weandate"));
                    tfTen.setText(rs.getString("w_salemate"));
                    tfEleven.setText(rs.getString("w_sire"));
                    tfTwelve.setText(rs.getString("w_dam"));
                    herdGroup();
                    Paddock();
                    TFID.setBackground(Color.WHITE);
            

                } else {

                    JOptionPane.showMessageDialog(null, "ID not Found, Please try again!");
                }

                conn.close();

            } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonSearchRecordActionPerformed

    private void buttonUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateRecordActionPerformed
        // Update Weaner Records

        Connection conn = myConnection.getConnect();
        String searchID = (String) TFID.getSelectedItem();
        String TFONE = TFNAME.getText().trim();
        String TFTWO = (String) JCGENDERW.getSelectedItem();
        String TFTHREE = (String) JCPADDOCK.getSelectedItem();
        String TFFOUR = (String) JCBREED.getSelectedItem();
        
        String TFSIX = (String) JCSTUDW.getSelectedItem();
        String TFSEVEN = (String) JCHERD.getSelectedItem();
        String TFEIGHT = (String) JCTYPE.getSelectedItem();
        //Integer TFNINE = Integer.valueOf(TFBW.getText());
        String TFTEN = TFSIRE.getText().trim();
        String TFELEVEN = TFDAM.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
           try {
            sdf.format(TFDOB.getDate());
            sdf.format(WeanDate.getDate());
            sdf.format(TFSALE.getDate());
           
        }catch (NullPointerException e) {
            System.out.print("null pointer expection" + e);
        }
        
        if(searchID.isEmpty()) {

            JOptionPane.showMessageDialog(null, " Please Enter ID to Update!", "ID Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            TFID.grabFocus();
            TFID.setBackground(Color.LIGHT_GRAY);
            
        } else if(TFTWO.isEmpty() || TFTWO.equals("SELECT") || TFTHREE.isEmpty() || TFTHREE.equals("SELECT") || TFFOUR.isEmpty() || TFFOUR.equals("SELECT") ||
                TFSIX.isEmpty() || TFSIX.equals("SELECT") || TFSEVEN.isEmpty() || TFSEVEN.equals("SELECT") || TFEIGHT.isEmpty() || TFEIGHT.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select all (*) Mandatory fields!", "AGRI8 ASSIST: SELECT ALL MANDITORY FIELDS", JOptionPane.ERROR_MESSAGE);
        } else if(TFTWO.isEmpty() || TFTWO.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select GENDER!", "AGRI8 ASSIST: GENDER NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFTHREE.isEmpty() || TFTHREE.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select PADDOCK!", "AGRI8 ASSIST: PADDOCK NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        }else if(TFFOUR.isEmpty() || TFFOUR.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select BREED!", "AGRI8 ASSIST: BREED NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFDOB.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please Select DATE-OF-BIRTH!", "AGRI8 ASSIST: DATE-OF-BIRTH NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFSIX.isEmpty() || TFSIX.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select STUD / COM!", "AGRI8 ASSIST: STUD / COM NOT SELECTED", JOptionPane.ERROR_MESSAGE);    
        } else if(TFSEVEN.isEmpty() || TFSEVEN.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select HERD GROUP!", "AGRI8 ASSIST: HERD GROUP NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFEIGHT.isEmpty() || TFEIGHT.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select TYPE!", "AGRI8 ASSIST: TYPE NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(TFSALE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please Select SALES  / MATING DATE", "AGRI8 ASSIST: DATE NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if ( WeanDate.getDate() == null){ 
           JOptionPane.showMessageDialog(null, "Please Select WEANING DATE", "AGRI8 ASSIST: DATE NOT SELECTED", JOptionPane.ERROR_MESSAGE);
    
        } else {
            
            try {

                String query = "UPDATE tbl_weaner_info SET " +
                "w_name ='" + TFONE + "', w_gender= '" + TFTWO + "', w_paddock = '" + TFTHREE + "', w_breed= '" + TFFOUR + "', w_dob= '" + sdf.format(TFDOB.getDate())+ "', w_studcom= '" + TFSIX + "', w_herdtype = '" + TFSEVEN + "', w_type = '" + TFEIGHT + "', w_birthweight = ?, w_weanweight = ?, w_weandate= '"
                        + sdf.format(TFSALE.getDate()) + "', w_salemate = '" + sdf.format(TFSALE.getDate()) + "', w_sire = '" + TFTEN + "', w_dam = '" + TFELEVEN + "'" + " WHERE w_id= '" + searchID + "'";

                PreparedStatement psm = conn.prepareStatement(query);
       
                   // Accept Null excption from string to Integer
                     if ( TFBW.getText().isEmpty() ) {
                        psm.setNull(1, Types.INTEGER);
                      } else {
                    psm.setInt(1, Integer.parseInt(TFBW.getText()));
                      }
                
                   // Accept Null excption from string to Integer
                     if ( TFWW.getText().isEmpty() ) {
                        psm.setNull(2, Types.INTEGER);
                      } else {
                    psm.setInt(2, Integer.parseInt(TFWW.getText()));
                      }
                
                
                int i = psm.executeUpdate();

                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + searchID + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new UpdateWeaner().setVisible(true);
                }
                
            } catch (SQLException  | HeadlessException | NullPointerException e ) {
                System.out.print("System Error exception" + e.getMessage());
            }
        }
    }//GEN-LAST:event_buttonUpdateRecordActionPerformed

    private void buttonCloseWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseWActionPerformed
        // Close frame
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonCloseWActionPerformed

    private void TFIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFIDFocusGained

        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT w_id FROM tbl_weaner_info");

            while(rs.next()){

                TFID.addItem(rs.getString("w_id"));
            }
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_TFIDFocusGained

    private void TFSIREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFSIREActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFSIREActionPerformed

    private void tfTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenActionPerformed

    private void tfNineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNineKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNineKeyPressed

    private void tfTwelveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTwelveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTwelveActionPerformed

    private void tfwwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfwwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfwwActionPerformed

    private void JCHERDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCHERDFocusGained
        
           try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     JCHERD.addItem(rs.getString("herdtype"));
                    
                } 
                 conn.close();
                 
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Herd Group System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
   
    }//GEN-LAST:event_JCHERDFocusGained

    private void buttonCloseW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseW1ActionPerformed
        this.dispose();
        new UpdateWeaner().setVisible(true);
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
            java.util.logging.Logger.getLogger(UpdateWeaner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateWeaner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateWeaner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateWeaner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateWeaner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBREED;
    private javax.swing.JComboBox<String> JCGENDERW;
    private javax.swing.JComboBox<String> JCHERD;
    private javax.swing.JComboBox<String> JCPADDOCK;
    private javax.swing.JComboBox<String> JCSTUDW;
    private javax.swing.JComboBox<String> JCTYPE;
    private javax.swing.JTextField TFBW;
    private javax.swing.JTextField TFDAM;
    private com.toedter.calendar.JDateChooser TFDOB;
    private javax.swing.JComboBox<String> TFID;
    private javax.swing.JTextField TFNAME;
    private com.toedter.calendar.JDateChooser TFSALE;
    private javax.swing.JTextField TFSIRE;
    private javax.swing.JTextField TFWW;
    private com.toedter.calendar.JDateChooser WeanDate;
    private javax.swing.JButton buttonCloseW;
    private javax.swing.JButton buttonCloseW1;
    private javax.swing.JButton buttonSearchRecord;
    private javax.swing.JButton buttonUpdateRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfEight;
    private javax.swing.JTextField tfEleven;
    private javax.swing.JTextField tfFive;
    private javax.swing.JTextField tfFour;
    private javax.swing.JTextField tfNine;
    private javax.swing.JTextField tfSeven;
    private javax.swing.JTextField tfSixs;
    private javax.swing.JTextField tfTen;
    private javax.swing.JTextField tfTwelve;
    private javax.swing.JTextField tfone;
    private javax.swing.JTextField tfthree;
    private javax.swing.JTextField tftwo;
    private javax.swing.JTextField tfww;
    private javax.swing.JTextField weandate;
    // End of variables declaration//GEN-END:variables
}
