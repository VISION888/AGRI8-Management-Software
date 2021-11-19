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


public class AddWeanerGoats extends javax.swing.JFrame {

    MySQLConnect myConnection;
  
    public AddWeanerGoats() {
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
        labelHeading = new javax.swing.JLabel();
        labelBg = new javax.swing.JLabel();

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

        JCSTUDW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Com Ewe)", "Stud / Com (Stud Ewe, Com Ram)" }));

        TFWDATE.setDateFormatString("yyyy-MM-dd");

        buttonSaveW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
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

        JCBREED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Angora", "Boer Goat", "British Alpine", "Indigenous Veld Goat ", "Kalahari Red", "Milch Goat", "Saanen", "Savannah White ", "Tankwa", "Toggenburg" }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCHERDW, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JCSTUDW, 0, 1, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel26))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JCBREED, javax.swing.GroupLayout.Alignment.LEADING, 0, 186, Short.MAX_VALUE)
                                    .addComponent(JCGENDERW, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TFNAMEW, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFIDW, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCPADDOCKW, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(TFDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel16))
                                    .addGap(51, 51, 51)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JCTYPE, 0, 1, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(TFBIRTHWEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel17))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(TFWEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel15)))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TFDAM)
                                        .addComponent(TFWDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TFSALEDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TFSIRE, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(buttonSaveW, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonClearW, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(TFIDW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFNAMEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCPADDOCKW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(JCSTUDW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JCHERDW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JCGENDERW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(JCBREED, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(TFDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JCTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(TFWEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(TFBIRTHWEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(TFWDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(TFSALEDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(TFSIRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(TFDAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(buttonSaveW, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonClearW, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCloseW, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addComponent(jLabel7)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 830, 430));

        labelHeading.setBackground(new java.awt.Color(255, 255, 255));
        labelHeading.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelHeading.setForeground(new java.awt.Color(255, 255, 255));
        labelHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeading.setText("Add Weaner Information");
        getContentPane().add(labelHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 960, 50));

        labelBg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kids.jpg"))); // NOI18N
        getContentPane().add(labelBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 960, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearWActionPerformed
        // Clear Mating Frame
        
           
          this.dispose();
          new AddWeanerGoats().setVisible(true);
    }//GEN-LAST:event_buttonClearWActionPerformed

    private void buttonSaveWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveWActionPerformed
        // Save new mating record to database
       
        
        Connection conn = myConnection.getConnect();
        
         String gwid = TFIDW.getText().trim();
         String gwname = TFNAMEW.getText().trim();
         String  gwgender= (String) JCGENDERW.getSelectedItem();
         String  gwbreed= (String) JCBREED.getSelectedItem();
         Date gdob = TFDOB.getDate();
         String gwpaddock = (String) JCPADDOCKW.getSelectedItem();
         String gwstud = (String) JCSTUDW.getSelectedItem();
         String  gwherd = (String) JCHERDW.getSelectedItem();
         String  gwtype= (String) JCTYPE.getSelectedItem();
         //Integer bweight = Integer.parseInt(TFBIRTHWEIGHT.getText().trim());
         //Integer wweight = Integer.parseInt(TFWEIGHT.getText().trim());
         Date gwweandate =  TFWDATE.getDate();
         Date gwsales =  TFSALEDATE.getDate();
         String gwram = TFSIRE.getText().trim();
         String gwewe = TFDAM.getText().trim();
         
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
        if(gwid.isEmpty() || gwgender.equals("SELECT") || gwbreed.equals("SELECT")  || gwpaddock.equals("SELECT")  || gwstud.equals("SELECT")  || gwherd.equals("SELECT")  ||
           gwtype.equals("SELECT"))  {
        
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
                String checkName = "SELECT gw_id FROM tbl_weaner_kids WHERE gw_id = '" + gwid + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If animal tag has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Weaner ID: " + gwid + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new record
                    String saveQuery = "INSERT INTO tbl_weaner_kids(gw_id, gw_name, gw_gender, gw_breed, gw_dob, gw_paddock, gw_studcom, gw_herdtype, gw_type, gw_birthweight, gw_weanweight, "
                            + "gw_weandate, gw_salemate, gw_ram, gw_ewe)" +
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
                    
                    psm.setString(1, gwid);                
                    psm.setString(2, gwname);
                    psm.setString(3, gwgender);
                    psm.setString(4, gwbreed);
                    psm.setString(5, date3);
                    psm.setString(6, gwpaddock);
                    psm.setString(7, gwstud);
                    psm.setString(8, gwherd);
                    psm.setString(9, gwtype);
                    //psm.setString(10, bweight.toString());
                   // psm.setString(11, wweight.toString());
                    psm.setString(12, date1);
                    psm.setString(13, date2);
                    psm.setString(14, gwram);
                    psm.setString(15, gwewe);
                    
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Weaner added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                        this.dispose();
                        new AddWeanerGoats().setVisible(true);
                        
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Weaner record!", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
            
  
            } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());
                 //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
            }
            
        }
    }//GEN-LAST:event_buttonSaveWActionPerformed

    private void buttonCloseWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseWActionPerformed
        // Close frame
        
       this.dispose();
       new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonCloseWActionPerformed

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

    private void TFBIRTHWEIGHTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBIRTHWEIGHTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFBIRTHWEIGHTKeyPressed

    private void TFBIRTHWEIGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFBIRTHWEIGHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFBIRTHWEIGHTActionPerformed

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
            java.util.logging.Logger.getLogger(AddWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWeanerGoats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWeanerGoats().setVisible(true);
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
    private javax.swing.JButton buttonClearW;
    private javax.swing.JButton buttonCloseW;
    private javax.swing.JButton buttonSaveW;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelBg;
    private javax.swing.JLabel labelHeading;
    // End of variables declaration//GEN-END:variables
}
