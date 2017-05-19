package shiro.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hunter on 2017/5/19.
 */
public class JDBCConnection {
    private static Connection con;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("--------------------请检查数据库驱动");
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/breeder";
        String username = "root";
        String pass = "root";
        try {
            con = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            System.out.println("---------------------数据库连接失败");
            e.printStackTrace();
        }
        return con;
    }
    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
