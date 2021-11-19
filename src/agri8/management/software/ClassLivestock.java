package agri8.management.software;


import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import net.proteanit.sql.DbUtils;

public class ClassLivestock extends javax.swing.JFrame {
   
     MySQLConnect myConnection;
    
    public ClassLivestock() {
        
        myConnection = new MySQLConnect();
        icon();
        initComponents();
        tabCattle.setBackground(new Color(0,0,0,100));
        jPanel2.setBackground(new Color(0,0,0,100));
        jPanel3.setBackground(new Color(0,0,0,100));
      
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        UpdateButtonCC();
        UpdateButtonK();
        UpdateButtonS();
        
        // ******************** SHEEP AND LAMB SECTION **********************
        
        sheepID();
        SheepHerdTable();
        SheepMatingTable();
        Lambpaddock();
        SheepHerdgroup();
        LambstextfieldEditable();
        SheepWeanerTable();
        SheepHealthTable();
        LambHerdTable();
        WeanerMainHerdTable();
        
         // ******************** GOAT AND KID SECTION **********************
        
        goatID();
        GoatWeanerTable();
        GoatHealthTable();
        KidstextfieldEditable();
        GoatHerdTable(); 
        GoatMatingTable();
        WeanerMainTable();
        KidsMainTable();
        
        
         // ******************** CATTL AND CALF SECTION **********************
        
        
        LivestockHerdTable();
        CalfHerdTable();
        WeanerHerdTable();
        IndividualMatingTable();
        AnimalHealthTable();
        CalfstextfieldEditable();
        WeanerTable();
        paddock();
        herdcalves();
     
   
    }
    
     private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
     
