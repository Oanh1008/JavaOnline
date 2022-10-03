package TranVanHai;

import java.util.Date;

public class MatHang {
	private String MaMH;
	private String TenMH;
	private String DonViTinh;
	private double DonGia;
	private double SoLuong;
	private Date NgayNhap;
	public MatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatHang(String MaMH, String TenMH, String DonViTinh, double DonGia, double SoLuong, Date NgayNhap) {
		super();
		this.MaMH = MaMH;
		this.TenMH = TenMH;
		this.DonViTinh = DonViTinh;
		this.DonGia = DonGia;
		this.SoLuong = SoLuong;
		this.NgayNhap = NgayNhap;
	}
	public String getMaMH() {
		return MaMH;
	}
	public void setMaMH(String maMH) {
		MaMH = maMH;
	}
	public String getTenMH() {
		return TenMH;
	}
	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public double getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(double soLuong) {
		SoLuong = soLuong;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	@Override
	public String toString() {
		return "mathang1 [MaMH=" + MaMH + ", TenMH=" + TenMH + ", DonViTinh=" + DonViTinh + ", DonGia=" + DonGia
				+ ", SoLuong=" + SoLuong + ", NgayNhap=" + NgayNhap + "]";
	}
	public void HienThi() {
		System.out.printf("\n \t%s \t%s \t%s \t%f \t%f \t%f", MaMH, TenMH,DonViTinh, SoLuong, DonGia,SoLuong*DonGia);

	}
	
}
