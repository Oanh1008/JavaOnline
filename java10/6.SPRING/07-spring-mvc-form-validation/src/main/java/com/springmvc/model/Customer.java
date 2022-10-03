  

package com.springmvc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.validation.StartsWith;

public class Customer {
	@NotNull(message = "*first name is required")
	@Size(min = 5, max = 10, message = "length is from 5 to 10")
	private String firstName;
	
	@NotNull(message = "*last name is required")
	@Size(min = 5, max = 10, message = "length is from 5 to 10")
	private String lastName;
	
	@NotNull(message = "*last name is required")
	@Min(value = 1,message = "min is one")
	@Max(value = 10,message = "max is 10")
	private int freePasses;
	
	@NotNull(message = "*last name is required")
	@Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 letter/digits")
	private String postalCode;
	
//	@NotNull(message = "courseCode is required")
	@StartsWith(prefix = "BKIT",message = "course code must start with BKIT")
	private String courseCode;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
