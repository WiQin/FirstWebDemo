package wyw.servlet;

import wyw.dao.StudentsDao;
import wyw.impl.StudentsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        StudentsDao students = new StudentsImpl();
        if(students.login(name,pwd)){
            request.setAttribute("xiaoxi","欢迎您："+name);
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        }else{
            response.sendRedirect("index.jsp");
        }

    }
}
