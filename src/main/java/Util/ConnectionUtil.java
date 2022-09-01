package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection conn;
    public static Connection getConnection() throws SQLException {
        if(conn == null){
            try{
                String url = "jdbc:sqlserver://localhost:1433;TrustServerCertificate=True";
                String username = "sa";
                String password = "P@SSWORD123";
                conn = DriverManager.getConnection(url, username, password);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        conn.setAutoCommit(false);
        return conn;
    }
}
