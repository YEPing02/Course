package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection conn = null;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // �������ݿ���������
			String user = "root";
			String psw = ""; // XXXΪ�Լ������ݿ������
			String url = "jdbc:mysql://localhost:3306/databaseinscrit?useSSL=false&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, user, psw); // ��ȡ����
		} catch (Exception e) {
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return conn;
	}

}
