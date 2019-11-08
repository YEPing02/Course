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

			conn = DatabaseConnection.getCon(); // �������ݿ�����
			String sqlInset = "insert into databaseinscrit.vehicule(idv,modele,imm ) values(?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sqlInset); // ���׳��쳣

			stmt.setInt(1, v.getIdv()); // ����SQL����һ����������ֵ
			stmt.setString(2, v.getModele());// ����SQL���ڶ�����������ֵ
			stmt.setString(3, v.getImm()); // ����SQL����������������ֵ

			int i = stmt.executeUpdate(); // ִ�в������ݲ���������Ӱ�������
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
			try {
				conn.close(); // ��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public boolean saveCoureur(Addcoureur addc) { // �����ݿ��м�������
		boolean result = false;
		Connection conn = null;
		try {

			conn = DatabaseConnection.getCon(); // �������ݿ�����
			String sqlInset = "insert into databaseinscrit.coureur(idcou,Nomcou,Prenomcou,datenaissance,groupesang ) values(?, ?, ?, ?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqlInset); // ���׳��쳣

			stmt.setInt(1, addc.getIdcou()); // ����SQL����һ����������ֵ
			stmt.setString(2, addc.getNomcou());// ����SQL���ڶ�����������ֵ
			stmt.setString(3, addc.getPrenomcou()); // ����SQL����������������ֵ
			stmt.setString(4, addc.getDatenaissance()); // ����SQL�����ĸ���������ֵ
			stmt.setString(5, addc.getSang()); // ����SQL�����ĸ���������ֵ
			// stmt.setInt(6, addc.getIdv()); //����SQL�����ĸ���������ֵ

			int i = stmt.executeUpdate(); // ִ�в������ݲ���������Ӱ�������
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
			try {
				conn.close(); // ��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public ArrayList<Addcoureur> selectcourse() { // �����ݿ��в�ѯ��������
		ArrayList<Addcoureur> colist = new ArrayList<Addcoureur>();
		Connection conn = null;
		try {
			conn = DatabaseConnection.getCon();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from databaseinscrit.coureur");// ִ��SQL�����ؽ����
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
				conn.close(); // �ر�����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return colist; // ���ؽ��
	}

	public boolean updatecourse(Addcoureur addc) { // ����Ա���ı�Ÿ���Ա����������Ϣ
		boolean result = false;
		Connection conn = null;
		try {
			conn = DatabaseConnection.getCon();
			String sql = "update databaseinscrit.coureur set groupesang=? where idcou=?"; // update���
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, addc.getSang()); // ����SQL����һ��"?"�Ĳ���ֵ
			stmt.setInt(2, addc.getIdv()); // ����SQL���ڶ���"?"�Ĳ���ֵ
			int flag = stmt.executeUpdate(); // ִ���޸Ĳ���������Ӱ�������
			if (flag == 1) { // �޸ĳɹ�����true
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
