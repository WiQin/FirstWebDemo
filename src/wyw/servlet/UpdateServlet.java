package wyw.servlet;

import wyw.dao.StudentsDao;
import wyw.impl.StudentsImpl;
import wyw.util.DbConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");


        System.out.println("------------------------------------"+userId);

        StudentsDao stu = new StudentsImpl(DbConn.getInstance());

        if(stu.update(userId,name,pwd,sex,email)){
            request.setAttribute("xiaoxi", "更新成功");
            request.getRequestDispatcher("/CheckServlet").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }


    }
}
