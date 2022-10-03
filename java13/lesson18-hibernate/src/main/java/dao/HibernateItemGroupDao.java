package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class HibernateItemGroupDao extends AbstractHibernateDao implements ItemGroupDao {

	// Option1: Using native query -> createNativeQuerry
	// private static final String Q_SELECT_ITEM_GROUP="SELECT * FROM LoaiHang";

	/*
	 * public List<ItemGroup> getAll() { // Auto Mapping // Require: ItemGroup is an
	 * Entity and mapping with correct LoaiHang NativeQuery<ItemGroup> nativeQuerry
	 * = openSession() .createNativeQuery(Q_SELECT_ITEM_GROUP, ItemGroup.class);
	 * return nativeQuerry.getResultList();
	 * 
	 * }
	 */

	private static final String Q_SELECT_ITEM_BY_GROUP = 
			"SELECT mh.MaLH 					"
			+ ItemGroupDto.ITEM_GROUP_ID + ",\n" 
			+ "lh.TenLH  						" + ItemGroupDto.ITEM_GROUP_NAME+ ",\n" + "GROUP_CONCAT(concat(mh.TenMH, ' - ', ctmh.MaKC, ' - ', ctmh.SoLuong)) " + ItemGroupDto.ITEMS
			+ ",\n" + "SUM(ctmh.SoLuong)  " + ItemGroupDto.TOTAL_OF_ITEMS + "\n" + "FROM chitietmathang ctmh\n"
			+ "JOIN mathang mh ON ctmh.MaMH = mh.MaMH\n" + "JOIN loaihang lh ON mh.MaLH = lh.MaLH\n"
			+ "GROUP BY lh.MaLH";
	// Option2: Java Persistence Query Language JPQL,HQL WHERE ig.id = :p_id ->
	// createQuery
//	private static final String Q_SELECT_ITEM_GROUP = "SELECT ig FROM ItemGroup ig  ";
//
//	public List<ItemGroup> getAll() {
//		// Auto Mapping
//		// Require: ItemGroup is an Entity and mapping with correct LoaiHang
//		Query<ItemGroup> query = openSession().createQuery(Q_SELECT_ITEM_GROUP, ItemGroup.class);
//		return query
//				// .setParameter("p_id", 4)
//				.setMaxResults(8).getResultList();
//
//	}

	// Option3:
	private static final String Q_SELECT_ITEM_GROUP = "SELECT ig FROM ItemGroup ig  ";

	public List<ItemGroup> getAll() {
		// Auto Mapping
		// Require: ItemGroup is an Entity and mapping with correct LoaiHang
		Query<ItemGroup> query = openSession().createNamedQuery(ItemGroup.Q_SELECT_ALL, ItemGroup.class);
		return query
				// .setParameter("p_id", 4)
				.setMaxResults(8).getResultList();

	}

	@Override
	public List<ItemGroupDto> getItemByItemGroup() {

		return openSession().createNativeQuery(Q_SELECT_ITEM_BY_GROUP)
				.addScalar(ItemGroupDto.ITEM_GROUP_ID, IntegerType.INSTANCE) // rs.getInt("igId")
				.addScalar(ItemGroupDto.ITEM_GROUP_NAME, StringType.INSTANCE)
				.addScalar(ItemGroupDto.ITEMS, StringType.INSTANCE)
				.addScalar(ItemGroupDto.TOTAL_OF_ITEMS, IntegerType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class)).getResultList();
	}

	@Override
	public void secondLevelCache() {
		Session session1 = openSession(); // gr1 gr2
		Session session2 = openSession();
		
		ItemGroup gr1= session1.get(ItemGroup.class, 1);
		System.out.println("->>>>>>>gr1: "+gr1);
		
		ItemGroup gr2= session1.get(ItemGroup.class, 2);
		System.out.println("->>>>>>>gr2: "+gr2);
		clearAllRegCache();
		ItemGroup gr11= session2.get(ItemGroup.class, 1); // 2nd
		System.out.println("->>>>>>>gr11: "+gr11);
	}

}
