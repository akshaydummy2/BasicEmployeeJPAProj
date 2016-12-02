package entity.manager.service;

import java.util.ArrayList;
import java.util.List;

import entity.manager.dbservice.EmployeeDBService;
import entity.manager.models.*;

public class EmployeeService {

	public int addEmployee(Employee emp) {
		EmployeeDBService empdb = new EmployeeDBService();
		return empdb.addEmployee(emp);
	}

	public void deleteEmployee(int id) {
		EmployeeDBService empdb = new EmployeeDBService();
		Employee emp = empdb.getEmpById(id);
		empdb.deleteEmployee(emp);
	}

	public List<Employee> getAllEmp() {
		EmployeeDBService empdb = new EmployeeDBService();
		List<Employee> emps = new ArrayList<Employee>();
		emps = empdb.getAllEmp();
		return emps;
	}

	public Employee getEmpById(int id) {
		EmployeeDBService empdb = new EmployeeDBService();
		Employee emp = empdb.getEmpById(id);
		return emp;
	}

	public List<Employee> searchEmpsByName(String name) {
		EmployeeDBService empdb = new EmployeeDBService();
		List<Employee> emps = empdb.searchEmpsByName(name);
		return emps;
	}

	public void updateEmp(Employee emp) {
		EmployeeDBService empdb = new EmployeeDBService();
		empdb.updateEmp(emp);
	}

}
