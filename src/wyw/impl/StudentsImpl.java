package wyw.impl;

import wyw.dao.StudentsDao;
import wyw.entity.Students;
import wyw.util.DbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentsImpl
 * @Description
 * @Author Wangyw
 */
public class StudentsImpl implements StudentsDao {
    private DbConn dbConn;
    private Connection connection = null;
    private PreparedStatement statement = null;

    public StudentsImpl() {
        super();
    }

    public StudentsImpl(DbConn dbConn) {
        this.dbConn = dbConn;
    }

    @Override
    public boolean login(String name, String pwd) {

        boolean flag = false;

        try {
            connection = dbConn.getConnection();
            String sql = "select username,password from wyw_students where username = '"+ name +"'";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                if(resultSet.getString("username").equals(name) && resultSet.getString("password").equals(pwd)){
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean register(Students students) {

        boolean flag = false;

        try {
            connection = dbConn.getConnection();

            boolean login = login(students.getName(), students.getPwd());

            if (login == false) {
                statement = connection.prepareStatement("insert into wyw_students (username,password) values (?,?)");
                statement.setString(1, students.getName());
                statement.setString(2, students.getPwd());
                statement.executeUpdate();
                connection.commit();
                System.out.println("注册成功");

                flag = true;

            } else {
                System.out.println("该用户名已存在，请重新输入");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.close(connection,statement,null);
        }
        return flag;
    }

    @Override
    public List<Students> getAllStudents() {
        List<Students> list = new ArrayList<Students>();
        return list;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, String name, String pwd, String sex, String eamil) {
        return false;
    }
}
