package com.employeemanagement.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.employeemanagement.app.model.Employee;
import com.employeemanagement.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public List<Employee> getAllEmployeeSortedByFirstName(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

	@Override
		public Employee getEmployeeById(Integer employeeId) {
			Optional<Employee> employeOptional = employeeRepository.findById(employeeId);
		
		if(employeOptional.isPresent()) {
			return employeOptional.get();
		}
		return null;
		
		}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		List<Employee> listOfEmployeeByFirstName = employeeRepository.findEmployeeByFirstName(firstName);
		return listOfEmployeeByFirstName;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	@Override
	public Employee editEmployeeById(Integer employeeId, Employee employee) {
		Employee employeeFromDB = getEmployeeById(employeeId);
		employeeFromDB.setFirstName( employee.getFirstName() );
		employeeFromDB.setLastName( employee.getLastName() );
		employeeFromDB.setEmail( employee.getEmail() );
		return saveEmployee(employeeFromDB);
	}

}
