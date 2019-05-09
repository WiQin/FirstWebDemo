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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");

        Students students = new Students();
        students.setName(name);
        students.setPwd(pwd);
        students.setSex(sex);
        students.setEmail(email);

        StudentsDao studentsDao = new StudentsImpl(DbConn.getInstance());

        if(studentsDao.register(students)){

            request.setAttribute("name", name);  //向request域中放置参数
            request.setAttribute("pwd", pwd);  //向request域中放置参数
            request.setAttribute("sex", sex);  //向request域中放置参数
            request.setAttribute("email", email);  //向request域中放置参数
            request.setAttribute("message", "注册成功");
            request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面

        }else{
            response.sendRedirect("index.jsp");
        }

    }
}
