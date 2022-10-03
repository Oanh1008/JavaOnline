package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.DbConnection;

public class ItemDetailDaoImpl implements ItemDetailDao {
	private Connection conn;
	private PreparedStatement pst;

	public ItemDetailDaoImpl() {
		conn = DbConnection.getConnection();
	}

	@Override
	public boolean doTransfer() {
		int rs1 = -1;
		int rs2 = -1;
		String sql = "UPDATE ChiTietMatHang\n" + "SET SoLuong=?\n" + "WHERE MaMH=?\n" + "AND MaKC=?";
		try {
			conn.setAutoCommit(false);

			pst = conn.prepareStatement(sql);
			pst.setInt(1, 50);
			pst.setInt(2, 1);
			pst.setString(3, "L");
			rs1 = pst.executeUpdate();

			pst = conn.prepareStatement(sql);
			pst.setInt(1, 80);
			pst.setInt(2, Integer.parseInt("221dd"));
			pst.setString(3, "M");
			rs2 = pst.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return rs1 > 0 && rs2 > 0;
	}

}
