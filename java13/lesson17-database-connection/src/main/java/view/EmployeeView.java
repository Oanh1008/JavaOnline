package view;

import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;

import persistence.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import utils.SqlUtils;

public class EmployeeView {
	private static EmployeeService employeeService;
	static {
		employeeService = new EmployeeServiceImpl();
	}
	public static void main(String[] args) {
		String email="poanh10022001@gmail.com";
		String pw= "windowsftfan";
		System.out.println("isSuscess: "+employeeService.signup(email, pw));
		
		System.out.println("encrypted: "+SqlUtils.md5Hex(pw)+"\n46a208654142b8f07a6e08288ad6fe0a+\n\n");
		
		System.out.println("===========================================================================================");
		System.out.println("====SignIn");
		
		Optional<Employee> optional=Optional.ofNullable(employeeService.signin(email, pw));
		if(optional.isPresent()) {
			System.out.println("Welcome to control panel");
			System.out.println(optional.get());
		}else {
			System.out.println("Wrong username or password");
		}
		
		
	}
}
