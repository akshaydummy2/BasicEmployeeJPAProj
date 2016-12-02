package entity.manager.service;

import entity.manager.dbservice.DepartmentDBService;
import entity.manager.models.Department;

public class DepartmentService {

	public void addDepartment(Department dept) {
		DepartmentDBService deptdb = new DepartmentDBService();
		deptdb.addDepartment(dept);
	}

	public Department getDeptById(int id) {
		DepartmentDBService deptdb = new DepartmentDBService();
		return deptdb.getDeptById(id);
	}

}
