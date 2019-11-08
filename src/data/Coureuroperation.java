package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Coureuroperation {

	private static Coureuroperation instance = new Coureuroperation();

	public static Coureuroperation getInstance() {
		return instance;
	}

	private Coureuroperation() {
	}

	public boolean savevehicule(vehicule v) {
		boolean result = false;
		Connection conn = null;
		try {

			conn = DatabaseConnection.getCon(); // 建立数据库连接
			String sqlInset = "insert into databaseinscrit.vehicule(idv,modele,imm ) values(?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sqlInset); // 会抛出异常

			stmt.setInt(1, v.getIdv()); // 设置SQL语句第一个“？”的值
			stmt.setString(2, v.getModele());// 设置SQL语句第二个“？”的值
			stmt.setString(3, v.getImm()); // 设置SQL语句第三个“？”的值

			int i = stmt.executeUpdate(); // 执行插入数据操作，返回影响的行数
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
			try {
				conn.close(); // 打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public boolean saveCoureur(Addcoureur addc) { // 向数据库中加入数据
		boolean result = false;
		Connection conn = null;
		try {

			conn = DatabaseConnection.getCon(); // 建立数据库连接
			String sqlInset = "insert into databaseinscrit.coureur(idcou,Nomcou,Prenomcou,datenaissance,groupesang ) values(?, ?, ?, ?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqlInset); // 会抛出异常

			stmt.setInt(1, addc.getIdcou()); // 设置SQL语句第一个“？”的值
			stmt.setString(2, addc.getNomcou());// 设置SQL语句第二个“？”的值
			stmt.setString(3, addc.getPrenomcou()); // 设置SQL语句第三个“？”的值
			stmt.setString(4, addc.getDatenaissance()); // 设置SQL语句第四个“？”的值
			stmt.setString(5, addc.getSang()); // 设置SQL语句第四个“？”的值
			// stmt.setInt(6, addc.getIdv()); //设置SQL语句第四个“？”的值

			int i = stmt.executeUpdate(); // 执行插入数据操作，返回影响的行数
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
			try {
				conn.close(); // 打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public ArrayList<Addcoureur> selectcourse() { // 从数据库中查询所需数据
		ArrayList<Addcoureur> colist = new ArrayList<Addcoureur>();
		Connection conn = null;
		try {
			conn = DatabaseConnection.getCon();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from databaseinscrit.coureur");// 执行SQL并返回结果集
			while (rs.next()) {
				Addcoureur addc = new Addcoureur();
				addc.setIdcou(rs.getInt("idcou"));
				addc.setNomcou(rs.getString("nomcou"));
				addc.setPrenomcou(rs.getString("prenomcou"));
				addc.setDatenaissance(rs.getString("datenaissance"));
				addc.setSang(rs.getString("groupesang"));
				// addc.setIdv(rs.getInt("idv"));
				colist.add(addc);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return colist; // 返回结果
	}

	public boolean updatecourse(Addcoureur addc) { // 根据员工的编号更改员工的年龄信息
		boolean result = false;
		Connection conn = null;
		try {
			conn = DatabaseConnection.getCon();
			String sql = "update databaseinscrit.coureur set groupesang=? where idcou=?"; // update语句
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, addc.getSang()); // 设置SQL语句第一个"?"的参数值
			stmt.setInt(2, addc.getIdv()); // 设置SQL语句第二个"?"的参数值
			int flag = stmt.executeUpdate(); // 执行修改操作，返回影响的行数
			if (flag == 1) { // 修改成功返回true
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean deletecoureurById(Addcoureur addc) {
		boolean result = false;
		Connection conn = null;
		try {
			conn = DatabaseConnection.getCon();
			String sql = "delete from databaseinscrit.coureur where idcou = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, addc.getIdcou());
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean deletevehiculeById(vehicule v) {
		boolean result = false;
		Connection conn = null;
		try {
			conn = DatabaseConnection.getCon();
			String sql = "delete from databaseinscrit.vehicule where idv = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getIdv());
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
