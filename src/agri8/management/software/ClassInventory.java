package agri8.management.software;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ClassInventory extends javax.swing.JFrame {

    MySQLConnect myConnection;
    
    public ClassInventory() {
        icon();
        initComponents();
        jPanel1.setBackground(new Color(117,66,30,225));
        tabHomePage.setBackground(new Color(0,0,0,100));
        tabAnimalHealth.setBackground(new Color(0,0,0,100));
        tabFeedstock.setBackground(new Color(0,0,0,100));
        tabMiscellaneous.setBackground(new Color(0,0,0,100));
        buttonSearchInv.setBackground(new Color(0,0,0,100));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         myConnection = new MySQLConnect();
         newVat.setEnabled(false);
         FNEWVAT.setEnabled(false);
         MNEWVAT.setEnabled(false);
         LogoName();
         TableAnimal();
         TableFeed();
         TableMisc();
         TableHome();
         filterTable();
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
         // ********** Filter SALES AND EXPENSE Table **************
     private void filter(String query){
         
         DefaultTableModel tblModel = (DefaultTableModel) tableHome.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(tblModel);
         tableHome.setRowSorter(trs);
         
         trs.setRowFilter(RowFilter.regexFilter(query));
     }
     
     
     private void filterTable() {
         
           // Populate Populate JCombobox
          
          String PRODUCTID = (String) productID.getSelectedItem();

        
        if(!PRODUCTID.equals("SELECT")) {
            
            productName.setSelectedItem("SELECT");
         
           }
        try {
            
            Connection conn = myConnection.getConnect();
            
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT a_pid, a_pname FROM tbl_inventory_vaccination ORDER BY a_pid, a_pname ASC");
                 
                 while(rs.next()){
                     
                     productID.addItem(rs.getString("a_pid"));
                     productName.addItem(rs.getString("a_pname"));
          
                   }
             
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
 
     }
        
       
        if(!PRODUCTID.equals("SELECT")) {
            
            productName.setSelectedItem("SELECT");
         
           }
        try {
            
            Connection conn = myConnection.getConnect();
            
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT f_pid, f_pname FROM tbl_inventory_feedstock ORDER BY f_pid, f_pname ASC");
                 
                 while(rs.next()){
                     
                     productID.addItem(rs.getString("f_pid"));
                     productName.addItem(rs.getString("f_pname"));
          
                   }
             
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
         if(!PRODUCTID.equals("SELECT")) {
            
            productName.setSelectedItem("SELECT");
         
           }
        try {
            
            Connection conn = myConnection.getConnect();
            
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT m_pid, m_pname FROM tbl_inventory_misc ORDER BY m_pid, m_pname ASC");
                 
                 while(rs.next()){
                     
                     productID.addItem(rs.getString("m_pid"));
                     productName.addItem(rs.getString("m_pname"));
          
                   }
             
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
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
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
     
     
      private void TableAnimal()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_inventory_vaccination ORDER BY a_pid ASC ";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              
              String aid = rs.getString("a_pid");
              String aname = rs.getString("a_pname");
              String atype = rs.getString("a_ptype");
              String asub = rs.getString("a_psubtotal");
              String avat = rs.getString("a_pvat");
              String atotal = rs.getString("a_ptotal");
              String adoses = rs.getString("a_pdoses");
              String aqty = rs.getString("a_pqty");
              String acost = rs.getString("a_pcostper");
              String adatein = rs.getString("a_pdatein");
              String adateout = rs.getString("a_pdateout");
              String anotes = rs.getString("a_pnotes");
    
              //String array to store data into jTable
              String tblDataA[] = {aid, aname, atype, asub, avat, atotal, adoses, aqty, acost, adatein, adateout, anotes};
              DefaultTableModel tblModelA = (DefaultTableModel)tableAnimale.getModel();
              
              //Add string array data into table
              tblModelA.addRow(tblDataA);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException  e) {
                    System.err.println(e.getMessage());
        }
      }
      
      
         private void TableFeed()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_inventory_feedstock ORDER BY f_pid ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              
              String fid = rs.getString("f_pid");
              String fname = rs.getString("f_pname");
              String ftype = rs.getString("f_ptype");
              String fsub = rs.getString("f_psubtotal");
              String fvat = rs.getString("f_pvat");
              String ftotal = rs.getString("f_ptotal");
              String fqty = rs.getString("f_pqty");
              String fcost = rs.getString("f_costper");
              String fdatein = rs.getString("f_pdatein");
              String fdateout = rs.getString("f_pdateout");
              String fnotes = rs.getString("f_pnotes");
    
              //String array to store data into jTable
              String tblDataF[] = {fid, fname, ftype, fsub, fvat, ftotal, fqty, fcost, fdatein, fdateout, fnotes};
              DefaultTableModel tblModelF = (DefaultTableModel)tableFeed.getModel();
              
              //Add string array data into table
              tblModelF.addRow(tblDataF);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
        }
      }
    
     private void TableMisc()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_inventory_misc ORDER BY m_pid ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              
              String mid = rs.getString("m_pid");
              String mname = rs.getString("m_pname");
              String mtype = rs.getString("m_ptype");
              String msub = rs.getString("m_psubtotal");
              String mvat = rs.getString("m_pvat");
              String mtotal = rs.getString("m_ptotal");
              String mqty = rs.getString("m_pqty");
              String mdatein = rs.getString("m_pdatein");
              String mnotes = rs.getString("m_pnotes");
    
              //String array to store data into jTable
              String tblDataM[] = {mid, mname, mtype, msub, mvat, mtotal, mdatein, mqty, mnotes};
              DefaultTableModel tblModelM = (DefaultTableModel)tableMiscell.getModel();
              
              //Add string array data into table
              tblModelM.addRow(tblDataM);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
        }
      }
     
       private void TableHome()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sqlA = "SELECT * FROM tbl_inventory_vaccination ORDER BY a_pid ASC";
          String sqlF = "SELECT * FROM tbl_inventory_feedstock ORDER BY f_pid ASC";
          String sqlM = "SELECT * FROM tbl_inventory_misc ORDER BY m_pid ASC";
          
             ResultSet rsa = stm.executeQuery(sqlA);
          
          while(rsa.next()) {
              
              //Add data
              
              String aid = rsa.getString("a_pid");
              String aname = rsa.getString("a_pname");
              String atype = rsa.getString("a_ptype");
              String asub = rsa.getString("a_psubtotal");
              String avat = rsa.getString("a_pvat");
              String atotal = rsa.getString("a_ptotal");
              String adoses = rsa.getString("a_pdoses");
              String aqty = rsa.getString("a_pqty");
              String acost = rsa.getString("a_pcostper");
              String adatein = rsa.getString("a_pdatein");
              String adateout = rsa.getString("a_pdateout");
              String anotes = rsa.getString("a_pnotes");
    
              //String array to store data into jTable
              String tblDataA[] = {aid, aname, atype, asub, avat, atotal, adoses, aqty, acost, adatein, adateout, anotes};
              DefaultTableModel tblModelA = (DefaultTableModel)tableHome.getModel();
              
              //Add string array data into table
              tblModelA.addRow(tblDataA);
          }
          
          ResultSet rsf = stm.executeQuery(sqlF);
          
          while(rsf.next()) {
              
              //Add data
              
              String fid = rsf.getString("f_pid");
              String fname = rsf.getString("f_pname");
              String ftype = rsf.getString("f_ptype");
              String fsub = rsf.getString("f_psubtotal");
              String fvat = rsf.getString("f_pvat");
              String ftotal = rsf.getString("f_ptotal");
              String fqty = rsf.getString("f_pqty");
              String fcost = rsf.getString("f_costper");
              String fdatein = rsf.getString("f_pdatein");
              String fdateout = rsf.getString("f_pdateout");
              String fnotes = rsf.getString("f_pnotes");
    
              //String array to store data into jTable
              String tblDataF[] = {fid, fname, ftype, fsub, fvat, ftotal, fqty, fcost, fdatein, fdateout, fnotes};
              DefaultTableModel tblModelF = (DefaultTableModel)tableHome.getModel();
              
              //Add string array data into table
              tblModelF.addRow(tblDataF);
          }
          
          
          ResultSet rs = stm.executeQuery(sqlM);
          
          while(rs.next()) {
              
              //Add data
              
              String mid = rs.getString("m_pid");
              String mname = rs.getString("m_pname");
              String mtype = rs.getString("m_ptype");
              String msub = rs.getString("m_psubtotal");
              String mvat = rs.getString("m_pvat");
              String mtotal = rs.getString("m_ptotal");
              String mqty = rs.getString("m_pqty");
              String mdatein = rs.getString("m_pdatein");
              String mnotes = rs.getString("m_pnotes");
    
              //String array to store data into jTable
              String tblDataH[] = {mid, mname, mtype, msub, mvat, mtotal, mdatein, mqty, mnotes};
              DefaultTableModel tblModelH = (DefaultTableModel)tableHome.getModel();
              
              //Add string array data into table
              tblModelH.addRow(tblDataH);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
        }
      }
     
     
         
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabMain = new javax.swing.JTabbedPane();
        tabHomePage = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productName = new javax.swing.JComboBox<>();
        buttonSearchInv = new javax.swing.JButton();
        productID = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableHome = new javax.swing.JTable();
        tabAnimalHealth = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        atwo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        aone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        athree = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        aeight = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        aseven = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        aten = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        aeleven = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        afour = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        afive = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        asixs = new javax.swing.JTextField();
        tfPCost = new javax.swing.JTextField();
        radioNoVat = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        anine = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        atwelve = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        newVat = new javax.swing.JTextField();
        btnChangeVat = new javax.swing.JToggleButton();
        tablejscoll = new javax.swing.JScrollPane();
        tableAnimale = new javax.swing.JTable();
        buttonPAdd = new javax.swing.JButton();
        buttonSearch = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        tabFeedstock = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        FONE = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        FTWO = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        FTHREE = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        FSEVEN = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        FTEN = new com.toedter.calendar.JDateChooser();
        FNINE = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        FFOUR = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        FFIVE = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        FSIXS = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        FEIGHT = new javax.swing.JTextField();
        RADIONOVAT = new javax.swing.JRadioButton();
        btnChangeVat1 = new javax.swing.JToggleButton();
        jLabel16 = new javax.swing.JLabel();
        FNEWVAT = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        FELEVEN = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableFeed = new javax.swing.JTable();
        buttonfAdd = new javax.swing.JButton();
        buttonfSearch = new javax.swing.JButton();
        buttonfUpdate = new javax.swing.JButton();
        buttonfDelete = new javax.swing.JButton();
        buttonfClear = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        tabMiscellaneous = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        TWOM = new javax.swing.JTextField();
        THREEM = new javax.swing.JTextField();
        FOURM = new javax.swing.JTextField();
        FIVEM = new javax.swing.JTextField();
        SIXSM = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        SEVENM = new com.toedter.calendar.JDateChooser();
        EIGHTM = new javax.swing.JTextField();
        NINEM = new javax.swing.JTextField();
        radioNoVatM = new javax.swing.JRadioButton();
        btnChangeVatM = new javax.swing.JToggleButton();
        jLabel32 = new javax.swing.JLabel();
        MNEWVAT = new javax.swing.JTextField();
        ONEM = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        buttonAddM = new javax.swing.JButton();
        buttonSearchM = new javax.swing.JButton();
        buttonUpdateM = new javax.swing.JButton();
        buttonDeleteM = new javax.swing.JButton();
        buttonClearM = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMiscell = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonAnimal = new javax.swing.JButton();
        buttonFeed = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        buttonHome = new javax.swing.JButton();
        buttonStock1 = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(223, 164, 73));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabMain.setBackground(new java.awt.Color(117, 66, 30));
        TabMain.setForeground(new java.awt.Color(223, 165, 73));
        TabMain.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tabHomePage.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("INVENTORY MANAGEMENT HOME PAGE");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "QUICK SEARCH"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Product ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Product Name:");

        productName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        productName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productNameItemStateChanged(evt);
            }
        });

        buttonSearchInv.setForeground(new java.awt.Color(255, 255, 255));
        buttonSearchInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonSearchInv.setText("REFRESH");
        buttonSearchInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchInvActionPerformed(evt);
            }
        });

        productID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        productID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productIDItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("OR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(buttonSearchInv, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSearchInv, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        tableHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Unit Price", "Vat", "Total Cost", "Qty / kg / ml"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableHome);
        if (tableHome.getColumnModel().getColumnCount() > 0) {
            tableHome.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableHome.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableHome.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        jScrollPane5.setViewportView(jScrollPane6);

        javax.swing.GroupLayout tabHomePageLayout = new javax.swing.GroupLayout(tabHomePage);
        tabHomePage.setLayout(tabHomePageLayout);
        tabHomePageLayout.setHorizontalGroup(
            tabHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabHomePageLayout.createSequentialGroup()
                .addGroup(tabHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabHomePageLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
        );
        tabHomePageLayout.setVerticalGroup(
            tabHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHomePageLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TabMain.addTab("Home Page", tabHomePage);

        tabAnimalHealth.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ANIMAL HEALTH INVENTORY");

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Product Name:");

        atwo.setNextFocusableComponent(athree);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Product ID:");

        aone.setNextFocusableComponent(atwo);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Product Type:");

        athree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dip", "Dose", "Intramuscular (into muscle)", "Intravenous (in the vein)", "Subcutaneous (fat layer)", "Other", " " }));
        athree.setSelectedIndex(-1);
        athree.setNextFocusableComponent(afour);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Qty / ml:");

        aeight.setNextFocusableComponent(anine);
        aeight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                aeightFocusLost(evt);
            }
        });
        aeight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aeightMouseExited(evt);
            }
        });
        aeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aeightKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Doses:");

        aseven.setNextFocusableComponent(aeight);
        aseven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                asevenKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Date bought:");

        aten.setDateFormatString("yyyy-MM-dd");
        aten.setNextFocusableComponent(aeleven);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Expire Date:");

        aeleven.setAutoscrolls(true);
        aeleven.setDateFormatString("yyyy-MM-dd");
        aeleven.setNextFocusableComponent(atwelve);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Sub-Total");

        afour.setNextFocusableComponent(afive);
        afour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                afourFocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Vat:");

        afive.setEnabled(false);
        afive.setNextFocusableComponent(asixs);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Total Cost:");

        asixs.setEnabled(false);
        asixs.setNextFocusableComponent(aseven);
        asixs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                asixsFocusLost(evt);
            }
        });
        asixs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asixsActionPerformed(evt);
            }
        });

        tfPCost.setEnabled(false);

        radioNoVat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioNoVat.setText("No Vat");
        radioNoVat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoVatActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Cost per ml:");

        anine.setEditable(false);
        anine.setNextFocusableComponent(aten);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("Notes:");

        atwelve.setNextFocusableComponent(buttonPAdd);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("New Vat %:");

        newVat.setText("15");
        newVat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newVatActionPerformed(evt);
            }
        });
        newVat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newVatKeyPressed(evt);
            }
        });

        btnChangeVat.setText("Change Vat %");
        btnChangeVat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeVatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(atwo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(athree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(afour, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(asixs)
                    .addComponent(afive, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aseven, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel17)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(atwelve)
                        .addComponent(aeleven, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aten, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newVat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnChangeVat, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNoVat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200)
                .addComponent(tfPCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 55, Short.MAX_VALUE)
                .addComponent(tfPCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(anine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(aone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(atwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(athree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(afive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(afour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(asixs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)))
                            .addComponent(jLabel11))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(aeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(aseven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(aten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(atwelve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(aeleven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel40))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(radioNoVat)
                        .addGap(18, 18, 18)
                        .addComponent(btnChangeVat)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(newVat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableAnimale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Type", "Sub-Total", "Vat", "Total", "Doses", "Qty / ml", "Cost per ml", "Date Bought", "Expire Date", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablejscoll.setViewportView(tableAnimale);
        if (tableAnimale.getColumnModel().getColumnCount() > 0) {
            tableAnimale.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableAnimale.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableAnimale.getColumnModel().getColumn(2).setPreferredWidth(140);
            tableAnimale.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableAnimale.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableAnimale.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableAnimale.getColumnModel().getColumn(6).setPreferredWidth(50);
            tableAnimale.getColumnModel().getColumn(7).setPreferredWidth(60);
            tableAnimale.getColumnModel().getColumn(8).setPreferredWidth(60);
            tableAnimale.getColumnModel().getColumn(9).setPreferredWidth(80);
            tableAnimale.getColumnModel().getColumn(10).setPreferredWidth(80);
            tableAnimale.getColumnModel().getColumn(11).setPreferredWidth(140);
        }

        buttonPAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonPAdd.setText("ADD");
        buttonPAdd.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonPAdd.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonPAdd.setName(""); // NOI18N
        buttonPAdd.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonPAdd.setRolloverEnabled(false);
        buttonPAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPAddActionPerformed(evt);
            }
        });

        buttonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearch.setText("SEARCH");
        buttonSearch.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonSearch.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonSearch.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonSearch.setRolloverEnabled(false);
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonItem.png"))); // NOI18N
        buttonUpdate.setText("UPDATE");
        buttonUpdate.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonUpdate.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonUpdate.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDelete.setText("DELETE");
        buttonDelete.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonDelete.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonDelete.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClear.setText("CLEAR");
        buttonClear.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonClear.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonClear.setName(""); // NOI18N
        buttonClear.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonClear.setRolloverEnabled(false);
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("AGRI8 Assist: After adding your product, first search the product ID in order to update product.");

        javax.swing.GroupLayout tabAnimalHealthLayout = new javax.swing.GroupLayout(tabAnimalHealth);
        tabAnimalHealth.setLayout(tabAnimalHealthLayout);
        tabAnimalHealthLayout.setHorizontalGroup(
            tabAnimalHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAnimalHealthLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(tabAnimalHealthLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(tabAnimalHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tablejscoll))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(tabAnimalHealthLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addGroup(tabAnimalHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(tabAnimalHealthLayout.createSequentialGroup()
                        .addComponent(buttonPAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabAnimalHealthLayout.setVerticalGroup(
            tabAnimalHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAnimalHealthLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(tabAnimalHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabAnimalHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonPAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabAnimalHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tablejscoll, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabMain.addTab("Animal Health", tabAnimalHealth);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("FEED STOCK INVENTORY");

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Feed ID:");

        FONE.setNextFocusableComponent(FTWO);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Feed Name:");

        FTWO.setNextFocusableComponent(FTHREE);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Feed Type:");

        FTHREE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flakes - bagged", "Flakes - not bagged", "Bagged - Concentrate", "Bagged - Other", "Bagged - Salt", "Bagged - other", "Bales - 50kg", "Bales - 500kg", "Bales - other", "Dried Grass - bagged", "Dried Grass - not bagged", "Molasses - Liquid", "Molasses - Dry", "Pallets -bagged", "Pallets - not bagged", "Roughage - Silage", "Roughage - other", "Silo Feed (not bagged)", "Other" }));
        FTHREE.setSelectedIndex(-1);
        FTHREE.setNextFocusableComponent(FFOUR);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Kg / ml:");

        FSEVEN.setNextFocusableComponent(FEIGHT);
        FSEVEN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FSEVENFocusLost(evt);
            }
        });
        FSEVEN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FSEVENKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Date bought:");

        FTEN.setDateFormatString("yyyy-MM-dd");
        FTEN.setNextFocusableComponent(FELEVEN);

        FNINE.setAutoscrolls(true);
        FNINE.setDateFormatString("yyyy-MM-dd");
        FNINE.setNextFocusableComponent(FTEN);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Sub-Total:");

        FFOUR.setNextFocusableComponent(FFIVE);
        FFOUR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FFOURFocusLost(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Vat:");

        FFIVE.setEnabled(false);
        FFIVE.setNextFocusableComponent(FSIXS);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Total Cost:");

        FSIXS.setEnabled(false);
        FSIXS.setNextFocusableComponent(FSEVEN);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Cost per kg / ml:");

        FEIGHT.setEnabled(false);
        FEIGHT.setNextFocusableComponent(FNINE);
        FEIGHT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FEIGHTKeyReleased(evt);
            }
        });

        RADIONOVAT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RADIONOVAT.setText("No Vat");

        btnChangeVat1.setText("Change Vat %");
        btnChangeVat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeVat1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("New Vat %:");

        FNEWVAT.setText("15");
        FNEWVAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNEWVATActionPerformed(evt);
            }
        });
        FNEWVAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FNEWVATKeyPressed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setText("Notes:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Date Expire:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(FTHREE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FONE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FSIXS, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FFOUR)
                    .addComponent(FFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel23)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(FEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FELEVEN)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(FSEVEN)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FNINE, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RADIONOVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangeVat1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FNEWVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel29)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(FTWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel22))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel47))))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(FONE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addComponent(FTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel26)
                                    .addGap(18, 18, 18)
                                    .addComponent(FELEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(RADIONOVAT)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnChangeVat1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(FNEWVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addGap(74, 74, 74)
                                            .addComponent(FSIXS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(FFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel23))
                                            .addGap(74, 74, 74)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(FSEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel25))
                                            .addComponent(FNINE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FTEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(FFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel30)
                                                .addComponent(FEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(2, 2, 2)))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );

        tableFeed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Feed ID", "Feed Name", "Feed Type", "Sub-Total", "Vat", "Total", "Kg / ml", "Cost per kg/ml", "Date Bought", "Date Expire", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableFeed);

        buttonfAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonfAdd.setText("ADD");
        buttonfAdd.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonfAdd.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonfAdd.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonfAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonfAddActionPerformed(evt);
            }
        });

        buttonfSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonfSearch.setText("SEARCH");
        buttonfSearch.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonfSearch.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonfSearch.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonfSearchActionPerformed(evt);
            }
        });

        buttonfUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonItem.png"))); // NOI18N
        buttonfUpdate.setText("UPDATE");
        buttonfUpdate.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonfUpdate.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonfUpdate.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonfUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonfUpdateActionPerformed(evt);
            }
        });

        buttonfDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonfDelete.setText("DELETE");
        buttonfDelete.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonfDelete.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonfDelete.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonfDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonfDeleteActionPerformed(evt);
            }
        });

        buttonfClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonfClear.setText("CLEAR");
        buttonfClear.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonfClear.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonfClear.setName(""); // NOI18N
        buttonfClear.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonfClear.setRolloverEnabled(false);
        buttonfClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonfClearActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AGRI8 Assist: After adding your product, first search the product ID in order to update product.");

        javax.swing.GroupLayout tabFeedstockLayout = new javax.swing.GroupLayout(tabFeedstock);
        tabFeedstock.setLayout(tabFeedstockLayout);
        tabFeedstockLayout.setHorizontalGroup(
            tabFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFeedstockLayout.createSequentialGroup()
                .addGroup(tabFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabFeedstockLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabFeedstockLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 1154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabFeedstockLayout.createSequentialGroup()
                                .addGroup(tabFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(tabFeedstockLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(buttonfAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonfUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonfDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonfClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabFeedstockLayout.setVerticalGroup(
            tabFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFeedstockLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(tabFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonfAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonfUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonfDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonfClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabMain.addTab("Feed Stock", tabFeedstock);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("MISCELLANEOUS INVENTORY");

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel12.setForeground(new java.awt.Color(204, 204, 255));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Product ID:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Product Name:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Product Type:");

        TWOM.setNextFocusableComponent(THREEM);

        THREEM.setNextFocusableComponent(FOURM);
        THREEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                THREEMActionPerformed(evt);
            }
        });

        FOURM.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        FOURM.setNextFocusableComponent(FIVEM);
        FOURM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FOURMFocusLost(evt);
            }
        });

        FIVEM.setEditable(false);
        FIVEM.setNextFocusableComponent(SIXSM);

        SIXSM.setEditable(false);
        SIXSM.setNextFocusableComponent(SEVENM);
        SIXSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIXSMActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Sub-Total:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("Vat:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setText("Total Cost:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Date bought:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Qty / ml:");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setText("Notes:");

        SEVENM.setDateFormatString("yyyy-MM-dd");
        SEVENM.setNextFocusableComponent(EIGHTM);

        EIGHTM.setNextFocusableComponent(NINEM);
        EIGHTM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EIGHTMKeyPressed(evt);
            }
        });

        NINEM.setNextFocusableComponent(buttonAddM);

        radioNoVatM.setText("No Vat Applicable");
        radioNoVatM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoVatMActionPerformed(evt);
            }
        });

        btnChangeVatM.setText("Change Vat %");
        btnChangeVatM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeVatMActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("New Vat %:");

        MNEWVAT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        MNEWVAT.setText("15");
        MNEWVAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNEWVATActionPerformed(evt);
            }
        });
        MNEWVAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MNEWVATKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(THREEM)
                    .addComponent(TWOM, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(ONEM))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel44)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(FOURM, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FIVEM, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SIXSM, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NINEM)
                    .addComponent(EIGHTM, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SEVENM, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnChangeVatM, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioNoVatM))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MNEWVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(14, 14, 14))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(radioNoVatM)
                        .addGap(17, 17, 17)
                        .addComponent(btnChangeVatM))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(ONEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TWOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(THREEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SEVENM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel37)
                                    .addComponent(EIGHTM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel49)
                                    .addComponent(NINEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)
                                    .addComponent(MNEWVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FOURM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FIVEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SIXSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel43.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("AGRI8 Assist: After adding your product, first search the product ID in order to update product.");

        buttonAddM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonAddM.setText("ADD");
        buttonAddM.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonAddM.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonAddM.setName(""); // NOI18N
        buttonAddM.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonAddM.setRolloverEnabled(false);
        buttonAddM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddMActionPerformed(evt);
            }
        });

        buttonSearchM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchM.setText("SEARCH");
        buttonSearchM.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonSearchM.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonSearchM.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonSearchM.setRolloverEnabled(false);
        buttonSearchM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchMActionPerformed(evt);
            }
        });

        buttonUpdateM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonItem.png"))); // NOI18N
        buttonUpdateM.setText("UPDATE");
        buttonUpdateM.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonUpdateM.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonUpdateM.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonUpdateM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateMActionPerformed(evt);
            }
        });

        buttonDeleteM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteM.setText("DELETE");
        buttonDeleteM.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonDeleteM.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonDeleteM.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonDeleteM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteMActionPerformed(evt);
            }
        });

        buttonClearM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClearM.setText("CLEAR");
        buttonClearM.setMaximumSize(new java.awt.Dimension(103, 30));
        buttonClearM.setMinimumSize(new java.awt.Dimension(103, 30));
        buttonClearM.setName(""); // NOI18N
        buttonClearM.setPreferredSize(new java.awt.Dimension(103, 30));
        buttonClearM.setRolloverEnabled(false);
        buttonClearM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        tableMiscell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Type", "Sub-Total", "Vat", "Total Cost", "Date Bought", "Qty / ml", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMiscell);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tabMiscellaneousLayout = new javax.swing.GroupLayout(tabMiscellaneous);
        tabMiscellaneous.setLayout(tabMiscellaneousLayout);
        tabMiscellaneousLayout.setHorizontalGroup(
            tabMiscellaneousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMiscellaneousLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabMiscellaneousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(tabMiscellaneousLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(buttonAddM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSearchM, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteM, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabMiscellaneousLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        tabMiscellaneousLayout.setVerticalGroup(
            tabMiscellaneousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMiscellaneousLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addGroup(tabMiscellaneousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSearchM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(tabMiscellaneousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabMain.addTab("Miscellaneous", tabMiscellaneous);

        getContentPane().add(TabMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1150, 700));

        jPanel10.setBackground(new java.awt.Color(223, 164, 73));

        jLabel50.setBackground(new java.awt.Color(223, 164, 73));
        jLabel50.setForeground(new java.awt.Color(223, 164, 73));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logopng_200px.png"))); // NOI18N
        jLabel50.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(117, 66, 30));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonAnimal.setBackground(new java.awt.Color(117, 66, 30));
        buttonAnimal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonAnimal.setForeground(new java.awt.Color(223, 164, 73));
        buttonAnimal.setText("Animal Health");
        buttonAnimal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnimalActionPerformed(evt);
            }
        });

        buttonFeed.setBackground(new java.awt.Color(117, 66, 30));
        buttonFeed.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonFeed.setForeground(new java.awt.Color(223, 164, 73));
        buttonFeed.setText("Feed Stock");
        buttonFeed.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFeedActionPerformed(evt);
            }
        });

        buttonClose.setBackground(new java.awt.Color(117, 66, 30));
        buttonClose.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(223, 164, 73));
        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonClose.setText("Close");
        buttonClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonClose.setIconTextGap(15);
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        buttonHome.setBackground(new java.awt.Color(117, 66, 30));
        buttonHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonHome.setForeground(new java.awt.Color(223, 164, 73));
        buttonHome.setText("Home Page");
        buttonHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonHome.setMaximumSize(new java.awt.Dimension(165, 36));
        buttonHome.setMinimumSize(new java.awt.Dimension(165, 36));
        buttonHome.setPreferredSize(new java.awt.Dimension(165, 36));
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        buttonStock1.setBackground(new java.awt.Color(117, 66, 30));
        buttonStock1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        buttonStock1.setForeground(new java.awt.Color(223, 164, 73));
        buttonStock1.setText("Add Miscellaneous");
        buttonStock1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStock1ActionPerformed(evt);
            }
        });

        labelLogo.setBackground(new java.awt.Color(117, 66, 30));
        labelLogo.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(204, 204, 204));
        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setText("Farm Logo");
        labelLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelName.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        labelName.setForeground(new java.awt.Color(204, 204, 204));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Farm Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonFeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonStock1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(labelName)
                .addGap(31, 31, 31)
                .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonFeed, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1214, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnimalActionPerformed
        // TODO add your handling code here:
        
        TabMain.setSelectedIndex(1); 
        
    }//GEN-LAST:event_buttonAnimalActionPerformed

    private void buttonFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFeedActionPerformed
        // TODO add your handling code here:
         TabMain.setSelectedIndex(2); 
    }//GEN-LAST:event_buttonFeedActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        // Back to main page (Close button)
        
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        // TODO add your handling code here:
        TabMain.setSelectedIndex(0);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStock1ActionPerformed
         TabMain.setSelectedIndex(3);
    }//GEN-LAST:event_buttonStock1ActionPerformed

    private void buttonDeleteMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteMActionPerformed
      
        Connection conn = myConnection.getConnect();
        if(ONEM.equals("")) {

            JOptionPane.showMessageDialog(null, " Please select Row in the table to Delete!", "NO ROW SELECTED!", JOptionPane.ERROR_MESSAGE);

        } else {

            try {

                //Get Table Model

                DefaultTableModel tblModelA = (DefaultTableModel) tableMiscell.getModel();

                if(tableMiscell.getSelectedRowCount()==1) {

                    int row = tableMiscell.getSelectedRow();
                    String cell = tableMiscell.getModel().getValueAt(row, 0).toString();
                    tblModelA.removeRow((int) row);
                    String Deletesql = "DELETE FROM tbl_inventory_misc WHERE m_pid = ?";

                    PreparedStatement psm = conn.prepareStatement(Deletesql);
                    psm.setString(1,cell);

                    psm.execute();
                    JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);

                } else {

                    if(tableMiscell.getRowCount() == 0) {

                        // Table has no data / empty

                        JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);
                    } else {

                        // If table is not empty but no row selected
                        JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);

                    }
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.print("System or Database error: " + e);
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonDeleteMActionPerformed

    private void buttonUpdateMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateMActionPerformed
         Connection conn = myConnection.getConnect();
         
        String onem = ONEM.getText().trim();
        String twom = TWOM.getText().trim();
        String threem = THREEM.getText().trim();
        String fourm = FOURM.getText().trim();
        String fivem = FIVEM.getText().trim();
        String sixsm = SIXSM.getText().trim();
      //  Date sevenm = SEVENM.getDate();
        String eightm = EIGHTM.getText().trim();
        String ninem = NINEM.getText().trim();

        if(onem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please search Product ID to update!", "AGRI8 ASSIST: INSERT PRODUCT ID!", JOptionPane.ERROR_MESSAGE);
            FONE.requestFocus();
        } else if (onem.isEmpty() || twom.isEmpty() || threem.isEmpty() ||fourm.isEmpty() || fivem.isEmpty() || sixsm.isEmpty() || eightm.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please complete all fields!", "AGRI8 ASSIST: FIELDS NOT COMPLETED!", JOptionPane.ERROR_MESSAGE);
        }else {

            try {

                String Updatequery = "UPDATE tbl_inventory_misc SET " +
                "m_pid= '" + onem + "', m_pname = '" + twom + "', m_ptype = '" + threem + "', m_psubtotal= '" + fourm + "', m_pvat = '"
                + fivem + "', m_ptotal = '" + sixsm + "', m_pdatein = ?, m_pqty = '" + eightm + "', m_pnotes ='" + ninem+ "'" + " WHERE m_pid= '" + onem + "'";

                PreparedStatement statement = conn.prepareStatement(Updatequery);

                try{
                    // Accept Null excption from string to Integer
                    if ( SEVENM.getDate() != null ) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String  Date1 = sdf.format(SEVENM.getDate());

                        statement.setString(1, Date1);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please select 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                        statement.setNull(1, java.sql.Types.DATE);

                    }

                } catch (NullPointerException | NumberFormatException e) {
                    System.err.print("System Error: " + e);
                }


                int i = statement.executeUpdate();

                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + onem + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassInventory().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.print("System or Database error: " + e);
            }

        }
        
 
    }//GEN-LAST:event_buttonUpdateMActionPerformed

    private void buttonSearchMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchMActionPerformed
      Connection conn = myConnection.getConnect();
        String ID = ONEM.getText().trim();

        if(ID.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            ONEM.setBackground(Color.LIGHT_GRAY);
            ONEM.requestFocus();

        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT * FROM  tbl_inventory_misc  WHERE m_pid = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, ID);

                //Executing Query
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {

                    ONEM.setText(rs.getString("m_pid"));
                    TWOM.setText(rs.getString("m_pname"));
                    THREEM.setText(rs.getString("m_ptype"));
                    FOURM.setText(rs.getString("m_psubtotal"));
                    FIVEM.setText(rs.getString("m_pvat"));
                    SIXSM.setText(rs.getString("m_ptotal"));
                    SEVENM.setDate(rs.getDate("m_pdatein"));
                    EIGHTM.setText(rs.getString("m_pqty"));
                    NINEM.setText(rs.getString("m_pnotes"));

                  
                } else {
                    JOptionPane.showMessageDialog(null, "Product Not Found, Please check Product ID!", "ERROR ID", JOptionPane.ERROR_MESSAGE);
                }
                conn.close();

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonSearchMActionPerformed

    private void buttonAddMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddMActionPerformed
        // Save new Product to database

        String MONE = ONEM.getText().trim();
        String MTWO = TWOM.getText().trim();
        String MTHREE = THREEM.getText().trim();

        BigDecimal MFOUR = null;
        BigDecimal MFIVE = null;
        BigDecimal MSIXS = null;

        try {

            MFOUR = new BigDecimal(FOURM.getText());
            MFIVE = new BigDecimal(FIVEM.getText());
            MSIXS = new BigDecimal(SIXSM.getText());

        } catch (NullPointerException | NumberFormatException e) {

        }

        String MEIGHT = (EIGHTM.getText().trim());
        String MNINE = (NINEM.getText().trim());

        //Validation to check if controls are empty or not
        if(MONE.isEmpty() || MTWO.isEmpty() || MTHREE.isEmpty() || FOURM.getText().isEmpty() || MEIGHT.isEmpty() ) {

            JOptionPane.showMessageDialog(null, "Please Complete all fields!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);

        }else {

            try {

                Connection conn = myConnection.getConnect();

                //Check if PRODUCT ID already exists
                String checkName = "SELECT m_pid FROM tbl_inventory_misc WHERE m_pid = '" + MONE + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();

                // If Product ID has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Product ID: " + MONE + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {

                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_inventory_misc(m_pid, m_pname, m_ptype, m_psubtotal, m_pvat, m_ptotal, m_pdatein, m_pqty, m_pnotes)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    psm = conn.prepareStatement(saveQuery);

                    try{

                        // Accept Null excption from string to Integer
                        if ( SEVENM.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(SEVENM.getDate());
                            psm.setString(7, Date1);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(7, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException  e) {

                    }

                    try {
                        psm.setString(1, MONE);
                        psm.setString(2, MTWO);
                        psm.setString(3, MTHREE);
                        psm.setBigDecimal(4, MFOUR);
                        psm.setBigDecimal(5, MFIVE);
                        psm.setBigDecimal(6, MSIXS);
                        psm.setString(8, MEIGHT);
                        psm.setString(9, MNINE);

                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Product " + MONE + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                        this.dispose();
                        new ClassInventory().setVisible(true);

                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new Product to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                  System.err.print("System or Database error: " + e);
             //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonAddMActionPerformed

    private void MNEWVATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNEWVATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MNEWVATActionPerformed

    private void radioNoVatMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoVatMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNoVatMActionPerformed

    private void SIXSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIXSMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SIXSMActionPerformed

    private void FOURMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FOURMFocusLost
        // Calculation for Subtotal, Vat, Total and Cost per ml / kg

        try {

            if(radioNoVatM.isSelected()) {

                double vat = 0;
                double subTotal = Double.parseDouble(FOURM.getText());
                double Vat = (subTotal * vat) / 100;
                FIVEM.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                SIXSM.setText(Double.toString(Total));

            } else {

                double vat = Double.parseDouble(MNEWVAT.getText());
                double subTotal = Double.parseDouble(FOURM.getText());
                double Vat = (subTotal * vat) / 100;
                FIVEM.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                SIXSM.setText(Double.toString(Total));

            }
        } catch (NullPointerException | NumberFormatException e) {
                  System.err.print("System or Database error: " + e);
        }
    }//GEN-LAST:event_FOURMFocusLost

    private void buttonfClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonfClearActionPerformed

        this.dispose();
        new ClassInventory().setVisible(true);
    }//GEN-LAST:event_buttonfClearActionPerformed

    private void buttonfDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonfDeleteActionPerformed

        Connection conn = myConnection.getConnect();
        if(FONE.equals("")) {

            JOptionPane.showMessageDialog(null, " Please select Row in the table to Delete!", "NO ROW SELECTED!", JOptionPane.ERROR_MESSAGE);

        } else {

            try {

                //Get Table Model

                DefaultTableModel tblModelA = (DefaultTableModel) tableFeed.getModel();

                if(tableFeed.getSelectedRowCount()==1) {

                    int row = tableFeed.getSelectedRow();
                    String cell = tableFeed.getModel().getValueAt(row, 0).toString();
                    tblModelA.removeRow((int) row);
                    String Deletesql = "DELETE FROM tbl_inventory_feedstock WHERE f_pid = ?";

                    PreparedStatement psm = conn.prepareStatement(Deletesql);
                    psm.setString(1,cell);

                    psm.execute();
                    JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);

                } else {

                    if(tableFeed.getRowCount() == 0) {

                        // Table has no data / empty

                        JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);
                    } else {

                        // If table is not empty but no row selected
                        JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);

                    }
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.print("System or Database error: " + e);
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonfDeleteActionPerformed

    private void buttonfUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonfUpdateActionPerformed

        Connection conn = myConnection.getConnect();

        String ONEF = FONE.getText().trim();
        String TWOF = FTWO.getText().trim();
        String THREEF = (String) FTHREE.getSelectedItem();
        String FOURF = FFOUR.getText().trim();
        String FIVEF = FFIVE.getText().trim();
        String SIXSF = FSIXS.getText().trim();
        String SEVENF = FSEVEN.getText().trim();
        String EIGHTF = FEIGHT.getText().trim();
        String ELEVENF = FELEVEN.getText().trim();

        if(ONEF.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please search Product ID to update!", "AGRI8 ASSIST: INSERT PRODUCT ID!", JOptionPane.ERROR_MESSAGE);
            FONE.requestFocus();
        } else if (ONEF.isEmpty() || TWOF.isEmpty() || FTHREE == null || FOURF.equals("SELECT") || FIVEF.isEmpty() ||SIXSF.isEmpty() ||
            SEVENF.isEmpty() || EIGHTF.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please complete all fields!", "AGRI8 ASSIST: FIELDS NOT COMPLETED!", JOptionPane.ERROR_MESSAGE);
        }else {

            try {

                String Updatequery = "UPDATE tbl_inventory_feedstock SET " +
                "f_pid= '" + ONEF + "', f_pname = '" + TWOF + "', f_ptype = '" + THREEF + "', f_psubtotal= '" + FOURF + "', f_pvat = '"
                + FIVEF + "', f_ptotal = '" + SIXSF + "', f_pqty = '" + SEVENF + "', f_costper = '" + EIGHTF + "', f_pdatein = ?, f_pdateout=?, f_pnotes ='" + ELEVENF+ "'" + " WHERE f_pid= '" + ONEF + "'";

                PreparedStatement statement = conn.prepareStatement(Updatequery);

                try{
                    // Accept Null excption from string to Integer
                    if ( FNINE.getDate() != null ) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String  Date1 = sdf.format(FNINE.getDate());

                        statement.setString(1, Date1);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please select 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                        statement.setNull(1, java.sql.Types.DATE);

                    }

                } catch (NullPointerException | NumberFormatException e) {
                    System.err.print("System Error: " + e);
                }

                try{
                    // Accept Null excption from string to Integer
                    if ( FTEN.getDate() != null ) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String  Date2 = sdf.format(FTEN.getDate());
                        statement.setString(2, Date2);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please select 'EXPIRATION DATE '!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                        statement.setNull(2, java.sql.Types.DATE);
                    }

                } catch (NullPointerException| NumberFormatException e) {
                    System.err.print("System Error: " + e);
                }

                int i = statement.executeUpdate();

                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + ONEF + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassInventory().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.print("System or Database error: " + e);
            }

        }
    }//GEN-LAST:event_buttonfUpdateActionPerformed

    private void buttonfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonfSearchActionPerformed

        Connection conn = myConnection.getConnect();
        String IDSEARCH = FONE.getText().trim();

        if(IDSEARCH.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            aone.setBackground(Color.LIGHT_GRAY);
            aone.requestFocus();

        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT * FROM  tbl_inventory_feedstock  WHERE f_pid = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, IDSEARCH);

                //Executing Query
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {

                    FONE.setText(rs.getString("f_pid"));
                    FTWO.setText(rs.getString("f_pname"));
                    FTHREE.setSelectedItem(rs.getString("f_ptype"));
                    FFOUR.setText(rs.getString("f_psubtotal"));
                    FFIVE.setText(rs.getString("f_pvat"));
                    FSIXS.setText(rs.getString("f_ptotal"));
                    FSEVEN.setText(rs.getString("f_pqty"));
                    FEIGHT.setText(rs.getString("f_costper"));
                    FNINE.setDate(rs.getDate("f_pdatein"));
                    FTEN.setDate(rs.getDate("f_pdateout"));
                    FELEVEN.setText(rs.getString("f_pnotes"));

                    aone.requestFocus(true);
                    aone.setBackground(Color.WHITE);

                }
                conn.close();

            } catch (SQLException | HeadlessException | NumberFormatException | NullPointerException e) {
                System.err.println(e.getMessage());
            //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonfSearchActionPerformed

    private void buttonfAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonfAddActionPerformed
        // Save new Product to database

        String ONEF = FONE.getText().trim();
        String TWOF = FTWO.getText().trim();
        String THREEF = (String) FTHREE.getSelectedItem();
        String SEVENF = FSEVEN.getText().trim();
        String ELEVENF = FELEVEN.getText().trim();

        BigDecimal FOURF = null;
        BigDecimal FIVEF = null;
        BigDecimal SIXSF = null;
        BigDecimal EIGHTF = null;

        try {
            FOURF = new BigDecimal(FFOUR.getText());
            FIVEF = new BigDecimal(FFIVE.getText());
            SIXSF = new BigDecimal(FSIXS.getText());
            EIGHTF = new BigDecimal(FEIGHT.getText());
        } catch (NumberFormatException e) {

        }

        //Validation to check if controls are empty or not
        if(ONEF.isEmpty() || TWOF.isEmpty() || THREEF.isEmpty() || SEVENF.isEmpty() || FFOUR.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Complete all fields!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);

        }else {

            try {

                Connection conn = myConnection.getConnect();

                //Check if PRODUCT ID already exists
                String checkName = "SELECT f_pid FROM tbl_inventory_feedstock WHERE f_pid = '" + FONE + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();

                // If Product ID has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Product ID: " + FONE + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {

                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_inventory_feedstock(f_pid, f_pname, f_ptype, f_psubtotal, f_pvat, f_ptotal, f_pqty, f_costper, f_pdatein,  f_pdateout, f_pnotes)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    psm = conn.prepareStatement(saveQuery);

                    try{

                        // Accept Null excption from string to Integer
                        if ( FNINE.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(FNINE.getDate());
                            psm.setString(9, Date1);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(9, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException  e) {

                    }

                    try{
                        // Accept Null excption from string to Integer
                        if ( FTEN.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(FTEN.getDate());
                            psm.setString(10, Date2);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'EXPIRATION DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(10, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    try {

                        psm.setString(1, ONEF);
                        psm.setString(2, TWOF);
                        psm.setString(3, THREEF);
                        psm.setBigDecimal(4, FOURF);
                        psm.setBigDecimal(5, FIVEF);
                        psm.setBigDecimal(6, SIXSF);
                        psm.setString(7, SEVENF);
                        psm.setBigDecimal(8, EIGHTF);
                        psm.setString(11, ELEVENF);

                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Product " + ONEF + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                       this.dispose();
                       new ClassInventory().setVisible(true);

                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new Product to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                }

            } catch (SQLException | HeadlessException | NumberFormatException | NullPointerException e) {
                  System.err.print("System or Database error: " + e);
         
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonfAddActionPerformed

    private void FNEWVATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNEWVATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNEWVATActionPerformed

    private void btnChangeVat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeVat1ActionPerformed
        if(btnChangeVat1.isSelected()){
            FNEWVAT.setEnabled(true);
        } else {
            FNEWVAT.setEnabled(false);
        }

    }//GEN-LAST:event_btnChangeVat1ActionPerformed

    private void FFOURFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FFOURFocusLost

        // Calculation for Subtotal, Vat, Total and Cost per ml / kg

        try {

            if(RADIONOVAT.isSelected()) {

                double vat = 0;
                double SubTotal = Double.parseDouble(FFOUR.getText());
                double VAT = (SubTotal * vat) / 100;
                FFIVE.setText(Double.toString(VAT));

                double ToTal = (SubTotal + VAT);
                FSIXS.setText(Double.toString(ToTal));

            } else {

                double vat = Double.parseDouble(FNEWVAT.getText());
                double SubTotal = Double.parseDouble(FFOUR.getText());
                double VAT = (SubTotal * vat) / 100;
                FFIVE.setText(Double.toString(VAT));

                double ToTal = (SubTotal + VAT);
                FSIXS.setText(Double.toString(ToTal));

            }
        } catch (NullPointerException | NumberFormatException e) {
            System.err.print("System Error: " + e);
        }

    }//GEN-LAST:event_FFOURFocusLost

    private void FSEVENFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FSEVENFocusLost
        try {

            double Total = Double.parseDouble(FSIXS.getText());
            double Qty = Double.parseDouble(FSEVEN.getText());
            double Costper = (Total / Qty);
            FEIGHT.setText(Double.toString(Costper));
        } catch (NullPointerException | NumberFormatException e) {
                  System.err.print("System or Database error: " + e);
         
        }
    }//GEN-LAST:event_FSEVENFocusLost

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        // Clear Textfields

       this.dispose();
       new ClassInventory().setVisible(true);
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        Connection conn = myConnection.getConnect();
        if(aone.equals("")) {

            JOptionPane.showMessageDialog(null, " Please select Row in the table to Delete!", "NO ROW SELECTED!", JOptionPane.ERROR_MESSAGE);

        } else {

            try {

                //Get Table Model

                DefaultTableModel tblModelA = (DefaultTableModel) tableAnimale.getModel();

                if(tableAnimale.getSelectedRowCount()==1) {

                    int row = tableAnimale.getSelectedRow();
                    String cell = tableAnimale.getModel().getValueAt(row, 0).toString();
                    tblModelA.removeRow((int) row);
                    String sql = "DELETE FROM tbl_inventory_vaccination WHERE a_pid = ?";

                    PreparedStatement psm = conn.prepareStatement(sql);
                    psm.setString(1,cell);

                    psm.execute();
                    JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);
                    
                       aone.setText("");
                        atwo.setText("");
                        athree.setSelectedIndex(-1);
                        afour.setText("");
                        afive.setText("");
                        asixs.setText("");
                        aten.setDate(null);
                        aeleven.setDate((null));
                        aeight.setText("");
                        aseven.setText("");
                        anine.setText("");
                        atwelve.setText("");
                        radioNoVat.setSelected(false);
                        btnChangeVat.setSelected(false);
                        newVat.setEnabled(false);
                    
                    
                    
                } else {

                    if(tableAnimale.getRowCount() == 0) {

                        // Table has no data / empty

                        JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);
                    } else {

                        // If table is not empty but no row selected
                        JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);

                    }
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                       System.err.println(e.getMessage());
     //           JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed

        Connection conn = myConnection.getConnect();

        String ONEA = aone.getText().trim();
        String TWOA =  atwo.getText().trim();
        String THREEA =  (String) athree.getSelectedItem();
        String FOURA = afour.getText().trim();
        String FIVEA = afive.getText().trim();
        String SIXSA =  asixs.getText().trim();
        String SEVENA = aseven.getText().trim();
        String EIGHTA = aeight.getText().trim();
        String NINEA =  anine.getText().trim();
        //Date TENA = (Date) aten.getDate();
        //Date ELEVENA =  (Date) aeleven.getDate();
        String TWELVEA = (String) atwelve.getText().trim();

        if(ONEA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please search Product ID to update!", "AGRI8 ASSIST: INSERT PRODUCT ID!", JOptionPane.ERROR_MESSAGE);
            aone.requestFocus();
        } else if (ONEA.isEmpty() || TWOA.isEmpty() || athree == null || THREEA.equals("SELECT") || FOURA.isEmpty() || SEVENA.isEmpty() || EIGHTA.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please complete all fields!", "AGRI8 ASSIST: FIELDS NOT COMPLETED!", JOptionPane.ERROR_MESSAGE);
        }else {

            try {

                String query = "UPDATE tbl_inventory_vaccination  SET " +
                "a_pid= '" + ONEA + "', a_pname = '" + TWOA + "', a_ptype = '" + THREEA + "', a_psubtotal= '" + FOURA + "', a_pvat = '"
                + FIVEA + "', a_ptotal = '" + SIXSA + "', a_pdoses = '" + SEVENA + "', a_pqty = '" + EIGHTA + "', a_pcostper = '" + NINEA + "', a_pdatein = ?, a_pdateout=?, a_pnotes ='" + TWELVEA+ "'" + " WHERE a_pid= '" + ONEA + "'";

                PreparedStatement statement = conn.prepareStatement(query);

                try{
                    // Accept Null excption from string to Integer
                    if ( aten.getDate() != null ) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String  Date1 = sdf.format(aten.getDate());

                        statement.setString(1, Date1);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please select 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                        statement.setNull(1, java.sql.Types.DATE);

                    }

                } catch (NullPointerException | NumberFormatException e) {

                }

                try{
                    // Accept Null excption from string to Integer
                    if ( aeleven.getDate() != null ) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String  Date2 = sdf.format(aeleven.getDate());
                        statement.setString(2, Date2);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please select 'EXPIRATION DATE '!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                        statement.setNull(2, java.sql.Types.DATE);
                    }

                } catch (NullPointerException| NumberFormatException e) {

                }

                int i = statement.executeUpdate();

                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + ONEA + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassInventory().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.print("System or Database error: " + e);
            }

        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed

        Connection conn = myConnection.getConnect();
        String SEARCHID = aone.getText().trim();

        if(SEARCHID.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter ID to search!");
            aone.setBackground(Color.LIGHT_GRAY);
            aone.requestFocus();

        } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT * FROM  tbl_inventory_vaccination  WHERE a_pid = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, SEARCHID);

                //Executing Query
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {

                    aone.setText(rs.getString("a_pid"));
                    atwo.setText(rs.getString("a_pname"));
                    athree.setSelectedItem(rs.getString("a_ptype"));
                    afour.setText(rs.getString("a_psubtotal"));
                    afive.setText(rs.getString("a_pvat"));
                    asixs.setText(rs.getString("a_ptotal"));
                    aseven.setText(rs.getString("a_pdoses"));
                    aeight.setText(rs.getString("a_pqty"));
                    anine.setText(rs.getString("a_pcostper"));
                    aten.setDate(rs.getDate("a_pdatein"));
                    aeleven.setDate(rs.getDate("a_pdateout"));
                    atwelve.setText(rs.getString("a_pnotes"));

                    aone.requestFocus(true);
                    aone.setBackground(Color.WHITE);

                }
                conn.close();

            } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
             //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonPAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPAddActionPerformed

        // Save new Product to database

        String ONE = aone.getText().trim();
        String TWO = atwo.getText().trim();
        String THREE = (String) athree.getSelectedItem();

        BigDecimal FOUR = null;
        BigDecimal FIVE = null;
        BigDecimal SIXS = null;
        BigDecimal NINE = null;

        try {
            FOUR = new BigDecimal(afour.getText());
            FIVE = new BigDecimal(afive.getText());
            SIXS = new BigDecimal(asixs.getText());
            NINE = new BigDecimal(anine.getText());
        } catch (NumberFormatException | NullPointerException e) {

        }
        String SEVEN = (aseven.getText().trim());
        String EIGHT = (aeight.getText().trim());
        String TWELVE = (atwelve.getText().trim());

        //Validation to check if controls are empty or not
        if(ONE.isEmpty() || TWO.isEmpty() || THREE.isEmpty() || afour.getText().isEmpty() || SEVEN.isEmpty() || EIGHT.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Complete all fields!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);

        }else {

            try {

                Connection conn = myConnection.getConnect();

                //Check if PRODUCT ID already exists
                String checkName = "SELECT a_pid FROM tbl_inventory_vaccination WHERE a_pid = '" + ONE + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();

                // If Product ID has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Product ID: " + ONE + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {

                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_inventory_vaccination(a_pid, a_pname, a_ptype, a_psubtotal, a_pvat, a_ptotal, a_pdoses, a_pqty,  a_pcostper, a_pdatein,  a_pdateout,  a_pnotes)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    psm = conn.prepareStatement(saveQuery);

                    try{

                        // Accept Null excption from string to Integer
                        if ( aten.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(aten.getDate());
                            psm.setString(10, Date1);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(10, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException  e) {

                    }

                    try{
                        // Accept Null excption from string to Integer
                        if ( aeleven.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(aeleven.getDate());
                            psm.setString(11, Date2);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'EXPIRATION DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(11, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    try {
                        psm.setString(1, ONE);
                        psm.setString(2, TWO);
                        psm.setString(3, THREE);
                        psm.setBigDecimal(4, FOUR);
                        psm.setBigDecimal(5, FIVE);
                        psm.setBigDecimal(6, SIXS);
                        psm.setString(7, SEVEN);
                        psm.setString(8, EIGHT);
                        psm.setBigDecimal(9, NINE);
                        psm.setString(12, TWELVE);
                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Product " + ONE + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                        aone.setText("");
                        atwo.setText("");
                        athree.setSelectedIndex(-1);
                        afour.setText("");
                        afive.setText("");
                        asixs.setText("");
                        aseven.setText("");
                        aeight.setText("");
                        anine.setText("");
                        aten.setDate(null);
                        aeleven.setDate(null);
                        atwelve.setText("");

                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new Product to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                }

            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                 System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonPAddActionPerformed

    private void btnChangeVatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeVatActionPerformed

        if(btnChangeVat.isSelected()){
            newVat.setEnabled(true);
        } else {
            newVat.setEnabled(false);
        }

    }//GEN-LAST:event_btnChangeVatActionPerformed

    private void newVatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newVatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newVatActionPerformed

    private void radioNoVatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoVatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNoVatActionPerformed

    private void asixsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asixsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asixsActionPerformed

    private void asixsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_asixsFocusLost

    }//GEN-LAST:event_asixsFocusLost

    private void afourFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_afourFocusLost
        // Calculation for Subtotal, Vat, Total and Cost per ml / kg

        try {

            if(radioNoVat.isSelected()) {

                double vat = 0;
                double subTotal = Double.parseDouble(afour.getText());
                double Vat = (subTotal * vat) / 100;
                afive.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                asixs.setText(Double.toString(Total));

            } else {

                double vat = Double.parseDouble(newVat.getText());
                double subTotal = Double.parseDouble(afour.getText());
                double Vat = (subTotal * vat) / 100;
                afive.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                asixs.setText(Double.toString(Total));

            }
        } catch (NullPointerException | NumberFormatException e) {
                       System.err.println(e.getMessage());
        
        }

    }//GEN-LAST:event_afourFocusLost

    private void aeightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aeightMouseExited
        // TODO add your handling code here:

        /*
        Integer qty = Integer.parseInt(tfaQty.getText());
        Double Total = Double.parseDouble(tfaTotal.getText());
        Double totelper = qty / Total;
        String Totalper = String.format("R %2f", totelper);
        tfaCostper.setText(Totalper);
        */

    }//GEN-LAST:event_aeightMouseExited

    private void aeightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aeightFocusLost

        try {

            double Total = Double.parseDouble(asixs.getText());
            double Qty = Double.parseDouble(aeight.getText());
            double Costper = Math.round(Total / Qty);
            anine.setText(Double.toString(Costper));
        } catch (NullPointerException e) {
                   System.err.println(e.getMessage());
        
        }
    }//GEN-LAST:event_aeightFocusLost

    private void buttonClearMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearMActionPerformed
        this.dispose();
        new ClassInventory().setVisible(true);
    }//GEN-LAST:event_buttonClearMActionPerformed

    private void btnChangeVatMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeVatMActionPerformed
           if(btnChangeVatM.isSelected()){
            MNEWVAT.setEnabled(true);
        } else {
            MNEWVAT.setEnabled(false);
        }
    }//GEN-LAST:event_btnChangeVatMActionPerformed

    private void EIGHTMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EIGHTMKeyPressed
            // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups
                
        String size = EIGHTM.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                EIGHTM.setEditable(true);
            } else {
                 EIGHTM.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                EIGHTM.setEditable(true);
            } else {
                EIGHTM.setEditable(false);
            }
        }
    }//GEN-LAST:event_EIGHTMKeyPressed

    private void FEIGHTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FEIGHTKeyReleased
         // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups
                
        String size = FEIGHT.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                FEIGHT.setEditable(true);
            } else {
                 FEIGHT.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                FEIGHT.setEditable(true);
            } else {
                FEIGHT.setEditable(false);
            }
        }
    }//GEN-LAST:event_FEIGHTKeyReleased

    private void asevenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asevenKeyPressed
         // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups
                
        String size = aseven.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<100) {
                aseven.setEditable(true);
            } else {
                 aseven.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                aseven.setEditable(true);
            } else {
                aseven.setEditable(false);
            }
        }
    }//GEN-LAST:event_asevenKeyPressed

    private void aeightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aeightKeyPressed
             // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups
                
        String size = aeight.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                aeight.setEditable(true);
            } else {
                 aeight.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                aeight.setEditable(true);
            } else {
                aeight.setEditable(false);
            }
        }
    }//GEN-LAST:event_aeightKeyPressed

    private void buttonSearchInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchInvActionPerformed
      
        this.dispose();
        new ClassInventory().setVisible(true);
    }//GEN-LAST:event_buttonSearchInvActionPerformed

    private void productIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productIDItemStateChanged
       // Filter by Type
        
        String query = (String) productID.getSelectedItem().toString();
        filter(query);
        
    }//GEN-LAST:event_productIDItemStateChanged

    private void productNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productNameItemStateChanged
        
         // Filter by Type
        
        String query = (String) productName.getSelectedItem().toString();
        filter(query);
        
    }//GEN-LAST:event_productNameItemStateChanged

    private void FSEVENKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FSEVENKeyPressed
       
         String number = FSEVEN.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                FSEVEN.setEditable(true);
            } else {
                 FSEVEN.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                FSEVEN.setEditable(true);
            } else {
                FSEVEN.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
            
        }
    }//GEN-LAST:event_FSEVENKeyPressed

    private void FNEWVATKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FNEWVATKeyPressed
        
         String number = FNEWVAT.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                FNEWVAT.setEditable(true);
            } else {
                 FNEWVAT.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                FNEWVAT.setEditable(true);
            } else {
                FNEWVAT.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
              System.err.println(e.getMessage());
        
        }
    }//GEN-LAST:event_FNEWVATKeyPressed

    private void MNEWVATKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MNEWVATKeyPressed
     
        String number = MNEWVAT.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                MNEWVAT.setEditable(true);
            } else {
                 MNEWVAT.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                MNEWVAT.setEditable(true);
            } else {
                MNEWVAT.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
               System.err.println(e.getMessage());
        
        }
    }//GEN-LAST:event_MNEWVATKeyPressed

    private void newVatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newVatKeyPressed
       
        String number = newVat.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                newVat.setEditable(true);
            } else {
                 newVat.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                newVat.setEditable(true);
            } else {
                newVat.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        
        }
    }//GEN-LAST:event_newVatKeyPressed

    private void THREEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_THREEMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_THREEMActionPerformed

 
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
            java.util.logging.Logger.getLogger(ClassInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EIGHTM;
    private javax.swing.JTextField FEIGHT;
    private javax.swing.JTextField FELEVEN;
    private javax.swing.JTextField FFIVE;
    private javax.swing.JTextField FFOUR;
    private javax.swing.JTextField FIVEM;
    private javax.swing.JTextField FNEWVAT;
    private com.toedter.calendar.JDateChooser FNINE;
    private javax.swing.JTextField FONE;
    private javax.swing.JTextField FOURM;
    private javax.swing.JTextField FSEVEN;
    private javax.swing.JTextField FSIXS;
    private com.toedter.calendar.JDateChooser FTEN;
    private javax.swing.JComboBox<String> FTHREE;
    private javax.swing.JTextField FTWO;
    private javax.swing.JTextField MNEWVAT;
    private javax.swing.JTextField NINEM;
    private javax.swing.JTextField ONEM;
    private javax.swing.JRadioButton RADIONOVAT;
    private com.toedter.calendar.JDateChooser SEVENM;
    private javax.swing.JTextField SIXSM;
    private javax.swing.JTextField THREEM;
    private javax.swing.JTextField TWOM;
    private javax.swing.JTabbedPane TabMain;
    private javax.swing.JTextField aeight;
    private com.toedter.calendar.JDateChooser aeleven;
    private javax.swing.JTextField afive;
    private javax.swing.JTextField afour;
    private javax.swing.JTextField anine;
    private javax.swing.JTextField aone;
    private javax.swing.JTextField aseven;
    private javax.swing.JTextField asixs;
    private com.toedter.calendar.JDateChooser aten;
    private javax.swing.JComboBox<String> athree;
    private javax.swing.JTextField atwelve;
    private javax.swing.JTextField atwo;
    private javax.swing.JToggleButton btnChangeVat;
    private javax.swing.JToggleButton btnChangeVat1;
    private javax.swing.JToggleButton btnChangeVatM;
    private javax.swing.JButton buttonAddM;
    private javax.swing.JButton buttonAnimal;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonClearM;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDeleteM;
    private javax.swing.JButton buttonFeed;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonPAdd;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonSearchInv;
    private javax.swing.JButton buttonSearchM;
    private javax.swing.JButton buttonStock1;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonUpdateM;
    private javax.swing.JButton buttonfAdd;
    private javax.swing.JButton buttonfClear;
    private javax.swing.JButton buttonfDelete;
    private javax.swing.JButton buttonfSearch;
    private javax.swing.JButton buttonfUpdate;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelName;
    private javax.swing.JTextField newVat;
    private javax.swing.JComboBox<String> productID;
    private javax.swing.JComboBox<String> productName;
    private javax.swing.JRadioButton radioNoVat;
    private javax.swing.JRadioButton radioNoVatM;
    private javax.swing.JPanel tabAnimalHealth;
    private javax.swing.JPanel tabFeedstock;
    private javax.swing.JPanel tabHomePage;
    private javax.swing.JPanel tabMiscellaneous;
    private javax.swing.JTable tableAnimale;
    private javax.swing.JTable tableFeed;
    private javax.swing.JTable tableHome;
    private javax.swing.JTable tableMiscell;
    private javax.swing.JScrollPane tablejscoll;
    private javax.swing.JTextField tfPCost;
    // End of variables declaration//GEN-END:variables
}
