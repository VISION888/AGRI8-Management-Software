package agri8.management.software;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;


public class MySQLConnect {
    Connection conn;
    
    public Connection getConnect() {
      
     try {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agri8_database", "root", "root");       //Creates a Connection);
        //JOptionPane.showMessageDialog(null, "Database successfully Connected", "ERROR", JOptionPane.DEFAULT_OPTION);
        return conn;
    }  catch (ClassNotFoundException | SQLException | HeadlessException e) {
                   
        JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
       
    }
     return conn;
    }
}
