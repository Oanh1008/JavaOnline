package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}
	@Override
	public boolean signup(String email, String password) {
		System.out.println(isExisted(email)+" : service");
		if(isExisted(email) > 0 ) {
			System.out.println("Email is existed already...");
			return false;
		}
		return employeeDao.signup(email, password);
	}
	@Override
	public Employee signin(String email, String password) {
		
		return employeeDao.signin(email, password);
	}
	@Override
	public int isExisted(String email) {
		return employeeDao.countWhereEmailEqualIpEmail(email);
	}
}
