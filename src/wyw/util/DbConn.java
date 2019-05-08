package wyw.util;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName DbConn
 * @Description
 * @Author Wangyw
 */
public class DbConn {
    private Connection connection = null;//企业级开发中，connection不要用static修饰，在哪用就在哪初始化

    private static DbConn instance = null;

    private String driver = "";
    private String url = "";
    private String userName = "";
    private String passWord = "";

    private static FileInputStream fis = null;
    private static Properties properties = null;

    public static DbConn getInstance(){
        if(instance == null){
            instance = new DbConn();
        }
        return instance;
    }

    //只连接一次，放入构造器中,单例模式
    private DbConn(){
        try {

            properties = new Properties();
            /*fis = new FileInputStream("DbInfo.properties");
            properties.load(fis);*/
            properties.load(DbConn.class.getResourceAsStream("/DbInfo.properties"));

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");

            //加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {//connection:晚开早关
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
