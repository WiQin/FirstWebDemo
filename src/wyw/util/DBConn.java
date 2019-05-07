package wyw.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName DBConn
 * @Description  数据库连接
 * @Author Wangyw
 */
public class DBConn {

    private Connection conn = null;

    private static DBConn instance = null;

    private String driver = "";
    private String url = "";
    private String userName = "";
    private String passWord = "";

    private static FileInputStream fis = null;
    private static Properties properties = null;

    public static DBConn getInstacne(){
        if(instance == null){
            instance = new DBConn();
        }
        return instance;
    }

    //连接数据库
    private DBConn(){
        try {
            properties = new Properties();
            fis = new FileInputStream("DbInfo.properties");
            properties.load(fis);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            conn = DriverManager.getConnection(url,userName,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void Close(Connection conn, Statement statement, ResultSet resuleSet){
        if(conn != null){
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(resuleSet != null){
            try {
                resuleSet.close();
                resuleSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
