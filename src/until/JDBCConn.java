package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConn {

	public static Connection getConn() {
		  String driver = "com.mysql.jdbc.Driver";        //jdbc连接mysql的驱动
		    String url = "jdbc:mysql://127.0.0.1:3306/sifei"; //数据库连接的url和数据库名称
		    String username = "root";						//数据库用户名
		    String password = "root";						//数据库密码
		    Connection conn = null;
		    try {
		        Class.forName(driver); //classLoader,加载对应驱动
		        conn = (Connection) DriverManager.getConnection(url, username, password);
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return conn;
		    }
	}

