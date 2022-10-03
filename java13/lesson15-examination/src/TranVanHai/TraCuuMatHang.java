package TranVanHai;

import java.util.Scanner;

public class TraCuuMatHang {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhập mã mh: ");
		String mmh = sc.next();
		MatHang[] mh = getMatHang();
		for (MatHang m : mh) {
			if (m.getMaMH().equals(mmh)) {
				System.out.println(m);
				return;
			}
		}
		System.out.print("Nhập tên mh: ");
		String tmh=sc.next();
		for (MatHang m : mh) {
			if (m.getTenMH().equals(tmh)) {
				System.out.println(m);
				
			}
		}

	}

	public static MatHang[] getMatHang() {
		return new MatHang[] { new MatHang("1", "Bún đậu", "mẹt", 100, 1, null),
				new MatHang("2", "Co ca", "lon", 100, 1, null),
				new MatHang("3", "Bún thêm", "mẹt", 100, 1, null),
				new MatHang("4", "Dừa", "trái", 100, 1, null), };
	}
}
