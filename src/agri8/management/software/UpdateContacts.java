
package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import static javax.management.openmbean.SimpleType.INTEGER;
import javax.swing.JOptionPane;


public class UpdateContacts extends javax.swing.JFrame {

      MySQLConnect myConnection;
      
    public UpdateContacts() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        IDCombobox();
        
        ONEC.setEditable(false);
        TWOC.setEditable(false);
        THREEC.setEditable(false);
        FOURC.setEditable(false);
        FIVEC.setEditable(false);
        SIXSC.setEditable(false);
        SEVENC.setEditable(false);
        EIGHTC.setEditable(false);
        NINEC.setEditable(false);
        TENC.setEditable(false);
        
        
        
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
    private void IDCombobox() {
        
           
        try {
                 
                Connection conn = myConnection.getConnect();
               
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c_id FROM tbl_company_reg");
                 
                 while(rs.next()){
                     
                     jcIDC.addItem(rs.getString("c_id"));
                    
                } 
            } catch (SQLException | HeadlessException  e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            } 
        
    } 
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ONEC = new javax.swing.JTextField();
        THREEC = new javax.swing.JTextField();
        TWOC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SIXSC = new javax.swing.JTextField();
        FIVEC = new javax.swing.JTextField();
        FOURC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        EIGHTC = new javax.swing.JTextField();
        NINEC = new javax.swing.JTextField();
        TENC = new javax.swing.JTextField();
        SEVENC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        EMAILC = new javax.swing.JTextField();
        jcIDC = new javax.swing.JComboBox<>();
        buttonSearchE = new javax.swing.JButton();
        buttonCloseE = new javax.swing.JButton();
        buttonClearE = new javax.swing.JButton();
        buttonUpdateE = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        threec = new javax.swing.JTextField();
        twoc = new javax.swing.JTextField();
        onec = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        sixsc = new javax.swing.JTextField();
        fivec = new javax.swing.JTextField();
        fourc = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ninec = new javax.swing.JTextField();
        tenc = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        sevenc = new javax.swing.JComboBox<>();
        eightc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailc = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CURRENT CONTACT INFORMATION"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Contact ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Contact Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contact Number:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Company Name:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Company Vat Nr:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Company Reg Nr:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Supplier Category:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Street Address:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("City / Town");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Postal Code:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Company Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ONEC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TWOC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(THREEC, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FOURC, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FIVEC, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SIXSC, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EMAILC, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EIGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(NINEC)
                    .addComponent(TENC)
                    .addComponent(SEVENC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(FOURC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(FIVEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SIXSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(EMAILC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7)
                            .addGap(22, 22, 22)
                            .addComponent(jLabel8)
                            .addGap(8, 8, 8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ONEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(TWOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(THREEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel9)
                                        .addComponent(SEVENC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel10)
                                        .addComponent(EIGHTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel11)
                                        .addComponent(NINEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(TENC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jcIDC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        buttonSearchE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchE.setText("SEARCH");
        buttonSearchE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchEActionPerformed(evt);
            }
        });

        buttonCloseE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonCloseE.setText("CLOSE");
        buttonCloseE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseEActionPerformed(evt);
            }
        });

        buttonClearE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear16.png"))); // NOI18N
        buttonClearE.setText("CLEAR");
        buttonClearE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearEActionPerformed(evt);
            }
        });

        buttonUpdateE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateE.setText("UPDATE");
        buttonUpdateE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateEActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "UPDATE CONTACT INFORMATION"));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Contact ID:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Contact Name:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Contact Number:");

        threec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                threecFocusGained(evt);
            }
        });

        twoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                twocFocusGained(evt);
            }
        });

        onec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onecFocusGained(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Company Name:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Company Vat Nr:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Company Reg Nr:");

        sixsc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sixscFocusGained(evt);
            }
        });
        sixsc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sixscKeyReleased(evt);
            }
        });

        fivec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fivecFocusGained(evt);
            }
        });
        fivec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fivecKeyPressed(evt);
            }
        });

        fourc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fourcFocusGained(evt);
            }
        });
        fourc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fourcKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Supplier Category:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Street Address");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("City / Town:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Postal Code:");

        ninec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ninecFocusGained(evt);
            }
        });

        tenc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tencFocusGained(evt);
            }
        });
        tenc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tencKeyPressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("AGRI8 Assist: In this section the user can change and update Contact information");

        sevenc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        sevenc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sevencFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Company Email:");

        emailc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailcKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(75, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(threec, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(twoc)
                            .addComponent(onec))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sixsc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fivec, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fourc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(emailc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ninec)
                            .addComponent(tenc)
                            .addComponent(sevenc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eightc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(fourc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(fivec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(sixsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(emailc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(onec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(twoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(threec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(sevenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(eightc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(ninec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(tenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("Search Contact ID:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("UPDATE CONTACTS INFORMATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jcIDC, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSearchE, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel26)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcIDC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearchE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(buttonUpdateE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearEActionPerformed
        // CLEAR ALL FILEDS
        
        jcIDC.setSelectedIndex(-1);
        ONEC.setText("");
        TWOC.setText("");
        THREEC.setText("");
        FOURC.setText("");
        FIVEC.setText("");
        SIXSC.setText("");
        EMAILC.setText("");
        SEVENC.setText("");
        EIGHTC.setText("");
        NINEC.setText("");
        TENC.setText("");
       
        
        onec.setText("");
        twoc.setText("");
        threec.setText("");
        fourc.setText("");
        fivec.setText("");
        sixsc.setText("");
        emailc.setText("");
        sevenc.setSelectedIndex(-1);
        eightc.setText("");
        ninec.setText("");
        tenc.setText("");
        
    }//GEN-LAST:event_buttonClearEActionPerformed

    private void buttonSearchEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchEActionPerformed
      
        
        Connection conn = myConnection.getConnect();
        String EMPID = (String) jcIDC.getSelectedItem();
      
     if(EMPID.trim().isEmpty() || EMPID.equals("SELECT")) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            jcIDC.setBackground(Color.LIGHT_GRAY);
            jcIDC.requestFocus();
            
        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT c_id, c_name, c_number, c_comp_name, c_vat, c_reg, c_email, c_category, c_street, c_city, c_area "
                        + "FROM tbl_company_reg WHERE c_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, EMPID);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();
                
                if (rs.next()) {

                    ONEC.setText(rs.getString("c_id"));                         
                    TWOC.setText(rs.getString("c_name"));                           
                    THREEC.setText(rs.getString("c_number"));                        
                    FOURC.setText(rs.getString("c_comp_name"));                     
                    FIVEC.setText(rs.getString("c_vat"));
                    SIXSC.setText(rs.getString("c_reg")); 
                    EMAILC.setText(rs.getString("c_email"));
                    SEVENC.setText(rs.getString("c_category"));
                    EIGHTC.setText(rs.getString("c_street"));             
                    NINEC.setText(rs.getString("c_city"));
                    TENC.setText(rs.getString("c_area"));
                    
                    onec.setText(rs.getString("c_id"));                         
                    twoc.setText(rs.getString("c_name"));                           
                    threec.setText(rs.getString("c_number"));                                            
                    fourc.setText(rs.getString("c_comp_name"));
                    fivec.setText(rs.getString("c_vat"));
                    sixsc.setText(rs.getString("c_reg"));    
                    emailc.setText(rs.getString("c_email"));
                    sevenc.setSelectedItem(rs.getString("c_category"));   
                    eightc.setText(rs.getString("c_street"));
                    ninec.setText(rs.getString("c_city"));
                    tenc.setText(rs.getString("c_area"));
                    
                    onec.requestFocus(true);
                    
                }
                conn.close();

            } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
        
        
    }//GEN-LAST:event_buttonSearchEActionPerformed

    private void buttonCloseEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseEActionPerformed
        this.dispose();
        new ClassFinancialEmp().setVisible(true);
    }//GEN-LAST:event_buttonCloseEActionPerformed

    private void buttonUpdateEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateEActionPerformed
         Connection conn = myConnection.getConnect();
        
        String EMPID = (String) jcIDC.getSelectedItem();
        String ONEC =  onec.getText().trim();          
        String TWOC =  twoc.getText().trim();      
        String THREEC = threec.getText().trim();               
        String FOURC = fourc.getText().trim();     
        String SIXSC = sixsc.getText().trim();         
        String EMAILC = emailc.getText().trim();
        String SEVENC = (String) sevenc.getSelectedItem();
        String EIGHTC = eightc.getText().trim(); 
        String NINEC = ninec.getText().trim();         
        String TENC = tenc.getText().trim();        
       
     
         if(jcIDC.getSelectedItem() == null || EMPID.equals("SELECT") ) {
            JOptionPane.showMessageDialog(null, "Please search Contact ID to update!", "AGRI8 ASSIST: CONTACT ID!", JOptionPane.ERROR_MESSAGE);
            jcIDC.requestFocus();
         } else if (ONEC.isEmpty() || TWOC.isEmpty() || THREEC.isEmpty() || FOURC.isEmpty() ||EMAILC.isEmpty() ||
                SEVENC.equals("SELECT") || EIGHTC.isEmpty() || NINEC.isEmpty() || TENC.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Please complete (*) mandatory fields!", "AGRI8 ASSIST: ENTER MANDATORY FIELDS!", JOptionPane.ERROR_MESSAGE);
        }else {
   
            try {

                String query = "UPDATE tbl_company_reg SET " +
                "c_id= '" + ONEC + "', c_name = '" + TWOC + "', c_number = '" + THREEC + "', c_comp_name= '" + FOURC + "', c_vat = ?, c_reg = ?, c_email = '" + EMAILC + "', c_category = '" 
                        + SEVENC + "', c_street = '" + EIGHTC + "', c_city = '" + NINEC + "', c_area = '" + TENC + "'" + " WHERE c_id= '" + EMPID + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
                
                try{
                      // Accept Null excption from string to Integer
                     if ( fivec.getText().isEmpty() || fivec.getText() == null) { 
                         statement.setNull(1, Types.NULL);
                        } else {
                             statement.setBigDecimal(1, BigDecimal.valueOf(Long.parseLong(fivec.getText().trim())));
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
                 
                          try{
                      // Accept Null excption from string to Integer
                     if ( sixsc.getText() != null ) { 
                            
                            statement.setString(2, SIXSC);
                      
                        } else {  
                          statement.setNull(2, Types.NULL);
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
                  
                int i = statement.executeUpdate();
                
                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + EMPID + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassFinancialEmp().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.print("System or Database error: " + e);
            }
            
         }
        
    }//GEN-LAST:event_buttonUpdateEActionPerformed

    private void fourcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fourcKeyPressed
         
    }//GEN-LAST:event_fourcKeyPressed

    private void fivecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fivecKeyPressed
            //Accept only Integers
        String number = fivec.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                fivec.setEditable(true);
            } else {
                 fivec.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                fivec.setEditable(true);
            } else {
                fivec.setEditable(false);
            }
        }
    }//GEN-LAST:event_fivecKeyPressed

    private void sixscKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sixscKeyReleased
            // Set Email address to lower case
        
        int email = sixsc.getCaretPosition();
                sixsc.setText(sixsc.getText().toLowerCase());
                SIXSC.setCaretPosition(email);
   
  
    }//GEN-LAST:event_sixscKeyReleased

    private void onecFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_onecFocusGained
        onec.setText("");
    }//GEN-LAST:event_onecFocusGained

    private void twocFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_twocFocusGained
        twoc.setText("");
    }//GEN-LAST:event_twocFocusGained

    private void threecFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_threecFocusGained
        threec.setText("");
    }//GEN-LAST:event_threecFocusGained

    private void fourcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fourcFocusGained
        fourc.setText("");
    }//GEN-LAST:event_fourcFocusGained

    private void fivecFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fivecFocusGained
       fivec.setText("");
       
    }//GEN-LAST:event_fivecFocusGained

    private void sixscFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sixscFocusGained
        sixsc.setText("");
    }//GEN-LAST:event_sixscFocusGained

    private void ninecFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ninecFocusGained
       ninec.setText("");
    }//GEN-LAST:event_ninecFocusGained

    private void tencFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tencFocusGained
        tenc.setText("");
    }//GEN-LAST:event_tencFocusGained

    private void tencKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tencKeyPressed
         // Set JTextfield to accept only Integers of a certain Length
        // for contact number in registration page
        
        String number = tenc.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                tenc.setEditable(true);
            } else {
                 tenc.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                tenc.setEditable(true);
            } else {
               tenc.setEditable(false);
            }
        }
    }//GEN-LAST:event_tencKeyPressed

    private void emailcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailcKeyReleased
             // Set Email address to lower case
        
        int email = emailc.getCaretPosition();
                emailc.setText(emailc.getText().toLowerCase());
                emailc.setCaretPosition(email);
   
    }//GEN-LAST:event_emailcKeyReleased

    private void sevencFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sevencFocusGained
        // Fill Textfield when choosing Company category in JComboBox
       
         try {
                 
                Connection conn = myConnection.getConnect();
                
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT category FROM tbl_company ORDER BY category ASC");
                 
                 while(rs.next()){
                   
                     sevenc.addItem(rs.getString("category"));
                } 
            } catch (SQLException | HeadlessException  e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
           
    }//GEN-LAST:event_sevencFocusGained


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
            java.util.logging.Logger.getLogger(UpdateContacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateContacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateContacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateContacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateContacts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EIGHTC;
    private javax.swing.JTextField EMAILC;
    private javax.swing.JTextField FIVEC;
    private javax.swing.JTextField FOURC;
    private javax.swing.JTextField NINEC;
    private javax.swing.JTextField ONEC;
    private javax.swing.JTextField SEVENC;
    private javax.swing.JTextField SIXSC;
    private javax.swing.JTextField TENC;
    private javax.swing.JTextField THREEC;
    private javax.swing.JTextField TWOC;
    private javax.swing.JButton buttonClearE;
    private javax.swing.JButton buttonCloseE;
    private javax.swing.JButton buttonSearchE;
    private javax.swing.JButton buttonUpdateE;
    private javax.swing.JTextField eightc;
    private javax.swing.JTextField emailc;
    private javax.swing.JTextField fivec;
    private javax.swing.JTextField fourc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcIDC;
    private javax.swing.JTextField ninec;
    private javax.swing.JTextField onec;
    private javax.swing.JComboBox<String> sevenc;
    private javax.swing.JTextField sixsc;
    private javax.swing.JTextField tenc;
    private javax.swing.JTextField threec;
    private javax.swing.JTextField twoc;
    // End of variables declaration//GEN-END:variables
}
