
package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class UpdateEmp extends javax.swing.JFrame {

      MySQLConnect myConnection;
      
    public UpdateEmp() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();
        IDCombobox();
        
        one.setEditable(false);
        two.setEditable(false);
        three.setEditable(false);
        four.setEditable(false);
        five.setEditable(false);
        sixs.setEditable(false);
        seven.setEditable(false);
        eight.setEditable(false);
        nine.setEditable(false);
        ten.setEditable(false);
        eleven.setEditable(false);
        twelve.setEditable(false);
        
        
        
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
    private void IDCombobox() {
        
           
        try {
                 
                Connection conn = myConnection.getConnect();
               
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT e_id FROM tbl_emp_reg ORDER BY e_id ASC");
                 
                 while(rs.next()){
                     
                     jcIDE.addItem(rs.getString("e_id"));
                    
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
        jLabel4 = new javax.swing.JLabel();
        one = new javax.swing.JTextField();
        three = new javax.swing.JTextField();
        four = new javax.swing.JTextField();
        two = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        eight = new javax.swing.JTextField();
        seven = new javax.swing.JTextField();
        sixs = new javax.swing.JTextField();
        five = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ten = new javax.swing.JTextField();
        eleven = new javax.swing.JTextField();
        twelve = new javax.swing.JTextField();
        nine = new javax.swing.JTextField();
        jcIDE = new javax.swing.JComboBox<>();
        buttonSearchE = new javax.swing.JButton();
        buttonCloseE = new javax.swing.JButton();
        buttonClearE = new javax.swing.JButton();
        buttonUpdateE = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        threee = new javax.swing.JTextField();
        twoe = new javax.swing.JTextField();
        onee = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        eighte = new javax.swing.JTextField();
        sevene = new javax.swing.JTextField();
        sixse = new javax.swing.JTextField();
        fivee = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        elevene = new javax.swing.JTextField();
        twelvee = new javax.swing.JTextField();
        tene = new javax.swing.JComboBox<>();
        foure = new com.toedter.calendar.JDateChooser();
        ninee = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CURRENT EMPLOYEE INFORMATION"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Emp ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Emp Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Emp Surename:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Date-of-Birth:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Emp ID Nr:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Emp Phone:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Emp Email:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Emp Gender:");

        seven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sevenKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Employment Date:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Job Category:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Hourly Rate: R");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Net Salary: R");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(one, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(two, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(four, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixs, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ten, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(eleven)
                    .addComponent(twelve)
                    .addComponent(nine))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sixs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel9)
                                .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel10)
                                .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel11)
                                .addComponent(eleven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(twelve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jcIDE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "UPDATE EMPLOYEE INFORMATION"));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Emp ID:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Emp Name:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Emp Surename:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Date-of-Birth:");

        threee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                threeeFocusGained(evt);
            }
        });

        twoe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                twoeFocusGained(evt);
            }
        });

        onee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                oneeFocusGained(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Emp ID Nr:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Emp Phone:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Emp Email:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Emp Gender:");

        eighte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                eighteFocusGained(evt);
            }
        });

        sevene.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                seveneFocusGained(evt);
            }
        });
        sevene.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seveneKeyReleased(evt);
            }
        });

        sixse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sixseFocusGained(evt);
            }
        });
        sixse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sixseKeyPressed(evt);
            }
        });

        fivee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fiveeFocusGained(evt);
            }
        });
        fivee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fiveeKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Employment Date:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Job Category:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Hourly Rate:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Net Salary:");

        elevene.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                eleveneFocusGained(evt);
            }
        });

        twelvee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                twelveeFocusGained(evt);
            }
        });

        tene.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Farm Manager", "Farm-Hand", "Feedlot Manager", "General Labour", "Part-time Labour", "Stockman", "Other" }));
        tene.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teneFocusGained(evt);
            }
        });
        tene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teneActionPerformed(evt);
            }
        });

        foure.setDateFormatString("yyyy-MM-dd");
        foure.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foureFocusGained(evt);
            }
        });

        ninee.setDateFormatString("yyyy-MM-dd");
        ninee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nineeFocusGained(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("AGRI8 Assist: In this section the user can change and update Employee information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(threee)
                            .addComponent(twoe)
                            .addComponent(onee)
                            .addComponent(foure, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eighte)
                            .addComponent(sevene)
                            .addComponent(sixse)
                            .addComponent(fivee, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(elevene)
                            .addComponent(twelvee)
                            .addComponent(tene, 0, 181, Short.MAX_VALUE)
                            .addComponent(ninee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(fivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(sixse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(sevene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(eighte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(onee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(twoe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(threee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addComponent(foure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ninee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(tene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(elevene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(twelvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("Search Employee ID:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("UPDATE EMPLOYEE INFORMATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jcIDE, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jcIDE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearchE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(buttonUpdateE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCloseE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearEActionPerformed
        // CLEAR ALL FILEDS
        
        jcIDE.setSelectedIndex(-1);
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        sixs.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");
        ten.setText("");
        eleven.setText("");
        twelve.setText("");
        
        onee.setText("");
        twoe.setText("");
        threee.setText("");
        foure.setDate(null);
        fivee.setText("");
        sixse.setText("");
        sevene.setText("");
        eighte.setText("");
        ninee.setDate(null);
        tene.setSelectedItem(-1);
        elevene.setText("");
        twelvee.setText("");
        
        
        
        
    }//GEN-LAST:event_buttonClearEActionPerformed

    private void buttonSearchEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchEActionPerformed
      
        
        Connection conn = myConnection.getConnect();
        String EMPID = (String) jcIDE.getSelectedItem();
      
     if(EMPID.trim().isEmpty() || EMPID.equals("SELECT")) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            jcIDE.setBackground(Color.LIGHT_GRAY);
            jcIDE.requestFocus();
            
        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT e_id, e_name, e_surename, e_dob, e_idnr, e_phone, e_email, e_gender, e_term, e_position, e_hourly, e_salary "
                        + "FROM tbl_emp_reg WHERE e_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, EMPID);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();
                
                if (rs.next()) {

                    one.setText(rs.getString("e_id"));                         
                    two.setText(rs.getString("e_name"));                           
                    three.setText(rs.getString("e_surename"));                        
                    four.setText(rs.getString("e_dob"));                     
                    five.setText(rs.getString("e_idnr"));
                    sixs.setText(rs.getString("e_phone"));
                    seven.setText(rs.getString("e_email"));             
                    eight.setText(rs.getString("e_gender"));
                    nine.setText(rs.getString("e_term"));
                    ten.setText(rs.getString("e_position"));             
                    eleven.setText(rs.getString("e_hourly"));
                    twelve.setText(rs.getString("e_salary"));
                    
                    onee.setText(rs.getString("e_id"));                         
                    twoe.setText(rs.getString("e_name"));                           
                    threee.setText(rs.getString("e_surename"));                        
                    foure.setDate(rs.getDate("e_dob"));                     
                    fivee.setText(rs.getString("e_idnr"));
                    sixse.setText(rs.getString("e_phone"));
                    sevene.setText(rs.getString("e_email"));             
                    eighte.setText(rs.getString("e_gender"));
                    ninee.setDate(rs.getDate("e_term"));
                    tene.setSelectedItem(rs.getString("e_position"));             
                    elevene.setText(rs.getString("e_hourly"));
                    twelvee.setText(rs.getString("e_salary"));
                    
                    one.requestFocus(true);
                    

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

    private void teneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teneActionPerformed

    private void buttonUpdateEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateEActionPerformed
         Connection conn = myConnection.getConnect();
        
        String EMPID = (String) jcIDE.getSelectedItem();
        String ONEE = (String) onee.getText().trim();          
        String TWOE = (String) twoe.getText().trim();      
        String THREEE = (String) three.getText().trim();         
        //Date FOURE =  (Date) foure.getDate();         
        String FIVEE = (String) fivee.getText().trim();        
        String SIXSE = (String) sixse.getText().trim();  
        String SEVENE = (String) sevene.getText().trim();         
        String EIGHTE = (String) eighte.getText().trim();         
        //Date NINEE = (Date) ninee.getDate();        
        String TENE = (String) tene.getSelectedItem();
        String ELEVENE = (String) elevene.getText().trim();         
        String TWELVEE = (String) twelvee.getText().trim();        
       
     
         if(jcIDE.getSelectedItem() == null || EMPID.equals("SELECT") ) {
            JOptionPane.showMessageDialog(null, "Please search Employee ID to update!", "AGRI8 ASSIST: EMPLOYEE ID!", JOptionPane.ERROR_MESSAGE);
            jcIDE.requestFocus();
         } else if (ONEE.isEmpty() || TWOE.isEmpty() || THREEE.isEmpty() || foure == null || FIVEE.isEmpty() || SIXSE.isEmpty() ||
                SEVENE.isEmpty() || EIGHTE.isEmpty() || ninee.equals(null) ||TENE.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, "Please complete all fields!", "AGRI8 ASSIST: FIELDS NOT COMPLETED!", JOptionPane.ERROR_MESSAGE);
        }else {
   
            try {

                String query = "UPDATE tbl_emp_reg SET " +
                "e_id= '" + ONEE + "', e_name = '" + TWOE + "', e_surename = '" + THREEE + "', e_dob= ?, e_idnr= '" + FIVEE + "', e_phone = '" 
                        + SIXSE + "', e_email = '" + SEVENE + "', e_gender = '" + EIGHTE + "', e_term =?, e_position = '" + TENE + "', e_hourly = '" + ELEVENE + "', e_salary = '" + TWELVEE + "'" + " WHERE e_id= '" + EMPID + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
                
                try{
                      // Accept Null excption from string to Integer
                     if ( foure.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(foure.getDate());
                          
                            statement.setString(1, Date1);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select 'DATE-OF-BIRTH'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          statement.setNull(1, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
               
                 
                          try{
                      // Accept Null excption from string to Integer
                     if ( ninee.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(ninee.getDate());
                            statement.setString(2, Date2);
                      
                        } else {  
                          JOptionPane.showMessageDialog(null, "Please select 'EMPLOYEMENT DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                           statement.setNull(2, java.sql.Types.DATE);
                        }
                     
                      } catch (NullPointerException| NumberFormatException e) {
                          
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

    private void fiveeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fiveeKeyPressed
          // Set JTextfield to accept only Integers of a certain Length
        // for contact number in registration page
        
        String number = fivee.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<13) {
                fivee.setEditable(true);
            } else {
                 fivee.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                fivee.setEditable(true);
            } else {
                fivee.setEditable(false);
            }
        }
    }//GEN-LAST:event_fiveeKeyPressed

    private void sixseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sixseKeyPressed
            //Accept only Integers
        String number = sixse.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                sixse.setEditable(true);
            } else {
                 sixse.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                sixse.setEditable(true);
            } else {
                sixse.setEditable(false);
            }
        }
    }//GEN-LAST:event_sixseKeyPressed

    private void seveneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seveneKeyReleased
            // Set Email address to lower case
        
        int email = sevene.getCaretPosition();
                sevene.setText(sevene.getText().toLowerCase());
                seven.setCaretPosition(email);
   
  
    }//GEN-LAST:event_seveneKeyReleased

    private void oneeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oneeFocusGained
        onee.setText("");
    }//GEN-LAST:event_oneeFocusGained

    private void twoeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_twoeFocusGained
        twoe.setText("");
    }//GEN-LAST:event_twoeFocusGained

    private void threeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_threeeFocusGained
        threee.setText("");
    }//GEN-LAST:event_threeeFocusGained

    private void foureFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_foureFocusGained
       foure.setDate(null);
    }//GEN-LAST:event_foureFocusGained

    private void fiveeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fiveeFocusGained
        fivee.setText("");
    }//GEN-LAST:event_fiveeFocusGained

    private void sixseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sixseFocusGained
       sixse.setText("");
    }//GEN-LAST:event_sixseFocusGained

    private void seveneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seveneFocusGained
        sevene.setText("");
    }//GEN-LAST:event_seveneFocusGained

    private void eighteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eighteFocusGained
        eighte.setText("");
    }//GEN-LAST:event_eighteFocusGained

    private void nineeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nineeFocusGained
        ninee.setDate(null);
    }//GEN-LAST:event_nineeFocusGained

    private void teneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teneFocusGained
        tene.setSelectedIndex(-1);
    }//GEN-LAST:event_teneFocusGained

    private void eleveneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eleveneFocusGained
       elevene.setText("");
    }//GEN-LAST:event_eleveneFocusGained

    private void twelveeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_twelveeFocusGained
        twelvee.setText("");
    }//GEN-LAST:event_twelveeFocusGained

    private void sevenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sevenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_sevenKeyReleased


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
            java.util.logging.Logger.getLogger(UpdateEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClearE;
    private javax.swing.JButton buttonCloseE;
    private javax.swing.JButton buttonSearchE;
    private javax.swing.JButton buttonUpdateE;
    private javax.swing.JTextField eight;
    private javax.swing.JTextField eighte;
    private javax.swing.JTextField eleven;
    private javax.swing.JTextField elevene;
    private javax.swing.JTextField five;
    private javax.swing.JTextField fivee;
    private javax.swing.JTextField four;
    private com.toedter.calendar.JDateChooser foure;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcIDE;
    private javax.swing.JTextField nine;
    private com.toedter.calendar.JDateChooser ninee;
    private javax.swing.JTextField one;
    private javax.swing.JTextField onee;
    private javax.swing.JTextField seven;
    private javax.swing.JTextField sevene;
    private javax.swing.JTextField sixs;
    private javax.swing.JTextField sixse;
    private javax.swing.JTextField ten;
    private javax.swing.JComboBox<String> tene;
    private javax.swing.JTextField three;
    private javax.swing.JTextField threee;
    private javax.swing.JTextField twelve;
    private javax.swing.JTextField twelvee;
    private javax.swing.JTextField two;
    private javax.swing.JTextField twoe;
    // End of variables declaration//GEN-END:variables
}
