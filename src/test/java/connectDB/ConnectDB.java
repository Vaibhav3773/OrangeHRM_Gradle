package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Statement;

public class ConnectDB {
    @Test
    public void  ConnectSQLDB() throws  ClassNotFoundException, SQLException {                                                  
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"        
        String dbUrl = "jdbc:mysql://localhost:3306/orangehrm";                 
        //Database Username     
        String username = "root";   
        //Database Password     
        String password = "root";               
        //Query to Execute      
        String query = "select * from login;";  
        //Load mysql jdbc driver        
        Class.forName("com.mysql.jdbc.Driver");         
        //Create Connection to DB       
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        //Create Statement Object       
       Statement stmt = (Statement) con.createStatement();                  
            // Execute the SQL Query. Store results in ResultSet        
        ResultSet rs= ((java.sql.Statement) stmt).executeQuery(query);                         
 
        // While Loop to iterate through all data and print results     
        while (rs.next()){
                    String Username = rs.getString(1);                                      
                    String Password = rs.getString(2);                                                 
                    System. out.println(Username+"  "+Password);
                    
            }       
             // closing DB Connection       
            con.close();            
}
}
