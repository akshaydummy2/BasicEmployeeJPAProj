package entity.manager.dbservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.manager.models.Employee;
import entity.manager.utils.EntityManagerUtil;

public class EmployeeDBService {

	public Employee getEmpById(int eid) {

		EntityManager em = EntityManagerUtil.getEm();
		Employee emp = em.find(Employee.class, eid);
		return emp;
	}

	public int addEmployee(Employee emp) {
		EntityManager em = EntityManagerUtil.getEm();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		EntityManagerUtil.closeEm();
		return emp.getId();
	}

	public void deleteEmployee(Employee emp) {

		EntityManager em = EntityManagerUtil.getEm();
		em.getTransaction().begin();
		em.remove(emp);
		em.getTransaction().commit();
		EntityManagerUtil.closeEm();

	}

	public void updateEmp(Employee emp) {

		EntityManager em = EntityManagerUtil.getEm();
		em.getTransaction().begin();
		em.merge(emp);
		em.getTransaction().commit();
		EntityManagerUtil.closeEm();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmp() {
		EntityManager em = EntityManagerUtil.getEm();
		Query query = (Query) em.createNativeQuery("SELECT * FROM employee e ORDER BY e.salary", Employee.class);
		List<Employee> list = query.getResultList();
		EntityManagerUtil.closeEm();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> searchEmpsByName(String name) {
		EntityManager em = EntityManagerUtil.getEm();
		Query query = em.createQuery("SELECT e FROM Employee e WHERE e.name LIKE :name OR e.email LIKE :name")
				.setParameter("name", "%" + name + "%");
		List<Employee> emps = (List<Employee>) query.getResultList();
		EntityManagerUtil.closeEm();
		return emps;
	}

}
