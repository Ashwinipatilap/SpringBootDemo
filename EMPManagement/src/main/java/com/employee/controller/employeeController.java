package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> allEmp = empserv.getAllEmployee();
		if(allEmp != null) {
			return ResponseEntity.ok().body(allEmp);
		}
		else {
			return ResponseEntity.status(404).body(null);
		}
	}
	
	@PutMapping("/updateEmployee/{empid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empid,@RequestBody Employee emp){
		Employee newemp = empserv.updateEmployee(empid, emp);
		 if(newemp != null) {
			return ResponseEntity.ok().body(newemp);
		 }else {
			 return ResponseEntity.status(404).body(null);
		 }
		
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id){
		String delete=empserv.deleteEmployee(id);
		if(delete !=null) {
			return ResponseEntity.ok().body(delete);
		 }else {
			 return ResponseEntity.status(404).body(null);
		 }
		
	}

}
