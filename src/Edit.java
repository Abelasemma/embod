import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aruns on 10/15/2016.
 */
@WebServlet(name = "Edit")
public class Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =  Integer.parseInt(request.getParameter("id"));
        Student newStudent = new Student();
        newStudent.setFname(request.getParameter("fname"));
        newStudent.setLname(request.getParameter("lname"));
        newStudent.setAddress(request.getParameter("address"));
        newStudent.setFathername(request.getParameter("father_name"));
        newStudent.setPhoneno(Integer.parseInt(request.getParameter("phone")));
        newStudent.setGrade(request.getParameter("grade"));
        StudentTransaction st = new StudentTransaction();
        int c=st.update(newStudent,id);
        request.setAttribute("dataSuccess",c);
        RequestDispatcher rd = request.getRequestDispatcher("/display");

        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        StudentTransaction st = new StudentTransaction();
        List<Student> li = st.selectById(id);
        request.setAttribute("edit", li);
        RequestDispatcher rd = request.getRequestDispatcher("/edit.jsp");
        rd.forward(request, response);
    }
}
