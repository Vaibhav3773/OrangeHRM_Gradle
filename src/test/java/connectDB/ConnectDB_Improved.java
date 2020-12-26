package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB_Improved {
    
    // Connection objectmy
    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    /*public static String DB_URL = "jdbc:mysql://localhost:3306/orangehrm";
    // Constant for Database Username
    public static String DB_USER = "root";
    // Constant for Database Password
    public static String DB_PASSWORD = "root";*/

    public ArrayList<String> ConnectMySQLDatabase(String DB_URL,String DB_USER,String DB_PASSWORD) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
             {
        
    // String[][] arrayDBData = null;
        // Make the database connection
        String dbClass = "com.mysql.jdbc.Driver";
        //String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(dbClass);
        // Get connection to DB
        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        // Statement object to send the SQL statement to the Database
        stmt = con.createStatement();

        String query = "select uname,upass from login";
        // Get the contents of userinfo table from DB
        ResultSet res = stmt.executeQuery(query);
        // Print the result untill all the records are printed
        // res.next() returns true if there is any next record else returns
        // false
        
        ArrayList<String> sqlData = new ArrayList<String>();
        while (res.next()) {
            System.out.print("\t" + res.getString("uname"));
            System.out.println("\t" + res.getString("upass"));
            sqlData.add(res.getString("uname")+"~"+res.getString("upass"));
            //Adminadmin123
        }

        // Close DB connection
        if (con != null) {
            con.close();
        }
        return sqlData;
    }


}
