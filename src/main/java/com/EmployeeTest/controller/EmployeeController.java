package com.EmployeeTest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeTest.Entity.Employee;
import com.EmployeeTest.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee emp) {

		Employee saveEmployee = employeeRepo.save(emp);

		return "Employee  successfully"; // test
	}

	@GetMapping("/getAll")

	public List<Employee> getAllEmployee() {

		List<Employee> getAllEmployee = employeeRepo.findAll();

		return getAllEmployee;

	}

	@PutMapping("/update")

	public String updateEmployee(@PathVariable long id) {

		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isPresent()) {

			employeeRepo.save(optional.get());
		}

		return "Employee updated  ";
	}

	@DeleteMapping("/delete")

	public String deleteEmployee(@RequestParam long id) {

		employeeRepo.deleteById(id);

		return " Employee deleted successfully";
	}

}
