import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aruns on 10/4/2016.
 */
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        UserTransaction u = new UserTransaction();

        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        // response.getWriter().println(username);

        Users un = u.selectUser(username);
        //response.getWriter().println(un.getUsername());
        //response.getWriter().println(un.getPassword());
        //response.getWriter().println(un.getRole());
        if(username.equalsIgnoreCase(un.getUsername())&& password.equalsIgnoreCase(un.getPassword())){

            request.getSession().setAttribute("user",un);
            StudentTransaction std= new StudentTransaction();
            List<Student> sList = std.displayAll();
            //response.getWriter().println(sList.get(1).getAddress());
            request.getSession().setAttribute("slist",sList);

            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
            rd.forward(request,response);
        }
        else{
            response.getWriter().println("Login Failed");
        }
        //response.getWriter().println(l.get(0));

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //response.getWriter().println(request.getAttribute("user.username"));
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }
}
