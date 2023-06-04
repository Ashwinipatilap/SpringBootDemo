package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.IemployeeService;

@RestController
@RequestMapping("/employee")
public class employeeController {
	
	@Autowired
	IemployeeService empserv;
	
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		 Employee emp = empserv.addEmployee(employee);
		 if(emp != null)
		 {
			 return ResponseEntity.ok().body(emp);
		 }else {
			 return ResponseEntity.status(404).body(null);
		 }
		
	}

}