     private void paddock() {
               try {
                 
              Connection conn = myConnection.getConnect();
             
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     ccPaddock.addItem(rs.getString("pname"));
                     filterPaddockSheep.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
     
     private void herdcalves() {
         
              try {
                 
               Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype");
                 
                 while(rs.next()){
                   
                     ccHerdGroup.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
   
     
             // *************** Resize Image to Update **********************
       String photopath1 = null;
    //javax.swing.ImageIcon to resize image
    
    public ImageIcon resizeImage1(String photopath, byte[] photo) {
        
       ImageIcon myPhoto = null;
       if(photopath != null){
           myPhoto = new ImageIcon(photopath);
       } else {
           myPhoto = new ImageIcon(photo);
       }
       
       Image img = myPhoto.getImage();
       Image img1 = img.getScaledInstance(labelImage1.getWidth(), labelImage1.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ph = new ImageIcon(img1);
       return ph;
           
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
       Image img1 = img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ph = new ImageIcon(img1);
       return ph;
           
    }
      

     
     // ******************************************* SHEEP AND LAMB SECTION ************************************************

    
     
          //*************** Sheep Health History Table *********************
     // Excutes with view button ' Add / edit Cattle
     
     private void SheepHealthTable() {
  
          Connection conn = myConnection.getConnect();
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT sv_id as 'Tag ID',  sv_name as 'Name', sv_dob as 'DOB', sv_disease as 'Disease', sv_vacc as 'Vaccination', sv_app as 'Application', sv_dosage as 'Dosage', sv_treatementDate as 'Treatement Date', sv_nexttreatment as 'Next Treatement', sv_employee as 'Employee', sv_note as 'Notes' FROM tbl_vacc_sheep;";
               ResultSet rs = stm.executeQuery(sql);
               sheepTableHealth.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
     
         //Sheep Mating Tab
    private void SheepHealthHistoryTable() {
        
        Connection conn = myConnection.getConnect();
       String sheepID = (String) TagIDSAdd.getSelectedItem();     
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT sv_id as 'Tag ID',  sv_name as 'Name', sv_dob as 'DOB', sv_disease as 'Disease', sv_vacc as 'Vaccination', sv_app as 'Application', sv_dosage as 'Dosage', sv_treatementDate as 'Treatement Date', sv_nexttreatment as 'Next Treatement', sv_employee as 'Employee', sv_note as 'Notes' FROM tbl_vacc_sheep  WHERE sv_id = '" + sheepID + "'";
          ResultSet rs = stm.executeQuery(sql);
          tableSheepHealthHistory.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        
              conn.close();

        } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                  //  JOptionPane.showMessageDialog(null, " Health History Group - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }
     
     private void matingSheepMain() {
        Connection conn = myConnection.getConnect();
               
                 String searchMating = (String) TagIDSAdd.getSelectedItem();
          
                            
                try {

                    //Establish / Open Connection
                   
                    String sql = "SELECT sm_ram, sm_method, sm_ramsin FROM tbl_mating_sheep WHERE sm_tag_id =? ";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, searchMating);

                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    while(rs.next()) {

                        SFIFTHTEEN.setText(rs.getString("sm_ramsin"));               // RAMS in
                        SSIXSTEEN.setText(rs.getString("sm_method"));                // Method
                        SSEVENTEEN.setText(rs.getString("sm_ram"));                 // RAM ID
                    }
                        
                      conn.close();
            
                } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                //    JOptionPane.showMessageDialog(null, "Mating Textfield: System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

               }   
    }
     
     private void SheepInfoMain() {
        Connection conn = myConnection.getConnect();
               
                 String searchSheeps = (String) TagIDSAdd.getSelectedItem();
          
                            
                try {

                    //Establish / Open Connection
                   
                    String sql = "SELECT s_ram1stgen, s_ewe1stgen FROM tbl_sheep_info WHERE s_tag_id = ?";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, searchSheeps);

                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    while(rs.next()) {

        
                                     
                        STWENTYONE.setText(rs.getString("s_ram1stgen"));               
                        STWENTYTWO.setText(rs.getString("s_ewe1stgen"));               
                          
                    }
                        
                      conn.close();
            
                } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
        //            JOptionPane.showMessageDialog(null, "Add Ewe / Lamb Info: System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }   
    }
     
      private void SheepWeanerTable() {
         
           Connection conn = myConnection.getConnect();
        
            try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_weaner_lambs ORDER BY sw_id ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String swid = rs.getString("sw_id");
              String swname = rs.getString("sw_name");
              String swgender = rs.getString("sw_gender");
              String swpaddock = rs.getString("sw_paddock");
              String swstud = rs.getString("sw_studcom");
              String swherd = rs.getString("sw_herdtype");
              String swtype = rs.getString("sw_type");
              String swweanweight = rs.getString("sw_weanweight");
              String swweandate = String.valueOf(sdf.format(rs.getDate("sw_weandate")));
              String swsalesmate = String.valueOf(sdf.format(rs.getDate("sw_salemate"))); 
              String swram = rs.getString("sw_ram");
              String swewe = rs.getString("sw_ewe");
              
              //String array to store data into jTable
              String tblDataSW[] = {swid, swname, swgender, swpaddock, swstud, swherd, swtype, swweanweight, swweandate, swsalesmate, swram, swewe};
              DefaultTableModel tblModelSW = (DefaultTableModel)tableWeanerSheep.getModel();
              
              //Add string array data into table
              tblModelSW.addRow(tblDataSW);
              
          }  
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Weaner Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }  
      }     
   
 
      private void Lambpaddock() {
           // Populate JCombobox in Paddock
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock ORDER BY pname ASC");
                 
                 while(rs.next()){
                     
                     sPaddock.addItem(rs.getString("pname"));
                     gPaddock.addItem(rs.getString("pname"));
                    
                } 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, " Paddock System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
      
      private void LambIDHealth() {
      
        
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s_tag_id FROM tbl_lamb_info");
                 
                 while(rs.next()){
                     
                     tagSearchSheepHealth.addItem(rs.getString("s_tag_id"));
                     filterTagSheep.addItem(rs.getString("s_tag_id"));
                } 
                 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                tagSearchSheepHealth.requestFocus(false);   
       
            } 
    
      }
      
         
      private void SheepWeanerIDHealth() {
      
        
         try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT sw_id FROM tbl_weaner_lambs");
                 
                 while(rs.next()){
                     
                     tagSearchSheepHealth.addItem(rs.getString("sw_id"));
                     filterTagSheep.addItem(rs.getString("sw_id"));
                    
                } 
                 
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                tagSearchSheepHealth.requestFocus(false);   
       
            } 
    
      }
      
      
       private void SheepHerdgroup() {
         
           try {
                 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                     
                     sHerdGroup.addItem(rs.getString("herdtype"));
                     gHerdGroup.addItem(rs.getString("herdtype"));
                    
                } 
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
     }
       
       
      private void sheepID() {
         
                // Populate Tag ID Combobox
   
             Connection conn = myConnection.getConnect();
        try {

      
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT s_tag_id FROM tbl_sheep_info");

        while(rs.next()){

            TagIDSAdd.addItem(rs.getString("s_tag_id"));
            filterTagSheep.addItem(rs.getString("s_tag_id"));
        }
        conn.close();
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "Sheep ID Add / Edit Sheep - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
         
     }
      
      private void SheepweanerID() {
           Connection conn = myConnection.getConnect();
        
     try {
          Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT sw_id FROM tbl_weaner_lambs ORDER BY sw_id ASC");
                 
                 while(rs.next()){
                     
                    searchWeanerSheep.addItem(rs.getString("sw_id"));
                    
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            } 
     }  
      
         //*************** Lamb Health History Table *********************
     // Excutes with view button ' Add / edit Sheep or Lambs Tab
     
     private void LambHealthTable() {
         
           Connection conn = myConnection.getConnect();
           String lambID = (String) searchLamb.getSelectedItem();        
           searchLamb.requestFocus();
                                             
                try {

                         Statement stm = conn.createStatement();
               String sql = "SELECT sv_id as 'Tag ID',  sv_name as 'Name', sv_dob as 'DOB', sv_disease as 'Disease', sv_vacc as 'Vaccination', sv_app as 'Application', sv_dosage as 'Dosage', sv_treatementDate as 'Treatement Date', sv_nexttreatment as 'Next Treatement', sv_employee as 'Employee', sv_note as 'Notes' FROM tbl_vacc_sheep WHERE sv_id = '" + lambID + "'";
               ResultSet rs = stm.executeQuery(sql);
               tableLambHealth.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     
     }
      
       // Livestock Table
     private void SheepHerdTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_sheep_info ORDER BY s_tag_id ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              String stagid = null;
              String sname = null;
              String sbreed = null;
              String sdob = null;
              String sstudcom = null;
              String sgender = null;
              String spaddock = null;
              String sherdtype = null;
              String sbirthweight = null;
              String sweanweight = null;
              String sweandate = null;
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try {
              stagid = rs.getString("s_tag_id");
              sname = rs.getString("s_name");
              sbreed = rs.getString("s_breed");
              sdob = String.valueOf(sdf.format(rs.getDate("s_dob")));
              sstudcom = rs.getString("s_studcom");
              sgender = rs.getString("s_gender");
              spaddock = rs.getString("s_paddock");
              sherdtype = rs.getString("s_herdtype");
              sbirthweight = String.valueOf(rs.getInt("s_birthweight"));
              sweanweight = String.valueOf(rs.getInt("s_weanweight"));
              sweandate = String.valueOf(sdf.format(rs.getDate("s_weandate")));
            
             } catch (NumberFormatException | NullPointerException e) {
                 
             }
              //String array to store data into jTable
              String tblDataS[] = {stagid, sname, sbreed, sdob, sstudcom, sgender, spaddock, sherdtype, sbirthweight, sweanweight, sweandate};
              DefaultTableModel tblModelS = (DefaultTableModel)tableSheepMain.getModel();
              
              //Add string array data into table
              tblModelS.addRow(tblDataS);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Sheep Main Page Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
     
        // Livestock Table
     private void LambHerdTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_lamb_info";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              String stagid = null;
              String sname = null;
              String sbreed = null;
              String sdob = null;
              String sstudcom = null;
              String sgender = null;
              String spaddock = null;
              String sherdtype = null;
              String sbirthweight = null;
              String sweanweight = null;
              String sweandate = null;
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try {
              stagid = rs.getString("s_tag_id");
              sname = rs.getString("s_name");
              sbreed = rs.getString("s_breed");
              sdob = String.valueOf(sdf.format(rs.getDate("s_dob")));
              sstudcom = rs.getString("s_studcom");
              sgender = rs.getString("s_gender");
              spaddock = rs.getString("s_paddock");
              sherdtype = rs.getString("s_herdgroup");
              sbirthweight = String.valueOf(rs.getInt("s_birthweight"));
              sweanweight = String.valueOf(rs.getInt("s_weanweight"));
              sweandate = String.valueOf(sdf.format(rs.getDate("s_weandate")));
            
             } catch (NumberFormatException | NullPointerException e) {
                 
             }
              //String array to store data into jTable
              String tblDataS[] = {stagid, sname, sbreed, sdob, sstudcom, sgender, spaddock, sherdtype, sbirthweight, sweanweight, sweandate};
              DefaultTableModel tblModelS = (DefaultTableModel)tableSheepMain.getModel();
              
              //Add string array data into table
              tblModelS.addRow(tblDataS);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Sheep Main Page Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
     
        // Livestock Table
     private void WeanerMainHerdTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_weaner_lambs";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              String stagid = null;
              String sname = null;
              String sbreed = null;
              String sdob = null;
              String sstudcom = null;
              String sgender = null;
              String spaddock = null;
              String sherdtype = null;
              String sbirthweight = null;
              String sweanweight = null;
              String sweandate = null;
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try {
              stagid = rs.getString("sw_id");
              sname = rs.getString("sw_name");
              sbreed = rs.getString("sw_breed");
              sdob = String.valueOf(sdf.format(rs.getDate("sw_dob")));
              sstudcom = rs.getString("sw_studcom");
              sgender = rs.getString("sw_gender");
              spaddock = rs.getString("sw_paddock");
              sherdtype = rs.getString("sw_herdtype");
              sbirthweight = String.valueOf(rs.getInt("sw_birthweight"));
              sweanweight = String.valueOf(rs.getInt("sw_weanweight"));
              sweandate = String.valueOf(sdf.format(rs.getDate("sw_weandate")));
            
             } catch (NumberFormatException | NullPointerException e) {
                 
             }
              //String array to store data into jTable
              String tblDataS[] = {stagid, sname, sbreed, sdob, sstudcom, sgender, spaddock, sherdtype, sbirthweight, sweanweight, sweandate};
              DefaultTableModel tblModelS = (DefaultTableModel)tableSheepMain.getModel();
              
              //Add string array data into table
              tblModelS.addRow(tblDataS);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Sheep Main Page Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
     
       private void SheepMatingTable() {
  
          Connection conn = myConnection.getConnect();
      
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT sm_tag_id as 'Tag ID',  sm_name as 'Name', sm_herdgroup as 'Herd Group', sm_paddock as 'Paddock', sm_stud as 'Stud/Com', sm_ram as 'Mating Ram', sm_method as 'Method', sm_ramsin as 'Rams-in', sm_ramsout as 'Rams-out', sm_k_start as 'Lambing Start', sm_l_ends as 'Lambing Ends', sm_nextmating as 'Next Mating', sm_weaningdate as 'Weaning Date' FROM tbl_mating_sheep;";
               ResultSet rs = stm.executeQuery(sql);
               tableMatingSheeps.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Sheep Mating table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
  
       //Sheep Mating Tab
    private void MatingTable() {
        
        Connection conn = myConnection.getConnect();
       String sheepID = (String) TagIDSAdd.getSelectedItem();     
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_mating_sheep WHERE sm_tag_id = '" + sheepID + "'";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String smid = rs.getString("sm_tag_id");
              String smname = rs.getString("sm_name");
              String smherdgroup = rs.getString("sm_herdgroup");
              String smpaddock = rs.getString("sm_paddock");
              String smstud = rs.getString("sm_stud");
              String smram = rs.getString("sm_ram");
              String smmethod = rs.getString("sm_method");
              String smramsin = rs.getString("sm_ramsin");
              String smramsout = rs.getString("sm_ramsout");
              String smkstart = rs.getString("sm_k_start");
              String smlend = rs.getString("sm_l_ends");      
              String smnextmating = String.valueOf(sdf.format(rs.getDate("sm_nextmating")));
              String smweandate = String.valueOf(sdf.format(rs.getDate("sm_weaningdate")));
                      
              //String array to store data into jTable
              String tblData[] = {smid, smname, smherdgroup, smpaddock, smstud, smram, smmethod,  smramsin, smramsout, smkstart, smlend, smnextmating, smweandate};
              DefaultTableModel tblModelM = (DefaultTableModel)tableMatingHistory.getModel();
              
              //Add string array data into table
              tblModelM.addRow(tblData);
             
          }        
              conn.close();

        } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                 //   JOptionPane.showMessageDialog(null, " Mating Group - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }            
    }
       
        private void LambstextfieldEditable(){
         // Set textfields not editable
         
         sTag.setEditable(false);
         sName.setEditable(false);
         sBreed.setEnabled(false);
         sDob.setEnabled(false);
         sStudCom.setEnabled(false);
         sGender.setEnabled(false);
         sBirthWeight.setEditable(false);
         sPaddock.setEnabled(false);
         sHerdGroup.setEnabled(false);
         sWeanWeight.setEditable(false);
         sWeanDate.setEnabled(false);
         sRamID.setEditable(false);
         sEweID.setEditable(false);
         sBirthStatues.setEnabled(false);
         sHealthStatues.setEnabled(false);
         sHornStatues.setEnabled(false);
         
         ((JTextFieldDateEditor)sDob.getDateEditor()).setDisabledTextColor(Color.darkGray); // Change colour of JDatechooser text
        ((JTextFieldDateEditor)sWeanDate.getDateEditor()).setDisabledTextColor(Color.darkGray); 
         UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
     }
     
       
     
     
       // ******************************************* SHEEP AND LAMB SECTION ************************************************
       
       
       
       
       // ******************************************* GOAT AND KID SECTION ************************************************
       
     
     private void goatID() {
         
                // Populate Tag ID Combobox
   
             Connection conn = myConnection.getConnect();
        try {

      
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT g_tag_id FROM tbl_goat_info");

        while(rs.next()){

            filterTagGoats.addItem(rs.getString("g_tag_id"));
            filterTagG.addItem(rs.getString("g_tag_id"));
        }
        conn.close();
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "Sheep ID Add / Edit Sheep - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
         
     }
     
      private void kidsID() {
         
                // Populate Tag ID Combobox
   
             Connection conn = myConnection.getConnect();
        try {

      
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT g_tag_id FROM tbl_kid_info");

        while(rs.next()){

            filterTagG.addItem(rs.getString("g_tag_id"));
        }
        conn.close();
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "Sheep ID Add / Edit Sheep - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
         
     }
     
          private void goatWeanerID() {
         
                // Populate Tag ID Combobox
   
             Connection conn = myConnection.getConnect();
        try {

      
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT gw_id FROM tbl_weaner_kids");

        while(rs.next()){

            filterTagG.addItem(rs.getString("gw_id"));
        }
        conn.close();
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "Sheep ID Add / Edit Sheep - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
         
     }
     
      private void matingGoatsMain() {
        Connection conn = myConnection.getConnect();
               
                 String searchMating = (String) filterTagGoats.getSelectedItem();
          
                            
                try {

                    //Establish / Open Connection
                   
                    String sql = "SELECT gm_ram, gm_method, gm_ramsin FROM tbl_mating_goats WHERE gm_tag_id =? ";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, searchMating);

                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    while(rs.next()) {

                        GFIFTHTEEN.setText(rs.getString("gm_ramsin"));               // RAMS in
                        GSIXSTEEN.setText(rs.getString("gm_method"));                // Method
                        GSEVENTEEN.setText(rs.getString("gm_ram"));                 // RAM ID
                    }
                        
                      conn.close();
            
                } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Mating Textfield: System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

               }   
    }
     
     private void GoatInfoMain() {
        Connection conn = myConnection.getConnect();
               
                 String searchGoatMain = (String) filterTagGoats.getSelectedItem();
          
                            
                try {

                    //Establish / Open Connection
                   
                    String sql = "SELECT  g_ram1stgen, g_ewe1stgen FROM tbl_goat_info WHERE g_tag_id = ?";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, searchGoatMain);

                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    while(rs.next()) {
               
                        GTWENTYONE.setText(rs.getString("g_ram1stgen"));               
                        GTWENTYTWO.setText(rs.getString("g_ewe1stgen"));               
                          
                    }
                        
                      conn.close();
            
                } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Add Ewe / Lamb Info: System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }   
    }    
          
          
     // Livestock Table
     private void GoatHerdTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_goat_info";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              String gtagid = null;
              String gname = null;
              String gbreed = null;
              String gdob = null;
              String gstudcom = null;
              String ggender = null;
              String gpaddock = null;
              String gherdtype = null;
              String gbirthweight = null;
              String gweanweight = null;
              String gweandate = null;
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try {
              gtagid = rs.getString("g_tag_id");
              gname = rs.getString("g_name");
              gbreed = rs.getString("g_breed");
              gdob = String.valueOf(sdf.format(rs.getDate("g_dob")));
              gstudcom = rs.getString("g_studcom");
              ggender = rs.getString("g_gender");
              gpaddock = rs.getString("g_paddock");
              gherdtype = rs.getString("g_herdtype");
              gbirthweight = String.valueOf(rs.getInt("g_birthweight"));
              gweanweight = String.valueOf(rs.getInt("g_weanweight"));
              gweandate = String.valueOf(sdf.format(rs.getDate("g_weandate")));
            
             } catch (NumberFormatException | NullPointerException e) {
                 
             }
              //String array to store data into jTable
              String tblDataG[] = {gtagid, gname, gbreed, gdob, gstudcom, ggender, gpaddock, gherdtype, gbirthweight, gweanweight, gweandate};
              DefaultTableModel tblModelG = (DefaultTableModel)tableGoats.getModel();
              
              //Add string array data into table
              tblModelG.addRow(tblDataG);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Goat herd table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
     
     // Livestock Table
     private void WeanerMainTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_weaner_kids";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              String gtagid = null;
              String gname = null;
              String gbreed = null;
              String gdob = null;
              String gstudcom = null;
              String ggender = null;
              String gpaddock = null;
              String gherdtype = null;
              String gbirthweight = null;
              String gweanweight = null;
              String gweandate = null;
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try {
              gtagid = rs.getString("gw_id");
              gname = rs.getString("gw_name");
              gbreed = rs.getString("gw_breed");
              gdob = String.valueOf(sdf.format(rs.getDate("gw_dob")));
              gstudcom = rs.getString("gw_studcom");
              ggender = rs.getString("gw_gender");
              gpaddock = rs.getString("gw_paddock");
              gherdtype = rs.getString("gw_herdtype");
              gbirthweight = String.valueOf(rs.getInt("gw_birthweight"));
              gweanweight = String.valueOf(rs.getInt("gw_weanweight"));
              gweandate = String.valueOf(sdf.format(rs.getDate("gw_weandate")));
            
             } catch (NumberFormatException | NullPointerException e) {
                 
             }
              //String array to store data into jTable
              String tblDataG[] = {gtagid, gname, gbreed, gdob, gstudcom, ggender, gpaddock, gherdtype, gbirthweight, gweanweight, gweandate};
              DefaultTableModel tblModelG = (DefaultTableModel)tableGoats.getModel();
              
              //Add string array data into table
              tblModelG.addRow(tblDataG);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Goat herd table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
     
      // Livestock Table
     private void KidsMainTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_kid_info";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              String gtagid = null;
              String gname = null;
              String gbreed = null;
              String gdob = null;
              String gstudcom = null;
              String ggender = null;
              String gpaddock = null;
              String gherdtype = null;
              String gbirthweight = null;
              String gweanweight = null;
              String gweandate = null;
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try {
              gtagid = rs.getString("g_tag_id");
              gname = rs.getString("g_name");
              gbreed = rs.getString("g_breed");
              gdob = String.valueOf(sdf.format(rs.getDate("g_dob")));
              gstudcom = rs.getString("g_studcom");
              ggender = rs.getString("g_gender");
              gpaddock = rs.getString("g_paddock");
              gherdtype = rs.getString("g_herdgroup");
              gbirthweight = String.valueOf(rs.getInt("g_birthweight"));
              gweanweight = String.valueOf(rs.getInt("g_weanweight"));
              gweandate = String.valueOf(sdf.format(rs.getDate("g_weandate")));
            
             } catch (NumberFormatException | NullPointerException e) {
                 
             }
              //String array to store data into jTable
              String tblDataG[] = {gtagid, gname, gbreed, gdob, gstudcom, ggender, gpaddock, gherdtype, gbirthweight, gweanweight, gweandate};
              DefaultTableModel tblModelG = (DefaultTableModel)tableGoats.getModel();
              
              //Add string array data into table
              tblModelG.addRow(tblDataG);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Goat herd table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
     
     
           
     
         //*************** GoAT Health History Table *********************
     // Excutes with view button ' Add / edit Cattle
     
     private void GoatWeanerTable() {
  
          Connection conn = myConnection.getConnect();
    
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT gw_id as 'Tag ID',  gw_name as 'Name', gw_gender as 'Gender', gw_paddock as 'Paddock', gw_studcom as 'Stud / Com', gw_herdtype as 'Herd Type', gw_type as 'Weaner Type', gw_weanweight as 'Weight', gw_weandate as 'Wean Date', gw_salemate as 'Sale / Mate', gw_ram as 'Ram ID', gw_ewe as 'Ewe ID' FROM tbl_weaner_kids";
               ResultSet rs = stm.executeQuery(sql);
               tableWeanerGoats.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
     
        private void GoatMatingTable() {
  
          Connection conn = myConnection.getConnect();
      
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT gm_tag_id as 'Tag ID',  gm_name as 'Name', gm_herdgroup as 'Herd Group', gm_paddock as 'Paddock', gm_stud as 'Stud/Com', gm_ram as 'Mating Ram', gm_method as 'Method', gm_ramsin as 'Rams-in', gm_ramsout as 'Rams-out', gm_k_start as 'Lambing Start', gm_l_ends as 'Lambing Ends', gm_nextmating as 'Next Mating', gm_weaningdate as 'Weaning Date' FROM tbl_mating_goats";
               ResultSet rs = stm.executeQuery(sql);
               tableMatingGoats.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep Mating table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
        
              private void GoatMatingTableMain() {
  
          Connection conn = myConnection.getConnect();
          String goatTag = (String) filterTagGoats.getSelectedItem();
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT gm_tag_id as 'Tag ID', gm_name as 'Name', gm_herdgroup as 'Herd Group', gm_paddock as 'Paddock', gm_stud as 'Stud/Com', gm_ram as 'Mating Ram', gm_method as 'Method', gm_ramsin as 'Rams-in', gm_ramsout as 'Rams-out', gm_k_start as 'Lambing Start', gm_l_ends as 'Lambing Ends', gm_nextmating as 'Next Mating', gm_weaningdate as 'Weaning Date' FROM tbl_mating_goats WHERE gm_tag_id = '" + goatTag + "'";
               ResultSet rs = stm.executeQuery(sql);
               tableGoatLamHistory.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep Mating table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
     
     
          //*************** GoAT Health History Table *********************
     // Excutes with view button ' Add / edit Cattle
     
     private void GoatHealthTable() {
  
          Connection conn = myConnection.getConnect();
    
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT gv_id as 'Tag ID',  gv_name as 'Name', gv_dob as 'DOB', gv_disease as 'Disease', gv_vacc as 'Vaccination', gv_app as 'Application', gv_dosage as 'Dosage', gv_treatementDate as 'Treatement Date', gv_nexttreatment as 'Next Treatement', gv_employee as 'Employee', gv_note as 'Notes' FROM tbl_vacc_goats;";
               ResultSet rs = stm.executeQuery(sql);
               tableAnimalHealthGoatsH.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
     
         private void KidHealthTable() {
  
          Connection conn = myConnection.getConnect();
          String SearchKid = (String) searchKid.getSelectedItem();
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT gv_id as 'Tag ID',  gv_name as 'Name', gv_dob as 'DOB', gv_disease as 'Disease', gv_vacc as 'Vaccination', gv_app as 'Application', gv_dosage as 'Dosage', gv_treatementDate as 'Treatement Date', gv_nexttreatment as 'Next Treatement', gv_employee as 'Employee', gv_note as 'Notes' FROM tbl_vacc_goats WHERE gv_id = '" + SearchKid + "'";
               ResultSet rs = stm.executeQuery(sql);
               tablegoatHealth.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
      
         private void GoatsHealthTableMain() {
  
          Connection conn = myConnection.getConnect();
          String SearchKid = (String) filterTagGoats.getSelectedItem();
 
        try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT gv_id as 'Tag ID',  gv_name as 'Name', gv_dob as 'DOB', gv_disease as 'Disease', gv_vacc as 'Vaccination', gv_app as 'Application', gv_dosage as 'Dosage', gv_treatementDate as 'Treatement Date', gv_nexttreatment as 'Next Treatement', gv_employee as 'Employee', gv_note as 'Notes' FROM tbl_vacc_goats WHERE gv_id = '" + SearchKid + "'";
               ResultSet rs = stm.executeQuery(sql);
               tableGoatHealthHistory.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                 
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Sheep table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
     
        private void KidstextfieldEditable(){
         // Set textfields not editable
         
         gTag.setEditable(false);
         gName.setEditable(false);
         gBreed.setEnabled(false);
         gDob.setEnabled(false);
         gStudCom.setEnabled(false);
         gGender.setEnabled(false);
         gBirthWeight.setEditable(false);
         gPaddock.setEnabled(false);
         gHerdGroup.setEnabled(false);
         gWeanWeight.setEditable(false);
         gWeanDate.setEnabled(false);
         gRamID.setEditable(false);
         gEweID.setEditable(false);
         gBirthStatues.setEnabled(false);
         gHealthStatues.setEnabled(false);
         gHornStatues.setEnabled(false);
         
         ((JTextFieldDateEditor)gDob.getDateEditor()).setDisabledTextColor(Color.darkGray); // Change colour of JDatechooser text
        ((JTextFieldDateEditor)gWeanDate.getDateEditor()).setDisabledTextColor(Color.darkGray); 
         UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
     }
     
    
  
     // ******************* CATTLE AND CALF SECTION ************************
     
    
     private void cattleID() {
         
         // Populate Tag ID Combobox
   
             Connection conn = myConnection.getConnect();
        try {

      
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT c_tag_id FROM tbl_cattle_info ORDER BY c_tag_id ASC");

        while(rs.next()){

            filterCattleTag.addItem(rs.getString("c_tag_id"));
        }
        conn.close();
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
         
     }
     
     private void calfID() {
           //Populate Jcomobox with Calf ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT cc_tag_id FROM tbl_calf_info ORDER BY cc_tag_id ASC");

            while(rs.next()){

                filterCattleTag.addItem(rs.getString("cc_tag_id"));
            }
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
     }
     
     private void weanerID() {
           Connection conn = myConnection.getConnect();
        
     try {
          Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT w_id FROM tbl_weaner_info ORDER BY w_id ASC");
                 
                 while(rs.next()){
                     
                    filterCattleTag.addItem(rs.getString("w_id"));
                } 
            } catch (SQLException | HeadlessException  e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            } 
     }
     
        //*************** Cattle Mating History Table *********************
     // Excutes with view button ' Add / edit Cattle
     
     private void CattleMatingHistoryTable() {
         
           Connection conn = myConnection.getConnect();
        
                 String IDsearch = (String) TAGIDL.getSelectedItem();
             
                TAGIDL.requestFocus();
                                            
                try {

                    //Establish / Open Connection
                   
                    String sql = "SELECT m_tag_id, m_name, m_herdgroup, m_paddock, m_sire, m_method,   "
                            + "m_bullsin, m_bullsout, m_c_start, m_c_ends, m_nextmating, m_weaningdate FROM tbl_mating_groups WHERE m_tag_id =? ORDER BY m_tag_id ASC";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, IDsearch);
                

                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) { 
                     
                        //Add data
              
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
                        String one = rs.getString("m_tag_id");
                        String two = rs.getString("m_name");
                        String three = rs.getString("m_herdgroup");
                        String four = rs.getString("m_paddock"); 
                        String five= rs.getString("m_sire");
                        String six = rs.getString("m_method");
                        String seven = rs.getString("m_bullsin");
                        String eight = rs.getString("m_bullsout");
                        String nine = rs.getString("m_c_start");
                        String ten = rs.getString("m_c_ends");
                        String eleven = String.valueOf(sdf.format(rs.getDate("m_nextmating")));
                        String twelve = String.valueOf(sdf.format(rs.getDate("m_weaningdate")));
                        
                      //String array to store data into jTable
                        String tblDataMH[] = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
                        DefaultTableModel tblModelMH = (DefaultTableModel)tableMatingCalvingHistory.getModel();
              
                      //Add string array data into table
                          tblModelMH.addRow(tblDataMH);
                            
                    } 
                   
                      conn.close();
            
                } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Cattle table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
       
     
     //***************** Main Livestock Page *************************
     
     // Livestock Table
     private void LivestockHerdTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_cattle_info ORDER BY c_tag_id ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String tagid = rs.getString("c_tag_id");
              String name = rs.getString("c_name");
              String breed = rs.getString("c_breed");
              String dob = String.valueOf(sdf.format(rs.getDate("c_dateofbirth")));
              String studcom = rs.getString("c_studcom");
              String gender = rs.getString("c_gender");
              String paddock = rs.getString("c_paddock");
              String herdtype = rs.getString("c_herdtype");
              String birthweight = String.valueOf(rs.getInt("c_birthweight"));
              String weanweight = String.valueOf(rs.getInt("c_weanweight"));
              String weandate = String.valueOf(sdf.format(rs.getDate("c_weandate")));
            
           
              //String array to store data into jTable
              String tblDataL[] = {tagid, name, breed, dob, studcom, gender, paddock, herdtype, birthweight, weanweight, weandate};
              DefaultTableModel tblModelL = (DefaultTableModel)tableLivestockHerd.getModel();
              
              //Add string array data into table
              tblModelL.addRow(tblDataL);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "LivestockHerdTable - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
  
     private void CalfstextfieldEditable(){
         // Set textfields not editable
         
         ccTag.setEditable(false);
         ccName.setEditable(false);
         ccBreed.setEnabled(false);
         ccDob.setEnabled(false);
         ccStudCom.setEnabled(false);
         ccGender.setEnabled(false);
         ccBirthWeight.setEditable(false);
         ccPaddock.setEnabled(false);
         ccHerdGroup.setEnabled(false);
         ccWeanWeight.setEditable(false);
         ccWeanDate.setEnabled(false);
         ccSireID.setEditable(false);
         ccDamID.setEditable(false);
         ccBirthStatues.setEnabled(false);
         ccHealthStatues.setEnabled(false);
         ccHornStatues.setEnabled(false);
         
         
         ((JTextFieldDateEditor)ccDob.getDateEditor()).setDisabledTextColor(Color.darkGray); // Change colour of JDatechooser text
        ((JTextFieldDateEditor)ccWeanDate.getDateEditor()).setDisabledTextColor(Color.darkGray); 
         UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
         
       Component editorComponent = ccGender.getEditor().getEditorComponent();
    if(editorComponent instanceof JTextComponent){
        ((JTextComponent)editorComponent).setDisabledTextColor(Color.BLACK);
    }
    
       Component editorComponents = ccHerdGroup.getEditor().getEditorComponent();
    if(editorComponents instanceof JTextComponent){
        ((JTextComponent)editorComponents).setDisabledTextColor(Color.BLACK);
    }
    
       Component editorComponentss = ccStudCom.getEditor().getEditorComponent();
    if(editorComponentss instanceof JTextComponent){
        ((JTextComponent)editorComponentss).setDisabledTextColor(Color.BLACK);
    }
        
 
     }
     
      private void matingCattle() {
                                                      
        Connection conn = myConnection.getConnect();       
        String IDCOWS = (String) TAGIDL.getSelectedItem();
        tfSearchID.requestFocus();
                           
                try {

                    //Establish / Open Connection
                    
                    String sql = "SELECT m_bullsin, m_method, m_sire FROM tbl_mating_groups WHERE m_tag_id = ? ";
                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, IDCOWS);

                    //Executing Query
                    ResultSet rs = sta.executeQuery();
                    if (rs.next()) {
    
                        CFIVETEEN.setText(rs.getString("m_bullsin"));                      
                        CSIXSTEEN.setText(rs.getString("m_method"));  
                        CSEVENTEEN.setText(rs.getString("m_sire"));
                      
                    }
                        
                } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
              }
      }
     
 
      //*************** Cattle Health History Table *********************
     // Excutes with view button ' Add / edit Cattle
     
     private void CattleHealthTable() {
         
           Connection conn = myConnection.getConnect();
        
                String IDsearch = (String) TAGIDL.getSelectedItem();
                TAGIDL.requestFocus();
                                            
                try {

                    //Establish / Open Connection
                   
                    String sql = "SELECT v_id, v_name, v_dob,v_disease, v_vacc, v_app, v_dosage, v_treatementDate,"
                            + "v_nexttreatment, v_employee, v_note FROM tbl_vacc_disease WHERE v_id =? ORDER BY v_id ASC";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, IDsearch);
                 

                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) { 
                        
                        //Add data
              
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
                        String tagid = rs.getString("v_id");
                        String name = rs.getString("v_name");
                        String dob = String.valueOf(sdf.format(rs.getDate("v_dob")));
                        String disease = rs.getString("v_disease");
                        String vaccination = rs.getString("v_vacc");
                        String application = rs.getString("v_app");
                        String dosage = rs.getString("v_dosage");
                        String treatementDate = String.valueOf(sdf.format(rs.getDate("v_treatementDate")));
                        String treatementNext = String.valueOf(sdf.format(rs.getDate("v_nexttreatment")));
                        String employee = rs.getString("v_employee");
                        String notes = rs.getString("v_note");
                    
                      //String array to store data into jTable
                        String tblDataL[] = {tagid, name, dob, disease, vaccination, application, dosage, treatementDate, treatementNext, employee, notes};
                        DefaultTableModel tblModelL = (DefaultTableModel)tableAnimalHealthHistory.getModel();
              
                      //Add string array data into table
                          tblModelL.addRow(tblDataL);
                            
                    } 
                   
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Cattle table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
     }
     
     //*************** Cattle Health History Table *********************
     // Excutes with view button ' Add / edit Cattle or Calves Tab
     
     private void CalfHealthTable() {
         
           Connection conn = myConnection.getConnect();
           String calfID = (String) tfSearchID.getSelectedItem();        
           TAGIDL.requestFocus();
           
           try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT v_id as 'Tag ID',  v_name as 'Name', v_dob as 'DOB', v_disease as 'Disease', v_vacc as 'Vaccination', v_app as 'Application', v_dosage as 'Dosage', v_treatementDate as 'Treatement Date', v_nexttreatment as 'Next Treatement', v_employee as 'Employee', v_note as 'Notes' FROM tbl_vacc_disease WHERE v_id = '" + calfID + "'";
               ResultSet rs = stm.executeQuery(sql);
               tableCalfHealth.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                  conn.close();

                  
        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "Calf Health Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }                   
              
            
     }
     
          // CALF ID Table
     
     private void CalfHerdTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_calf_info ORDER BY cc_tag_id ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String tagid = rs.getString("cc_tag_id");
              String name = rs.getString("cc_name");
              String breed = rs.getString("cc_breed");
              String dob = String.valueOf(sdf.format(rs.getDate("cc_dob")));
              String studcom = rs.getString("cc_studcom");
              String gender = rs.getString("cc_gender");
              String paddock = rs.getString("cc_paddock");
              String herdtype = rs.getString("cc_herdgroup");
              String birthweight = String.valueOf(rs.getInt("cc_birthweight"));
              String weanweight = String.valueOf(rs.getInt("cc_weanweight"));
              String weandate = String.valueOf(sdf.format(rs.getDate("cc_weandate")));
            
           
              //String array to store data into jTable
              String tblDataC[] = {tagid, name, breed, dob, studcom, gender, paddock, herdtype, birthweight, weanweight, weandate};
              DefaultTableModel tblModelC = (DefaultTableModel)tableLivestockHerd.getModel();
              
              //Add string array data into table
              tblModelC.addRow(tblDataC);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "LivestockHerdTable - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
 
      // CALF ID Table
     
     private void WeanerHerdTable() {
        
        Connection conn = myConnection.getConnect();
           
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_weaner_info ORDER BY w_id ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String tagid = rs.getString("w_id");
              String name = rs.getString("w_name");
              String breed = rs.getString("w_breed");
              String dob = String.valueOf(sdf.format(rs.getDate("w_dob")));
              String studcom = rs.getString("w_studcom");
              String gender = rs.getString("w_gender");
              String paddock = rs.getString("w_paddock");
              String herdtype = rs.getString("w_herdtype");
              String birthweight = String.valueOf(rs.getInt("w_birthweight"));
              String weanweight = String.valueOf(rs.getInt("w_weanweight"));
              String weandate = String.valueOf(sdf.format(rs.getDate("w_weandate")));
            
           
              //String array to store data into jTable
              String tblDataW[] = {tagid, name, breed, dob, studcom, gender, paddock, herdtype, birthweight, weanweight, weandate};
              DefaultTableModel tblModelW = (DefaultTableModel)tableLivestockHerd.getModel();
              
              //Add string array data into table
              tblModelW.addRow(tblDataW);
           
        }
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                //    JOptionPane.showMessageDialog(null, "LivestockHerdTable - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    } 
     // ******************* Mating Group Table ********************
     
     //Mating Tab
    private void IndividualMatingTable() {
        
        Connection conn = myConnection.getConnect();
     
        try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_mating_groups ORDER BY m_tag_id ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String mid = rs.getString("m_tag_id");
              String mname = rs.getString("m_name");
              String mherdgroup = rs.getString("m_herdgroup");
              String mpaddock = rs.getString("m_paddock");
              String mstud = rs.getString("m_stud");
              String msire = rs.getString("m_sire");
              String mmethod = rs.getString("m_method");
              String mbullsin = rs.getString("m_bullsin");
              String mbullsout = rs.getString("m_bullsout");
              String mcalvesstart = rs.getString("m_c_start");
              String mcalvesend = rs.getString("m_c_ends");      
              String mnextmating = String.valueOf(sdf.format(rs.getDate("m_nextmating")));
              String mweandate = String.valueOf(sdf.format(rs.getDate("m_weaningdate")));
                      
              //String array to store data into jTable
              String tblData[] = {mid, mname, mherdgroup, mpaddock, mstud, msire, mmethod,  mbullsin, mbullsout, mcalvesstart, mcalvesend, mnextmating, mweandate};
              DefaultTableModel tblModelM = (DefaultTableModel)tableMatingHerd.getModel();
              
              //Add string array data into table
              tblModelM.addRow(tblData);
             
          }        
              conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, " Mating Group - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }            
    } 
      
          //*************** Weaner Table *********************
     // Excutes with system fire
     
     private void WeanerTable() {
         
           Connection conn = myConnection.getConnect();
        
            try {
            
          Statement stm = conn.createStatement();
          String sql = "SELECT * FROM tbl_weaner_info ORDER BY w_id ASC";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()) {
              
              //Add data
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
              String wid = rs.getString("w_id");
              String wname = rs.getString("w_name");
              String wgender = rs.getString("w_gender");
              String wpaddock = rs.getString("w_paddock");
              String wstud = rs.getString("w_studcom");
              String wherd = rs.getString("w_herdtype");
              String wtype = rs.getString("w_type");
              String wweanweight = rs.getString("w_weanweight");
              String wweandate = String.valueOf(sdf.format(rs.getDate("w_weandate")));
              String wsalesmate = String.valueOf(sdf.format(rs.getDate("w_salemate"))); 
              String wsire = rs.getString("w_sire");
              String wdam = rs.getString("w_dam");
              
              //String array to store data into jTable
              String tblDataW[] = {wid, wname, wgender, wpaddock, wstud, wherd, wtype, wweanweight, wweandate, wsalesmate, wsire, wdam};
              DefaultTableModel tblModelW = (DefaultTableModel)tableWeanerCattle.getModel();
              
              //Add string array data into table
              tblModelW.addRow(tblDataW);
              
          }  
                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "Weaner Table - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }  
     }
      
           //***************** Main Livestock Page *************************
     
     // Animal Health Table
     
     private void AnimalHealthTable() {
        
        Connection conn = myConnection.getConnect();
           
            
           try {
            
          
               Statement stm = conn.createStatement();
               String sql = "SELECT v_id as 'Tag ID',  v_name as 'Name', v_dob as 'DOB', v_disease as 'Disease', v_vacc as 'Vaccination', v_app as 'Application', v_dosage as 'Dosage', v_treatementDate as 'Treatement Date', v_nexttreatment as 'Next Treatement', v_employee as 'Employee', v_note as 'Notes' FROM tbl_vacc_disease";
               ResultSet rs = stm.executeQuery(sql);
               tableAnimalHealth.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                  conn.close();

        } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                  //  JOptionPane.showMessageDialog(null, "AnimalHealthTable - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }  
    } 
     
     
     //****************************** CATTLE AND CALF SECTION END *************************************
     

      
     private void UpdateButtonCC() {
         
         if(radioUpdateCC.isSelected()) {
             buttonUpdateCC.setEnabled(true);
         } else {
             buttonUpdateCC.setEnabled(false);
         }
         
     }
     
       private void UpdateButtonK() {
         
         if(radioUpdateG.isSelected()) {
             buttonUpdateK.setEnabled(true);
         } else {
             buttonUpdateK.setEnabled(false);
         }
         
     }
       
           private void UpdateButtonS() {
         
         if(radioUpdateS.isSelected()) {
             buttonUpdateS.setEnabled(true);
         } else {
             buttonUpdateS.setEnabled(false);
         }
         
     }
     
   // ********** Filter Animal Health Table Sheep **************
     private void filterSheep(String querySH){
         
         DefaultTableModel tblModelSH = (DefaultTableModel) sheepTableHealth.getModel();
         TableRowSorter<DefaultTableModel> sh = new TableRowSorter<DefaultTableModel>(tblModelSH);
         sheepTableHealth.setRowSorter(sh);
         
         sh.setRowFilter(RowFilter.regexFilter(querySH));
     }
     
       // ********** Filter Weaner Table Sheep **************
     private void filterSheepW(String querySW){
         
         DefaultTableModel tblModelSHW = (DefaultTableModel) tableWeanerSheep.getModel();
         TableRowSorter<DefaultTableModel> shw = new TableRowSorter<DefaultTableModel>(tblModelSHW);
         tableWeanerSheep.setRowSorter(shw);
         
         shw.setRowFilter(RowFilter.regexFilter(querySW));
     }
     
         // ********** Filter Weaner Table Sheep **************
     private void filterSheepSM(String querySM){
         
         DefaultTableModel tblModelSHM = (DefaultTableModel) tableMatingSheeps.getModel();
         TableRowSorter<DefaultTableModel> shm = new TableRowSorter<DefaultTableModel>(tblModelSHM);
         tableMatingSheeps.setRowSorter(shm);
         
         shm.setRowFilter(RowFilter.regexFilter(querySM));
     }
     
           // ********** Filter Main Page Table Sheep **************
     private void filterSheepMain(String queryMS){
         
         DefaultTableModel tblModelMS = (DefaultTableModel) tableSheepMain.getModel();
         TableRowSorter<DefaultTableModel> ms = new TableRowSorter<DefaultTableModel>(tblModelMS);
         tableSheepMain.setRowSorter(ms);
         
         ms.setRowFilter(RowFilter.regexFilter(queryMS));
     }
     
       
     // ********** Filter Animal Health Table Goats **************
     private void filterGoats(String queryGG){
         
         DefaultTableModel tblModelGG = (DefaultTableModel) tableAnimalHealthGoatsH.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(tblModelGG);
         tableAnimalHealthGoatsH.setRowSorter(trs);
         
         trs.setRowFilter(RowFilter.regexFilter(queryGG));
     }
     
       // ********** Filter Weaner Table Goats **************
     private void filterGoatsWeaner(String queryGW){
         
         DefaultTableModel tblModelGW = (DefaultTableModel) tableWeanerGoats.getModel();
         TableRowSorter<DefaultTableModel> gw = new TableRowSorter<DefaultTableModel>(tblModelGW);
         tableWeanerGoats.setRowSorter(gw);
         
         gw.setRowFilter(RowFilter.regexFilter(queryGW));
     }
     
        // ********** Filter Main Page Table Goats **************
     private void filterGoatsMainPage(String queryGM){
         
         DefaultTableModel tblModelGM = (DefaultTableModel) tableGoats.getModel();
         TableRowSorter<DefaultTableModel> gm = new TableRowSorter<DefaultTableModel>(tblModelGM);
         tableGoats.setRowSorter(gm);
         
         gm.setRowFilter(RowFilter.regexFilter(queryGM));
     }
     
     // ********** Filter Animal Health Table **************
     private void filter(String query){
         
         DefaultTableModel tblModel = (DefaultTableModel) tableAnimalHealth.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(tblModel);
         tableAnimalHealth.setRowSorter(trs);
         
         trs.setRowFilter(RowFilter.regexFilter(query));
     }
     
     // ********** Filter Weaner Table **************
     private void filterWeaner(String queryw){
         
         DefaultTableModel tblModelw = (DefaultTableModel) tableWeanerCattle.getModel();
         TableRowSorter<DefaultTableModel> trsw = new TableRowSorter<DefaultTableModel>(tblModelw);
         tableWeanerCattle.setRowSorter(trsw);
         
         trsw.setRowFilter(RowFilter.regexFilter(queryw));
     }
     
     
     // ********** Filter Mating Table **************
     private void filterMating(String querym){
         
         DefaultTableModel tblModelM = (DefaultTableModel) tableMatingHerd.getModel();
         TableRowSorter<DefaultTableModel> trsm = new TableRowSorter<DefaultTableModel>(tblModelM);
         tableMatingHerd.setRowSorter(trsm);
         
         trsm.setRowFilter(RowFilter.regexFilter(querym));
     }
     
       // ********** Filter Mating Table **************
     private void filterMatingGoats(String queryg){
         
         DefaultTableModel tblModelg = (DefaultTableModel) tableMatingGoats.getModel();
         TableRowSorter<DefaultTableModel> trsg = new TableRowSorter<DefaultTableModel>(tblModelg);
         tableMatingGoats.setRowSorter(trsg);
         
         trsg.setRowFilter(RowFilter.regexFilter(queryg));
     }
     
       // ********** Filter Mating Table **************
     private void filterMainTable(String querym){
         
         DefaultTableModel tblModelML = (DefaultTableModel) tableLivestockHerd.getModel();
         TableRowSorter<DefaultTableModel> trsml = new TableRowSorter<DefaultTableModel>(tblModelML);
         tableLivestockHerd.setRowSorter(trsml);
         
         trsml.setRowFilter(RowFilter.regexFilter(querym));
     }
     

         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabCattle = new javax.swing.JPanel();
        tabSubpan = new javax.swing.JTabbedPane();
        tabMainCattle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filterCattlePaddock = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        filterCattleGroup = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        filterCattleTag = new javax.swing.JComboBox<>();
        buttonClearCattle1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableLivestockHerd = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        tabAddCattle = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        buttonCAdd = new javax.swing.JButton();
        panelSearch = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        buttonUpdate = new javax.swing.JButton();
        buttonDeleteL = new javax.swing.JButton();
        buttonCClose = new javax.swing.JButton();
        buttonClearCattle = new javax.swing.JButton();
        TAGIDL = new javax.swing.JComboBox<>();
        buttonSearchCow = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        CONE = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        CTWO = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        CNINE = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        CSIXSTEEN = new javax.swing.JTextField();
        CTHREE = new javax.swing.JTextField();
        CFIVE = new javax.swing.JTextField();
        CSIXS = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        CSEVENTEEN = new javax.swing.JTextField();
        CSEVEN = new javax.swing.JTextField();
        CEIGHT = new javax.swing.JTextField();
        CFOURTEEN = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        CTWENTYONE = new javax.swing.JTextField();
        CTWENTYTWO = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableMatingCalvingHistory = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableAnimalHealthHistory = new javax.swing.JTable();
        jLabel87 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        CTEN = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        CTWELVE = new javax.swing.JTextField();
        CFIVETEEN = new javax.swing.JTextField();
        CELEVEND = new javax.swing.JTextField();
        CFOURD = new javax.swing.JTextField();
        CTHIRTEEND = new javax.swing.JTextField();
        labelBackground = new javax.swing.JLabel();
        TabMating = new javax.swing.JPanel();
        searchBar2 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        filterMatingCattleID = new javax.swing.JComboBox<>();
        filterStartCattle = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        filterMatingNext = new javax.swing.JComboBox<>();
        jScrollPane19 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tableMatingHerd = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        buttonUpdateM = new javax.swing.JButton();
        buttonClearM = new javax.swing.JButton();
        buttonDeleteM = new javax.swing.JButton();
        buttonCClose4 = new javax.swing.JButton();
        jLabel93 = new javax.swing.JLabel();
        tabCalves = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        searchBar = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        buttonViewCalf = new javax.swing.JButton();
        buttonUpdateCC = new javax.swing.JButton();
        buttonDeleteCC = new javax.swing.JButton();
        buttonCloseC = new javax.swing.JButton();
        buttonClearCC = new javax.swing.JButton();
        tfSearchID = new javax.swing.JComboBox<>();
        radioUpdateCC = new javax.swing.JRadioButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        ccTag = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        ccName = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        ccDob = new com.toedter.calendar.JDateChooser();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        ccBirthWeight = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tableCalfHealth = new javax.swing.JTable();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        ccWeanWeight = new javax.swing.JTextField();
        ccWeanDate = new com.toedter.calendar.JDateChooser();
        ccSireID = new javax.swing.JTextField();
        ccDamID = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        ccGender = new javax.swing.JComboBox<>();
        ccBreed = new javax.swing.JComboBox<>();
        ccPaddock = new javax.swing.JComboBox<>();
        ccHerdGroup = new javax.swing.JComboBox<>();
        ccBirthStatues = new javax.swing.JComboBox<>();
        ccHealthStatues = new javax.swing.JComboBox<>();
        ccHornStatues = new javax.swing.JComboBox<>();
        ccStudCom = new javax.swing.JComboBox<>();
        buttonCAdd2 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        buttonAddWeaner = new javax.swing.JButton();
        labelHeading = new javax.swing.JLabel();
        searchBar3 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        buttonUpdateWeaner = new javax.swing.JButton();
        buttonDeleteWeaner = new javax.swing.JButton();
        buttonCloseWeaner = new javax.swing.JButton();
        buttonClearWeaner = new javax.swing.JButton();
        filterPaddockCattle = new javax.swing.JComboBox<>();
        filterWeanerTagCattle = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tableWeanerCattle = new javax.swing.JTable();
        labelBg = new javax.swing.JLabel();
        tabAnimaleHealth = new javax.swing.JPanel();
        buttonAddVacc = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        searchBar1 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        buttonDeleteA = new javax.swing.JButton();
        buttonCClose3 = new javax.swing.JButton();
        buttonClearA = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        filterDiseaseCattle = new javax.swing.JComboBox<>();
        filterVaccCattle = new javax.swing.JComboBox<>();
        filterTagCattle = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tableAnimalHealth = new javax.swing.JTable();
        jLabel76 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        goatSubPane = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        filterPaddockGoats = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        filterHerdGoats = new javax.swing.JComboBox<>();
        buttonCloseG = new javax.swing.JButton();
        filterTagG = new javax.swing.JComboBox<>();
        buttonClearG = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableGoats = new javax.swing.JTable();
        labelBG = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        buttonGAdd = new javax.swing.JButton();
        panelSearch1 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        buttonGSearch = new javax.swing.JButton();
        buttonGUpdate = new javax.swing.JButton();
        buttonGDelete = new javax.swing.JButton();
        buttonGClose = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        buttonClearGoats = new javax.swing.JButton();
        filterTagGoats = new javax.swing.JComboBox<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        labelImage1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        GONE = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        GTWO = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        GNINE = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        GSIXSTEEN = new javax.swing.JTextField();
        GTHREE = new javax.swing.JTextField();
        GFIVE = new javax.swing.JTextField();
        GSIXS = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        GSEVENTEEN = new javax.swing.JTextField();
        GSEVEN = new javax.swing.JTextField();
        GEIGHT = new javax.swing.JTextField();
        GFOURTEEN = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        GTWENTYONE = new javax.swing.JTextField();
        GTWENTYTWO = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tableGoatLamHistory = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tableGoatHealthHistory = new javax.swing.JTable();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        GTEN = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        GTWELEVE = new javax.swing.JTextField();
        GFIFTHTEEN = new javax.swing.JTextField();
        GELEVEN = new javax.swing.JTextField();
        GFOUR = new javax.swing.JTextField();
        GTHIRTEEN = new javax.swing.JTextField();
        tabMatingGoats = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel133 = new javax.swing.JLabel();
        searchBar4 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        filterMatingGoats = new javax.swing.JComboBox<>();
        filterStartGoats = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        filterNextGoats = new javax.swing.JComboBox<>();
        buttonUpdateM1 = new javax.swing.JButton();
        buttonClearM1 = new javax.swing.JButton();
        buttonDeleteM1 = new javax.swing.JButton();
        buttonCClose5 = new javax.swing.JButton();
        jLabel138 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tableMatingGoats = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tabKidsGoats = new javax.swing.JPanel();
        buttonAddKid = new javax.swing.JButton();
        jLabel139 = new javax.swing.JLabel();
        searchBar5 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        buttonViewK = new javax.swing.JButton();
        buttonUpdateK = new javax.swing.JButton();
        buttonDeleteK = new javax.swing.JButton();
        buttonCloseK = new javax.swing.JButton();
        buttonClearK = new javax.swing.JButton();
        searchKid = new javax.swing.JComboBox<>();
        radioUpdateG = new javax.swing.JRadioButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        gTag = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        gName = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        gDob = new com.toedter.calendar.JDateChooser();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        gBirthWeight = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tablegoatHealth = new javax.swing.JTable();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        gWeanWeight = new javax.swing.JTextField();
        gWeanDate = new com.toedter.calendar.JDateChooser();
        gRamID = new javax.swing.JTextField();
        gEweID = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        gGender = new javax.swing.JComboBox<>();
        gBreed = new javax.swing.JComboBox<>();
        gPaddock = new javax.swing.JComboBox<>();
        gHerdGroup = new javax.swing.JComboBox<>();
        gBirthStatues = new javax.swing.JComboBox<>();
        gHealthStatues = new javax.swing.JComboBox<>();
        gHornStatues = new javax.swing.JComboBox<>();
        gStudCom = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        labelHeading1 = new javax.swing.JLabel();
        searchBar6 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        buttonUpdateWeaner1 = new javax.swing.JButton();
        buttonDeleteWeaner1 = new javax.swing.JButton();
        buttonCloseWeaner1 = new javax.swing.JButton();
        buttonClearWeaner1 = new javax.swing.JButton();
        filterTypeGoats = new javax.swing.JComboBox<>();
        filterGoatWeanerID = new javax.swing.JComboBox<>();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        buttonAddWeaner1 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tableWeanerGoats = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        tabHealthGoat = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tableAnimalHealthGoatsH = new javax.swing.JTable();
        jLabel162 = new javax.swing.JLabel();
        searchBar7 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        buttonDeleteA1 = new javax.swing.JButton();
        buttonCClose6 = new javax.swing.JButton();
        buttonClearA1 = new javax.swing.JButton();
        jLabel165 = new javax.swing.JLabel();
        searchGoatDisease = new javax.swing.JComboBox<>();
        searchGoatVacc = new javax.swing.JComboBox<>();
        searchGoatIDH = new javax.swing.JComboBox<>();
        buttonAddVacc1 = new javax.swing.JButton();
        jLabel166 = new javax.swing.JLabel();
        labelBGGoatsA = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableSheepMain = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        filterGenderSheep = new javax.swing.JComboBox<>();
        jLabel137 = new javax.swing.JLabel();
        filterPaddockSheep = new javax.swing.JComboBox<>();
        buttonCloseSM = new javax.swing.JButton();
        filterTagSheep = new javax.swing.JComboBox<>();
        buttonClearG1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        buttonSAdd = new javax.swing.JButton();
        panelSearch2 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        buttonSSearch = new javax.swing.JButton();
        buttonSUpdate = new javax.swing.JButton();
        buttonSDelete = new javax.swing.JButton();
        buttonSClose = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        buttonClearSheep = new javax.swing.JButton();
        TagIDSAdd = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel31 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        labelImageS = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        SONE = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        STWO = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        SNINE = new javax.swing.JTextField();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        SSIXSTEEN = new javax.swing.JTextField();
        STHREE = new javax.swing.JTextField();
        SFIVE = new javax.swing.JTextField();
        SSIXS = new javax.swing.JTextField();
        jLabel178 = new javax.swing.JLabel();
        SSEVENTEEN = new javax.swing.JTextField();
        SSEVEN = new javax.swing.JTextField();
        SEIGHT = new javax.swing.JTextField();
        SFOURTEEN = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        STWENTYONE = new javax.swing.JTextField();
        STWENTYTWO = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tableMatingHistory = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        tableSheepHealthHistory = new javax.swing.JTable();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        STEN = new javax.swing.JTextField();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        STWELEVE = new javax.swing.JTextField();
        SFIFTHTEEN = new javax.swing.JTextField();
        SELEVEN = new javax.swing.JTextField();
        SFOUR = new javax.swing.JTextField();
        STHIRTEEN = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btnAddMatingSheep = new javax.swing.JLabel();
        searchBar8 = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        matingIDSheep = new javax.swing.JComboBox<>();
        matingStartSheep = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        searchNextMating = new javax.swing.JComboBox<>();
        buttonUpdateMatingSheep = new javax.swing.JButton();
        buttonDeleteMatingSheep = new javax.swing.JButton();
        buttonClearMatingSheep = new javax.swing.JButton();
        buttonCloseMatingSheep = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane28 = new javax.swing.JScrollPane();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        tableMatingSheeps = new javax.swing.JTable();
        jLabel192 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        searchBar9 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        buttonViewS = new javax.swing.JButton();
        buttonUpdateS = new javax.swing.JButton();
        buttonDeleteS = new javax.swing.JButton();
        buttonCloseS = new javax.swing.JButton();
        buttonClearS = new javax.swing.JButton();
        searchLamb = new javax.swing.JComboBox<>();
        radioUpdateS = new javax.swing.JRadioButton();
        buttonAddLamb = new javax.swing.JButton();
        jScrollPane30 = new javax.swing.JScrollPane();
        jPanel42 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        sTag = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        sName = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        sDob = new com.toedter.calendar.JDateChooser();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        sBirthWeight = new javax.swing.JTextField();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane31 = new javax.swing.JScrollPane();
        tableLambHealth = new javax.swing.JTable();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        sWeanWeight = new javax.swing.JTextField();
        sWeanDate = new com.toedter.calendar.JDateChooser();
        sRamID = new javax.swing.JTextField();
        sEweID = new javax.swing.JTextField();
        jLabel210 = new javax.swing.JLabel();
        sGender = new javax.swing.JComboBox<>();
        sBreed = new javax.swing.JComboBox<>();
        sPaddock = new javax.swing.JComboBox<>();
        sHerdGroup = new javax.swing.JComboBox<>();
        sBirthStatues = new javax.swing.JComboBox<>();
        sHealthStatues = new javax.swing.JComboBox<>();
        sHornStatues = new javax.swing.JComboBox<>();
        sStudCom = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        labelHeading2 = new javax.swing.JLabel();
        searchBar10 = new javax.swing.JPanel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        buttonUpdateWeanerS = new javax.swing.JButton();
        buttonDeleteWeanerS = new javax.swing.JButton();
        buttonCloseWeaner2 = new javax.swing.JButton();
        buttonClearWeanerS = new javax.swing.JButton();
        typeWeaner = new javax.swing.JComboBox<>();
        searchWeanerSheep = new javax.swing.JComboBox<>();
        jScrollPane32 = new javax.swing.JScrollPane();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane33 = new javax.swing.JScrollPane();
        tableWeanerSheep = new javax.swing.JTable();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        buttonAddWeanerSheep = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        buttonAddVacc2 = new javax.swing.JButton();
        jLabel215 = new javax.swing.JLabel();
        searchBar11 = new javax.swing.JPanel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        buttonDeleteA2 = new javax.swing.JButton();
        buttonCClose7 = new javax.swing.JButton();
        buttonClearA2 = new javax.swing.JButton();
        jLabel218 = new javax.swing.JLabel();
        sheepDisease = new javax.swing.JComboBox<>();
        sheepVacc = new javax.swing.JComboBox<>();
        tagSearchSheepHealth = new javax.swing.JComboBox<>();
        jLabel219 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane34 = new javax.swing.JScrollPane();
        sheepTableHealth = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIVESTOCK MANAGEMENT");

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tabCattle.setBackground(new java.awt.Color(101, 53, 15));
        tabCattle.setMaximumSize(new java.awt.Dimension(1300, 600));
        tabCattle.setPreferredSize(new java.awt.Dimension(1405, 600));
        tabCattle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabSubpan.setBackground(new java.awt.Color(204, 204, 255));
        tabSubpan.setForeground(new java.awt.Color(51, 51, 51));
        tabSubpan.setPreferredSize(new java.awt.Dimension(1172, 700));

        tabMainCattle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CATTLE LIVESTOCK MANAGEMENT");
        tabMainCattle.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1330, 33));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "SEARCH ANIMAL / HERDS"));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("TAG NR:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("PADDOCK:");

        filterCattlePaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterCattlePaddock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterCattlePaddockItemStateChanged(evt);
            }
        });
        filterCattlePaddock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterCattlePaddockFocusGained(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("GROUP:");

        filterCattleGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterCattleGroup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterCattleGroupItemStateChanged(evt);
            }
        });
        filterCattleGroup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterCattleGroupFocusGained(evt);
            }
        });
        filterCattleGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCattleGroupActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        filterCattleTag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterCattleTag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterCattleTagItemStateChanged(evt);
            }
        });
        filterCattleTag.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterCattleTagFocusGained(evt);
            }
        });

        buttonClearCattle1.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearCattle1.setForeground(new java.awt.Color(51, 51, 51));
        buttonClearCattle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClearCattle1.setText("CLEAR");
        buttonClearCattle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearCattle1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(filterCattleTag, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(filterCattleGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(filterCattlePaddock, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(buttonClearCattle1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClearCattle1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(filterCattlePaddock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(filterCattleGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(filterCattleTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        tabMainCattle.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 71, 1300, 70));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("LIVESTOCK HERD"));

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tableLivestockHerd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Breed", "Date-of-Birth", "Stud / Com", "Gender", "Paddock", "Herd group", "Birth Weight", "W Weight", "Wean Date"
            }
        ));
        jScrollPane13.setViewportView(tableLivestockHerd);
        if (tableLivestockHerd.getColumnModel().getColumnCount() > 0) {
            tableLivestockHerd.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableLivestockHerd.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableLivestockHerd.getColumnModel().getColumn(7).setPreferredWidth(150);
            tableLivestockHerd.getColumnModel().getColumn(8).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1319, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel11);

        tabMainCattle.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1310, 450));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jLabel69.setText("jLabel69");
        tabMainCattle.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 640));

        tabSubpan.addTab("Main Cattle Page", tabMainCattle);

        tabAddCattle.setBackground(new java.awt.Color(204, 204, 204));
        tabAddCattle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("VIEW / ADD / EDIT / DELETE INDIVIDUAL CATTLE");
        tabAddCattle.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1182, -1));

        buttonCAdd.setBackground(new java.awt.Color(204, 204, 255));
        buttonCAdd.setForeground(new java.awt.Color(0, 0, 0));
        buttonCAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        buttonCAdd.setText("ADD CATTLE");
        buttonCAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCAddActionPerformed(evt);
            }
        });
        tabAddCattle.add(buttonCAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, -1, 37));

        panelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "SEARCH LIVESTOCK"));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setText("Tag ID:");

        buttonUpdate.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdate.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDeleteL.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteL.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteL.setText("DELETE");
        buttonDeleteL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteLActionPerformed(evt);
            }
        });

        buttonCClose.setBackground(new java.awt.Color(204, 204, 255));
        buttonCClose.setForeground(new java.awt.Color(0, 0, 0));
        buttonCClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCClose.setText("CLOSE");
        buttonCClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCCloseActionPerformed(evt);
            }
        });

        buttonClearCattle.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearCattle.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearCattle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClearCattle.setText("CLEAR");
        buttonClearCattle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearCattleActionPerformed(evt);
            }
        });

        TAGIDL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        TAGIDL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TAGIDLFocusGained(evt);
            }
        });

        buttonSearchCow.setBackground(new java.awt.Color(204, 204, 255));
        buttonSearchCow.setForeground(new java.awt.Color(0, 0, 0));
        buttonSearchCow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSearchCow.setText("SEARCH");
        buttonSearchCow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchCowActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("AGRI8 Assist - Click 'CLEAR BUTTON' to search next Animal!");

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TAGIDL, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(buttonSearchCow, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteL, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCClose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDeleteL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClearCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSearchCow, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonCClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TAGIDL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        tabAddCattle.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1300, -1));

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
        jPanel9.setForeground(new java.awt.Color(0, 0, 0));

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel19.setForeground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Tag ID Nr:");

        CONE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CONE.setForeground(new java.awt.Color(0, 0, 0));
        CONE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CONE.setEnabled(false);
        CONE.setPreferredSize(new java.awt.Dimension(64, 22));
        CONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONEActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Name:");

        CTWO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CTWO.setForeground(new java.awt.Color(0, 0, 0));
        CTWO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CTWO.setEnabled(false);
        CTWO.setPreferredSize(new java.awt.Dimension(64, 22));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Breed:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Date-of-Birth:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Gender:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Stud / Com:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Paddock:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Herd Type:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Birth Weight:");

        CNINE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CNINE.setForeground(new java.awt.Color(0, 0, 0));
        CNINE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CNINE.setEnabled(false);
        CNINE.setPreferredSize(new java.awt.Dimension(64, 22));
        CNINE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CNINEKeyPressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Breeding Status:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Mating Date:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Mating Method:");

        CSIXSTEEN.setEditable(false);
        CSIXSTEEN.setForeground(new java.awt.Color(0, 0, 0));
        CSIXSTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CSIXSTEEN.setEnabled(false);
        CSIXSTEEN.setMinimumSize(new java.awt.Dimension(149, 22));

        CTHREE.setForeground(new java.awt.Color(0, 0, 0));
        CTHREE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CTHREE.setEnabled(false);

        CFIVE.setForeground(new java.awt.Color(0, 0, 0));
        CFIVE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CFIVE.setEnabled(false);

        CSIXS.setForeground(new java.awt.Color(0, 0, 0));
        CSIXS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CSIXS.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Mating Sire:");

        CSEVENTEEN.setEditable(false);
        CSEVENTEEN.setForeground(new java.awt.Color(0, 0, 0));
        CSEVENTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CSEVENTEEN.setEnabled(false);

        CSEVEN.setForeground(new java.awt.Color(0, 0, 0));
        CSEVEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CSEVEN.setEnabled(false);

        CEIGHT.setForeground(new java.awt.Color(0, 0, 0));
        CEIGHT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CEIGHT.setEnabled(false);

        CFOURTEEN.setForeground(new java.awt.Color(0, 0, 0));
        CFOURTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CFOURTEEN.setEnabled(false);
        CFOURTEEN.setMinimumSize(new java.awt.Dimension(149, 22));
        CFOURTEEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CFOURTEENActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("1st gener Dam Nr:");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("1st gener Sire nr:");

        CTWENTYONE.setForeground(new java.awt.Color(0, 0, 0));
        CTWENTYONE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CTWENTYONE.setEnabled(false);

        CTWENTYTWO.setForeground(new java.awt.Color(0, 0, 0));
        CTWENTYTWO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CTWENTYTWO.setEnabled(false);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "MATING AND CALVING HISTORY"));

        tableMatingCalvingHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Herd Group", "Paddock", "Mating Sire", "Method", "Bulls-in", "Bulls-out", "Calving-start", "Calving-Ends", "Next mating", "Weaning Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tableMatingCalvingHistory);
        if (tableMatingCalvingHistory.getColumnModel().getColumnCount() > 0) {
            tableMatingCalvingHistory.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableMatingCalvingHistory.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableMatingCalvingHistory.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "ANIMALE HEALTH HISTORY"));

        tableAnimalHealthHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Date-of-Birth", "Disease", "Medication", "Application", "Dosage", "Treatement Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tableAnimalHealthHistory);
        if (tableAnimalHealthHistory.getColumnModel().getColumnCount() > 0) {
            tableAnimalHealthHistory.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableAnimalHealthHistory.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableAnimalHealthHistory.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableAnimalHealthHistory.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableAnimalHealthHistory.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableAnimalHealthHistory.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableAnimalHealthHistory.getColumnModel().getColumn(6).setPreferredWidth(20);
            tableAnimalHealthHistory.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableAnimalHealthHistory.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableAnimalHealthHistory.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableAnimalHealthHistory.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        jLabel87.setText("Wean Weight:");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 0, 0));
        jLabel90.setText("Wean Date:");

        CTEN.setForeground(new java.awt.Color(0, 0, 0));
        CTEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CTEN.setEnabled(false);
        CTEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CTENActionPerformed(evt);
            }
        });
        CTEN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CTENKeyPressed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 0, 0));
        jLabel91.setText("12 Month Weight:");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 0, 0));
        jLabel92.setText("12M Weight Date:");

        CTWELVE.setForeground(new java.awt.Color(0, 0, 0));
        CTWELVE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CTWELVE.setEnabled(false);
        CTWELVE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CTWELVEKeyPressed(evt);
            }
        });

        CFIVETEEN.setEditable(false);
        CFIVETEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CFIVETEEN.setEnabled(false);

        CELEVEND.setForeground(new java.awt.Color(0, 0, 0));
        CELEVEND.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CELEVEND.setEnabled(false);

        CFOURD.setForeground(new java.awt.Color(0, 0, 0));
        CFOURD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CFOURD.setEnabled(false);

        CTHIRTEEND.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CTHIRTEEND.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31)
                            .addComponent(jLabel27)
                            .addComponent(jLabel30)
                            .addComponent(jLabel37)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel28)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CFOURD)
                            .addComponent(CFIVE)
                            .addComponent(CSIXS)
                            .addComponent(CSEVEN)
                            .addComponent(CEIGHT)
                            .addComponent(CNINE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(CONE, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(CTWO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CTHREE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel91)
                                    .addComponent(jLabel92)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel40))
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CFIVETEEN)
                                    .addComponent(CSIXSTEEN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CFOURTEEN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CTHIRTEEND)
                                    .addComponent(CTWELVE)
                                    .addComponent(CSEVENTEEN)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel90))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CELEVEND)
                                    .addComponent(CTWENTYONE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel87)
                                        .addGap(52, 52, 52)
                                        .addComponent(CTEN))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel46)
                                        .addGap(32, 32, 32)
                                        .addComponent(CTWENTYTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(37, 37, 37))
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(CONE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(CTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(CFOURD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CSIXS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CSEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)))
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel90)
                            .addComponent(CELEVEND, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CNINE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(CTWENTYONE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CTWENTYTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(CTWELVE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CTHIRTEEND, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CFOURTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(CFIVETEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CSIXSTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CSEVENTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel87)
                            .addComponent(CTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jScrollPane7.setViewportView(jPanel9);

        tabAddCattle.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 158, 1300, 458));

        labelBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        tabAddCattle.add(labelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 640));

        tabSubpan.addTab("Add / Edit Cattle", tabAddCattle);

        TabMating.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBar2.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH LIVESTOCK"));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel95.setText("Tag ID:");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel97.setText("Calving Starts:");

        filterMatingCattleID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterMatingCattleID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterMatingCattleIDItemStateChanged(evt);
            }
        });
        filterMatingCattleID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterMatingCattleIDFocusGained(evt);
            }
        });

        filterStartCattle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterStartCattle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterStartCattleItemStateChanged(evt);
            }
        });
        filterStartCattle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterStartCattleFocusGained(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Next Mating:");

        filterMatingNext.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterMatingNext.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterMatingNextItemStateChanged(evt);
            }
        });
        filterMatingNext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterMatingNextFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar2Layout = new javax.swing.GroupLayout(searchBar2);
        searchBar2.setLayout(searchBar2Layout);
        searchBar2Layout.setHorizontalGroup(
            searchBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterMatingCattleID, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(jLabel97)
                .addGap(18, 18, 18)
                .addComponent(filterStartCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(filterMatingNext, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        searchBar2Layout.setVerticalGroup(
            searchBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterMatingNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(searchBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterStartCattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel97))
                    .addGroup(searchBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel95)
                        .addComponent(filterMatingCattleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );

        TabMating.add(searchBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1300, 70));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("INDIVIDUAL MATING GROUP"));

        tableMatingHerd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Herd Group", "Paddock", "Stud / Com", "Mating Sire", "Method", "Bulls-in", "Bulls-out", "Calving-Start", "Calving-Ends", "Next Mating", "Weaning Date"
            }
        ));
        jScrollPane20.setViewportView(tableMatingHerd);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        jScrollPane19.setViewportView(jPanel7);

        TabMating.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1300, 380));

        jButton10.setBackground(new java.awt.Color(204, 204, 255));
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        jButton10.setText("ADD MATING");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        TabMating.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, -1, 30));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(51, 51, 51));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("AGRI8 Assist - Here you can filter the table by various methods!                                                                                                                                         \"DELETE a field in the Table below by selecting a row and then click the \"DELETE BUTTON\".");
        TabMating.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 1290, -1));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("MATING HERD AND RECORDS");
        TabMating.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1340, -1));

        buttonUpdateM.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateM.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateM.setText("UPDATE");
        buttonUpdateM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateMActionPerformed(evt);
            }
        });
        TabMating.add(buttonUpdateM, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 110, 31));

        buttonClearM.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearM.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearM.setText("CLEAR");
        buttonClearM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearMActionPerformed(evt);
            }
        });
        TabMating.add(buttonClearM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 110, 30));

        buttonDeleteM.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteM.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteM.setText("DELETE");
        buttonDeleteM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteMActionPerformed(evt);
            }
        });
        TabMating.add(buttonDeleteM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 110, 30));

        buttonCClose4.setBackground(new java.awt.Color(204, 204, 255));
        buttonCClose4.setForeground(new java.awt.Color(0, 0, 0));
        buttonCClose4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCClose4.setText("CLOSE");
        buttonCClose4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCClose4ActionPerformed(evt);
            }
        });
        TabMating.add(buttonCClose4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 110, 30));

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jLabel93.setText("jLabel69");
        TabMating.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 650));

        tabSubpan.addTab("Mating Herd", TabMating);

        tabCalves.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("VIEW / ADD / EDIT / DELETE CALF INFORMATION");
        tabCalves.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1182, -1));

        searchBar.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH LIVESTOCK"));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel72.setText("Tag ID:");

        buttonViewCalf.setBackground(new java.awt.Color(204, 204, 255));
        buttonViewCalf.setForeground(new java.awt.Color(0, 0, 0));
        buttonViewCalf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonViewCalf.setText("SEARCH");
        buttonViewCalf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewCalfActionPerformed(evt);
            }
        });

        buttonUpdateCC.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateCC.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateCC.setText("UPDATE");
        buttonUpdateCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateCCActionPerformed(evt);
            }
        });

        buttonDeleteCC.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteCC.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteCC.setText("DELETE");
        buttonDeleteCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteCCActionPerformed(evt);
            }
        });

        buttonCloseC.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseC.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseC.setText("CLOSE");
        buttonCloseC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseCActionPerformed(evt);
            }
        });

        buttonClearCC.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearCC.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearCC.setText("CLEAR");
        buttonClearCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearCCActionPerformed(evt);
            }
        });

        tfSearchID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        tfSearchID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfSearchIDFocusGained(evt);
            }
        });

        radioUpdateCC.setForeground(new java.awt.Color(51, 51, 51));
        radioUpdateCC.setText("Update Fields");
        radioUpdateCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioUpdateCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchBarLayout = new javax.swing.GroupLayout(searchBar);
        searchBar.setLayout(searchBarLayout);
        searchBarLayout.setHorizontalGroup(
            searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonViewCalf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(radioUpdateCC)
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateCC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteCC, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearCC, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        searchBarLayout.setVerticalGroup(
            searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBarLayout.createSequentialGroup()
                        .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonViewCalf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonUpdateCC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDeleteCC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCloseC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72)
                            .addComponent(tfSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioUpdateCC))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonClearCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabCalves.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1300, -1));

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 0, 0));
        jLabel98.setText("Tag ID Nr:");

        ccTag.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ccTag.setForeground(new java.awt.Color(0, 0, 0));

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        jLabel99.setText("Name:");

        ccName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ccName.setForeground(new java.awt.Color(0, 0, 0));

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 0, 0));
        jLabel100.setText("Breed:");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 0, 0));
        jLabel101.setText("Date-of-Birth:");

        ccDob.setForeground(new java.awt.Color(0, 0, 0));
        ccDob.setDateFormatString("yyyy-MM-dd");

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 0, 0));
        jLabel102.setText("Gender:");

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 0, 0));
        jLabel103.setText("Stud / Com:");

        jLabel104.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 0, 0));
        jLabel104.setText("Paddock:");

        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 0, 0));
        jLabel105.setText("Herd Group:");

        jLabel106.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jLabel106.setText("Birth Weight:");

        ccBirthWeight.setForeground(new java.awt.Color(0, 0, 0));

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 0, 0));
        jLabel111.setText("Sire ID:");

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 0, 0));
        jLabel112.setText("Dam ID:");

        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 0, 0));
        jLabel113.setText("Birth Statues:");

        jLabel114.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 0));
        jLabel114.setText("Health Statues:");

        jLabel115.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 0, 0));
        jLabel115.setText("Horn Statues:");

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "CALF HEALTH HISTORY"));

        tableCalfHealth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Date-of-Birth", "Disease", "Medication", "Application", "Dosage", "Treatement Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane22.setViewportView(tableCalfHealth);
        if (tableCalfHealth.getColumnModel().getColumnCount() > 0) {
            tableCalfHealth.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableCalfHealth.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableCalfHealth.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableCalfHealth.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableCalfHealth.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableCalfHealth.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableCalfHealth.getColumnModel().getColumn(6).setPreferredWidth(20);
            tableCalfHealth.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableCalfHealth.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableCalfHealth.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableCalfHealth.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel116.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 0, 0));
        jLabel116.setText("Wean Weight:");

        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 0, 0));
        jLabel117.setText("Wean Date:");

        ccWeanWeight.setForeground(new java.awt.Color(0, 0, 0));

        ccWeanDate.setForeground(new java.awt.Color(0, 0, 0));
        ccWeanDate.setDateFormatString("yyyy-MM-dd");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(51, 51, 51));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("AGRI8 Assist - New born calves up to weaning age can be add to this section. UPDATE: Search calf, then select \"Update Fields\", add changes and click update button!");

        ccGender.setEditable(true);
        ccGender.setForeground(new java.awt.Color(0, 0, 0));
        ccGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Dam (Female)", "Sire (Male)", "Other" }));

        ccBreed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrikaner", "Angus", "Ankole", "Beefmaster", "Bonsmara", "Boran", "Brahman", "Braunivieh", "Charolais", "Drakensberger", "Hereford", "Limousin", "Nguni", "Other", "Santa Gertrudis", "Shorthorn", "Simbra", "Simmentaler", "Susses", "Tuli", "Wagyu" }));

        ccPaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        ccPaddock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ccPaddockFocusGained(evt);
            }
        });
        ccPaddock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccPaddockActionPerformed(evt);
            }
        });

        ccHerdGroup.setEditable(true);
        ccHerdGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        ccHerdGroup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ccHerdGroupFocusGained(evt);
            }
        });

        ccBirthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Alive", "Dead (Born Dead)", "Dead (Calving Difficulty)", "Dead (Scavanger animal)", "Dead (Other)" }));

        ccHealthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Healthy (Above average)", "Healthy", "Poor Condition", "Sick", " " }));

        ccHornStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Horned", "Polled", "Scurs" }));

        ccStudCom.setForeground(new java.awt.Color(0, 0, 0));
        ccStudCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Sire Commercial Dam)", "Stud / Com (Stud Dam, Commercial Sire)" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel98)
                                    .addComponent(jLabel100)
                                    .addComponent(jLabel99))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ccTag, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(ccName, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(ccBreed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel101)
                                .addGap(18, 18, 18)
                                .addComponent(ccDob, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel102))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ccGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ccStudCom, 0, 1, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel106)
                                    .addComponent(jLabel104))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ccBirthWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(ccPaddock, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel116)
                                    .addComponent(jLabel111)
                                    .addComponent(jLabel105))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ccWeanDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ccWeanWeight)
                                    .addComponent(ccSireID)
                                    .addComponent(ccHerdGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel117))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel112)
                            .addComponent(jLabel115)
                            .addComponent(jLabel114)
                            .addComponent(jLabel113))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ccDamID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(ccBirthStatues, 0, 1, Short.MAX_VALUE)
                            .addComponent(ccHealthStatues, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                            .addComponent(ccHornStatues, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel99)
                                    .addComponent(ccName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(ccTag, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel100)
                            .addComponent(ccBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel101)
                            .addComponent(ccDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel103)
                                        .addComponent(ccStudCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel105)
                                        .addComponent(ccHerdGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel102)
                                            .addComponent(ccGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel106)
                                            .addComponent(ccBirthWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel104)
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel111)
                                                .addComponent(ccPaddock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel116)
                                                    .addComponent(ccWeanWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel117))
                                            .addComponent(ccWeanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(ccSireID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel112)
                                    .addComponent(ccDamID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel113)
                                    .addComponent(ccBirthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel114)
                                    .addComponent(ccHealthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel115)
                                    .addComponent(ccHornStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(26, 26, 26)
                .addComponent(jLabel75)
                .addGap(18, 18, 18)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jScrollPane14.setViewportView(jPanel10);

        tabCalves.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1290, 460));

        buttonCAdd2.setBackground(new java.awt.Color(204, 204, 255));
        buttonCAdd2.setForeground(new java.awt.Color(0, 0, 0));
        buttonCAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        buttonCAdd2.setText("Add Calf");
        buttonCAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCAdd2ActionPerformed(evt);
            }
        });
        tabCalves.add(buttonCAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, 104, 37));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jLabel70.setText("jLabel69");
        tabCalves.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 640));

        tabSubpan.addTab("Calves", tabCalves);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonAddWeaner.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddWeaner.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonAddWeaner.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddWeaner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        buttonAddWeaner.setText("Add Weaner");
        buttonAddWeaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddWeanerActionPerformed(evt);
            }
        });
        jPanel8.add(buttonAddWeaner, new org.netbeans.lib.awtextra.AbsoluteConstraints(1165, 20, 150, 40));

        labelHeading.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelHeading.setForeground(new java.awt.Color(0, 0, 0));
        labelHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeading.setText("VIEW / ADD / EDIT / WEANER INFORMATION");
        jPanel8.add(labelHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1182, -1));

        searchBar3.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTER WEANERS"));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel79.setText("Tag ID:");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel81.setText("Paddock:");

        buttonUpdateWeaner.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateWeaner.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateWeaner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateWeaner.setText("UPDATE");
        buttonUpdateWeaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateWeanerActionPerformed(evt);
            }
        });

        buttonDeleteWeaner.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteWeaner.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteWeaner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteWeaner.setText("DELETE");
        buttonDeleteWeaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteWeanerActionPerformed(evt);
            }
        });

        buttonCloseWeaner.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseWeaner.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseWeaner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseWeaner.setText("CLOSE");
        buttonCloseWeaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseWeanerActionPerformed(evt);
            }
        });

        buttonClearWeaner.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearWeaner.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearWeaner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearWeaner.setText("CLEAR");
        buttonClearWeaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearWeanerActionPerformed(evt);
            }
        });

        filterPaddockCattle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterPaddockCattle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterPaddockCattleItemStateChanged(evt);
            }
        });
        filterPaddockCattle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterPaddockCattleFocusGained(evt);
            }
        });

        filterWeanerTagCattle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterWeanerTagCattle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterWeanerTagCattleItemStateChanged(evt);
            }
        });
        filterWeanerTagCattle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterWeanerTagCattleFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar3Layout = new javax.swing.GroupLayout(searchBar3);
        searchBar3.setLayout(searchBar3Layout);
        searchBar3Layout.setHorizontalGroup(
            searchBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79)
                .addGap(18, 18, 18)
                .addComponent(filterWeanerTagCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel81)
                .addGap(18, 18, 18)
                .addComponent(filterPaddockCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(buttonUpdateWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        searchBar3Layout.setVerticalGroup(
            searchBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar3Layout.createSequentialGroup()
                        .addGroup(searchBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(buttonUpdateWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDeleteWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79)
                            .addComponent(filterPaddockCattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterWeanerTagCattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonCloseWeaner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearWeaner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(searchBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1300, -1));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(51, 51, 51));
        jLabel82.setText("AGRI8 - Assist: Filter the Table below by typing the Tag ID or Weight in the Textboxs Above.");
        jPanel8.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(51, 51, 51));
        jLabel83.setText("AGRI8 -Assist: DELETE a field in the Table below by selecting a row and then click the \"DELETE BUTTON\".");
        jPanel8.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        tableWeanerCattle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Gender", "Paddock", "Stud / Com", "Herd Group", "Weaner Type", "W Weight", "Wean Date", "Sale / Mate Date", "Sire", "Dam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(tableWeanerCattle);
        if (tableWeanerCattle.getColumnModel().getColumnCount() > 0) {
            tableWeanerCattle.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableWeanerCattle.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableWeanerCattle.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableWeanerCattle.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1290, 430));

        labelBg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel8.add(labelBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 680));

        tabSubpan.addTab("Weaners", jPanel8);

        tabAnimaleHealth.setBackground(new java.awt.Color(204, 204, 204));
        tabAnimaleHealth.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonAddVacc.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddVacc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonAddVacc.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddVacc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cow-breed-16.png"))); // NOI18N
        buttonAddVacc.setText("ADD ANIMAL DISEASE");
        buttonAddVacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddVaccActionPerformed(evt);
            }
        });
        tabAnimaleHealth.add(buttonAddVacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 20, 180, 37));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("ANIMAL HEALTH DISEASE AND VACCINATION RECORD");
        tabAnimaleHealth.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1310, -1));

        searchBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH ANIMAL HEALTH"));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel86.setText("Tag ID:");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel88.setText("Vaccination:");

        buttonDeleteA.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteA.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteA.setText("DELETE");
        buttonDeleteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteAActionPerformed(evt);
            }
        });

        buttonCClose3.setBackground(new java.awt.Color(204, 204, 255));
        buttonCClose3.setForeground(new java.awt.Color(0, 0, 0));
        buttonCClose3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCClose3.setText("CLOSE");
        buttonCClose3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCClose3ActionPerformed(evt);
            }
        });

        buttonClearA.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearA.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearA.setText("CLEAR");
        buttonClearA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearAActionPerformed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel89.setText("Diseases:");

        filterDiseaseCattle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Anthrax", "Blue Tongue", "Botulism", "Brucellosis (Contagious Abortion)", "Cattle Tick-Fever", "Corridor Disease", "East Coast Fever", "Eye-infection (Opthalmia)", "Epivag", "Foot and Mouth Disease (Notifiable Diseases)", "Footrot (Foul in the Foot)", "Gallsikness (Anaplasmosis)", "Gonderiosis Theileriasis", "Heartwater", "Malignant Oedema (Clostridium)", "Mastitis", "Navil ill  - E. coli", "Navil ill - Pasteurella", "Liver Flukes (Tremotodes)", "Lumpy Skin Disease", "ORF or Pastular Dermatitis", "Pasteurellosis", "Poison - Arsenical Dips", "Poison - Nitrate Poisoning", "Poison - Lead Poisoning", "Poison - Organo (Chloride Dips)", "Poison - Organo  (Phoshpate Poisoning)", "Poison - Urea Poisoning", "Pulpy Kidney - (Enteroxaemia)", "Quater Evil / Black Leg", "Rabies", "Redwater - (Babesiosis)", "Rift Valley Fever", "Salmonella - (Paratypnoid)", "Scab", "Sleeping Sickness (Trypanosomiasis)", "Sweating Sickness", "Swin erysipelas", "Tetanus", "Theileriosis", "Three Day Sickness (Ephemeral Fever)", "Trichomoniasis", "Trypanosomiasis (Notifable Disease)", "Tuberculosis", "Twin-lamb Disease", "Vibriosis", "White scours (E. coli)", "Worms - Bankruptworm", "Worms - Brown stomachworm", "Worms - Hookworms", "Worms - Nodularworms", "Worms - Ringworm", "Worms - Screwworm", "Worms - Wireworm", "Worms - Tapeworm (Cestades)", " " }));
        filterDiseaseCattle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterDiseaseCattleItemStateChanged(evt);
            }
        });
        filterDiseaseCattle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterDiseaseCattleFocusGained(evt);
            }
        });

        filterVaccCattle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Castration", "Dipping", "Docking", "Hoof Trimming" }));
        filterVaccCattle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterVaccCattleItemStateChanged(evt);
            }
        });
        filterVaccCattle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterVaccCattleFocusGained(evt);
            }
        });

        filterTagCattle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterTagCattle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterTagCattleItemStateChanged(evt);
            }
        });
        filterTagCattle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterTagCattleFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar1Layout = new javax.swing.GroupLayout(searchBar1);
        searchBar1.setLayout(searchBar1Layout);
        searchBar1Layout.setHorizontalGroup(
            searchBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterTagCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel88)
                .addGap(18, 18, 18)
                .addComponent(filterVaccCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterDiseaseCattle, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(buttonDeleteA, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearA, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCClose3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        searchBar1Layout.setVerticalGroup(
            searchBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar1Layout.createSequentialGroup()
                        .addGroup(searchBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCClose3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86)
                            .addComponent(filterTagCattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88)
                            .addComponent(filterVaccCattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDeleteA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel89)
                        .addComponent(filterDiseaseCattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonClearA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabAnimaleHealth.add(searchBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1300, -1));

        tableAnimalHealth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "DOB", "Disease", "Medication", "Application", "Dosage", "Treatment Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(tableAnimalHealth);
        if (tableAnimalHealth.getColumnModel().getColumnCount() > 0) {
            tableAnimalHealth.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableAnimalHealth.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableAnimalHealth.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableAnimalHealth.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableAnimalHealth.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableAnimalHealth.getColumnModel().getColumn(5).setPreferredWidth(100);
            tableAnimalHealth.getColumnModel().getColumn(6).setPreferredWidth(30);
            tableAnimalHealth.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableAnimalHealth.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableAnimalHealth.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableAnimalHealth.getColumnModel().getColumn(10).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabAnimaleHealth.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1300, 430));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(51, 51, 51));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("AGRI8 Assist - Here you can Filter the table by either, Tag-id, Vaccinations or Diseases!                            DELETE a field in the Table below by first searching the animal, then select a row in the table and click the \"DELETE BUTTON\".");
        tabAnimaleHealth.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1290, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jLabel84.setText("jLabel69");
        tabAnimaleHealth.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 690));

        tabSubpan.addTab("Cattle Health", tabAnimaleHealth);

        tabCattle.add(tabSubpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, 1340, 660));

        jTabbedPane1.addTab("Cattle", tabCattle);

        jPanel2.setBackground(new java.awt.Color(101, 53, 15));

        goatSubPane.setBackground(new java.awt.Color(204, 204, 255));
        goatSubPane.setForeground(new java.awt.Color(0, 0, 0));

        jPanel13.setBackground(new java.awt.Color(212, 175, 55));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "SEARCH ANIMAL / HERDS"));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("TAG NR:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("PADDOCK:");

        filterPaddockGoats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterPaddockGoats.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterPaddockGoatsItemStateChanged(evt);
            }
        });
        filterPaddockGoats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterPaddockGoatsFocusGained(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel73.setText("GROUP:");

        filterHerdGoats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterHerdGoats.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterHerdGoatsItemStateChanged(evt);
            }
        });
        filterHerdGoats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterHerdGoatsFocusGained(evt);
            }
        });

        buttonCloseG.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseG.setForeground(new java.awt.Color(51, 51, 51));
        buttonCloseG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseG.setText("CLOSE");
        buttonCloseG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseGActionPerformed(evt);
            }
        });

        filterTagG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterTagG.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterTagGItemStateChanged(evt);
            }
        });
        filterTagG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterTagGFocusGained(evt);
            }
        });

        buttonClearG.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearG.setForeground(new java.awt.Color(51, 51, 51));
        buttonClearG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClearG.setText("CLEAR");
        buttonClearG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(filterTagG, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel73)
                .addGap(18, 18, 18)
                .addComponent(filterHerdGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(filterPaddockGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(buttonClearG, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(buttonCloseG, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCloseG, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClearG, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(filterTagG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73)
                            .addComponent(filterHerdGoats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(filterPaddockGoats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1310, 70));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GOAT LIVESTOCK MANAGEMENT");
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1335, 33));

        tableGoats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Breed", "Date-of-Birth", "Stud / Com", "Gender", "Paddock", "Herd Group", "B Weight", "W Weight", "Wean Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableGoats);
        if (tableGoats.getColumnModel().getColumnCount() > 0) {
            tableGoats.getColumnModel().getColumn(7).setPreferredWidth(150);
            tableGoats.getColumnModel().getColumn(9).setPreferredWidth(50);
        }

        jScrollPane3.setViewportView(jScrollPane4);

        jPanel13.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 172, 1310, 420));

        labelBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel13.add(labelBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 610));

        goatSubPane.addTab("Main Goat Page", jPanel13);

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel27.setBackground(new java.awt.Color(204, 204, 204));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("VIEW / ADD / EDIT / DELETE INDIVIDUAL GOATS");

        buttonGAdd.setBackground(new java.awt.Color(204, 204, 255));
        buttonGAdd.setForeground(new java.awt.Color(0, 0, 0));
        buttonGAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonGAdd.setText("Add Goats");
        buttonGAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGAddActionPerformed(evt);
            }
        });

        panelSearch1.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH LIVESTOCK"));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel48.setText("Tag ID:");

        buttonGSearch.setBackground(new java.awt.Color(204, 204, 255));
        buttonGSearch.setForeground(new java.awt.Color(0, 0, 0));
        buttonGSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonGSearch.setText("SEARCH");
        buttonGSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGSearchActionPerformed(evt);
            }
        });

        buttonGUpdate.setBackground(new java.awt.Color(204, 204, 255));
        buttonGUpdate.setForeground(new java.awt.Color(0, 0, 0));
        buttonGUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonItem.png"))); // NOI18N
        buttonGUpdate.setText("UPDATE");
        buttonGUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGUpdateActionPerformed(evt);
            }
        });

        buttonGDelete.setBackground(new java.awt.Color(204, 204, 255));
        buttonGDelete.setForeground(new java.awt.Color(0, 0, 0));
        buttonGDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonGDelete.setText("DELETE");
        buttonGDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGDeleteActionPerformed(evt);
            }
        });

        buttonGClose.setBackground(new java.awt.Color(204, 204, 255));
        buttonGClose.setForeground(new java.awt.Color(0, 0, 0));
        buttonGClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonGClose.setText("CLOSE");
        buttonGClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGCloseActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("AGRI8 Assist - Click 'CLEAR BUTTON' to search next Animal!");

        buttonClearGoats.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearGoats.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearGoats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClearGoats.setText("CLEAR");
        buttonClearGoats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearGoatsActionPerformed(evt);
            }
        });

        filterTagGoats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        javax.swing.GroupLayout panelSearch1Layout = new javax.swing.GroupLayout(panelSearch1);
        panelSearch1.setLayout(panelSearch1Layout);
        panelSearch1Layout.setHorizontalGroup(
            panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearch1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterTagGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGClose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelSearch1Layout.setVerticalGroup(
            panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearch1Layout.createSequentialGroup()
                .addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSearch1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel48)
                                .addComponent(filterTagGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36)))
                    .addGroup(panelSearch1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonGSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonClearGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));

        jPanel33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel33.setForeground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Tag ID Nr:");

        GONE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GONE.setForeground(new java.awt.Color(0, 0, 0));
        GONE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GONE.setEnabled(false);
        GONE.setPreferredSize(new java.awt.Dimension(64, 22));
        GONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GONEActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 0));
        jLabel74.setText("Name:");

        GTWO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GTWO.setForeground(new java.awt.Color(0, 0, 0));
        GTWO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GTWO.setEnabled(false);
        GTWO.setPreferredSize(new java.awt.Dimension(64, 22));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Breed:");

        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setText("Date-of-Birth:");

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 0, 0));
        jLabel108.setText("Gender:");

        jLabel109.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 0, 0));
        jLabel109.setText("Stud / Com:");

        jLabel110.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 0, 0));
        jLabel110.setText("Paddock:");

        jLabel118.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 0, 0));
        jLabel118.setText("Herd Type:");

        jLabel119.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 0, 0));
        jLabel119.setText("Birth Weight:");

        GNINE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GNINE.setForeground(new java.awt.Color(0, 0, 0));
        GNINE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GNINE.setEnabled(false);
        GNINE.setPreferredSize(new java.awt.Dimension(64, 22));
        GNINE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GNINEKeyPressed(evt);
            }
        });

        jLabel120.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 0, 0));
        jLabel120.setText("Breeding Status:");

        jLabel121.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 0));
        jLabel121.setText("Mating Date:");

        jLabel122.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(0, 0, 0));
        jLabel122.setText("Mating Method:");

        GSIXSTEEN.setEditable(false);
        GSIXSTEEN.setForeground(new java.awt.Color(0, 0, 0));
        GSIXSTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GSIXSTEEN.setEnabled(false);
        GSIXSTEEN.setMinimumSize(new java.awt.Dimension(149, 22));

        GTHREE.setForeground(new java.awt.Color(0, 0, 0));
        GTHREE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GTHREE.setEnabled(false);

        GFIVE.setForeground(new java.awt.Color(0, 0, 0));
        GFIVE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GFIVE.setEnabled(false);

        GSIXS.setForeground(new java.awt.Color(0, 0, 0));
        GSIXS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GSIXS.setEnabled(false);

        jLabel123.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(0, 0, 0));
        jLabel123.setText("Mating Ram:");

        GSEVENTEEN.setEditable(false);
        GSEVENTEEN.setForeground(new java.awt.Color(0, 0, 0));
        GSEVENTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GSEVENTEEN.setEnabled(false);

        GSEVEN.setForeground(new java.awt.Color(0, 0, 0));
        GSEVEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GSEVEN.setEnabled(false);

        GEIGHT.setForeground(new java.awt.Color(0, 0, 0));
        GEIGHT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GEIGHT.setEnabled(false);

        GFOURTEEN.setForeground(new java.awt.Color(0, 0, 0));
        GFOURTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GFOURTEEN.setEnabled(false);
        GFOURTEEN.setMinimumSize(new java.awt.Dimension(149, 22));
        GFOURTEEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GFOURTEENActionPerformed(evt);
            }
        });

        jLabel127.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 0, 0));
        jLabel127.setText("1st gener Ewe Nr:");

        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 0, 0));
        jLabel128.setText("1st gener Ram nr:");

        GTWENTYONE.setForeground(new java.awt.Color(0, 0, 0));
        GTWENTYONE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GTWENTYONE.setEnabled(false);

        GTWENTYTWO.setForeground(new java.awt.Color(0, 0, 0));
        GTWENTYTWO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GTWENTYTWO.setEnabled(false);

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "MATING AND LAMBING HISTORY"));

        tableGoatLamHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Herd Group", "Paddock", "Mating Ram", "Method", "Rams-in", "Rams-out", "Lambing-start", "Lambing-Ends", "Next mating", "Weaning Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(tableGoatLamHistory);
        if (tableGoatLamHistory.getColumnModel().getColumnCount() > 0) {
            tableGoatLamHistory.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableGoatLamHistory.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableGoatLamHistory.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "ANIMALE HEALTH HISTORY"));

        tableGoatHealthHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Date-of-Birth", "Disease", "Medication", "Application", "Dosage", "Treatement Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane18.setViewportView(tableGoatHealthHistory);
        if (tableGoatHealthHistory.getColumnModel().getColumnCount() > 0) {
            tableGoatHealthHistory.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableGoatHealthHistory.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableGoatHealthHistory.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableGoatHealthHistory.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableGoatHealthHistory.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableGoatHealthHistory.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableGoatHealthHistory.getColumnModel().getColumn(6).setPreferredWidth(20);
            tableGoatHealthHistory.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableGoatHealthHistory.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableGoatHealthHistory.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableGoatHealthHistory.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );

        jLabel129.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 0, 0));
        jLabel129.setText("Wean Weight:");

        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 0, 0));
        jLabel130.setText("Wean Date:");

        GTEN.setForeground(new java.awt.Color(0, 0, 0));
        GTEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GTEN.setEnabled(false);
        GTEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GTENActionPerformed(evt);
            }
        });
        GTEN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GTENKeyPressed(evt);
            }
        });

        jLabel131.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 0, 0));
        jLabel131.setText("12 Month Weight:");

        jLabel132.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(0, 0, 0));
        jLabel132.setText("12M Weight Date:");

        GTWELEVE.setForeground(new java.awt.Color(0, 0, 0));
        GTWELEVE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GTWELEVE.setEnabled(false);
        GTWELEVE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GTWELEVEKeyPressed(evt);
            }
        });

        GFIFTHTEEN.setEditable(false);
        GFIFTHTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GFIFTHTEEN.setEnabled(false);

        GELEVEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GELEVEN.setEnabled(false);

        GFOUR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GFOUR.setEnabled(false);

        GTHIRTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GTHIRTEEN.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel109)
                    .addComponent(jLabel108)
                    .addComponent(jLabel35)
                    .addComponent(jLabel107)
                    .addComponent(jLabel119)
                    .addComponent(jLabel118)
                    .addComponent(jLabel110)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel80)
                        .addComponent(jLabel74)))
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GNINE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GSEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GSIXS, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GONE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel131)
                            .addComponent(jLabel132)
                            .addComponent(jLabel120)
                            .addComponent(jLabel121)
                            .addComponent(jLabel122)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel129)
                                    .addComponent(jLabel123)
                                    .addComponent(jLabel130)
                                    .addComponent(jLabel127)
                                    .addComponent(jLabel128))))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(GTWELEVE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GTHIRTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GFOURTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GSIXSTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GFIFTHTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GSEVENTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GELEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(GTWENTYTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GTWENTYONE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(GONE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addComponent(GTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel107)
                            .addComponent(GFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel109))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GSIXS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel108))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GSEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel110)
                            .addComponent(jLabel129)
                            .addComponent(GTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(GTWELEVE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GTHIRTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel132))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GFOURTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel120))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel121)
                            .addComponent(GFIFTHTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GSIXSTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel122))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GSEVENTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel118)
                            .addComponent(jLabel130)
                            .addComponent(GELEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GNINE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GTWENTYONE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel127))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GTWENTYTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel128))
                        .addGap(28, 28, 28)))
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jScrollPane10.setViewportView(jPanel12);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(buttonGAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(panelSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel22.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1330, -1));

        goatSubPane.addTab("Add / Edit Goats", jPanel22);

        tabMatingGoats.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        jButton1.setText("Add Mating");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        tabMatingGoats.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 140, 40));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("GOAT MATING HERD AND RECORDS");
        tabMatingGoats.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1340, -1));

        searchBar4.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH LIVESTOCK"));

        jLabel134.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel134.setText("Tag ID:");

        jLabel136.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel136.setText("Lambing Starts:");

        filterMatingGoats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterMatingGoats.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterMatingGoatsItemStateChanged(evt);
            }
        });
        filterMatingGoats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterMatingGoatsFocusGained(evt);
            }
        });

        filterStartGoats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterStartGoats.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterStartGoatsItemStateChanged(evt);
            }
        });
        filterStartGoats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterStartGoatsFocusGained(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Next Mating:");

        filterNextGoats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterNextGoats.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterNextGoatsItemStateChanged(evt);
            }
        });
        filterNextGoats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterNextGoatsFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar4Layout = new javax.swing.GroupLayout(searchBar4);
        searchBar4.setLayout(searchBar4Layout);
        searchBar4Layout.setHorizontalGroup(
            searchBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel134)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterMatingGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel136)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterStartGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(filterNextGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        searchBar4Layout.setVerticalGroup(
            searchBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterNextGoats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(searchBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterStartGoats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel136))
                    .addGroup(searchBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel134)
                        .addComponent(filterMatingGoats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );

        tabMatingGoats.add(searchBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1300, 70));

        buttonUpdateM1.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateM1.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateM1.setText("UPDATE");
        buttonUpdateM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateM1ActionPerformed(evt);
            }
        });
        tabMatingGoats.add(buttonUpdateM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 110, 31));

        buttonClearM1.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearM1.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearM1.setText("CLEAR");
        buttonClearM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearM1ActionPerformed(evt);
            }
        });
        tabMatingGoats.add(buttonClearM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 110, 30));

        buttonDeleteM1.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteM1.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteM1.setText("DELETE");
        buttonDeleteM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteM1ActionPerformed(evt);
            }
        });
        tabMatingGoats.add(buttonDeleteM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 110, 30));

        buttonCClose5.setBackground(new java.awt.Color(204, 204, 255));
        buttonCClose5.setForeground(new java.awt.Color(0, 0, 0));
        buttonCClose5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCClose5.setText("CLOSE");
        buttonCClose5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCClose5ActionPerformed(evt);
            }
        });
        tabMatingGoats.add(buttonCClose5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 110, 30));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(51, 51, 51));
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel138.setText("AGRI8 Assist - Here you can filter the table by various methods!                                                                                                                                         \"DELETE a field in the Table below by selecting a row and then click the \"DELETE BUTTON\".");
        tabMatingGoats.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 1280, -1));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("INDIVIDUAL MATING GROUP"));

        tableMatingGoats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Herd Group", "Paddock", "Stud / Com", "Mating Sire", "Method", "Bulls-in", "Bulls-out", "Calving-Start", "Calving-Ends", "Next Mating", "Weaning Date"
            }
        ));
        jScrollPane21.setViewportView(tableMatingGoats);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 1294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel14);

        tabMatingGoats.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 1290, 350));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        tabMatingGoats.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 600));

        goatSubPane.addTab("Mating Herds", tabMatingGoats);

        tabKidsGoats.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonAddKid.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddKid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonAddKid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonAddKid.setText("Add Kid");
        buttonAddKid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddKidActionPerformed(evt);
            }
        });
        tabKidsGoats.add(buttonAddKid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, 110, 40));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel139.setText("VIEW / ADD / EDIT / DELETE KID INFORMATION");
        tabKidsGoats.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1182, -1));

        searchBar5.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH LIVESTOCK"));

        jLabel140.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel140.setText("Tag ID:");

        buttonViewK.setBackground(new java.awt.Color(204, 204, 255));
        buttonViewK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonViewK.setText("SEARCH");
        buttonViewK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewKActionPerformed(evt);
            }
        });

        buttonUpdateK.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateK.setText("UPDATE");
        buttonUpdateK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateKActionPerformed(evt);
            }
        });

        buttonDeleteK.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteK.setText("DELETE");
        buttonDeleteK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteKActionPerformed(evt);
            }
        });

        buttonCloseK.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseK.setText("CLOSE");
        buttonCloseK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseKActionPerformed(evt);
            }
        });

        buttonClearK.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearK.setText("CLEAR");
        buttonClearK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearKActionPerformed(evt);
            }
        });

        searchKid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        searchKid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchKidFocusGained(evt);
            }
        });

        radioUpdateG.setForeground(new java.awt.Color(51, 51, 51));
        radioUpdateG.setText("Update Fields");
        radioUpdateG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioUpdateGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchBar5Layout = new javax.swing.GroupLayout(searchBar5);
        searchBar5.setLayout(searchBar5Layout);
        searchBar5Layout.setHorizontalGroup(
            searchBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel140)
                .addGap(18, 18, 18)
                .addComponent(searchKid, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(buttonViewK, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(radioUpdateG)
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteK, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearK, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseK, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        searchBar5Layout.setVerticalGroup(
            searchBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar5Layout.createSequentialGroup()
                .addGroup(searchBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonClearK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonViewK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonUpdateK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDeleteK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCloseK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel140)
                        .addComponent(searchKid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioUpdateG)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tabKidsGoats.add(searchBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1290, 70));

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel141.setText("Tag ID Nr:");

        gTag.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gTag.setForeground(new java.awt.Color(0, 0, 0));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel142.setText("Name:");

        gName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gName.setForeground(new java.awt.Color(0, 0, 0));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel143.setText("Breed:");

        jLabel144.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel144.setText("Date-of-Birth:");

        gDob.setForeground(new java.awt.Color(0, 0, 0));
        gDob.setDateFormatString("yyyy-MM-dd");

        jLabel145.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel145.setText("Gender:");

        jLabel146.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel146.setText("Stud / Com:");

        jLabel147.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel147.setText("Paddock:");

        jLabel148.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel148.setText("Herd Group:");

        jLabel149.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel149.setText("Birth Weight:");

        gBirthWeight.setForeground(new java.awt.Color(0, 0, 0));

        jLabel150.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel150.setText("Ram ID:");

        jLabel151.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel151.setText("Ewe ID:");

        jLabel152.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel152.setText("Birth Statues:");

        jLabel153.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel153.setText("Health Statues:");

        jLabel154.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel154.setText("Horn Statues:");

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "KID HEALTH HISTORY"));

        tablegoatHealth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Date-of-Birth", "Disease", "Medication", "Application", "Dosage", "Treatement Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane23.setViewportView(tablegoatHealth);
        if (tablegoatHealth.getColumnModel().getColumnCount() > 0) {
            tablegoatHealth.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablegoatHealth.getColumnModel().getColumn(1).setPreferredWidth(50);
            tablegoatHealth.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablegoatHealth.getColumnModel().getColumn(3).setPreferredWidth(80);
            tablegoatHealth.getColumnModel().getColumn(4).setPreferredWidth(80);
            tablegoatHealth.getColumnModel().getColumn(5).setPreferredWidth(80);
            tablegoatHealth.getColumnModel().getColumn(6).setPreferredWidth(20);
            tablegoatHealth.getColumnModel().getColumn(7).setPreferredWidth(50);
            tablegoatHealth.getColumnModel().getColumn(8).setPreferredWidth(50);
            tablegoatHealth.getColumnModel().getColumn(9).setPreferredWidth(50);
            tablegoatHealth.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel155.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel155.setText("Wean Weight:");

        jLabel156.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel156.setText("Wean Date:");

        gWeanWeight.setForeground(new java.awt.Color(0, 0, 0));

        gWeanDate.setForeground(new java.awt.Color(0, 0, 0));
        gWeanDate.setDateFormatString("yyyy-MM-dd");

        jLabel157.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(51, 51, 51));
        jLabel157.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel157.setText("AGRI8 Assist - New born kids up to weaning age can be add to this section. UPDATE: Search kids, then select \"Update Fields\", add changes and click update button!");

        gGender.setForeground(new java.awt.Color(0, 0, 0));
        gGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Ewe (Female)", "Ram (Male)", "Other" }));

        gBreed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Angora", "Boer Goat", "British Alpine", "Indigenous Veld Goat ", "Kalahari Red", "Milch Goat", "Saanen", "Savannah White ", "Tankwa", "Toggenburg" }));

        gPaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        gPaddock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gPaddockFocusGained(evt);
            }
        });

        gHerdGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        gHerdGroup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gHerdGroupFocusGained(evt);
            }
        });

        gBirthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Alive", "Dead (Born Dead)", "Dead (Calving Difficulty)", "Dead (Scavanger animal)", "Dead (Other)" }));

        gHealthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Healthy (Above average)", "Healthy", "Poor Condition", "Sick", " " }));

        gHornStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Horned", "Polled", "Scurs" }));

        gStudCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Commercial Ewe)", "Stud / Com (Stud Ewe, Commercial Ram)" }));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel141)
                                    .addComponent(jLabel143)
                                    .addComponent(jLabel142))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gTag)
                                    .addComponent(gName)
                                    .addComponent(gBreed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel144)
                                .addGap(18, 18, 18)
                                .addComponent(gDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel146)
                                    .addComponent(jLabel145))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gGender, 0, 190, Short.MAX_VALUE)
                                    .addComponent(gStudCom, 0, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel149)
                                    .addComponent(jLabel147))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gBirthWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(gPaddock, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel155)
                                    .addComponent(jLabel150)
                                    .addComponent(jLabel148))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gWeanDate, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(gWeanWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(gRamID, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(gHerdGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel156))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel151)
                            .addComponent(jLabel154)
                            .addComponent(jLabel153)
                            .addComponent(jLabel152))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(gEweID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(gBirthStatues, 0, 1, Short.MAX_VALUE)
                            .addComponent(gHealthStatues, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                            .addComponent(gHornStatues, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel141)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel142)
                                    .addComponent(gName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(gTag, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel143)
                            .addComponent(gBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel144)
                            .addComponent(gDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel146)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel148)
                                        .addComponent(gHerdGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(gStudCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel145)
                                            .addComponent(gGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel149)
                                            .addComponent(gBirthWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel147)
                                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel150)
                                                .addComponent(gPaddock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel155)
                                                    .addComponent(gWeanWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel156))
                                            .addComponent(gWeanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(gRamID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel151)
                                    .addComponent(gEweID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel152)
                                    .addComponent(gBirthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel153)
                                    .addComponent(gHealthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel154)
                                    .addComponent(gHornStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(26, 26, 26)
                .addComponent(jLabel157)
                .addGap(18, 18, 18)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane11.setViewportView(jPanel18);

        tabKidsGoats.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1300, 410));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        tabKidsGoats.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 600));

        goatSubPane.addTab("Kids", tabKidsGoats);

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHeading1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelHeading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeading1.setText("VIEW / ADD / EDIT / WEANER INFORMATION");
        jPanel25.add(labelHeading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1300, -1));

        searchBar6.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTER WEANERS"));

        jLabel158.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel158.setText("Tag ID:");

        jLabel159.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel159.setText("Paddock:");

        buttonUpdateWeaner1.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateWeaner1.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateWeaner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateWeaner1.setText("UPDATE");
        buttonUpdateWeaner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateWeaner1ActionPerformed(evt);
            }
        });

        buttonDeleteWeaner1.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteWeaner1.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteWeaner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteWeaner1.setText("DELETE");
        buttonDeleteWeaner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteWeaner1ActionPerformed(evt);
            }
        });

        buttonCloseWeaner1.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseWeaner1.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseWeaner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseWeaner1.setText("CLOSE");
        buttonCloseWeaner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseWeaner1ActionPerformed(evt);
            }
        });

        buttonClearWeaner1.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearWeaner1.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearWeaner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearWeaner1.setText("CLEAR");
        buttonClearWeaner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearWeaner1ActionPerformed(evt);
            }
        });

        filterTypeGoats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterTypeGoats.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterTypeGoatsItemStateChanged(evt);
            }
        });
        filterTypeGoats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterTypeGoatsFocusGained(evt);
            }
        });

        filterGoatWeanerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterGoatWeanerID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterGoatWeanerIDItemStateChanged(evt);
            }
        });
        filterGoatWeanerID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterGoatWeanerIDFocusGained(evt);
            }
        });
        filterGoatWeanerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterGoatWeanerIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchBar6Layout = new javax.swing.GroupLayout(searchBar6);
        searchBar6.setLayout(searchBar6Layout);
        searchBar6Layout.setHorizontalGroup(
            searchBar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar6Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel158)
                .addGap(18, 18, 18)
                .addComponent(filterGoatWeanerID, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel159)
                .addGap(18, 18, 18)
                .addComponent(filterTypeGoats, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(buttonUpdateWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        searchBar6Layout.setVerticalGroup(
            searchBar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar6Layout.createSequentialGroup()
                .addGroup(searchBar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonUpdateWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDeleteWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClearWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCloseWeaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchBar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel158)
                        .addComponent(filterGoatWeanerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchBar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel159)
                        .addComponent(filterTypeGoats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.add(searchBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1290, -1));

        jLabel160.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(51, 51, 51));
        jLabel160.setText("AGRI8 - Assist: Filter the Table below by typing the Tag ID or Weight in the Textboxs Above.");
        jPanel25.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel161.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(51, 51, 51));
        jLabel161.setText("AGRI8 -Assist: DELETE a field in the Table below by selecting a row and then click the \"DELETE BUTTON\".");
        jPanel25.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        buttonAddWeaner1.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddWeaner1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonAddWeaner1.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddWeaner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonAddWeaner1.setText("Add Weaner");
        buttonAddWeaner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddWeaner1ActionPerformed(evt);
            }
        });
        jPanel25.add(buttonAddWeaner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, 150, 40));

        tableWeanerGoats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Gender", "Paddock", "Stud / Com", "Herd Group", "Weaner Type", "W Weight", "Wean Date", "Sale / Mate Date", "Ram", "Ewe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane24.setViewportView(tableWeanerGoats);
        if (tableWeanerGoats.getColumnModel().getColumnCount() > 0) {
            tableWeanerGoats.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableWeanerGoats.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableWeanerGoats.getColumnModel().getColumn(2).setPreferredWidth(40);
            tableWeanerGoats.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableWeanerGoats.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableWeanerGoats.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableWeanerGoats.getColumnModel().getColumn(6).setPreferredWidth(150);
            tableWeanerGoats.getColumnModel().getColumn(7).setPreferredWidth(40);
            tableWeanerGoats.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableWeanerGoats.getColumnModel().getColumn(9).setPreferredWidth(60);
            tableWeanerGoats.getColumnModel().getColumn(10).setPreferredWidth(40);
            tableWeanerGoats.getColumnModel().getColumn(11).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel25.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1290, 430));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel25.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 610));

        goatSubPane.addTab("Weaners", jPanel25);

        tabHealthGoat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAnimalHealthGoatsH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "DOB", "Disease", "Medication", "Application", "Dosage", "Treatment Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane25.setViewportView(tableAnimalHealthGoatsH);
        if (tableAnimalHealthGoatsH.getColumnModel().getColumnCount() > 0) {
            tableAnimalHealthGoatsH.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(5).setPreferredWidth(100);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(6).setPreferredWidth(30);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableAnimalHealthGoatsH.getColumnModel().getColumn(10).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabHealthGoat.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1300, 400));

        jLabel162.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(51, 51, 51));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel162.setText("AGRI8 Assist - Here you can Filter the table by either, Tag-id, Vaccinations or Diseases!                            DELETE a field in the Table below by first searching the animal, then select a row in the table and click the \"DELETE BUTTON\".");
        tabHealthGoat.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1290, -1));

        searchBar7.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH ANIMAL HEALTH"));

        jLabel163.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel163.setText("Tag ID:");

        jLabel164.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel164.setText("Vaccination:");

        buttonDeleteA1.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteA1.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteA1.setText("DELETE");
        buttonDeleteA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteA1ActionPerformed(evt);
            }
        });

        buttonCClose6.setBackground(new java.awt.Color(204, 204, 255));
        buttonCClose6.setForeground(new java.awt.Color(0, 0, 0));
        buttonCClose6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCClose6.setText("CLOSE");
        buttonCClose6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCClose6ActionPerformed(evt);
            }
        });

        buttonClearA1.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearA1.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearA1.setText("CLEAR");
        buttonClearA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearA1ActionPerformed(evt);
            }
        });

        jLabel165.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel165.setText("Diseases:");

        searchGoatDisease.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Anthrax", "Blue Tongue", "Botulism", "Brucellosis (Contagious Abortion)", "Cattle Tick-Fever", "Corridor Disease", "East Coast Fever", "Eye-infection (Opthalmia)", "Epivag", "Foot and Mouth Disease (Notifiable Diseases)", "Footrot (Foul in the Foot)", "Gallsikness (Anaplasmosis)", "Gonderiosis Theileriasis", "Heartwater", "Malignant Oedema (Clostridium)", "Mastitis", "Navil ill  - E. coli", "Navil ill - Pasteurella", "Liver Flukes (Tremotodes)", "Lumpy Skin Disease", "ORF or Pastular Dermatitis", "Pasteurellosis", "Poison - Arsenical Dips", "Poison - Nitrate Poisoning", "Poison - Lead Poisoning", "Poison - Organo (Chloride Dips)", "Poison - Organo  (Phoshpate Poisoning)", "Poison - Urea Poisoning", "Pulpy Kidney - (Enteroxaemia)", "Quater Evil / Black Leg", "Rabies", "Redwater - (Babesiosis)", "Rift Valley Fever", "Salmonella - (Paratypnoid)", "Scab", "Sleeping Sickness (Trypanosomiasis)", "Sweating Sickness", "Swin erysipelas", "Tetanus", "Theileriosis", "Three Day Sickness (Ephemeral Fever)", "Trichomoniasis", "Trypanosomiasis (Notifable Disease)", "Tuberculosis", "Twin-lamb Disease", "Vibriosis", "White scours (E. coli)", "Worms - Bankruptworm", "Worms - Brown stomachworm", "Worms - Hookworms", "Worms - Nodularworms", "Worms - Ringworm", "Worms - Screwworm", "Worms - Wireworm", "Worms - Tapeworm (Cestades)", " " }));
        searchGoatDisease.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchGoatDiseaseItemStateChanged(evt);
            }
        });
        searchGoatDisease.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchGoatDiseaseFocusGained(evt);
            }
        });

        searchGoatVacc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Castration", "Dipping", "Docking", "Hoof Trimming" }));
        searchGoatVacc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchGoatVaccItemStateChanged(evt);
            }
        });
        searchGoatVacc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchGoatVaccFocusGained(evt);
            }
        });

        searchGoatIDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        searchGoatIDH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchGoatIDHItemStateChanged(evt);
            }
        });
        searchGoatIDH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchGoatIDHFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar7Layout = new javax.swing.GroupLayout(searchBar7);
        searchBar7.setLayout(searchBar7Layout);
        searchBar7Layout.setHorizontalGroup(
            searchBar7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel163)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGoatIDH, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel164)
                .addGap(18, 18, 18)
                .addComponent(searchGoatVacc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel165)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGoatDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(buttonDeleteA1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearA1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCClose6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        searchBar7Layout.setVerticalGroup(
            searchBar7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBar7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar7Layout.createSequentialGroup()
                        .addGroup(searchBar7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCClose6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel163)
                            .addComponent(searchGoatIDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel164)
                            .addComponent(searchGoatVacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBar7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDeleteA1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel165)
                        .addComponent(searchGoatDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonClearA1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabHealthGoat.add(searchBar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1300, -1));

        buttonAddVacc1.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddVacc1.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddVacc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonAdd.png"))); // NOI18N
        buttonAddVacc1.setText("ADD ANIMAL DISEASE");
        buttonAddVacc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddVacc1ActionPerformed(evt);
            }
        });
        tabHealthGoat.add(buttonAddVacc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 20, 180, 37));

        jLabel166.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel166.setText("GOAT HEALTH DISEASE AND VACCINATION RECORD");
        tabHealthGoat.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1310, -1));

        labelBGGoatsA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBGGoatsA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        tabHealthGoat.add(labelBGGoatsA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 600));

        goatSubPane.addTab("Goat Health", tabHealthGoat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goatSubPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(goatSubPane, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Goats", jPanel2);

        jPanel3.setBackground(new java.awt.Color(101, 53, 15));

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("SHEEP LIVESTOCK MANAGEMENT");
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1335, 33));

        tableSheepMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Breed", "Date-of-Birth", "Stud / Com", "Gender", "Paddock", "Herd Group", "Birth Weight", "W Weight", "W Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableSheepMain);
        if (tableSheepMain.getColumnModel().getColumnCount() > 0) {
            tableSheepMain.getColumnModel().getColumn(7).setPreferredWidth(150);
            tableSheepMain.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        jScrollPane5.setViewportView(jScrollPane6);

        jPanel15.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 172, 1300, 440));

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "SEARCH ANIMAL / HERDS"));

        jLabel21.setText("TAG NR:");

        jLabel49.setText("HERD GROUP:");

        filterGenderSheep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterGenderSheep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterGenderSheepItemStateChanged(evt);
            }
        });
        filterGenderSheep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterGenderSheepFocusGained(evt);
            }
        });

        jLabel137.setText("PADDOCK:");

        filterPaddockSheep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterPaddockSheep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterPaddockSheepItemStateChanged(evt);
            }
        });
        filterPaddockSheep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterPaddockSheepFocusGained(evt);
            }
        });

        buttonCloseSM.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseSM.setForeground(new java.awt.Color(51, 51, 51));
        buttonCloseSM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseSM.setText("CLOSE");
        buttonCloseSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseSMActionPerformed(evt);
            }
        });

        filterTagSheep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        filterTagSheep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterTagSheepItemStateChanged(evt);
            }
        });
        filterTagSheep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filterTagSheepFocusGained(evt);
            }
        });

        buttonClearG1.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearG1.setForeground(new java.awt.Color(51, 51, 51));
        buttonClearG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClearG1.setText("CLEAR");
        buttonClearG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearG1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterTagSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(filterGenderSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel137)
                .addGap(29, 29, 29)
                .addComponent(filterPaddockSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(buttonClearG1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(buttonCloseSM, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClearG1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCloseSM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(filterTagSheep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel49)
                                .addComponent(filterGenderSheep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel137)
                                .addComponent(filterPaddockSheep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1290, 70));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel15.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1336, 621));

        jTabbedPane2.addTab("Main Sheep Page", jPanel15);

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("VIEW / ADD / EDIT / DELETE INDIVIDUAL SHEEP");
        jPanel16.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, -1));

        buttonSAdd.setBackground(new java.awt.Color(204, 204, 255));
        buttonSAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonSAdd.setForeground(new java.awt.Color(0, 0, 0));
        buttonSAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        buttonSAdd.setText("Add Sheep");
        buttonSAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSAddActionPerformed(evt);
            }
        });
        jPanel16.add(buttonSAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 40, 140, 40));

        panelSearch2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "SEARCH LIVESTOCK"));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel50.setText("Tag ID:");

        buttonSSearch.setBackground(new java.awt.Color(204, 204, 255));
        buttonSSearch.setForeground(new java.awt.Color(0, 0, 0));
        buttonSSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonSSearch.setText("SEARCH");
        buttonSSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSSearchActionPerformed(evt);
            }
        });

        buttonSUpdate.setBackground(new java.awt.Color(204, 204, 255));
        buttonSUpdate.setForeground(new java.awt.Color(0, 0, 0));
        buttonSUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonItem.png"))); // NOI18N
        buttonSUpdate.setText("UPDATE");
        buttonSUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSUpdateActionPerformed(evt);
            }
        });

        buttonSDelete.setBackground(new java.awt.Color(204, 204, 255));
        buttonSDelete.setForeground(new java.awt.Color(0, 0, 0));
        buttonSDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonSDelete.setText("DELETE");
        buttonSDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSDeleteActionPerformed(evt);
            }
        });

        buttonSClose.setBackground(new java.awt.Color(204, 204, 255));
        buttonSClose.setForeground(new java.awt.Color(0, 0, 0));
        buttonSClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonSClose.setText("CLOSE");
        buttonSClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSCloseActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("AGRI8 Assist - Click 'CLEAR BUTTON' to search next Animal!");

        buttonClearSheep.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearSheep.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClear.png"))); // NOI18N
        buttonClearSheep.setText("CLEAR");
        buttonClearSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearSheepActionPerformed(evt);
            }
        });

        TagIDSAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        TagIDSAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TagIDSAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSearch2Layout = new javax.swing.GroupLayout(panelSearch2);
        panelSearch2.setLayout(panelSearch2Layout);
        panelSearch2Layout.setHorizontalGroup(
            panelSearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearch2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TagIDSAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(buttonSSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSClose, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSearch2Layout.setVerticalGroup(
            panelSearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearch2Layout.createSequentialGroup()
                .addGroup(panelSearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(TagIDSAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(buttonSSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel16.add(panelSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1310, 70));

        jPanel31.setBackground(new java.awt.Color(204, 204, 255));

        jPanel36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel36.setForeground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImageS, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImageS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Tag ID Nr:");

        SONE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SONE.setForeground(new java.awt.Color(0, 0, 0));
        SONE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SONE.setEnabled(false);
        SONE.setPreferredSize(new java.awt.Dimension(64, 22));
        SONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SONEActionPerformed(evt);
            }
        });

        jLabel167.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(0, 0, 0));
        jLabel167.setText("Name:");

        STWO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        STWO.setForeground(new java.awt.Color(0, 0, 0));
        STWO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        STWO.setEnabled(false);
        STWO.setPreferredSize(new java.awt.Dimension(64, 22));

        jLabel168.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(0, 0, 0));
        jLabel168.setText("Breed:");

        jLabel169.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(0, 0, 0));
        jLabel169.setText("Date-of-Birth:");

        jLabel170.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(0, 0, 0));
        jLabel170.setText("Gender:");

        jLabel171.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(0, 0, 0));
        jLabel171.setText("Stud / Com:");

        jLabel172.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(0, 0, 0));
        jLabel172.setText("Paddock:");

        jLabel173.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(0, 0, 0));
        jLabel173.setText("Herd Type:");

        jLabel174.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(0, 0, 0));
        jLabel174.setText("Birth Weight:");

        SNINE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SNINE.setForeground(new java.awt.Color(0, 0, 0));
        SNINE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SNINE.setEnabled(false);
        SNINE.setPreferredSize(new java.awt.Dimension(64, 22));
        SNINE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SNINEKeyPressed(evt);
            }
        });

        jLabel175.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(0, 0, 0));
        jLabel175.setText("Breeding Status:");

        jLabel176.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(0, 0, 0));
        jLabel176.setText("Mating Date:");

        jLabel177.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(0, 0, 0));
        jLabel177.setText("Mating Method:");

        SSIXSTEEN.setEditable(false);
        SSIXSTEEN.setForeground(new java.awt.Color(0, 0, 0));
        SSIXSTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SSIXSTEEN.setEnabled(false);
        SSIXSTEEN.setMinimumSize(new java.awt.Dimension(149, 22));

        STHREE.setForeground(new java.awt.Color(0, 0, 0));
        STHREE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        STHREE.setEnabled(false);

        SFIVE.setForeground(new java.awt.Color(0, 0, 0));
        SFIVE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SFIVE.setEnabled(false);

        SSIXS.setForeground(new java.awt.Color(0, 0, 0));
        SSIXS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SSIXS.setEnabled(false);

        jLabel178.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(0, 0, 0));
        jLabel178.setText("Mating Ram:");

        SSEVENTEEN.setEditable(false);
        SSEVENTEEN.setForeground(new java.awt.Color(0, 0, 0));
        SSEVENTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SSEVENTEEN.setEnabled(false);

        SSEVEN.setForeground(new java.awt.Color(0, 0, 0));
        SSEVEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SSEVEN.setEnabled(false);

        SEIGHT.setForeground(new java.awt.Color(0, 0, 0));
        SEIGHT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SEIGHT.setEnabled(false);

        SFOURTEEN.setForeground(new java.awt.Color(0, 0, 0));
        SFOURTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SFOURTEEN.setEnabled(false);
        SFOURTEEN.setMinimumSize(new java.awt.Dimension(149, 22));
        SFOURTEEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SFOURTEENActionPerformed(evt);
            }
        });

        jLabel182.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(0, 0, 0));
        jLabel182.setText("1st gener Ram Nr:");

        jLabel183.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(0, 0, 0));
        jLabel183.setText("1st gener Ewe nr:");

        STWENTYONE.setForeground(new java.awt.Color(0, 0, 0));
        STWENTYONE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        STWENTYONE.setEnabled(false);

        STWENTYTWO.setForeground(new java.awt.Color(0, 0, 0));
        STWENTYTWO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        STWENTYTWO.setEnabled(false);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "MATING AND LAMBING HISTORY"));

        tableMatingHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Herd Group", "Paddock", "Mating Ram", "Method", "Rams-in", "Rams-out", "Lambing-start", "Lambing-Ends", "Next mating", "Weaning Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane26.setViewportView(tableMatingHistory);
        if (tableMatingHistory.getColumnModel().getColumnCount() > 0) {
            tableMatingHistory.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableMatingHistory.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableMatingHistory.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "ANIMALE HEALTH HISTORY"));

        tableSheepHealthHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Date-of-Birth", "Disease", "Medication", "Application", "Dosage", "Treatement Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane27.setViewportView(tableSheepHealthHistory);
        if (tableSheepHealthHistory.getColumnModel().getColumnCount() > 0) {
            tableSheepHealthHistory.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableSheepHealthHistory.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableSheepHealthHistory.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableSheepHealthHistory.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableSheepHealthHistory.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableSheepHealthHistory.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableSheepHealthHistory.getColumnModel().getColumn(6).setPreferredWidth(20);
            tableSheepHealthHistory.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableSheepHealthHistory.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableSheepHealthHistory.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableSheepHealthHistory.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );

        jLabel184.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(0, 0, 0));
        jLabel184.setText("Wean Weight:");

        jLabel185.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(0, 0, 0));
        jLabel185.setText("Wean Date:");

        STEN.setForeground(new java.awt.Color(0, 0, 0));
        STEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        STEN.setEnabled(false);
        STEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STENActionPerformed(evt);
            }
        });
        STEN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                STENKeyPressed(evt);
            }
        });

        jLabel186.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(0, 0, 0));
        jLabel186.setText("12 Month Weight:");

        jLabel187.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(0, 0, 0));
        jLabel187.setText("12M Weight Date:");

        STWELEVE.setForeground(new java.awt.Color(0, 0, 0));
        STWELEVE.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        STWELEVE.setEnabled(false);
        STWELEVE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                STWELEVEKeyPressed(evt);
            }
        });

        SFIFTHTEEN.setEditable(false);
        SFIFTHTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SFIFTHTEEN.setEnabled(false);

        SELEVEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SELEVEN.setEnabled(false);

        SFOUR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        SFOUR.setEnabled(false);

        STHIRTEEN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        STHIRTEEN.setEnabled(false);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel171)
                            .addComponent(jLabel170)
                            .addComponent(jLabel52)
                            .addComponent(jLabel169)
                            .addComponent(jLabel174)
                            .addComponent(jLabel173)
                            .addComponent(jLabel172)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel168)
                                .addComponent(jLabel167)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SNINE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSIXS, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(STHREE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(STWO, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SONE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel178)
                                    .addComponent(jLabel184)
                                    .addComponent(jLabel177)
                                    .addComponent(jLabel176)
                                    .addComponent(jLabel175)
                                    .addComponent(jLabel187)
                                    .addComponent(jLabel186))
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel31Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(STWELEVE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(STHIRTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SFOURTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SSIXSTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SFIFTHTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SSEVENTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(STEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel183)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(STWENTYTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel185)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SELEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel182)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(STWENTYONE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(SONE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(STWO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel167))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel168)
                            .addComponent(STHREE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel169)
                            .addComponent(SFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel171))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SSIXS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel170))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SSEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel172)))
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STWELEVE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel186))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STHIRTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel187))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SFOURTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel175))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(SFIFTHTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SSIXSTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel177)))
                            .addComponent(jLabel176))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SSEVENTEEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel178))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel184)
                            .addComponent(STEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel173)
                    .addComponent(SELEVEN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel185))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SNINE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel174)
                    .addComponent(jLabel182)
                    .addComponent(STWENTYONE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel183)
                    .addComponent(STWENTYTWO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        jScrollPane12.setViewportView(jPanel31);

        jPanel16.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 180, -1, 430));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel16.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1336, 621));

        jTabbedPane2.addTab("Add / Edit Sheep", jPanel16);

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddMatingSheep.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        btnAddMatingSheep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddMatingSheep.setText("SHEEP MATING HERD AND RECORDS");
        jPanel17.add(btnAddMatingSheep, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 1300, -1));

        searchBar8.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH LIVESTOCK"));

        jLabel189.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel189.setText("Tag ID:");

        jLabel191.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel191.setText("Lambing Starts:");

        matingIDSheep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        matingIDSheep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matingIDSheepItemStateChanged(evt);
            }
        });
        matingIDSheep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                matingIDSheepFocusGained(evt);
            }
        });

        matingStartSheep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        matingStartSheep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matingStartSheepItemStateChanged(evt);
            }
        });
        matingStartSheep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                matingStartSheepFocusGained(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setText("Next Mating:");

        searchNextMating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        searchNextMating.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchNextMatingItemStateChanged(evt);
            }
        });
        searchNextMating.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchNextMatingFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar8Layout = new javax.swing.GroupLayout(searchBar8);
        searchBar8.setLayout(searchBar8Layout);
        searchBar8Layout.setHorizontalGroup(
            searchBar8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel189)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matingIDSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel191)
                .addGap(18, 18, 18)
                .addComponent(matingStartSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(searchNextMating, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        searchBar8Layout.setVerticalGroup(
            searchBar8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBar8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel189)
                    .addComponent(matingIDSheep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel191)
                    .addComponent(matingStartSheep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(searchNextMating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel17.add(searchBar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1300, 70));

        buttonUpdateMatingSheep.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateMatingSheep.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateMatingSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateMatingSheep.setText("UPDATE");
        buttonUpdateMatingSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateMatingSheepActionPerformed(evt);
            }
        });
        jPanel17.add(buttonUpdateMatingSheep, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 110, 31));

        buttonDeleteMatingSheep.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteMatingSheep.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteMatingSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteMatingSheep.setText("DELETE");
        buttonDeleteMatingSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteMatingSheepActionPerformed(evt);
            }
        });
        jPanel17.add(buttonDeleteMatingSheep, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 110, 30));

        buttonClearMatingSheep.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearMatingSheep.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearMatingSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearMatingSheep.setText("CLEAR");
        buttonClearMatingSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearMatingSheepActionPerformed(evt);
            }
        });
        jPanel17.add(buttonClearMatingSheep, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 110, 30));

        buttonCloseMatingSheep.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseMatingSheep.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseMatingSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseMatingSheep.setText("CLOSE");
        buttonCloseMatingSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseMatingSheepActionPerformed(evt);
            }
        });
        jPanel17.add(buttonCloseMatingSheep, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 110, 30));

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        jButton3.setText("Add Mating");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 30, 140, 40));

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("INDIVIDUAL MATING GROUP"));

        tableMatingSheeps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Herd Group", "Paddock", "Stud / Com", "Mating Ram", "Method", "Rams-in", "Rams-out", "Lambing-Start", "Lambing-Ends", "Next Mating", "Weaning Date"
            }
        ));
        jScrollPane29.setViewportView(tableMatingSheeps);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 1294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        jScrollPane28.setViewportView(jPanel41);

        jPanel17.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 1290, 350));

        jLabel192.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(51, 51, 51));
        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel192.setText("AGRI8 Assist - Here you can filter the table by various methods!                                                                                                                                         \"DELETE a field in the Table below by selecting a row and then click the \"DELETE BUTTON\".");
        jPanel17.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1280, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel17.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1336, 621));

        jTabbedPane2.addTab("Mating Herd", jPanel17);

        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel188.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(0, 0, 0));
        jLabel188.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel188.setText("VIEW / ADD / EDIT / DELETE LAMB INFORMATION");
        jPanel26.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1182, -1));

        searchBar9.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH LIVESTOCK"));

        jLabel193.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel193.setText("Tag ID:");

        buttonViewS.setBackground(new java.awt.Color(204, 204, 255));
        buttonViewS.setForeground(new java.awt.Color(0, 0, 0));
        buttonViewS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonSearch.png"))); // NOI18N
        buttonViewS.setText("SEARCH");
        buttonViewS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewSActionPerformed(evt);
            }
        });

        buttonUpdateS.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateS.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateS.setText("UPDATE");
        buttonUpdateS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateSActionPerformed(evt);
            }
        });

        buttonDeleteS.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteS.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteS.setText("DELETE");
        buttonDeleteS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteSActionPerformed(evt);
            }
        });

        buttonCloseS.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseS.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseS.setText("CLOSE");
        buttonCloseS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseSActionPerformed(evt);
            }
        });

        buttonClearS.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearS.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearS.setText("CLEAR");
        buttonClearS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearSActionPerformed(evt);
            }
        });

        searchLamb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        searchLamb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchLambFocusGained(evt);
            }
        });

        radioUpdateS.setForeground(new java.awt.Color(51, 51, 51));
        radioUpdateS.setText("Update Fields");
        radioUpdateS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioUpdateSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchBar9Layout = new javax.swing.GroupLayout(searchBar9);
        searchBar9.setLayout(searchBar9Layout);
        searchBar9Layout.setHorizontalGroup(
            searchBar9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel193)
                .addGap(18, 18, 18)
                .addComponent(searchLamb, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(buttonViewS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(radioUpdateS)
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteS, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearS, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseS, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        searchBar9Layout.setVerticalGroup(
            searchBar9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar9Layout.createSequentialGroup()
                .addGroup(searchBar9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonClearS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchBar9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonViewS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonUpdateS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDeleteS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCloseS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel193)
                        .addComponent(searchLamb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioUpdateS)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel26.add(searchBar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1290, 70));

        buttonAddLamb.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddLamb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonAddLamb.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddLamb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        buttonAddLamb.setText("Add Lamb");
        buttonAddLamb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddLambActionPerformed(evt);
            }
        });
        jPanel26.add(buttonAddLamb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 130, 40));

        jPanel42.setBackground(new java.awt.Color(204, 204, 255));

        jLabel194.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(0, 0, 0));
        jLabel194.setText("Tag ID Nr:");

        sTag.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sTag.setForeground(new java.awt.Color(0, 0, 0));

        jLabel195.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(0, 0, 0));
        jLabel195.setText("Name:");

        sName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sName.setForeground(new java.awt.Color(0, 0, 0));

        jLabel196.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(0, 0, 0));
        jLabel196.setText("Breed:");

        jLabel197.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(0, 0, 0));
        jLabel197.setText("Date-of-Birth:");

        sDob.setForeground(new java.awt.Color(0, 0, 0));
        sDob.setDateFormatString("yyyy-MM-dd");

        jLabel198.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(0, 0, 0));
        jLabel198.setText("Gender:");

        jLabel199.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(0, 0, 0));
        jLabel199.setText("Stud / Com:");

        jLabel200.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(0, 0, 0));
        jLabel200.setText("Paddock:");

        jLabel201.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(0, 0, 0));
        jLabel201.setText("Herd Group:");

        jLabel202.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(0, 0, 0));
        jLabel202.setText("Birth Weight:");

        sBirthWeight.setForeground(new java.awt.Color(0, 0, 0));

        jLabel203.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(0, 0, 0));
        jLabel203.setText("Ram ID:");

        jLabel204.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(0, 0, 0));
        jLabel204.setText("Ewe ID:");

        jLabel205.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(0, 0, 0));
        jLabel205.setText("Birth Statues:");

        jLabel206.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(0, 0, 0));
        jLabel206.setText("Health Statues:");

        jLabel207.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(0, 0, 0));
        jLabel207.setText("Horn Statues:");

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "LAMB HEALTH HISTORY"));

        tableLambHealth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Date-of-Birth", "Disease", "Medication", "Application", "Dosage", "Treatement Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane31.setViewportView(tableLambHealth);
        if (tableLambHealth.getColumnModel().getColumnCount() > 0) {
            tableLambHealth.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableLambHealth.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableLambHealth.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableLambHealth.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableLambHealth.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableLambHealth.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableLambHealth.getColumnModel().getColumn(6).setPreferredWidth(20);
            tableLambHealth.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableLambHealth.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableLambHealth.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableLambHealth.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jScrollPane31, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel208.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(0, 0, 0));
        jLabel208.setText("Wean Weight:");

        jLabel209.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(0, 0, 0));
        jLabel209.setText("Wean Date:");

        sWeanWeight.setForeground(new java.awt.Color(0, 0, 0));

        sWeanDate.setForeground(new java.awt.Color(0, 0, 0));
        sWeanDate.setDateFormatString("yyyy-MM-dd");

        jLabel210.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(51, 51, 51));
        jLabel210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel210.setText("AGRI8 Assist - New born Lambs up to weaning age can be add to this section. UPDATE: Search lambs, then select \"Update Fields\", add changes and click update button!");

        sGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Ewe (Female)", "Ram (Male)", "Other" }));

        sBreed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Afrino", "Black-head Persian", "Corriedale", "Dohne Merino", "Dormer", "Dorper Sheep", "Dorset Horn", "Hampshire Down", "ile de France", "Karakul", "Meatmaster", "SA Mutton Merino", "SA Wool Merino", "Suffolk", "Vandor", "Van Rooyen", "Witlshire" }));

        sPaddock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        sPaddock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sPaddockFocusGained(evt);
            }
        });

        sHerdGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        sHerdGroup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sHerdGroupFocusGained(evt);
            }
        });

        sBirthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Alive", "Dead (Born Dead)", "Dead (Calving Difficulty)", "Dead (Scavanger animal)", "Dead (Other)" }));

        sHealthStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Healthy (Above average)", "Healthy", "Poor Condition", "Sick", " " }));

        sHornStatues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Horned", "Polled", "Scurs" }));

        sStudCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Commercial", "Stud", "Stud / Com (Stud Ram Commercial Ewe)", "Stud / Com (Stud Ewe, Commercial Ram)" }));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel194)
                                    .addComponent(jLabel196)
                                    .addComponent(jLabel195))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sTag)
                                    .addComponent(sName)
                                    .addComponent(sBreed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel197)
                                .addGap(18, 18, 18)
                                .addComponent(sDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel202)
                                    .addComponent(jLabel200))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sBirthWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(sPaddock, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel199)
                                    .addComponent(jLabel198))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sGender, 0, 183, Short.MAX_VALUE)
                                    .addComponent(sStudCom, 0, 1, Short.MAX_VALUE))))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel208)
                                    .addComponent(jLabel203)
                                    .addComponent(jLabel201))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sWeanDate, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(sWeanWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(sRamID, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(sHerdGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel209))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel204)
                            .addComponent(jLabel207)
                            .addComponent(jLabel206)
                            .addComponent(jLabel205))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sEweID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(sBirthStatues, 0, 1, Short.MAX_VALUE)
                            .addComponent(sHealthStatues, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                            .addComponent(sHornStatues, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel210, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel194)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel195)
                                    .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(sTag, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel196)
                            .addComponent(sBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel197)
                            .addComponent(sDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel199)
                                        .addComponent(sStudCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel201)
                                        .addComponent(sHerdGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel198)
                                            .addComponent(sGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel202)
                                            .addComponent(sBirthWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel200)
                                            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel203)
                                                .addComponent(sPaddock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel42Layout.createSequentialGroup()
                                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel208)
                                                    .addComponent(sWeanWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel209))
                                            .addComponent(sWeanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(sRamID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel204)
                                    .addComponent(sEweID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel205)
                                    .addComponent(sBirthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel206)
                                    .addComponent(sHealthStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel207)
                                    .addComponent(sHornStatues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(26, 26, 26)
                .addComponent(jLabel210)
                .addGap(18, 18, 18)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane30.setViewportView(jPanel42);

        jPanel26.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1280, 450));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel26.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1336, 621));

        jTabbedPane2.addTab("Lambs", jPanel26);

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHeading2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelHeading2.setForeground(new java.awt.Color(0, 0, 0));
        labelHeading2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeading2.setText("VIEW / ADD / EDIT / WEANER INFORMATION");
        jPanel28.add(labelHeading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 1300, -1));

        searchBar10.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTER WEANERS"));

        jLabel211.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel211.setText("Tag ID:");

        jLabel212.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel212.setText("Weaner Type:");

        buttonUpdateWeanerS.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdateWeanerS.setForeground(new java.awt.Color(0, 0, 0));
        buttonUpdateWeanerS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEdit.png"))); // NOI18N
        buttonUpdateWeanerS.setText("UPDATE");
        buttonUpdateWeanerS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateWeanerSActionPerformed(evt);
            }
        });

        buttonDeleteWeanerS.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteWeanerS.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteWeanerS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonDelete.png"))); // NOI18N
        buttonDeleteWeanerS.setText("DELETE");
        buttonDeleteWeanerS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteWeanerSActionPerformed(evt);
            }
        });

        buttonCloseWeaner2.setBackground(new java.awt.Color(204, 204, 255));
        buttonCloseWeaner2.setForeground(new java.awt.Color(0, 0, 0));
        buttonCloseWeaner2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCloseWeaner2.setText("CLOSE");
        buttonCloseWeaner2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseWeaner2ActionPerformed(evt);
            }
        });

        buttonClearWeanerS.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearWeanerS.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearWeanerS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearWeanerS.setText("CLEAR");
        buttonClearWeanerS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearWeanerSActionPerformed(evt);
            }
        });

        typeWeaner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "1. Mating Ram - Farm keep (Stud)", "2. Mating Ram - Sale (Stud)", "3.Commercial Ram - Farm keep", "4. Commerical Ram - Sales", "5. Wether - Sales (Feedlot)", "6. Wether- Sales (Backgrounding)", "7. Wether - Sales (Backgrouding + Feedlot)", "8. Stud Ram - Commercial Sale", "9. Stud Ram - Stud Sale", "10. Open Mating Ewe - Farm keep", "11. Open Mating Ewe - Sale", "12. Commercial Ewe - Farm keep", "13. Commerical Ewe - Sales", "14. Stud Ewe - Commercial Sale", "15. Stud Ewe - Stud Sale", "16. Other" }));
        typeWeaner.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeWeanerItemStateChanged(evt);
            }
        });
        typeWeaner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                typeWeanerFocusGained(evt);
            }
        });

        searchWeanerSheep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        searchWeanerSheep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchWeanerSheepItemStateChanged(evt);
            }
        });
        searchWeanerSheep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchWeanerSheepFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar10Layout = new javax.swing.GroupLayout(searchBar10);
        searchBar10.setLayout(searchBar10Layout);
        searchBar10Layout.setHorizontalGroup(
            searchBar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar10Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jLabel211)
                .addGap(18, 18, 18)
                .addComponent(searchWeanerSheep, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel212)
                .addGap(18, 18, 18)
                .addComponent(typeWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(buttonUpdateWeanerS, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDeleteWeanerS, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearWeanerS, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCloseWeaner2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        searchBar10Layout.setVerticalGroup(
            searchBar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar10Layout.createSequentialGroup()
                .addGroup(searchBar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonUpdateWeanerS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDeleteWeanerS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClearWeanerS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCloseWeaner2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchBar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel212)
                        .addComponent(typeWeaner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchBar10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel211)
                        .addComponent(searchWeanerSheep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.add(searchBar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1290, -1));

        tableWeanerSheep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Name", "Gender", "Paddock", "Stud / Com", "Herd Group", "Weaner Type", "W Weight", "Wean Date", "Sale / Mate Date", "Ram", "Ewe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane33.setViewportView(tableWeanerSheep);
        if (tableWeanerSheep.getColumnModel().getColumnCount() > 0) {
            tableWeanerSheep.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableWeanerSheep.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableWeanerSheep.getColumnModel().getColumn(2).setPreferredWidth(40);
            tableWeanerSheep.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableWeanerSheep.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableWeanerSheep.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableWeanerSheep.getColumnModel().getColumn(6).setPreferredWidth(150);
            tableWeanerSheep.getColumnModel().getColumn(7).setPreferredWidth(40);
            tableWeanerSheep.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableWeanerSheep.getColumnModel().getColumn(9).setPreferredWidth(60);
            tableWeanerSheep.getColumnModel().getColumn(10).setPreferredWidth(40);
            tableWeanerSheep.getColumnModel().getColumn(11).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane33, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane33, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane32.setViewportView(jPanel44);

        jPanel28.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1290, 430));

        jLabel213.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(51, 51, 51));
        jLabel213.setText("AGRI8 - Assist: Filter the Table below by typing the Tag ID or Weight in the Textboxs Above.");
        jPanel28.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel214.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(51, 51, 51));
        jLabel214.setText("AGRI8 -Assist: DELETE a field in the Table below by selecting a row and then click the \"DELETE BUTTON\".");
        jPanel28.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        buttonAddWeanerSheep.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddWeanerSheep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonAddWeanerSheep.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddWeanerSheep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        buttonAddWeanerSheep.setText("Add Weaner");
        buttonAddWeanerSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddWeanerSheepActionPerformed(evt);
            }
        });
        jPanel28.add(buttonAddWeanerSheep, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, 150, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel28.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1336, 621));

        jTabbedPane2.addTab("Weaners", jPanel28);

        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonAddVacc2.setBackground(new java.awt.Color(204, 204, 255));
        buttonAddVacc2.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddVacc2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sheep-16.png"))); // NOI18N
        buttonAddVacc2.setText("ADD ANIMAL DISEASE");
        buttonAddVacc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddVacc2ActionPerformed(evt);
            }
        });
        jPanel29.add(buttonAddVacc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 20, 180, 37));

        jLabel215.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel215.setText("ANIMAL HEALTH DISEASE AND VACCINATION RECORD");
        jPanel29.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1310, -1));

        searchBar11.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH ANIMAL HEALTH"));

        jLabel216.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel216.setText("Tag ID:");

        jLabel217.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel217.setText("Vaccination:");

        buttonDeleteA2.setBackground(new java.awt.Color(204, 204, 255));
        buttonDeleteA2.setForeground(new java.awt.Color(0, 0, 0));
        buttonDeleteA2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnDelete16.png"))); // NOI18N
        buttonDeleteA2.setText("DELETE");
        buttonDeleteA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteA2ActionPerformed(evt);
            }
        });

        buttonCClose7.setBackground(new java.awt.Color(204, 204, 255));
        buttonCClose7.setForeground(new java.awt.Color(0, 0, 0));
        buttonCClose7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonClose.png"))); // NOI18N
        buttonCClose7.setText("CLOSE");
        buttonCClose7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCClose7ActionPerformed(evt);
            }
        });

        buttonClearA2.setBackground(new java.awt.Color(204, 204, 255));
        buttonClearA2.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearA2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClear.png"))); // NOI18N
        buttonClearA2.setText("CLEAR");
        buttonClearA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearA2ActionPerformed(evt);
            }
        });

        jLabel218.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel218.setText("Diseases:");

        sheepDisease.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Anthrax", "Blue Tongue", "Botulism", "Brucellosis (Contagious Abortion)", "Cattle Tick-Fever", "Corridor Disease", "East Coast Fever", "Eye-infection (Opthalmia)", "Epivag", "Foot and Mouth Disease (Notifiable Diseases)", "Footrot (Foul in the Foot)", "Gallsikness (Anaplasmosis)", "Gonderiosis Theileriasis", "Heartwater", "Malignant Oedema (Clostridium)", "Mastitis", "Navil ill  - E. coli", "Navil ill - Pasteurella", "Liver Flukes (Tremotodes)", "Lumpy Skin Disease", "ORF or Pastular Dermatitis", "Pasteurellosis", "Poison - Arsenical Dips", "Poison - Nitrate Poisoning", "Poison - Lead Poisoning", "Poison - Organo (Chloride Dips)", "Poison - Organo  (Phoshpate Poisoning)", "Poison - Urea Poisoning", "Pulpy Kidney - (Enteroxaemia)", "Quater Evil / Black Leg", "Rabies", "Redwater - (Babesiosis)", "Rift Valley Fever", "Salmonella - (Paratypnoid)", "Scab", "Sleeping Sickness (Trypanosomiasis)", "Sweating Sickness", "Swin erysipelas", "Tetanus", "Theileriosis", "Three Day Sickness (Ephemeral Fever)", "Trichomoniasis", "Trypanosomiasis (Notifable Disease)", "Tuberculosis", "Twin-lamb Disease", "Vibriosis", "White scours (E. coli)", "Worms - Bankruptworm", "Worms - Brown stomachworm", "Worms - Hookworms", "Worms - Nodularworms", "Worms - Ringworm", "Worms - Screwworm", "Worms - Wireworm", "Worms - Tapeworm (Cestades)", " " }));
        sheepDisease.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sheepDiseaseItemStateChanged(evt);
            }
        });
        sheepDisease.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sheepDiseaseFocusGained(evt);
            }
        });

        sheepVacc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "Castration", "Dipping", "Docking", "Hoof Trimming" }));
        sheepVacc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sheepVaccItemStateChanged(evt);
            }
        });
        sheepVacc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sheepVaccFocusGained(evt);
            }
        });

        tagSearchSheepHealth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        tagSearchSheepHealth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tagSearchSheepHealthItemStateChanged(evt);
            }
        });
        tagSearchSheepHealth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tagSearchSheepHealthFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchBar11Layout = new javax.swing.GroupLayout(searchBar11);
        searchBar11.setLayout(searchBar11Layout);
        searchBar11Layout.setHorizontalGroup(
            searchBar11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel216)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tagSearchSheepHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel217)
                .addGap(18, 18, 18)
                .addComponent(sheepVacc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel218)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sheepDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(buttonDeleteA2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClearA2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCClose7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        searchBar11Layout.setVerticalGroup(
            searchBar11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBar11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBar11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBar11Layout.createSequentialGroup()
                        .addGroup(searchBar11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCClose7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel216)
                            .addComponent(tagSearchSheepHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel217)
                            .addComponent(sheepVacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBar11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDeleteA2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel218)
                        .addComponent(sheepDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonClearA2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel29.add(searchBar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 1300, -1));

        jLabel219.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(51, 51, 51));
        jLabel219.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel219.setText("AGRI8 Assist - Here you can Filter the table by either, Tag-id, Vaccinations or Diseases!                            DELETE a field in the Table below by first searching the animal, then select a row in the table and click the \"DELETE BUTTON\".");
        jPanel29.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1300, -1));

        sheepTableHealth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag  ID", "Name", "DOB", "Disease", "Vaccination", "Application", "Dosage", "Treatement Date", "Next Treatement", "Employee", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane34.setViewportView(sheepTableHealth);
        if (sheepTableHealth.getColumnModel().getColumnCount() > 0) {
            sheepTableHealth.getColumnModel().getColumn(0).setPreferredWidth(30);
            sheepTableHealth.getColumnModel().getColumn(1).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane34, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane34, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel29.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1300, 410));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg4.jpeg"))); // NOI18N
        jPanel29.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1336, 621));

        jTabbedPane2.addTab("Sheep Health", jPanel29);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sheep", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1365, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCAddActionPerformed
        // Button to Add Livestock
       
        this.dispose();
        new AddCattle().setVisible(true);
    }//GEN-LAST:event_buttonCAddActionPerformed

    private void CONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONEActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_CONEActionPerformed

    private void CFOURTEENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CFOURTEENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CFOURTEENActionPerformed

    private void buttonGAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGAddActionPerformed
       this.dispose();
       new AddGoats().setVisible(true);
    }//GEN-LAST:event_buttonGAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // CLOSE PAGE
        
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonCAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCAdd2ActionPerformed
        // Add Calves to database
        this.dispose();
        new AddCalf().setVisible(true);
    }//GEN-LAST:event_buttonCAdd2ActionPerformed

    private void buttonAddVaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddVaccActionPerformed
        // Add code for new vaccination frame
        this.dispose();
        new AddVaccination().setVisible(true);
    }//GEN-LAST:event_buttonAddVaccActionPerformed

      //***************** Add mating Textfield in Add / Edit Cattle Above *******************       
       
    private void mating() {
        Connection conn = myConnection.getConnect();
               
                 String IDsearch = (String) TAGIDL.getSelectedItem();
          
                            
                try {

                    //Establish / Open Connection
                   
                    String sql = "SELECT m_sire, m_method, m_bullsin FROM tbl_mating_groups WHERE m_tag_id =? ";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, IDsearch);

                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    while(rs.next()) {

                        CFIVETEEN.setText(rs.getString("m_bullsin"));               // Bulls in
                        CSIXSTEEN.setText(rs.getString("m_method"));                // Method
                        CSEVENTEEN.setText(rs.getString("m_sire"));                 // Sire
                    }
                        
                      conn.close();
            
                } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                  //  JOptionPane.showMessageDialog(null, "Mating Textfield: System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }   
    }
    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // Update cattle info
        
        this.dispose();
        new UpdateCattle().setVisible(true);
       
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void CTENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CTENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CTENActionPerformed

    private void buttonCCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCCloseActionPerformed

    private void CNINEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CNINEKeyPressed
        // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups
                
        String size = CNINE.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                CNINE.setEditable(true);
            } else {
                 CNINE.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                CNINE.setEditable(true);
            } else {
                CNINE.setEditable(false);
            }
        }
    }//GEN-LAST:event_CNINEKeyPressed

    private void CTENKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTENKeyPressed
       // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups
                
        String size = CTEN.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                CTEN.setEditable(true);
            } else {
                 CTEN.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                CTEN.setEditable(true);
            } else {
                CTEN.setEditable(false);
            }
        }
    }//GEN-LAST:event_CTENKeyPressed

    private void CTWELVEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTWELVEKeyPressed
         // Set JTextfield to accept only Integers of a certain Length
        // for weight in Add Cattle Groups
                
        String size = CTWELVE.getText().trim();
        int length = size.length();
        
        char c = evt.getKeyChar();
        
        // check for numbers 0 - 9
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            
            //Check Length
            if(length<4) {
                CTWELVE.setEditable(true);
            } else {
                 CTWELVE.setEditable(false);
            }
            
        } else {
            // Allow for keys 'backspace and deletion
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                CTWELVE.setEditable(true);
            } else {
                CTWELVE.setEditable(false);
            }
        }
    }//GEN-LAST:event_CTWELVEKeyPressed

    private void buttonViewCalfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewCalfActionPerformed
    
        
                Connection conn = myConnection.getConnect();
                String searchID = (String) tfSearchID.getSelectedItem();
                tfSearchID.requestFocus();
               
                if(searchID.trim().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please select ID to search!");
                   
                        
                } else {
                                
                try {
                    CalfHealthTable();
                    //Establish / Open Connection
                   
                    String sql = "SELECT cc_tag_id, cc_name, cc_breed, cc_dob, cc_studcom, cc_gender,cc_birthweight, cc_paddock, cc_herdgroup, cc_weanweight,"
                            + "cc_weandate, cc_sireID, cc_damID, cc_birthstatues, cc_healthstatues, cc_hornstatues FROM tbl_calf_info WHERE cc_tag_id = ? ";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, searchID);
                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) {

                        ccTag.setText(rs.getString("cc_tag_id"));                         //Tag ID
                        ccName.setText(rs.getString("cc_name"));                           //Animale name
                        ccBreed.setSelectedItem(rs.getString("cc_breed"));                         //Breed
                        ccDob.setDate(rs.getDate("cc_dob"));                               //Date of Birth
                        ccStudCom.setSelectedItem(rs.getString("cc_studcom"));                     //stud / com
                        ccGender.setSelectedItem(rs.getString("cc_gender"));                       //Gender
                        ccBirthWeight.setText(rs.getString("cc_birthweight"));              //Birth weight
                        ccPaddock.setSelectedItem(rs.getString("cc_paddock"));                      //Paddock
                        ccHerdGroup.setSelectedItem(rs.getString("cc_herdgroup"));                  //Herd Type
                        
                        ccWeanWeight.setText(rs.getString("cc_weanweight"));                 // wean Weight
                        ccWeanDate.setDate(rs.getDate("cc_weandate"));                       // Wean Date
                        ccSireID.setText(rs.getString("cc_sireID"));                        // Sire ID
                        ccDamID.setText(rs.getString("cc_damID"));                          // Dam ID
                        ccBirthStatues.setSelectedItem(rs.getString("cc_birthstatues"));               // Birth statues
                        ccHealthStatues.setSelectedItem(rs.getString("cc_healthstatues"));          // Health stautes
                        ccHornStatues.setSelectedItem(rs.getString("cc_hornstatues"));              // Horn Type
              
                            
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "ID not Found, Please try again!");
                        tfSearchID.setSelectedItem("SELECT");
                  
                    }
                   
                  conn.close();
                  
                } catch (SQLException | HeadlessException | NullPointerException e) {
                    System.err.println(e.getMessage());
                    //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
                   
            }
    }//GEN-LAST:event_buttonViewCalfActionPerformed

    private void buttonClearCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearCCActionPerformed
        // Clear button
     
         tfSearchID.setSelectedItem("SELECT");
         ccTag.setText("");
         ccName.setText("");
         ccBreed.setSelectedItem("SELECT");
         ccDob.setDate(null);
         ccStudCom.setSelectedItem("SELECT");
         ccGender.setSelectedItem("SELECT");
         ccBirthWeight.setText("");
         ccPaddock.setSelectedItem("SELECT");
         ccHerdGroup.setSelectedItem("SELECT");
         ccWeanWeight.setText("");
         ccWeanDate.setDate(null);
         ccSireID.setText("");
         ccDamID.setText("");
         ccBirthStatues.setSelectedItem("SELECT");
         ccHealthStatues.setSelectedItem("SELECT");
         ccHornStatues.setSelectedItem("SELECT");
         radioUpdateCC.setSelected(false);
         tfSearchID.requestFocus(true);
        
         DefaultTableModel model = (DefaultTableModel) tableCalfHealth.getModel();
         model.setRowCount(0);
         CalfstextfieldEditable();
        
        
    }//GEN-LAST:event_buttonClearCCActionPerformed

    private void buttonDeleteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteAActionPerformed
        // Delete Calf and Health History
        
        Connection conn = myConnection.getConnect();
        String searchID = (String) filterTagCattle.getSelectedItem();
           
        if(searchID.isEmpty() ) {
            
            JOptionPane.showMessageDialog(null, " Please Enter and Search Livestock ID", "Enter ID to Delete!", JOptionPane.ERROR_MESSAGE);
            filterTagCattle.grabFocus();
      
  
        } else { 
         
         
        try {
            
        
            //Get Table Model
            
            DefaultTableModel tblModel = (DefaultTableModel) tableAnimalHealth.getModel();
            
            if(tableAnimalHealth.getSelectedRowCount()==1) {
            
            int row = tableAnimalHealth.getSelectedRow();
            String cell = tableAnimalHealth.getModel().getValueAt(row, 0).toString();
            tblModel.removeRow((int) row);
            String sql = "DELETE FROM tbl_vacc_disease WHERE v_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
            filterTagCattle.setBackground(Color.WHITE);             
                        
            } else {
                
                if(tableAnimalHealth.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please search animal ID and then select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
                conn.close();
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());
                 //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      } 
    }//GEN-LAST:event_buttonDeleteAActionPerformed

    private void buttonDeleteCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteCCActionPerformed
         // Delete Calf and Health History
        
        Connection conn = myConnection.getConnect();
        String searchID = (String) tfSearchID.getSelectedItem();
        String ID =  ccTag.getText().trim();
        
        if(searchID.isEmpty() ) {
            
            JOptionPane.showMessageDialog(null, " Please first search Calf ID from search bar to Delete!", "ID / Name Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            tfSearchID.grabFocus();
    
        } else {
        try {
                    
            String sqldelete = "DELETE FROM tbl_calf_info WHERE cc_tag_id = '" + ID + "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            int deleted = pst.executeUpdate(sqldelete);
            
            if(deleted == 0) {
                
                JOptionPane.showMessageDialog(null, "No record deleted, please retry!", "DELETION ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
            
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            tfSearchID.setSelectedItem("SELECT");
        
            ccTag.setText("");
            ccName.setText("");
            ccBreed.setSelectedItem("SELECT");
            ccDob.setDate(null);
            ccStudCom.setSelectedItem("SELECT");
            ccGender.setSelectedItem("SELECT");
            ccBirthWeight.setText("");
            ccPaddock.setSelectedItem("SELECT");
            ccHerdGroup.setSelectedItem("SELECT");
            ccWeanWeight.setText("");
            ccWeanDate.setDate(null);
            ccSireID.setText("");
            ccDamID.setText("");
            ccBirthStatues.setSelectedItem("SELECT");
            ccHealthStatues.setSelectedItem("SELECT");
            ccHornStatues.setSelectedItem("SELECT");
            radioUpdateCC.setSelected(false);
            tfSearchID.requestFocus(true);
        
         DefaultTableModel model = (DefaultTableModel) tableCalfHealth.getModel();
         model.setRowCount(0);
         
            
            tfSearchID.grabFocus();
          
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
             JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
        
        }
    
    }//GEN-LAST:event_buttonDeleteCCActionPerformed

    private void buttonUpdateCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateCCActionPerformed
        // Update Calf Records
        
        Connection conn = myConnection.getConnect();
      
        String searchID =(String) tfSearchID.getSelectedItem();
        String cctag = ccTag.getText().trim();
        String ccname = ccName.getText().trim();
        String ccbreed = (String) ccBreed.getSelectedItem();
        String ccstud = (String) ccStudCom.getSelectedItem();
        String ccgender = (String) ccGender.getSelectedItem();

         Integer ccbirthweight = null;
         Integer ccweanweight = null;
         
         try {
         ccbirthweight = Integer.parseInt(ccBirthWeight.getText());
         ccweanweight = Integer.parseInt(ccWeanWeight.getText());
         } catch (NullPointerException | NumberFormatException e) {
               System.err.println("System got an error: " + e.getMessage());
         }
         
         String ccpaddock = (String) ccPaddock.getSelectedItem();
         String ccherd = (String) ccHerdGroup.getSelectedItem();
  
        
         String ccsire = ccSireID.getText().trim();
         String ccdam = ccDamID.getText().trim();
         String ccbirthstatues = (String) ccBirthStatues.getSelectedItem();
         String cchealthstatues = (String) ccHealthStatues.getSelectedItem();
         String cchorntatues = (String) ccHornStatues.getSelectedItem();
         
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String ccdob = sdf.format(ccDob.getDate());
          String ccweandate = sdf.format(ccWeanDate.getDate());
             
         

        if(searchID.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please Enter Calf ID to Update!", "ID / Name Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            tfSearchID.grabFocus();
            
        } else { 
        
        try {
                    
           
            String query = "UPDATE tbl_calf_info SET " +
                            "cc_tag_id ='" + cctag + "', cc_name = '" + ccname + "', cc_breed = '" + ccbreed + "', cc_dob= '" + ccdob + "', cc_studcom = '"
                            + ccstud + "', cc_gender = '" + ccgender + "', cc_birthweight = ? , cc_paddock = '" + ccpaddock + "', cc_herdgroup = '" + ccherd + "', cc_weanweight = ?"
                            + ", cc_weandate = '" + ccweandate + "', cc_sireID = '" + ccsire + "', cc_damID = '" + ccdam + "', cc_birthstatues = '" + ccbirthstatues + "', cc_healthstatues = '" 
                            + cchealthstatues + "', cc_hornstatues = '" + cchorntatues + "'" + " WHERE cc_tag_id= '" + searchID + "'";

                    PreparedStatement psm = conn.prepareStatement(query);

                    
                     // Accept Null excption from string to Integer
                     if ( ccBirthWeight.getText().isEmpty() ) {
                        psm.setNull(1, Types.INTEGER);
                      } else {
                    psm.setInt(1, Integer.parseInt(ccBirthWeight.getText()));
                      }
                     
                      // Accept Null excption from string to Integer
                     if ( ccWeanWeight.getText().isEmpty() ) {
                        psm.setNull(2, Types.INTEGER);
                      } else {
                    psm.setInt(2, Integer.parseInt(ccWeanWeight.getText()));
                      }
                    
                    
                    
                    
              int i = psm.executeUpdate();
             
              if(i >= 1){
                 
                JOptionPane.showMessageDialog(this, "" + cctag + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                buttonUpdateCC.setEnabled(false);
                radioUpdateCC.setSelected(false);
                buttonClearCC.setEnabled(true);
                buttonViewCalf.setEnabled(true);
                buttonDeleteCC.setEnabled(true);
                tfSearchID.setEditable(true);
                tfSearchID.setSelectedItem("SELECT");
                ccTag.setText("");
                ccName.setText("");
                ccBreed.setSelectedItem("SELECT");
                ccDob.setDate(null);
                ccStudCom.setSelectedItem("SELECT");
                ccGender.setSelectedItem("SELECT");
                ccBirthWeight.setText("");
                ccPaddock.setSelectedItem("SELECT");
                ccHerdGroup.setSelectedItem("SELECT");
                ccWeanWeight.setText("");
                ccWeanDate.setDate(null);
                ccSireID.setText("");
                ccDamID.setText("");
                ccBirthStatues.setSelectedItem("SELECT");
                ccHealthStatues.setSelectedItem("SELECT");
                ccHornStatues.setSelectedItem("SELECT");
                radioUpdateCC.setSelected(false);
                CalfstextfieldEditable();
                DefaultTableModel model = (DefaultTableModel) tableCalfHealth.getModel();
                model.setRowCount(0);

            
              }
            
        } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                 System.err.println(e.getMessage());
                  //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      }   
    }//GEN-LAST:event_buttonUpdateCCActionPerformed

    private void radioUpdateCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioUpdateCCActionPerformed
        // Activate Radio Button to Update Fields
        
        String searchID = (String) tfSearchID.getSelectedItem();
        
        if(searchID.equals("SELECT")) {
            radioUpdateCC.setSelected(false);
            JOptionPane.showMessageDialog(null, "First search Calf and then select 'Update Fields! ",  "ERROR", JOptionPane.DEFAULT_OPTION);   
       
        } else if(radioUpdateCC.isSelected()){
           
            tfSearchID.setEditable(false);
            ccTag.setEditable(true);
            ccTag.requestFocus();
            ccName.setEditable(true);
            ccBreed.setEnabled(true);
            ccDob.setEnabled(true);
            ccStudCom.setEditable(true);
            ccGender.setEnabled(true);
            ccBirthWeight.setEditable(true);
            ccPaddock.setEnabled(true);
            ccHerdGroup.setEnabled(true);
            ccWeanWeight.setEditable(true);
            ccWeanDate.setEnabled(true);
            ccSireID.setEditable(true);
            ccDamID.setEditable(true);
            ccBirthStatues.setEnabled(true);
            ccHealthStatues.setEnabled(true);
            ccHornStatues.setEnabled(true);
            buttonClearCC.setEnabled(false);
            buttonViewCalf.setEnabled(false);
            buttonDeleteCC.setEnabled(false);
            buttonUpdateCC.setEnabled(true);
        } else {
            
            tfSearchID.setEditable(true);
            ccTag.setEditable(false);
            ccTag.requestFocus();
            ccName.setEditable(false);
            ccBreed.setEditable(false);
            ccDob.setEnabled(false);
            ccStudCom.setEditable(false);
            ccGender.setEditable(false);
            ccBirthWeight.setEditable(false);
            ccPaddock.setEditable(false);
            ccHerdGroup.setEditable(false);
            ccWeanWeight.setEditable(false);
            ccWeanDate.setEnabled(false);
            ccSireID.setEditable(false);
            ccDamID.setEditable(false);
            ccBirthStatues.setEditable(false);
            ccHealthStatues.setEditable(false);
            ccHornStatues.setEditable(false);
            buttonClearCC.setEnabled(true);
            buttonViewCalf.setEnabled(true);
            buttonDeleteCC.setEnabled(true);
            buttonUpdateCC.setEnabled(true);
           
        }
    }//GEN-LAST:event_radioUpdateCCActionPerformed

    private void buttonCClose3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCClose3ActionPerformed
        // Close Button
        
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCClose3ActionPerformed

    private void filterVaccCattleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterVaccCattleItemStateChanged
        // Filter JTable according to JCombobox selection
        
         String query1 = (String) filterVaccCattle.getSelectedItem().toString();
         filter(query1);
        
    }//GEN-LAST:event_filterVaccCattleItemStateChanged

    private void filterDiseaseCattleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterDiseaseCattleItemStateChanged
        // Filter table according to JCombobox
        
        String query2 = (String) filterDiseaseCattle.getSelectedItem().toString();
        filter(query2);
        
    }//GEN-LAST:event_filterDiseaseCattleItemStateChanged

    private void buttonClearAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearAActionPerformed
        // Clear Textfields, Jcombobox and refreash JTable
        
       this.dispose();
       new ClassLivestock().setVisible(true);
        
       
    }//GEN-LAST:event_buttonClearAActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // Open Individual mating frame
        
        this.dispose();
        new AddMating().setVisible(true);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    
    private void filterMatingCattleIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterMatingCattleIDItemStateChanged
        
        // Filter JTable according to JCombobox selection
        
         String querym1 = (String) filterMatingCattleID.getSelectedItem().toString();
         filterMating(querym1);
        
    }//GEN-LAST:event_filterMatingCattleIDItemStateChanged

    private void filterStartCattleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterStartCattleItemStateChanged
         
    // Filter JTable according to JCombobox selection
        String querym3 = (String) filterStartCattle.getSelectedItem().toString();
        filterMating(querym3);
                            
    }//GEN-LAST:event_filterStartCattleItemStateChanged

    private void filterMatingNextItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterMatingNextItemStateChanged
       // Filter JTable according to JCombobox selection
        String querym5 = (String) filterMatingNext.getSelectedItem().toString();
        filterMating(querym5);
         
    }//GEN-LAST:event_filterMatingNextItemStateChanged

    private void filterMatingCattleIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterMatingCattleIDFocusGained
          // Populate Populate JCombobox
    
      if(!filterMatingGoats.equals("SELECT")) {           
            filterNextGoats.setSelectedItem("SELECT");
            filterStartGoats.setSelectedItem("SELECT");
      }        
                                             
 
        try {
            
                Connection conn = myConnection.getConnect();
               
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT m_tag_id FROM tbl_mating_groups");
                 
                 while(rs.next()){
                     
                     filterMatingCattleID.addItem(rs.getString("m_tag_id"));
          
                   }
             
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_filterMatingCattleIDFocusGained

    private void filterStartCattleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterStartCattleFocusGained
       
 
          if(!filterStartCattle.equals("SELECT")) {
            
            filterMatingCattleID.setSelectedItem("SELECT");
            filterMatingNext.setSelectedItem("SELECT");
      }
        
         try {
            
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT m_c_start FROM tbl_mating_groups");
                 
                 while(rs.next()){
                     
                     filterStartCattle.addItem(rs.getString("m_c_start"));
          
                   }
             
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
                //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
        
    }//GEN-LAST:event_filterStartCattleFocusGained

    private void filterMatingNextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterMatingNextFocusGained

          if(!filterMatingNext.equals("SELECT")) {
            
            filterMatingCattleID.setSelectedItem("SELECT");
            filterStartCattle.setSelectedItem("SELECT");
      }

         try {
            
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT m_nextmating FROM tbl_mating_groups");
                 
                 while(rs.next()){
                     
                     filterMatingNext.addItem(rs.getString("m_nextmating"));
          
                   }
             
                 conn.close();
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_filterMatingNextFocusGained

    private void buttonClearMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearMActionPerformed
        // Clear Mating frame
            this.dispose();
            new ClassLivestock().setVisible(true);
    
            filterMatingCattleID.setSelectedItem("SELECT");
            filterMatingNext.setSelectedItem("SELECT");
            filterStartCattle.setSelectedItem("SELECT");
            
            DefaultTableModel model = (DefaultTableModel) tableMatingHerd.getModel();
            model.setRowCount(0);
         
       
            tableMatingHerd.revalidate();
            tableMatingHerd.repaint();
                
    }//GEN-LAST:event_buttonClearMActionPerformed

    private void buttonDeleteMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteMActionPerformed
        
        Connection conn = myConnection.getConnect();
               
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelM = (DefaultTableModel) tableMatingHerd.getModel();
            
            if(tableMatingHerd.getSelectedRowCount()==1) {
            
            int row = tableMatingHerd.getSelectedRow();
            String cell = tableMatingHerd.getModel().getValueAt(row, 0).toString();
            tblModelM.removeRow((int) row);
            String sql = "DELETE FROM tbl_mating_groups WHERE m_tag_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                   
            } else {
                
                if(tableMatingHerd.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
              System.err.println(e.getMessage());
                  //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
        
    }//GEN-LAST:event_buttonDeleteMActionPerformed

    private void buttonUpdateMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateMActionPerformed
        this.dispose();
        new UpdateMatingHerd().setVisible(true);
    }//GEN-LAST:event_buttonUpdateMActionPerformed

    private void buttonUpdateWeanerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateWeanerActionPerformed
        // Update Weaner Records
        
        this.dispose();
        new UpdateWeaner().setVisible(true);
    }//GEN-LAST:event_buttonUpdateWeanerActionPerformed

    private void buttonDeleteWeanerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteWeanerActionPerformed
        
        Connection conn = myConnection.getConnect();
               
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelW = (DefaultTableModel) tableWeanerCattle.getModel();
            
            if(tableWeanerCattle.getSelectedRowCount()==1) {
            
            int row = tableWeanerCattle.getSelectedRow();
            String cell = tableWeanerCattle.getModel().getValueAt(row, 0).toString();
            tblModelW.removeRow((int) row);
            String sql = "DELETE FROM tbl_weaner_info WHERE w_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
                                    
            } else {
                
                if(tableWeanerCattle.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
              System.err.println(e.getMessage());
              //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
    }//GEN-LAST:event_buttonDeleteWeanerActionPerformed

    private void buttonClearWeanerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearWeanerActionPerformed
        // Refresh Weaner table and Jcombobox
        
        this.dispose();
        new ClassLivestock().setVisible(true);
               
    }//GEN-LAST:event_buttonClearWeanerActionPerformed

    private void buttonAddWeanerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddWeanerActionPerformed
        // Open Frame to add Weaner records
        
        this.dispose();
        new AddWeaner().setVisible(true);
        
    }//GEN-LAST:event_buttonAddWeanerActionPerformed

    private void filterPaddockCattleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterPaddockCattleItemStateChanged
        // Weaner Type Filter

         String queryw = (String) filterPaddockCattle.getSelectedItem().toString();
         filterWeaner(queryw);
    
    }//GEN-LAST:event_filterPaddockCattleItemStateChanged

    private void buttonDeleteLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteLActionPerformed
        // Delete Cattle
        
        Connection conn = myConnection.getConnect();
         String IDsearch = (String) TAGIDL.getSelectedItem();
        
        if(IDsearch.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " Please Search Livestock ID to Delete!", "Select ID to Delete!", JOptionPane.ERROR_MESSAGE);
            TAGIDL.grabFocus();
        
        } else { 
         
         
        try {
            
           String sql = "DELETE FROM tbl_cattle_info WHERE c_tag_id = ? ";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,IDsearch);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.DEFAULT_OPTION);  
      
            this.dispose();
            new ClassLivestock().setVisible(true);
          
        } catch (SQLException | HeadlessException  | NullPointerException e) {
              System.err.println(e.getMessage());
               //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);   
        }
      }
    }//GEN-LAST:event_buttonDeleteLActionPerformed

    private void TAGIDLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TAGIDLFocusGained
             // Populate Tag ID Combobox
   
             Connection conn = myConnection.getConnect();
        try {

      
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT c_tag_id FROM tbl_cattle_info");

        while(rs.next()){

            TAGIDL.addItem(rs.getString("c_tag_id"));
        }
        conn.close();
        } catch (SQLException | HeadlessException  e) {
            System.err.println(e.getMessage());
          //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_TAGIDLFocusGained

    private void buttonSearchCowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchCowActionPerformed
        Connection conn = myConnection.getConnect();
               
                String IDCOWS = (String) TAGIDL.getSelectedItem();
                tfSearchID.requestFocus();
                if(IDCOWS.equals("SELECT")) {

                        JOptionPane.showMessageDialog(null, "Please select ID to search!");
                
                        
                } else {
                    
                    CattleHealthTable();
                    CattleMatingHistoryTable();
                                
                try {

                    //Establish / Open Connection
                    
                    String sql = "SELECT c_tag_id, c_name, c_breed, c_dateofbirth, c_studcom, c_gender, c_paddock, c_herdtype, c_birthweight, "
                            + " c_weanweight, c_weandate, c_12monthweight, c_12monthweightdate, c_breedingstatus, c_dambirthweight, c_calfbirthweight, "
                            + "c_calfbirthdate, c_sire1stgen, c_dam1stgen, c_picture FROM tbl_cattle_info WHERE c_tag_id = ?";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, IDCOWS);


                    //Executing Query
                    ResultSet rs = sta.executeQuery();
                    byte[] image = null;
                    if (rs.next()) {
                        TAGIDL.setEnabled(false);
                        CONE.setText(rs.getString("c_tag_id"));                       
                        CTWO.setText(rs.getString("c_name"));                         
                        CTHREE.setText(rs.getString("c_breed"));                     
                        CFOURD.setText(rs.getString("c_dateofbirth"));                           
                        CFIVE.setText(rs.getString("c_studcom"));                  
                        CSIXS.setText(rs.getString("c_gender"));                
                        CSEVEN.setText(rs.getString("c_paddock"));    
                        
                        CEIGHT.setText(rs.getString("c_herdtype"));                      
                        CNINE.setText(rs.getString("c_birthweight"));  
                        CTEN.setText(rs.getString("c_weanweight"));
                        CELEVEND.setText(rs.getString("c_weandate"));   
                        
                        CTWELVE.setText(rs.getString("c_12monthweight"));  
                        CTHIRTEEND.setText(rs.getString("c_12monthweightdate"));              
                        CFOURTEEN.setText(rs.getString("c_breedingstatus")); 
                 
                        matingCattle();
           
                        CTWENTYONE.setText(rs.getString("c_sire1stgen"));               
                        CTWENTYTWO.setText(rs.getString("c_dam1stgen"));              
                        image = (rs.getBytes("c_picture"));
                    
                    if(image != null) {
                        Image img = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon icon = new ImageIcon(img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH));
                        labelImage.setIcon(icon);
                    } else {
                        sta.setNull(1, Types.BLOB);
                    }
                     
                    }
                        } catch (SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
    }//GEN-LAST:event_buttonSearchCowActionPerformed

    private void filterTagCattleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterTagCattleFocusGained
        // Populate with JComboboxs
               
          if(!filterTagCattle.equals("SELECT")) {
            
            filterVaccCattle.setSelectedItem("SELECT");
            filterDiseaseCattle.setSelectedItem("SELECT");
        }
   
           try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_id FROM tbl_vacc_disease");
                 
                 while(rs.next()){
                     
                     filterTagCattle.addItem(rs.getString("v_id"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }

    }//GEN-LAST:event_filterTagCattleFocusGained

    private void filterTagCattleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterTagCattleItemStateChanged
        // Filter by Tag ID
        
        String query3 = (String) filterTagCattle.getSelectedItem().toString();
        filter(query3);
        
        
    }//GEN-LAST:event_filterTagCattleItemStateChanged

    private void filterVaccCattleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterVaccCattleFocusGained
        // Populate Vaccination JComboboxs
       
                 
          if(!filterVaccCattle.equals("SELECT")) {
            
            filterTagCattle.setSelectedItem("SELECT");
            filterDiseaseCattle.setSelectedItem("SELECT");
        }
      
        try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_vacc FROM tbl_vacc");
                 
                 while(rs.next()){
                     
                     filterVaccCattle.addItem(rs.getString("v_vacc"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(" Cattle Health - System got an error: " + e.getMessage());
             }
        
    }//GEN-LAST:event_filterVaccCattleFocusGained

    private void filterDiseaseCattleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterDiseaseCattleFocusGained
        // Populate Disease
       
          if(!filterDiseaseCattle.equals("SELECT")) {
            
            filterTagCattle.setSelectedItem("SELECT");
            filterVaccCattle.setSelectedItem("SELECT");
        }
       
        try {
                 
                 Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_disease FROM tbl_disease");
                 
                 while(rs.next()){
                     
                     filterDiseaseCattle.addItem(rs.getString("v_disease"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(" Cattle Health - System got an error: " + e.getMessage());
             }
        
        
    }//GEN-LAST:event_filterDiseaseCattleFocusGained

    private void filterWeanerTagCattleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterWeanerTagCattleFocusGained
        

       if(!filterWeanerTagCattle.equals("SELECT")) {
            
            filterPaddockCattle.setSelectedItem("SELECT");
        
        }
        
        Connection conn = myConnection.getConnect();
        
     try {
          Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT w_id FROM tbl_weaner_info");
                 
                 while(rs.next()){
                     
                     filterWeanerTagCattle.addItem(rs.getString("w_id"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException  e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }   
    }//GEN-LAST:event_filterWeanerTagCattleFocusGained

    private void filterWeanerTagCattleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterWeanerTagCattleItemStateChanged
        // Filter Weaners
         String queryw = (String) filterWeanerTagCattle.getSelectedItem().toString();
         filterWeaner(queryw);
    }//GEN-LAST:event_filterWeanerTagCattleItemStateChanged

    private void tfSearchIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSearchIDFocusGained
        
        //Populate Jcomobox with Calf ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT cc_tag_id FROM tbl_calf_info");

            while(rs.next()){

                tfSearchID.addItem(rs.getString("cc_tag_id"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
        
    }//GEN-LAST:event_tfSearchIDFocusGained

    private void buttonCloseCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseCActionPerformed
        // exit to main page
        
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseCActionPerformed

    private void filterPaddockCattleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterPaddockCattleFocusGained
        
       if(!filterPaddockCattle.equals("SELECT")) {
            
            filterWeanerTagCattle.setSelectedItem("SELECT");
        
        }
       
         try {
                 
                   
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     filterPaddockCattle.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
      
    }//GEN-LAST:event_filterPaddockCattleFocusGained

    private void buttonCloseWeanerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseWeanerActionPerformed
        // CLOSE WEANER FRAME
        
       this.dispose();
       new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseWeanerActionPerformed

    private void buttonClearCattleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearCattleActionPerformed

         TAGIDL.setSelectedItem("SELECT");
         TAGIDL.setEnabled(true);
         CONE.setText("");
         CTWO.setText("");
         CTHREE.setText("");
         CFOURD.setText("");
         CFIVE.setText("");
         CSIXS.setText("");
         CSEVEN.setText("");
         CEIGHT.setText("");
         CNINE.setText("");
         CTEN.setText("");
         CELEVEND.setText("");
         CTWELVE.setText("");
         CTHIRTEEND.setText("");
         CFOURTEEN.setText("");
         CFIVETEEN.setText("");
         CSIXSTEEN.setText("");
         CSEVENTEEN.setText("");

         CTWENTYONE.setText("");
         CTWENTYTWO.setText("");
         labelImage.setIcon(null);
         DefaultTableModel model = (DefaultTableModel) tableMatingCalvingHistory.getModel();
         model.setRowCount(0);
      
         DefaultTableModel modelH = (DefaultTableModel) tableAnimalHealthHistory.getModel();
         modelH.setRowCount(0);
        
        
        
        
    }//GEN-LAST:event_buttonClearCattleActionPerformed

    private void buttonClearCattle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearCattle1ActionPerformed
        // Refresh Main Page
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearCattle1ActionPerformed

    private void filterCattleTagFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterCattleTagFocusGained

          if(!filterCattleTag.equals("SELECT")) {
            
            filterCattleGroup.setSelectedItem("SELECT");
            filterCattlePaddock.setSelectedItem("SELECT");
      }


        
        cattleID();
        calfID();
        weanerID();
        
        
    }//GEN-LAST:event_filterCattleTagFocusGained

    private void filterCattleTagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterCattleTagItemStateChanged
        // Filter Main page table
         String querym = (String) filterCattleTag.getSelectedItem().toString();
         filterMainTable(querym);
    }//GEN-LAST:event_filterCattleTagItemStateChanged

    private void filterCattlePaddockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterCattlePaddockItemStateChanged
             // Filter Main page table
         String querym = (String) filterCattlePaddock.getSelectedItem().toString();
         filterMainTable(querym);
    }//GEN-LAST:event_filterCattlePaddockItemStateChanged

    private void filterCattleGroupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterCattleGroupItemStateChanged
          // Filter Main page table
         String querym = (String) filterCattleGroup.getSelectedItem().toString();
         filterMainTable(querym);
    }//GEN-LAST:event_filterCattleGroupItemStateChanged

    private void filterCattleGroupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterCattleGroupFocusGained

            if(!filterCattleGroup.equals("SELECT")) {
            
            filterCattleTag.setSelectedItem("SELECT");
            filterCattlePaddock.setSelectedItem("SELECT");
      }


        try {
                 
               Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                   
                     filterCattleGroup.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_filterCattleGroupFocusGained

    private void ccHerdGroupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ccHerdGroupFocusGained
   
       
    
    }//GEN-LAST:event_ccHerdGroupFocusGained

    private void ccPaddockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ccPaddockFocusGained
          
  
    }//GEN-LAST:event_ccPaddockFocusGained

    private void filterPaddockGoatsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterPaddockGoatsItemStateChanged
      
        String queryGM = (String) filterPaddockGoats.getSelectedItem().toString();
        filterGoatsMainPage(queryGM);
    }//GEN-LAST:event_filterPaddockGoatsItemStateChanged

    private void filterHerdGoatsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterHerdGoatsItemStateChanged
        
        String queryGM = (String) filterHerdGoats.getSelectedItem().toString();
        filterGoatsMainPage(queryGM);
    }//GEN-LAST:event_filterHerdGoatsItemStateChanged

    private void filterHerdGoatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterHerdGoatsFocusGained
       
         if(!filterHerdGoats.equals("SELECT")) {
            
            filterTagGoats.setSelectedItem("SELECT");
            filterPaddockGoats.setSelectedItem("SELECT");
      } 
         
         
          try {
                 
               Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                   
                     filterHerdGoats.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_filterHerdGoatsFocusGained

    private void buttonCloseGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseGActionPerformed
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseGActionPerformed

    private void buttonClearGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearGActionPerformed
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearGActionPerformed

    private void GONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GONEActionPerformed

    private void GNINEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GNINEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GNINEKeyPressed

    private void GFOURTEENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GFOURTEENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GFOURTEENActionPerformed

    private void GTENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GTENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GTENActionPerformed

    private void GTENKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GTENKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GTENKeyPressed

    private void GTWELEVEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GTWELEVEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GTWELEVEKeyPressed

    private void filterMatingGoatsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterMatingGoatsItemStateChanged
        String queryg = (String) filterMatingGoats.getSelectedItem().toString();
        filterMatingGoats(queryg);
    }//GEN-LAST:event_filterMatingGoatsItemStateChanged

    private void filterMatingGoatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterMatingGoatsFocusGained
       
           // Populate Populate JCombobox
          
       
          if(!filterMatingGoats.equals("SELECT")) {
            
            filterNextGoats.setSelectedItem("SELECT");
            filterStartGoats.setSelectedItem("SELECT");
      }        
                                             
        //Populate Jcomobox with Mating ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT gm_tag_id FROM tbl_mating_goats");

            while(rs.next()){

                filterMatingGoats.addItem(rs.getString("gm_tag_id"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_filterMatingGoatsFocusGained

    private void filterStartGoatsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterStartGoatsItemStateChanged
        String queryg = (String) filterStartGoats.getSelectedItem().toString();
        filterMatingGoats(queryg);
    }//GEN-LAST:event_filterStartGoatsItemStateChanged

    private void filterStartGoatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterStartGoatsFocusGained
        
        
          if(!filterStartGoats.equals("SELECT")) {
            
            filterNextGoats.setSelectedItem("SELECT");
            filterMatingGoats.setSelectedItem("SELECT");
      }        
                                             
        //Populate Jcomobox with Mating ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT gm_k_start FROM tbl_mating_goats");

            while(rs.next()){

                filterStartGoats.addItem(rs.getString("gm_k_start"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_filterStartGoatsFocusGained

    private void filterNextGoatsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterNextGoatsItemStateChanged
        
        String queryg = (String) filterNextGoats.getSelectedItem().toString();
        filterMatingGoats(queryg);
    }//GEN-LAST:event_filterNextGoatsItemStateChanged

    private void filterNextGoatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterNextGoatsFocusGained
        
        
          if(!filterNextGoats.equals("SELECT")) {
            
            filterMatingGoats.setSelectedItem("SELECT");
            filterStartGoats.setSelectedItem("SELECT");
      }        
                                             
        //Populate Jcomobox with Mating ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT gm_nextmating FROM tbl_mating_goats");

            while(rs.next()){

                filterNextGoats.addItem(rs.getString("gm_nextmating"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_filterNextGoatsFocusGained

    private void buttonUpdateM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateM1ActionPerformed
        this.dispose();
        new UpdateMatingGoats().setVisible(true);
    }//GEN-LAST:event_buttonUpdateM1ActionPerformed

    private void buttonClearM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearM1ActionPerformed
      
         // Clear Mating frame
        
    
            this.dispose();
            new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearM1ActionPerformed

    private void buttonDeleteM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteM1ActionPerformed
       
         Connection conn = myConnection.getConnect();
               
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelG = (DefaultTableModel) tableMatingGoats.getModel();
            
            if(tableMatingGoats.getSelectedRowCount()==1) {
            
            int row = tableMatingGoats.getSelectedRow();
            String cell = tableMatingGoats.getModel().getValueAt(row, 0).toString();
            tblModelG.removeRow((int) row);
            String sql = "DELETE FROM tbl_mating_goats WHERE gm_tag_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
            this.dispose();
            new ClassLivestock().setVisible(true);                      
            } else {
                
                if(tableMatingGoats.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
                      //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
    }//GEN-LAST:event_buttonDeleteM1ActionPerformed

    private void buttonViewKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewKActionPerformed
        
        Connection conn = myConnection.getConnect();
                String goatID = (String) searchKid.getSelectedItem();
                searchKid.requestFocus();
               
                if(goatID.equals("SELECT")) {

                        JOptionPane.showMessageDialog(null, "Please select ID to search!");
                   
                        
                } else {
                                
                try {
                   KidHealthTable();
                    //Establish / Open Connection
                   
                    String sql = "SELECT g_tag_id, g_name, g_breed, g_dob, g_studcom, g_gender, g_birthweight, g_paddock, g_herdgroup, g_weanweight,"
                            + "g_weandate, g_ramID, g_eweID, g_birthstatues, g_healthstatues, g_hornstatues FROM tbl_kid_info WHERE g_tag_id = ? ";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, goatID);
                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) {

                        gTag.setText(rs.getString("g_tag_id"));                         //Tag ID
                        gName.setText(rs.getString("g_name"));                           //Animale name
                        gBreed.setSelectedItem(rs.getString("g_breed"));                         //Breed
                        gDob.setDate(rs.getDate("g_dob"));                               //Date of Birth
                        gStudCom.setSelectedItem(rs.getString("g_studcom"));                     //stud / com
                        gGender.setSelectedItem(rs.getString("g_gender"));                       //Gender
                        gBirthWeight.setText(rs.getString("g_birthweight"));              //Birth weight
                        gPaddock.setSelectedItem(rs.getString("g_paddock"));                      //Paddock
                        gHerdGroup.setSelectedItem(rs.getString("g_herdgroup"));                  //Herd Type
                        
                        gWeanWeight.setText(rs.getString("g_weanweight"));                 // wean Weight
                        gWeanDate.setDate(rs.getDate("g_weandate"));                       // Wean Date
                        gRamID.setText(rs.getString("g_ramID"));                        // Sire / Ram ID
                        gEweID.setText(rs.getString("g_eweID"));                          // Dam / Ewe ID
                        gBirthStatues.setSelectedItem(rs.getString("g_birthstatues"));               // Birth statues
                        gHealthStatues.setSelectedItem(rs.getString("g_healthstatues"));          // Health stautes
                        gHornStatues.setSelectedItem(rs.getString("g_hornstatues"));              // Horn Type
              
                            
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "ID not Found, Please try again!");
                        searchKid.setSelectedItem("SELECT");
                  
                    }
                   
                  conn.close();
                  
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
                   
            }
    }//GEN-LAST:event_buttonViewKActionPerformed

    private void buttonUpdateKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateKActionPerformed
       
         // Update Kid Records
        
        Connection conn = myConnection.getConnect();
      
        String kidID =(String) searchKid.getSelectedItem();
        String gtag = gTag.getText().trim();
        String gname = gName.getText().trim();
        String gbreed = (String) gBreed.getSelectedItem();
       
         String gstud =  (String) gStudCom.getSelectedItem();         
         String ggender = (String) gGender.getSelectedItem();
         String gbirthweight = gBirthWeight.getText().trim();
         String gpaddock = (String) gPaddock.getSelectedItem();
         String gherd = (String) gHerdGroup.getSelectedItem();
         String gweanweight = gWeanWeight.getText().trim();
        
         String gram = gRamID.getText().trim();
         String gewe = gEweID.getText().trim();
         String gbirthstatues = (String) gBirthStatues.getSelectedItem();
         String ghealthstatues = (String) gHealthStatues.getSelectedItem();
         String ghorntatues = (String) gHornStatues.getSelectedItem();
         
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String gdob = sdf.format(gDob.getDate());
          String gweandate = sdf.format(gWeanDate.getDate());
             
         

        if(kidID.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, " Please Enter Kid ID to Update!", "ID / Name Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            searchKid.grabFocus();
            
        } else { 
        
        try {
                    
           
            String query = "UPDATE tbl_kid_info SET " +
                            "g_tag_id ='" + gtag + "', g_name = '" + gname + "', g_breed = '" + gbreed + "', g_dob= '" + gdob + "', g_studcom = '"
                            + gstud + "', g_gender = '" + ggender + "', g_birthweight = '" + gbirthweight + "', g_paddock = '" + gpaddock + "', g_herdgroup = '" 
                            + gherd + "', g_weanweight = ? , g_weandate = '" + gweandate + "', g_ramID = '" + gram + "', g_eweID = '" + gewe + "', g_birthstatues = '" + gbirthstatues + "', g_healthstatues = '" 
                            + ghealthstatues + "', g_hornstatues = '" + ghorntatues + "'" + " WHERE g_tag_id= '" + kidID + "'";

                    PreparedStatement statement = conn.prepareStatement(query);

                               // Accept Null excption from string to Integer
                try { 
                  
                    statement.setInt(1, Integer.parseInt(gWeanWeight.getText()));
                      
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.print(" Wean Weight:  System Error exception" + e.getMessage());
                    
                }
          
              int i = statement.executeUpdate();
             
              if(i >= 1){
                 
                JOptionPane.showMessageDialog(this, "" + gtag + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                buttonUpdateK.setEnabled(false);
                radioUpdateG.setSelected(false);
                buttonClearK.setEnabled(true);
                buttonViewK.setEnabled(true);
                buttonDeleteK.setEnabled(true);
                searchKid.setEditable(true);
                searchKid.setSelectedItem("SELECT");
                gTag.setText("");
                gName.setText("");
                gBreed.setSelectedItem("SELECT");
                gDob.setDate(null);
                gStudCom.setSelectedItem("SELECT");
                gGender.setSelectedItem("SELECT");
                gBirthWeight.setText("");
                gPaddock.setSelectedItem("SELECT");
                gHerdGroup.setSelectedItem("SELECT");
                gWeanWeight.setText("");
                gWeanDate.setDate(null);
                gRamID.setText("");
                gEweID.setText("");
                gBirthStatues.setSelectedItem("SELECT");
                gHealthStatues.setSelectedItem("SELECT");
                gHornStatues.setSelectedItem("SELECT");
                radioUpdateG.setSelected(false);
                KidstextfieldEditable();
               

                
                
                DefaultTableModel model = (DefaultTableModel) tablegoatHealth.getModel();
                model.setRowCount(0);

            
              }
            
        } catch (SQLException | HeadlessException e) {
               System.err.println(e.getMessage());
                      //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      }   
    }//GEN-LAST:event_buttonUpdateKActionPerformed

    private void buttonDeleteKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteKActionPerformed
        
        Connection conn = myConnection.getConnect();
        String deleteKid = (String) searchKid.getSelectedItem();
        String kID =  gTag.getText().trim();
        
        if(deleteKid.equals("SELECT") ) {
            
            JOptionPane.showMessageDialog(null, " Please first search Kid ID from search bar to Delete!", "ID / Name Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            searchKid.grabFocus();
    
        } else {
        try {
                    
            String sqldelete = "DELETE FROM tbl_kid_info WHERE g_tag_id = '" + kID + "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            int deleted = pst.executeUpdate(sqldelete);
            
            if(deleted == 0) {
                
                JOptionPane.showMessageDialog(null, "No record deleted, please retry!", "DELETION ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
            
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            searchKid.setSelectedItem("SELECT");
        
            this.dispose();
            new ClassLivestock().setVisible(true);
        
         DefaultTableModel model = (DefaultTableModel) tablegoatHealth.getModel();
         model.setRowCount(0);
         
            
           searchKid.grabFocus();
          
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
        
        }
    }//GEN-LAST:event_buttonDeleteKActionPerformed

    private void buttonCloseKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseKActionPerformed
        
           this.dispose();
           new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseKActionPerformed

    private void buttonClearKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearKActionPerformed
        
         searchKid.setSelectedItem("SELECT");
         gTag.setText("");
         gName.setText("");
         gBreed.setSelectedItem("SELECT");
         gDob.setDate(null);
         gStudCom.setSelectedItem("SELECT");
         gGender.setSelectedItem("SELECT");
         gBirthWeight.setText("");
         gPaddock.setSelectedItem("SELECT");
         gHerdGroup.setSelectedItem("SELECT");
         gWeanWeight.setText("");
         gWeanDate.setDate(null);
         gRamID.setText("");
         gEweID.setText("");
         gBirthStatues.setSelectedItem("SELECT");
         gHealthStatues.setSelectedItem("SELECT");
         gHornStatues.setSelectedItem("SELECT");
         radioUpdateCC.setSelected(false);
         searchKid.requestFocus(true);
        
         DefaultTableModel model = (DefaultTableModel) tablegoatHealth.getModel();
         model.setRowCount(0);
         
    }//GEN-LAST:event_buttonClearKActionPerformed

    private void searchKidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchKidFocusGained
          
        //Populate Jcomobox with Calf ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT g_tag_id FROM tbl_kid_info");

            while(rs.next()){

                searchKid.addItem(rs.getString("g_tag_id"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_searchKidFocusGained

    private void radioUpdateGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioUpdateGActionPerformed
        
        String goatID = (String) searchKid.getSelectedItem();
        
        if(goatID.equals("SELECT")) {
            radioUpdateG.setSelected(false);
            JOptionPane.showMessageDialog(null, "First search Kid and then select 'Update Fields! ",  "ERROR", JOptionPane.DEFAULT_OPTION);   
       
        } else if(radioUpdateG.isSelected()){
           
            searchKid.setEditable(false);
            gTag.setEditable(true);
            gTag.requestFocus();
            gName.setEditable(true);
            gBreed.setEnabled(true);
            gDob.setEnabled(true);
            gStudCom.setEnabled(true);
            gGender.setEnabled(true);
            gBirthWeight.setEditable(true);
            gPaddock.setEnabled(true);
            gHerdGroup.setEnabled(true);
            gWeanWeight.setEditable(true);
            gWeanDate.setEnabled(true);
            gRamID.setEditable(true);
            gEweID.setEditable(true);
            gBirthStatues.setEnabled(true);
            gHealthStatues.setEnabled(true);
            gHornStatues.setEnabled(true);
            buttonClearK.setEnabled(false);
            buttonViewK.setEnabled(false);
            buttonDeleteK.setEnabled(false);
            buttonUpdateK.setEnabled(true);
        } else {
            
            searchKid.setEditable(true);
            gTag.setEditable(false);
            gTag.requestFocus();
            gName.setEditable(false);
            gBreed.setEditable(false);
            gDob.setEnabled(false);
            gStudCom.setEnabled(false);
            gGender.setEditable(false);
            gBirthWeight.setEditable(false);
            gPaddock.setEditable(false);
            gHerdGroup.setEditable(false);
            gWeanWeight.setEditable(false);
            gWeanDate.setEnabled(false);
            gRamID.setEditable(false);
            gEweID.setEditable(false);
            gBirthStatues.setEditable(false);
            gHealthStatues.setEditable(false);
            gHornStatues.setEditable(false);
            buttonClearG.setEnabled(true);
            buttonViewK.setEnabled(true);
            buttonDeleteK.setEnabled(true);
            buttonUpdateK.setEnabled(true);
           
        }
    }//GEN-LAST:event_radioUpdateGActionPerformed

    private void gPaddockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gPaddockFocusGained
       
         
    }//GEN-LAST:event_gPaddockFocusGained

    private void gHerdGroupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gHerdGroupFocusGained
        
         SheepHerdgroup();
    }//GEN-LAST:event_gHerdGroupFocusGained

    private void buttonUpdateWeaner1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateWeaner1ActionPerformed
        
            this.dispose();
            new UpdateWeanerGoats().setVisible(true);
    }//GEN-LAST:event_buttonUpdateWeaner1ActionPerformed

    private void buttonDeleteWeaner1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteWeaner1ActionPerformed
       Connection conn = myConnection.getConnect();
               
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelW = (DefaultTableModel) tableWeanerGoats.getModel();
            
            if(tableWeanerGoats.getSelectedRowCount()==1) {
            
            int row = tableWeanerGoats.getSelectedRow();
            String cell = tableWeanerGoats.getModel().getValueAt(row, 0).toString();
            tblModelW.removeRow((int) row);
            String sql = "DELETE FROM tbl_weaner_kids WHERE gw_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
            this.dispose();
            new ClassLivestock().setVisible(true);                      
            } else {
                
                if(tableWeanerGoats.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
              System.err.println(e.getMessage());
                 //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
    }//GEN-LAST:event_buttonDeleteWeaner1ActionPerformed

    private void buttonCloseWeaner1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseWeaner1ActionPerformed
        
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseWeaner1ActionPerformed

    private void buttonClearWeaner1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearWeaner1ActionPerformed
       this.dispose();
       new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearWeaner1ActionPerformed

    private void filterTypeGoatsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterTypeGoatsItemStateChanged
        
        String queryGW = (String) filterTypeGoats.getSelectedItem().toString();
        filterGoatsWeaner(queryGW);
    }//GEN-LAST:event_filterTypeGoatsItemStateChanged

    private void filterTypeGoatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterTypeGoatsFocusGained
           
        if(!filterTypeGoats.equals("SELECT")) {
            
            filterGoatWeanerID.setSelectedItem("SELECT");
     
      }
        
          try {
                 
                   
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     filterTypeGoats.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_filterTypeGoatsFocusGained

    private void filterGoatWeanerIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterGoatWeanerIDItemStateChanged
        
             
        String queryGW = (String) filterGoatWeanerID.getSelectedItem().toString();
        filterGoatsWeaner(queryGW);
                                
    }//GEN-LAST:event_filterGoatWeanerIDItemStateChanged

    private void filterGoatWeanerIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterGoatWeanerIDFocusGained
        
        
          if(!filterGoatWeanerID.equals("SELECT")) {
            
            filterTypeGoats.setSelectedItem("SELECT");
     
      }
          
        
          try {
                 
                   
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT gw_id FROM tbl_weaner_kids ORDER BY gw_id ASC");
                 
                 while(rs.next()){
                     
                     filterGoatWeanerID.addItem(rs.getString("gw_id"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
          
    }//GEN-LAST:event_filterGoatWeanerIDFocusGained

    private void buttonAddWeaner1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddWeaner1ActionPerformed
        
        this.dispose();
        new AddWeanerGoats().setVisible(true);
    }//GEN-LAST:event_buttonAddWeaner1ActionPerformed

    private void buttonDeleteA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteA1ActionPerformed
        // Delete Goat Health History
        
        Connection conn = myConnection.getConnect();
        String searchID = (String) searchGoatIDH.getSelectedItem();
           
        if(searchID.isEmpty() ) {
            
            JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);
            searchGoatIDH.grabFocus();
      
  
        } else { 
         
         
        try {
            
        
            //Get Table Model
            
            DefaultTableModel tblModelG = (DefaultTableModel) tableAnimalHealthGoatsH.getModel();
            
            if(tableAnimalHealthGoatsH.getSelectedRowCount()==1) {
            
            int row = tableAnimalHealthGoatsH.getSelectedRow();
            String cell = tableAnimalHealthGoatsH.getModel().getValueAt(row, 0).toString();
            tblModelG.removeRow((int) row);
            String sql = "DELETE FROM tbl_vacc_disease WHERE v_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
            searchGoatIDH.setBackground(Color.WHITE);  
             this.dispose();
            new ClassLivestock().setVisible(true);
                        
            } else {
                
                if(tableAnimalHealthGoatsH.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please search animal ID and then select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
                conn.close();
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());        
                        //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      } 
    }//GEN-LAST:event_buttonDeleteA1ActionPerformed

    private void buttonCClose6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCClose6ActionPerformed
       this.dispose();
       new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCClose6ActionPerformed

    private void buttonClearA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearA1ActionPerformed
      
       this.dispose();
       new ClassLivestock().setVisible(true);
       
    }//GEN-LAST:event_buttonClearA1ActionPerformed

    private void searchGoatDiseaseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchGoatDiseaseItemStateChanged
        String queryGG = (String) searchGoatDisease.getSelectedItem().toString();
        filterGoats(queryGG);
    }//GEN-LAST:event_searchGoatDiseaseItemStateChanged

    private void searchGoatDiseaseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGoatDiseaseFocusGained
      
       
          if(!searchGoatDisease.equals("SELECT")) {
            
            searchGoatVacc.setSelectedItem("SELECT");
            searchGoatIDH.setSelectedItem("SELECT");
        }
       
        try {
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_disease FROM tbl_disease");
                 
                 while(rs.next()){
                     
                     filterDiseaseCattle.addItem(rs.getString("v_disease"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_searchGoatDiseaseFocusGained

    private void searchGoatVaccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchGoatVaccItemStateChanged
        
         String queryGG = (String) searchGoatVacc.getSelectedItem().toString();
        filterGoats(queryGG);
    }//GEN-LAST:event_searchGoatVaccItemStateChanged

    private void searchGoatVaccFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGoatVaccFocusGained
        
           // Populate Vaccination JComboboxs
           
       if(!searchGoatVacc.equals("SELECT")) {
            
            searchGoatIDH.setSelectedItem("SELECT");
            searchGoatDisease.setSelectedItem("SELECT");
        }
      
        try {
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_vacc FROM tbl_vacc");
                 
                 while(rs.next()){
                     
                     searchGoatVacc.addItem(rs.getString("v_vacc"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
           //     JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
    }//GEN-LAST:event_searchGoatVaccFocusGained

    private void searchGoatIDHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchGoatIDHItemStateChanged
         // Filter by Tag ID
        
        String queryGG = (String) searchGoatIDH.getSelectedItem().toString();
        filterGoats(queryGG);
    }//GEN-LAST:event_searchGoatIDHItemStateChanged

    private void searchGoatIDHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGoatIDHFocusGained
        
          if(!searchGoatIDH.equals("SELECT")) {
            
            searchGoatVacc.setSelectedItem("SELECT");
            searchGoatDisease.setSelectedItem("SELECT");
        }
        
        
        
         // Populate with JComboboxs
      
        String tagida = (String) filterTagCattle.getSelectedItem();
        
        if(tagida == null ? ("SELECT") != null : !tagida.equals("SELECT")) {
            
            searchGoatVacc.setSelectedItem("SELECT");
            searchGoatDisease.setSelectedItem("SELECT");
        }
   
           try {
                 
                
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT gv_id FROM tbl_vacc_goats");
                 
                 while(rs.next()){
                     
                     searchGoatIDH.addItem(rs.getString("gv_id"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_searchGoatIDHFocusGained

    private void buttonAddVacc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddVacc1ActionPerformed
       this.dispose();
       new AddVaccGoat().setVisible(true);
    }//GEN-LAST:event_buttonAddVacc1ActionPerformed

    private void buttonGDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGDeleteActionPerformed
      
         // Delete Cattle
        
        Connection conn = myConnection.getConnect();
         String IDG = (String) filterTagGoats.getSelectedItem();
        
        if(IDG.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, " Please Search Livestock ID to Delete!", "Select ID to Delete!", JOptionPane.ERROR_MESSAGE);
            filterTagGoats.grabFocus();
        } else {
            
        try {
            
           String sql = "DELETE FROM tbl_goat_info WHERE g_tag_id = ? ";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,IDG);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.DEFAULT_OPTION);  
      
            this.dispose();
            new ClassLivestock().setVisible(true);
          
        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
             //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);   
        }
      }
    }//GEN-LAST:event_buttonGDeleteActionPerformed

    private void buttonClearGoatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearGoatsActionPerformed
       
         filterTagGoats.setSelectedItem("SELECT");
         filterTagGoats.setEnabled(true);
         GONE.setText("");
         GTWO.setText("");
         GTHREE.setText("");
         GFOUR.setText("");
         GFIVE.setText("");
         GSIXS.setText("");
         GSEVEN.setText("");
         GEIGHT.setText("");
         GNINE.setText("");
         GTEN.setText("");
         GELEVEN.setText("");
         GTWELEVE.setText("");
         GTHIRTEEN.setText("");
         GFOURTEEN.setText("");
         GFIFTHTEEN.setText("");
         GSIXSTEEN.setText("");
         GSEVENTEEN.setText("");
   
         GTWENTYONE.setText("");
         GTWENTYTWO.setText("");
         labelImage.setIcon(null);
         DefaultTableModel model = (DefaultTableModel) tableGoatLamHistory.getModel();
         model.setRowCount(0);
      
         DefaultTableModel modelH = (DefaultTableModel) tableGoatHealthHistory.getModel();
         modelH.setRowCount(0);
        
    }//GEN-LAST:event_buttonClearGoatsActionPerformed

    private void buttonGSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGSearchActionPerformed
        
         Connection conn = myConnection.getConnect();
               
                String IDGoats = (String) filterTagGoats.getSelectedItem();
                filterTagGoats.requestFocus();
                if(IDGoats.equals("SELECT")) {

                        JOptionPane.showMessageDialog(null, "Please select ID to search!");
                
                        
                } else {
           
                            
                try {
                  GoatMatingTableMain();
                  GoatsHealthTableMain();
                  matingGoatsMain();
                  GoatInfoMain();
                  
                    //Establish / Open Connection
                    
                    String sql = "SELECT g_tag_id, g_name, g_breed, g_dob, g_studcom, g_gender, g_paddock, g_herdtype, g_birthweight, "
                            + " g_weanweight, g_weandate, g_12monthweight, g_12monthweightdate, g_breedingstatues, g_ram1stgen, g_ewe1stgen, g_picture FROM tbl_goat_info WHERE g_tag_id = ?";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, IDGoats);


                    //Executing Query
                    ResultSet rs = sta.executeQuery();
                    byte[] image = null;
                    if (rs.next()) {
                        filterTagGoats.setEnabled(false);
                        GONE.setText(rs.getString("g_tag_id"));                       
                        GTWO.setText(rs.getString("g_name"));                         
                        GTHREE.setText(rs.getString("g_breed"));                     
                        GFOUR.setText(rs.getString("g_dob"));                           
                        GFIVE.setText(rs.getString("g_studcom"));                  
                        GSIXS.setText(rs.getString("g_gender"));                
                        GSEVEN.setText(rs.getString("g_paddock"));    
                        
                        GEIGHT.setText(rs.getString("g_herdtype"));                      
                        GNINE.setText(rs.getString("g_birthweight"));  
                        GTEN.setText(rs.getString("g_weanweight"));
                        GELEVEN.setText(rs.getString("g_weandate"));   
                        
                        GTWELEVE.setText(rs.getString("g_12monthweight"));  
                        GTHIRTEEN.setText(rs.getString("g_12monthweightdate"));              
                        GFOURTEEN.setText(rs.getString("g_breedingstatues")); 
                   
                        GTWENTYONE.setText(rs.getString("g_ram1stgen"));               
                        GTWENTYTWO.setText(rs.getString("g_ewe1stgen"));              
                        image = (rs.getBytes("g_picture"));
                    
                    if(image != null) {
                        Image img = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon icon = new ImageIcon(img.getScaledInstance(labelImage1.getWidth(), labelImage1.getHeight(), Image.SCALE_SMOOTH));
                        labelImage1.setIcon(icon);
                    } else {
                        sta.setNull(1, Types.BLOB);
                    }
                     
                    }
                        } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
             //   JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
    }//GEN-LAST:event_buttonGSearchActionPerformed

    private void buttonGUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGUpdateActionPerformed
        this.dispose();
        new UpdateGoat().setVisible(true);
    }//GEN-LAST:event_buttonGUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new AddMatingGoats().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonCClose5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCClose5ActionPerformed
        
            this.dispose();
            new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCClose5ActionPerformed

    private void buttonCClose4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCClose4ActionPerformed
        
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCClose4ActionPerformed

    private void buttonAddKidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddKidActionPerformed
        
        this.dispose();
        new AddKid().setVisible(true);
    }//GEN-LAST:event_buttonAddKidActionPerformed

    private void filterGoatWeanerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterGoatWeanerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterGoatWeanerIDActionPerformed

    private void filterGenderSheepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterGenderSheepItemStateChanged
        String queryMS = (String) filterGenderSheep.getSelectedItem().toString();
        filterSheepMain(queryMS);
    }//GEN-LAST:event_filterGenderSheepItemStateChanged

    private void filterPaddockSheepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterPaddockSheepItemStateChanged
        
        String queryMS = (String) filterPaddockSheep.getSelectedItem().toString();
        filterSheepMain(queryMS);
    }//GEN-LAST:event_filterPaddockSheepItemStateChanged

    private void filterPaddockSheepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterPaddockSheepFocusGained

           if(!filterPaddockSheep.equals("SELECT")) {
            
            filterTagSheep.setSelectedItem("SELECT");
            filterGenderSheep.setSelectedItem("SELECT");
      } 
        
        try {
                 
                   
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     filterPaddockSheep.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_filterPaddockSheepFocusGained

    private void buttonCloseSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseSMActionPerformed
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseSMActionPerformed

    private void buttonClearG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearG1ActionPerformed
         this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearG1ActionPerformed

    private void buttonSAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSAddActionPerformed
       this.dispose();
       new AddSheep().setVisible(true);
    }//GEN-LAST:event_buttonSAddActionPerformed

    private void buttonSSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSSearchActionPerformed
        
        Connection conn = myConnection.getConnect();
               
                String IDsheep = (String) TagIDSAdd.getSelectedItem();
                TagIDSAdd.requestFocus();
                
                if(IDsheep.equals("SELECT")) {

                        JOptionPane.showMessageDialog(null, "Please select ID to search!");
                
                        
                } else {
           
                            
                try {
                    MatingTable();
                    SheepHealthHistoryTable();
                     matingSheepMain();
                     SheepInfoMain();
                    //Establish / Open Connection
                    
                    String sql = "SELECT s_tag_id, s_name, s_breed, s_dob, s_studcom, s_gender, s_paddock, s_herdtype, s_birthweight, "
                            + " s_weanweight, s_weandate, s_12monthweight, s_12monthweightdate, s_breedingstatues, s_ram1stgen, s_ewe1stgen, s_picture FROM tbl_sheep_info WHERE s_tag_id = ?";

                    PreparedStatement sta = conn.prepareStatement(sql);

                    sta.setString(1, IDsheep);


                    //Executing Query
                    ResultSet rs = sta.executeQuery();
                    byte[] image = null;
                    if (rs.next()) {
                        TagIDSAdd.setEnabled(false);
                        SONE.setText(rs.getString("s_tag_id"));                       
                        STWO.setText(rs.getString("s_name"));                         
                        STHREE.setText(rs.getString("s_breed"));                     
                        SFOUR.setText(rs.getString("s_dob"));                           
                        SFIVE.setText(rs.getString("s_studcom"));                  
                        SSIXS.setText(rs.getString("s_gender"));                
                        SSEVEN.setText(rs.getString("s_paddock"));    
                        
                        SEIGHT.setText(rs.getString("s_herdtype"));                      
                        SNINE.setText(rs.getString("s_birthweight"));  
                        STEN.setText(rs.getString("s_weanweight"));
                        SELEVEN.setText(rs.getString("s_weandate"));   
                        
                        STWELEVE.setText(rs.getString("s_12monthweight"));  
                        STHIRTEEN.setText(rs.getString("s_12monthweightdate"));              
                        SFOURTEEN.setText(rs.getString("s_breedingstatues")); 
             
        
                        STWENTYONE.setText(rs.getString("s_ram1stgen"));               
                        STWENTYTWO.setText(rs.getString("s_ewe1stgen"));              
                        image = (rs.getBytes("s_picture"));
                    
                    if(image != null) {
                        Image img = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon icon = new ImageIcon(img.getScaledInstance(labelImageS.getWidth(), labelImageS.getHeight(), Image.SCALE_SMOOTH));
                        labelImageS.setIcon(icon);
                    } else {
                        sta.setNull(1, Types.BLOB);
                    }
                     
                    }
                        } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "Sheep Add/Edit Tab - System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }
    }//GEN-LAST:event_buttonSSearchActionPerformed

    private void buttonSUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSUpdateActionPerformed
        
        this.dispose();
        new UpdateSheep().setVisible(true);
    }//GEN-LAST:event_buttonSUpdateActionPerformed

    private void buttonSDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSDeleteActionPerformed
         // Delete Cattle
        
        Connection conn = myConnection.getConnect();
         String IDG = (String) TagIDSAdd.getSelectedItem();
        
        if(IDG.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, " Please Search Livestock ID to Delete!", "Select ID to Delete!", JOptionPane.ERROR_MESSAGE);
            TagIDSAdd.grabFocus();
        
        } else { 
         
         
        try {
            
           String sql = "DELETE FROM tbl_sheep_info WHERE s_tag_id = ? ";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,IDG);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.DEFAULT_OPTION);  
      
            this.dispose();
            new ClassLivestock().setVisible(true);
          
        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
              //JOptionPane.showMessageDialog(null, " Delete Sheep - System got an error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);   
        }
      }
    }//GEN-LAST:event_buttonSDeleteActionPerformed

    private void buttonClearSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearSheepActionPerformed
     
         TagIDSAdd.setSelectedItem("SELECT");
         TagIDSAdd.setEnabled(true);
         SONE.setText("");
         STWO.setText("");
         STHREE.setText("");
         SFOUR.setText("");
         SFIVE.setText("");
         SSIXS.setText("");
         SSEVEN.setText("");
         SEIGHT.setText("");
         SNINE.setText("");
         STEN.setText("");
         SELEVEN.setText("");
         STWELEVE.setText("");
         STHIRTEEN.setText("");
         SFOURTEEN.setText("");
         SFIFTHTEEN.setText("");
         SSIXSTEEN.setText("");
         SSEVENTEEN.setText("");
    
         STWENTYONE.setText("");
         STWENTYTWO.setText("");
         labelImageS.setIcon(null);
         DefaultTableModel modelS = (DefaultTableModel) tableMatingHistory.getModel();
         modelS.setRowCount(0);
      
         DefaultTableModel modelSS = (DefaultTableModel) tableSheepHealthHistory.getModel();
         modelSS.setRowCount(0);
    }//GEN-LAST:event_buttonClearSheepActionPerformed

    private void TagIDSAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TagIDSAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TagIDSAddActionPerformed

    private void SONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SONEActionPerformed

    private void SNINEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SNINEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SNINEKeyPressed

    private void SFOURTEENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SFOURTEENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SFOURTEENActionPerformed

    private void STENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STENActionPerformed

    private void STENKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STENKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_STENKeyPressed

    private void STWELEVEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STWELEVEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_STWELEVEKeyPressed

    private void buttonSCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSCloseActionPerformed
       
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonSCloseActionPerformed

    private void matingIDSheepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matingIDSheepItemStateChanged
           // Filter by Tag ID
        
        String querySM = (String) matingIDSheep.getSelectedItem().toString();
        filterSheepSM(querySM);
    }//GEN-LAST:event_matingIDSheepItemStateChanged

    private void matingIDSheepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_matingIDSheepFocusGained


      if(!matingIDSheep.equals("SELECT")) {
            
            searchNextMating.setSelectedItem("SELECT");
            matingStartSheep.setSelectedItem("SELECT");
      }        
                                             
        //Populate Jcomobox with Mating ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT sm_tag_id FROM tbl_mating_sheep");

            while(rs.next()){

                matingIDSheep.addItem(rs.getString("sm_tag_id"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
      
    
    }//GEN-LAST:event_matingIDSheepFocusGained

    private void matingStartSheepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matingStartSheepItemStateChanged
      
        String querySM = (String) matingStartSheep.getSelectedItem().toString();
        filterSheepSM(querySM);
    }//GEN-LAST:event_matingStartSheepItemStateChanged

    private void matingStartSheepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_matingStartSheepFocusGained
        
        if(!matingStartSheep.equals("SELECT")) {
            
            matingIDSheep.setSelectedItem("SELECT");
            searchNextMating.setSelectedItem("SELECT");
      } 
        
        
        
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT sm_k_start FROM tbl_mating_sheep");

            while(rs.next()){

                matingStartSheep.addItem(rs.getString("sm_k_start"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_matingStartSheepFocusGained

    private void searchNextMatingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchNextMatingItemStateChanged
        String querySM = (String) searchNextMating.getSelectedItem().toString();
        filterSheepSM(querySM);
    }//GEN-LAST:event_searchNextMatingItemStateChanged

    private void searchNextMatingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchNextMatingFocusGained
         if(!searchNextMating.equals("SELECT")) {
            matingIDSheep.setSelectedItem("SELECT");
            searchNextMating.setSelectedItem("SELECT");
      } 
        
        
        
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT sm_nextmating FROM tbl_mating_sheep");

            while(rs.next()){

                searchNextMating.addItem(rs.getString("sm_nextmating"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_searchNextMatingFocusGained

    private void buttonUpdateMatingSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateMatingSheepActionPerformed
        
        this.dispose();
        new UpdateMatingSheep().setVisible(true);
    }//GEN-LAST:event_buttonUpdateMatingSheepActionPerformed

    private void buttonDeleteMatingSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteMatingSheepActionPerformed
        
         Connection conn = myConnection.getConnect();
               
        try {
              
            //Get Table Model
            
            DefaultTableModel tblModelSS = (DefaultTableModel) tableMatingSheeps.getModel();
            
            if(tableMatingSheeps.getSelectedRowCount()==1) {
            
            int row = tableMatingSheeps.getSelectedRow();
            String cell = tableMatingSheeps.getModel().getValueAt(row, 0).toString();
            tblModelSS.removeRow((int) row);
            String sql = "DELETE FROM tbl_mating_sheep WHERE sm_tag_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
            this.dispose();
            new ClassLivestock().setVisible(true);                       
            } else {
                
                if(tableMatingSheeps.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
             //    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
    }//GEN-LAST:event_buttonDeleteMatingSheepActionPerformed

    private void buttonClearMatingSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearMatingSheepActionPerformed
       
             this.dispose();
             new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearMatingSheepActionPerformed

    private void buttonCloseMatingSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseMatingSheepActionPerformed
       
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseMatingSheepActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new AddMatingSheep().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buttonViewSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewSActionPerformed
        
         Connection conn = myConnection.getConnect();
                String sheepID = (String) searchLamb.getSelectedItem();
                searchLamb.requestFocus();
               
                if(sheepID.equals("SELECT")) {

                        JOptionPane.showMessageDialog(null, "Please select ID to search!");
                   
                        
                } else {
                                
                try {
                   LambHealthTable();
                   
                    //Establish / Open Connection
                   
                    String sql = "SELECT s_tag_id, s_name, s_breed, s_dob, s_studcom, s_gender, s_birthweight, s_paddock, s_herdgroup, s_weanweight,"
                            + "s_weandate, s_ramID, s_eweID, s_birthstatues, s_healthstatues, s_hornstatues FROM tbl_lamb_info WHERE s_tag_id = ? ";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, sheepID);
                    //Executing Query
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) {
                        
                        sTag.setText(rs.getString("s_tag_id"));                         //Tag ID
                        sName.setText(rs.getString("s_name"));                           //Animale name
                        sBreed.setSelectedItem(rs.getString("s_breed"));                        //Breed
                        sDob.setDate(rs.getDate("s_dob"));                               //Date of Birth
                        sStudCom.setSelectedItem(rs.getString("s_studcom"));                     //stud / com
                        sGender.setSelectedItem(rs.getString("s_gender"));                       //Gender
                        sBirthWeight.setText(rs.getString("s_birthweight"));              //Birth weight
                        sPaddock.setSelectedItem(rs.getString("s_paddock"));                      //Paddock
                        sHerdGroup.setSelectedItem(rs.getString("s_herdgroup"));                  //Herd Type
                        
                        sWeanWeight.setText(rs.getString("s_weanweight"));                 // wean Weight
                        sWeanDate.setDate(rs.getDate("s_weandate"));                       // Wean Date
                        sRamID.setText(rs.getString("s_ramID"));                        // Sire / Ram ID
                        sEweID.setText(rs.getString("s_eweID"));                          // Dam / Ewe ID
                        sBirthStatues.setSelectedItem(rs.getString("s_birthstatues"));               // Birth statues
                        sHealthStatues.setSelectedItem(rs.getString("s_healthstatues"));          // Health stautes
                        sHornStatues.setSelectedItem(rs.getString("s_hornstatues"));              // Horn Type
              
                            
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "ID not Found, Please try again!");
                        searchLamb.setSelectedItem("SELECT");
                  
                    }
                   
                  conn.close();
                  
                } catch (SQLException | HeadlessException | NullPointerException | NumberFormatException e) {
                    System.err.println(e.getMessage());
                   // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
                   
            }
    }//GEN-LAST:event_buttonViewSActionPerformed

    private void buttonUpdateSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateSActionPerformed
      
       // Update lamb Records
        
        Connection conn = myConnection.getConnect();
      
        String lambID =(String) searchLamb.getSelectedItem();
        String stag = sTag.getText().trim();
        String sname = sName.getText().trim();
        String sbreed = (String) sBreed.getSelectedItem();
       
        String sstud = (String) sStudCom.getSelectedItem();
         
         String sgender = (String) sGender.getSelectedItem();
         String sbirthweight = sBirthWeight.getText().trim();
         String spaddock = (String) sPaddock.getSelectedItem();
         String sherdg = (String) sHerdGroup.getSelectedItem();
         String sweanweight = sWeanWeight.getText().trim();
       
         String sram = sRamID.getText().trim();
         String sewe = sEweID.getText().trim();
         String sbirthstatues = (String) sBirthStatues.getSelectedItem();
         String shealthstatues = (String) sHealthStatues.getSelectedItem();
         String shorntatues = (String) sHornStatues.getSelectedItem();
         
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String sdob = sdf.format(sDob.getDate());
          String sweandate = sdf.format(sWeanDate.getDate());
             
         

        if(lambID.equals("SELECT")) {
            
            JOptionPane.showMessageDialog(null, " Please Enter Lamb ID to Update!", "ID / Name Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            searchKid.grabFocus();
            
        } else { 
        
        try {
                    
           
            String query = "UPDATE tbl_lamb_info SET " +
                            "s_tag_id = '" + stag + "', s_name = '" + sname + "', s_breed = '" + sbreed + "', s_dob = '" + sdob + "', s_studcom = '"
                            + sstud + "', s_gender = '" + sgender + "', s_birthweight = '" + sbirthweight + "', s_paddock = '" + spaddock + "', s_herdgroup = '" 
                            + sherdg + "', s_weanweight = ?, s_weandate = '" + sweandate + "', s_ramID = '" + sram + "', s_eweID = '" + sewe + "', s_birthstatues = '" + sbirthstatues + "', s_healthstatues = '" 
                            + shealthstatues + "', s_hornstatues = '" + shorntatues + "' " + " WHERE s_tag_id = '" + lambID + "'";

                    PreparedStatement statement = conn.prepareStatement(query);

                    
                    
                       // Accept Null excption from string to Integer
                try { 
                  if ( sWeanWeight.getText().isEmpty() ) {
                        statement.setNull(1, Types.NULL);
                      } else {
                    statement.setInt(1, Integer.parseInt(sWeanWeight.getText()));
                      }
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.print(" Wean Weight:  System Error exception" + e.getMessage());
                    
                }
                    
                    
                    
                    
              int i = statement.executeUpdate();
             
              if(i >= 1){
                 
                JOptionPane.showMessageDialog(this, "" + stag + " data successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);
                buttonUpdateS.setEnabled(false);
                radioUpdateS.setSelected(false);
                buttonClearS.setEnabled(true);
                buttonViewS.setEnabled(true);
                buttonDeleteS.setEnabled(true);
                searchLamb.setEditable(true);
                searchLamb.setSelectedItem("SELECT");
                sTag.setText("");
                sName.setText("");
                sBreed.setSelectedItem("SELECT");
                sDob.setDate(null);
                sStudCom.setSelectedItem("SELECT");
                sGender.setSelectedItem("SELECT");
                sBirthWeight.setText("");
                sPaddock.setSelectedItem("SELECT");
                sHerdGroup.setSelectedItem("SELECT");
                sWeanWeight.setText("");
                sWeanDate.setDate(null);
                sRamID.setText("");
                sEweID.setText("");
                sBirthStatues.setSelectedItem("SELECT");
                sHealthStatues.setSelectedItem("SELECT");
                sHornStatues.setSelectedItem("SELECT");
                radioUpdateS.setSelected(false);
                LambstextfieldEditable();
                DefaultTableModel model = (DefaultTableModel) tableLambHealth.getModel();
                model.setRowCount(0);

            
              }
            
        } catch (SQLException | HeadlessException e) {
               System.err.println(e.getMessage());
                      //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      } 
    }//GEN-LAST:event_buttonUpdateSActionPerformed

    private void buttonDeleteSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteSActionPerformed
       
         Connection conn = myConnection.getConnect();
        String deleteSheep = (String) searchLamb.getSelectedItem();
        String sID =  sTag.getText().trim();
        
        if(deleteSheep.equals("SELECT") ) {
            
            JOptionPane.showMessageDialog(null, " Please first search Lamb ID from search bar to Delete!", "ID / Name Empty or Incorrect!", JOptionPane.ERROR_MESSAGE);
            searchLamb.grabFocus();
    
        } else {
        try {
                    
            String sqldelete = "DELETE FROM tbl_lamb_info WHERE s_tag_id = '" + sID + "'";
            
            PreparedStatement pst=conn.prepareStatement(sqldelete);
            int deleted = pst.executeUpdate(sqldelete);
            
            if(deleted == 0) {
                
                JOptionPane.showMessageDialog(null, "No record deleted, please retry!", "DELETION ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
            
            JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
            searchLamb.setSelectedItem("SELECT");
        
             this.dispose();
            new ClassLivestock().setVisible(true);
        
         DefaultTableModel model = (DefaultTableModel) tableLambHealth.getModel();
         model.setRowCount(0);
         
            
           searchLamb.grabFocus();
          
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
             System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
        
        }
    }//GEN-LAST:event_buttonDeleteSActionPerformed

    private void buttonCloseSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseSActionPerformed
       this.dispose();
       new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseSActionPerformed

    private void buttonClearSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearSActionPerformed
        
        searchLamb.setSelectedItem("SELECT");
         sTag.setText("");
         sName.setText("");
         sBreed.setSelectedItem("SELECT");
         sDob.setDate(null);
         sStudCom.setSelectedItem("SELECT");
         sGender.setSelectedItem("SELECT");
         sBirthWeight.setText("");
         sPaddock.setSelectedItem("SELECT");
         sHerdGroup.setSelectedItem("SELECT");
         sWeanWeight.setText("");
         sWeanDate.setDate(null);
         sRamID.setText("");
         sEweID.setText("");
         sBirthStatues.setSelectedItem("SELECT");
         sHealthStatues.setSelectedItem("SELECT");
         sHornStatues.setSelectedItem("SELECT");
         radioUpdateS.setSelected(false);
         searchLamb.requestFocus(true);
        
         DefaultTableModel model = (DefaultTableModel) tableLambHealth.getModel();
         model.setRowCount(0);;
    }//GEN-LAST:event_buttonClearSActionPerformed

    private void searchLambFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchLambFocusGained
        
        //Populate Jcomobox with lAMB ID
        Connection conn = myConnection.getConnect();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT s_tag_id FROM tbl_lamb_info");

            while(rs.next()){

                searchLamb.addItem(rs.getString("s_tag_id"));
            }
        } catch (SQLException | HeadlessException | NullPointerException e) {
            System.err.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
      
    }//GEN-LAST:event_searchLambFocusGained

    private void buttonAddLambActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddLambActionPerformed
        this.dispose();
        new AddLamb().setVisible(true);
    }//GEN-LAST:event_buttonAddLambActionPerformed

    private void radioUpdateSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioUpdateSActionPerformed
       
        String sheepID = (String) searchLamb.getSelectedItem();
        
        if(sheepID.equals("SELECT")) {
            radioUpdateS.setSelected(false);
            JOptionPane.showMessageDialog(null, "First search Calf and then select 'Update Fields! ",  "ERROR", JOptionPane.DEFAULT_OPTION);   
       
        } else if(radioUpdateS.isSelected()){
           
            searchLamb.setEditable(false);
            sTag.setEditable(true);
            sTag.requestFocus();
            sName.setEditable(true);
            sBreed.setEnabled(true);
            sDob.setEnabled(true);
            sStudCom.setEnabled(true);
            sGender.setEnabled(true);
            sBirthWeight.setEditable(true);
            sPaddock.setEnabled(true);
            sHerdGroup.setEnabled(true);
            sWeanWeight.setEditable(true);
            sWeanDate.setEnabled(true);
            sRamID.setEditable(true);
            sEweID.setEditable(true);
            sBirthStatues.setEnabled(true);
            sHealthStatues.setEnabled(true);
            sHornStatues.setEnabled(true);
            buttonClearS.setEnabled(false);
            buttonViewS.setEnabled(false);
            buttonDeleteS.setEnabled(false);
            buttonUpdateS.setEnabled(true);
        } else {
            
            searchLamb.setEditable(true);
            sTag.setEditable(false);
            sTag.requestFocus();
            sName.setEditable(false);
            sBreed.setEditable(false);
            sDob.setEnabled(false);
            sStudCom.setEditable(false);
            sGender.setEditable(false);
            sBirthWeight.setEditable(false);
            sPaddock.setEditable(false);
            sHerdGroup.setEditable(false);
            sWeanWeight.setEditable(false);
            sWeanDate.setEnabled(false);
            sRamID.setEditable(false);
            sEweID.setEditable(false);
            sBirthStatues.setEditable(false);
            sHealthStatues.setEditable(false);
            sHornStatues.setEditable(false);
            buttonClearS.setEnabled(true);
            buttonViewS.setEnabled(true);
            buttonDeleteS.setEnabled(true);
            buttonUpdateS.setEnabled(true);
           
        }
    }//GEN-LAST:event_radioUpdateSActionPerformed

    private void sPaddockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sPaddockFocusGained
        
          try {
                 
                   
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     sPaddock.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_sPaddockFocusGained

    private void sHerdGroupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sHerdGroupFocusGained
        
          try {
                 
               Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                   
                     sHerdGroup.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_sHerdGroupFocusGained

    private void buttonUpdateWeanerSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateWeanerSActionPerformed
        this.dispose();
        new UpdateWeanerSheep().setVisible(true);
    }//GEN-LAST:event_buttonUpdateWeanerSActionPerformed

    private void buttonDeleteWeanerSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteWeanerSActionPerformed
        
         // Delete weaner lamb and Health History
        
        Connection conn = myConnection.getConnect();
        String searchID = (String) searchWeanerSheep.getSelectedItem();
           
        if(searchID.equals("SHEEP") ) {
            
            JOptionPane.showMessageDialog(null, " Please select single Row to Delete", "SELECT ROW TO DELETE!", JOptionPane.ERROR_MESSAGE);
            searchWeanerSheep.grabFocus();
      
  
        } else { 
         
         
        try {
 
            //Get Table Model
            
            DefaultTableModel tblModelG = (DefaultTableModel) tableWeanerSheep.getModel();
            
            if(tableWeanerSheep.getSelectedRowCount()==1) {
            
            int row = tableWeanerSheep.getSelectedRow();
            String cell = tableWeanerSheep.getModel().getValueAt(row, 0).toString();
            tblModelG.removeRow((int) row);
            String sql = "DELETE FROM tbl_weaner_lambs WHERE sw_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
            searchWeanerSheep.setBackground(Color.WHITE);    
            this.dispose();
            new ClassLivestock().setVisible(true);
                        
            } else {
                
                if(tableWeanerSheep.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please search animal ID and then select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
                conn.close();
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());        
                        //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      }
    }//GEN-LAST:event_buttonDeleteWeanerSActionPerformed

    private void buttonCloseWeaner2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseWeaner2ActionPerformed
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCloseWeaner2ActionPerformed

    private void buttonClearWeanerSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearWeanerSActionPerformed
        this.dispose();
        new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearWeanerSActionPerformed

    private void typeWeanerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeWeanerItemStateChanged
        
           
        String querySW = (String) typeWeaner.getSelectedItem().toString();
         filterSheepW(querySW);
    }//GEN-LAST:event_typeWeanerItemStateChanged

    private void typeWeanerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typeWeanerFocusGained
        // TODO add your handling code here:
        
          if(!typeWeaner.equals("SELECT")) {
            
            searchWeanerSheep.setSelectedItem("SELECT");
     
      }
          
     
    }//GEN-LAST:event_typeWeanerFocusGained

    private void searchWeanerSheepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchWeanerSheepItemStateChanged
           // Filter by Tag ID
        
        String querySW = (String) searchWeanerSheep.getSelectedItem().toString();
         filterSheepW(querySW);
    }//GEN-LAST:event_searchWeanerSheepItemStateChanged

    private void searchWeanerSheepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchWeanerSheepFocusGained
       
        
     SheepweanerID();
      if(!searchWeanerSheep.equals("SELECT")) {
            
            typeWeaner.setSelectedItem("SELECT");
     
      }
        
    }//GEN-LAST:event_searchWeanerSheepFocusGained

    private void buttonAddWeanerSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddWeanerSheepActionPerformed
       this.dispose();
       new AddWeanerSheep().setVisible(true);
    }//GEN-LAST:event_buttonAddWeanerSheepActionPerformed

    private void buttonDeleteA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteA2ActionPerformed
       
         // Delete Goat Health History
        
        Connection conn = myConnection.getConnect();
        String searchID = (String) tagSearchSheepHealth.getSelectedItem();
           
        if(searchID.equals("SELECT") ) {
            
            JOptionPane.showMessageDialog(null, " Please Select a Single row to Delete", "Select row to Delete!", JOptionPane.ERROR_MESSAGE);
            tagSearchSheepHealth.grabFocus();
      
  
        } else { 
         
         
        try {
            
        
            //Get Table Model
            
            DefaultTableModel tblModelSH = (DefaultTableModel) sheepTableHealth.getModel();
            
            if(sheepTableHealth.getSelectedRowCount()==1) {
            
            int row = sheepTableHealth.getSelectedRow();
            String cell = sheepTableHealth.getModel().getValueAt(row, 0).toString();
            tblModelSH.removeRow((int) row);
            String sql = "DELETE FROM tbl_vacc_sheep WHERE sv_id = ?";
                        
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1,cell);
            
            psm.execute();
            JOptionPane.showMessageDialog(null, " Successfully Deleted", "DELETED!", JOptionPane.ERROR_MESSAGE);  
            tagSearchSheepHealth.setBackground(Color.WHITE);    
            this.dispose();
            new ClassLivestock().setVisible(true);
                        
            } else {
                
                if(sheepTableHealth.getRowCount() == 0) {
                    
                    // Table has no data / empty
                    
                    JOptionPane.showMessageDialog(null, " Table is Empty", "ERROR, TABLE EMPTY!", JOptionPane.ERROR_MESSAGE);  
                } else {
                    
                    // If table is not empty but no row selected
                          JOptionPane.showMessageDialog(null, " Please search animal ID and then select a SINGLE row to delete!", "ERROR, No Selection!", JOptionPane.ERROR_MESSAGE);  
             
                }   
                conn.close();
            }

        } catch (SQLException | HeadlessException | NullPointerException e) {
                 System.err.println(e.getMessage());        
                        //JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);   
        }
      } 
    }//GEN-LAST:event_buttonDeleteA2ActionPerformed

    private void buttonCClose7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCClose7ActionPerformed
      this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonCClose7ActionPerformed

    private void buttonClearA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearA2ActionPerformed

       this.dispose();
       new ClassLivestock().setVisible(true);
    }//GEN-LAST:event_buttonClearA2ActionPerformed

    private void sheepDiseaseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sheepDiseaseItemStateChanged
            String querySH = (String) sheepDisease.getSelectedItem().toString();
            filterSheep(querySH);
    }//GEN-LAST:event_sheepDiseaseItemStateChanged

    private void sheepDiseaseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sheepDiseaseFocusGained
       
             // Populate Disease

        
        if(!sheepDisease.equals("SELECT")) {
            tagSearchSheepHealth.setSelectedItem("SELECT");
            sheepVacc.setSelectedItem("SELECT");
        }
       
        try {
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_disease FROM tbl_disease");
                 
                 while(rs.next()){
                     
                     sheepDisease.addItem(rs.getString("v_disease"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        
        
    }//GEN-LAST:event_sheepDiseaseFocusGained

    private void sheepVaccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sheepVaccItemStateChanged
        
        String querySH = (String) sheepVacc.getSelectedItem().toString();
        filterSheep(querySH);
    }//GEN-LAST:event_sheepVaccItemStateChanged

    private void sheepVaccFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sheepVaccFocusGained
       
           // Populate Vaccination JComboboxs
        
        
        if(!sheepVacc.equals("SELECT")) {
       
            tagSearchSheepHealth.setSelectedItem("SELECT");
            sheepVacc.setSelectedItem("SELECT");
        }
 
      
        try {
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT v_vacc FROM tbl_vacc");
                 
                 while(rs.next()){
                     
                     sheepVacc.addItem(rs.getString("v_vacc"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_sheepVaccFocusGained

    private void tagSearchSheepHealthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tagSearchSheepHealthItemStateChanged
          // Filter by Tag ID
        
        String querySH = (String) tagSearchSheepHealth.getSelectedItem().toString();
        filterSheep(querySH);
        
    }//GEN-LAST:event_tagSearchSheepHealthItemStateChanged

    private void tagSearchSheepHealthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tagSearchSheepHealthFocusGained
            
           // Populate with JComboboxs
           SheepWeanerIDHealth();
           LambIDHealth();
           
        
        if(!tagSearchSheepHealth.equals("SELECT")) {
            
            sheepVacc.setSelectedItem("SELECT");
            sheepDisease.setSelectedItem("SELECT");
        }
   
           try {
                 
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s_tag_id FROM tbl_sheep_info");
                 
                 while(rs.next()){
                     
                     tagSearchSheepHealth.addItem(rs.getString("s_tag_id"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_tagSearchSheepHealthFocusGained

    private void buttonAddVacc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddVacc2ActionPerformed
        this.dispose();
        new AddVaccSheep().setVisible(true);
    }//GEN-LAST:event_buttonAddVacc2ActionPerformed

    private void filterTagSheepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterTagSheepFocusGained
     
        
      if(!filterTagSheep.equals("SELECT")) {
            
            filterGenderSheep.setSelectedItem("SELECT");
            filterPaddockSheep.setSelectedItem("SELECT");
      } 
        
        
       sheepID();
       SheepWeanerIDHealth();
       LambIDHealth();
     
    }//GEN-LAST:event_filterTagSheepFocusGained

    private void filterTagSheepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterTagSheepItemStateChanged
        String queryMS = (String) filterTagSheep.getSelectedItem().toString();
        filterSheepMain(queryMS);
    }//GEN-LAST:event_filterTagSheepItemStateChanged

    private void filterGenderSheepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterGenderSheepFocusGained
         if(!filterGenderSheep.equals("SELECT")) {
            
            filterTagSheep.setSelectedItem("SELECT");
            filterPaddockSheep.setSelectedItem("SELECT");
      } 
         
         
          try {
                 
               Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT herdtype FROM tbl_herdtype ORDER BY herdtype ASC");
                 
                 while(rs.next()){
                   
                     filterGenderSheep.addItem(rs.getString("herdtype"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
               // JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
         
    }//GEN-LAST:event_filterGenderSheepFocusGained

    private void buttonGCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGCloseActionPerformed
            this.dispose();
            new HomePage().setVisible(true);
    }//GEN-LAST:event_buttonGCloseActionPerformed

    private void filterPaddockGoatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterPaddockGoatsFocusGained
        
        
            if(!filterPaddockGoats.equals("SELECT")) {
            
            filterTagG.setSelectedItem("SELECT");
            filterHerdGoats.setSelectedItem("SELECT");
      } 
        
        try {
                 
                   
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     filterPaddockGoats.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }

    }//GEN-LAST:event_filterPaddockGoatsFocusGained

    private void filterTagGFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterTagGFocusGained
        
             
      if(!filterTagG.equals("SELECT")) {
            
            filterHerdGoats.setSelectedItem("SELECT");
            filterPaddockGoats.setSelectedItem("SELECT");
      } 
        
        
       goatID();
       kidsID();
       goatWeanerID();
    
    }//GEN-LAST:event_filterTagGFocusGained

    private void filterTagGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterTagGItemStateChanged
       
        String queryGM = (String) filterTagG.getSelectedItem().toString();
        filterGoatsMainPage(queryGM);
    }//GEN-LAST:event_filterTagGItemStateChanged

    private void ccPaddockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccPaddockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccPaddockActionPerformed

    private void filterCattleGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCattleGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterCattleGroupActionPerformed

    private void filterCattlePaddockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filterCattlePaddockFocusGained
           
        if(!filterCattlePaddock.equals("SELECT")) {
            
            filterCattleTag.setSelectedItem("SELECT");
            filterCattleGroup.setSelectedItem("SELECT");
      }
        
           try {
                 
                   
                Connection conn = myConnection.getConnect();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT pname FROM tbl_paddock");
                 
                 while(rs.next()){
                     
                     filterCattlePaddock.addItem(rs.getString("pname"));
                } 
            } catch (SQLException | HeadlessException | NullPointerException e) {
                System.err.println(e.getMessage());
              //  JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
    }//GEN-LAST:event_filterCattlePaddockFocusGained

    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassLivestock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CEIGHT;
    private javax.swing.JTextField CELEVEND;
    private javax.swing.JTextField CFIVE;
    private javax.swing.JTextField CFIVETEEN;
    private javax.swing.JTextField CFOURD;
    private javax.swing.JTextField CFOURTEEN;
    private javax.swing.JTextField CNINE;
    private javax.swing.JTextField CONE;
    private javax.swing.JTextField CSEVEN;
    private javax.swing.JTextField CSEVENTEEN;
    private javax.swing.JTextField CSIXS;
    private javax.swing.JTextField CSIXSTEEN;
    private javax.swing.JTextField CTEN;
    private javax.swing.JTextField CTHIRTEEND;
    private javax.swing.JTextField CTHREE;
    private javax.swing.JTextField CTWELVE;
    private javax.swing.JTextField CTWENTYONE;
    private javax.swing.JTextField CTWENTYTWO;
    private javax.swing.JTextField CTWO;
    private javax.swing.JTextField GEIGHT;
    private javax.swing.JTextField GELEVEN;
    private javax.swing.JTextField GFIFTHTEEN;
    private javax.swing.JTextField GFIVE;
    private javax.swing.JTextField GFOUR;
    private javax.swing.JTextField GFOURTEEN;
    private javax.swing.JTextField GNINE;
    private javax.swing.JTextField GONE;
    private javax.swing.JTextField GSEVEN;
    private javax.swing.JTextField GSEVENTEEN;
    private javax.swing.JTextField GSIXS;
    private javax.swing.JTextField GSIXSTEEN;
    private javax.swing.JTextField GTEN;
    private javax.swing.JTextField GTHIRTEEN;
    private javax.swing.JTextField GTHREE;
    private javax.swing.JTextField GTWELEVE;
    private javax.swing.JTextField GTWENTYONE;
    private javax.swing.JTextField GTWENTYTWO;
    private javax.swing.JTextField GTWO;
    private javax.swing.JTextField SEIGHT;
    private javax.swing.JTextField SELEVEN;
    private javax.swing.JTextField SFIFTHTEEN;
    private javax.swing.JTextField SFIVE;
    private javax.swing.JTextField SFOUR;
    private javax.swing.JTextField SFOURTEEN;
    private javax.swing.JTextField SNINE;
    private javax.swing.JTextField SONE;
    private javax.swing.JTextField SSEVEN;
    private javax.swing.JTextField SSEVENTEEN;
    private javax.swing.JTextField SSIXS;
    private javax.swing.JTextField SSIXSTEEN;
    private javax.swing.JTextField STEN;
    private javax.swing.JTextField STHIRTEEN;
    private javax.swing.JTextField STHREE;
    private javax.swing.JTextField STWELEVE;
    private javax.swing.JTextField STWENTYONE;
    private javax.swing.JTextField STWENTYTWO;
    private javax.swing.JTextField STWO;
    private javax.swing.JComboBox<String> TAGIDL;
    private javax.swing.JPanel TabMating;
    private javax.swing.JComboBox<String> TagIDSAdd;
    private javax.swing.JLabel btnAddMatingSheep;
    private javax.swing.JButton buttonAddKid;
    private javax.swing.JButton buttonAddLamb;
    private javax.swing.JButton buttonAddVacc;
    private javax.swing.JButton buttonAddVacc1;
    private javax.swing.JButton buttonAddVacc2;
    private javax.swing.JButton buttonAddWeaner;
    private javax.swing.JButton buttonAddWeaner1;
    private javax.swing.JButton buttonAddWeanerSheep;
    private javax.swing.JButton buttonCAdd;
    private javax.swing.JButton buttonCAdd2;
    private javax.swing.JButton buttonCClose;
    private javax.swing.JButton buttonCClose3;
    private javax.swing.JButton buttonCClose4;
    private javax.swing.JButton buttonCClose5;
    private javax.swing.JButton buttonCClose6;
    private javax.swing.JButton buttonCClose7;
    private javax.swing.JButton buttonClearA;
    private javax.swing.JButton buttonClearA1;
    private javax.swing.JButton buttonClearA2;
    private javax.swing.JButton buttonClearCC;
    private javax.swing.JButton buttonClearCattle;
    private javax.swing.JButton buttonClearCattle1;
    private javax.swing.JButton buttonClearG;
    private javax.swing.JButton buttonClearG1;
    private javax.swing.JButton buttonClearGoats;
    private javax.swing.JButton buttonClearK;
    private javax.swing.JButton buttonClearM;
    private javax.swing.JButton buttonClearM1;
    private javax.swing.JButton buttonClearMatingSheep;
    private javax.swing.JButton buttonClearS;
    private javax.swing.JButton buttonClearSheep;
    private javax.swing.JButton buttonClearWeaner;
    private javax.swing.JButton buttonClearWeaner1;
    private javax.swing.JButton buttonClearWeanerS;
    private javax.swing.JButton buttonCloseC;
    private javax.swing.JButton buttonCloseG;
    private javax.swing.JButton buttonCloseK;
    private javax.swing.JButton buttonCloseMatingSheep;
    private javax.swing.JButton buttonCloseS;
    private javax.swing.JButton buttonCloseSM;
    private javax.swing.JButton buttonCloseWeaner;
    private javax.swing.JButton buttonCloseWeaner1;
    private javax.swing.JButton buttonCloseWeaner2;
    private javax.swing.JButton buttonDeleteA;
    private javax.swing.JButton buttonDeleteA1;
    private javax.swing.JButton buttonDeleteA2;
    private javax.swing.JButton buttonDeleteCC;
    private javax.swing.JButton buttonDeleteK;
    private javax.swing.JButton buttonDeleteL;
    private javax.swing.JButton buttonDeleteM;
    private javax.swing.JButton buttonDeleteM1;
    private javax.swing.JButton buttonDeleteMatingSheep;
    private javax.swing.JButton buttonDeleteS;
    private javax.swing.JButton buttonDeleteWeaner;
    private javax.swing.JButton buttonDeleteWeaner1;
    private javax.swing.JButton buttonDeleteWeanerS;
    private javax.swing.JButton buttonGAdd;
    private javax.swing.JButton buttonGClose;
    private javax.swing.JButton buttonGDelete;
    private javax.swing.JButton buttonGSearch;
    private javax.swing.JButton buttonGUpdate;
    private javax.swing.JButton buttonSAdd;
    private javax.swing.JButton buttonSClose;
    private javax.swing.JButton buttonSDelete;
    private javax.swing.JButton buttonSSearch;
    private javax.swing.JButton buttonSUpdate;
    private javax.swing.JButton buttonSearchCow;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonUpdateCC;
    private javax.swing.JButton buttonUpdateK;
    private javax.swing.JButton buttonUpdateM;
    private javax.swing.JButton buttonUpdateM1;
    private javax.swing.JButton buttonUpdateMatingSheep;
    private javax.swing.JButton buttonUpdateS;
    private javax.swing.JButton buttonUpdateWeaner;
    private javax.swing.JButton buttonUpdateWeaner1;
    private javax.swing.JButton buttonUpdateWeanerS;
    private javax.swing.JButton buttonViewCalf;
    private javax.swing.JButton buttonViewK;
    private javax.swing.JButton buttonViewS;
    private javax.swing.JComboBox<String> ccBirthStatues;
    private javax.swing.JTextField ccBirthWeight;
    private javax.swing.JComboBox<String> ccBreed;
    private javax.swing.JTextField ccDamID;
    private com.toedter.calendar.JDateChooser ccDob;
    private javax.swing.JComboBox<String> ccGender;
    private javax.swing.JComboBox<String> ccHealthStatues;
    private javax.swing.JComboBox<String> ccHerdGroup;
    private javax.swing.JComboBox<String> ccHornStatues;
    private javax.swing.JTextField ccName;
    private javax.swing.JComboBox<String> ccPaddock;
    private javax.swing.JTextField ccSireID;
    private javax.swing.JComboBox<String> ccStudCom;
    private javax.swing.JTextField ccTag;
    private com.toedter.calendar.JDateChooser ccWeanDate;
    private javax.swing.JTextField ccWeanWeight;
    private javax.swing.JComboBox<String> filterCattleGroup;
    private javax.swing.JComboBox<String> filterCattlePaddock;
    private javax.swing.JComboBox<String> filterCattleTag;
    private javax.swing.JComboBox<String> filterDiseaseCattle;
    private javax.swing.JComboBox<String> filterGenderSheep;
    private javax.swing.JComboBox<String> filterGoatWeanerID;
    private javax.swing.JComboBox<String> filterHerdGoats;
    private javax.swing.JComboBox<String> filterMatingCattleID;
    private javax.swing.JComboBox<String> filterMatingGoats;
    private javax.swing.JComboBox<String> filterMatingNext;
    private javax.swing.JComboBox<String> filterNextGoats;
    private javax.swing.JComboBox<String> filterPaddockCattle;
    private javax.swing.JComboBox<String> filterPaddockGoats;
    private javax.swing.JComboBox<String> filterPaddockSheep;
    private javax.swing.JComboBox<String> filterStartCattle;
    private javax.swing.JComboBox<String> filterStartGoats;
    private javax.swing.JComboBox<String> filterTagCattle;
    private javax.swing.JComboBox<String> filterTagG;
    private javax.swing.JComboBox<String> filterTagGoats;
    private javax.swing.JComboBox<String> filterTagSheep;
    private javax.swing.JComboBox<String> filterTypeGoats;
    private javax.swing.JComboBox<String> filterVaccCattle;
    private javax.swing.JComboBox<String> filterWeanerTagCattle;
    private javax.swing.JComboBox<String> gBirthStatues;
    private javax.swing.JTextField gBirthWeight;
    private javax.swing.JComboBox<String> gBreed;
    private com.toedter.calendar.JDateChooser gDob;
    private javax.swing.JTextField gEweID;
    private javax.swing.JComboBox<String> gGender;
    private javax.swing.JComboBox<String> gHealthStatues;
    private javax.swing.JComboBox<String> gHerdGroup;
    private javax.swing.JComboBox<String> gHornStatues;
    private javax.swing.JTextField gName;
    private javax.swing.JComboBox<String> gPaddock;
    private javax.swing.JTextField gRamID;
    private javax.swing.JComboBox<String> gStudCom;
    private javax.swing.JTextField gTag;
    private com.toedter.calendar.JDateChooser gWeanDate;
    private javax.swing.JTextField gWeanWeight;
    private javax.swing.JTabbedPane goatSubPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
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
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
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
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelBG;
    private javax.swing.JLabel labelBGGoatsA;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelBg;
    private javax.swing.JLabel labelHeading;
    private javax.swing.JLabel labelHeading1;
    private javax.swing.JLabel labelHeading2;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelImage1;
    private javax.swing.JLabel labelImageS;
    private javax.swing.JComboBox<String> matingIDSheep;
    private javax.swing.JComboBox<String> matingStartSheep;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelSearch1;
    private javax.swing.JPanel panelSearch2;
    private javax.swing.JRadioButton radioUpdateCC;
    private javax.swing.JRadioButton radioUpdateG;
    private javax.swing.JRadioButton radioUpdateS;
    private javax.swing.JComboBox<String> sBirthStatues;
    private javax.swing.JTextField sBirthWeight;
    private javax.swing.JComboBox<String> sBreed;
    private com.toedter.calendar.JDateChooser sDob;
    private javax.swing.JTextField sEweID;
    private javax.swing.JComboBox<String> sGender;
    private javax.swing.JComboBox<String> sHealthStatues;
    private javax.swing.JComboBox<String> sHerdGroup;
    private javax.swing.JComboBox<String> sHornStatues;
    private javax.swing.JTextField sName;
    private javax.swing.JComboBox<String> sPaddock;
    private javax.swing.JTextField sRamID;
    private javax.swing.JComboBox<String> sStudCom;
    private javax.swing.JTextField sTag;
    private com.toedter.calendar.JDateChooser sWeanDate;
    private javax.swing.JTextField sWeanWeight;
    private javax.swing.JPanel searchBar;
    private javax.swing.JPanel searchBar1;
    private javax.swing.JPanel searchBar10;
    private javax.swing.JPanel searchBar11;
    private javax.swing.JPanel searchBar2;
    private javax.swing.JPanel searchBar3;
    private javax.swing.JPanel searchBar4;
    private javax.swing.JPanel searchBar5;
    private javax.swing.JPanel searchBar6;
    private javax.swing.JPanel searchBar7;
    private javax.swing.JPanel searchBar8;
    private javax.swing.JPanel searchBar9;
    private javax.swing.JComboBox<String> searchGoatDisease;
    private javax.swing.JComboBox<String> searchGoatIDH;
    private javax.swing.JComboBox<String> searchGoatVacc;
    private javax.swing.JComboBox<String> searchKid;
    private javax.swing.JComboBox<String> searchLamb;
    private javax.swing.JComboBox<String> searchNextMating;
    private javax.swing.JComboBox<String> searchWeanerSheep;
    private javax.swing.JComboBox<String> sheepDisease;
    private javax.swing.JTable sheepTableHealth;
    private javax.swing.JComboBox<String> sheepVacc;
    private javax.swing.JPanel tabAddCattle;
    private javax.swing.JPanel tabAnimaleHealth;
    private javax.swing.JPanel tabCalves;
    private javax.swing.JPanel tabCattle;
    private javax.swing.JPanel tabHealthGoat;
    private javax.swing.JPanel tabKidsGoats;
    private javax.swing.JPanel tabMainCattle;
    private javax.swing.JPanel tabMatingGoats;
    private javax.swing.JTabbedPane tabSubpan;
    private javax.swing.JTable tableAnimalHealth;
    private javax.swing.JTable tableAnimalHealthGoatsH;
    private javax.swing.JTable tableAnimalHealthHistory;
    private javax.swing.JTable tableCalfHealth;
    private javax.swing.JTable tableGoatHealthHistory;
    private javax.swing.JTable tableGoatLamHistory;
    private javax.swing.JTable tableGoats;
    private javax.swing.JTable tableLambHealth;
    private javax.swing.JTable tableLivestockHerd;
    private javax.swing.JTable tableMatingCalvingHistory;
    private javax.swing.JTable tableMatingGoats;
    private javax.swing.JTable tableMatingHerd;
    private javax.swing.JTable tableMatingHistory;
    private javax.swing.JTable tableMatingSheeps;
    private javax.swing.JTable tableSheepHealthHistory;
    private javax.swing.JTable tableSheepMain;
    private javax.swing.JTable tableWeanerCattle;
    private javax.swing.JTable tableWeanerGoats;
    private javax.swing.JTable tableWeanerSheep;
    private javax.swing.JTable tablegoatHealth;
    private javax.swing.JComboBox<String> tagSearchSheepHealth;
    private javax.swing.JComboBox<String> tfSearchID;
    private javax.swing.JComboBox<String> typeWeaner;
    // End of variables declaration//GEN-END:variables
}
