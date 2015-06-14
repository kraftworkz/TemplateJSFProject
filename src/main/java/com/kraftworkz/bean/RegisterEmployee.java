package com.kraftworkz.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.kraftworkz.domain.Employee;
import com.kraftworkz.service.EmployeeService;

/*
 * 
 * @author Engin
 * */

@ManagedBean
@SessionScoped
public class RegisterEmployee {

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private Employee employee = new Employee();

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String register() {
		// Calling Business Service
		employeeService.register(employee);
		// Add message
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage("The Employee "
						+ this.employee.getEmployeeName()
						+ " Is Registered Successfully"));
		return "";
	}
}
