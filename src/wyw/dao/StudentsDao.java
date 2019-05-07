package wyw.dao;

import wyw.entity.Students;

import java.util.List;

public interface StudentsDao {
    public boolean login(String name,String pwd);
    public boolean register(Students students);
    public List<Students> getAllStudents();
    public boolean delete(int id);
    public boolean update(int id,String name,String pwd,String sex,String eamil,String dob);

}
