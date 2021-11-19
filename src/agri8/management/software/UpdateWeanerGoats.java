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


public class UpdateWeanerGoats extends javax.swing.JFrame {

    MySQLConnect myConnection;    
    
    public UpdateWeanerGoats() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        TFID.requestFocus();
        herdGroup();
        Paddock();
    }

     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
       private void herdGroup() {

       
          try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     seven.addItem(rs.getString("herdtype"));
                    
                } 
                 conn.close();
                 
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Herd Group System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }   }
   
   private void Paddock() {
       
       // Populate JCombobox
        
         try {
                 
                 Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     three.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
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
        one = new javax.swing.JTextField();
        two = new javax.swing.JComboBox<>();
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
        three = new javax.swing.JComboBox<>();
        sixs = new javax.swing.JComboBox<>();
        seven = new javax.swing.JComboBox<>();
        eight = new javax.swing.JComboBox<>();
        TFID = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tfeleven = new javax.swing.JTextField();
        tweleve = new com.toedter.calendar.JDateChooser();
        tfthirteen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        thirteen = new javax.swing.JTextField();
        tfourteen = new javax.swing.JTextField();
        fourteen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        buttonCloseW = new javax.swing.JButton();
        buttonUpdateRecord = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        four = new javax.swing.JComboBox<>();
        tfFour = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        five = new com.toedter.calendar.JDateChooser();
        tfFive = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfNine = new javax.swing.JTextField();
        ten = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tften = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        nine = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tftweleve = new javax.swing.JTextField();
        eleven = new com.toedter.calendar.JDateChooser();
        buttonCloseW1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("UPDATE GOAT WEANER RECORDS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1230, -1));

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
        tfone.setNextFocusableComponent(two);

        one.setNextFocusableComponent(two);

        two.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Ewe (Female)", "Ram (Male)", "Other" }));
        two.setNextFocusableComponent(three);

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
        tfEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEightActionPerformed(evt);
            }
        });

        tfSeven.setEditable(false);

        tfSixs.setEditable(false);

        tfthree.setEditable(false);

        three.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        three.setNextFocusableComponent(sixs);

        sixs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Commercial Ewe)", "Stud / Com (Stud Ewe, Commercial Ram)" }));
        sixs.setNextFocusableComponent(seven);

        seven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        seven.setNextFocusableComponent(eight);
        seven.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sevenFocusGained(evt);
            }
        });

        eight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "1. Mating Ram - Farm keep (Stud)", "2. Mating Ram - Sale (Stud)", "3.Commercial Ram - Farm keep", "4. Commerical Ram - Sales", "5. Wether - Sales (Feedlot)", "6. Wether- Sales (Backgrounding)", "7. Wether - Sales (Backgrouding + Feedlot)", "8. Stud Ram - Commercial Sale", "9. Stud Ram - Stud Sale", "10. Open Mating Ewe - Farm keep", "11. Open Mating Ewe - Sale", "12. Commercial Ewe - Farm keep", "13. Commerical Ewe - Sales", "14. Stud Ewe - Commercial Sale", "15. Stud Ewe - Stud Sale", "16. Other", " " }));

        TFID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        TFID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFIDFocusGained(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("*Sale / Mating Date:");

        tfeleven.setEditable(false);
        tfeleven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfelevenActionPerformed(evt);
            }
        });

        tweleve.setDateFormatString("yyyy-MM-dd");
        tweleve.setNextFocusableComponent(thirteen);

        tfthirteen.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ram ID:");

        thirteen.setNextFocusableComponent(fourteen);
        thirteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirteenActionPerformed(evt);
            }
        });

        tfourteen.setEditable(false);
        tfourteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfourteenActionPerformed(evt);
            }
        });

        fourteen.setNextFocusableComponent(buttonUpdateRecord);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Ewe ID:");

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

        four.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Angora", "Boer Goat", "British Alpine", "Indigenous Veld Goat ", "Kalahari Red", "Milch Goat", "Saanen", "Savannah White ", "Tankwa", "Toggenburg" }));

        tfFour.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("*Date of Birth:");

        five.setDateFormatString("yyyy-MM-dd");

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

        tften.setEditable(false);
        tften.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tftenKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Kg");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Kg");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("*Wean Date:");

        tftweleve.setEditable(false);

        eleven.setDateFormatString("yyyy-MM-dd");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel5))
                                                .addComponent(jLabel7)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfFour, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfSixs, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfFive, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(60, 60, 60)
                                        .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(three, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(two, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(one, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sixs, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel26)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(64, 64, 64))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfEight, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfNine, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tften, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(22, 22, 22))
                                .addComponent(tftweleve))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfthirteen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfeleven, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCloseW1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tweleve, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addComponent(eight, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel19))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel22)))
                                    .addGap(21, 21, 21))
                                .addComponent(fourteen)
                                .addComponent(eleven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(thirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSearchRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCloseW1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addComponent(tftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(tfEight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfNine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(1, 1, 1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(tfthree, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(three, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(tfFour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tften, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfeleven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eleven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfFive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfSixs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sixs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfthirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tweleve, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tftweleve, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(23, 23, 23)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tfSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1170, 480));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg3.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1240, 610));

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

                String sql = "SELECT gw_name, gw_gender, gw_paddock, gw_breed, gw_dob, gw_studcom, gw_herdtype, gw_type, gw_birthweight, gw_weanweight, gw_weandate, "
                        + "gw_salemate, gw_ram, gw_ewe FROM tbl_weaner_kids WHERE gw_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, searchID);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {

                    tfone.setText(rs.getString("gw_name"));                         
                    tftwo.setText(rs.getString("gw_gender"));                           
                    tfthree.setText(rs.getString("gw_paddock"));
                    tfFour.setText(rs.getString("gw_breed"));                     
                    tfFive.setText(rs.getString("gw_dob")); 
                    tfSixs.setText(rs.getString("gw_studcom"));                     
                    tfSeven.setText(rs.getString("gw_herdtype"));                       
                    tfEight.setText(rs.getString("gw_type"));
                    tfNine.setText(rs.getString("gw_birthweight"));
                    tften.setText(rs.getString("gw_weanweight"));
                    tftweleve.setText(rs.getString("gw_weandate"));
                    tfeleven.setText(rs.getString("gw_salemate"));
                    tfthirteen.setText(rs.getString("gw_ram"));
                    tfourteen.setText(rs.getString("gw_ewe"));
                   
                    TFID.setBackground(Color.WHITE);
            

                } else {

                    JOptionPane.showMessageDialog(null, "ID not Found, Please try again!");
                }

                conn.close();

            } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonSearchRecordActionPerformed

    private void buttonUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateRecordActionPerformed
        // Update Weaner Records

        Connection conn = myConnection.getConnect();
        String ID = (String) TFID.getSelectedItem();
        String ONE = one.getText().trim();
        String TWO = (String) two.getSelectedItem();
        String THREE = (String) three.getSelectedItem();
        String FOUR = (String) four.getSelectedItem();
        // DATE OF BIRTH FIVE
        String SIX = (String) sixs.getSelectedItem();
        String SEVEN = (String) seven.getSelectedItem();
        String EIGHT = (String) eight.getSelectedItem();
        // BIRTH WEIGHT NINE
        // WEAN WEIGHT TEN
        // WEAN DATE ELEVEN
        // SALES DATE TWELVE
        String THIRTEEN = thirteen.getText().trim();
        String FOURTEEN = fourteen.getText().trim();
        
        String FIVE = null;
        String ELEVEN = null;
        String TWELEVE = null;
        
           try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
            FIVE = sdf.format(five.getDate());
            ELEVEN =  sdf.format(eleven.getDate());
            TWELEVE =  sdf.format(tweleve.getDate());
           
        }catch (NullPointerException e) {
            System.out.print("null pointer expection" + e);
        }
        
        if(ID.equals("SELECT")) {

            JOptionPane.showMessageDialog(null, " Please Enter ID to Update!", "ID Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            TFID.grabFocus();
            TFID.setBackground(Color.LIGHT_GRAY);
            
        } else if(TWO.equals("SELECT") || THREE.equals("SELECT") || FOUR.equals("SELECT") ||
                SIX.equals("SELECT") || SEVEN.equals("SELECT") || EIGHT.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select all (*) Mandatory fields!", "AGRI8 ASSIST: SELECT ALL MANDITORY FIELDS", JOptionPane.ERROR_MESSAGE);
        } else if(TWO.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select GENDER!", "AGRI8 ASSIST: GENDER NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(THREE.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select PADDOCK!", "AGRI8 ASSIST: PADDOCK NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        }else if(FOUR.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select BREED!", "AGRI8 ASSIST: BREED NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(five.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please Select DATE-OF-BIRTH!", "AGRI8 ASSIST: DATE-OF-BIRTH NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(SIX.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select STUD / COM!", "AGRI8 ASSIST: STUD / COM NOT SELECTED", JOptionPane.ERROR_MESSAGE);    
        } else if(SEVEN.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select HERD GROUP!", "AGRI8 ASSIST: HERD GROUP NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(EIGHT.equals("SELECT")) {
            JOptionPane.showMessageDialog(null, "Please Select TYPE!", "AGRI8 ASSIST: TYPE NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else if(eleven.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please Select WEANING DATE", "AGRI8 ASSIST: DATE NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        }else if(tweleve.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please Select SALES  / MATING DATE", "AGRI8 ASSIST: DATE NOT SELECTED", JOptionPane.ERROR_MESSAGE);
        } else {
            
            try {

                String query = "UPDATE tbl_weaner_kids SET " +
                "gw_name ='" + ONE + "', gw_gender= '" + TWO + "', gw_paddock = '" + THREE + "', gw_breed= '" + FOUR + "', gw_dob= '" + FIVE + "', gw_studcom= '" 
                        + SIX + "', gw_herdtype = '" + SEVEN + "', gw_type = '" + EIGHT + "', gw_birthweight = ?, gw_weanweight =?, "
                        + "gw_weandate = '" + ELEVEN + "', gw_salemate = '" + TWELEVE + "', gw_ram = '" + THIRTEEN + "', gw_ewe = '" + FOURTEEN + "'"
                        + " WHERE gw_id= '" + ID + "'";

                PreparedStatement statement = conn.prepareStatement(query);

                             // Accept Null excption from string to Integer
                try { 
                  if ( nine.getText().isEmpty() ) {
                        statement.setNull(1, Types.INTEGER);
                      } else {
                    statement.setInt(1, Integer.parseInt(nine.getText()));
                      }
                } catch (NullPointerException | NumberFormatException e) {
                    
                }
                
                                // Accept Null excption from string to Integer
                try { 
                  if ( ten.getText().isEmpty() ) {
                        statement.setNull(2, Types.INTEGER);
                      } else {
                    statement.setInt(2, Integer.parseInt(ten.getText()));
                      }
                } catch (NullPointerException | NumberFormatException e) {
                    
                }
                
                int i = statement.executeUpdate();

                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + ID + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new UpdateWeanerGoats().setVisible(true);
                }
                
            } catch (SQLException  | HeadlessException | NullPointerException e ) {
                System.out.print("UPDATE ERROR: System Error exception" + e.getMessage());
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
            ResultSet rs = stm.executeQuery("SELECT gw_id FROM tbl_weaner_kids");

            while(rs.next()){

                TFID.addItem(rs.getString("gw_id"));
            }
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_TFIDFocusGained

    private void thirteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirteenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thirteenActionPerformed

    private void tfelevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfelevenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfelevenActionPerformed

    private void tfNineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNineKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNineKeyPressed

    private void tfourteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfourteenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfourteenActionPerformed

    private void tfEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEightActionPerformed

    private void tftenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftenKeyPressed
        
           try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     seven.addItem(rs.getString("herdtype"));
                    
                } 
                 conn.close();
                 
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Herd Group System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
   
    }//GEN-LAST:event_tftenKeyPressed

    private void sevenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sevenFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_sevenFocusGained

    private void buttonCloseW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseW1ActionPerformed
        this.dispose();
        new UpdateWeanerGoats().setVisible(true);
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
            java.util.logging.Logger.getLogger(UpdateWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateWeanerGoats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> TFID;
    private javax.swing.JButton buttonCloseW;
    private javax.swing.JButton buttonCloseW1;
    private javax.swing.JButton buttonSearchRecord;
    private javax.swing.JButton buttonUpdateRecord;
    private javax.swing.JComboBox<String> eight;
    private com.toedter.calendar.JDateChooser eleven;
    private com.toedter.calendar.JDateChooser five;
    private javax.swing.JComboBox<String> four;
    private javax.swing.JTextField fourteen;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nine;
    private javax.swing.JTextField one;
    private javax.swing.JComboBox<String> seven;
    private javax.swing.JComboBox<String> sixs;
    private javax.swing.JTextField ten;
    private javax.swing.JTextField tfEight;
    private javax.swing.JTextField tfFive;
    private javax.swing.JTextField tfFour;
    private javax.swing.JTextField tfNine;
    private javax.swing.JTextField tfSeven;
    private javax.swing.JTextField tfSixs;
    private javax.swing.JTextField tfeleven;
    private javax.swing.JTextField tfone;
    private javax.swing.JTextField tfourteen;
    private javax.swing.JTextField tften;
    private javax.swing.JTextField tfthirteen;
    private javax.swing.JTextField tfthree;
    private javax.swing.JTextField tftweleve;
    private javax.swing.JTextField tftwo;
    private javax.swing.JTextField thirteen;
    private javax.swing.JComboBox<String> three;
    private com.toedter.calendar.JDateChooser tweleve;
    private javax.swing.JComboBox<String> two;
    // End of variables declaration//GEN-END:variables
}
