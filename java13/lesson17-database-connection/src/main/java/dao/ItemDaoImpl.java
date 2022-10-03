package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbConnection;
import persistence.Item;
import persistence.ItemGroup;
import utils.SqlUtils;

public class ItemDaoImpl  implements ItemDao{
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private final Connection conn;

	public ItemDaoImpl() {
		conn = DbConnection.getConnection();
	}
	@Override
	public List<Item> findItemsByItemGroupName(String name) {
		List<Item> items= new ArrayList<>();
		String sql="SELECT mh.*,lh.TenLH \n"
				+ "FROM MatHang mh\n"
				+ "JOIN LoaiHang lh\n"
				+ "ON mh.MaLH=lh.MaLH\n"
				+ "WHERE lh.TenLH=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			System.out.println(sql);
			while(rs.next()) {
				ItemGroup itemGroup= new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				Item item= new Item(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getString("MauSac"),itemGroup);
				items.add(item);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			SqlUtils.close(rs,pst);
		}
		return items;
	}
}
