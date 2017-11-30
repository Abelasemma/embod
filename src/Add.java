import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aruns on 10/15/2016.
 */
@WebServlet(name = "Add")
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student newStudent = new Student();
        Users newUser = new Users();
        UserTransaction u = new UserTransaction();
        newUser.setUsername(request.getParameter("uname"));
        newUser.setPassword(request.getParameter("pass"));
        newUser.setRole(request.getParameter("role"));
        u.insert(newUser);

        newStudent.setUser_id(u.selectUser(newUser.getUsername()).getId());
        newStudent.setFname(request.getParameter("fname"));
        newStudent.setLname(request.getParameter("lname"));
        newStudent.setAddress(request.getParameter("address"));
        newStudent.setFathername(request.getParameter("father_name"));
        newStudent.setPhoneno(Integer.parseInt(request.getParameter("phone")));
        newStudent.setGrade(request.getParameter("grade"));
        StudentTransaction st = new StudentTransaction();
        int c=st.insert(newStudent);
        request.setAttribute("dataSuccess",c);
        RequestDispatcher rd = request.getRequestDispatcher("/display");

        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher  rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }
}
