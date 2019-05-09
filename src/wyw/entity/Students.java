package wyw.entity;

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
    private String email;


    public Students() {
        super();
    }

    public Students(int id, String name, String pwd, String sex, String email) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
        this.email = email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
