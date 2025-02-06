
import java.sql.*;

public class DBConnection {
    public static final DBConnection DBCONNECTION = new DBConnection();
    public static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb", "postgres", "tiger");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DBConnection() {
    }

    public static DBConnection createDBconnection() {
        return DBCONNECTION;
    }
}
