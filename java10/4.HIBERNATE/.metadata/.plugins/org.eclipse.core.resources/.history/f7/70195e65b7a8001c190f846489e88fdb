package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.Dbconnection;
import persistence.ItemGroup;
import utils.SqlUtils;

public class ItemGroupDao {
	public List<ItemGroup> getAll() {
		List<ItemGroup> igrs = new ArrayList<>();
		String sql = "select Maloai,\n" + "		TenLoai, \n" + "		concat(MaLoai,TenLoai) as MaTenLoai \n"
				+ " from loaihang";
		Connection cnn = Dbconnection.getConnection();
		Statement st=null;
		ResultSet rs=null;
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql);

			// ResultSet =List<T> >> T: columns alias

			// iterator
			while (rs.next()) {
				ItemGroup igr = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				igrs.add(igr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				SqlUtils.close(st,rs,cnn);
			} catch (Exception e2) {
			}
		}
		return igrs;
	}
	
}
