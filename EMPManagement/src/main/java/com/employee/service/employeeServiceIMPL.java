package com.employee.service;

import java.util.List;

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

}
