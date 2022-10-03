package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbConnection;
import connection.DbProvider;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {

	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private final Connection conn;

	public ItemGroupDaoImpl() {
		conn = DbConnection.getConnection();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> itgs = new ArrayList<>();
		String sql = "SELECT * FROM LOAIHANG";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				itgs.add(itemGroup);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return itgs;

	}

	@Override
	public ItemGroup getItemGroup(int id) {
		ItemGroup itgs = null;
		String sql = "SELECT * " + "FROM LOAIHANG lh " + "WHERE lh.MaLH = " + id;
		try {
			st = conn.createStatement();

			rs = st.executeQuery(sql);
			if (rs.next()) {
				itgs = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return itgs;
	}

	@Override
	public int save(ItemGroup itemGroup) {

		String sql = "INSERT INTO LOAIHANG(MaLH,TenLH) VALUES(?,?)";
		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, itemGroup.getId());
			pst.setString(2, itemGroup.getName());
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		return -1;
	}
	@Override
	public int[] save(List<ItemGroup> itemGroups) {
		
		
		String sql = "INSERT INTO LOAIHANG(MaLH,TenLH) VALUES(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			for(ItemGroup itemGroup:itemGroups) {
				pst.setInt(1, itemGroup.getId());
				pst.setString(2, itemGroup.getName());
				pst.addBatch();
			}
			return pst.executeBatch();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		return null;
	}

	@Override
	public int update(ItemGroup itemGroup) {

		String sql = "UPDATE LOAIHANG\n" + "SET TenLH= ?\n" + "WHERE MaLH= ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, itemGroup.getName());
			pst.setInt(2, itemGroup.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		return -1;
	}

	@Override
	public ItemGroup getItemGroup(String name) {
		ItemGroup itgs = null;
		String sql = "SELECT * " + "FROM LOAIHANG lh " + "WHERE lh.TenLH = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeQuery();
			rs = pst.getResultSet();

			if (rs.next()) {
				itgs = new ItemGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return itgs;
	}

	@Override
	public List<ItemGroupDto> getItemsByItemGroup() {
		List<ItemGroupDto> itemGroupDtos= new ArrayList<ItemGroupDto>();
		String sql = "SELECT mh.MaLH,\n" 
				+ "lh.TenLH,\n"
				+ "GROUP_CONCAT(concat(mh.TenMH, ' - ', ctmh.MaKC, ' - ', ctmh.SoLuong)) AS ThongTin,\n"
				+ "SUM(ctmh.SoLuong) AS TongSoLuong \n" 
				+ "FROM chitietmathang ctmh\n"
				+ "JOIN mathang mh ON ctmh.MaMH = mh.MaMH\n" 
				+ "JOIN loaihang lh ON mh.MaLH = lh.MaLH\n"
				+ "GROUP BY lh.MaLH";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				ItemGroupDto itemGroupDto= new ItemGroupDto(rs.getInt("MaLH"), rs.getString("TenLH"), rs.getString("ThongTin"), rs.getInt("TongSoLuong"));
				itemGroupDtos.add(itemGroupDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs,pst);
		}
		return itemGroupDtos;
	}
}
