package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.Dbconnection;
import persistence.ItemGroup;
import utils.SqlUtils;

public class ItemGroupDao {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	public ItemGroupDao() {
		conn=Dbconnection.getConnection();
	}
	public List<ItemGroup> getAll() {
		List<ItemGroup> igrs = new ArrayList<>();
		String sql = "select Maloai,\n" + "		TenLoai, \n" + "		concat(MaLoai,TenLoai) as MaTenLoai \n"
				+ " from loaihang";
		
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);

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
				SqlUtils.close(st,rs);
			} catch (Exception e2) {
			}
		}
		return igrs;
	}
	public ItemGroup getItemGroup(int id) {
		ItemGroup igrs = null;
		String sql = 	"select * \n" 
						+ "from loaihang\n"
						+"where MALOAI = ?";
		
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				igrs= new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				SqlUtils.close(st,rs);
			} catch (Exception e2) {
			}
		}
		return igrs;
	}
	public List<ItemGroup> getItemGroup(String name) {
		List<ItemGroup> igrs = new ArrayList<>();
		String sql = 	"select * \n" 
				+ "from loaihang\n"
				+"where tenloai = ?";
		
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup igr = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				igrs.add(igr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			SqlUtils.close(st, rs);
		}
		return igrs;
	}
	
	public boolean save(ItemGroup itemGroup) {
		boolean rs=false;
		String sql="insert into loaihang (maloai,tenloai)\n"
					+"values(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			// gan gia tri
			pst.setInt(1, itemGroup.getId());
			pst.setString(2, itemGroup.getName());
			rs=pst.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			SqlUtils.close(st);
		}
		return rs;
		
	}
	
}
