package wyw.entity;

import java.util.Date;

/**
 * @ClassName Students
 * @Description
 * @Author Wangyw
 */
public class Students {
    private int id;
    private String name;
    private String pwd;
    private String sex;
    private String eamil;


    public Students() {
        super();
    }

    public Students(int id, String name, String pwd, String sex, String eamil) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
        this.eamil = eamil;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

}
