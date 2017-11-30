import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by aruns on 10/15/2016.
 */
@WebServlet(name = "Display")
public class Display extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentTransaction std= new StudentTransaction();
        List<Student> sList = std.displayAll();
        //response.getWriter().println(sList.get(1).getAddress());
        request.setAttribute("slist",sList);
        RequestDispatcher rda = request.getRequestDispatcher("/home.jsp");
        rda.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rda = request.getRequestDispatcher("/home.jsp");
        rda.forward(request,response);
    }
}
