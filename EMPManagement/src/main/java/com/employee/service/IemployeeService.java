package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface IemployeeService {
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(int empid,Employee emp);
	public String deleteEmployee(int id);
}
