import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aruns on 10/4/2016.
 */
public class DbConnection {

    public static Connection getConnection() {
        String DATABASE_URL = "jdbc:mysql://localhost:3306/sims";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {

            con = DriverManager.getConnection(DATABASE_URL, "root", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  con;
    }
}
