package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection conn = null;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 加载数据库连接驱动
			String user = "root";
			String psw = ""; // XXX为自己的数据库的密码
			String url = "jdbc:mysql://localhost:3306/databaseinscrit?useSSL=false&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, user, psw); // 获取连接
		} catch (Exception e) {
			System.out.println("连接数据库失败");
			e.printStackTrace();
		}
		return conn;
	}

}
