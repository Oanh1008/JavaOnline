package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DbConnection;
import connection.DbProvider;
import persistence.Employee;
import persistence.Title;
import utils.SqlUtils;

public class EmployeeDaoImpl implements EmployeeDao{
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection conn;
	public EmployeeDaoImpl() {
		conn=DbConnection.getConnection();
	}
	
	private static final String EMPTY_STRING="";
	private static final Integer DEFAULT_NUMBER=1;
	private static final String Q_SIGN_UP=""
			+"INSERT INTO NhanVien(TenNV,Email,SDT,DiaChi,MatKhau,MaCV)\n "
			+ "VALUES(?,?,?,?,?,?)";
	private static final String Q_SIGN_IN=""
			+"SELECT nv.*,cv.TenCV \n"
			+ "FROM NHANVIEN nv \n"
			+ "JOIN CHUCVU cv on nv.MaCV = cv.MaCV \n"
			+ "WHERE email = ? and MatKhau = ?";
	private static final String Q_COUNT_EMAIL_WHERE_EQUAl_IPEMAIL=""
			+"SELECT count(*) as count\n"
			+ "FROM NhanVien \n"
			+ "WHERE email = ?";
	@Override
	public boolean signup(String email, String password) {
		
		try {
			pst=conn.prepareStatement(Q_SIGN_UP);
			pst.setString(1, EMPTY_STRING);
			pst.setString(2, email);
			pst.setString(3, EMPTY_STRING);
			pst.setString(4, EMPTY_STRING);
			pst.setString(5, SqlUtils.md5Hex(password));
			pst.setInt(6,DEFAULT_NUMBER );
			return pst.executeUpdate() >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(pst);
		}
		
		return false;
	}

	@Override
	public Employee signin(String email, String password) {
		Employee employee = null;
		try {
			pst=conn.prepareStatement(Q_SIGN_IN);
			pst.setString(1, email);
			pst.setString(2, SqlUtils.md5Hex(password));
			rs=pst.executeQuery();
			
			if(rs.next()) {
				employee = new Employee(rs.getInt("MaNV"), rs.getString("TenNV"), email, rs.getString("SDT"), rs.getString("DiaChi"),password,new Title(rs.getInt("MaCV"), rs.getString("TenCV")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs,pst);
		}
		return employee;
	}
	@Override
	public int countWhereEmailEqualIpEmail(String email) {

		try {
			pst = conn.prepareStatement(Q_COUNT_EMAIL_WHERE_EQUAl_IPEMAIL);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if(rs.next()) {
				return rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs,pst);
		}
		return 0;
	}

}
