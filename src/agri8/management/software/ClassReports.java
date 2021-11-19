package agri8.management.software;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;


public class ClassReports extends javax.swing.JFrame {

    MySQLConnect myConnection;
    
    public ClassReports() {
        icon();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         myConnection = new MySQLConnect();
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
     
        public void loadReportBalanceSheet()  {
      
        String reportid = reportBalance.getText().trim();
        
        if (reportid.isEmpty()){
           
            JOptionPane.showMessageDialog(null, " Please Enter Balancesheet ID to generate report, e.g. BALANCE1" ,"AGRI8 DIALOG: ENTER BALANCESHEET ID", JOptionPane.ERROR_MESSAGE);
    } else {
        
        try {
            Connection conn = myConnection.getConnect();
            HashMap a = new HashMap();
            a.put("bsid", reportBalance.getText());
            
            reportPanelFinancial.removeAll();
            reportPanelFinancial.repaint();
            reportPanelFinancial.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportBalancesheet.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, a, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelFinancial.setLayout(new BorderLayout());
            reportPanelFinancial.add(v);
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
    }
        
            public void loadReportAccounts()  {
      
        String reportid = reportAccounts.getText().trim();
        
        if (reportid.isEmpty()){
           
            JOptionPane.showMessageDialog(null, " Please Enter Trading Account ID to generate report, e.g. ACCOUNT1" ,"AGRI8 DIALOG: ENTER TRADING ACCOUNT ID", JOptionPane.ERROR_MESSAGE);
    } else {
        
        try {
            Connection conn = myConnection.getConnect();
            HashMap a = new HashMap();
            a.put("a_id", reportAccounts.getText());
            
            reportPanelFinancial.removeAll();
            reportPanelFinancial.repaint();
            reportPanelFinancial.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\reportAccounts.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, a, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelFinancial.setLayout(new BorderLayout());
            reportPanelFinancial.add(v);
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
    }
     
        public void loadReportSheep()  {
      
        String reportid = reportSheepID.getText().trim();
        
        if (reportid.isEmpty()){
           
            JOptionPane.showMessageDialog(null, " Please Enter Sheep ID to generate report, e.g. SAU18-898" ,"AGRI8 DIALOG: ENTER SHEEP ID", JOptionPane.ERROR_MESSAGE);
    } else {
        
        try {
            Connection conn = myConnection.getConnect();
            HashMap a = new HashMap();
            a.put("s_tag_id", reportSheepID.getText());
            
            reportPanelSheep.removeAll();
            reportPanelSheep.repaint();
            reportPanelSheep.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportSheep.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, a, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelSheep.setLayout(new BorderLayout());
            reportPanelSheep.add(v);
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
    }
     
     
     
     
     
    public void loadReportGoats()  {
      
        String reportid = reportGoatID.getText().trim();
        
        if (reportid.isEmpty()){
           
            JOptionPane.showMessageDialog(null, " Please Enter Goat ID to generate report, e.g. GAU18-898" ,"AGRI8 DIALOG: ENTER GOAT ID", JOptionPane.ERROR_MESSAGE);
    } else {
        
        try {
            Connection conn = myConnection.getConnect();
            HashMap a = new HashMap();
            a.put("g_tag_id", reportGoatID.getText());
            
            reportPanelGoats.removeAll();
            reportPanelGoats.repaint();
            reportPanelGoats.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportAllGoats.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, a, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelGoats.setLayout(new BorderLayout());
            reportPanelGoats.add(v);
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
    }

     public void loadReportCattle()  {
      
        String reportid = reportID.getText().trim();
        
        if (reportid.isEmpty()){
           
            JOptionPane.showMessageDialog(null, " Please Enter Cattle ID to generate report, e.g. WDW18-898" ,"AGRI8 DIALOG: ENTER CATTLE ID", JOptionPane.ERROR_MESSAGE);
    } else {
        
        try {
            Connection conn = myConnection.getConnect();
            HashMap a = new HashMap();
            a.put("c_tag_id", reportID.getText());
            
            reportPanelCattle.removeAll();
            reportPanelCattle.repaint();
            reportPanelCattle.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportCattle.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, a, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelCattle.setLayout(new BorderLayout());
            reportPanelCattle.add(v);
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
    }

    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        reportPanelCattle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reportID = new javax.swing.JTextField();
        buttonGenerate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnCattleHerd = new javax.swing.JButton();
        btnCalfHerd = new javax.swing.JButton();
        btnMatingHerd = new javax.swing.JButton();
        btnWeanerHerd = new javax.swing.JButton();
        btnHerdHealth = new javax.swing.JButton();
        btnHerdHealth1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        reportGoatID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        buttonGenerate1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        reportPanelGoats = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnGoatHerd = new javax.swing.JButton();
        btnKidHerd = new javax.swing.JButton();
        btnMatingGoats = new javax.swing.JButton();
        btnWeanerGoats = new javax.swing.JButton();
        btnHealthGoats = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnSheepHerd = new javax.swing.JButton();
        btnLambHerd = new javax.swing.JButton();
        btnMatingSheeps = new javax.swing.JButton();
        btnWeanerSheep = new javax.swing.JButton();
        btnHealthSheep = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        reportSheepID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        buttonGenerateSheep = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        reportPanelSheep = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        reportBalance = new javax.swing.JTextField();
        btnGenerateBS = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnSheepHerd1 = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnSheepHerd4 = new javax.swing.JButton();
        reportPanelFinancial = new javax.swing.JPanel();
        btnContact = new javax.swing.JButton();
        btnLabour = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        reportAccounts = new javax.swing.JTextField();
        btnGenerateBS1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        reportPanelAnimal = new javax.swing.JPanel();
        btnAnimalHealthInv = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnFeedStock1 = new javax.swing.JButton();
        btnMisc1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        reportFeedStock = new javax.swing.JTextField();
        btnFeedstock = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        btnFeedStock = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        reportPanelFeed = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        reportMisc = new javax.swing.JTextField();
        btnMiscGenerate = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        btnMisc = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        reportPanelMisc = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        reportPanelCattle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout reportPanelCattleLayout = new javax.swing.GroupLayout(reportPanelCattle);
        reportPanelCattle.setLayout(reportPanelCattleLayout);
        reportPanelCattleLayout.setHorizontalGroup(
            reportPanelCattleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reportPanelCattleLayout.setVerticalGroup(
            reportPanelCattleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Individual Cattle ID Report:");

        reportID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        buttonGenerate.setBackground(new java.awt.Color(102, 102, 255));
        buttonGenerate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGenerate.setForeground(new java.awt.Color(0, 0, 0));
        buttonGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-livestock-16.png"))); // NOI18N
        buttonGenerate.setText("GENERATE");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AGRI8 Assist: Please enter Cattle ID to generate individual report!");

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        btnCattleHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnCattleHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCattleHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnCattleHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livestock (2).png"))); // NOI18N
        btnCattleHerd.setText("CATTLE HERD");
        btnCattleHerd.setIconTextGap(12);
        btnCattleHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCattleHerdActionPerformed(evt);
            }
        });

        btnCalfHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnCalfHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCalfHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnCalfHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/horseshoe.png"))); // NOI18N
        btnCalfHerd.setText("CALF HERD");
        btnCalfHerd.setIconTextGap(26);
        btnCalfHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalfHerdActionPerformed(evt);
            }
        });

        btnMatingHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnMatingHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMatingHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnMatingHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        btnMatingHerd.setText("MATING HERD");
        btnMatingHerd.setIconTextGap(12);
        btnMatingHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatingHerdActionPerformed(evt);
            }
        });

        btnWeanerHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnWeanerHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnWeanerHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnWeanerHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/weaner.png"))); // NOI18N
        btnWeanerHerd.setText("WEANER HERD");
        btnWeanerHerd.setIconTextGap(12);
        btnWeanerHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWeanerHerdActionPerformed(evt);
            }
        });

        btnHerdHealth.setBackground(new java.awt.Color(102, 102, 102));
        btnHerdHealth.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHerdHealth.setForeground(new java.awt.Color(0, 255, 255));
        btnHerdHealth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/syringe.png"))); // NOI18N
        btnHerdHealth.setText("HERD HEALTH");
        btnHerdHealth.setIconTextGap(12);
        btnHerdHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHerdHealthActionPerformed(evt);
            }
        });

        btnHerdHealth1.setBackground(new java.awt.Color(102, 102, 102));
        btnHerdHealth1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHerdHealth1.setForeground(new java.awt.Color(0, 255, 255));
        btnHerdHealth1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnHerdHealth1.setText("CLOSE");
        btnHerdHealth1.setIconTextGap(12);
        btnHerdHealth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHerdHealth1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCattleHerd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCalfHerd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
            .addComponent(btnMatingHerd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWeanerHerd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
            .addComponent(btnHerdHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHerdHealth1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCattleHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnCalfHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnMatingHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnWeanerHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnHerdHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHerdHealth1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                                .addGap(158, 158, 158))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(reportID, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reportPanelCattle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(reportID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportPanelCattle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Cattle Report", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Individual Goat ID Report:");

        reportGoatID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("AGRI8 Assist: Please enter Goat ID to generate individual report!");

        buttonGenerate1.setBackground(new java.awt.Color(102, 102, 255));
        buttonGenerate1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGenerate1.setForeground(new java.awt.Color(0, 0, 0));
        buttonGenerate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addGoat.png"))); // NOI18N
        buttonGenerate1.setText("GENERATE");
        buttonGenerate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerate1ActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        reportPanelGoats.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout reportPanelGoatsLayout = new javax.swing.GroupLayout(reportPanelGoats);
        reportPanelGoats.setLayout(reportPanelGoatsLayout);
        reportPanelGoatsLayout.setHorizontalGroup(
            reportPanelGoatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reportPanelGoatsLayout.setVerticalGroup(
            reportPanelGoatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        btnGoatHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnGoatHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGoatHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnGoatHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addGoat.png"))); // NOI18N
        btnGoatHerd.setText("GOAT HERD");
        btnGoatHerd.setIconTextGap(12);
        btnGoatHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoatHerdActionPerformed(evt);
            }
        });

        btnKidHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnKidHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnKidHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnKidHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/horseshoe.png"))); // NOI18N
        btnKidHerd.setText("KID HERD");
        btnKidHerd.setIconTextGap(26);
        btnKidHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKidHerdActionPerformed(evt);
            }
        });

        btnMatingGoats.setBackground(new java.awt.Color(102, 102, 102));
        btnMatingGoats.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMatingGoats.setForeground(new java.awt.Color(0, 255, 255));
        btnMatingGoats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        btnMatingGoats.setText("MATING HERD");
        btnMatingGoats.setIconTextGap(12);
        btnMatingGoats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatingGoatsActionPerformed(evt);
            }
        });

        btnWeanerGoats.setBackground(new java.awt.Color(102, 102, 102));
        btnWeanerGoats.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnWeanerGoats.setForeground(new java.awt.Color(0, 255, 255));
        btnWeanerGoats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/weaner.png"))); // NOI18N
        btnWeanerGoats.setText("WEANER HERD");
        btnWeanerGoats.setIconTextGap(12);
        btnWeanerGoats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWeanerGoatsActionPerformed(evt);
            }
        });

        btnHealthGoats.setBackground(new java.awt.Color(102, 102, 102));
        btnHealthGoats.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHealthGoats.setForeground(new java.awt.Color(0, 255, 255));
        btnHealthGoats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/syringe.png"))); // NOI18N
        btnHealthGoats.setText("HERD HEALTH");
        btnHealthGoats.setIconTextGap(12);
        btnHealthGoats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHealthGoatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGoatHerd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKidHerd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMatingGoats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWeanerGoats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnHealthGoats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnGoatHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnKidHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnMatingGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnWeanerGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnHealthGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(reportGoatID, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonGenerate1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reportPanelGoats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reportGoatID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGenerate1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportPanelGoats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Goat Report", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        btnSheepHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnSheepHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSheepHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnSheepHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        btnSheepHerd.setText("SHEEP HERD");
        btnSheepHerd.setIconTextGap(12);
        btnSheepHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSheepHerdActionPerformed(evt);
            }
        });

        btnLambHerd.setBackground(new java.awt.Color(102, 102, 102));
        btnLambHerd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLambHerd.setForeground(new java.awt.Color(0, 255, 255));
        btnLambHerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addLambs.png"))); // NOI18N
        btnLambHerd.setText("LAMB HERD");
        btnLambHerd.setIconTextGap(26);
        btnLambHerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLambHerdActionPerformed(evt);
            }
        });

        btnMatingSheeps.setBackground(new java.awt.Color(102, 102, 102));
        btnMatingSheeps.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMatingSheeps.setForeground(new java.awt.Color(0, 255, 255));
        btnMatingSheeps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        btnMatingSheeps.setText("MATING HERD");
        btnMatingSheeps.setIconTextGap(12);
        btnMatingSheeps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatingSheepsActionPerformed(evt);
            }
        });

        btnWeanerSheep.setBackground(new java.awt.Color(102, 102, 102));
        btnWeanerSheep.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnWeanerSheep.setForeground(new java.awt.Color(0, 255, 255));
        btnWeanerSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addSheepWeaners.png"))); // NOI18N
        btnWeanerSheep.setText("WEANER HERD");
        btnWeanerSheep.setIconTextGap(12);
        btnWeanerSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWeanerSheepActionPerformed(evt);
            }
        });

        btnHealthSheep.setBackground(new java.awt.Color(102, 102, 102));
        btnHealthSheep.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHealthSheep.setForeground(new java.awt.Color(0, 255, 255));
        btnHealthSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/syringe.png"))); // NOI18N
        btnHealthSheep.setText("HERD HEALTH");
        btnHealthSheep.setIconTextGap(12);
        btnHealthSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHealthSheepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSheepHerd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLambHerd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMatingSheeps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWeanerSheep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnHealthSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnSheepHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnLambHerd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnMatingSheeps, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnWeanerSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnHealthSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Individual Sheep ID Report:");

        reportSheepID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("AGRI8 Assist: Please enter Sheep ID to generate individual report!");

        buttonGenerateSheep.setBackground(new java.awt.Color(102, 102, 255));
        buttonGenerateSheep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGenerateSheep.setForeground(new java.awt.Color(0, 0, 0));
        buttonGenerateSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        buttonGenerateSheep.setText("GENERATE");
        buttonGenerateSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateSheepActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        reportPanelSheep.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout reportPanelSheepLayout = new javax.swing.GroupLayout(reportPanelSheep);
        reportPanelSheep.setLayout(reportPanelSheepLayout);
        reportPanelSheepLayout.setHorizontalGroup(
            reportPanelSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reportPanelSheepLayout.setVerticalGroup(
            reportPanelSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reportSheepID, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonGenerateSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(281, 281, 281))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reportPanelSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reportSheepID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGenerateSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(28, 28, 28)
                        .addComponent(reportPanelSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sheep Report", jPanel3);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Individual Balancesheet ID Report:");

        reportBalance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnGenerateBS.setBackground(new java.awt.Color(153, 153, 255));
        btnGenerateBS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerateBS.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerateBS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livestock (2).png"))); // NOI18N
        btnGenerateBS.setText("GENERATE BALANCESHEET");
        btnGenerateBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBSActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("AGRI8 Assist: Please enter Balancesheet or Accounts ID to generate individual report!");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        btnSheepHerd1.setBackground(new java.awt.Color(102, 102, 102));
        btnSheepHerd1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSheepHerd1.setForeground(new java.awt.Color(0, 255, 255));
        btnSheepHerd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        btnSheepHerd1.setText("EXPENSE / COST");
        btnSheepHerd1.setIconTextGap(12);
        btnSheepHerd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSheepHerd1ActionPerformed(evt);
            }
        });

        btnEmployee.setBackground(new java.awt.Color(102, 102, 102));
        btnEmployee.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEmployee.setForeground(new java.awt.Color(0, 255, 255));
        btnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        btnEmployee.setText("EMPLOYEE LIST");
        btnEmployee.setIconTextGap(12);
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnSheepHerd4.setBackground(new java.awt.Color(102, 102, 102));
        btnSheepHerd4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSheepHerd4.setForeground(new java.awt.Color(0, 255, 255));
        btnSheepHerd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/weaner.png"))); // NOI18N
        btnSheepHerd4.setText("INCOME SALES");
        btnSheepHerd4.setIconTextGap(12);
        btnSheepHerd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSheepHerd4ActionPerformed(evt);
            }
        });

        reportPanelFinancial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout reportPanelFinancialLayout = new javax.swing.GroupLayout(reportPanelFinancial);
        reportPanelFinancial.setLayout(reportPanelFinancialLayout);
        reportPanelFinancialLayout.setHorizontalGroup(
            reportPanelFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reportPanelFinancialLayout.setVerticalGroup(
            reportPanelFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        btnContact.setBackground(new java.awt.Color(102, 102, 102));
        btnContact.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnContact.setForeground(new java.awt.Color(0, 255, 255));
        btnContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/weaner.png"))); // NOI18N
        btnContact.setText("LABOUR LIST");
        btnContact.setIconTextGap(24);
        btnContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactActionPerformed(evt);
            }
        });

        btnLabour.setBackground(new java.awt.Color(102, 102, 102));
        btnLabour.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLabour.setForeground(new java.awt.Color(0, 255, 255));
        btnLabour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/weaner.png"))); // NOI18N
        btnLabour.setText("CONTACTS LIST");
        btnLabour.setIconTextGap(12);
        btnLabour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabourActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Individual Accounts ID Report:");

        reportAccounts.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnGenerateBS1.setBackground(new java.awt.Color(153, 153, 255));
        btnGenerateBS1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerateBS1.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerateBS1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livestock (2).png"))); // NOI18N
        btnGenerateBS1.setText("GENERATE TRADING ACC");
        btnGenerateBS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBS1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reportBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerateBS))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reportAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerateBS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(121, 121, 121)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnContact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSheepHerd1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSheepHerd4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLabour, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(reportPanelFinancial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenerateBS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(reportBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reportAccounts)
                            .addComponent(jLabel32)
                            .addComponent(btnGenerateBS1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportPanelFinancial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSheepHerd4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnSheepHerd1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnContact, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnLabour, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );

        jTabbedPane3.addTab("FINANCIAL", jPanel6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Financial Report", jPanel4);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        reportPanelAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout reportPanelAnimalLayout = new javax.swing.GroupLayout(reportPanelAnimal);
        reportPanelAnimal.setLayout(reportPanelAnimalLayout);
        reportPanelAnimalLayout.setHorizontalGroup(
            reportPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reportPanelAnimalLayout.setVerticalGroup(
            reportPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        btnAnimalHealthInv.setBackground(new java.awt.Color(204, 204, 255));
        btnAnimalHealthInv.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAnimalHealthInv.setForeground(new java.awt.Color(0, 0, 0));
        btnAnimalHealthInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addAnimalInv.png"))); // NOI18N
        btnAnimalHealthInv.setText("ANIMAL HEALTH");
        btnAnimalHealthInv.setIconTextGap(12);
        btnAnimalHealthInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimalHealthInvActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("AGRI8 Assist: Press \" ANIMAL HEALTH, FEEDSTOCK OR MISC REPORT\" button to Genereate full stock report");

        btnFeedStock1.setBackground(new java.awt.Color(204, 204, 255));
        btnFeedStock1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnFeedStock1.setForeground(new java.awt.Color(0, 0, 0));
        btnFeedStock1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addHay.png"))); // NOI18N
        btnFeedStock1.setText("FEED STOCK REPORT");
        btnFeedStock1.setIconTextGap(12);
        btnFeedStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedStock1ActionPerformed(evt);
            }
        });

        btnMisc1.setBackground(new java.awt.Color(204, 204, 255));
        btnMisc1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMisc1.setForeground(new java.awt.Color(0, 0, 0));
        btnMisc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addInv.png"))); // NOI18N
        btnMisc1.setText("MISC REPORT");
        btnMisc1.setIconTextGap(12);
        btnMisc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisc1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reportPanelAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btnAnimalHealthInv)
                                .addGap(78, 78, 78)
                                .addComponent(btnFeedStock1)
                                .addGap(69, 69, 69)
                                .addComponent(btnMisc1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnimalHealthInv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFeedStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMisc1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)))
                .addGap(18, 18, 18)
                .addComponent(reportPanelAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("ANIMAL HEALTH INV", jPanel10);

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Enter Product ID Report:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("AGRI8 Assist: Please enter Product ID to generate individual item report!");

        reportFeedStock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnFeedstock.setBackground(new java.awt.Color(204, 204, 255));
        btnFeedstock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFeedstock.setForeground(new java.awt.Color(0, 0, 0));
        btnFeedstock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addHay.png"))); // NOI18N
        btnFeedstock.setText("GENERATE");
        btnFeedstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedstockActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("AGRI8 Assist: Press \" FEED STOCK\"  button to Genereate full stock report");

        btnFeedStock.setBackground(new java.awt.Color(204, 204, 255));
        btnFeedStock.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnFeedStock.setForeground(new java.awt.Color(0, 0, 0));
        btnFeedStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addHay.png"))); // NOI18N
        btnFeedStock.setText("FEED STOCK REPORT");
        btnFeedStock.setIconTextGap(12);
        btnFeedStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedStockActionPerformed(evt);
            }
        });

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        reportPanelFeed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout reportPanelFeedLayout = new javax.swing.GroupLayout(reportPanelFeed);
        reportPanelFeed.setLayout(reportPanelFeedLayout);
        reportPanelFeedLayout.setHorizontalGroup(
            reportPanelFeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reportPanelFeedLayout.setVerticalGroup(
            reportPanelFeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(reportFeedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeedstock, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFeedStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(33, 33, 33)))
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportPanelFeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reportFeedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFeedstock)
                            .addComponent(jLabel21)
                            .addComponent(btnFeedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(reportPanelFeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("FEEDSTOCK INV", jPanel11);

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Enter Product ID Report:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("AGRI8 Assist: Please enter Product ID to generate individual item report!");

        reportMisc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnMiscGenerate.setBackground(new java.awt.Color(204, 204, 255));
        btnMiscGenerate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMiscGenerate.setForeground(new java.awt.Color(0, 0, 0));
        btnMiscGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addInv.png"))); // NOI18N
        btnMiscGenerate.setText("GENERATE");
        btnMiscGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiscGenerateActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("AGRI8 Assist: Press \"MISC REPORT\" button to Genereate full stock report");

        btnMisc.setBackground(new java.awt.Color(204, 204, 255));
        btnMisc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMisc.setForeground(new java.awt.Color(0, 0, 0));
        btnMisc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addInv.png"))); // NOI18N
        btnMisc.setText("MISC REPORT");
        btnMisc.setIconTextGap(12);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo80.png"))); // NOI18N

        reportPanelMisc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout reportPanelMiscLayout = new javax.swing.GroupLayout(reportPanelMisc);
        reportPanelMisc.setLayout(reportPanelMiscLayout);
        reportPanelMiscLayout.setHorizontalGroup(
            reportPanelMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reportPanelMiscLayout.setVerticalGroup(
            reportPanelMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(reportMisc, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMiscGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel27))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMisc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jLabel28)
                                .addGap(33, 33, 33)))
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reportPanelMisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reportMisc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMiscGenerate)
                            .addComponent(jLabel26)
                            .addComponent(btnMisc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(reportPanelMisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("MISCELLANEOUSE INV", jPanel12);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventory Report", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        loadReportCattle();
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void btnMatingHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatingHerdActionPerformed
       
        try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelCattle.removeAll();
            reportPanelCattle.repaint();
            reportPanelCattle.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportMatingCattle.jrxml");
            String sql = "SELECT * FROM tbl_mating_groups";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelCattle.setLayout(new BorderLayout());
            reportPanelCattle.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatingHerdActionPerformed

    private void btnWeanerHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWeanerHerdActionPerformed
        
          try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelCattle.removeAll();
            reportPanelCattle.repaint();
            reportPanelCattle.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportWeanerCattle.jrxml");
            String sql = "SELECT * FROM tbl_weaner_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelCattle.setLayout(new BorderLayout());
            reportPanelCattle.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnWeanerHerdActionPerformed

    private void btnHerdHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHerdHealthActionPerformed
        
           try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelCattle.removeAll();
            reportPanelCattle.repaint();
            reportPanelCattle.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportCattleHealth.jrxml");
            String sql = "SELECT * FROM tbl_vacc_disease";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelCattle.setLayout(new BorderLayout());
            reportPanelCattle.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHerdHealthActionPerformed

    private void btnCalfHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalfHerdActionPerformed
       
        try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelCattle.removeAll();
            reportPanelCattle.repaint();
            reportPanelCattle.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportCalf.jrxml");
            String sql = "SELECT * FROM tbl_calf_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelCattle.setLayout(new BorderLayout());
            reportPanelCattle.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCalfHerdActionPerformed

    private void buttonGenerate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerate1ActionPerformed
         loadReportGoats();
    }//GEN-LAST:event_buttonGenerate1ActionPerformed

    private void btnKidHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKidHerdActionPerformed
          try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelGoats.removeAll();
            reportPanelGoats.repaint();
            reportPanelGoats.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportKids.jrxml");
            String sql = "SELECT * FROM tbl_kid_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelGoats.setLayout(new BorderLayout());
            reportPanelGoats.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKidHerdActionPerformed

    private void btnMatingGoatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatingGoatsActionPerformed
        
        try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelGoats.removeAll();
            reportPanelGoats.repaint();
            reportPanelGoats.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportMatingGoats.jrxml");
            String sql = "SELECT * FROM tbl_mating_goats";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelGoats.setLayout(new BorderLayout());
            reportPanelGoats.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatingGoatsActionPerformed

    private void btnWeanerGoatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWeanerGoatsActionPerformed
     
        try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelGoats.removeAll();
            reportPanelGoats.repaint();
            reportPanelGoats.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportWeanerGoats.jrxml");
            String sql = "SELECT * FROM tbl_weaner_kids";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelGoats.setLayout(new BorderLayout());
            reportPanelGoats.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnWeanerGoatsActionPerformed

    private void btnHealthGoatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHealthGoatsActionPerformed
        
            try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelGoats.removeAll();
            reportPanelGoats.repaint();
            reportPanelGoats.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportGoatsHealth.jrxml");
            String sql = "SELECT * FROM tbl_vacc_goats";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelGoats.setLayout(new BorderLayout());
            reportPanelGoats.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHealthGoatsActionPerformed

    private void btnGoatHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoatHerdActionPerformed
        
            try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelGoats.removeAll();
            reportPanelGoats.repaint();
            reportPanelGoats.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportGoatHerd.jrxml");
            String sql = "SELECT * FROM tbl_goat_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelGoats.setLayout(new BorderLayout());
            reportPanelGoats.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGoatHerdActionPerformed

    private void btnCattleHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCattleHerdActionPerformed
       
           try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelCattle.removeAll();
            reportPanelCattle.repaint();
            reportPanelCattle.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportAllCattle.jrxml");
            String sql = "SELECT * FROM tbl_cattle_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelCattle.setLayout(new BorderLayout());
            reportPanelCattle.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnCattleHerdActionPerformed

    private void btnSheepHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSheepHerdActionPerformed
             try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelSheep.removeAll();
            reportPanelSheep.repaint();
            reportPanelSheep.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportAllSheep.jrxml");
            String sql = "SELECT * FROM tbl_sheep_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelSheep.setLayout(new BorderLayout());
            reportPanelSheep.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSheepHerdActionPerformed

    private void btnLambHerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLambHerdActionPerformed
              try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelSheep.removeAll();
            reportPanelSheep.repaint();
            reportPanelSheep.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportLambs.jrxml");
            String sql = "SELECT * FROM tbl_lamb_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelSheep.setLayout(new BorderLayout());
            reportPanelSheep.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLambHerdActionPerformed

    private void btnMatingSheepsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatingSheepsActionPerformed
        
               try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelSheep.removeAll();
            reportPanelSheep.repaint();
            reportPanelSheep.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportMatingSheep.jrxml");
            String sql = "SELECT * FROM tbl_mating_sheep";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelSheep.setLayout(new BorderLayout());
            reportPanelSheep.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_btnMatingSheepsActionPerformed

    private void btnWeanerSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWeanerSheepActionPerformed
        
             try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelSheep.removeAll();
            reportPanelSheep.repaint();
            reportPanelSheep.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportWeanerSheep.jrxml");
            String sql = "SELECT * FROM tbl_weaner_lambs";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelSheep.setLayout(new BorderLayout());
            reportPanelSheep.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnWeanerSheepActionPerformed

    private void btnHealthSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHealthSheepActionPerformed
       
          try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelSheep.removeAll();
            reportPanelSheep.repaint();
            reportPanelSheep.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportSheepHealth.jrxml");
            String sql = "SELECT * FROM tbl_vacc_sheep";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelSheep.setLayout(new BorderLayout());
            reportPanelSheep.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHealthSheepActionPerformed

    private void buttonGenerateSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateSheepActionPerformed
        loadReportSheep();
    }//GEN-LAST:event_buttonGenerateSheepActionPerformed

    private void btnFeedstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedstockActionPerformed

    private void btnMiscGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiscGenerateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMiscGenerateActionPerformed

    private void btnFeedStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedStockActionPerformed

    private void btnAnimalHealthInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimalHealthInvActionPerformed
          try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelAnimal.removeAll();
            reportPanelAnimal.repaint();
            reportPanelAnimal.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportAnimalHealthInv.jrxml");
            String sql = "SELECT * FROM tbl_inventory_vaccination";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelAnimal.setLayout(new BorderLayout());
            reportPanelAnimal.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnimalHealthInvActionPerformed

    private void btnFeedStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedStock1ActionPerformed
        
           try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelAnimal.removeAll();
            reportPanelAnimal.repaint();
            reportPanelAnimal.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportFeedStock.jrxml");
            String sql = "SELECT * FROM tbl_inventory_feedstock";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelAnimal.setLayout(new BorderLayout());
            reportPanelAnimal.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFeedStock1ActionPerformed

    private void btnMisc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisc1ActionPerformed
        
         try {
        
             Connection conn = myConnection.getConnect();
            
            reportPanelAnimal.removeAll();
            reportPanelAnimal.repaint();
            reportPanelAnimal.revalidate();
            
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportMiscInv.jrxml");
            String sql = "SELECT * FROM tbl_inventory_misc";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);
            
            
            JRViewer v = new JRViewer(jprint);
            reportPanelAnimal.setLayout(new BorderLayout());
            reportPanelAnimal.add(v);
        
       
        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMisc1ActionPerformed

    private void btnSheepHerd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSheepHerd4ActionPerformed

        try {

            Connection conn = myConnection.getConnect();

            reportPanelFinancial.removeAll();
            reportPanelFinancial.repaint();
            reportPanelFinancial.revalidate();

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportSales.jrxml");
            String sql = "SELECT * FROM tbl_sales_add";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);

            JRViewer v = new JRViewer(jprint);
            reportPanelFinancial.setLayout(new BorderLayout());
            reportPanelFinancial.add(v);

        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSheepHerd4ActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed

        try {

            Connection conn = myConnection.getConnect();

            reportPanelFinancial.removeAll();
            reportPanelFinancial.repaint();
            reportPanelFinancial.revalidate();

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportEmp.jrxml");
            String sql = "SELECT * FROM tbl_emp_reg ";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);

            JRViewer v = new JRViewer(jprint);
            reportPanelFinancial.setLayout(new BorderLayout());
            reportPanelFinancial.add(v);

        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnSheepHerd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSheepHerd1ActionPerformed

        try {

            Connection conn = myConnection.getConnect();

            reportPanelFinancial.removeAll();
            reportPanelFinancial.repaint();
            reportPanelFinancial.revalidate();

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportExpenses.jrxml");
            String sql = "SELECT * FROM tbl_expense_add";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);

            JRViewer v = new JRViewer(jprint);
            reportPanelFinancial.setLayout(new BorderLayout());
            reportPanelFinancial.add(v);

        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSheepHerd1ActionPerformed

    private void btnGenerateBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBSActionPerformed
        loadReportBalanceSheet();
    }//GEN-LAST:event_btnGenerateBSActionPerformed

    private void btnContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactActionPerformed
               try {

            Connection conn = myConnection.getConnect();

            reportPanelFinancial.removeAll();
            reportPanelFinancial.repaint();
            reportPanelFinancial.revalidate();

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportLabour.jrxml");
            String sql = "SELECT * FROM tbl_labour_info";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);

            JRViewer v = new JRViewer(jprint);
            reportPanelFinancial.setLayout(new BorderLayout());
            reportPanelFinancial.add(v);

        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnContactActionPerformed

    private void btnLabourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLabourActionPerformed
               try {

            Connection conn = myConnection.getConnect();

            reportPanelFinancial.removeAll();
            reportPanelFinancial.repaint();
            reportPanelFinancial.revalidate();

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\AGRI8 Project Management\\AGRI8 Management Software\\AGRI8 Management Software\\src\\agri8\\management\\software\\ReportContacts.jrxml");
            String sql = "SELECT * FROM tbl_company_reg ";
            JRDesignQuery dq = new JRDesignQuery();
            dq.setText(sql);
            jdesign.setQuery(dq);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            HashMap para = new HashMap();
            JasperPrint jprint = JasperFillManager.fillReport(jreport, para, conn);

            JRViewer v = new JRViewer(jprint);
            reportPanelFinancial.setLayout(new BorderLayout());
            reportPanelFinancial.add(v);

        } catch (JRException ex) {
            Logger.getLogger(ClassReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLabourActionPerformed

    private void btnHerdHealth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHerdHealth1ActionPerformed
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_btnHerdHealth1ActionPerformed

    private void btnGenerateBS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBS1ActionPerformed
        loadReportAccounts();
    }//GEN-LAST:event_btnGenerateBS1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(ClassReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnimalHealthInv;
    private javax.swing.JButton btnCalfHerd;
    private javax.swing.JButton btnCattleHerd;
    private javax.swing.JButton btnContact;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnFeedStock;
    private javax.swing.JButton btnFeedStock1;
    private javax.swing.JButton btnFeedstock;
    private javax.swing.JButton btnGenerateBS;
    private javax.swing.JButton btnGenerateBS1;
    private javax.swing.JButton btnGoatHerd;
    private javax.swing.JButton btnHealthGoats;
    private javax.swing.JButton btnHealthSheep;
    private javax.swing.JButton btnHerdHealth;
    private javax.swing.JButton btnHerdHealth1;
    private javax.swing.JButton btnKidHerd;
    private javax.swing.JButton btnLabour;
    private javax.swing.JButton btnLambHerd;
    private javax.swing.JButton btnMatingGoats;
    private javax.swing.JButton btnMatingHerd;
    private javax.swing.JButton btnMatingSheeps;
    private javax.swing.JButton btnMisc;
    private javax.swing.JButton btnMisc1;
    private javax.swing.JButton btnMiscGenerate;
    private javax.swing.JButton btnSheepHerd;
    private javax.swing.JButton btnSheepHerd1;
    private javax.swing.JButton btnSheepHerd4;
    private javax.swing.JButton btnWeanerGoats;
    private javax.swing.JButton btnWeanerHerd;
    private javax.swing.JButton btnWeanerSheep;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JButton buttonGenerate1;
    private javax.swing.JButton buttonGenerateSheep;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField reportAccounts;
    private javax.swing.JTextField reportBalance;
    private javax.swing.JTextField reportFeedStock;
    private javax.swing.JTextField reportGoatID;
    private javax.swing.JTextField reportID;
    private javax.swing.JTextField reportMisc;
    private javax.swing.JPanel reportPanelAnimal;
    private javax.swing.JPanel reportPanelCattle;
    private javax.swing.JPanel reportPanelFeed;
    private javax.swing.JPanel reportPanelFinancial;
    private javax.swing.JPanel reportPanelGoats;
    private javax.swing.JPanel reportPanelMisc;
    private javax.swing.JPanel reportPanelSheep;
    private javax.swing.JTextField reportSheepID;
    // End of variables declaration//GEN-END:variables
}
