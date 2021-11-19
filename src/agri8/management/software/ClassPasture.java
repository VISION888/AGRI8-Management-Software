package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ClassPasture extends javax.swing.JFrame {
    
     MySQLConnect myConnection;

    public ClassPasture() {
        icon();
        initComponents();
        jPanel1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        myConnection = new MySQLConnect();
        TablePaddock();
        fillComoboboxs();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        LogoName();
          
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
       private void LogoName() {
         
           Connection conn = myConnection.getConnect();
                                      
                try {

                    //Establish / Open Connection
                    
                    String sql = "SELECT f_id_name, farm_picture FROM tbl_farm_details";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    //Executing Query
                    ResultSet rs = sta.executeQuery();
                    byte[] image = null;
                    if (rs.next()) {
                        labelLogo.setText("");  
                        labelName.setText(rs.getString("f_id_name"));                                    
                        image = (rs.getBytes("farm_picture"));
                    
                    if(image != null) {
                        Image img = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon icon = new ImageIcon(img.getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH));
                        labelLogo.setIcon(icon);
                    } else {
                        sta.setNull(1, Types.BLOB);
                    }
                     
                    }
                        } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
       
       private void fillComoboboxs() {
           
           
             try {
                 
                Connection conn = myConnection.getConnect();
               
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock ORDER BY pname ASC");
                 
                 while(rs.next()){
                     
                     jcName.addItem(rs.getString("pname"));
                    
                } 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Paddock name System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            } 
             
               try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                   
                     jcHerdGroup.addItem(rs.getString("herdtype"));
                } 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Herdgroup - sSystem got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
           
           
       }
     
      // ********** Filter Paddock Table **************
     private void filter(String query){
         
         DefaultTableModel tblModel = (DefaultTableModel) tablePaddock.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(tblModel);
         tablePaddock.setRowSorter(trs);
         
         trs.setRowFilter(RowFilter.regexFilter(query));
     }
     
     
     //*************** Paddock Table *********************
     
     private void TablePaddock() {
         
           Connection conn = myConnection.getConnect();
      
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_paddock ORDER BY pname ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
             
              String name = rs.getString("pname");
              String size = rs.getString("psize");
              String statues = rs.getString("pstatues");
              String type = rs.getString("ptype");
              String herdsize = rs.getString("pherdsize");
              String herdtype = rs.getString("pherdtype");
              
              String datein = null;
              String dateout = null;
             try {
             
               datein = String.valueOf(sdf.format(rs.getDate("datein")));
               dateout = String.valueOf(sdf.format(rs.getDate("dateout")));
         }catch (NullPointerException e) {
                        System.out.print("Null pointer expection: " + e + "");
         }
              
              String stockingrate = String.valueOf(rs.getInt("stockingrate"));
           
              //String array to store data into jTable
              String tblDataP[] = {name, size, statues, type, herdsize, herdtype, datein, dateout, stockingrate};
              DefaultTableModel tblModel = (DefaultTableModel)tablePaddock.getModel();
              
              //Add string array data into table
              tblModel.addRow(tblDataP);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Paddock Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
           
           
     }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        btnLiveM = new javax.swing.JButton();
        btnInvM = new javax.swing.JButton();
        btnFinM = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnCloseP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jcName = new javax.swing.JComboBox<>();
        buttonClear = new javax.swing.JButton();
        buttonDelectP = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcHerdGroup = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePaddock = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GRAZING PASTURES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelLogo.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setText("Farm Logo");
        labelLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelName.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        labelName.setForeground(new java.awt.Color(204, 204, 204));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Farm Name");

        btnLiveM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLiveM.setForeground(new java.awt.Color(223, 164, 73));
        btnLiveM.setText("LIVESTOCK MANAGEMENT");
        btnLiveM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLiveM.setBorderPainted(false);
        btnLiveM.setContentAreaFilled(false);
        btnLiveM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLiveM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiveMActionPerformed(evt);
            }
        });

        btnInvM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnInvM.setForeground(new java.awt.Color(223, 164, 73));
        btnInvM.setText("INVENTORY MANAGEMENT");
        btnInvM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnInvM.setBorderPainted(false);
        btnInvM.setContentAreaFilled(false);
        btnInvM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInvM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvMActionPerformed(evt);
            }
        });

        btnFinM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnFinM.setForeground(new java.awt.Color(223, 164, 63));
        btnFinM.setText("FINANCIAL MANAGEMENT");
        btnFinM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnFinM.setBorderPainted(false);
        btnFinM.setContentAreaFilled(false);
        btnFinM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinMActionPerformed(evt);
            }
        });

        btnReports.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnReports.setForeground(new java.awt.Color(223, 163, 73));
        btnReports.setText("VIEW REPORTS");
        btnReports.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnReports.setBorderPainted(false);
        btnReports.setContentAreaFilled(false);
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        btnCloseP.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCloseP.setForeground(new java.awt.Color(223, 164, 73));
        btnCloseP.setText("CLOSE PAGE");
        btnCloseP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCloseP.setBorderPainted(false);
        btnCloseP.setContentAreaFilled(false);
        btnCloseP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosePActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnInvM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(btnFinM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLiveM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCloseP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLiveM, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInvM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCloseP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 216, 220, 480));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GRAZING PADDOCKS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1360, -1));

        jPanel5.setBackground(new java.awt.Color(223, 164, 73));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "VIEW / SEARCH PADDOCKS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("NAME:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("HERD GROUP:");

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jcName.setBackground(new java.awt.Color(204, 204, 255));
        jcName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcNameItemStateChanged(evt);
            }
        });

        buttonClear.setBackground(new java.awt.Color(204, 204, 255));
        buttonClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonClear.setForeground(new java.awt.Color(0, 0, 0));
        buttonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClear.setText("CLEAR");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonDelectP.setBackground(new java.awt.Color(204, 204, 255));
        buttonDelectP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonDelectP.setForeground(new java.awt.Color(0, 0, 0));
        buttonDelectP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonDelectP.setText("DELETE");
        buttonDelectP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDelectPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("OR");

        jcHerdGroup.setBackground(new java.awt.Color(204, 204, 255));
        jcHerdGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        jcHerdGroup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcHerdGroupItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jcName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jcHerdGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(buttonDelectP, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jcName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(buttonDelectP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcHerdGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 1120, 60));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablePaddock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paddock Name", "Size", "Paddock Statues", "Paddock Type", "Herd Size", "Herd Type", "Date-in", "Date-out", "Rate (LSU)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePaddock);
        if (tablePaddock.getColumnModel().getColumnCount() > 0) {
            tablePaddock.getColumnModel().getColumn(1).setPreferredWidth(30);
            tablePaddock.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablePaddock.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablePaddock.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablePaddock.getColumnModel().getColumn(5).setPreferredWidth(150);
            tablePaddock.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 1120, 490));

        buttonAdd.setBackground(new java.awt.Color(204, 204, 255));
        buttonAdd.setForeground(new java.awt.Color(0, 0, 0));
        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonAdd.setText("Add Pasture");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 50, 129, 40));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(51, 51, 51));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("AGRI8 Assist: DELETE a field in the Table below by first searching the animal, then select a row in the table and click the \"DELETE BUTTON\".");
        getContentPane().add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 1120, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logopng_200px.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 170));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgsheep.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 1370, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // Open add frame
        this.dispose();
        new AddPasture().setVisible(true);
        
    }//GEN-LAST:event_buttonAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // CLOSE PAGE

        this.dispose();
        new UpdatePasture().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcNameItemStateChanged
          
        String query = (String) jcName.getSelectedItem().toString();
        filter(query);  
    }//GEN-LAST:event_jcNameItemStateChanged

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
       this.dispose();
       new ClassPasture().setVisible(true);
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonDelectPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDelectPActionPerformed
         // Delete Calf and Health History
        
        Connection conn = myConnection.getConnect();
        String searchID = (String) jcName.getSelectedItem();
       
        if(searchID.equals("SELECT") ) {
            
            JOptionPane.showMessageDialog(null, " Please first select Paddock Name from Paddock Box to Delete!", "Paddock Name not Selected!", JOptionPane.ERROR_MESSAGE);
            jcName.grabFocus();
    
        } else {
        try {
                    
            String sqldelete = "DELETE FROM tbl_paddock WHERE pname = '" + searchID + "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            int deleted = pst.executeUpdate(sqldelete);
            
            if(deleted == 0) {
                
                JOptionPane.showMessageDialog(null, "No record deleted, please retry!", "DELETION ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
            
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
          
            jcName.setSelectedItem("SELECT");
           
         DefaultTableModel model = (DefaultTableModel) tablePaddock.getModel();
         model.setRowCount(0);
         this.dispose();
         new ClassPasture().setVisible(true);
          
            }
        } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
        
        }
    
    }//GEN-LAST:event_buttonDelectPActionPerformed

    private void btnLiveMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiveMActionPerformed
        
        this.dispose();
        new ClassLivestock().setVisible(true);
        
    }//GEN-LAST:event_btnLiveMActionPerformed

    private void btnInvMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvMActionPerformed
        this.dispose();
        new ClassInventory().setVisible(true);
    }//GEN-LAST:event_btnInvMActionPerformed

    private void btnFinMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinMActionPerformed
        
        this.dispose();
        new Login_AuthoF().setVisible(true);
    }//GEN-LAST:event_btnFinMActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        
        this.dispose();
        new Login_AuthoR().setVisible(true);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void jcHerdGroupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcHerdGroupItemStateChanged
        
         // Filter by Type
        
        String query = (String) jcHerdGroup.getSelectedItem().toString();
        filter(query);
        
    }//GEN-LAST:event_jcHerdGroupItemStateChanged

    private void btnClosePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosePActionPerformed
      
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_btnClosePActionPerformed


    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassPasture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseP;
    private javax.swing.JButton btnFinM;
    private javax.swing.JButton btnInvM;
    private javax.swing.JButton btnLiveM;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonDelectP;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcHerdGroup;
    private javax.swing.JComboBox<String> jcName;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelName;
    private javax.swing.JTable tablePaddock;
    // End of variables declaration//GEN-END:variables
}
