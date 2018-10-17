import java.sql.*;

public class Database {
    static Connection conn = null;
    static Statement stmt = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Bank", "root", "");
            stmt = conn.createStatement();
        } catch(Exception E) {
            System.out.println(E.toString());
        }
    }
}
