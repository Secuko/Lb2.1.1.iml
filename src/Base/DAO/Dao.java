package Base.DAO;
import java.sql.*;

import java.sql.Connection;

public class Dao {
    public static Connection getConn() throws SQLException {
        String pass = "pass";
        String user = "root";
        String url = "jdbc:mysql://localhost/rps";
        return DriverManager.getConnection(url,user,pass);
    }

    public static void initConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
        }
    }
}
