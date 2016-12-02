package entity.manager.dbservice;

import javax.persistence.EntityManager;

import entity.manager.models.Department;
import entity.manager.utils.EntityManagerUtil;

public class DepartmentDBService {

	public void addDepartment(Department dept) {
		EntityManager em = EntityManagerUtil.getEm();
		em.getTransaction().begin();
		em.persist(dept);
		em.getTransaction().commit();
		EntityManagerUtil.closeEm();
	}

	public Department getDeptById(int id) {

		EntityManager em = EntityManagerUtil.getEm();
		return em.find(Department.class, id);
	}

}
