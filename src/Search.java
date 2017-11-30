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
@WebServlet(name = "Search")
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String in  =  request.getParameter("q");
        StudentTransaction st =  new StudentTransaction();
        List<Student> students = st.searchByName(in);
        request.setAttribute("slist",students);
        request.setAttribute("query",in);
        request.setAttribute("size",students.size());
        RequestDispatcher rda = request.getRequestDispatcher("/search.jsp");
        rda.forward(request,response);
    }
}
