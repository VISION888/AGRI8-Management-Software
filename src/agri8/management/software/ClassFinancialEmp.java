
package agri8.management.software;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class ClassFinancialEmp extends javax.swing.JFrame {

      MySQLConnect myConnection;
 
    public ClassFinancialEmp() {
        
        icon();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        myConnection = new MySQLConnect(); 
        UIF.setEnabled(false);
        newVat.setEnabled(false);
        newVat1.setEnabled(false);
        addfilterCategoryS();
        addfilterCategoryE();
        contactComboboxs();
        LabourTable();
        tableContact();
        AccountsTable();
        EmpTable();
        TableHome();
        BalanceTable();
        LogoName();
        bsid.requestFocus();
        panelSide.setBackground(new Color(153,153,255,220));
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
                        } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
             //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
     
    private void contactComboboxs() {
        // Fill Textfield when choosing Company category in JComboBox
       
         try {
                 
                Connection conn = myConnection.getConnect();
                
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT category FROM tbl_company ORDER BY category ASC");
                 
                 while(rs.next()){
                   
                     seven.addItem(rs.getString("category"));
                } 
            } catch (SQLException | HeadlessException  e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }
     
   
        // ********** Filter SALES AND EXPENSE Table **************
     private void filter(String query){
         
         DefaultTableModel tblModel = (DefaultTableModel) tableSE.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(tblModel);
         tableSE.setRowSorter(trs);
         
         trs.setRowFilter(RowFilter.regexFilter(query));
     }
     
       private void LabourTable()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_labour_info";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              
              String id = rs.getString("l_id");
              String name = rs.getString("l_name");
              String surname = rs.getString("l_surname");
              String contract = rs.getString("l_contract");
              String position = rs.getString("l_position");
              String normal = rs.getString("l_normal_hr");
              String overtime = rs.getString("l_total_overtime");
              String totalhr = rs.getString("l_total_hr");
              String hourly = rs.getString("l_hourly_rate");
              String uif = rs.getString("l_less_uif");
              String paye = rs.getString("l_less_paye");
              String deduc = rs.getString("l_less_deduc");
              String salary = rs.getString("l_total_salary");
       
    
              //String array to store data into jTable
              String tblDataL[] = {id, name, surname, contract, position, normal, overtime, totalhr, hourly, uif, paye, deduc, salary};
              DefaultTableModel tblModelL = (DefaultTableModel)tableLabour.getModel();
              
              //Add string array data into table
              tblModelL.addRow(tblDataL);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
              //      JOptionPane.showMessageDialog(null, "Supplier Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    }
     
          private void BalanceTable()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_bs_report";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              
              String bsid = rs.getString("bsid");
              String datestart = rs.getString("datestart");
              String dateend = rs.getString("dateend");
              String totall = rs.getString("one3");
              String networth = rs.getString("two3");
              String total = rs.getString("three3");
              String totala = rs.getString("four3");
        
    
              //String array to store data into jTable
              String tblDataB[] = {bsid, datestart, dateend, totall, networth, total, totala};
              DefaultTableModel tblModelB = (DefaultTableModel)tableBalance.getModel();
              
              //Add string array data into table
              tblModelB.addRow(tblDataB);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
               //     JOptionPane.showMessageDialog(null, "Supplier Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    }
          
          
      private void AccountsTable()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_account_report";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              String aid = rs.getString("a_id");
              String Dateopen = rs.getString("dateopen");
              String opentotal = rs.getString("t31");
              String openqty = rs.getString("q31");
              String closetotal = rs.getString("t15");
              String closeqty = rs.getString("q15");
              String difference = rs.getString("d");
              String Dateclose = rs.getString("dateclose");
         
    
              //String array to store data into jTable
              String tblDataA[] = {aid, Dateopen, opentotal, openqty, closetotal, closeqty, difference, Dateclose};
              DefaultTableModel tblModelA = (DefaultTableModel)tableAccounts.getModel();
              
              //Add string array data into table
              tblModelA.addRow(tblDataA);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                //    JOptionPane.showMessageDialog(null, "Supplier Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    }
     
          
     
      private void EmpTable()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_emp_reg";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
         
              String id = rs.getString("e_id");
              String name = rs.getString("e_name");
              String surname = rs.getString("e_surename");
              String dob = rs.getString("e_dob");
              String idnr = rs.getString("e_idnr");
              String phone = rs.getString("e_phone");
              String email = rs.getString("e_email");
              String gender = rs.getString("e_gender");
              String date = rs.getString("e_term");
              String job = rs.getString("e_position");
              String hourly = rs.getString("e_hourly");
              String salary = rs.getString("e_salary");
    
              //String array to store data into jTable
              String tblDataM[] = {id, name, surname, dob, idnr, phone, email, gender, date, job, hourly, salary};
              DefaultTableModel tblModelM = (DefaultTableModel)tableEmp.getModel();
              
              //Add string array data into table
              tblModelM.addRow(tblDataM);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                //    JOptionPane.showMessageDialog(null, "Supplier Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    }
     
     
     private void tableContact()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_company_reg";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              
              String id = rs.getString("c_id");
              String name = rs.getString("c_name");
              String number = rs.getString("c_number");
              String cname = rs.getString("c_comp_name");
              String vat = rs.getString("c_vat");
              String reg = rs.getString("c_reg");
              String email = rs.getString("c_email");
              String category = rs.getString("c_category");
              String street = rs.getString("c_street");
              String city = rs.getString("c_city");
              String area = rs.getString("c_area");

  
              //String array to store data into jTable
              String tblDataC[] = {id, name, number, cname, vat, reg, email, category, street, city, area};
              DefaultTableModel tblModelC = (DefaultTableModel)tableContacts.getModel();
              
              //Add string array data into table
              tblModelC.addRow(tblDataC);
          }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                 //   JOptionPane.showMessageDialog(null, "Supplier Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    }

     
     private void addfilterCategoryS() {
         
          String filtertype = (String) filterType.getSelectedItem();
        
        if(!filtertype.equals("SELECT")) {
       
            filterCategory.setSelectedItem("SELECT");
            
        }

        try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                
                String sales = ("SELECT s_category FROM tbl_sales_add ORDER BY s_category ASC");
           
                 
                 ResultSet rs = stm.executeQuery(sales);
                while(rs.next()){
                     
                     filterCategory.addItem(rs.getString("s_category"));
                } 
                
 
                conn.close();
                 
            } catch (SQLException | HeadlessException | ClassNotFoundException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
         
     }
     
     
     
     
      private void addfilterCategoryE() {
         
          String filtertype = (String) filterType.getSelectedItem();
        
        if(!filtertype.equals("SELECT")) {
       
            filterCategory.setSelectedItem("SELECT");
            
        }
 
      
        try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                
           
                String expenses = ("SELECT e_category FROM tbl_expense_add ORDER BY e_category ASC");  
                 

                ResultSet rse = stm.executeQuery(expenses);
                
                while(rse.next()){
                     
                     filterCategory.addItem(rse.getString("e_category"));
                } 
                
                conn.close();
                 
            } catch (SQLException | HeadlessException | ClassNotFoundException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
         
     }
     
     // *************** Resize Image to Update **********************
       String photopath = null;
    //javax.swing.ImageIcon to resize image
    
    public ImageIcon resizeImage(String photopath, byte[] photo) {
        
       ImageIcon myPhoto = null;
       if(photopath != null){
           myPhoto = new ImageIcon(photopath);
       } else {
           myPhoto = new ImageIcon(photo);
       }
       
       Image img = myPhoto.getImage();
       Image img1 = img.getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ph = new ImageIcon(img1);
       return ph;
           
    }
     
        private void TableHome()  {
        
         Connection conn = myConnection.getConnect();
             try {
            
          Statement stm = conn.createStatement();
          String sqlS = "SELECT * FROM tbl_sales_add ORDER BY s_type ASC";
          String sqlE = "SELECT * FROM tbl_expense_add ORDER BY e_type ASC";
 
          
             ResultSet rss = stm.executeQuery(sqlS);
          
          while(rss.next()) {
              
              //Add data

              String stype = rss.getString("s_type");
              String sdate = rss.getString("s_date");
              String sname = rss.getString("s_name");
              String scategory = rss.getString("s_category");
              String sunitprice = rss.getString("s_unitprice");
              String sqty = rss.getString("s_qty");
              String ssubtotal = rss.getString("s_subtotal");
              String svat = rss.getString("s_vat");
              String stotal = rss.getString("s_total");
          
    
              //String array to store data into jTable
              String tblDataS[] = {stype, sdate, sname, scategory, sunitprice, sqty, ssubtotal, svat, stotal};
              DefaultTableModel tblModelS = (DefaultTableModel)tableSE.getModel();
              
              //Add string array data into table
              tblModelS.addRow(tblDataS);
          }
          
          ResultSet rse = stm.executeQuery(sqlE);
          
          while(rse.next()) {
              
              //Add data
              
              String etype = rse.getString("e_type");
              String edate = rse.getString("e_date");
              String ename = rse.getString("e_name");
              String ecategory = rse.getString("e_category");
              String eunitprice = rse.getString("e_unitprice");
              String eqty = rse.getString("e_qty");
              String esubtotal = rse.getString("e_subtotal");
              String evat = rse.getString("e_vat");
              String etotal = rse.getString("e_total");

              //String array to store data into jTable
              String tblDataS[] = {etype, edate, ename, ecategory, eunitprice, eqty, esubtotal, evat, etotal};
              DefaultTableModel tblModelS = (DefaultTableModel)tableSE.getModel();
              
              //Add string array data into table
              tblModelS.addRow(tblDataS);
          }
      
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
        }
      }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField18 = new javax.swing.JTextField();
        panelSide = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        buttonHome = new javax.swing.JButton();
        buttonAnimal = new javax.swing.JButton();
        buttonFeed = new javax.swing.JButton();
        buttonStock1 = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        tabFinancial = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        filterType = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        filterCategory = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableSE = new javax.swing.JTable();
        buttonDeleteSE = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        cone = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        ctwoDate = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        cthree = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        cfour = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        cunitprice = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        cqty = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        csubtotal = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        cvat = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        ctotal = new javax.swing.JTextField();
        buttonAddSale = new javax.swing.JButton();
        radioNoVat = new javax.swing.JRadioButton();
        btnChangeVat = new javax.swing.JToggleButton();
        jLabel56 = new javax.swing.JLabel();
        newVat = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        cone1 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        ctwoDate1 = new com.toedter.calendar.JDateChooser();
        jLabel59 = new javax.swing.JLabel();
        cthree1 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        cfour1 = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        cunitprice1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        cqty1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        csubtotal1 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        cvat1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        ctotal1 = new javax.swing.JTextField();
        buttonAddSale1 = new javax.swing.JButton();
        radioNoVat1 = new javax.swing.JRadioButton();
        btnChangeVat1 = new javax.swing.JToggleButton();
        jLabel66 = new javax.swing.JLabel();
        newVat1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        TWO3 = new javax.swing.JTextField();
        ONE3 = new javax.swing.JTextField();
        THREE3 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        FOUR3 = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        g = new javax.swing.JTextField();
        f = new javax.swing.JTextField();
        e = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        h = new javax.swing.JTextField();
        i = new javax.swing.JTextField();
        j = new javax.swing.JTextField();
        k = new javax.swing.JTextField();
        l = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        m = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        o = new javax.swing.JTextField();
        p = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        aa = new javax.swing.JTextField();
        bb = new javax.swing.JTextField();
        cc = new javax.swing.JTextField();
        dd = new javax.swing.JTextField();
        ee = new javax.swing.JTextField();
        ff = new javax.swing.JTextField();
        gg = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        hh = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        ii = new javax.swing.JTextField();
        jj = new javax.swing.JTextField();
        kk = new javax.swing.JTextField();
        ll = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        mm = new javax.swing.JTextField();
        nn = new javax.swing.JTextField();
        oo = new javax.swing.JTextField();
        pp = new javax.swing.JTextField();
        datestart = new com.toedter.calendar.JDateChooser();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        dateend = new com.toedter.calendar.JDateChooser();
        jLabel124 = new javax.swing.JLabel();
        bsid = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        V13 = new javax.swing.JTextField();
        V14 = new javax.swing.JTextField();
        V12 = new javax.swing.JTextField();
        V11 = new javax.swing.JTextField();
        V10 = new javax.swing.JTextField();
        V9 = new javax.swing.JTextField();
        V8 = new javax.swing.JTextField();
        V7 = new javax.swing.JTextField();
        V6 = new javax.swing.JTextField();
        V5 = new javax.swing.JTextField();
        V4 = new javax.swing.JTextField();
        V3 = new javax.swing.JTextField();
        V2 = new javax.swing.JTextField();
        V1 = new javax.swing.JTextField();
        V = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        Q = new javax.swing.JTextField();
        Q1 = new javax.swing.JTextField();
        Q2 = new javax.swing.JTextField();
        Q3 = new javax.swing.JTextField();
        Q4 = new javax.swing.JTextField();
        Q5 = new javax.swing.JTextField();
        Q6 = new javax.swing.JTextField();
        Q7 = new javax.swing.JTextField();
        Q8 = new javax.swing.JTextField();
        Q9 = new javax.swing.JTextField();
        Q10 = new javax.swing.JTextField();
        Q11 = new javax.swing.JTextField();
        Q12 = new javax.swing.JTextField();
        Q13 = new javax.swing.JTextField();
        Q14 = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        T = new javax.swing.JTextField();
        T1 = new javax.swing.JTextField();
        T2 = new javax.swing.JTextField();
        T3 = new javax.swing.JTextField();
        T4 = new javax.swing.JTextField();
        T5 = new javax.swing.JTextField();
        T6 = new javax.swing.JTextField();
        T7 = new javax.swing.JTextField();
        T8 = new javax.swing.JTextField();
        T9 = new javax.swing.JTextField();
        T10 = new javax.swing.JTextField();
        T11 = new javax.swing.JTextField();
        T12 = new javax.swing.JTextField();
        T13 = new javax.swing.JTextField();
        T14 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        V29 = new javax.swing.JTextField();
        V30 = new javax.swing.JTextField();
        V28 = new javax.swing.JTextField();
        V27 = new javax.swing.JTextField();
        V26 = new javax.swing.JTextField();
        V25 = new javax.swing.JTextField();
        V24 = new javax.swing.JTextField();
        V23 = new javax.swing.JTextField();
        V22 = new javax.swing.JTextField();
        V21 = new javax.swing.JTextField();
        V20 = new javax.swing.JTextField();
        V19 = new javax.swing.JTextField();
        V18 = new javax.swing.JTextField();
        V17 = new javax.swing.JTextField();
        V16 = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        Q16 = new javax.swing.JTextField();
        Q17 = new javax.swing.JTextField();
        Q18 = new javax.swing.JTextField();
        Q19 = new javax.swing.JTextField();
        Q20 = new javax.swing.JTextField();
        Q21 = new javax.swing.JTextField();
        Q22 = new javax.swing.JTextField();
        Q23 = new javax.swing.JTextField();
        Q24 = new javax.swing.JTextField();
        Q25 = new javax.swing.JTextField();
        Q26 = new javax.swing.JTextField();
        Q27 = new javax.swing.JTextField();
        Q28 = new javax.swing.JTextField();
        Q29 = new javax.swing.JTextField();
        Q30 = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        T16 = new javax.swing.JTextField();
        T17 = new javax.swing.JTextField();
        T18 = new javax.swing.JTextField();
        T19 = new javax.swing.JTextField();
        T20 = new javax.swing.JTextField();
        T21 = new javax.swing.JTextField();
        T22 = new javax.swing.JTextField();
        T23 = new javax.swing.JTextField();
        T24 = new javax.swing.JTextField();
        T25 = new javax.swing.JTextField();
        T26 = new javax.swing.JTextField();
        T27 = new javax.swing.JTextField();
        T28 = new javax.swing.JTextField();
        T29 = new javax.swing.JTextField();
        T30 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        dateOpen = new com.toedter.calendar.JDateChooser();
        jLabel125 = new javax.swing.JLabel();
        dateClose = new com.toedter.calendar.JDateChooser();
        jLabel145 = new javax.swing.JLabel();
        Q15 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        T15 = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        ACCOUNTID = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        Q31 = new javax.swing.JTextField();
        T31 = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        D = new javax.swing.JTextField();
        btnClearT = new javax.swing.JButton();
        btnUpdateT = new javax.swing.JButton();
        btnSaveT = new javax.swing.JButton();
        btnSearchT = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableBalance = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableAccounts = new javax.swing.JTable();
        btnDeleteB = new javax.swing.JButton();
        btnDeleteT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        ethree = new javax.swing.JTextField();
        etwo = new javax.swing.JTextField();
        eone = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        efour = new com.toedter.calendar.JDateChooser();
        efive = new javax.swing.JTextField();
        esixs = new javax.swing.JTextField();
        eseven = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        eeight = new javax.swing.JComboBox<>();
        eeleven = new javax.swing.JTextField();
        etwelve = new javax.swing.JTextField();
        eten = new javax.swing.JComboBox<>();
        enine = new com.toedter.calendar.JDateChooser();
        buttonClearE = new javax.swing.JButton();
        buttonDeleteE = new javax.swing.JButton();
        buttonUpdateE = new javax.swing.JButton();
        buttonSearchE = new javax.swing.JButton();
        buttonSaveE = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lone = new javax.swing.JTextField();
        ltwo = new javax.swing.JTextField();
        lthree = new javax.swing.JTextField();
        lfour = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lseven = new javax.swing.JTextField();
        lfive = new javax.swing.JComboBox<>();
        lsixs = new javax.swing.JTextField();
        leight = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ltwelve = new javax.swing.JTextField();
        leleven = new javax.swing.JTextField();
        lten = new javax.swing.JTextField();
        lnine = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        lthirteen = new javax.swing.JTextField();
        buttonUIF = new javax.swing.JToggleButton();
        UIF = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        buttonSaveL = new javax.swing.JButton();
        buttonSearchL = new javax.swing.JButton();
        buttonUpdateL = new javax.swing.JButton();
        buttonDeleteL = new javax.swing.JButton();
        buttonClearL = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLabour = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        three = new javax.swing.JTextField();
        two = new javax.swing.JTextField();
        one = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        four = new javax.swing.JTextField();
        five = new javax.swing.JTextField();
        sixs = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        emailc = new javax.swing.JTextField();
        btnAddC = new javax.swing.JButton();
        btnDeleteC = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        seven = new javax.swing.JComboBox<>();
        eight = new javax.swing.JTextField();
        nine = new javax.swing.JTextField();
        ten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonSaveC = new javax.swing.JButton();
        buttonSearchC = new javax.swing.JButton();
        buttonUpdateC = new javax.swing.JButton();
        buttonDeleteC = new javax.swing.JButton();
        buttonClearC = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableContacts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTextField18.setText("jTextField18");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogo.setBackground(new java.awt.Color(153, 153, 255));
        labelLogo.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(204, 204, 204));
        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setText("Farm Logo");
        labelLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelName.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        labelName.setForeground(new java.awt.Color(0, 0, 0));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Farm Name");

        buttonHome.setBackground(new java.awt.Color(153, 153, 255));
        buttonHome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonHome.setForeground(new java.awt.Color(0, 0, 0));
        buttonHome.setText("Financial Page");
        buttonHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buttonHome.setMaximumSize(new java.awt.Dimension(165, 36));
        buttonHome.setMinimumSize(new java.awt.Dimension(165, 36));
        buttonHome.setPreferredSize(new java.awt.Dimension(165, 36));
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        buttonAnimal.setBackground(new java.awt.Color(153, 153, 255));
        buttonAnimal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonAnimal.setForeground(new java.awt.Color(0, 0, 0));
        buttonAnimal.setText("Employee's");
        buttonAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buttonAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnimalActionPerformed(evt);
            }
        });

        buttonFeed.setBackground(new java.awt.Color(153, 153, 255));
        buttonFeed.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonFeed.setForeground(new java.awt.Color(0, 0, 0));
        buttonFeed.setText("Labour info");
        buttonFeed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buttonFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFeedActionPerformed(evt);
            }
        });

        buttonStock1.setBackground(new java.awt.Color(153, 153, 255));
        buttonStock1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonStock1.setForeground(new java.awt.Color(0, 0, 0));
        buttonStock1.setText("Contact's");
        buttonStock1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buttonStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStock1ActionPerformed(evt);
            }
        });

        buttonClose.setBackground(new java.awt.Color(153, 153, 255));
        buttonClose.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(0, 0, 0));
        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonClose.setText("Close");
        buttonClose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buttonClose.setIconTextGap(15);
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSideLayout = new javax.swing.GroupLayout(panelSide);
        panelSide.setLayout(panelSideLayout);
        panelSideLayout.setHorizontalGroup(
            panelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelSideLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAnimal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonFeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonStock1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSideLayout.setVerticalGroup(
            panelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(labelName)
                .addGap(35, 35, 35)
                .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonFeed, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(panelSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 190, 510));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jPanel13.setBackground(new java.awt.Color(153, 153, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("FILTER BY TYPE:");

        filterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "INCOME", "EXPENSE" }));
        filterType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterTypeItemStateChanged(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("FILTER BY CATOGERY:");

        filterCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterCategoryItemStateChanged(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setText("OR / AND");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("INCOME AND EXPENSE INFORMATION");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterType, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRefresh)
                .addGap(20, 20, 20))
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68)
                        .addComponent(filterCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel69)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel67))
                .addGap(34, 34, 34))
        );

        tableSE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Date", "Description", "Category", "Unit Price", "Qty", "Subtotal", "Vat", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableSE);
        if (tableSE.getColumnModel().getColumnCount() > 0) {
            tableSE.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableSE.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableSE.getColumnModel().getColumn(2).setPreferredWidth(200);
            tableSE.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableSE.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableSE.getColumnModel().getColumn(5).setPreferredWidth(40);
            tableSE.getColumnModel().getColumn(6).setPreferredWidth(50);
            tableSE.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableSE.getColumnModel().getColumn(8).setPreferredWidth(60);
        }

        buttonDeleteSE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteSE.setText("DELETE");
        buttonDeleteSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteSEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDeleteSE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Financial Main Page", jPanel1);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("ADD AGRICULTURE INCOME AND EXPENSES");

        jPanel14.setBackground(new java.awt.Color(153, 153, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ADD INCOME AND SALES"));
        jPanel14.setForeground(new java.awt.Color(51, 51, 51));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Sales Type:");

        cone.setEditable(false);
        cone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cone.setText("INCOME");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Sales Date:");

        ctwoDate.setDateFormatString("yyyy-MM-dd");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("Description:");

        cthree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cthreeActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("Category:");

        cfour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Crop sales", "Feed Sales", "Livestock - Cattle", "Livestock - Goats", "Livestock - Sheep", "Other Sales" }));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("Unit Price:");

        cunitprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cunitpriceKeyReleased(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("Quantity:");

        cqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cqtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cqtyKeyReleased(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("Sub-Total:");

        csubtotal.setEditable(false);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("Vat:");

        cvat.setEditable(false);

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("Total:");

        ctotal.setEditable(false);

        buttonAddSale.setBackground(new java.awt.Color(153, 153, 255));
        buttonAddSale.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddSale.setText("ADD");
        buttonAddSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSaleActionPerformed(evt);
            }
        });

        radioNoVat.setBackground(new java.awt.Color(204, 204, 255));
        radioNoVat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioNoVat.setForeground(new java.awt.Color(51, 51, 51));
        radioNoVat.setText("No Vat");

        btnChangeVat.setText("Edit Vat %");
        btnChangeVat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeVatActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 51, 51));
        jLabel56.setText("New Vat:");

        newVat.setText("15");
        newVat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newVatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel50)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cunitprice))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel46)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cone, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(radioNoVat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ctwoDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(cqty, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(csubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel54)
                        .addGap(18, 18, 18)
                        .addComponent(cvat))
                    .addComponent(cthree, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(ctotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddSale, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(btnChangeVat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)
                        .addGap(11, 11, 11)
                        .addComponent(newVat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cfour, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctwoDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(cone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47)
                        .addComponent(jLabel48)
                        .addComponent(cthree, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49)
                        .addComponent(cfour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(cunitprice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(cqty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(ctotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddSale, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeVat)
                    .addComponent(jLabel56)
                    .addComponent(newVat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNoVat))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(153, 153, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ADD EXPENSES"));
        jPanel15.setForeground(new java.awt.Color(51, 51, 51));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setText("Expense Type:");

        cone1.setEditable(false);
        cone1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cone1.setText("EXPENSE");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setText("Expense Date:");

        ctwoDate1.setDateFormatString("yyyy-MM-dd");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Description:");

        cthree1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cthree1ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Category:");

        cfour1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Animal Husbandry", "Chemical", "Crop Expenses", "Feed Expenses", "Fertilizer", "Equipment", "Livestock - Cattle", "Livestock - Goats", "Livestock - Sheep", "Labour Expenses", "Licence and Insurance", "Machinary Expenses", "Office Expenses", "Other Expense", "Seed", "Transport", "Veterinary", "Wages", " " }));
        cfour1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfour1ActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Unit Price:");

        cunitprice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cunitprice1KeyReleased(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Quantity:");

        cqty1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cqty1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cqty1KeyReleased(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("Sub-Total:");

        csubtotal1.setEditable(false);

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 51));
        jLabel64.setText("Vat:");

        cvat1.setEditable(false);

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 51));
        jLabel65.setText("Total:");

        ctotal1.setEditable(false);

        buttonAddSale1.setBackground(new java.awt.Color(153, 153, 255));
        buttonAddSale1.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddSale1.setText("ADD");
        buttonAddSale1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSale1ActionPerformed(evt);
            }
        });

        radioNoVat1.setBackground(new java.awt.Color(204, 204, 255));
        radioNoVat1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioNoVat1.setForeground(new java.awt.Color(51, 51, 51));
        radioNoVat1.setText("No Vat");
        radioNoVat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoVat1ActionPerformed(evt);
            }
        });

        btnChangeVat1.setText("Edit Vat %");
        btnChangeVat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeVat1ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setText("New Vat:");

        newVat1.setText("15");
        newVat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newVat1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cone1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(radioNoVat1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cunitprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctwoDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(csubtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cvat1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ctotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChangeVat1))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newVat1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonAddSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cthree1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel60)
                        .addGap(18, 18, 18)
                        .addComponent(cfour1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctwoDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel57)
                        .addComponent(cone1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel58)
                        .addComponent(jLabel59)
                        .addComponent(cthree1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel60)
                        .addComponent(cfour1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(cunitprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(cqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csubtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvat1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(ctotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeVat1)
                    .addComponent(jLabel66)
                    .addComponent(newVat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNoVat1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel45)
                .addGap(40, 40, 40)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Income / Expense", jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 0));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("GENERATE BALANCSHEET - YEARLY");

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel119.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 0, 0));
        jLabel119.setText("TOTAL LIABILTIES:");

        jLabel120.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 0, 0));
        jLabel120.setText("INCOME NET WORTH:");

        jLabel121.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 0));
        jLabel121.setText("TOTAL:");

        TWO3.setText("0.00");
        TWO3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TWO3KeyReleased(evt);
            }
        });

        ONE3.setEditable(false);
        ONE3.setText("0.00");
        ONE3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ONE3KeyReleased(evt);
            }
        });

        THREE3.setEditable(false);
        THREE3.setText("0.00");

        jLabel122.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(0, 0, 0));
        jLabel122.setText("TOTAL ASSETS:");

        FOUR3.setEditable(false);
        FOUR3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FOUR3.setText("0.00");

        btnUpdate.setBackground(new java.awt.Color(204, 204, 255));
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(204, 204, 255));
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(204, 204, 255));
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120)
                    .addComponent(jLabel119)
                    .addComponent(jLabel121))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TWO3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(THREE3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ONE3))
                .addGap(118, 118, 118)
                .addComponent(jLabel122)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FOUR3)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(157, 157, 157))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(ONE3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122)
                    .addComponent(FOUR3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(TWO3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(THREE3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setText("LIABILITIES");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("DATE START:");

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel73.setText("CURRENT LIABILITES:");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel74.setText("Bank(s):");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel75.setText("Cooperatives(s):");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel76.setText("Creditors:");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel77.setText("Income tax:");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel78.setText("Bills payable:");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel79.setText("Long term liabilites:");

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel80.setText("R");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel81.setText("Total current Liabilites:");

        g.setEditable(false);
        g.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        g.setText("0.00");

        f.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        f.setText("0.00");
        f.setNextFocusableComponent(h);
        f.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fKeyReleased(evt);
            }
        });

        e.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e.setText("0.00");
        e.setNextFocusableComponent(f);
        e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eKeyReleased(evt);
            }
        });

        d.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        d.setText("0.00");
        d.setNextFocusableComponent(e);
        d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dKeyReleased(evt);
            }
        });

        c.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c.setText("0.00");
        c.setNextFocusableComponent(d);
        c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cKeyReleased(evt);
            }
        });

        b.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        b.setText("0.00");
        b.setNextFocusableComponent(c);
        b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bKeyReleased(evt);
            }
        });

        a.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        a.setText("0.00");
        a.setNextFocusableComponent(b);
        a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aKeyReleased(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel82.setText("MEDIUM TERM LIABILITES:");

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel83.setText("R");

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel84.setText("Term Loans:");

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel85.setText("Installment sales Credit:");

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel86.setText("Leases:");

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel87.setText("Other:");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel88.setText("Total Medium Liabilities:");

        h.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        h.setText("0.00");
        h.setNextFocusableComponent(i);
        h.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hKeyReleased(evt);
            }
        });

        i.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        i.setText("0.00");
        i.setNextFocusableComponent(j);
        i.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iKeyReleased(evt);
            }
        });

        j.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j.setText("0.00");
        j.setNextFocusableComponent(k);
        j.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jKeyReleased(evt);
            }
        });

        k.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        k.setText("0.00");
        k.setNextFocusableComponent(m);
        k.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kKeyReleased(evt);
            }
        });

        l.setEditable(false);
        l.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        l.setText("0.00");

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel89.setText("LONG TERM LIABILITES:");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel90.setText("R");

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel91.setText("Bonds:");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel92.setText("Long term loans:");

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel93.setText("Other loans:");

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel94.setText("Total Long Liabilities:");

        m.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        m.setText("0.00");
        m.setNextFocusableComponent(n);
        m.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mKeyReleased(evt);
            }
        });

        n.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        n.setText("0.00");
        n.setNextFocusableComponent(o);
        n.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nKeyReleased(evt);
            }
        });

        o.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        o.setText("0.00");
        o.setNextFocusableComponent(aa);
        o.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oKeyReleased(evt);
            }
        });

        p.setEditable(false);
        p.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        p.setText("0.00");
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel95.setText("CURRENT ASSETS:");

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel96.setText("R");

        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel99.setText("Cash on hand / in Bank:");

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel100.setText("Debtors:");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel101.setText("Prepaid Expenses:");

        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel102.setText("Prepaid:");

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel103.setText("Life insurance:");

        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel104.setText("Marketable Livestock:");

        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel105.setText("Stock on Hand:");

        aa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aa.setText("0.00");
        aa.setNextFocusableComponent(bb);
        aa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aaKeyReleased(evt);
            }
        });

        bb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bb.setText("0.00");
        bb.setNextFocusableComponent(cc);
        bb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bbKeyReleased(evt);
            }
        });

        cc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cc.setText("0.00");
        cc.setNextFocusableComponent(dd);
        cc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ccKeyReleased(evt);
            }
        });

        dd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dd.setText("0.00");
        dd.setNextFocusableComponent(ee);
        dd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ddKeyReleased(evt);
            }
        });

        ee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ee.setText("0.00");
        ee.setNextFocusableComponent(ff);

        ff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ff.setText("0.00");
        ff.setNextFocusableComponent(gg);
        ff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffActionPerformed(evt);
            }
        });
        ff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ffKeyReleased(evt);
            }
        });

        gg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gg.setText("0.00");
        gg.setNextFocusableComponent(ii);
        gg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ggKeyReleased(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel106.setText("Total current Assets:");

        hh.setEditable(false);
        hh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hh.setText("0.00");

        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel107.setText("MEDIUM TERM ASSETS:");

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel108.setText("R");

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel109.setText("Breeding-stock:");

        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel110.setText("Vehicles, equipement, machinery:");

        jLabel111.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel111.setText("Other: Office furniture, etc:");

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel112.setText("Total Medium term Assets:");

        ii.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ii.setText("0.00");
        ii.setNextFocusableComponent(jj);
        ii.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iiKeyReleased(evt);
            }
        });

        jj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jj.setText("0.00");
        jj.setNextFocusableComponent(kk);
        jj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jjKeyReleased(evt);
            }
        });

        kk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kk.setText("0.00");
        kk.setNextFocusableComponent(mm);
        kk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kkKeyReleased(evt);
            }
        });

        ll.setEditable(false);
        ll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ll.setText("0.00");

        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel113.setText("FIXED ASSETS:");

        jLabel114.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel114.setText("R");

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel115.setText("Fixed Improvements:");

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel116.setText("Land:");

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel117.setText("Other:");

        jLabel118.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel118.setText("Total fixed Assets:");

        mm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mm.setText("0.00");
        mm.setNextFocusableComponent(nn);
        mm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mmKeyReleased(evt);
            }
        });

        nn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nn.setText("0.00");
        nn.setNextFocusableComponent(oo);
        nn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nnKeyReleased(evt);
            }
        });

        oo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        oo.setText("0.00");
        oo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ooKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ooKeyReleased(evt);
            }
        });

        pp.setEditable(false);
        pp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pp.setText("0.00");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(169, 169, 169)
                        .addComponent(jLabel80))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel90))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel83))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addComponent(jLabel78)
                            .addComponent(jLabel77)
                            .addComponent(jLabel76)
                            .addComponent(jLabel75)
                            .addComponent(jLabel74)
                            .addComponent(jLabel81))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(g)
                            .addComponent(f)
                            .addComponent(e)
                            .addComponent(d)
                            .addComponent(c)
                            .addComponent(b)
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel84)
                                                .addComponent(jLabel85)
                                                .addComponent(jLabel86)
                                                .addComponent(jLabel87)
                                                .addComponent(jLabel88))
                                            .addGap(34, 34, 34))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                            .addComponent(jLabel91)
                                            .addGap(197, 197, 197)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel92)
                                        .addGap(127, 127, 127)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                    .addComponent(jLabel93)
                                    .addGap(159, 159, 159)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel94)
                                .addGap(62, 62, 62)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(o, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel99)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel100)
                                    .addComponent(jLabel101)
                                    .addComponent(jLabel102)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel104)
                                    .addComponent(jLabel105)
                                    .addComponent(jLabel106))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pp, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(oo)
                                    .addComponent(nn)
                                    .addComponent(mm)
                                    .addComponent(ll)
                                    .addComponent(kk)
                                    .addComponent(jj)
                                    .addComponent(ii)
                                    .addComponent(bb)
                                    .addComponent(cc)
                                    .addComponent(dd)
                                    .addComponent(ee)
                                    .addComponent(ff)
                                    .addComponent(gg)
                                    .addComponent(hh))))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel114)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel107)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel108))
                            .addComponent(jLabel109)
                            .addComponent(jLabel110)
                            .addComponent(jLabel111)
                            .addComponent(jLabel112)
                            .addComponent(jLabel115)
                            .addComponent(jLabel116)
                            .addComponent(jLabel117)
                            .addComponent(jLabel118))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel96)
                        .addGap(151, 151, 151))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jLabel80)
                    .addComponent(jLabel95)
                    .addComponent(jLabel96))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99)
                    .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100)
                    .addComponent(bb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101)
                    .addComponent(cc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102)
                    .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103)
                    .addComponent(ee, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104)
                    .addComponent(ff, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(gg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(hh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83)
                    .addComponent(jLabel107)
                    .addComponent(jLabel108))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(ii, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110)
                    .addComponent(jj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(kk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel88)
                        .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel112)
                        .addComponent(ll, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(jLabel90)
                    .addComponent(jLabel113)
                    .addComponent(jLabel114))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115)
                    .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116)
                    .addComponent(nn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(o, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117)
                    .addComponent(oo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118)
                    .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel16);

        datestart.setDateFormatString("yyyy-MM-dd");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 0, 0));
        jLabel97.setText("ASSETS");

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 0, 0));
        jLabel98.setText("DATE END:");

        dateend.setDateFormatString("yyyy-MM-dd");

        jLabel124.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(0, 0, 0));
        jLabel124.setText("BALANCESHEET ID:");

        bsid.setBackground(new java.awt.Color(204, 204, 204));
        bsid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(153, 153, 255));
        btnSearch.setForeground(new java.awt.Color(0, 0, 0));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addGap(51, 51, 51)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel124)
                                    .addComponent(jLabel72))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel97)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel98)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(bsid, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSearch)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(32, 32, 32))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(bsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel98)
                        .addComponent(jLabel97))
                    .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel72)
                        .addComponent(jLabel71)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Balancesheet", jPanel7);

        jPanel8.setForeground(new java.awt.Color(0, 0, 0));

        jPanel18.setBackground(new java.awt.Color(153, 153, 153));
        jPanel18.setForeground(new java.awt.Color(153, 153, 153));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("VALUE");

        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel127.setText("Breeding Cows / Ewe's:");

        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel128.setText("Heifers / Lambs 2 - 3 y.o:");

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel129.setText("Heifers / Lambs 1- 2 y.o:");

        jLabel130.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel130.setText("Weaners, Male:");

        jLabel131.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel131.setText("Weaners, Female:");

        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel132.setText("Bulls 3 y.o. +");

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel133.setText("Bulls 2 - 3 y.o. :");

        jLabel134.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel134.setText("Bulls 1 - 2 y.o. :");

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel135.setText("Steers / Weather:");

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel136.setText("Culled Cows / Ewes:");

        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel137.setText("Mortality rate:");

        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel138.setText("Purchased Bulls / Rams:");

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel139.setText("Purchased Cows / Ewe's:");

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel140.setText("Purchased Wethers / Weaners:");

        jLabel141.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel141.setText("Purchased Calves / Lambs:");

        V13.setText("0.00");
        V13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V13FocusGained(evt);
            }
        });
        V13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V13KeyReleased(evt);
            }
        });

        V14.setText("0.00");
        V14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V14KeyReleased(evt);
            }
        });

        V12.setText("0.00");
        V12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V12KeyReleased(evt);
            }
        });

        V11.setText("0.00");
        V11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V11KeyReleased(evt);
            }
        });

        V10.setText("0.00");
        V10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V10KeyReleased(evt);
            }
        });

        V9.setText("0.00");
        V9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V9KeyReleased(evt);
            }
        });

        V8.setText("0.00");
        V8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V8KeyReleased(evt);
            }
        });

        V7.setText("0.00");
        V7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V7KeyReleased(evt);
            }
        });

        V6.setText("0.00");
        V6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V6KeyReleased(evt);
            }
        });

        V5.setText("0.00");
        V5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V5KeyReleased(evt);
            }
        });

        V4.setText("0.00");
        V4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V4KeyReleased(evt);
            }
        });

        V3.setText("0.00");
        V3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V3KeyReleased(evt);
            }
        });

        V2.setText("0.00");
        V2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V2KeyReleased(evt);
            }
        });

        V1.setText("0.00");
        V1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V1KeyReleased(evt);
            }
        });

        V.setText("0.00");
        V.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VKeyReleased(evt);
            }
        });

        jLabel142.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setText("ANIMAL CLASS");

        Q.setText("0");
        Q.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QKeyReleased(evt);
            }
        });

        Q1.setText("0");
        Q1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q1KeyReleased(evt);
            }
        });

        Q2.setText("0");
        Q2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q2KeyReleased(evt);
            }
        });

        Q3.setText("0");
        Q3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q3KeyReleased(evt);
            }
        });

        Q4.setText("0");
        Q4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q4KeyReleased(evt);
            }
        });

        Q5.setText("0");
        Q5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q5KeyReleased(evt);
            }
        });

        Q6.setText("0");
        Q6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q6KeyReleased(evt);
            }
        });

        Q7.setText("0");
        Q7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q7KeyReleased(evt);
            }
        });

        Q8.setText("0");
        Q8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q8KeyReleased(evt);
            }
        });

        Q9.setText("0");
        Q9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q9KeyReleased(evt);
            }
        });

        Q10.setText("0");
        Q10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q10KeyReleased(evt);
            }
        });

        Q11.setText("0");
        Q11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q11KeyReleased(evt);
            }
        });

        Q12.setText("0");
        Q12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q12KeyReleased(evt);
            }
        });

        Q13.setText("0");
        Q13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q13KeyReleased(evt);
            }
        });

        Q14.setText("0");
        Q14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q14KeyReleased(evt);
            }
        });

        jLabel143.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel143.setText("QTY");

        jLabel144.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel144.setText("TOTAL");

        T.setText("0.00");
        T.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T.setEnabled(false);

        T1.setText("0.00");
        T1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T1.setEnabled(false);

        T2.setText("0.00");
        T2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T2.setEnabled(false);

        T3.setText("0.00");
        T3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T3.setEnabled(false);

        T4.setText("0.00");
        T4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T4.setEnabled(false);

        T5.setText("0.00");
        T5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T5.setEnabled(false);

        T6.setText("0.00");
        T6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T6.setEnabled(false);

        T7.setText("0.00");
        T7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T7.setEnabled(false);

        T8.setText("0.00");
        T8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T8.setEnabled(false);

        T9.setText("0.00");
        T9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T9.setEnabled(false);

        T10.setText("0.00");
        T10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T10.setEnabled(false);

        T11.setText("0.00");
        T11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T11.setEnabled(false);

        T12.setText("0.00");
        T12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T12.setEnabled(false);

        T13.setText("0.00");
        T13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T13.setEnabled(false);

        T14.setText("0.00");
        T14.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T14.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel140)
                    .addComponent(jLabel141)
                    .addComponent(jLabel139)
                    .addComponent(jLabel138)
                    .addComponent(jLabel137)
                    .addComponent(jLabel136)
                    .addComponent(jLabel135)
                    .addComponent(jLabel134)
                    .addComponent(jLabel133)
                    .addComponent(jLabel132)
                    .addComponent(jLabel131)
                    .addComponent(jLabel130)
                    .addComponent(jLabel129)
                    .addComponent(jLabel128)
                    .addComponent(jLabel127)
                    .addComponent(jLabel142))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(V, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(V1)
                    .addComponent(V2)
                    .addComponent(V3)
                    .addComponent(V4)
                    .addComponent(V5)
                    .addComponent(V6)
                    .addComponent(V7)
                    .addComponent(V8)
                    .addComponent(V9)
                    .addComponent(V10)
                    .addComponent(V11)
                    .addComponent(V12)
                    .addComponent(V14)
                    .addComponent(V13)
                    .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Q)
                    .addComponent(Q1)
                    .addComponent(Q2)
                    .addComponent(Q3)
                    .addComponent(Q4)
                    .addComponent(Q5)
                    .addComponent(Q6)
                    .addComponent(Q7)
                    .addComponent(Q8)
                    .addComponent(Q9)
                    .addComponent(Q10)
                    .addComponent(Q11)
                    .addComponent(Q12)
                    .addComponent(Q13)
                    .addComponent(Q14)
                    .addComponent(jLabel143, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(T)
                    .addComponent(T1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(T2)
                    .addComponent(T3)
                    .addComponent(T4)
                    .addComponent(T5)
                    .addComponent(T6)
                    .addComponent(T7)
                    .addComponent(T8)
                    .addComponent(T9)
                    .addComponent(T10)
                    .addComponent(T11)
                    .addComponent(T12)
                    .addComponent(T13)
                    .addComponent(T14))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(jLabel126)
                    .addComponent(jLabel143)
                    .addComponent(jLabel144))
                .addGap(21, 21, 21)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel128)
                    .addComponent(V1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(V2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(V3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131)
                    .addComponent(V4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel132)
                    .addComponent(V5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(V6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(V7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(V8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(V9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(V10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel138)
                    .addComponent(V11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(V12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel140)
                    .addComponent(V13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(V14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel148.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel148.setText("VALUE");

        jLabel149.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel149.setText("Breeding Cows / Ewe's:");

        jLabel150.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel150.setText("Heifers / Lambs 2 - 3 y.o:");

        jLabel151.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel151.setText("Heifers / Lambs 1- 2 y.o:");

        jLabel152.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel152.setText("Weaners, Male:");

        jLabel153.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel153.setText("Weaners, Female:");

        jLabel154.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel154.setText("Bulls 3 y.o. +");

        jLabel155.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel155.setText("Bulls 2 - 3 y.o. :");

        jLabel156.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel156.setText("Bulls 1 - 2 y.o. :");

        jLabel157.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel157.setText("Steers / Weather:");

        jLabel158.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel158.setText("Culled Cows / Ewes:");

        jLabel159.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel159.setText("Mortality rate:");

        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel160.setText("Purchased Bulls / Rams:");

        jLabel161.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel161.setText("Purchased Cows / Ewe's:");

        jLabel162.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel162.setText("Purchased Wethers / Weaners:");

        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel163.setText("Purchased Calves / Lambs:");

        V29.setText("0.00");
        V29.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V29FocusGained(evt);
            }
        });
        V29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V29KeyReleased(evt);
            }
        });

        V30.setText("0.00");
        V30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V30KeyReleased(evt);
            }
        });

        V28.setText("0.00");
        V28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V28KeyReleased(evt);
            }
        });

        V27.setText("0.00");
        V27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V27KeyReleased(evt);
            }
        });

        V26.setText("0.00");
        V26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V26KeyReleased(evt);
            }
        });

        V25.setText("0.00");
        V25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V25KeyReleased(evt);
            }
        });

        V24.setText("0.00");
        V24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V24KeyReleased(evt);
            }
        });

        V23.setText("0.00");
        V23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V23KeyReleased(evt);
            }
        });

        V22.setText("0.00");
        V22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V22KeyReleased(evt);
            }
        });

        V21.setText("0.00");
        V21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V21KeyReleased(evt);
            }
        });

        V20.setText("0.00");
        V20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V20KeyReleased(evt);
            }
        });

        V19.setText("0.00");
        V19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V19KeyReleased(evt);
            }
        });

        V18.setText("0.00");
        V18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V18KeyReleased(evt);
            }
        });

        V17.setText("0.00");
        V17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V17KeyReleased(evt);
            }
        });

        V16.setText("0.00");
        V16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V16KeyReleased(evt);
            }
        });

        jLabel164.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel164.setText("ANIMAL CLASS");

        Q16.setText("0");
        Q16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q16KeyReleased(evt);
            }
        });

        Q17.setText("0");
        Q17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q17KeyReleased(evt);
            }
        });

        Q18.setText("0");
        Q18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q18KeyReleased(evt);
            }
        });

        Q19.setText("0");
        Q19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q19KeyReleased(evt);
            }
        });

        Q20.setText("0");
        Q20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q20KeyReleased(evt);
            }
        });

        Q21.setText("0");
        Q21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q21KeyReleased(evt);
            }
        });

        Q22.setText("0");
        Q22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q22KeyReleased(evt);
            }
        });

        Q23.setText("0");
        Q23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q23KeyReleased(evt);
            }
        });

        Q24.setText("0");
        Q24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q24KeyReleased(evt);
            }
        });

        Q25.setText("0");
        Q25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q25KeyReleased(evt);
            }
        });

        Q26.setText("0");
        Q26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q26KeyReleased(evt);
            }
        });

        Q27.setText("0");
        Q27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q27KeyReleased(evt);
            }
        });

        Q28.setText("0");
        Q28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q28KeyReleased(evt);
            }
        });

        Q29.setText("0");
        Q29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q29KeyReleased(evt);
            }
        });

        Q30.setText("0");
        Q30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q30KeyReleased(evt);
            }
        });

        jLabel165.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel165.setText("QTY");

        jLabel166.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel166.setText("TOTAL");

        T16.setText("0.00");
        T16.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T16.setEnabled(false);

        T17.setText("0.00");
        T17.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T17.setEnabled(false);

        T18.setText("0.00");
        T18.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T18.setEnabled(false);

        T19.setText("0.00");
        T19.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T19.setEnabled(false);

        T20.setText("0.00");
        T20.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T20.setEnabled(false);

        T21.setText("0.00");
        T21.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T21.setEnabled(false);

        T22.setText("0.00");
        T22.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T22.setEnabled(false);

        T23.setText("0.00");
        T23.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T23.setEnabled(false);

        T24.setText("0.00");
        T24.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T24.setEnabled(false);

        T25.setText("0.00");
        T25.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T25.setEnabled(false);

        T26.setText("0.00");
        T26.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T26.setEnabled(false);

        T27.setText("0.00");
        T27.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T27.setEnabled(false);

        T28.setText("0.00");
        T28.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T28.setEnabled(false);

        T29.setText("0.00");
        T29.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T29.setEnabled(false);

        T30.setText("0.00");
        T30.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T30.setEnabled(false);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel162)
                    .addComponent(jLabel163)
                    .addComponent(jLabel161)
                    .addComponent(jLabel160)
                    .addComponent(jLabel159)
                    .addComponent(jLabel158)
                    .addComponent(jLabel157)
                    .addComponent(jLabel156)
                    .addComponent(jLabel155)
                    .addComponent(jLabel154)
                    .addComponent(jLabel153)
                    .addComponent(jLabel152)
                    .addComponent(jLabel151)
                    .addComponent(jLabel150)
                    .addComponent(jLabel149)
                    .addComponent(jLabel164))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(V16, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(V17)
                    .addComponent(V18)
                    .addComponent(V19)
                    .addComponent(V20)
                    .addComponent(V21)
                    .addComponent(V22)
                    .addComponent(V23)
                    .addComponent(V24)
                    .addComponent(V25)
                    .addComponent(V26)
                    .addComponent(V27)
                    .addComponent(V28)
                    .addComponent(V30)
                    .addComponent(V29)
                    .addComponent(jLabel148, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Q16)
                    .addComponent(Q17)
                    .addComponent(Q18)
                    .addComponent(Q19)
                    .addComponent(Q20)
                    .addComponent(Q21)
                    .addComponent(Q22)
                    .addComponent(Q23)
                    .addComponent(Q24)
                    .addComponent(Q25)
                    .addComponent(Q26)
                    .addComponent(Q27)
                    .addComponent(Q28)
                    .addComponent(Q29)
                    .addComponent(Q30)
                    .addComponent(jLabel165, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel166, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(T16)
                    .addComponent(T17, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(T18)
                    .addComponent(T19)
                    .addComponent(T20)
                    .addComponent(T21)
                    .addComponent(T22)
                    .addComponent(T23)
                    .addComponent(T24)
                    .addComponent(T25)
                    .addComponent(T26)
                    .addComponent(T27)
                    .addComponent(T28)
                    .addComponent(T29)
                    .addComponent(T30))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jLabel148)
                    .addComponent(jLabel165)
                    .addComponent(jLabel166))
                .addGap(21, 21, 21)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(V16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(V17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151)
                    .addComponent(V18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(V19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel153)
                    .addComponent(V20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel154)
                    .addComponent(V21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel155)
                    .addComponent(V22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel156)
                    .addComponent(V23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157)
                    .addComponent(V24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel158)
                    .addComponent(V25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(V26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel160)
                    .addComponent(V27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel161)
                    .addComponent(V28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(V29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(V30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jScrollPane10.setViewportView(jPanel18);

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("CLOSING DATE:");

        dateOpen.setDateFormatString("yyyy-MM-dd");

        jLabel125.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 0, 0));
        jLabel125.setText("OPENING DATE:");

        dateClose.setDateFormatString("yyyy-MM-dd");

        jLabel145.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(0, 0, 0));
        jLabel145.setText("TOTAL QUANTITY:");

        Q15.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Q15.setEnabled(false);

        jLabel146.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(0, 0, 0));
        jLabel146.setText("OPENING TOTAL:");

        T15.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T15.setEnabled(false);

        jLabel147.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(0, 0, 0));
        jLabel147.setText("ACCOUNT ID:");

        jLabel167.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(0, 0, 0));
        jLabel167.setText("TOTAL DIFFERENCE:");

        jLabel168.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(0, 0, 0));
        jLabel168.setText("TOTAL QUANTITY:");

        Q31.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Q31.setEnabled(false);

        T31.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        T31.setEnabled(false);

        jLabel169.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(0, 0, 0));
        jLabel169.setText("CLOSING TOTAL:");

        D.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        D.setEnabled(false);

        btnClearT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear16.png"))); // NOI18N
        btnClearT.setText("CLEAR");
        btnClearT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTActionPerformed(evt);
            }
        });

        btnUpdateT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        btnUpdateT.setText("UPDATE");
        btnUpdateT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTActionPerformed(evt);
            }
        });

        btnSaveT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnSaveT.setText("SAVE");
        btnSaveT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTActionPerformed(evt);
            }
        });

        btnSearchT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/weaner.png"))); // NOI18N
        btnSearchT.setText("SEARCH");
        btnSearchT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel145)
                    .addComponent(jLabel125)
                    .addComponent(jLabel146)
                    .addComponent(jLabel147))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ACCOUNTID, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T31, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUpdateT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q31, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(148, 148, 148)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel167)
                    .addComponent(jLabel169)
                    .addComponent(jLabel168)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(T15, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q15, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateClose, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(dateOpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel147)
                                    .addComponent(ACCOUNTID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel146)
                                    .addComponent(T31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel145)
                                    .addComponent(Q31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel125))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSaveT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel167)
                                    .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearchT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel169)
                                    .addComponent(T15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel168)
                                    .addComponent(Q15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel52)
                                    .addComponent(dateClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpdateT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClearT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Trading Account", jPanel8);

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));

        jLabel123.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(0, 0, 0));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("BALANCESHEET AND TRADING ACCOUNTS - YEARLY");

        tableBalance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BST ID", "Date-start", "Date-end", "Total Liabilities", "Net Worth", "Total", "Total Assets"
            }
        ));
        jScrollPane11.setViewportView(tableBalance);

        tableAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Accounts ID", "Date Open", "Open Total", "Open Qty", "Close Total", "Close Qty", "Difference", "Date Close"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tableAccounts);

        btnDeleteB.setBackground(new java.awt.Color(153, 153, 255));
        btnDeleteB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteB.setText("DELETE");
        btnDeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBActionPerformed(evt);
            }
        });

        btnDeleteT.setBackground(new java.awt.Color(153, 153, 255));
        btnDeleteT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteT.setText("DELETE");
        btnDeleteT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123, javax.swing.GroupLayout.DEFAULT_SIZE, 1146, Short.MAX_VALUE)
                    .addComponent(jScrollPane11)
                    .addComponent(jScrollPane9)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteB, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteT, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel123)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnDeleteT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jTabbedPane2.addTab("View Balancesheet and Trading Accounts", jPanel17);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addGap(69, 69, 69))
        );

        tabFinancial.addTab("Financial", jPanel2);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("EMPLOYEE INFORMATION AND RECORDS");

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("*Emp ID:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("*Emp Name:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("*Emp Surname:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("*Date-of-Birth:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("*Emp ID Nr:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("*Emp  Phone:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("*Emp Email:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("*Emp Gender:");

        efive.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                efiveKeyPressed(evt);
            }
        });

        esixs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                esixsKeyPressed(evt);
            }
        });

        eseven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                esevenKeyPressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("*Emp Date:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("*Job Category:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("*Hourly Rate R:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("*Gross Salary R:");

        eeight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Male", "Female" }));

        eten.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Farm Manager", "Farm-Hand", "Feedlot Manager", "General Manager", "General worker", "Stock-Hand", "Temporary worker", "Other" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel30))
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(etwo, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(ethree)
                            .addComponent(eone)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(efour, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel34)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(efive)
                    .addComponent(eseven)
                    .addComponent(esixs)
                    .addComponent(eeight, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel41)
                        .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eten, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etwelve)
                    .addComponent(eeleven, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(enine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(etwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(eten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(eeleven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(eone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(etwo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ethree, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(efive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(esixs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(eseven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(efour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel37)
                                        .addComponent(eeight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );

        buttonClearE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearE.setText("CLEAR");
        buttonClearE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearEActionPerformed(evt);
            }
        });

        buttonDeleteE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteE.setText("DELETE");
        buttonDeleteE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteEActionPerformed(evt);
            }
        });

        buttonUpdateE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateE.setText("UPDATE");
        buttonUpdateE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateEActionPerformed(evt);
            }
        });

        buttonSearchE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchE.setText("SEARCH");
        buttonSearchE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchEActionPerformed(evt);
            }
        });

        buttonSaveE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonSaveE.setText("SAVE");
        buttonSaveE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveEActionPerformed(evt);
            }
        });

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Emp Name", "Surname", "Date-of-Birth", "Emp ID Nr", "Phone Nr", "Emp Email", "Gender", "Emp Date", "Category", "Hourly Rate", "Salary"
            }
        ));
        jScrollPane3.setViewportView(tableEmp);
        if (tableEmp.getColumnModel().getColumnCount() > 0) {
            tableEmp.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableEmp.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jScrollPane7.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(buttonSaveE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonSearchE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonUpdateE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(buttonDeleteE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonClearE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSaveE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearchE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabFinancial.addTab("Employee's", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("LABOUR INFORMATION AND RECORDS");

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("*Labour ID:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("*Labour Name:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("*Labour Surname:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("*Contract Type:");

        lone.setNextFocusableComponent(ltwo);

        ltwo.setNextFocusableComponent(lthree);

        lthree.setNextFocusableComponent(lfour);

        lfour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Permanent", "Temporary" }));
        lfour.setNextFocusableComponent(lfive);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("*Position:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("*Normal Hours:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Overtime Hours:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Total Hours:");

        lseven.setText("0");
        lseven.setNextFocusableComponent(leight);
        lseven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lsevenKeyReleased(evt);
            }
        });

        lfive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Farm Manager", "Farm-Hand", "Feedlot Manager", "General Manager", "General worker", "Stock-Hand", "Temporary worker", "Other" }));
        lfive.setNextFocusableComponent(lsixs);

        lsixs.setNextFocusableComponent(lseven);
        lsixs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lsixsKeyReleased(evt);
            }
        });

        leight.setEditable(false);
        leight.setNextFocusableComponent(lnine);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("*Hourly Rate:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Deductions UIF:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Deductions PAYE:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Other Deductions:");

        ltwelve.setText("0.00");
        ltwelve.setNextFocusableComponent(lthirteen);
        ltwelve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ltwelveKeyReleased(evt);
            }
        });

        leleven.setText("0.00");
        leleven.setNextFocusableComponent(ltwelve);
        leleven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lelevenKeyReleased(evt);
            }
        });

        lten.setEditable(false);
        lten.setText("0.00");
        lten.setNextFocusableComponent(leleven);

        lnine.setNextFocusableComponent(lten);
        lnine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lnineKeyPressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("NET SALARY");

        lthirteen.setEditable(false);
        lthirteen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lthirteen.setNextFocusableComponent(buttonSaveL);

        buttonUIF.setBackground(new java.awt.Color(153, 153, 255));
        buttonUIF.setForeground(new java.awt.Color(0, 0, 0));
        buttonUIF.setText("CHANGE UIF %");
        buttonUIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUIFActionPerformed(evt);
            }
        });

        UIF.setEditable(false);
        UIF.setText("1");
        UIF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UIFKeyPressed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setText("UIF %");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lone)
                            .addComponent(ltwo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lthree)
                            .addComponent(lfour, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lsixs)
                    .addComponent(lseven)
                    .addComponent(lfive, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leight, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ltwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leleven, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lthirteen)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUIF)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UIF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(lfive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(lnine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ltwo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(lsixs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(lten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lthirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lthree, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(lseven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(leleven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUIF))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lfour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(leight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(ltwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        buttonSaveL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonSaveL.setText("SAVE");
        buttonSaveL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveLActionPerformed(evt);
            }
        });

        buttonSearchL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchL.setText("SEARCH");
        buttonSearchL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchLActionPerformed(evt);
            }
        });

        buttonUpdateL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateL.setText("UPDATE");
        buttonUpdateL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateLActionPerformed(evt);
            }
        });

        buttonDeleteL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteL.setText("DELETE");
        buttonDeleteL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteLActionPerformed(evt);
            }
        });

        buttonClearL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearL.setText("CLEAR");
        buttonClearL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearLActionPerformed(evt);
            }
        });

        tableLabour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Surname", "Contract Type", "Position", "N Hours", "Overtime", "Total Hr", "Hourly Rate", "UIF", "PAYE", "Deductions", "Total Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableLabour);
        if (tableLabour.getColumnModel().getColumnCount() > 0) {
            tableLabour.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableLabour.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableLabour.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableLabour.getColumnModel().getColumn(5).setPreferredWidth(40);
            tableLabour.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        jScrollPane6.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(buttonSaveL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonSearchL)
                        .addGap(37, 37, 37)
                        .addComponent(buttonUpdateL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(buttonDeleteL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonClearL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSaveL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearchL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabFinancial.addTab("Labour", jPanel4);

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("*Contact ID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("*Contact Name:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("*Contact Number:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Add / Delete Category:");

        three.setNextFocusableComponent(four);
        three.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                threeKeyPressed(evt);
            }
        });

        two.setNextFocusableComponent(three);

        one.setNextFocusableComponent(two);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("*Company Name:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("*Company Vat:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Company Reg:");

        four.setNextFocusableComponent(five);

        five.setNextFocusableComponent(sixs);
        five.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fiveKeyPressed(evt);
            }
        });

        sixs.setNextFocusableComponent(emailc);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("*Company Email:");

        emailc.setNextFocusableComponent(seven);
        emailc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailcKeyReleased(evt);
            }
        });

        btnAddC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        btnAddC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCActionPerformed(evt);
            }
        });

        btnDeleteC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        btnDeleteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("*Category:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("*Street Address:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("*City / Town:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("*Postal Code:");

        seven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        seven.setNextFocusableComponent(eight);
        seven.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sevenFocusGained(evt);
            }
        });

        eight.setNextFocusableComponent(nine);

        nine.setNextFocusableComponent(ten);

        ten.setNextFocusableComponent(buttonSaveC);
        ten.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tenKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(one, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(two)
                            .addComponent(three)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddC)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteC)))
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(emailc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(five)
                            .addComponent(sixs, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(four))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(seven, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eight)
                    .addComponent(nine)
                    .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(sixs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteC)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(emailc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(btnAddC))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CONTACT / SUPPLIERS INFORMATION");

        buttonSaveC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonSaveC.setText("SAVE");
        buttonSaveC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveCActionPerformed(evt);
            }
        });

        buttonSearchC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchC.setText("SEARCH");
        buttonSearchC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchCActionPerformed(evt);
            }
        });

        buttonUpdateC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateC.setText("UPDATE");
        buttonUpdateC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateCActionPerformed(evt);
            }
        });

        buttonDeleteC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteC.setText("DELETE");
        buttonDeleteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteCActionPerformed(evt);
            }
        });

        buttonClearC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearC.setText("CLEAR");
        buttonClearC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearCActionPerformed(evt);
            }
        });

        tableContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Contact Nr", "Company Name", "Company Vat", "Registration Nr", "Company Email", "Category", "Street Address", "City / Town", "Postal Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableContacts);
        if (tableContacts.getColumnModel().getColumnCount() > 0) {
            tableContacts.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jScrollPane5.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSaveC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonSearchC)
                        .addGap(37, 37, 37)
                        .addComponent(buttonUpdateC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(buttonDeleteC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonClearC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSaveC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearchC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabFinancial.addTab("Contact's", jPanel5);

        getContentPane().add(tabFinancial, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 1170, 690));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logopng_200px.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 170));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgfarm.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 890));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        // TODO add your handling code here:
          tabFinancial.setSelectedIndex(0);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnimalActionPerformed
     
        tabFinancial.setSelectedIndex(1);

    }//GEN-LAST:event_buttonAnimalActionPerformed

    private void buttonFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFeedActionPerformed
        
        tabFinancial.setSelectedIndex(2);
    }//GEN-LAST:event_buttonFeedActionPerformed

    private void buttonStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStock1ActionPerformed
        tabFinancial.setSelectedIndex(3);
    }//GEN-LAST:event_buttonStock1ActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        // Back to main page (Close button)

        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void btnAddCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCActionPerformed
        // Add Company Name / Category

        //Prompt User

        try {

            String category = JOptionPane.showInputDialog(null, "Please enter Company or Category Name", "AGRI8 ASSIST: ENTER COMPANY / CATEGORY NAME", JOptionPane.QUESTION_MESSAGE);

            if(category.equals("")) {
                JOptionPane.showMessageDialog(null, "Dialog Box Empty, Not Saved!");
            } else {

                Connection conn = myConnection.getConnect();

                //Save new Item / String
                String saveQuery = "INSERT INTO tbl_company(category)" +
                "values(?)";

                PreparedStatement psm = conn.prepareStatement(saveQuery);

                psm.setString(1, category);
                psm.executeUpdate();
                this.dispose();
                new ClassFinancialEmp().setVisible(true);
                JOptionPane.showMessageDialog(null, "Item Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                conn.close();
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.out.print("System Error: " + e);
        }
    }//GEN-LAST:event_btnAddCActionPerformed

    private void btnDeleteCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCActionPerformed
        // Remove Category

        try {
            Connection conn = myConnection.getConnect();
            String category = (String) seven.getSelectedItem();

            if(category.equals("SELECT")) {

                JOptionPane.showMessageDialog(null, " Please select Suppliers Category in ComboBox to delete!", "AGRI8 ASSIST: PLEASE SELECT!", JOptionPane.ERROR_MESSAGE);

            } else {

                String sqldelete = "DELETE FROM tbl_company WHERE category = '" + category + "'";

                PreparedStatement pst=conn.prepareStatement(sqldelete);
                pst.executeUpdate(sqldelete);
                JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                this.dispose();
                new ClassFinancialEmp().setVisible(true);
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.print("Calculation error " + e);
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnDeleteCActionPerformed

    private void sevenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sevenFocusGained
         
    }//GEN-LAST:event_sevenFocusGained

    private void buttonSaveCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveCActionPerformed
          // Save Contact to database
        
        String id = one.getText().trim();
        String name = two.getText().trim();
        String number = three.getText().trim();
        String c_name = four.getText().trim();
        
        //  Integer vat = Integer.valueOf(five.getText());
         BigDecimal vat = null;
      
         try {
             vat = BigDecimal.valueOf(Long.parseLong(five.getText().trim()));
             
         } catch (NumberFormatException | NullPointerException e) {
             
         }
      
      
        String reg = sixs.getText().trim();
        String email = emailc.getText().trim();
        String category = (String) seven.getSelectedItem();
        String street = eight.getText().trim();
        String city = nine.getText().trim();
       // Integer code = Integer.valueOf(ten.getText());
     
        //Validation to check if controls are empty or not
        if(id.isEmpty()|| name.isEmpty() || number.isEmpty() || c_name.isEmpty() || email.isEmpty() || category.isEmpty() || 
          category.equals("SELECT") || city.isEmpty())
        {    
           JOptionPane.showMessageDialog(null, "All mandatory (*) fields must be completed!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
        
        } else {
            
            try {
                
                Connection conn = myConnection.getConnect(); 
                
                //Check CONTACT already exists
                String checkName = "SELECT c_id FROM tbl_company_reg WHERE c_id = '" + id + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                if(rs.next() == true) {// If CONTACT name has already been taken
                    JOptionPane.showMessageDialog(null, "Company ID " + id + " already exist in Database!", "ERROR, USER ALREADY EXIST", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new Contact
                    String saveQuery = "INSERT INTO tbl_company_reg(c_id, c_name, c_number, c_comp_name, c_vat, c_reg, c_email, c_category, c_street, c_city, c_area)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);
                                 
                    psm.setString(1, id);                
                    psm.setString(2, name);
                    psm.setString(3, number);
                    psm.setString(4, c_name);
                    
                    try {
                    
                          // Accept Null excption from string to Integer
                     if ( five.getText().isEmpty()  ) {
                          psm.setNull(5, Types.DECIMAL);
                      } else {
                        
                         psm.setBigDecimal(5, BigDecimal.valueOf(Long.parseLong(five.getText().trim())));
                      }
                   
                    }catch(NullPointerException |NumberFormatException e) {
                        System.out.print("Null Pointer Exception caught! " + e);
                    }
                                
                    psm.setString(6, reg);
                    psm.setString(7, email);
                    psm.setString(8, category);
                    psm.setString(9, street);                  
                    psm.setString(10, city);
                    
                  try {  
                   // Accept Null excption from string to Integer
                     if ( ten.getText().isEmpty()  ) {
                        JOptionPane.showMessageDialog(null, "Please add Postal Code", "POSTAL CODE REQUIED", JOptionPane.INFORMATION_MESSAGE);
                        psm.setNull(11, Types.INTEGER);
                      } else {
                        psm.setInt(11, Integer.valueOf(ten.getText()));
                      }
                
                     }catch(NullPointerException |NumberFormatException e) {
                        System.out.print("Null Pointer Exception caught! " + e);
                    } 
                     
                     
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "New Supplier Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                        this.dispose();
                        new ClassFinancialEmp().setVisible(true);
                    
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Contact ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    }     
             }
        
            } catch (SQLException | HeadlessException |NullPointerException e) {
                 System.err.print("Calculation error " + e);
                        //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonSaveCActionPerformed

    private void threeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_threeKeyPressed
        
         // Set JTextfield to accept only Integers of a certain Length
        // for contact number
        
        String number = three.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                three.setEditable(true);
            } else {
                 three.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                three.setEditable(true);
            } else {
                three.setEditable(false);
            }
        }
        } catch(NullPointerException e){
            
        }
    }//GEN-LAST:event_threeKeyPressed

    private void fiveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fiveKeyPressed
           // Set JTextfield to accept only Integers of a certain Length
        // for contact vat number
        
        String number = five.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                five.setEditable(true);
            } else {
                 five.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                five.setEditable(true);
            } else {
                five.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
            
        }
    }//GEN-LAST:event_fiveKeyPressed

    private void tenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tenKeyPressed
        
          // Set JTextfield to accept only Integers of a certain Length
        // for contact area code number
        
        String number = ten.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                ten.setEditable(true);
            } else {
                 ten.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                ten.setEditable(true);
            } else {
                ten.setEditable(false);
            }
        }
        } catch (NullPointerException e){
            
        }
    }//GEN-LAST:event_tenKeyPressed

    private void emailcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailcKeyReleased
          
        int email = emailc.getCaretPosition();
                emailc.setText(emailc.getText().toLowerCase());
                emailc.setCaretPosition(email);
    }//GEN-LAST:event_emailcKeyReleased

    private void buttonDeleteCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteCActionPerformed
        
        Connection conn = myConnection.getConnect();

        String ONE = one.getText().trim();    
       
        if(one.equals("") ) {
            
              JOptionPane.showMessageDialog(null, " Please select Row in the table to Delete!", "NO ROW SELECTED!", JOptionPane.ERROR_MESSAGE);
       
        } else {
         
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelC = (DefaultTableModel) tableContacts.getModel();
            
            if(tableContacts.getSelectedRowCount()==1) {
            
            int row = tableContacts.getSelectedRow();
            String cell = tableContacts.getModel().getValueAt(row, 0).toString();
            tblModelC.removeRow((int) row);
            String sql = "DELETE FROM tbl_company_reg WHERE c_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                    
            } else {
                
                if(tableContacts.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
       }
    }//GEN-LAST:event_buttonDeleteCActionPerformed

    private void buttonClearCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearCActionPerformed
        
       this.dispose();
       new ClassFinancialEmp().setVisible(true);
              
     
    }//GEN-LAST:event_buttonClearCActionPerformed

    private void buttonUpdateCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateCActionPerformed
        
        Connection conn = myConnection.getConnect();
        
        String CID =  one.getText().trim();         
        String TWOC =  two.getText().trim();      
        String THREEC = three.getText().trim();               
        String FOURC = four.getText().trim();     
        String FIVEC = five.getText().trim();         
        String SIXSC = sixs.getText().trim();
        String EMAILC = emailc.getText().trim();
        String SEVENC = (String) seven.getSelectedItem();
        String EIGHTC = eight.getText().trim(); 
        String NINEC = nine.getText().trim();         
        String TENC = ten.getText().trim();        
       
     
         if(CID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please search Contact ID to update!", "AGRI8 ASSIST: CONTACT ID!", JOptionPane.ERROR_MESSAGE);
            one.requestFocus();
         } else if (TWOC.isEmpty() || THREEC.isEmpty() || FOURC.isEmpty() || EMAILC.isEmpty() || SEVENC.equals("SELECT") || EIGHTC.isEmpty() || NINEC.isEmpty() || TENC.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Please complete (*) mandatory fields!", "AGRI8 ASSIST: ENTER MANDATORY FIELDS!", JOptionPane.ERROR_MESSAGE);
        }else {
   
            try {

                String query = "UPDATE tbl_company_reg SET " +
                "c_id= '" + CID + "', c_name = '" + TWOC + "', c_number = '" + THREEC + "', c_comp_name= '" + FOURC + "', c_vat = ?, c_reg = ?, c_email = '" + EMAILC + "', c_category = '" 
                        + SEVENC + "', c_street = '" + EIGHTC + "', c_city = '" + NINEC + "', c_area = '" + TENC + "'" + " WHERE c_id= '" + CID + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
                
                try{
                      // Accept Null excption from string to Integer
                     if ( five.getText().isEmpty() || five.getText() == null) { 
                         statement.setNull(1, Types.NULL);
                        } else {
                             statement.setBigDecimal(1, BigDecimal.valueOf(Long.parseLong(five.getText().trim())));
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
                 
                          try{
                      // Accept Null excption from string to Integer
                     if ( sixs.getText() != null ) { 
                            
                            statement.setString(2, SIXSC);
                      
                        } else {  
                          statement.setNull(2, Types.NULL);
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
                  
                int i = statement.executeUpdate();
                
                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + CID + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassFinancialEmp().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.print("System or Database error: " + e);
            }
            
         }
 
    }//GEN-LAST:event_buttonUpdateCActionPerformed

    private void buttonSaveLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveLActionPerformed
        
        
        // Save new Labour to database

        String LONE = lone.getText().trim();
        String LTWO = ltwo.getText().trim();
        String LTHREE = lthree.getText().trim();
        String LFOUR = (String) lfour.getSelectedItem();
        String LFIVE = (String) lfive.getSelectedItem();

        Integer LSIXS = null;
        Integer LSEVEN = null;
        Integer LEIGHT = null;
        
        try {
        
        LSIXS = Integer.parseInt(lsixs.getText().trim());
        LSEVEN = Integer.parseInt(lseven.getText().trim());
        LEIGHT = Integer.parseInt(leight.getText().trim());

        } catch (NullPointerException | NumberFormatException e) {
            
        }
        
        BigDecimal LNINE = null;
        BigDecimal LTEN = null;
        BigDecimal LELEVEN = null;
        BigDecimal LTWELVE = null;
        BigDecimal LTHIRTEEN = null;
         
        try {
          
            LNINE = new BigDecimal(lnine.getText());
            LTEN = new BigDecimal(lten.getText());
            LELEVEN = new BigDecimal(leleven.getText());
            LTWELVE = new BigDecimal(ltwelve.getText());
            LTHIRTEEN = new BigDecimal(lthirteen.getText());
        } catch (NumberFormatException | NullPointerException e) {

        }
 

        //Validation to check if controls are empty or not
        if( LONE.isEmpty() || LTWO.isEmpty() || LTHREE.isEmpty() || LFOUR.equals("SELECT") || LFIVE.equals("SELECT") ||
                lsixs.getText().isEmpty() || lnine.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Complete all fields!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);

        } try {
                
                Connection conn = myConnection.getConnect(); 
                
                //Check CONTACT already exists
                String checkName = "SELECT l_id FROM tbl_labour_info WHERE l_id = '" + LONE + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                if(rs.next() == true) {// If LABOUR name has already been taken
                    JOptionPane.showMessageDialog(null, "Labour ID " + LONE + " already exist in Database!", "ERROR, USER ALREADY EXIST", JOptionPane.ERROR_MESSAGE);
                }

                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_labour_info(l_id, l_name, l_surname, l_contract, l_position, l_normal_hr, l_total_overtime, l_total_hr, l_hourly_rate, l_less_uif, l_less_paye, l_less_deduc, l_total_salary)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                     psm = conn.prepareStatement(saveQuery);

                       try{

                        // Accept Null excption from string to Integer
                     if ( lsixs.getText().isEmpty() ) {
                        psm.setNull(6, Types.INTEGER);
                      } else {
                    psm.setInt(6, Integer.parseInt(lsixs.getText()));
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
                     
                    try{

                        // Accept Null excption from string to Integer
                     if ( lseven.getText().isEmpty() ) {
                        psm.setNull(7, Types.INTEGER);
                      } else {
                    psm.setInt(7, Integer.parseInt(lseven.getText()));
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
                    
                        try{

                        // Accept Null excption from string to Integer
                     if ( leight.getText().isEmpty() ) {
                        psm.setNull(8, Types.INTEGER);
                      } else {
                    psm.setInt(8, Integer.parseInt(leight.getText()));
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
                    
                      try{

                        // Accept Null excption from string to Integer
                     if ( lnine.getText().isEmpty() ) {
                        psm.setNull(9, Types.DECIMAL);
                      } else {
                    psm.setBigDecimal(9, LNINE);
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
                      
                    try{

                        // Accept Null excption from string to Integer
                     if ( lten.getText().isEmpty() ) {
                        psm.setNull(10, Types.DECIMAL);
                      } else {
                    psm.setBigDecimal(10, LTEN);
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
                        
                     try{

                        // Accept Null excption from string to Integer
                     if ( leleven.getText().isEmpty() ) {
                        psm.setNull(11, Types.DECIMAL);
                      } else {
                    psm.setBigDecimal(11, LELEVEN);
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
                     
                      try{

                        // Accept Null excption from string to Integer
                     if ( ltwelve.getText().isEmpty() ) {
                        psm.setNull(12, Types.DECIMAL);
                      } else {
                    psm.setBigDecimal(12,LTWELVE);
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
                      
                   try{

                        // Accept Null excption from string to Integer
                     if ( lthirteen.getText().isEmpty() ) {
                        psm.setNull(13, Types.DECIMAL);
                      } else {
                    psm.setBigDecimal(13, LTHIRTEEN);
                      }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }

                    try {
                        psm.setString(1, LONE);
                        psm.setString(2, LTWO);
                        psm.setString(3, LTHREE);
                        psm.setString(4, LFOUR);
                        psm.setString(5, LFIVE);


                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Labourer: " + LONE + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                        this.dispose();
                        new ClassFinancialEmp().setVisible(true);
                        
                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new Sale / Income to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                
            } catch (SQLException | HeadlessException e) {
                System.err.print("System Error: " + e);
             //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
  
    }//GEN-LAST:event_buttonSaveLActionPerformed

    private void buttonUpdateLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateLActionPerformed
        
        Connection conn = myConnection.getConnect();
        
        String LONE = lone.getText().trim();
        String LTWO = ltwo.getText().trim();
        String LTHREE = lthree.getText().trim();
        String LFOUR = (String) lfour.getSelectedItem();
        String LFIVE = (String) lfive.getSelectedItem();

        Integer LSIXS = null;
        Integer LSEVEN = null;
        Integer LEIGHT = null;
        
        try {
        
        LSIXS = Integer.parseInt(lsixs.getText().trim());
        LSEVEN = Integer.parseInt(lseven.getText().trim());
        LEIGHT = Integer.parseInt(leight.getText().trim());

        } catch (NullPointerException | NumberFormatException e) {
            
        }
        
        BigDecimal LNINE = null;
        BigDecimal LTEN = null;
        BigDecimal LELEVEN = null;
        BigDecimal LTWELVE = null;
        BigDecimal LTHIRTEEN = null;
         
        try {
          
            LNINE = new BigDecimal(lnine.getText());
            LTEN = new BigDecimal(lten.getText());
            LELEVEN = new BigDecimal(leleven.getText());
            LTWELVE = new BigDecimal(ltwelve.getText());
            LTHIRTEEN = new BigDecimal(lthirteen.getText());
        } catch (NumberFormatException | NullPointerException e) {

        }        
       
     
         if(LONE.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please enter Labourer ID to update!", "AGRI8 ASSIST: EMPLOYEE ID!", JOptionPane.ERROR_MESSAGE);
            lone.requestFocus();
         } else if (LTWO.isEmpty() || LTHREE.isEmpty() ||  LFOUR.isEmpty() || LFIVE.isEmpty() ||
               lsixs == null || lnine == null || leleven == null || ltwelve == null) {
            
            JOptionPane.showMessageDialog(null, "Please complete all fields!", "AGRI8 ASSIST: FIELDS NOT COMPLETED!", JOptionPane.ERROR_MESSAGE);
        }else {
   
            try {

                String query = "UPDATE tbl_labour_info SET " +
                "l_id= '" + LONE + "', l_name = '" + LTWO + "', l_surname = '" + LTHREE + "', l_contract= '" + LFOUR + "', l_position = '" 
                        + LFIVE + "', l_normal_hr = '" + LSIXS + "', l_total_overtime = '" + LSEVEN + "', l_total_hr= '" + LEIGHT + "', l_hourly_rate = '" + LNINE + "', l_less_uif = '" + LTEN + "', l_less_paye= '" 
                        + LELEVEN + "', l_less_deduc = '" + LTWELVE + "', l_total_salary = '" + LTHIRTEEN + "'" + " WHERE l_id= '" + LONE + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
            
              
                int i = statement.executeUpdate();
                
                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "" + LONE + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassFinancialEmp().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.print("System or Database error: " + e);
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
       
            }
            
         }
    }//GEN-LAST:event_buttonUpdateLActionPerformed

    private void buttonDeleteLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteLActionPerformed
       
         Connection conn = myConnection.getConnect();
          
        if(lone.equals("")) {
            
              JOptionPane.showMessageDialog(null, " Please select Row in the table to Delete!", "NO ROW SELECTED!", JOptionPane.ERROR_MESSAGE);
        
    
        } else {
        
        
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelE = (DefaultTableModel) tableLabour.getModel();
            
            if(tableLabour.getSelectedRowCount()==1) {
            
            int row = tableLabour.getSelectedRow();
            String cell = tableLabour.getModel().getValueAt(row, 0).toString();
            tblModelE.removeRow((int) row);
            String sql = "DELETE FROM tbl_labour_info WHERE l_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                    
            } else {
                
                if(tableLabour.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.print("Calculation error " + e);
                   //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
       }
    }//GEN-LAST:event_buttonDeleteLActionPerformed

    private void buttonClearLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearLActionPerformed
      
        
                        lone.setText("");
                        ltwo.setText("");
                        lthree.setText("");
                        lfour.setSelectedIndex(-1);
                        lfive.setSelectedIndex(-1);
                        lsixs.setText("0");
                        lseven.setText("0");
                        leight.setText("");
                        lnine.setText("0");
                        lten.setText("");
                        leleven.setText("0");
                        ltwelve.setText("0");
                        lthirteen.setText("");
        
    }//GEN-LAST:event_buttonClearLActionPerformed

    private void buttonClearEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearEActionPerformed
        
           eone.setText("");
           etwo.setText("");
           ethree.setText("");
           efour.setDate(null);
           efive.setText("");
           esixs.setText("");
           eseven.setText("");
           eeight.setSelectedIndex(-1);
           enine.setDate(null);
           eten.setSelectedIndex(-1);
           eeleven.setText("");
           etwelve.setText("");
    }//GEN-LAST:event_buttonClearEActionPerformed

    private void buttonDeleteEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteEActionPerformed
      
          Connection conn = myConnection.getConnect();
          
        if(eone.equals("")) {
            
              JOptionPane.showMessageDialog(null, " Please select Row in the table to Delete!", "NO ROW SELECTED!", JOptionPane.ERROR_MESSAGE);
        
    
        } else {
        
        
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelE = (DefaultTableModel) tableEmp.getModel();
            
            if(tableEmp.getSelectedRowCount()==1) {
            
            int row = tableEmp.getSelectedRow();
            String cell = tableEmp.getModel().getValueAt(row, 0).toString();
            tblModelE.removeRow((int) row);
            String sql = "DELETE FROM tbl_emp_reg WHERE e_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                    
            } else {
                
                if(tableEmp.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.print("Calculation error " + e);
                        //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
       }
    }//GEN-LAST:event_buttonDeleteEActionPerformed

    private void buttonUpdateEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateEActionPerformed
      
        Connection conn = myConnection.getConnect();
        
        String EMPID =  eone.getText().trim(); 
        String ETWO =  etwo.getText().trim();          
        String ETHREE =  ethree.getText().trim();            
        //Date EFOUR =  (Date) foure.getDate();         
        String EFIVE = efive.getText().trim();        
        String ESIXS = esixs.getText().trim();  
        String ESEVEN =  eseven.getText().trim();         
        String EEIGHT = (String) eeight.getSelectedItem();         
        //Date ENINE = (Date) ninee.getDate();        
        String ETEN = (String) eten.getSelectedItem();
        String EELEVEN = eeleven.getText().trim();         
        String ETWELVE = etwelve.getText().trim();        
       
     
         if(EMPID.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please search Employee ID to update!", "AGRI8 ASSIST: EMPLOYEE ID!", JOptionPane.ERROR_MESSAGE);
            eone.requestFocus();
         } else if (ETWO.isEmpty() || ETHREE.isEmpty() ||  EFIVE.isEmpty() || ESIXS.isEmpty() ||
                ESEVEN.isEmpty() || EEIGHT.equals("SELECT") || ETEN.equals("SELECT") || EELEVEN.isEmpty() || ETWELVE.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Please complete all fields!", "AGRI8 ASSIST: FIELDS NOT COMPLETED!", JOptionPane.ERROR_MESSAGE);
        }else {
   
            try {

                String query = "UPDATE tbl_emp_reg SET " +
                "e_id= '" + EMPID + "', e_name = '" + ETWO + "', e_surename = '" + ETHREE + "', e_dob= ?, e_idnr= '" + EFIVE + "', e_phone = '" 
                        + ESIXS + "', e_email = '" + ESEVEN + "', e_gender = '" + EEIGHT + "', e_term =?, e_position = '" + ETEN + "', e_hourly = '" + EELEVEN + "', e_salary = '" + ETWELVE + "'" + " WHERE e_id= '" + EMPID + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
                
                try{
                      // Accept Null excption from string to Integer
                     if ( efour.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(efour.getDate());
                          
                            statement.setString(1, Date1);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select 'DATE-OF-BIRTH'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          statement.setNull(1, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
               
                 
                          try{
                      // Accept Null excption from string to Integer
                     if ( enine.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(enine.getDate());
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

    private void buttonSaveEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveEActionPerformed
        
         // Save new Employee to database
       
         String ONE = eone.getText().trim();
         String TWO = etwo.getText().trim();
         String THREE = ethree.getText().trim();
         //java.util.Date FOUR =  efour.getDate();
          BigDecimal FIVE = null;
          BigDecimal ELEVEN = null;
          BigDecimal TWELVE = null;
           
         try {
             FIVE = BigDecimal.valueOf(Long.parseLong(efive.getText().trim()));
             ELEVEN = new BigDecimal(eeleven.getText());
             TWELVE = new BigDecimal(etwelve.getText());
         } catch (NumberFormatException e) {
             
         }
         
         
         String SIXS = esixs.getText().trim();
         String SEVEN = eseven.getText().trim();
         String EIGHT = (String) eeight.getSelectedItem();        
         //java.util.Date NINE =  enine.getDate();
         String TEN = (String) eten.getSelectedItem();
    
        //Validation to check if controls are empty or not
        if(ONE.isEmpty() || TWO.isEmpty() || THREE.isEmpty() || efive.getText().isEmpty() || SIXS.isEmpty() || SEVEN.isEmpty() || EIGHT.equals("SELECT") ||
            TEN.equals("SELECT") || eeleven.getText().isEmpty() || etwelve.getText().isEmpty()) {
        
           JOptionPane.showMessageDialog(null, "Please Complete all fields!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
         
        }else {
            
            try {
                
                Connection conn = myConnection.getConnect();
                
                //Check if EMPLOYEE ID already exists
                String checkName = "SELECT e_id FROM tbl_emp_reg WHERE e_id = '" + ONE + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                // If Employee ID has already been taken
                if(rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Employee ID: " + ONE + " already exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_emp_reg(e_id, e_name, e_surename, e_dob, e_idnr, e_phone, e_email, e_gender, e_term, e_position, e_hourly, e_salary)" +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    psm = conn.prepareStatement(saveQuery);      
                    
                      try{
                          
                      // Accept Null excption from string to Integer
                     if ( efour.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(efour.getDate());
                            psm.setString(4, Date1);
                         
                        } else {
                         JOptionPane.showMessageDialog(null, "Please enter 'DATE-OF-BIRTH'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          psm.setNull(4, java.sql.Types.DATE);   
                        }
                     
                      } catch (NullPointerException e) {
                           
                       }
                      
                           try{
                      // Accept Null excption from string to Integer
                     if ( enine.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(enine.getDate());
                            psm.setString(9, Date2);
                      
                        } else {
                         JOptionPane.showMessageDialog(null, "Please enter 'EMPLOYMENT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                         psm.setNull(4, java.sql.Types.DATE); 
                        }
                     
                      } catch (NullPointerException e) {
                           
                       }

                    psm.setString(1, ONE);                
                    psm.setString(2, TWO);
                    psm.setString(3, THREE);
                    //psm.setString(4, date1);
                    psm.setBigDecimal(5, BigDecimal.valueOf(Long.parseLong(efive.getText().trim())));
                    psm.setString(6, SIXS);
                    psm.setString(7, SEVEN);
                    psm.setString(8, EIGHT);
                    //psm.setString(9, date2);
                    psm.setString(10, TEN);
                    psm.setBigDecimal(11, ELEVEN);
                    psm.setBigDecimal(12, TWELVE);
                               
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Employee " + ONE + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                        this.dispose();
                        new ClassFinancialEmp().setVisible(true);
                        
                        conn.close();
                       
                    } else {
                           JOptionPane.showMessageDialog(null, "Failed to add new Employee to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
  
            } catch (SQLException | HeadlessException | NullPointerException e) {
                     System.err.print("Calculation error " + e);
                  //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);  
            }
        }
    }//GEN-LAST:event_buttonSaveEActionPerformed

    private void cthreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cthreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cthreeActionPerformed

    private void newVatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newVatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newVatActionPerformed

    private void btnChangeVatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeVatActionPerformed

        if(btnChangeVat.isSelected()){
            newVat.setEnabled(true);
        } else {
            newVat.setEnabled(false);
        }
    }//GEN-LAST:event_btnChangeVatActionPerformed

    private void cunitpriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cunitpriceKeyReleased
       
    }//GEN-LAST:event_cunitpriceKeyReleased

    private void cqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cqtyKeyReleased
       try {

            if(radioNoVat.isSelected()) {

                double vat = 0;
                double unitprice = Double.parseDouble(cunitprice.getText());
                int qty = Integer.parseInt(cqty.getText());
                
                double Subtotal = (qty * unitprice);
                csubtotal.setText(Double.toString(Subtotal));
                
                double subTotal = Double.parseDouble(csubtotal.getText());
                double Vat = (subTotal * vat) / 100;
                cvat.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                ctotal.setText(Double.toString(Total));

            } else {

                double vat = Double.parseDouble(newVat.getText());
                double unitprice = Double.parseDouble(cunitprice.getText());
                int qty = Integer.parseInt(cqty.getText());
                
                double Subtotal = (qty * unitprice);
                csubtotal.setText(Double.toString(Subtotal));
                
                double subTotal = Double.parseDouble(csubtotal.getText());
                double Vat = (subTotal * vat) / 100;
                cvat.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                ctotal.setText(Double.toString(Total));

            }
        } catch (NullPointerException | NumberFormatException e) {
            System.err.print("Calculation error " + e);
        }
    }//GEN-LAST:event_cqtyKeyReleased

    private void buttonAddSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSaleActionPerformed
        // Save new SALE to database

        String ONE = cone.getText().trim();
        String THREE = cthree.getText().trim();
        String FOUR = (String) cfour.getSelectedItem();

        Integer QTY = null;

        try {
        
        QTY = Integer.parseInt(cqty.getText().trim());

        } catch (NullPointerException | NumberFormatException e) {
            
        }
        BigDecimal UNITPRICE = null;
        BigDecimal SUBTOTAL = null;
        BigDecimal VAT = null;
        BigDecimal TOTAL = null;

        try {
          
            UNITPRICE = new BigDecimal(cunitprice.getText());
            SUBTOTAL = new BigDecimal(csubtotal.getText());
            VAT = new BigDecimal(cvat.getText());
            TOTAL = new BigDecimal(ctotal.getText());
        } catch (NumberFormatException | NullPointerException e) {
             System.err.print("Calculation error " + e);
        }
 

        //Validation to check if controls are empty or not
        if( THREE.isEmpty() || FOUR.equals("SELECT") || cunitprice.getText().isEmpty() || cqty.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Complete all fields!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);

        }else {

            try {

                Connection conn = myConnection.getConnect();

            
                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_sales_add(s_type, s_date, s_name, s_category, s_unitprice, s_qty, s_subtotal, s_vat, s_total)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement psm = conn.prepareStatement(saveQuery);

                    try{

                        // Accept Null excption from string to Integer
                        if ( ctwoDate.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(ctwoDate.getDate());
                            psm.setString(2, Date1);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(2, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {
                                         System.err.print("Calculation error " + e);
                    }

                    try {
                        psm.setString(1, ONE);
                        psm.setString(3, THREE);
                        psm.setString(4, FOUR);
                        psm.setBigDecimal(5, UNITPRICE);
                        psm.setInt(6, QTY);
                        psm.setBigDecimal(7, SUBTOTAL);
                        psm.setBigDecimal(8, VAT);
                        psm.setBigDecimal(9, TOTAL);
                  
                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Sale / Income" + ONE + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                  
                        cthree.setText("");
                        cfour.setSelectedIndex(-1);
                        csubtotal.setText("");
                        cqty.setText("");
                        cunitprice.setText("");
                        cvat.setText("");
                        ctotal.setText("");
                        ctwoDate.setDate(null);

                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new Sale / Income to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                

            } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.print("Calculation error " + e);
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonAddSaleActionPerformed

    private void cthree1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cthree1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cthree1ActionPerformed

    private void cunitprice1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cunitprice1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cunitprice1KeyReleased

    private void cqty1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cqty1KeyReleased
       
         try {

            if(radioNoVat1.isSelected()) {

                double vat = 0;
                double unitprice = Double.parseDouble(cunitprice1.getText());
                int qty = Integer.parseInt(cqty1.getText());
                
                double Subtotal = (qty * unitprice);
                csubtotal1.setText(Double.toString(Subtotal));
                
                double subTotal = Double.parseDouble(csubtotal1.getText());
                double Vat = (subTotal * vat) / 100;
                cvat1.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                ctotal1.setText(Double.toString(Total));

            } else {

                double vat = Double.parseDouble(newVat1.getText());
                double unitprice = Double.parseDouble(cunitprice1.getText());
                int qty = Integer.parseInt(cqty1.getText());
                
                double Subtotal = (qty * unitprice);
                csubtotal1.setText(Double.toString(Subtotal));
                
                double subTotal = Double.parseDouble(csubtotal1.getText());
                double Vat = (subTotal * vat) / 100;
                cvat1.setText(Double.toString(Vat));

                double Total = (subTotal + Vat);
                ctotal1.setText(Double.toString(Total));

            }
        } catch (NullPointerException | NumberFormatException e) {
            System.err.print("Calculation error " + e);
        }
    }//GEN-LAST:event_cqty1KeyReleased

    private void buttonAddSale1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSale1ActionPerformed
        
         // Save new Expenses to database

        String ONE1 = cone1.getText().trim();
        String THREE1 = cthree1.getText().trim();
        String FOUR1 = (String) cfour1.getSelectedItem();

        Integer QTY1 = null;

        try {
        
        QTY1 = Integer.parseInt(cqty1.getText().trim());

        } catch (NullPointerException | NumberFormatException e) {
            
        }
        BigDecimal UNITPRICE1 = null;
        BigDecimal SUBTOTAL1 = null;
        BigDecimal VAT1 = null;
        BigDecimal TOTAL1 = null;

        try {
          
            UNITPRICE1 = new BigDecimal(cunitprice1.getText());
            SUBTOTAL1 = new BigDecimal(csubtotal1.getText());
            VAT1 = new BigDecimal(cvat1.getText());
            TOTAL1 = new BigDecimal(ctotal1.getText());
        } catch (NumberFormatException | NullPointerException e) {

        }
 

        //Validation to check if controls are empty or not
        if( THREE1.isEmpty() || FOUR1.equals("SELECT") || cunitprice1.getText().isEmpty() || cqty1.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Complete all fields!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);

        }else {

            try {

                Connection conn = myConnection.getConnect();

            
                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_expense_add(e_type, e_date, e_name, e_category, e_unitprice, e_qty, e_subtotal, e_vat, e_total)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement psm = conn.prepareStatement(saveQuery);

                    try{

                        // Accept Null excption from string to Integer
                        if ( ctwoDate1.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(ctwoDate1.getDate());
                            psm.setString(2, Date1);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'DATE BOUGHT'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(2, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }

                    try {
                        psm.setString(1, ONE1);
                        psm.setString(3, THREE1);
                        psm.setString(4, FOUR1);
                        psm.setBigDecimal(5, UNITPRICE1);
                        psm.setInt(6, QTY1);
                        psm.setBigDecimal(7, SUBTOTAL1);
                        psm.setBigDecimal(8, VAT1);
                        psm.setBigDecimal(9, TOTAL1);
                  
                    } catch (NullPointerException | NumberFormatException e) {

                    }

                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Expense " + ONE1 + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

               
                        cthree1.setText("");
                        cfour1.setSelectedIndex(-1);
                        csubtotal1.setText("");
                        cqty1.setText("");
                        cunitprice1.setText("");
                        cvat1.setText("");
                        ctotal1.setText("");
                        ctwoDate1.setDate(null);

                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new EXPENSE to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                

            } catch (SQLException | HeadlessException e) {
                 System.err.print("Calculation error " + e);
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
    }//GEN-LAST:event_buttonAddSale1ActionPerformed

    private void radioNoVat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoVat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNoVat1ActionPerformed

    private void btnChangeVat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeVat1ActionPerformed
        
        if(btnChangeVat1.isSelected()){
            newVat1.setEnabled(true);
        } else {
            newVat1.setEnabled(false);
        }

    }//GEN-LAST:event_btnChangeVat1ActionPerformed

    private void newVat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newVat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newVat1ActionPerformed

    private void cfour1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfour1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cfour1ActionPerformed

    private void filterCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterCategoryItemStateChanged
      
            // Filter by Category
        
        String query = (String) filterCategory.getSelectedItem().toString();
        filter(query);
        

    }//GEN-LAST:event_filterCategoryItemStateChanged

    private void filterTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterTypeItemStateChanged
        
            // Filter by Type
        
        String query = (String) filterType.getSelectedItem().toString();
        filter(query);
        
        
    }//GEN-LAST:event_filterTypeItemStateChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        this.dispose();
        new ClassFinancialEmp().setVisible(true);
        filterType.setSelectedItem("SELECT");
       filterCategory.setSelectedItem("SELECT");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void buttonDeleteSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteSEActionPerformed
         
        Connection conn = myConnection.getConnect(); 
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelC = (DefaultTableModel) tableSE.getModel();
            
            if(tableSE.getSelectedRowCount()==1) {
            
            int row = tableSE.getSelectedRow();
            String cell = tableSE.getModel().getValueAt(row, 0).toString();
            tblModelC.removeRow((int) row);
            String sql = "DELETE FROM tbl_sales_add WHERE s_type =?";
            String sql1 = "DELETE FROM tbl_expense_add WHERE e_type = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            PreparedStatement psm1 = conn.prepareStatement(sql1);
            psm1.setString(1,cell);
            
            psm1.execute();
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                    
            } else {
                
                if(tableSE.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.print("Calculation error " + e);
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        
       }
        
       
    }//GEN-LAST:event_buttonDeleteSEActionPerformed

    private void esixsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_esixsKeyPressed
        
          // Set JTextfield to accept only Integers of a certain Length
        // for contact number
        
        String number = esixs.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                esixs.setEditable(true);
            } else {
                 esixs.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                esixs.setEditable(true);
            } else {
                esixs.setEditable(false);
            }
        }
        } catch(NullPointerException e){
            
        }
    }//GEN-LAST:event_esixsKeyPressed

    private void efiveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_efiveKeyPressed
        
         // Set JTextfield to accept only Integers of a certain Length
         // ID Number length and integers
        
        String number = efive.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<13) {
                efive.setEditable(true);
            } else {
                 efive.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                efive.setEditable(true);
            } else {
                efive.setEditable(false);
            }
        }
    }//GEN-LAST:event_efiveKeyPressed

    private void buttonSearchEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchEActionPerformed
        
        
             Connection conn = myConnection.getConnect();
               
                String idEmp = eone.getText();
                eone.requestFocus();
                
                if(idEmp.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please select ID in Emp ID Field to search!");
                
                } else {
                    
                try {

                    //Establish / Open Connection
                    
                    String sql = "SELECT * FROM tbl_emp_reg WHERE e_id = ?";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, idEmp);
             //Executing Query
                    ResultSet rs = sta.executeQuery();
                 
                    if (rs.next()) {
                        eone.setEnabled(false);
                        eone.setText(rs.getString("e_id"));                       
                        etwo.setText(rs.getString("e_name"));                         
                        ethree.setText(rs.getString("e_surename"));                     
                        efour.setDate(rs.getDate("e_dob"));                           
                        efive.setText(rs.getString("e_idnr"));                  
                        esixs.setText(rs.getString("e_phone"));                
                        eseven.setText(rs.getString("e_email"));    
                        
                        eeight.setSelectedItem(rs.getString("e_gender"));                      
                        enine.setDate(rs.getDate("e_term"));  
                        eten.setSelectedItem(rs.getString("e_position"));
                        eeleven.setText(rs.getString("e_hourly"));   
                        etwelve.setText(rs.getString("e_salary"));   

                    }
                        } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
               
    }//GEN-LAST:event_buttonSearchEActionPerformed

    private void buttonSearchCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchCActionPerformed
      
        Connection conn = myConnection.getConnect();
            
                String idC = one.getText();
                one.setBackground(Color.LIGHT_GRAY);
                one.requestFocus();
                
             if(idC.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please enter ID in Contact ID Field to search!", "ENTER ID", JOptionPane.ERROR_MESSAGE);
                
                } else {

            try {

                //Establish / Open Connection

                String sql = "SELECT * FROM tbl_company_reg WHERE c_id = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, idC);
                
                //Executing Query
                ResultSet rs = statement.executeQuery();
                
                if (rs.next()) {

                    one.setText(rs.getString("c_id"));                         
                    two.setText(rs.getString("c_name"));                           
                    three.setText(rs.getString("c_number"));                        
                    four.setText(rs.getString("c_comp_name"));                     
                    five.setText(rs.getString("c_vat"));
                    sixs.setText(rs.getString("c_reg")); 
                    emailc.setText(rs.getString("c_email"));
                    seven.setSelectedItem(rs.getString("c_category"));
                    eight.setText(rs.getString("c_street"));             
                    nine.setText(rs.getString("c_city"));
                    ten.setText(rs.getString("c_area"));
                    
               
                    one.requestFocus();
                    
                } else {
                      JOptionPane.showMessageDialog(null, "ID not found, please register user!", "ID NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
                conn.close();

            } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }
    }//GEN-LAST:event_buttonSearchCActionPerformed

    private void esevenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_esevenKeyPressed
       
          int email = eseven.getCaretPosition();
                eseven.setText(eseven.getText().toLowerCase());
                eseven.setCaretPosition(email);
    }//GEN-LAST:event_esevenKeyPressed

    private void buttonSearchLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchLActionPerformed
      
        
          Connection conn = myConnection.getConnect();
               
                String idl = lone.getText();
                lone.requestFocus();
                
                if(idl.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please enter ID in Labour ID Field to search!");
                
                } else {
                    
                try {

                    //Establish / Open Connection
                    
                    String sql = "SELECT * FROM tbl_labour_info WHERE l_id = ?";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, idl);
             //Executing Query
                    ResultSet rs = sta.executeQuery();
                 
                    if (rs.next()) {
                        lone.setEnabled(false);
                        lone.setText(rs.getString("l_id"));                       
                        ltwo.setText(rs.getString("l_name"));                         
                        lthree.setText(rs.getString("l_surname"));                     
                        lfour.setSelectedItem(rs.getString("l_contract"));                           
                        lfive.setSelectedItem(rs.getString("l_position"));                  
                        lsixs.setText(rs.getString("l_normal_hr"));                
                        lseven.setText(rs.getString("l_total_overtime"));    
                        
                        leight.setText(rs.getString("l_total_hr"));                      
                        lnine.setText(rs.getString("l_hourly_rate"));  
                        lten.setText(rs.getString("l_less_uif"));
                        leleven.setText(rs.getString("l_less_paye"));   
                        ltwelve.setText(rs.getString("l_less_deduc"));
                        lthirteen.setText(rs.getString("l_total_salary"));  
                        
                           lsixs.setText("");
                           lseven.setText("0");
                           leight.setText("");
                           lnine.setText("");
                           lten.setText("0.00");
                           leleven.setText("0.00"); 
                           ltwelve.setText("0.00");
                           lthirteen.setText("");

                    }
                        } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
        
    }//GEN-LAST:event_buttonSearchLActionPerformed

    private void lsixsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lsixsKeyReleased
     
       try {
           
       
        int normal = Integer.parseInt(lsixs.getText().trim());
        int overtime = Integer.parseInt(lseven.getText().trim());
        int totalh = normal + overtime;
        leight.setText(Integer.toString(totalh));
        
        } catch (NullPointerException | NumberFormatException e) {

        }

    }//GEN-LAST:event_lsixsKeyReleased

    private void lsevenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lsevenKeyReleased
        
        
        try {

        int normal = Integer.parseInt(lsixs.getText().trim());
        int overtime = Integer.parseInt(lseven.getText().trim());
        int totalh = normal + overtime;
        leight.setText(Integer.toString(totalh));
        

        } catch (NullPointerException | NumberFormatException e) {

        }

    }//GEN-LAST:event_lsevenKeyReleased

    private void lnineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnineKeyPressed
       
         try {

                double uif = Double.parseDouble(UIF.getText());
                int totalh = Integer.parseInt(leight.getText());
                double rateh = Double.parseDouble(lnine.getText());
                double finaluif = Double.parseDouble(lten.getText().trim());
                double paye = (Double.parseDouble(leleven.getText()));
                double deductions = (Double.parseDouble(ltwelve.getText()));
         
                double salary = (totalh * rateh);
                double tuif = (salary * uif) / 100;
                lten.setText(Double.toString(tuif));
                
                double SALARY =(totalh * rateh - finaluif - paye - deductions);
                lthirteen.setText(Double.toString(SALARY));

        } catch (NullPointerException | NumberFormatException e) {

        }
        
    }//GEN-LAST:event_lnineKeyPressed

    private void lelevenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lelevenKeyReleased
        
         try {

                double uif = Double.parseDouble(UIF.getText());
                int totalh = Integer.parseInt(leight.getText());
                double rateh = Double.parseDouble(lnine.getText());
                double finaluif = Double.parseDouble(lten.getText().trim());
                double paye = (Double.parseDouble(leleven.getText()));
                double deductions = (Double.parseDouble(ltwelve.getText()));
         
                double salary = (totalh * rateh);
                double tuif = (salary * uif) / 100;
                lten.setText(Double.toString(tuif));
                
                double SALARY =(totalh * rateh - finaluif - paye - deductions);
                lthirteen.setText(Double.toString(SALARY));

        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_lelevenKeyReleased

    private void ltwelveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ltwelveKeyReleased
       
         try {

                double uif = Double.parseDouble(UIF.getText());
                int totalh = Integer.parseInt(leight.getText());
                double rateh = Double.parseDouble(lnine.getText());
                double finaluif = Double.parseDouble(lten.getText().trim());
                double paye = (Double.parseDouble(leleven.getText()));
                double deductions = (Double.parseDouble(ltwelve.getText()));
         
                double salary = (totalh * rateh);
                double tuif = (salary * uif) / 100;
                lten.setText(Double.toString(tuif));
                
                double SALARY =(totalh * rateh - finaluif - paye - deductions);
                lthirteen.setText(Double.toString(SALARY));

        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_ltwelveKeyReleased

    private void buttonUIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUIFActionPerformed
       
          if(buttonUIF.isSelected()){
            UIF.setEnabled(true);
        } else {
            UIF.setEnabled(false);
        }
        
    }//GEN-LAST:event_buttonUIFActionPerformed

    private void aKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aKeyReleased
        
        
             try {

                double A = Double.parseDouble(a.getText());
                double B = Double.parseDouble(b.getText());
                double C = Double.parseDouble(c.getText().trim());
                double D = (Double.parseDouble(d.getText()));
                double E = (Double.parseDouble(e.getText()));
                double F = (Double.parseDouble(f.getText()));
         
                double totalg = (A + B + C + D + E + F);
                g.setText(Double.toString(totalg));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }

    }//GEN-LAST:event_aKeyReleased

    private void bKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bKeyReleased
        
          try {

                double A = Double.parseDouble(a.getText());
                double B = Double.parseDouble(b.getText());
                double C = Double.parseDouble(c.getText().trim());
                double D = (Double.parseDouble(d.getText()));
                double E = (Double.parseDouble(e.getText()));
                double F = (Double.parseDouble(f.getText()));
         
                double totalg = (A + B + C + D + E + F);
                g.setText(Double.toString(totalg));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
          
            try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_bKeyReleased

    private void cKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cKeyReleased
        
          try {

                double A = Double.parseDouble(a.getText());
                double B = Double.parseDouble(b.getText());
                double C = Double.parseDouble(c.getText().trim());
                double D = (Double.parseDouble(d.getText()));
                double E = (Double.parseDouble(e.getText()));
                double F = (Double.parseDouble(f.getText()));
         
                double totalg = (A + B + C + D + E + F);
                g.setText(Double.toString(totalg));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
          
            try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_cKeyReleased

    private void dKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dKeyReleased
        
          try {

                double A = Double.parseDouble(a.getText());
                double B = Double.parseDouble(b.getText());
                double C = Double.parseDouble(c.getText().trim());
                double D = (Double.parseDouble(d.getText()));
                double E = (Double.parseDouble(e.getText()));
                double F = (Double.parseDouble(f.getText()));
         
                double totalg = (A + B + C + D + E + F);
                g.setText(Double.toString(totalg));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
          
            try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_dKeyReleased

    private void eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eKeyReleased
        
          try {

                double A = Double.parseDouble(a.getText());
                double B = Double.parseDouble(b.getText());
                double C = Double.parseDouble(c.getText().trim());
                double D = (Double.parseDouble(d.getText()));
                double E = (Double.parseDouble(e.getText()));
                double F = (Double.parseDouble(f.getText()));
         
                double totalg = (A + B + C + D + E + F);
                g.setText(Double.toString(totalg));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
          
            try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_eKeyReleased

    private void fKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fKeyReleased
        
          try {

                double A = Double.parseDouble(a.getText().trim());
                double B = Double.parseDouble(b.getText().trim());
                double C = Double.parseDouble(c.getText().trim());
                double D = (Double.parseDouble(d.getText().trim()));
                double E = (Double.parseDouble(e.getText().trim()));
                double F = (Double.parseDouble(f.getText().trim()));
         
                double totalg = (A + B + C + D + E + F);
                g.setText(Double.toString(totalg));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
          
            try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_fKeyReleased

    private void hKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hKeyReleased
       
          try {

                double H = Double.parseDouble(h.getText().trim());
                double I = Double.parseDouble(i.getText().trim());
                double J = Double.parseDouble(j.getText().trim());
                double K = (Double.parseDouble(k.getText().trim()));
            
         
                double totalh = (H + I + J + K);
                l.setText(Double.toString(totalh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
          
            try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_hKeyReleased

    private void iKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iKeyReleased
        
              try {

                double H = Double.parseDouble(h.getText().trim());
                double I = Double.parseDouble(i.getText().trim());
                double J = Double.parseDouble(j.getText().trim());
                double K = (Double.parseDouble(k.getText().trim()));
            
         
                double totalh = (H + I + J + K);
                l.setText(Double.toString(totalh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
              
                try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_iKeyReleased

    private void jKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jKeyReleased
      
           
                  try {

                double H = Double.parseDouble(h.getText().trim());
                double I = Double.parseDouble(i.getText().trim());
                double J = Double.parseDouble(j.getText().trim());
                double K = (Double.parseDouble(k.getText().trim()));
            
         
                double totalh = (H + I + J + K);
                l.setText(Double.toString(totalh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
                  
           try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }

    }//GEN-LAST:event_jKeyReleased

    private void kKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kKeyReleased
        
               try {

                double H = Double.parseDouble(h.getText().trim());
                double I = Double.parseDouble(i.getText().trim());
                double J = Double.parseDouble(j.getText().trim());
                double K = (Double.parseDouble(k.getText().trim()));
            
         
                double totalh = (H + I + J + K);
                l.setText(Double.toString(totalh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
          try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_kKeyReleased

    private void mKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mKeyReleased
      
           try {

                double M = Double.parseDouble(m.getText());
                double N = Double.parseDouble(n.getText());
                double O = Double.parseDouble(o.getText().trim());
             
                double totalh = (M + N + O);
                p.setText(Double.toString(totalh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
           
          try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_mKeyReleased

    private void nKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nKeyReleased
        
            try {

                double M = Double.parseDouble(m.getText());
                double N = Double.parseDouble(n.getText());
                double O = Double.parseDouble(o.getText().trim());
             
                double totalh = (M + N + O);
                p.setText(Double.toString(totalh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
            
            
          try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_nKeyReleased

    private void oKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oKeyReleased
       
            try {

                double M = Double.parseDouble(m.getText());
                double N = Double.parseDouble(n.getText());
                double O = Double.parseDouble(o.getText().trim());
             
                double totalh = (M + N + O);
                p.setText(Double.toString(totalh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
   
          try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_oKeyReleased

    private void ONE3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ONE3KeyReleased
        
             try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
           try {

                double TG = Double.parseDouble(g.getText().trim());
                double TL = Double.parseDouble(l.getText().trim());
                double TP = Double.parseDouble(p.getText().trim());
        
                double total = (TG + TL + TP);
                ONE3.setText(Double.toString(total));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_ONE3KeyReleased

    private void TWO3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TWO3KeyReleased
        
        
          try {

                double T1 = Double.parseDouble(ONE3.getText().trim());
                double T2 = Double.parseDouble(TWO3.getText().trim());
        
                double totalt = Math.round(T2 - T1);
                THREE3.setText(Double.toString(totalt));
       
        } catch (NullPointerException | NumberFormatException e) {

        }

    }//GEN-LAST:event_TWO3KeyReleased

    private void aaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aaKeyReleased
        
        
          try {

                double AA = Double.parseDouble(aa.getText());
                double BB = Double.parseDouble(bb.getText());
                double CC = Double.parseDouble(cc.getText().trim());
                double DD = (Double.parseDouble(dd.getText()));
                double EE = (Double.parseDouble(ee.getText()));
                double FF = (Double.parseDouble(ff.getText()));
                double GG = (Double.parseDouble(gg.getText()));
         
                double totalhh = (AA + BB + CC + DD + EE + FF + GG);
                hh.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
              
    }//GEN-LAST:event_aaKeyReleased

    private void iiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iiKeyReleased
        
         try {

                double II = Double.parseDouble(ii.getText());
                double JJ = Double.parseDouble(jj.getText());
                double KK = Double.parseDouble(kk.getText().trim());
         
         
                double totalhh = (II + JJ + KK);
                ll.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_iiKeyReleased

    private void jjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jjKeyReleased
        
        try {

                double II = Double.parseDouble(ii.getText());
                double JJ = Double.parseDouble(jj.getText());
                double KK = Double.parseDouble(kk.getText().trim());
         
         
                double totalhh = (II + JJ + KK);
                ll.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_jjKeyReleased

    private void kkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kkKeyReleased
        
        try {

                double II = Double.parseDouble(ii.getText());
                double JJ = Double.parseDouble(jj.getText());
                double KK = Double.parseDouble(kk.getText().trim());
         
         
                double totalhh = (II + JJ + KK);
                ll.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_kkKeyReleased

    private void mmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mmKeyReleased
        
        try {

                double MM = Double.parseDouble(mm.getText().trim());
                double NN = Double.parseDouble(nn.getText().trim());
                double OO = Double.parseDouble(oo.getText().trim());
         
         
                double totalhh = (MM + NN + OO);
                pp.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_mmKeyReleased

    private void nnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nnKeyReleased
        
          try {

                double MM = Double.parseDouble(mm.getText().trim());
                double NN = Double.parseDouble(nn.getText().trim());
                double OO = Double.parseDouble(oo.getText().trim());
         
         
                double totalhh = (MM + NN + OO);
                pp.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_nnKeyReleased

    private void ooKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ooKeyReleased
       
          try {

                double MM = Double.parseDouble(mm.getText().trim());
                double NN = Double.parseDouble(nn.getText().trim());
                double OO = Double.parseDouble(oo.getText().trim());
         
         
                double totalhh = (MM + NN + OO);
                pp.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_ooKeyReleased

    private void ffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ffActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
          // Save new BALANCESHEET to database

        String BSID = bsid.getText().trim();
          
        BigDecimal one3 = null;
        BigDecimal two3 = null;
        BigDecimal three3 = null;
        BigDecimal four3 = null;
 
        BigDecimal A = null;
        BigDecimal B = null;
        BigDecimal C = null;
        BigDecimal D = null;
        BigDecimal E = null;
         
        BigDecimal F = null;
        BigDecimal G = null;
        BigDecimal H = null;
        BigDecimal I = null;
        BigDecimal J = null;
         
        BigDecimal K = null;
        BigDecimal L= null;
        BigDecimal M = null;
        BigDecimal N = null;
        BigDecimal O = null;
        BigDecimal P = null;
         
        BigDecimal AA = null;
        BigDecimal BB = null;
        BigDecimal CC = null;
        BigDecimal DD = null;
        BigDecimal EE = null;
         
        BigDecimal FF = null;
        BigDecimal GG = null;
        BigDecimal HH = null;
        BigDecimal II = null;
        BigDecimal JJ = null;
         
        BigDecimal KK = null;
        BigDecimal LL = null;
        BigDecimal MM = null;
        BigDecimal NN = null;
        BigDecimal OO = null;
        BigDecimal PP = null;
      
        try {
            
            one3 = new BigDecimal(ONE3.getText());
            two3 = new BigDecimal(TWO3.getText());
            three3 = new BigDecimal(THREE3.getText());
            four3 = new BigDecimal(FOUR3.getText());
    
            A = new BigDecimal(a.getText());
            B = new BigDecimal(b.getText());
            C = new BigDecimal(c.getText());
            D = new BigDecimal(d.getText());
            E = new BigDecimal(e.getText());
            
            F = new BigDecimal(f.getText());
            G = new BigDecimal(g.getText());
            H = new BigDecimal(h.getText());
            I = new BigDecimal(i.getText());
            J = new BigDecimal(j.getText());
            
            K = new BigDecimal(k.getText());
            L = new BigDecimal(l.getText());
            M = new BigDecimal(m.getText());
            N = new BigDecimal(n.getText());
            O = new BigDecimal(o.getText());
            P = new BigDecimal(p.getText());
            
            AA = new BigDecimal(aa.getText());
            BB = new BigDecimal(bb.getText());
            CC = new BigDecimal(cc.getText());
            DD = new BigDecimal(dd.getText());
            EE = new BigDecimal(ee.getText());
            
            FF = new BigDecimal(ff.getText());
            GG = new BigDecimal(gg.getText());
            HH = new BigDecimal(hh.getText());
            II = new BigDecimal(ii.getText());
            JJ = new BigDecimal(jj.getText());
            
            KK = new BigDecimal(kk.getText());
            LL = new BigDecimal(ll.getText());
            MM = new BigDecimal(mm.getText());
            NN = new BigDecimal(nn.getText());
            OO = new BigDecimal(oo.getText());
            PP = new BigDecimal(pp.getText());
            
  
        } catch (NumberFormatException | NullPointerException e) {

        }
 

        //Validation to check if controls are empty or not
        if( BSID.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter BALANCESHEET ID!", "AGRI8 ASSIST DIALOG: ENTER ID", JOptionPane.INFORMATION_MESSAGE);

        } else {   
            
        } try {
                
                Connection conn = myConnection.getConnect(); 
                
                //Check CONTACT already exists
                String checkName = "SELECT bsid FROM tbl_bs_report WHERE bsid = '" + BSID + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                if(rs.next() == true) {// If LABOUR name has already been taken
                    JOptionPane.showMessageDialog(null, "Balancesheet ID " + BSID + " already exist in Database!", "ERROR, USER ALREADY EXIST", JOptionPane.ERROR_MESSAGE);
                }

                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_bs_report(bsid, one3, two3, three3, four3, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, ll, mm, nn, oo, pp, datestart, dateend)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                     psm = conn.prepareStatement(saveQuery);

                      try{

                        // Accept Null excption from string to Integer
                        if ( datestart.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(datestart.getDate());
                            psm.setString(38, Date1);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'OPENING DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(38, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException  e) {

                    }
                      
                       try{

                        // Accept Null excption from string to Integer
                        if ( dateend.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(dateend.getDate());
                            psm.setString(39, Date2);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'CLOSING DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(39, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException  e) {

                    }
   
                        
                     try{
                        psm.setString(1, BSID);
                        psm.setBigDecimal(2, one3); 
                        psm.setBigDecimal(3, two3);
                        psm.setBigDecimal(4, three3); 
                        psm.setBigDecimal(5, four3); 
                        
                        psm.setBigDecimal(6, A); 
                        psm.setBigDecimal(7, B);
                        psm.setBigDecimal(8, C); 
                        psm.setBigDecimal(9, D);
                        psm.setBigDecimal(10, E); 
                        psm.setBigDecimal(11, F);
                        psm.setBigDecimal(12, G); 
                        psm.setBigDecimal(13, H);
                        psm.setBigDecimal(14, I); 
                        psm.setBigDecimal(15, J);
                        psm.setBigDecimal(16, K); 
                        psm.setBigDecimal(17, L);
                        psm.setBigDecimal(18, M); 
                        psm.setBigDecimal(19, N);
                        psm.setBigDecimal(20, O); 
                        psm.setBigDecimal(21, P);
                       
                        psm.setBigDecimal(22, AA); 
                        psm.setBigDecimal(23, BB);
                        psm.setBigDecimal(24, CC); 
                        psm.setBigDecimal(25, DD);
                        psm.setBigDecimal(26, EE); 
                        psm.setBigDecimal(27, FF);
                        psm.setBigDecimal(28, GG); 
                        psm.setBigDecimal(29, HH);
                        psm.setBigDecimal(30, II); 
                        psm.setBigDecimal(31, JJ);
                        psm.setBigDecimal(32, KK); 
                        psm.setBigDecimal(33, LL);
                        psm.setBigDecimal(34, MM); 
                        psm.setBigDecimal(35, NN);
                        psm.setBigDecimal(36, OO); 
                        psm.setBigDecimal(37, PP);
                      

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
     
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Balancesheet " + BSID + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                      
                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new BALANCSHEET to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                
            } catch (SQLException | HeadlessException e) {
                System.err.print("System Error: " + e);
              // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void bbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bbKeyReleased
        
           try {

                double AA = Double.parseDouble(aa.getText());
                double BB = Double.parseDouble(bb.getText());
                double CC = Double.parseDouble(cc.getText().trim());
                double DD = (Double.parseDouble(dd.getText()));
                double EE = (Double.parseDouble(ee.getText()));
                double FF = (Double.parseDouble(ff.getText()));
                double GG = (Double.parseDouble(gg.getText()));
         
                double totalhh = (AA + BB + CC + DD + EE + FF + GG);
                hh.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_bbKeyReleased

    private void ccKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ccKeyReleased
       
           try {

                double AA = Double.parseDouble(aa.getText());
                double BB = Double.parseDouble(bb.getText());
                double CC = Double.parseDouble(cc.getText().trim());
                double DD = (Double.parseDouble(dd.getText()));
                double EE = (Double.parseDouble(ee.getText()));
                double FF = (Double.parseDouble(ff.getText()));
                double GG = (Double.parseDouble(gg.getText()));
         
                double totalhh = (AA + BB + CC + DD + EE + FF + GG);
                hh.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_ccKeyReleased

    private void ddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ddKeyReleased
        
           try {

                double AA = Double.parseDouble(aa.getText());
                double BB = Double.parseDouble(bb.getText());
                double CC = Double.parseDouble(cc.getText().trim());
                double DD = (Double.parseDouble(dd.getText()));
                double EE = (Double.parseDouble(ee.getText()));
                double FF = (Double.parseDouble(ff.getText()));
                double GG = (Double.parseDouble(gg.getText()));
         
                double totalhh = (AA + BB + CC + DD + EE + FF + GG);
                hh.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_ddKeyReleased

    private void ggKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ggKeyReleased
        
           try {

                double AA = Double.parseDouble(aa.getText());
                double BB = Double.parseDouble(bb.getText());
                double CC = Double.parseDouble(cc.getText().trim());
                double DD = (Double.parseDouble(dd.getText()));
                double EE = (Double.parseDouble(ee.getText()));
                double FF = (Double.parseDouble(ff.getText()));
                double GG = (Double.parseDouble(gg.getText()));
         
                double totalhh = (AA + BB + CC + DD + EE + FF + GG);
                hh.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_ggKeyReleased

    private void ffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ffKeyReleased
        
           try {

                double AA = Double.parseDouble(aa.getText());
                double BB = Double.parseDouble(bb.getText());
                double CC = Double.parseDouble(cc.getText().trim());
                double DD = (Double.parseDouble(dd.getText()));
                double EE = (Double.parseDouble(ee.getText()));
                double FF = (Double.parseDouble(ff.getText()));
                double GG = (Double.parseDouble(gg.getText()));
         
                double totalhh = (AA + BB + CC + DD + EE + FF + GG);
                hh.setText(Double.toString(totalhh));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
               try {

                double TG = Double.parseDouble(hh.getText().trim());
                double TL = Double.parseDouble(ll.getText().trim());
                double TP = Double.parseDouble(pp.getText().trim());
        
                double ttotal = (TG + TL + TP);
                FOUR3.setText(Double.toString(ttotal));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_ffKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       
        
         Connection conn = myConnection.getConnect();
               
                String BSID = bsid.getText();
                bsid.requestFocus();
                
                if(BSID.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please select ID in Balancesheet ID Field to search!");
                
                } else {
                    
                try {

                    //Establish / Open Connection
                    
                    String sql = "SELECT * FROM tbl_bs_report WHERE bsid = ?";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, BSID);
             //Executing Query
                    ResultSet rs = sta.executeQuery();
                 
                    if (rs.next()) {
                        bsid.setEditable(false);
                        bsid.setText(rs.getString("bsid"));                       
                        ONE3.setText(rs.getString("one3"));                         
                        TWO3.setText(rs.getString("two3"));                     
                        THREE3.setText(rs.getString("three3"));                           
                        FOUR3.setText(rs.getString("four3")); 
                        
                        a.setText(rs.getString("a"));                
                        b.setText(rs.getString("b"));    
                        c.setText(rs.getString("c"));                      
                        d.setText(rs.getString("d"));  
                        e.setText(rs.getString("e"));
                        f.setText(rs.getString("f"));   
                        g.setText(rs.getString("g"));
                        h.setText(rs.getString("h"));  
                        i.setText(rs.getString("i"));                      
                        j.setText(rs.getString("j"));  
                        k.setText(rs.getString("k"));
                        l.setText(rs.getString("l"));   
                        m.setText(rs.getString("m"));
                        n.setText(rs.getString("n"));  
                        o.setText(rs.getString("o"));
                        p.setText(rs.getString("p")); 
                        
                        aa.setText(rs.getString("aa"));                
                        bb.setText(rs.getString("bb"));    
                        cc.setText(rs.getString("cc"));                      
                        dd.setText(rs.getString("dd"));  
                        ee.setText(rs.getString("ee"));
                        ff.setText(rs.getString("ff"));   
                        gg.setText(rs.getString("gg"));
                        hh.setText(rs.getString("hh"));  
                        ii.setText(rs.getString("ii"));                      
                        jj.setText(rs.getString("jj"));  
                        kk.setText(rs.getString("kk"));
                        ll.setText(rs.getString("ll"));   
                        mm.setText(rs.getString("mm"));
                        nn.setText(rs.getString("nn"));  
                        oo.setText(rs.getString("oo"));
                        pp.setText(rs.getString("pp"));
                        
                        datestart.setDate(rs.getDate("datestart"));
                        dateend.setDate(rs.getDate("dateend"));
              

                    }
                        } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
    
        Connection conn = myConnection.getConnect();
        
          String BSID = bsid.getText().trim();
          
        BigDecimal one3 = null;
        BigDecimal two3 = null;
        BigDecimal three3 = null;
        BigDecimal four3 = null;
 
        BigDecimal A = null;
        BigDecimal B = null;
        BigDecimal C = null;
        BigDecimal D = null;
        BigDecimal E = null;
         
        BigDecimal F = null;
        BigDecimal G = null;
        BigDecimal H = null;
        BigDecimal I = null;
        BigDecimal J = null;
         
        BigDecimal K = null;
        BigDecimal L= null;
        BigDecimal M = null;
        BigDecimal N = null;
        BigDecimal O = null;
        BigDecimal P = null;
         
        BigDecimal AA = null;
        BigDecimal BB = null;
        BigDecimal CC = null;
        BigDecimal DD = null;
        BigDecimal EE = null;
         
        BigDecimal FF = null;
        BigDecimal GG = null;
        BigDecimal HH = null;
        BigDecimal II = null;
        BigDecimal JJ = null;
         
        BigDecimal KK = null;
        BigDecimal LL = null;
        BigDecimal MM = null;
        BigDecimal NN = null;
        BigDecimal OO = null;
        BigDecimal PP = null;
      
        try {
            
            one3 = new BigDecimal(ONE3.getText());
            two3 = new BigDecimal(TWO3.getText());
            three3 = new BigDecimal(THREE3.getText());
            four3 = new BigDecimal(FOUR3.getText());
    
            A = new BigDecimal(a.getText());
            B = new BigDecimal(b.getText());
            C = new BigDecimal(c.getText());
            D = new BigDecimal(d.getText());
            E = new BigDecimal(e.getText());
            
            F = new BigDecimal(f.getText());
            G = new BigDecimal(g.getText());
            H = new BigDecimal(h.getText());
            I = new BigDecimal(i.getText());
            J = new BigDecimal(j.getText());
            
            K = new BigDecimal(k.getText());
            L = new BigDecimal(l.getText());
            M = new BigDecimal(m.getText());
            N = new BigDecimal(n.getText());
            O = new BigDecimal(o.getText());
            P = new BigDecimal(p.getText());
            
            AA = new BigDecimal(aa.getText());
            BB = new BigDecimal(bb.getText());
            CC = new BigDecimal(cc.getText());
            DD = new BigDecimal(dd.getText());
            EE = new BigDecimal(ee.getText());
            
            FF = new BigDecimal(ff.getText());
            GG = new BigDecimal(gg.getText());
            HH = new BigDecimal(hh.getText());
            II = new BigDecimal(ii.getText());
            JJ = new BigDecimal(jj.getText());
            
            KK = new BigDecimal(kk.getText());
            LL = new BigDecimal(ll.getText());
            MM = new BigDecimal(mm.getText());
            NN = new BigDecimal(nn.getText());
            OO = new BigDecimal(oo.getText());
            PP = new BigDecimal(pp.getText());
            
  
        } catch (NumberFormatException | NullPointerException e) {

        }     
       
     
         if(BSID.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please search Balancesheet ID to update!", "AGRI8 ASSIST: BALANCSHEET ID REQUIRED!", JOptionPane.ERROR_MESSAGE);
            bsid.requestFocus();
         } else if (datestart == null ) {
              JOptionPane.showMessageDialog(null, "Please enter 'START DATE'!", "AGRI8 ASSIST DIALOG: Date required", JOptionPane.INFORMATION_MESSAGE);
        }else if (dateend == null ) {
              JOptionPane.showMessageDialog(null, "Please enter 'END DATE'!", "AGRI8 ASSIST DIALOG: Date required", JOptionPane.INFORMATION_MESSAGE);
        } else {
   
            try {

                String query = "UPDATE tbl_bs_report SET " +
                "bsid= '" + BSID + "', one3 = '" + one3 + "', two3 = '" + two3 + "', three3= '" + three3 + "', four3 = '" 
                        + four3 + "', a = '" + A + "', b = '" + B + "', c= '" + C + "', d = '" + D + "', e = '" + E + "', f= '" 
                        + F + "', g = '" + G + "', h = '" + H + "', i = '" + I + "', j = '" + J + "',k = '" + K + "', l = '" 
                        + L + "', m = '" + M + "', n = '" + N + "', o = '" + O + "', p = '" + P + "',  aa = '" + AA + "', bb = '" 
                        + BB + "', cc= '" + CC + "',  dd = '" + DD + "', ee = '" + EE + "', ff = '" + FF + "', gg = '" + GG + "',  hh = '" 
                        + HH + "', ii = '" + II + "', jj= '" + JJ + "',  kk = '" + KK + "', ll = '" + LL + "', mm= '" + MM + "',  nn = '" + NN + "', oo = '" + OO + "', pp= '" 
                        + PP + "', datestart =?, dateend=? " + " WHERE bsid= '" + BSID + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
            
              
                      try{
                      // Accept Null excption from string to Integer
                     if ( datestart.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(datestart.getDate());
                          
                            statement.setString(1, Date1);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select 'START DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          statement.setNull(1, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
                      
                      
                      try{
                      // Accept Null excption from string to Integer
                     if ( dateend.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(dateend.getDate());
                          
                            statement.setString(2, Date2);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select 'END DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          statement.setNull(2, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
               
                int i = statement.executeUpdate();
                
                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "Balancesheet: " + BSID + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassFinancialEmp().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.print("System or Database error: " + e);
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
       
            }
            
         }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        bsid.setText("");
        ONE3.setText("0.00");
        TWO3.setText("0.00");
        THREE3.setText("0.00");
        FOUR3.setText("0.00");
  
        a.setText("0.00");
        b.setText("0.00");
        c.setText("0.00");
        d.setText("0.00");
        e.setText("0.00");
        f.setText("0.00");
        g.setText("0.00");
        h.setText("0.00");
        i.setText("0.00");
        j.setText("0.00");
        k.setText("0.00");
        l.setText("0.00");
        m.setText("0.00");
        n.setText("0.00");
        o.setText("0.00");
        p.setText("0.00");
        
        aa.setText("0.00");
        bb.setText("0.00");
        cc.setText("0.00");
        dd.setText("0.00");
        ee.setText("0.00");
        ff.setText("0.00");
        gg.setText("0.00");
        hh.setText("0.00");
        ii.setText("0.00");
        jj.setText("0.00");
        kk.setText("0.00");
        ll.setText("0.00");
        mm.setText("0.00");
        nn.setText("0.00");
        oo.setText("0.00");
        pp.setText("0.00");
        
        datestart.setDate(null);
        dateend.setDate(null);

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBActionPerformed
        
        
          Connection conn = myConnection.getConnect();
     
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelB = (DefaultTableModel) tableBalance.getModel();
            
            if(tableBalance.getSelectedRowCount()==1) {
            
            int row = tableBalance.getSelectedRow();
            String cell = tableBalance.getModel().getValueAt(row, 0).toString();
            tblModelB.removeRow((int) row);
            String sql = "DELETE FROM tbl_bs_report WHERE bsid = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                    
            } else {
                
                if(tableBalance.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      
        
    }//GEN-LAST:event_btnDeleteBActionPerformed

    private void UIFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UIFKeyPressed
       
        String number = UIF.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<5) {
                UIF.setEditable(true);
            } else {
                 UIF.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                UIF.setEditable(true);
            } else {
                UIF.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
            
        }
    }//GEN-LAST:event_UIFKeyPressed

    private void cqtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cqtyKeyPressed
        String number = cqty.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                cqty.setEditable(true);
            } else {
                 cqty.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                cqty.setEditable(true);
            } else {
                cqty.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
            
        }
    }//GEN-LAST:event_cqtyKeyPressed

    private void cqty1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cqty1KeyPressed
       
        String number = cqty1.getText().trim();
        int length = number.length();
        
        char c = evt.getKeyChar();
        
        try {
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<10) {
                cqty1.setEditable(true);
            } else {
                 cqty1.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                cqty1.setEditable(true);
            } else {
                cqty1.setEditable(false);
            }
        }
        
        } catch (NullPointerException e) {
            
        }
    }//GEN-LAST:event_cqty1KeyPressed

    private void ooKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ooKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ooKeyPressed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pActionPerformed

    private void VKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VKeyReleased
        
        
        try {

                double v = Double.parseDouble(V.getText().trim());
                int q = Integer.parseInt(Q.getText().trim());
             
                double t = (v * q);
                T.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
             
             
        
    }//GEN-LAST:event_VKeyReleased

    private void QKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QKeyReleased
        try {

                double v = Double.parseDouble(V.getText().trim());
                int q = Integer.parseInt(Q.getText().trim());
             
                double t = (v * q);
                T.setText(Double.toString(t));
                
             double t15 = Double.parseDouble(T15.getText().trim());
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q13.getText().trim());                        
                           
                int q15 = (q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_QKeyReleased

    private void V1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V1KeyReleased
        try {

                double v = Double.parseDouble(V1.getText().trim());
                int q = Integer.parseInt(Q1.getText().trim());
             
                double t = (v * q);
                T1.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_V1KeyReleased

    private void V2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V2KeyReleased
        try {

                double v = Double.parseDouble(V2.getText().trim());
                int q = Integer.parseInt(Q2.getText().trim());
             
                double t = (v * q);
                T2.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_V2KeyReleased

    private void V3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V3KeyReleased
        try {

                double v = Double.parseDouble(V3.getText().trim());
                int q = Integer.parseInt(Q3.getText().trim());
             
                double t = (v * q);
                T3.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_V3KeyReleased

    private void V4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V4KeyReleased
        try {

                double v = Double.parseDouble(V4.getText().trim());
                int q = Integer.parseInt(Q4.getText().trim());
             
                double t = (v * q);
                T4.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_V4KeyReleased

    private void V5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V5KeyReleased
        try {

                double v = Double.parseDouble(V5.getText().trim());
                int q = Integer.parseInt(Q5.getText().trim());
             
                double t = (v * q);
                T5.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_V5KeyReleased

    private void V6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V6KeyReleased
        try {

                double v = Double.parseDouble(V6.getText().trim());
                int q = Integer.parseInt(Q6.getText().trim());
             
                double t = (v * q);
                T6.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_V6KeyReleased

    private void V7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V7KeyReleased
          try {

                double v = Double.parseDouble(V7.getText().trim());
                int q = Integer.parseInt(Q7.getText().trim());
             
                double t = (v * q);
                T7.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V7KeyReleased

    private void V8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V8KeyReleased
          try {

                double v = Double.parseDouble(V8.getText().trim());
                int q = Integer.parseInt(Q8.getText().trim());
             
                double t = (v * q);
                T8.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V8KeyReleased

    private void V9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V9KeyReleased
          try {

                double v = Double.parseDouble(V9.getText().trim());
                int q = Integer.parseInt(Q9.getText().trim());
             
                double t = (v * q);
                T9.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V9KeyReleased

    private void V10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V10KeyReleased
          try {

                double v = Double.parseDouble(V10.getText().trim());
                int q = Integer.parseInt(Q10.getText().trim());
             
                double t = (v * q);
                T10.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V10KeyReleased

    private void V11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V11KeyReleased
          try {

                double v = Double.parseDouble(V11.getText().trim());
                int q = Integer.parseInt(Q11.getText().trim());
             
                double t = (v * q);
                T11.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V11KeyReleased

    private void V12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V12KeyReleased
          try {

                double v = Double.parseDouble(V12.getText().trim());
                int q = Integer.parseInt(Q12.getText().trim());
             
                double t = (v * q);
                T12.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V12KeyReleased

    private void V13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V13FocusGained
        
    }//GEN-LAST:event_V13FocusGained

    private void V14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V14KeyReleased
          try {

                double v = Double.parseDouble(V14.getText().trim());
                int q = Integer.parseInt(Q14.getText().trim());
             
                double t = (v * q);
                T14.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V14KeyReleased

    private void V13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V13KeyReleased
          try {

                double v = Double.parseDouble(V13.getText().trim());
                int q = Integer.parseInt(Q13.getText().trim());
             
                double t = (v * q);
                T13.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V13KeyReleased

    private void Q1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q1KeyReleased
          try {

                double v = Double.parseDouble(V1.getText().trim());
                int q = Integer.parseInt(Q1.getText().trim());
             
                double t = (v * q);
                T1.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = ( q + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_Q1KeyReleased

    private void Q2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q2KeyReleased
          try {

                double v = Double.parseDouble(V2.getText().trim());
                int q = Integer.parseInt(Q2.getText().trim());
             
                double t = (v * q);
                T2.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
             
             
             
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_Q2KeyReleased

    private void Q3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q3KeyReleased
          try {

                double v = Double.parseDouble(V3.getText().trim());
                int q = Integer.parseInt(Q3.getText().trim());
             
                double t = (v * q);
                T3.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_Q3KeyReleased

    private void Q4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q4KeyReleased
       try {

                double v = Double.parseDouble(V4.getText().trim());
                int q = Integer.parseInt(Q4.getText().trim());
             
                double t = (v * q);
                T4.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q4KeyReleased

    private void Q5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q5KeyReleased
        try {

                double v = Double.parseDouble(V5.getText().trim());
                int q = Integer.parseInt(Q5.getText().trim());
             
                double t = (v * q);
                T5.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q5KeyReleased

    private void Q6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q6KeyReleased
        try {

                double v = Double.parseDouble(V6.getText().trim());
                int q = Integer.parseInt(Q6.getText().trim());
             
                double t = (v * q);
                T6.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q6KeyReleased

    private void Q7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q7KeyReleased
        
         try {

                double v = Double.parseDouble(V7.getText().trim());
                int q = Integer.parseInt(Q7.getText().trim());
             
                double t = (v * q);
                T7.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q7KeyReleased

    private void Q8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q8KeyReleased
         try {

                double v = Double.parseDouble(V8.getText().trim());
                int q = Integer.parseInt(Q8.getText().trim());
             
                double t = (v * q);
                T8.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q8KeyReleased

    private void Q9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q9KeyReleased
        try {

                double v = Double.parseDouble(V9.getText().trim());
                int q = Integer.parseInt(Q9.getText().trim());
             
                double t = (v * q);
                T9.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
                
        
        } catch (NullPointerException | NumberFormatException e) {

        }
         
           try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q9KeyReleased

    private void Q10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q10KeyReleased
        try {

                double v = Double.parseDouble(V10.getText().trim());
                int q = Integer.parseInt(Q10.getText().trim());
             
                double t = (v * q);
                T10.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
            
         
    }//GEN-LAST:event_Q10KeyReleased

    private void Q11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q11KeyReleased
        try {

                double v = Double.parseDouble(V11.getText().trim());
                int q = Integer.parseInt(Q11.getText().trim());
             
                double t = (v * q);
                T11.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q11KeyReleased

    private void Q12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q12KeyReleased
        try {

                double v = Double.parseDouble(V12.getText().trim());
                int q = Integer.parseInt(Q12.getText().trim());
             
                double t = (v * q);
                T12.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                  
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q12KeyReleased

    private void Q13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q13KeyReleased
        try {

                double v = Double.parseDouble(V13.getText().trim());
                int q = Integer.parseInt(Q13.getText().trim());
             
                double t = (v * q);
                T13.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
         
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q13KeyReleased

    private void Q14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q14KeyReleased
        try {

                double v = Double.parseDouble(V14.getText().trim());
                int q = Integer.parseInt(Q14.getText().trim());
             
                double t = (v * q);
                T14.setText(Double.toString(t));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q = Integer.parseInt(Q.getText().trim());
             int q1 = Integer.parseInt(Q1.getText().trim());
             int q2 = Integer.parseInt(Q2.getText().trim());
             int q3 = Integer.parseInt(Q3.getText().trim());
             int q4 = Integer.parseInt(Q4.getText().trim());
             int q5 = Integer.parseInt(Q5.getText().trim());
             int q6 = Integer.parseInt(Q6.getText().trim());
             int q7 = Integer.parseInt(Q7.getText().trim());
             int q8 = Integer.parseInt(Q8.getText().trim());  
             int q9 = Integer.parseInt(Q9.getText().trim());
             int q10 = Integer.parseInt(Q10.getText().trim());
             int q11 = Integer.parseInt(Q11.getText().trim());
             int q12 = Integer.parseInt(Q12.getText().trim());
             int q13 = Integer.parseInt(Q13.getText().trim());
             int q14 = Integer.parseInt(Q14.getText().trim());                        
                           
                int q15 = (q  + q1    +   q2   +   q3   +   q4   +   q5   + q6    +   q7   +   q8   +   q9   +   q10    +   q11    +   q12   +   q13   +   q14);
                Q15.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            
               try {

             double t = Double.parseDouble(T.getText().trim());
             double t1 = Double.parseDouble(T1.getText().trim());
             double t2 = Double.parseDouble(T2.getText().trim());
             double t3 = Double.parseDouble(T3.getText().trim());
             double t4 = Double.parseDouble(T4.getText().trim());
             double t5 = Double.parseDouble(T5.getText().trim());
             double t6 = Double.parseDouble(T6.getText().trim());
             double t7 = Double.parseDouble(T7.getText().trim());
             double t8 = Double.parseDouble(T8.getText().trim());
             double t9 = Double.parseDouble(T9.getText().trim());
             double t10 = Double.parseDouble(T10.getText().trim());
             double t11 = Double.parseDouble(T11.getText().trim());
             double t12 = Double.parseDouble(T12.getText().trim());
             double t13 = Double.parseDouble(T13.getText().trim());
             double t14 = Double.parseDouble(T14.getText().trim());              
                                    
             double t15 = (t  + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13 + t14 );
             T15.setText(Double.toString(t15));
             
                    
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
               
        
         
         
    }//GEN-LAST:event_Q14KeyReleased

    private void QKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QKeyPressed
        //
              try {

                double v = Double.parseDouble(V.getText().trim());
                int q = Integer.parseInt(Q.getText().trim());
             
                double t = (v * q);
                T.setText(Double.toString(t));
                
             double t15 = Double.parseDouble(T15.getText().trim());
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_QKeyPressed

    private void V29FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V29FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_V29FocusGained

    private void V29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V29KeyReleased
        
        try {

                double v29= Double.parseDouble(V29.getText().trim());
                int q29 = Integer.parseInt(Q29.getText().trim());
             
                double t29 = (v29 * q29);
                T29.setText(Double.toString(t29));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V29KeyReleased

    private void V30KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V30KeyReleased
               try {

                double v30= Double.parseDouble(V30.getText().trim());
                int q30 = Integer.parseInt(Q30.getText().trim());
             
                double t30 = (v30 * q30);
                T30.setText(Double.toString(t30));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V30KeyReleased

    private void V28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V28KeyReleased
       try {

                double v28= Double.parseDouble(V28.getText().trim());
                int q28 = Integer.parseInt(Q28.getText().trim());
             
                double t28 = (v28 * q28);
                T28.setText(Double.toString(t28));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V28KeyReleased

    private void V27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V27KeyReleased
        try {

                double v27= Double.parseDouble(V27.getText().trim());
                int q27 = Integer.parseInt(Q27.getText().trim());
             
                double t27 = (v27 * q27);
                T27.setText(Double.toString(t27));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V27KeyReleased

    private void V26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V26KeyReleased
       try {

                double v26= Double.parseDouble(V26.getText().trim());
                int q26 = Integer.parseInt(Q26.getText().trim());
             
                double t26 = (v26 * q26);
                T26.setText(Double.toString(t26));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V26KeyReleased

    private void V25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V25KeyReleased
             try {

                double v25= Double.parseDouble(V25.getText().trim());
                int q25 = Integer.parseInt(Q25.getText().trim());
             
                double t25 = (v25 * q25);
                T25.setText(Double.toString(t25));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V25KeyReleased

    private void V24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V24KeyReleased
           
       try {

                double v24= Double.parseDouble(V24.getText().trim());
                int q24 = Integer.parseInt(Q24.getText().trim());
             
                double t24 = (v24 * q24);
                T24.setText(Double.toString(t24));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V24KeyReleased

    private void V23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V23KeyReleased
        
               try {

                double v23= Double.parseDouble(V23.getText().trim());
                int q23 = Integer.parseInt(Q23.getText().trim());
             
                double t23 = (v23 * q23);
                T23.setText(Double.toString(t23));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
    }//GEN-LAST:event_V23KeyReleased

    private void V22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V22KeyReleased
                 try {

                double v22 = Double.parseDouble(V22.getText().trim());
                int q22 = Integer.parseInt(Q22.getText().trim());
             
                double t22 = (v22 * q22);
                T22.setText(Double.toString(t22));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V22KeyReleased

    private void V21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V21KeyReleased
              try {

                double v21 = Double.parseDouble(V21.getText().trim());
                int q21 = Integer.parseInt(Q21.getText().trim());
             
                double t21= (v21 * q21);
                T21.setText(Double.toString(t21));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V21KeyReleased

    private void V20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V20KeyReleased
              try {

                double v20 = Double.parseDouble(V20.getText().trim());
                int q20 = Integer.parseInt(Q20.getText().trim());
             
                double t20 = (v20 * q20);
                T20.setText(Double.toString(t20));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V20KeyReleased

    private void V19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V19KeyReleased
           try {

                double v19 = Double.parseDouble(V19.getText().trim());
                int q19 = Integer.parseInt(Q19.getText().trim());
             
                double t19 = (v19 * q19);
                T19.setText(Double.toString(t19));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V19KeyReleased

    private void V18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V18KeyReleased
              try {

                double v18 = Double.parseDouble(V18.getText().trim());
                int q18 = Integer.parseInt(Q18.getText().trim());
             
                double t18 = (v18 * q18);
                T18.setText(Double.toString(t18));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_V18KeyReleased

    private void V17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V17KeyReleased
               try {

                double v17 = Double.parseDouble(V17.getText().trim());
                int q17 = Integer.parseInt(Q17.getText().trim());
             
                double t17 = (v17 * q17);
                T17.setText(Double.toString(t17));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
          
    }//GEN-LAST:event_V17KeyReleased

    private void V16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V16KeyReleased
        
        
             try {

                double v16 = Double.parseDouble(V16.getText().trim());
                int q16 = Integer.parseInt(Q16.getText().trim());
             
                double t16 = (v16 * q16);
                T16.setText(Double.toString(t16));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
        
    }//GEN-LAST:event_V16KeyReleased

    private void Q16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q16KeyReleased
        
         try {

                double v16 = Double.parseDouble(V16.getText().trim());
                int q16 = Integer.parseInt(Q16.getText().trim());
             
                double t16 = (v16 * q16);
                T16.setText(Double.toString(t16));
             
             double t15 = Double.parseDouble(T31.getText().trim());
             double t31 = Double.parseDouble(T31.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
            
             T31.setText(Double.toString(t31));
             
             double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
           
    }//GEN-LAST:event_Q16KeyReleased

    private void Q17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q17KeyReleased
       
         try {

                double v17 = Double.parseDouble(V17.getText().trim());
                int q17 = Integer.parseInt(Q17.getText().trim());
             
                double t17 = (v17 * q17);
                T17.setText(Double.toString(t17));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
             double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q17KeyReleased

    private void Q18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q18KeyReleased
        
        try {

                double v18 = Double.parseDouble(V18.getText().trim());
                int q18 = Integer.parseInt(Q18.getText().trim());
             
                double t18 = (v18 * q18);
                T18.setText(Double.toString(t18));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
             double t15 = Double.parseDouble(T15.getText().trim());
             double dD = (t15 - t31);
             D.setText(Double.toString(dD));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q18KeyReleased

    private void Q19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q19KeyReleased
          try {

                double v19 = Double.parseDouble(V19.getText().trim());
                int q19 = Integer.parseInt(Q19.getText().trim());
             
                double t19 = (v19 * q19);
                T19.setText(Double.toString(t19));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
             double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q19KeyReleased

    private void Q20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q20KeyReleased
          try {

                double v20 = Double.parseDouble(V20.getText().trim());
                int q20 = Integer.parseInt(Q20.getText().trim());
             
                double t20 = (v20 * q20);
                T20.setText(Double.toString(t20));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q20KeyReleased

    private void Q21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q21KeyReleased
          try {

                double v21 = Double.parseDouble(V21.getText().trim());
                int q21 = Integer.parseInt(Q21.getText().trim());
             
                double t21 = (v21 * q21);
                T21.setText(Double.toString(t21));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q21KeyReleased

    private void Q22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q22KeyReleased
           try {

                double v22 = Double.parseDouble(V22.getText().trim());
                int q22 = Integer.parseInt(Q22.getText().trim());
             
                double t22 = (v22 * q22);
                T22.setText(Double.toString(t22));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q22KeyReleased

    private void Q23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q23KeyReleased
           try {

                double v23 = Double.parseDouble(V23.getText().trim());
                int q23 = Integer.parseInt(Q23.getText().trim());
             
                double t23 = (v23 * q23);
                T23.setText(Double.toString(t23));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q23KeyReleased

    private void Q24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q24KeyReleased
          try {

                double v24 = Double.parseDouble(V24.getText().trim());
                int q24 = Integer.parseInt(Q24.getText().trim());
             
                double t24 = (v24 * q24);
                T24.setText(Double.toString(t24));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q24KeyReleased

    private void Q25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q25KeyReleased
              try {

                double v25 = Double.parseDouble(V25.getText().trim());
                int q25 = Integer.parseInt(Q25.getText().trim());
             
                double t25 = (v25 * q25);
                T25.setText(Double.toString(t25));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q25KeyReleased

    private void Q26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q26KeyReleased
             try {

                double v26 = Double.parseDouble(V26.getText().trim());
                int q26 = Integer.parseInt(Q26.getText().trim());
             
                double t26 = (v26 * q26);
                T26.setText(Double.toString(t26));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q26KeyReleased

    private void Q27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q27KeyReleased
              try {

                double v27 = Double.parseDouble(V27.getText().trim());
                int q27 = Integer.parseInt(Q27.getText().trim());
             
                double t27 = (v27 * q27);
                T27.setText(Double.toString(t27));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q27KeyReleased

    private void Q28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q28KeyReleased
              try {

                double v28 = Double.parseDouble(V28.getText().trim());
                int q28 = Integer.parseInt(Q28.getText().trim());
             
                double t28 = (v28 * q28);
                T28.setText(Double.toString(t28));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q28KeyReleased

    private void Q29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q29KeyReleased
             try {

                double v29 = Double.parseDouble(V29.getText().trim());
                int q29 = Integer.parseInt(Q29.getText().trim());
             
                double t29 = (v29 * q29);
                T29.setText(Double.toString(t29));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q29KeyReleased

    private void Q30KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q30KeyReleased
              try {

                double v30 = Double.parseDouble(V30.getText().trim());
                int q30 = Integer.parseInt(Q30.getText().trim());
             
                double t30 = (v30 * q30);
                T30.setText(Double.toString(t30));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
        
         try {

             int q16 = Integer.parseInt(Q16.getText().trim());
             int q17 = Integer.parseInt(Q17.getText().trim());
             int q18 = Integer.parseInt(Q18.getText().trim());
             int q19 = Integer.parseInt(Q19.getText().trim());
             int q20 = Integer.parseInt(Q20.getText().trim());
             int q21 = Integer.parseInt(Q21.getText().trim());
             int q22 = Integer.parseInt(Q22.getText().trim());
             int q23 = Integer.parseInt(Q23.getText().trim());
             int q24 = Integer.parseInt(Q24.getText().trim());  
             int q25 = Integer.parseInt(Q25.getText().trim());
             int q26 = Integer.parseInt(Q26.getText().trim());
             int q27 = Integer.parseInt(Q27.getText().trim());
             int q28 = Integer.parseInt(Q28.getText().trim());
             int q29 = Integer.parseInt(Q29.getText().trim());
             int q30 = Integer.parseInt(Q30.getText().trim());                        
                           
                int q15 = ( q16 + q17    +   q18   +   q19   +   q20   +   q21   + q22    +   q23   +   q24   +   q25   +   q26    +   q27    +   q28   +   q29   +   q30);
                Q31.setText(Integer.toString(q15));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
         
            try {

             double t16 = Double.parseDouble(T16.getText().trim());
             double t17 = Double.parseDouble(T17.getText().trim());
             double t18 = Double.parseDouble(T18.getText().trim());
             double t19 = Double.parseDouble(T19.getText().trim());
             double t20 = Double.parseDouble(T20.getText().trim());
             double t21 = Double.parseDouble(T21.getText().trim());
             double t22 = Double.parseDouble(T22.getText().trim());
             double t23 = Double.parseDouble(T23.getText().trim());
             double t24 = Double.parseDouble(T24.getText().trim());
             double t25 = Double.parseDouble(T25.getText().trim());
             double t26 = Double.parseDouble(T26.getText().trim());
             double t27 = Double.parseDouble(T27.getText().trim());
             double t28 = Double.parseDouble(T28.getText().trim());
             double t29 = Double.parseDouble(T29.getText().trim());
             double t30 = Double.parseDouble(T30.getText().trim());              
                                    
             double t31 = (t16  + t17 + t18 + t19 + t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29 + t30 );
             T31.setText(Double.toString(t31));
             
               double t15 = Double.parseDouble(T15.getText().trim());
             double d = (t15 - t31);
             D.setText(Double.toString(d));
       
        } catch (NullPointerException | NumberFormatException e) {

        }
    }//GEN-LAST:event_Q30KeyReleased

    private void btnClearTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTActionPerformed
        this.dispose();
        new ClassFinancialEmp().setVisible(true);
    }//GEN-LAST:event_btnClearTActionPerformed

    private void btnSaveTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTActionPerformed
         // Save new TRADING ACCOUNT to database

        String ACCOUNT = ACCOUNTID.getText().trim();
          
        BigDecimal t31 = null;
        BigDecimal q31 = null;
        BigDecimal d = null;
        BigDecimal t15 = null;
        BigDecimal q15 = null;
        
 
        BigDecimal v = null;
        BigDecimal v1 = null;
        BigDecimal v2 = null;
        BigDecimal v3 = null;
        BigDecimal v4 = null;
         
        BigDecimal v5 = null;
        BigDecimal v6 = null;
        BigDecimal v7 = null;
        BigDecimal v8 = null;
        BigDecimal v9 = null;
         
        BigDecimal v10 = null;
        BigDecimal v11 = null;
        BigDecimal v12 = null;
        BigDecimal v13 = null;
        BigDecimal v14 = null;
         
        BigDecimal v16 = null;
        BigDecimal v17 = null;
        BigDecimal v18 = null;
        BigDecimal v19 = null;
        BigDecimal v20 = null;
         
        BigDecimal v21 = null;
        BigDecimal v22 = null;
        BigDecimal v23 = null;
        BigDecimal v24 = null;
        BigDecimal v25 = null;
         
        BigDecimal v26 = null;
        BigDecimal v27 = null;
        BigDecimal v28 = null;
        BigDecimal v29 = null;
        BigDecimal v30 = null;
        
 
        BigDecimal q = null;
        BigDecimal q1 = null;
        BigDecimal q2 = null;
        BigDecimal q3 = null;
        BigDecimal q4 = null;
         
        BigDecimal q5 = null;
        BigDecimal q6 = null;
        BigDecimal q7 = null;
        BigDecimal q8 = null;
        BigDecimal q9 = null;
         
        BigDecimal q10 = null;
        BigDecimal q11 = null;
        BigDecimal q12 = null;
        BigDecimal q13 = null;
        BigDecimal q14 = null;
         
        BigDecimal q16 = null;
        BigDecimal q17 = null;
        BigDecimal q18 = null;
        BigDecimal q19 = null;
        BigDecimal q20 = null;
         
        BigDecimal q21 = null;
        BigDecimal q22 = null;
        BigDecimal q23 = null;
        BigDecimal q24 = null;
        BigDecimal q25 = null;
         
        BigDecimal q26 = null;
        BigDecimal q27 = null;
        BigDecimal q28 = null;
        BigDecimal q29 = null;
        BigDecimal q30 = null;
    

        BigDecimal t = null;
        BigDecimal t1 = null;
        BigDecimal t2 = null;
        BigDecimal t3 = null;
        BigDecimal t4 = null;
         
        BigDecimal t5 = null;
        BigDecimal t6 = null;
        BigDecimal t7 = null;
        BigDecimal t8 = null;
        BigDecimal t9 = null;
         
        BigDecimal t10 = null;
        BigDecimal t11 = null;
        BigDecimal t12 = null;
        BigDecimal t13 = null;
        BigDecimal t14 = null;
         
        BigDecimal t16 = null;
        BigDecimal t17 = null;
        BigDecimal t18 = null;
        BigDecimal t19 = null;
        BigDecimal t20 = null;
         
        BigDecimal t21 = null;
        BigDecimal t22 = null;
        BigDecimal t23 = null;
        BigDecimal t24 = null;
        BigDecimal t25 = null;
         
        BigDecimal t26 = null;
        BigDecimal t27 = null;
        BigDecimal t28 = null;
        BigDecimal t29 = null;
        BigDecimal t30 = null;
    
        try {
            
            t31 = new BigDecimal(T31.getText());
            q31 = new BigDecimal(Q31.getText());
            d = new BigDecimal(D.getText());
            t15 = new BigDecimal(T15.getText());
            t31 = new BigDecimal(Q15.getText());
    
            v = new BigDecimal(V.getText());
            v1 = new BigDecimal(V1.getText());
            v2 = new BigDecimal(V2.getText());
            v3 = new BigDecimal(V3.getText());
            v4 = new BigDecimal(V4.getText());
            
            v5 = new BigDecimal(V5.getText());
            v6 = new BigDecimal(V6.getText());
            v7 = new BigDecimal(V7.getText());
            v8 = new BigDecimal(V8.getText());
            v9 = new BigDecimal(V9.getText());
            
            v10 = new BigDecimal(V10.getText());
            v11 = new BigDecimal(V11.getText());
            v12 = new BigDecimal(V12.getText());
            v13 = new BigDecimal(V13.getText());
            v14 = new BigDecimal(V14.getText());
            
            v16 = new BigDecimal(V16.getText());
            v17 = new BigDecimal(V17.getText());
            v18 = new BigDecimal(V18.getText());
            v19 = new BigDecimal(V19.getText());
            v20 = new BigDecimal(V20.getText());
            
            v21 = new BigDecimal(V21.getText());
            v22 = new BigDecimal(V22.getText());
            v23 = new BigDecimal(V23.getText());
            v24 = new BigDecimal(V24.getText());
            v25 = new BigDecimal(V25.getText());
            
            v26 = new BigDecimal(V26.getText());
            v27 = new BigDecimal(V27.getText());
            v28 = new BigDecimal(V28.getText());
            v29 = new BigDecimal(V29.getText());
            v30 = new BigDecimal(V30.getText());
      
              q = new BigDecimal(Q.getText());
            q1 = new BigDecimal(Q1.getText());
            q2 = new BigDecimal(Q2.getText());
            q3 = new BigDecimal(Q3.getText());
            q4 = new BigDecimal(Q4.getText());
            
            q5 = new BigDecimal(Q5.getText());
            q6 = new BigDecimal(Q6.getText());
            q7 = new BigDecimal(Q7.getText());
            q8 = new BigDecimal(Q8.getText());
            q9 = new BigDecimal(Q9.getText());
            
            q10 = new BigDecimal(Q10.getText());
            q11 = new BigDecimal(Q11.getText());
            q12 = new BigDecimal(Q12.getText());
            q13 = new BigDecimal(Q13.getText());
            q14 = new BigDecimal(Q14.getText());
            
            q16 = new BigDecimal(Q16.getText());
            q17 = new BigDecimal(Q17.getText());
            q18 = new BigDecimal(Q18.getText());
            q19 = new BigDecimal(Q19.getText());
            q20 = new BigDecimal(Q20.getText());
           
            q21 = new BigDecimal(Q21.getText());
            q22 = new BigDecimal(Q22.getText());
            q23 = new BigDecimal(Q23.getText());
            q24 = new BigDecimal(Q24.getText());
            q25 = new BigDecimal(Q25.getText());
          
            q26 = new BigDecimal(Q26.getText());
            q27 = new BigDecimal(Q27.getText());
            q28 = new BigDecimal(Q28.getText());
            q29 = new BigDecimal(Q29.getText());
            q30 = new BigDecimal(Q30.getText());
            
            t = new BigDecimal(T.getText());
            t1 = new BigDecimal(T1.getText());
            t2 = new BigDecimal(T2.getText());
            t3 = new BigDecimal(T3.getText());
            t4 = new BigDecimal(T4.getText());
            
            t5 = new BigDecimal(T5.getText());
            t6 = new BigDecimal(T6.getText());
            t7 = new BigDecimal(T7.getText());
            t8 = new BigDecimal(T8.getText());
            t9 = new BigDecimal(T9.getText());
            
            t10 = new BigDecimal(T10.getText());
            t11 = new BigDecimal(T11.getText());
            t12 = new BigDecimal(T12.getText());
            t13 = new BigDecimal(T13.getText());
            t14 = new BigDecimal(T14.getText());
            
            t16 = new BigDecimal(T16.getText());
            t17 = new BigDecimal(T17.getText());
            t18 = new BigDecimal(T18.getText());
            t19 = new BigDecimal(T19.getText());
            t20 = new BigDecimal(T20.getText());
           
            t21 = new BigDecimal(T21.getText());
            t22 = new BigDecimal(T22.getText());
            t23 = new BigDecimal(T23.getText());
            t24 = new BigDecimal(T24.getText());
            t25 = new BigDecimal(T25.getText());
         
            t26 = new BigDecimal(T26.getText());
            t27 = new BigDecimal(T27.getText());
            t28 = new BigDecimal(T28.getText());
            t29 = new BigDecimal(T29.getText());
            t30 = new BigDecimal(T30.getText());
           
            
            
        } catch (NumberFormatException | NullPointerException e) {

        }
 

        //Validation to check if controls are empty or not
        if( ACCOUNT.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter TRADING ACCOUNTS ID!", "AGRI8 ASSIST DIALOG: ENTER ID", JOptionPane.INFORMATION_MESSAGE);

        } else {   
            
        } try {
                
                Connection conn = myConnection.getConnect(); 
                
                //Check CONTACT already exists
                String checkName = "SELECT a_id FROM tbl_account_report WHERE a_id = '" + ACCOUNT + "'";
                PreparedStatement psm= conn.prepareStatement(checkName);
                ResultSet rs = psm.executeQuery();
                
                if(rs.next() == true) {// If LABOUR name has already been taken
                    JOptionPane.showMessageDialog(null, "Trading Account ID " + ACCOUNT + " already exist in Database!", "ERROR, ACCOUNT ALREADY EXIST", JOptionPane.ERROR_MESSAGE);
                }

                    //Save new Employee
                    String saveQuery = "INSERT INTO tbl_account_report(a_id, t31, q31, d, t15, q15, dateopen, dateclose, v, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, q, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27, q28, q29, q30, t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30 )" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

                     psm = conn.prepareStatement(saveQuery);

                      try{

                        // Accept Null excption from string to Integer
                        if ( dateOpen.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(dateOpen.getDate());
                            psm.setString(7, Date1);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'OPENING DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(7, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException  e) {

                    }
                      
                       try{

                        // Accept Null excption from string to Integer
                        if ( dateClose.getDate() != null ) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(dateClose.getDate());
                            psm.setString(8, Date2);

                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter 'CLOSING DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                            psm.setNull(8, java.sql.Types.DATE);
                        }

                    } catch (NullPointerException | NumberFormatException  e) {

                    }
   
                        
                     try{
                        psm.setString(1, ACCOUNT);
                        psm.setBigDecimal(2, t31); 
                        psm.setBigDecimal(3, q31);
                        psm.setBigDecimal(4, d); 
                        psm.setBigDecimal(5, t15); 
                        psm.setBigDecimal(6, q15); 
                        
                        psm.setBigDecimal(9, v); 
                        psm.setBigDecimal(10, v1);
                        psm.setBigDecimal(11, v2); 
                        psm.setBigDecimal(12, v3);
                        psm.setBigDecimal(13, v4); 
                        psm.setBigDecimal(14, v5);
                        psm.setBigDecimal(15, v6); 
                        psm.setBigDecimal(16, v7);
                        psm.setBigDecimal(17, v8); 
                        psm.setBigDecimal(18, v9);
                        psm.setBigDecimal(19, v10); 
                        psm.setBigDecimal(20, v11);
                        psm.setBigDecimal(21, v12); 
                        psm.setBigDecimal(22, v13);
                        psm.setBigDecimal(23, v14); 
                        psm.setBigDecimal(24, v16);
                       
                        psm.setBigDecimal(25, v17); 
                        psm.setBigDecimal(26, v18);
                        psm.setBigDecimal(27, v19); 
                        psm.setBigDecimal(28, v20);
                        psm.setBigDecimal(29, v21); 
                        psm.setBigDecimal(30, v22);
                 
                        psm.setBigDecimal(31, v23); 
                        psm.setBigDecimal(32, v24);
                       
                        psm.setBigDecimal(33, v25); 
                        psm.setBigDecimal(34, v26);
                        psm.setBigDecimal(35, v27); 
                        psm.setBigDecimal(36, v28);
                        psm.setBigDecimal(37, v29); 
                        psm.setBigDecimal(38, v30);
                        
                        psm.setBigDecimal(39, q); 
                        psm.setBigDecimal(40, q1);
                        psm.setBigDecimal(41, q2); 
                        psm.setBigDecimal(42, q3);
                        psm.setBigDecimal(43, q4); 
                        psm.setBigDecimal(44, q5);
                        psm.setBigDecimal(45, q6); 
                        psm.setBigDecimal(46, q7);
                        psm.setBigDecimal(47, q8); 
                        psm.setBigDecimal(48, q9);
                        psm.setBigDecimal(49, q10); 
                        psm.setBigDecimal(50, q11);
                        psm.setBigDecimal(51, q12); 
                        psm.setBigDecimal(52, q13);
                        psm.setBigDecimal(53, q14); 
                        psm.setBigDecimal(54, q16);
                       
                        psm.setBigDecimal(55, q17); 
                        psm.setBigDecimal(56, q18);
                        psm.setBigDecimal(57, q19); 
                        psm.setBigDecimal(58, q20);
                        psm.setBigDecimal(59, q21); 
                        psm.setBigDecimal(60, q22);
                 
                        psm.setBigDecimal(61, q23); 
                        psm.setBigDecimal(62, q24);
                      
                        psm.setBigDecimal(63, q25); 
                        psm.setBigDecimal(64, q26);
                        psm.setBigDecimal(65, q27); 
                        psm.setBigDecimal(66, q28);
                        psm.setBigDecimal(67, q29); 
                        psm.setBigDecimal(68, q30);
                        
                        psm.setBigDecimal(69, t); 
                        psm.setBigDecimal(70, t1);
                        psm.setBigDecimal(71, t2); 
                        psm.setBigDecimal(72, t3);
                        psm.setBigDecimal(73, t4); 
                        psm.setBigDecimal(74, t5);
                        psm.setBigDecimal(75, t6); 
                        psm.setBigDecimal(76, t7);
                        psm.setBigDecimal(77, t8); 
                        psm.setBigDecimal(78, t9);
                        psm.setBigDecimal(79, t10); 
                        psm.setBigDecimal(80, t11);
                        psm.setBigDecimal(81, t12); 
                        psm.setBigDecimal(82, t13);
                        psm.setBigDecimal(83, t14); 
                        psm.setBigDecimal(84, t16);
                       
                        psm.setBigDecimal(85, t17); 
                        psm.setBigDecimal(86, t18);
                        psm.setBigDecimal(87, t19); 
                        psm.setBigDecimal(88, t20);
                        psm.setBigDecimal(89, t21); 
                        psm.setBigDecimal(90, t22);
                
                        psm.setBigDecimal(91, t23); 
                        psm.setBigDecimal(92, t24);
                      
                        psm.setBigDecimal(93, t25); 
                        psm.setBigDecimal(94, t26);
                        psm.setBigDecimal(95, t27); 
                        psm.setBigDecimal(96, t28);
                        psm.setBigDecimal(97, t29); 
                        psm.setBigDecimal(98, t30);
                        

                    } catch (NullPointerException | NumberFormatException | SQLException | HeadlessException e) {

                    }
     
                    int i = psm.executeUpdate();
                    if(i >= 1){
                        JOptionPane.showMessageDialog(null, "Trading Account " + ACCOUNT + " Added Succesfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                      
                        conn.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new TRADING ACOUNT to database ", "FAILURE", JOptionPane.INFORMATION_MESSAGE);

                    }
                
            } catch (SQLException | HeadlessException e) {
                System.err.print("System Error: " + e);
              // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_btnSaveTActionPerformed

    private void btnSearchTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTActionPerformed
        
        
          Connection conn = myConnection.getConnect();
               
                String ACCOUNT = ACCOUNTID.getText();
                ACCOUNTID.requestFocus();
                
                if(ACCOUNT.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please select ID in ACCOUNT ID Field to search!");
                
                } else {
                               
                try {

                    //Establish / Open Connection
                    
                    String sql = "SELECT * FROM tbl_account_report WHERE a_id = ?";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, ACCOUNT);
             //Executing Query
                    ResultSet rs = sta.executeQuery();
                 
                    if (rs.next()) {
                        ACCOUNTID.setEditable(false);
                        T31.setText(rs.getString("t31"));                       
                        Q31.setText(rs.getString("q31"));                         
                        D.setText(rs.getString("d"));                     
                        T15.setText(rs.getString("t15"));                           
                        Q15.setText(rs.getString("q15")); 
                        dateOpen.setDate(rs.getDate("dateopen"));
                        dateClose.setDate(rs.getDate("dateclose"));
           
                        V.setText(rs.getString("v"));                
                        V1.setText(rs.getString("v1"));    
                        V2.setText(rs.getString("v2"));                      
                        V3.setText(rs.getString("v3"));  
                        V4.setText(rs.getString("v4"));
                        V5.setText(rs.getString("v5"));   
                        V6.setText(rs.getString("v6"));
                        V7.setText(rs.getString("v7"));  
                        V8.setText(rs.getString("v8"));                      
                        V9.setText(rs.getString("v9"));  
                        V10.setText(rs.getString("v10"));
                        V11.setText(rs.getString("v11"));   
                        V12.setText(rs.getString("v12"));
                        V13.setText(rs.getString("v13"));  
                        V14.setText(rs.getString("v14"));
                        V16.setText(rs.getString("v16")); 
                       
                        V17.setText(rs.getString("v17"));                
                        V18.setText(rs.getString("v18"));    
                        V19.setText(rs.getString("v19"));                      
                        V20.setText(rs.getString("v20"));  
                        V21.setText(rs.getString("v21"));
                        V22.setText(rs.getString("v22"));   
                        V23.setText(rs.getString("v23"));
                        V24.setText(rs.getString("v24"));  
                        V25.setText(rs.getString("v25"));                      
                        V26.setText(rs.getString("v26"));  
                        V27.setText(rs.getString("v27"));
                        V28.setText(rs.getString("v28"));   
                        V29.setText(rs.getString("v29"));
                        V30.setText(rs.getString("v30"));  
               
                        Q.setText(rs.getString("q"));                
                        Q1.setText(rs.getString("q1"));    
                        Q2.setText(rs.getString("q2"));                      
                        Q3.setText(rs.getString("q3"));  
                        Q4.setText(rs.getString("q4"));
                        Q5.setText(rs.getString("q5"));   
                        Q6.setText(rs.getString("q6"));
                        Q7.setText(rs.getString("q7"));  
                        Q8.setText(rs.getString("q8"));                      
                        Q9.setText(rs.getString("q9"));  
                        Q10.setText(rs.getString("q10"));
                        Q11.setText(rs.getString("q11"));   
                        Q12.setText(rs.getString("q12"));
                        Q13.setText(rs.getString("q13"));  
                        Q14.setText(rs.getString("q14"));
                        Q16.setText(rs.getString("q16")); 
                       
                        Q17.setText(rs.getString("q17"));                
                        Q18.setText(rs.getString("q18"));    
                        Q19.setText(rs.getString("q19"));                      
                        Q20.setText(rs.getString("q20"));  
                        Q21.setText(rs.getString("q21"));
                        Q22.setText(rs.getString("q22"));   
                        Q23.setText(rs.getString("q23"));
                        Q24.setText(rs.getString("q24"));  
                        Q25.setText(rs.getString("q25"));                      
                        Q26.setText(rs.getString("q26"));  
                        Q27.setText(rs.getString("q27"));
                        Q28.setText(rs.getString("q28"));   
                        Q29.setText(rs.getString("q29"));
                        Q30.setText(rs.getString("q30"));  
               
                        T.setText(rs.getString("t"));                
                        T1.setText(rs.getString("t1"));    
                        T2.setText(rs.getString("t2"));                      
                        T3.setText(rs.getString("t3"));  
                        T4.setText(rs.getString("t4"));
                        T5.setText(rs.getString("t5"));   
                        T6.setText(rs.getString("t6"));
                        T7.setText(rs.getString("t7"));  
                        T8.setText(rs.getString("t8"));                      
                        T9.setText(rs.getString("t9"));  
                        T10.setText(rs.getString("t10"));
                        T11.setText(rs.getString("t11"));   
                        T12.setText(rs.getString("t12"));
                        T13.setText(rs.getString("t13"));  
                        T14.setText(rs.getString("t14"));
                        T16.setText(rs.getString("t16")); 
                       
                        T17.setText(rs.getString("t17"));                
                        T18.setText(rs.getString("t18"));    
                        T19.setText(rs.getString("t19"));                      
                        T20.setText(rs.getString("t20"));  
                        T21.setText(rs.getString("t21"));
                        T22.setText(rs.getString("t22"));   
                        T23.setText(rs.getString("t23"));
                        T24.setText(rs.getString("t24"));  
                        T25.setText(rs.getString("t25"));                      
                        T26.setText(rs.getString("t26"));  
                        T27.setText(rs.getString("t27"));
                        T28.setText(rs.getString("t28"));   
                        T29.setText(rs.getString("t29"));
                        T30.setText(rs.getString("t30"));  
            
                     

                    }
                        } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }

  
        
    }//GEN-LAST:event_btnSearchTActionPerformed

    private void btnUpdateTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTActionPerformed
        
       String ACCOUNT = ACCOUNTID.getText().trim();
       Integer q31 = null;
       Integer q15 = null;
           
        BigDecimal t31 = null;
    
        BigDecimal d = null;
        BigDecimal t15 = null;

        BigDecimal v = null;
        BigDecimal v1 = null;
        BigDecimal v2 = null;
        BigDecimal v3 = null;
        BigDecimal v4 = null;
         
        BigDecimal v5 = null;
        BigDecimal v6 = null;
        BigDecimal v7 = null;
        BigDecimal v8 = null;
        BigDecimal v9 = null;
         
        BigDecimal v10 = null;
        BigDecimal v11 = null;
        BigDecimal v12 = null;
        BigDecimal v13 = null;
        BigDecimal v14 = null;
         
        BigDecimal v16 = null;
        BigDecimal v17 = null;
        BigDecimal v18 = null;
        BigDecimal v19 = null;
        BigDecimal v20 = null;
         
        BigDecimal v21 = null;
        BigDecimal v22 = null;
        BigDecimal v23 = null;
        BigDecimal v24 = null;
        BigDecimal v25 = null;
         
        BigDecimal v26 = null;
        BigDecimal v27 = null;
        BigDecimal v28 = null;
        BigDecimal v29 = null;
        BigDecimal v30 = null;
        
 
        Integer q = null;
        Integer q1 = null;
        Integer q2 = null;
        Integer q3 = null;
        Integer q4 = null;
         
        Integer q5 = null;
        Integer q6 = null;
        Integer q7 = null;
        Integer q8 = null;
        Integer q9 = null;
         
        Integer q10 = null;
        Integer q11 = null;
        Integer q12 = null;
        Integer q13 = null;
        Integer q14 = null;
         
        Integer q16 = null;
        Integer q17 = null;
        Integer q18 = null;
        Integer q19 = null;
        Integer q20 = null;
         
        Integer q21 = null;
        Integer q22 = null;
        Integer q23 = null;
        Integer q24 = null;
        Integer q25 = null;
         
        Integer q26 = null;
        Integer q27 = null;
        Integer q28 = null;
        Integer q29 = null;
        Integer q30 = null;
    

        BigDecimal t = null;
        BigDecimal t1 = null;
        BigDecimal t2 = null;
        BigDecimal t3 = null;
        BigDecimal t4 = null;
         
        BigDecimal t5 = null;
        BigDecimal t6 = null;
        BigDecimal t7 = null;
        BigDecimal t8 = null;
        BigDecimal t9 = null;
         
        BigDecimal t10 = null;
        BigDecimal t11 = null;
        BigDecimal t12 = null;
        BigDecimal t13 = null;
        BigDecimal t14 = null;
         
        BigDecimal t16 = null;
        BigDecimal t17 = null;
        BigDecimal t18 = null;
        BigDecimal t19 = null;
        BigDecimal t20 = null;
         
        BigDecimal t21 = null;
        BigDecimal t22 = null;
        BigDecimal t23 = null;
        BigDecimal t24 = null;
        BigDecimal t25 = null;
         
        BigDecimal t26 = null;
        BigDecimal t27 = null;
        BigDecimal t28 = null;
        BigDecimal t29 = null;
        BigDecimal t30 = null;
    
        

        
        try {
            
            t31 = new BigDecimal(T31.getText());
            q31 = Integer.parseInt(Q31.getText());
            
            d = new BigDecimal(D.getText());
            t15 = new BigDecimal(T15.getText());
            t31 = new BigDecimal(Q15.getText());
            q15 = Integer.parseInt(Q15.getText());
    
            v = new BigDecimal(V.getText());
            v1 = new BigDecimal(V1.getText());
            v2 = new BigDecimal(V2.getText());
            v3 = new BigDecimal(V3.getText());
            v4 = new BigDecimal(V4.getText());
            
            v5 = new BigDecimal(V5.getText());
            v6 = new BigDecimal(V6.getText());
            v7 = new BigDecimal(V7.getText());
            v8 = new BigDecimal(V8.getText());
            v9 = new BigDecimal(V9.getText());
            
            v10 = new BigDecimal(V10.getText());
            v11 = new BigDecimal(V11.getText());
            v12 = new BigDecimal(V12.getText());
            v13 = new BigDecimal(V13.getText());
            v14 = new BigDecimal(V14.getText());
            
            v16 = new BigDecimal(V16.getText());
            v17 = new BigDecimal(V17.getText());
            v18 = new BigDecimal(V18.getText());
            v19 = new BigDecimal(V19.getText());
            v20 = new BigDecimal(V20.getText());
            
            v21 = new BigDecimal(V21.getText());
            v22 = new BigDecimal(V22.getText());
            v23 = new BigDecimal(V23.getText());
            v24 = new BigDecimal(V24.getText());
            v25 = new BigDecimal(V25.getText());
            
            v26 = new BigDecimal(V26.getText());
            v27 = new BigDecimal(V27.getText());
            v28 = new BigDecimal(V28.getText());
            v29 = new BigDecimal(V29.getText());
            v30 = new BigDecimal(V30.getText());
      
              q = Integer.parseInt(Q.getText());
              q1 = Integer.parseInt(Q1.getText());
              q2 = Integer.parseInt(Q2.getText());
              q3 = Integer.parseInt(Q3.getText());
              q4 = Integer.parseInt(Q3.getText());
              q5 = Integer.parseInt(Q5.getText());
              
              q6 = Integer.parseInt(Q6.getText());
              q7 = Integer.parseInt(Q7.getText());
              q8 = Integer.parseInt(Q8.getText());
              q9 = Integer.parseInt(Q9.getText());
              q10 = Integer.parseInt(Q10.getText());
              q11 = Integer.parseInt(Q11.getText());
              
              q12 = Integer.parseInt(Q12.getText());
              q13 = Integer.parseInt(Q13.getText());
              q14 = Integer.parseInt(Q14.getText());
              q16 = Integer.parseInt(Q16.getText());
              q17 = Integer.parseInt(Q17.getText());
              q18 = Integer.parseInt(Q18.getText());
              
              q19 = Integer.parseInt(Q19.getText());
              q20 = Integer.parseInt(Q20.getText());
              q21 = Integer.parseInt(Q21.getText());
              q22 = Integer.parseInt(Q22.getText());
              q23 = Integer.parseInt(Q23.getText());
              q24 = Integer.parseInt(Q24.getText());
                     
              q25 = Integer.parseInt(Q25.getText());
              q26 = Integer.parseInt(Q26.getText());
              q27 = Integer.parseInt(Q27.getText());
              q28 = Integer.parseInt(Q28.getText());
              q29 = Integer.parseInt(Q29.getText());
              q30 = Integer.parseInt(Q30.getText());

            t = new BigDecimal(T.getText());
            t1 = new BigDecimal(T1.getText());
            t2 = new BigDecimal(T2.getText());
            t3 = new BigDecimal(T3.getText());
            t4 = new BigDecimal(T4.getText());
            
            t5 = new BigDecimal(T5.getText());
            t6 = new BigDecimal(T6.getText());
            t7 = new BigDecimal(T7.getText());
            t8 = new BigDecimal(T8.getText());
            t9 = new BigDecimal(T9.getText());
            
            t10 = new BigDecimal(T10.getText());
            t11 = new BigDecimal(T11.getText());
            t12 = new BigDecimal(T12.getText());
            t13 = new BigDecimal(T13.getText());
            t14 = new BigDecimal(T14.getText());
            
            t16 = new BigDecimal(T16.getText());
            t17 = new BigDecimal(T17.getText());
            t18 = new BigDecimal(T18.getText());
            t19 = new BigDecimal(T19.getText());
            t20 = new BigDecimal(T20.getText());
           
            t21 = new BigDecimal(T21.getText());
            t22 = new BigDecimal(T22.getText());
            t23 = new BigDecimal(T23.getText());
            t24 = new BigDecimal(T24.getText());
            t25 = new BigDecimal(T25.getText());
         
            t26 = new BigDecimal(T26.getText());
            t27 = new BigDecimal(T27.getText());
            t28 = new BigDecimal(T28.getText());
            t29 = new BigDecimal(T29.getText());
            t30 = new BigDecimal(T30.getText());
           
            
            
        } catch (NumberFormatException | NullPointerException e) {

        }
 
       
         Connection conn = myConnection.getConnect();
         if(ACCOUNT.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please search ACCOUNT ID to update!", "AGRI8 ASSIST: ACCOUNT ID REQUIRED!", JOptionPane.ERROR_MESSAGE);
            ACCOUNTID.requestFocus();
         } else if (dateOpen == null ) {
              JOptionPane.showMessageDialog(null, "Please enter 'OPENING DATE'!", "AGRI8 ASSIST DIALOG: Date required", JOptionPane.INFORMATION_MESSAGE);
        }else if (dateClose == null ) {
              JOptionPane.showMessageDialog(null, "Please enter 'CLOSING DATE'!", "AGRI8 ASSIST DIALOG: Date required", JOptionPane.INFORMATION_MESSAGE);
        } else {
   
            try {

                String query = "UPDATE tbl_account_report SET " +
                "dateopen = ? , dateclose = ? , a_id= '" + ACCOUNT + "', t31 = '" + t31 + "', q31 = '" + q31 + "', d= '" + d + "', t15 = '" + t15 + "', q15 = '" + q15 + "', v = '" 
                        + v + "', v1= '" + v1 + "', v2 = '" + v2 + "', v3 = '" + v3 + "', v4= '" + v4 + "', v5 = '" + v5 + "', v6 = '" + v6 + "', v7 = '" 
                        + v7 + "', v8 = '" + v8+ "', v9 = '" + v9 + "', v10 = '" + v10 + "', v11 = '" + v11 + "', v12 = '" + v12 + "', v13 = '" + v13 + "', v14 = '" 
                        + v14 + "',  v16 = '" + v16 + "', v17 = '" + v17 + "', v18= '" + v18 + "',  v19 = '" + v19 + "', v20 = '" + v20 + "', v21 = '" + v21 + "', v22 = '" 
                        + v22 + "',  v23 = '" + v23 + "', v24 = '" + v24 + "', v25= '" + v25 + "',  v26 = '" + v26 + "', v27 = '" + v27 + "', v28= '" + v28 + "',  v29 = '" + v29 + "', v30 = '" + v30 + "', q = '"
                        + q + "', q1= '" + q1 + "', q2 = '" + q2 + "', q3 = '" + q3 + "', q4= '" + q4 + "', q5 = '" + q5 + "', q6 = '" + q6 + "', q7 = '" 
                        + q7 + "', q8 = '" + q8+ "', q9 = '" + q9 + "', q10 = '" + q10 + "', q11 = '" + q11 + "', q12 = '" + q12 + "', q13 = '" + q13 + "', q14 = '" 
                        + q14 + "', q16 = '" + q16 + "', q17 = '" + q17 + "', q18= '" + q18 + "', q19 = '" + q19 + "', q20 = '" + q20 + "', q21 = '" + q21 + "', q22 = '" 
                        + q22 + "',  q23 = '" + q23 + "', q24 = '" + q24 + "', q25= '" + q25 + "', q26 = '" + q26 + "', q27 = '" + q27 + "', q28= '" + q28 + "',  q29 = '" + q29 + "', q30 = '" + q30 + "', t = '"
                        + t + "', t1= '" + t1 + "', t2 = '" + t2 + "', t3 = '" + t3 + "', t4= '" + t4 + "', t5 = '" + t5 + "', q6 = '" + t6 + "', t7 = '" 
                        + t7 + "', t8 = '" + t8+ "', t9 = '" + t9 + "', t10 = '" + t10 + "', t11 = '" + t11 + "', t12 = '" + t12 + "', t13 = '" + t13 + "', t14 = '" 
                        + t14 + "', t16 = '" + t16 + "', t17 = '" + t17 + "', t18= '" + t18 + "', t19 = '" + t19 + "', t20 = '" + t20 + "', t21 = '" + t21 + "', t22 = '" 
                        + t22 + "',  t23 = '" + t23 + "', t24 = '" + t24 + "', t25= '" + t25 + "', t26 = '" + t26 + "', t27 = '" + t27 + "', t28= '" + t28 + "',  t29 = '" + t29 + "', t30 = '" 
                        + t30 + "'" + " WHERE a_id= '" + ACCOUNT + "'";

                PreparedStatement statement = conn.prepareStatement(query); 
            
              
                      try{
                      // Accept Null excption from string to Integer
                     if ( dateOpen.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date1 = sdf.format(dateOpen.getDate());
                          
                            statement.setString(1, Date1);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select 'OPENING DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          statement.setNull(1, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
                      
                      
                      try{
                      // Accept Null excption from string to Integer
                     if ( dateClose.getDate() != null ) { 
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String  Date2 = sdf.format(dateClose.getDate());
                          
                            statement.setString(2, Date2);
                      
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select 'CLOSING DATE'!", "AGRI8 ASSIST DIALOG", JOptionPane.INFORMATION_MESSAGE);
                          statement.setNull(2, java.sql.Types.DATE);   
                       
                        }
                     
                      } catch (NullPointerException | NumberFormatException e) {
                          
                       }
               
                int i = statement.executeUpdate();
                
                if(i >= 1){

                    JOptionPane.showMessageDialog(this, "ACCOUNT: " + ACCOUNT + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                    this.dispose();
                    new ClassFinancialEmp().setVisible(true);
                }

            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.print("System or Database error: " + e);
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
       
            }
            
         }
        
    }//GEN-LAST:event_btnUpdateTActionPerformed

    private void btnDeleteTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTActionPerformed
        
            Connection conn = myConnection.getConnect();
          
     
        
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelA = (DefaultTableModel) tableAccounts.getModel();
            
            if(tableAccounts.getSelectedRowCount()==1) {
            
            int row = tableAccounts.getSelectedRow();
            String cell = tableAccounts.getModel().getValueAt(row, 0).toString();
            tblModelA.removeRow((int) row);
            String sql = "DELETE FROM tbl_account_report WHERE a_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                    
            } else {
                
                if(tableAccounts.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
       
        
        
    }//GEN-LAST:event_btnDeleteTActionPerformed

 
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassFinancialEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ACCOUNTID;
    private javax.swing.JTextField D;
    private javax.swing.JTextField FOUR3;
    private javax.swing.JTextField ONE3;
    private javax.swing.JTextField Q;
    private javax.swing.JTextField Q1;
    private javax.swing.JTextField Q10;
    private javax.swing.JTextField Q11;
    private javax.swing.JTextField Q12;
    private javax.swing.JTextField Q13;
    private javax.swing.JTextField Q14;
    private javax.swing.JTextField Q15;
    private javax.swing.JTextField Q16;
    private javax.swing.JTextField Q17;
    private javax.swing.JTextField Q18;
    private javax.swing.JTextField Q19;
    private javax.swing.JTextField Q2;
    private javax.swing.JTextField Q20;
    private javax.swing.JTextField Q21;
    private javax.swing.JTextField Q22;
    private javax.swing.JTextField Q23;
    private javax.swing.JTextField Q24;
    private javax.swing.JTextField Q25;
    private javax.swing.JTextField Q26;
    private javax.swing.JTextField Q27;
    private javax.swing.JTextField Q28;
    private javax.swing.JTextField Q29;
    private javax.swing.JTextField Q3;
    private javax.swing.JTextField Q30;
    private javax.swing.JTextField Q31;
    private javax.swing.JTextField Q4;
    private javax.swing.JTextField Q5;
    private javax.swing.JTextField Q6;
    private javax.swing.JTextField Q7;
    private javax.swing.JTextField Q8;
    private javax.swing.JTextField Q9;
    private javax.swing.JTextField T;
    private javax.swing.JTextField T1;
    private javax.swing.JTextField T10;
    private javax.swing.JTextField T11;
    private javax.swing.JTextField T12;
    private javax.swing.JTextField T13;
    private javax.swing.JTextField T14;
    private javax.swing.JTextField T15;
    private javax.swing.JTextField T16;
    private javax.swing.JTextField T17;
    private javax.swing.JTextField T18;
    private javax.swing.JTextField T19;
    private javax.swing.JTextField T2;
    private javax.swing.JTextField T20;
    private javax.swing.JTextField T21;
    private javax.swing.JTextField T22;
    private javax.swing.JTextField T23;
    private javax.swing.JTextField T24;
    private javax.swing.JTextField T25;
    private javax.swing.JTextField T26;
    private javax.swing.JTextField T27;
    private javax.swing.JTextField T28;
    private javax.swing.JTextField T29;
    private javax.swing.JTextField T3;
    private javax.swing.JTextField T30;
    private javax.swing.JTextField T31;
    private javax.swing.JTextField T4;
    private javax.swing.JTextField T5;
    private javax.swing.JTextField T6;
    private javax.swing.JTextField T7;
    private javax.swing.JTextField T8;
    private javax.swing.JTextField T9;
    private javax.swing.JTextField THREE3;
    private javax.swing.JTextField TWO3;
    private javax.swing.JTextField UIF;
    private javax.swing.JTextField V;
    private javax.swing.JTextField V1;
    private javax.swing.JTextField V10;
    private javax.swing.JTextField V11;
    private javax.swing.JTextField V12;
    private javax.swing.JTextField V13;
    private javax.swing.JTextField V14;
    private javax.swing.JTextField V16;
    private javax.swing.JTextField V17;
    private javax.swing.JTextField V18;
    private javax.swing.JTextField V19;
    private javax.swing.JTextField V2;
    private javax.swing.JTextField V20;
    private javax.swing.JTextField V21;
    private javax.swing.JTextField V22;
    private javax.swing.JTextField V23;
    private javax.swing.JTextField V24;
    private javax.swing.JTextField V25;
    private javax.swing.JTextField V26;
    private javax.swing.JTextField V27;
    private javax.swing.JTextField V28;
    private javax.swing.JTextField V29;
    private javax.swing.JTextField V3;
    private javax.swing.JTextField V30;
    private javax.swing.JTextField V4;
    private javax.swing.JTextField V5;
    private javax.swing.JTextField V6;
    private javax.swing.JTextField V7;
    private javax.swing.JTextField V8;
    private javax.swing.JTextField V9;
    private javax.swing.JTextField a;
    private javax.swing.JTextField aa;
    private javax.swing.JTextField b;
    private javax.swing.JTextField bb;
    private javax.swing.JTextField bsid;
    private javax.swing.JButton btnAddC;
    private javax.swing.JToggleButton btnChangeVat;
    private javax.swing.JToggleButton btnChangeVat1;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearT;
    private javax.swing.JButton btnDeleteB;
    private javax.swing.JButton btnDeleteC;
    private javax.swing.JButton btnDeleteT;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveT;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchT;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateT;
    private javax.swing.JButton buttonAddSale;
    private javax.swing.JButton buttonAddSale1;
    private javax.swing.JButton buttonAnimal;
    private javax.swing.JButton buttonClearC;
    private javax.swing.JButton buttonClearE;
    private javax.swing.JButton buttonClearL;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonDeleteC;
    private javax.swing.JButton buttonDeleteE;
    private javax.swing.JButton buttonDeleteL;
    private javax.swing.JButton buttonDeleteSE;
    private javax.swing.JButton buttonFeed;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonSaveC;
    private javax.swing.JButton buttonSaveE;
    private javax.swing.JButton buttonSaveL;
    private javax.swing.JButton buttonSearchC;
    private javax.swing.JButton buttonSearchE;
    private javax.swing.JButton buttonSearchL;
    private javax.swing.JButton buttonStock1;
    private javax.swing.JToggleButton buttonUIF;
    private javax.swing.JButton buttonUpdateC;
    private javax.swing.JButton buttonUpdateE;
    private javax.swing.JButton buttonUpdateL;
    private javax.swing.JTextField c;
    private javax.swing.JTextField cc;
    private javax.swing.JComboBox<String> cfour;
    private javax.swing.JComboBox<String> cfour1;
    private javax.swing.JTextField cone;
    private javax.swing.JTextField cone1;
    private javax.swing.JTextField cqty;
    private javax.swing.JTextField cqty1;
    private javax.swing.JTextField csubtotal;
    private javax.swing.JTextField csubtotal1;
    private javax.swing.JTextField cthree;
    private javax.swing.JTextField cthree1;
    private javax.swing.JTextField ctotal;
    private javax.swing.JTextField ctotal1;
    private com.toedter.calendar.JDateChooser ctwoDate;
    private com.toedter.calendar.JDateChooser ctwoDate1;
    private javax.swing.JTextField cunitprice;
    private javax.swing.JTextField cunitprice1;
    private javax.swing.JTextField cvat;
    private javax.swing.JTextField cvat1;
    private javax.swing.JTextField d;
    private com.toedter.calendar.JDateChooser dateClose;
    private com.toedter.calendar.JDateChooser dateOpen;
    private com.toedter.calendar.JDateChooser dateend;
    private com.toedter.calendar.JDateChooser datestart;
    private javax.swing.JTextField dd;
    private javax.swing.JTextField e;
    private javax.swing.JTextField ee;
    private javax.swing.JComboBox<String> eeight;
    private javax.swing.JTextField eeleven;
    private javax.swing.JTextField efive;
    private com.toedter.calendar.JDateChooser efour;
    private javax.swing.JTextField eight;
    private javax.swing.JTextField emailc;
    private com.toedter.calendar.JDateChooser enine;
    private javax.swing.JTextField eone;
    private javax.swing.JTextField eseven;
    private javax.swing.JTextField esixs;
    private javax.swing.JComboBox<String> eten;
    private javax.swing.JTextField ethree;
    private javax.swing.JTextField etwelve;
    private javax.swing.JTextField etwo;
    private javax.swing.JTextField f;
    private javax.swing.JTextField ff;
    private javax.swing.JComboBox<String> filterCategory;
    private javax.swing.JComboBox<String> filterType;
    private javax.swing.JTextField five;
    private javax.swing.JTextField four;
    private javax.swing.JTextField g;
    private javax.swing.JTextField gg;
    private javax.swing.JTextField h;
    private javax.swing.JTextField hh;
    private javax.swing.JTextField i;
    private javax.swing.JTextField ii;
    private javax.swing.JTextField j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
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
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jj;
    private javax.swing.JTextField k;
    private javax.swing.JTextField kk;
    private javax.swing.JTextField l;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelName;
    private javax.swing.JTextField leight;
    private javax.swing.JTextField leleven;
    private javax.swing.JComboBox<String> lfive;
    private javax.swing.JComboBox<String> lfour;
    private javax.swing.JTextField ll;
    private javax.swing.JTextField lnine;
    private javax.swing.JTextField lone;
    private javax.swing.JTextField lseven;
    private javax.swing.JTextField lsixs;
    private javax.swing.JTextField lten;
    private javax.swing.JTextField lthirteen;
    private javax.swing.JTextField lthree;
    private javax.swing.JTextField ltwelve;
    private javax.swing.JTextField ltwo;
    private javax.swing.JTextField m;
    private javax.swing.JTextField mm;
    private javax.swing.JTextField n;
    private javax.swing.JTextField newVat;
    private javax.swing.JTextField newVat1;
    private javax.swing.JTextField nine;
    private javax.swing.JTextField nn;
    private javax.swing.JTextField o;
    private javax.swing.JTextField one;
    private javax.swing.JTextField oo;
    private javax.swing.JTextField p;
    private javax.swing.JPanel panelSide;
    private javax.swing.JTextField pp;
    private javax.swing.JRadioButton radioNoVat;
    private javax.swing.JRadioButton radioNoVat1;
    private javax.swing.JComboBox<String> seven;
    private javax.swing.JTextField sixs;
    private javax.swing.JTabbedPane tabFinancial;
    private javax.swing.JTable tableAccounts;
    private javax.swing.JTable tableBalance;
    private javax.swing.JTable tableContacts;
    private javax.swing.JTable tableEmp;
    private javax.swing.JTable tableLabour;
    private javax.swing.JTable tableSE;
    private javax.swing.JTextField ten;
    private javax.swing.JTextField three;
    private javax.swing.JTextField two;
    // End of variables declaration//GEN-END:variables
}
