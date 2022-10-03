package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.Customer;

@Repository
public class HibernateCustomerDao implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int countTotalRecords() {
		Session session = sessionFactory.getCurrentSession();
		final String sql="select count(*) totalRecords from customer";
		return (int) session.createNativeQuery(sql)
							.addScalar("totalRecords",IntegerType.INSTANCE)
							.getSingleResult();
	}
	@Override
	public List<Customer> getAll(int offset, int rowcount) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM customer LIMIT :offset, :rowcount", Customer.class)
				  .setParameter("offset", offset)
				  .setParameter("rowcount", rowcount)
			      .getResultList();
	}
	@Override
	public void save(Customer customer) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}
	@Override
	public Customer get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
		
	}
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("delete from customer where id=:id").setParameter("id", id).executeUpdate();
	}
	
//	@Override
//	public List<Customer> getAll(int offset, int rowcount, String sort) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.createNativeQuery("SELECT * FROM customer LIMIT :offset, :rowcount ", Customer.class)
//				  .setParameter("offset", offset)
//				  .setParameter("rowcount", rowcount)
//			      .getResultList();
//	}
}
