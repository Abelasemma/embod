import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by aruns on 10/4/2016.
 */
public class UserTransaction {
    private Connection con;
    public UserTransaction(){
        this.con= DbConnection.getConnection();
    }

    public void insert(Users u){
        try {
        PreparedStatement statement=con.prepareStatement("INSERT into users(username,password,role) VALUES(?,?,?)");
        statement.setString(1, u.getUsername());
        statement.setString(2,u.getPassword() );
        statement.setString(3,u.getRole());
        statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Users selectUser(String username){

        PreparedStatement st = null;
        ResultSet rs;
        Users u = new Users();
        try {

            st = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            st.setString(1,username);
            rs = st.executeQuery();
            while (rs.next()){

                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setRole(rs.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            return u;
        }

    }

}
