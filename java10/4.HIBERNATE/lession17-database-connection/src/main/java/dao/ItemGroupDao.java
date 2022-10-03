package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.mysql.cj.conf.url.XDevApiDnsSrvConnectionUrl;
import com.mysql.cj.xdevapi.Statement;

import connection.Dbconnection;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import persistence.ItemGroupRawData;
import utils.SqlUtils;

public class ItemGroupDao {
	private Connection conn;
	private java.sql.Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ItemGroupDao() {
		conn = Dbconnection.getConnection();
	}
/*
 * get all ItemGroup
 */
	public List<ItemGroup> getAll() {
		List<ItemGroup> iGroups = new ArrayList<>();
		String sql = "select MaLoai, TenLoai " + " from loaihang";

		try {
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			// ResultSet List<T> T: columns alias
			// iterator row by row
			while (rs.next()) {
				ItemGroup ig = new ItemGroup(rs.getInt(1), rs.getString(2));
				iGroups.add(ig);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				SqlUtils.close(rs, st);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return iGroups;
	}

	public ItemGroup getItemGroups(int id) {
		ItemGroup result = null;
		String sql = "select MaLoai, TenLoai " + " from loaihang where MaLoai= ?" ;

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				SqlUtils.close(rs, st);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return result;
	}

	public List<ItemGroup> getItemGroups(String name) { 
		List<ItemGroup> iGroups = new ArrayList<>();
		String sql = "select MaLoai, TenLoai " + " from loaihang where TenLoai= ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup ig = new ItemGroup(rs.getInt(1), rs.getString(2));
				iGroups.add(ig);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				SqlUtils.close(rs, pst);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return iGroups;
	}
/*
 * insert a ItemGroup
 */
	public boolean save(ItemGroup itemGroup) {
		boolean isSaved = false;
		String sql = "insert into loaihang(MaLoai, TenLoai)\n" 
						+ " values(?, ?)";

		try {

			pst = conn.prepareStatement(sql);
			// gán giá trị var
			// set values
			pst.setInt(1, itemGroup.getId());
			pst.setString(2, itemGroup.getName());
			
			isSaved = pst.executeUpdate() > 0; // row count

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				SqlUtils.close(pst);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return isSaved;
	}
	// insert into LoaiHang , many columns
	public boolean addBatch(List<ItemGroup> itemGroups) {
		boolean isSaved = false;
		String sql = "insert into loaihang(MaLoai, TenLoai)\n" 
				+ " values(?, ?)";
		
		try {
			
			pst = conn.prepareStatement(sql);
			// gán giá trị var
			// set values
			for(ItemGroup itemGroup: itemGroups) {
				pst.setInt(1, itemGroup.getId());
				pst.setString(2, itemGroup.getName());
				pst.addBatch();
			}
			
			isSaved = Arrays.stream(pst.executeBatch()).sum()>0; // row count
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				SqlUtils.close(pst);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		return isSaved;
	}
	
	// 3
	public List<ItemGroupRawData> getItemGroups(){
		List<ItemGroupRawData> result = new ArrayList<>();
		String sql = 
				"with TMP_CTE  as(\n"
				+ "	select mh.MaMH,\n"
				+ "		   sum(kcmh.SoLuong) SoLuong,\n"
				+ "           mh.MaLoai\n"
				+ "    from mathang mh\n"
				+ "    join kichcomathang  kcmh\n"
				+ "		on mh.MaMH=kcmh.MaMH\n"
				+ "	group by mh.MaMH\n"
				+ ")\n"
				+ "select lh.MaLoai,\n"
				+ "	   lh.TenLoai,\n"
				+ "       group_concat(concat(mh.TenMH,'-',mh.SoLuong)separator',') DanhSachMatHang,\n"
				+ "       sum(mh.SoLuong) TongSoLuong\n"
				+ "from loaihang lh\n"
				+ "join mathang mh\n"
				+ "	on lh.MaLoai=mh.MaLoai\n"
				+ "group by lh.MaLoai";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroupRawData data = new ItemGroupRawData();
				data.setIgrId(rs.getInt("MaLoai"));
				data.setIgrName(rs.getString("TenLoai"));
				data.setItems(rs.getString("DanhSachMatHang"));
				data.setTotalOfItems(rs.getInt("TongSoLuong"));
				result.add(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				SqlUtils.close(rs, pst);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return result;
		
	}

}
