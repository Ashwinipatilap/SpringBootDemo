package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class employeeServiceIMPL implements IemployeeService {
    @Autowired
	EmployeeRepository emprepo;
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return emprepo.save(employee);
	}
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}
	@Override
	public Employee updateEmployee(int empid, Employee emp) {
		// TODO Auto-generated method stub
		
		Employee newEmp = emprepo.findById(empid);
		newEmp.setFirstName(emp.getFirstName());
		newEmp.setLastName(emp.getLastName());
		newEmp.setEmailId(emp.getEmailId());
		return emprepo.save(newEmp);
	}
	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method 
Employee emp = emprepo.findById(id);
emprepo.delete(emp);
return "employee deleted";
		
	}

}
