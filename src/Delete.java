import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aruns on 10/15/2016.
 */
@WebServlet(name = "Delete")
public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id  =  Integer.parseInt(request.getParameter("id"));
        StudentTransaction s = new StudentTransaction();
        int r =s.deleteById(id);
        if(r==1){
            request.setAttribute("deleteSuccess",r);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id  =  Integer.parseInt(request.getParameter("id"));
        StudentTransaction s = new StudentTransaction();
        int r =s.deleteById(id);
        if(r==1){
            request.setAttribute("deleteSuccess",r);
        }


    }
}
