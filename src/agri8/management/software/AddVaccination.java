package agri8.management.software;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class AddVaccination extends javax.swing.JFrame {
    
       MySQLConnect myConnection;
       
    public AddVaccination() {
        icon();
        initComponents();
        myConnection = new MySQLConnect();

    }
    
    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
    
    
       private void Emp() {
        
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT e_name FROM tbl_emp_reg");
                 
                 while(rs.next()){
                     
                     tfvEmployee.addItem(rs.getString("e_name"));
                    
                } 
                 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                jcvID.requestFocus(false);   
       
            }   
    }
    
    private void cattleComboBox() {
        
         try {
                 
            
                Connection conn = myConnection.getConnect();
               
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c_tag_id, c_name, c_dateofbirth FROM tbl_cattle_info");
                 
                 while(rs.next()){
                     
                     jcvID.addItem(rs.getString("c_tag_id"));
                    
                } 
                 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
             //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                jcvID.requestFocus(false);   
       
            }   
    }
    
    private void cattleDetails() {
        // Fill Textfield when choosing cattle ID in JComboBox
        
        String cattleID = (String) jcvID.getSelectedItem();
        
         try {
                 
               
                Connection conn = myConnection.getConnect();
               
                String sql = ("SELECT c_name, c_dateofbirth FROM tbl_cattle_info WHERE c_tag_id = ?");
                
                PreparedStatement psm = conn.prepareStatement(sql);
                psm.setString(1, cattleID);
                ResultSet rs = psm.executeQuery();
                 
                if(rs.next()){
                    
                     tfvName.setText(rs.getString("c_name"));
                     tfvDob.setText(rs.getString("c_dateofbirth")) ;
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                jcvID.requestFocus(false);   
       
            }
    }
    
    //***************** Calf manditory Information ************************
    
    private void calfComboBox() {
        
         try {
                 
             
                Connection conn = myConnection.getConnect();
               
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT cc_tag_id, cc_name, cc_dob FROM tbl_calf_info");
                 
                 while(rs.next()){
                     
                     jcvID.addItem(rs.getString("cc_tag_id"));
                    
                } 
                 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                jcvID.requestFocus(false);   
       
            } 
    }
    
     private void calfDetails() {
        // Fill Textfield when choosing calf ID in JComboBox
        
        String cattleID = (String) jcvID.getSelectedItem();
        
         try {
                 
               
                Connection conn = myConnection.getConnect();
               
                String sql = ("SELECT cc_name, cc_dob FROM tbl_calf_info WHERE cc_tag_id = ?");
                
                PreparedStatement psm = conn.prepareStatement(sql);
                psm.setString(1, cattleID);
                ResultSet rs = psm.executeQuery();
                 
                if(rs.next()){
                    
                     tfvName.setText(rs.getString("cc_name"));
                     tfvDob.setText(rs.getString("cc_dob")) ;
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                jcvID.requestFocus(false);   
       
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcvID = new javax.swing.JComboBox<>();
        tfvName = new javax.swing.JTextField();
        tfvDob = new javax.swing.JTextField();
        jcvA = new javax.swing.JComboBox<>();
        tfvDosage = new javax.swing.JTextField();
        tfvTDate = new com.toedter.calendar.JDateChooser();
        tfvNTreat = new com.toedter.calendar.JDateChooser();
        tfvEmployee = new javax.swing.JComboBox<>();
        tfvNotes = new javax.swing.JTextField();
        btnAddV = new javax.swing.JButton();
        btnClearV = new javax.swing.JButton();
        jcAddDisease = new javax.swing.JComboBox<>();
        jcVacc = new javax.swing.JComboBox<>();
        btnCloseV = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        btnAddVaccination = new javax.swing.JButton();
        btnDeleteVaccination = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        btnAddDisease = new javax.swing.JButton();
        btnDeleteDisease = new javax.swing.JButton();
        lbbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Vaccination / Disease Record");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tag ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Date-of-Birth:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Disease:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Treatement");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Application:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Dosage:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Treatement Date:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Next Treatement:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Employee:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Notes:");

        jcvID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcvID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcvIDFocusGained(evt);
            }
        });
        jcvID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcvIDActionPerformed(evt);
            }
        });

        tfvName.setEditable(false);

        tfvDob.setEditable(false);

        jcvA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Dip", "Dose", "Intramascular Injection", "Intravenouse Injection", "Subcontaneous Injection", "Other" }));

        tfvDosage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfvDosageActionPerformed(evt);
            }
        });

        tfvTDate.setDateFormatString("yyyy-MM-dd");

        tfvNTreat.setDateFormatString("yyyy-MM-dd");

        tfvEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        tfvEmployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfvEmployeeFocusGained(evt);
            }
        });

        btnAddV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        btnAddV.setText("SAVE");
        btnAddV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVActionPerformed(evt);
            }
        });

        btnClearV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear16.png"))); // NOI18N
        btnClearV.setText("CLEAR");

        jcAddDisease.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Anthrax", "Blue Tongue", "Botulism", "Brucellosis (Contagious Abortion)", "Cattle Tick-Fever", "Corridor Disease", "East Coast Fever", "Eye-infection (Opthalmia)", "Epivag", "Foot and Mouth Disease (Notifiable Diseases)", "Footrot (Foul in the Foot)", "Gallsikness (Anaplasmosis)", "Gonderiosis Theileriasis", "Heartwater", "Malignant Oedema (Clostridium)", "Mastitis", "Navil ill  - E. coli", "Navil ill - Pasteurella", "Liver Flukes (Tremotodes)", "Lumpy Skin Disease", "ORF or Pastular Dermatitis", "Pasteurellosis", "Poison - Arsenical Dips", "Poison - Nitrate Poisoning", "Poison - Lead Poisoning", "Poison - Organo (Chloride Dips)", "Poison - Organo  (Phoshpate Poisoning)", "Poison - Urea Poisoning", "Pulpy Kidney - (Enteroxaemia)", "Quater Evil / Black Leg", "Rabies", "Redwater - (Babesiosis)", "Rift Valley Fever", "Salmonella - (Paratypnoid)", "Scab", "Sleeping Sickness (Trypanosomiasis)", "Sweating Sickness", "Swin erysipelas", "Tetanus", "Theileriosis", "Three Day Sickness (Ephemeral Fever)", "Trichomoniasis", "Trypanosomiasis (Notifable Disease)", "Tuberculosis", "Twin-lamb Disease", "Vibriosis", "White scours (E. coli)", "Worms - Bankruptworm", "Worms - Brown stomachworm", "Worms - Hookworms", "Worms - Nodularworms", "Worms - Ringworm", "Worms - Screwworm", "Worms - Wireworm", "Worms - Tapeworm (Cestades)" }));
        jcAddDisease.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcAddDiseaseFocusGained(evt);
            }
        });

        jcVacc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Castration", "Dipping", "Docking", "Dosing", "Hoof Trimming" }));
        jcVacc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcVaccFocusGained(evt);
            }
        });

        btnCloseV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnCloseV.setText("CLOSE");
        btnCloseV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcVacc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcAddDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcvA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfvDob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfvName)
                                    .addComponent(jcvID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfvTDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tfvDosage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfvEmployee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfvNTreat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfvNotes))))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddV, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(btnClearV, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCloseV, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jcvID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfvDosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel9)
                        .addComponent(tfvName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfvTDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel10)
                        .addComponent(tfvDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfvNTreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel11)
                        .addComponent(tfvEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcAddDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel12)
                        .addComponent(tfvNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcVacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jcvA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClearV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCloseV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 770, 340));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Add / Delete Treatement:");
        getContentPane().add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        btnAddVaccination.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAdd.png"))); // NOI18N
        btnAddVaccination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVaccinationActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddVaccination, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 40, 40));

        btnDeleteVaccination.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete.png"))); // NOI18N
        btnDeleteVaccination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVaccinationActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteVaccination, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 40, 40));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Add / Delete Disease:");
        getContentPane().add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        btnAddDisease.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAdd.png"))); // NOI18N
        btnAddDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDiseaseActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 40, 40));

        btnDeleteDisease.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete.png"))); // NOI18N
        btnDeleteDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDiseaseActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 40, 40));

        lbbackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg3.jpg"))); // NOI18N
        getContentPane().add(lbbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfvDosageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfvDosageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfvDosageActionPerformed

    private void btnCloseVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseVActionPerformed
        // Close Frame button
        this.dispose();
        new ClassLivestock().setVisible(true);
  
    }//GEN-LAST:event_btnCloseVActionPerformed

    private void btnAddVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVActionPerformed
         // Save new animale to database
        
         String vidtag = (String) jcvID.getSelectedItem();
         String vname = tfvName.getText().trim();
         String vdob =  tfvDob.getText().trim();
         String vdisease = (String) jcAddDisease.getSelectedItem();
         String vacc = (String) jcVacc.getSelectedItem();
         String vapplication = (String) jcvA.getSelectedItem();
         String vdosage = tfvDosage.getText();
         Date vtdate = tfvTDate.getDate();
         Date vnextte = tfvNTreat.getDate();
         String vemployee = (String) tfvEmployee.getSelectedItem();
         String vnotes = tfvNotes.getText().trim();
         
        //Validation to check if controls are empty or not
        if(vidtag.equals("SELECT") || vdisease.equals("SELECT") || vacc.equals("SELECT")  || vapplication.equals("SELECT")  ||
           vdosage.isEmpty() || vemployee.equals("SELECT") )  {
        
           JOptionPane.showMessageDialog(null, "All fields are mandatory to be completed!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        } else if (vtdate == null) {
            
                JOptionPane.showMessageDialog(null, "Please select correct Date!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                
        } else {
            
            try {
                
                Connection conn = myConnection.getConnect();
                
                   //Save new Animale
                    String saveQuery = "INSERT INTO tbl_vacc_disease(v_id, v_name, v_dob, v_disease, v_vacc, v_app, v_dosage, v_treatementDate, v_nexttreatment, v_employee, v_note)" +
                            "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            
                    PreparedStatement psm = conn.prepareStatement(saveQuery);
                                      
                    psm.setString(1, vidtag);                
                    psm.setString(2, vname);
                    psm.setString(3, vdob);
                    psm.setString(4, vdisease);
                    psm.setString(5, vacc);
                    psm.setString(6, vapplication);
                    psm.setString(7, vdosage);
                    psm.setString(10, vemployee);
                    psm.setString(11, vnotes);
                   
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(tfvTDate.getDate());
                    //String date2 = sdf.format(tfvNTreat.getDate());
                  
                    
                    try{
                      // Accept Null excption from string to Integer
                     if ( tfvNTreat.getDate() != null  ) { 
               
                           String  Date2 = sdf.format(tfvNTreat.getDate());
                           psm.setString(9, Date2);
                        } else {
          
             
                           psm.setNull(9, java.sql.Types.NULL);
                        }
                     
                      } catch (NullPointerException e) {
                           System.out.print("Datein Null Pointer Exception " + e);
                       }
                    
                    psm.setString(8, date1);
                    //psm.setString(9, date2);

                    
                   int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Record added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                       
                        this.dispose();
                        new AddVaccination().setVisible(true);
                               
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add Record to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
            } catch (SQLException | HeadlessException | NullPointerException e) {
                     System.err.println(e.getMessage());
                     //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
            }
        }    
    }//GEN-LAST:event_btnAddVActionPerformed

    private void jcvIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcvIDActionPerformed
        // TODO add your handling code here:
        
        calfDetails();      //Activate Calf info when JComboBox ID selected
        cattleDetails();     //Activate Cattle info when JComboBox ID selected
        
    }//GEN-LAST:event_jcvIDActionPerformed

    private void jcvIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcvIDFocusGained
        // Fill JCombox from Database
        
        calfComboBox();     //Calf IDs
        cattleComboBox();     //Cattle IDs
                
    }//GEN-LAST:event_jcvIDFocusGained

    private void btnAddVaccinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVaccinationActionPerformed
        // Add Vaccination Code

        boolean flag1 = false; 
         
        //Prompt User
        String inputVacc = JOptionPane.showInputDialog(null, "Please enter Medication Name", "Add new Medication", JOptionPane.QUESTION_MESSAGE);
     
    if(inputVacc == null) 
    {
         JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
         flag1 = false;
         
    } else {
         flag1 = true;
        
        try {
                
            Connection conn = myConnection.getConnect();
            
     
                 //Save new Item / String
                 
                    String saveQuery = "INSERT INTO tbl_vacc(v_vacc)" +
                            "values(?)";
                    
                    PreparedStatement psm = conn.prepareStatement(saveQuery);    
                    psm.setString(1, inputVacc);                
                       
                    psm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    conn.close();
                    this.dispose();
                    new AddVaccination().setVisible(true);
                
                
            } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());
                     //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
            }
         }  
    }//GEN-LAST:event_btnAddVaccinationActionPerformed

    private void btnAddDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDiseaseActionPerformed
         // Add Disease Code
 
       boolean flag = false; 
         
        //Prompt User
        String inputDisease = JOptionPane.showInputDialog(null, "Please enter Disease Name", "Input new Disease", JOptionPane.QUESTION_MESSAGE);
     
    if(inputDisease == null) 
    {
         JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
         flag = false;
         
    } else {
         flag = true;
     
        try {
                
                Connection conn = myConnection.getConnect();
                
                 //Save new Item / String
                 
                    String saveQuery = "INSERT INTO tbl_disease(v_disease)" +
                            "values(?)";
                    
                    PreparedStatement psm = conn.prepareStatement(saveQuery);    
                    psm.setString(1, inputDisease);                
                       
                    psm.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Added new Item ", "ITEM ADD", JOptionPane.INFORMATION_MESSAGE);
                    conn.close();
                    
     
            } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                     //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
            } 
          }
    }//GEN-LAST:event_btnAddDiseaseActionPerformed

    private void btnDeleteVaccinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVaccinationActionPerformed
        // Remove Vaccination
        
        String vacc = (String) jcVacc.getSelectedItem();
        if(vacc.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, " Please select Treatment Box to Delete Medication!", "PLEASE SELECT COMBOBOX!", JOptionPane.ERROR_MESSAGE);
       } else {
        
       
      try {  
         Connection conn = myConnection.getConnect();
        
           
            String sqldelete = "DELETE FROM tbl_vacc WHERE v_vacc = '" + vacc + "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            this.dispose();
            new AddVaccination().setVisible(true);
            conn.close();
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
               System.err.println(e.getMessage());
               JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
      }
    }//GEN-LAST:event_btnDeleteVaccinationActionPerformed

    private void jcVaccFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcVaccFocusGained
        // Populate Vaccination Combobox
        
         try {
                 
               Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_vacc FROM tbl_vacc ORDER BY v_vacc ASC");
                 
                 while(rs.next()){
                     
                     jcVacc.addItem(rs.getString("v_vacc"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }

    }//GEN-LAST:event_jcVaccFocusGained

    private void jcAddDiseaseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcAddDiseaseFocusGained
        // Populate Disease Combobox
        
         try {
                 
             Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_disease FROM tbl_disease ORDER BY v_disease ASC");
                 
                 while(rs.next()){
                     
                     jcAddDisease.addItem(rs.getString("v_disease"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
             //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_jcAddDiseaseFocusGained

    private void btnDeleteDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDiseaseActionPerformed
        // Remove Disease
        
        String disease = (String) jcAddDisease.getSelectedItem();
        
         if(disease.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, " Please select Disease in Disease Combobox to be deleted!", "PLEASE SELECT DISEASE COMBOBOX!", JOptionPane.ERROR_MESSAGE);
           
        } else {
        
        try {  
         Connection conn = myConnection.getConnect();
         
     
            String sqldelete = "DELETE FROM tbl_disease WHERE v_disease = '" + disease + "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            pst.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            this.dispose();
            new AddVaccination().setVisible(true);
            conn.close();
        
       } catch (SQLException | HeadlessException | NullPointerException e) {
               System.err.println(e.getMessage());
                 //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
       } 
     } 
        
    }//GEN-LAST:event_btnDeleteDiseaseActionPerformed

    private void tfvEmployeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfvEmployeeFocusGained
        Emp();
    }//GEN-LAST:event_tfvEmployeeFocusGained

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddVaccination().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDisease;
    private javax.swing.JButton btnAddV;
    private javax.swing.JButton btnAddVaccination;
    private javax.swing.JButton btnClearV;
    private javax.swing.JButton btnCloseV;
    private javax.swing.JButton btnDeleteDisease;
    private javax.swing.JButton btnDeleteVaccination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcAddDisease;
    private javax.swing.JComboBox<String> jcVacc;
    private javax.swing.JComboBox<String> jcvA;
    private javax.swing.JComboBox<String> jcvID;
    private javax.swing.JLabel lbbackground;
    private javax.swing.JTextField tfvDob;
    private javax.swing.JTextField tfvDosage;
    private javax.swing.JComboBox<String> tfvEmployee;
    private com.toedter.calendar.JDateChooser tfvNTreat;
    private javax.swing.JTextField tfvName;
    private javax.swing.JTextField tfvNotes;
    private com.toedter.calendar.JDateChooser tfvTDate;
    // End of variables declaration//GEN-END:variables
}
