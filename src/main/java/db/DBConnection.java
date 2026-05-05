package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null) {
                System.out.println("✅ Database connected successfully");
                return con;
            } else {
                throw new RuntimeException("❌ Connection returned null");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("❌ MySQL JDBC Driver not found.", e);
        } catch (SQLException e) {
            throw new RuntimeException("❌ Database connection failed.", e);
        }
    }
}