package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import persistence.Item;

public class HibernateItemDao extends AbstractHibernateDao implements ItemDao {
	private static final String Q_GET_ALL_ITEM = "SELECT * FROM MatHang";
	//private static final String Q_GET_ITEM_BY_ID="SELECT * FROM MatHang WHERE MaMH= :p_id";
	private static final String Q_GET_ITEM_BY_ID="SELECT it FROM Item it WHERE it.id= :p_id";
	@Override
	public List<Item> getAll() {
		return openSession().createNativeQuery(Q_GET_ALL_ITEM,Item.class).getResultList();
	}
	
	@Override
	public Optional<Item> get(int id) {
		// using getSingleResult -> throw EntityNotFound
		// try catch
		//-> uniquResult
		return Optional.ofNullable(openSession()
				.createQuery(Q_GET_ITEM_BY_ID, Item.class)
				.setParameter("p_id", id).uniqueResult()) 
				;
	}
	@Override
	public Optional<Item> find(int id) {
		return Optional.ofNullable(openSession().get(Item.class, id));
		
		
	}
	
	@Override
	public void firstLevelCache() {
		
		// Store in session scope
		Session session = openSession();
		
		Item item1= session.get(Item.class, 1);
		System.out.println("item1: "+item1);
		
		Item item2= session.get(Item.class, 2);
		System.out.println("item2: "+item2);
		// session.clear(); // clear all loaded instance in session's cache
		session.evict(item2); // clear item2 in session's cache
		Item item11=session.get(Item.class, 1);
		System.out.println("item1: "+item11);
		
		Item item22= session.get(Item.class, 2);
		System.out.println("item2: "+item22);
	}
}
