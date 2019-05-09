package wyw.servlet;

import wyw.dao.StudentsDao;
import wyw.entity.Students;
import wyw.impl.StudentsImpl;
import wyw.util.DbConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentsDao stu = new StudentsImpl(DbConn.getInstance());
        List<Students> allStudents = stu.getAllStudents();
        request.setAttribute("allStudents",allStudents);
        request.getRequestDispatcher("/check.jsp").forward(request, response);

    }
}
