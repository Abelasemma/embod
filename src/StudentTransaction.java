import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aruns on 10/15/2016.
 */
public class StudentTransaction {
    private Connection con;
    public StudentTransaction(){
        this.con= DbConnection.getConnection();
    }

    public  int insert(Student s){
       int r =0;
        try {
            PreparedStatement statement=con.prepareStatement("INSERT into student(user_id,fname,lname,address,fathername,phoneno,grade) VALUES(?,?,?,?,?,?,?)");
            statement.setInt(1, s.getUser_id());
            statement.setString(2,s.getFname() );
            statement.setString(3,s.getLname() );
            statement.setString(4,s.getAddress());
            statement.setString(5,s.getFathername());
            statement.setInt(6,s.getPhoneno());
            statement.setString(7,s.getGrade());
            statement.executeUpdate();
            r=1;
        } catch (SQLException e) {
            //e.printStackTrace();
            return r;
        }
        return r;
    }
    public  int update(Student s,int id){
        int r =0;
        try {
            PreparedStatement statement=con.prepareStatement("UPDATE `student` SET `fname`=?,`lname`=?,`address`=?,`fathername`=?,`phoneno`=?,`grade`=? WHERE id =?");

            statement.setString(1,s.getFname() );
            statement.setString(2,s.getLname() );
            statement.setString(3,s.getAddress());
            statement.setString(4,s.getFathername());
            statement.setInt(5,s.getPhoneno());
            statement.setString(6,s.getGrade());
            statement.setInt(7,id);
            statement.executeUpdate();
            r=1;
        } catch (SQLException e) {
            //e.printStackTrace();
            return r;
        }
        return r;
    }
    public List<Student> displayAll(){

        List <Student> s =  new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("SELECT * FROM student INNER JOIN users ON student.user_id = users.id ");

            ResultSet rs = st.executeQuery();

            s=listGenerator(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    public List<Student> searchByName(String in){

        List <Student> su =  new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("SELECT * FROM student INNER JOIN users ON student.user_id = users.id  WHERE student.fname LIKE ?");
            st.setString(1,"%"+in+"%");
            ResultSet rs1 = st.executeQuery();
            //System.out.println(rs);
            su = listGenerator(rs1);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return su;
    }
    public List<Student> selectById(String id){
        List <Student> su =  new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("SELECT * FROM student INNER JOIN users ON student.user_id = users.id  WHERE student.id = ?");
            st.setInt(1,Integer.parseInt(id));
            ResultSet rs1 = st.executeQuery();
            //System.out.println(rs);
            su = listGenerator(rs1);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return su;
    }
    public List<Student> listGenerator(ResultSet rs1){
       List <Student> su = new ArrayList<>();
        try {
            while (rs1.next()) {
                Student  temp = new Student();
                //System.out.println(rs.getInt("id"));
                temp.setId(rs1.getInt(1));
                temp.setUser_id(rs1.getInt(2));
                temp.setFname(rs1.getString(3));
                temp.setLname(rs1.getString(4));
                temp.setAddress(rs1.getString(5));
                temp.setFathername(rs1.getString(6));
                temp.setPhoneno(rs1.getInt(7));
                temp.setGrade(rs1.getString(8));
                temp.getUser().setId(rs1.getInt(9));
                temp.getUser().setUsername(rs1.getString(10));
                temp.getUser().setPassword(rs1.getString(11));
                temp.getUser().setRole(rs1.getString(12));
                su.add(temp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  su;
    }
    public  int deleteById(int id){
        PreparedStatement st=null;
        int r =0;
        try {
            st = con.prepareStatement("DELETE FROM `student` WHERE id = ?");
            st.setInt(1,id);
            r = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

}
