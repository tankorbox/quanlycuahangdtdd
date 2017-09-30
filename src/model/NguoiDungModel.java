package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.NguoiDung;
import library.ConnectMySQDBLLibrary;

public class NguoiDungModel {
	private ConnectMySQDBLLibrary connectMySQDBLLibrary;
	private Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	public NguoiDungModel() {
		connectMySQDBLLibrary = new ConnectMySQDBLLibrary();
	}

	public ArrayList<NguoiDung> getAll() {
		conn = connectMySQDBLLibrary.getConnectMySQL();
		ArrayList<NguoiDung> listND = new ArrayList<>();
		String sql = "SELECT * FROM nguoidung";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				NguoiDung obj = new NguoiDung(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				System.out.println(obj.getTendangnhap());
				listND.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listND;
	}

	public NguoiDung getNguoiDungById(int id) {
		conn = connectMySQDBLLibrary.getConnectMySQL();
		NguoiDung obj = null;
		String sql = "SELECT * FROM nguoidung WHERE ID=" + id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				obj = new NguoiDung(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				System.out.println(obj.getTendangnhap());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public int addItem(NguoiDung obj) {
		// TODO Auto-generated method stub
		int result = 0;
		conn = connectMySQDBLLibrary.getConnectMySQL();
		String sql = "INSERT INTO " + "nguoidung" + " VALUES (null,?,?,?,?,?,?,?) ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.getTendangnhap());
			pst.setString(2, obj.getMatkhau());
			pst.setString(3, obj.getTendaydu());
			pst.setString(4, obj.getDiachi());
			pst.setString(5, obj.getSodienthoai());
			pst.setInt(6, obj.getId_role());
			pst.setInt(7, obj.getActive());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int delItem(int id) {
		// TODO Auto-generated method stub
		int result = 0;
		conn = connectMySQDBLLibrary.getConnectMySQL();
		String sql = "DELETE FROM " + "nguoidung" + " WHERE id =  ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result = 1;
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int editItem(NguoiDung obj) {
		int result = 0;
		conn = connectMySQDBLLibrary.getConnectMySQL();
		String query = "UPDATE dienthoai SET tendangnhap=?,matkhau=?,tendaydu=?,diachi=?,sodienthoai=?,id_role=?,active=? WHERE id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(query);


			pst.setString(1, obj.getTendangnhap());
			pst.setString(2, obj.getMatkhau());
			pst.setString(3, obj.getTendaydu());
			pst.setString(4, obj.getDiachi());
			pst.setString(5, obj.getSodienthoai());
			pst.setInt(6, obj.getId_role());
			pst.setInt(7, obj.getActive());
			pst.setInt(8,  obj.getId());
			result = pst.executeUpdate();
			System.out.println("da vao model" + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
