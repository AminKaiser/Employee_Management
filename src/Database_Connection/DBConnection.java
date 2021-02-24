
package Database_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
     public static Connection DBConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "");
        

        if (con != null) {
            System.err.println("Connected!");
        }
        return con;
    
}
}
