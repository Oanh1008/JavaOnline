package view;

import connection.HibernateProvider;
import dao.AbstractHibernateDao;

public class DemoApp  {
	public static void main(String[] args) {
		System.out.println(HibernateProvider.getSessionFactory());
		
//		System.out.println("Option1: OpenSession");
//		AbstractHibernateDao dao= new AbstractHibernateDao();
//		System.out.println("S1: "+dao.openSession());
//		System.out.println("S2: "+dao.openSession());
//		
//		System.out.println("Option2: getCurrentSession");
//		System.out.println(dao.getCurrentSession());
//		System.out.println(dao.getCurrentSession());
	}
}
