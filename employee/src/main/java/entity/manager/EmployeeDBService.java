package entity.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeDBService {

	public Employee getempbyid(int eid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee emp = em.find(Employee.class, eid);

		return emp;
	}

	public void insertemp(Employee emp) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(emp);
		tx.commit();
		em.close();
		emf.close();

	}

	public void delete(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee emp = em.find(Employee.class, id);
		em.remove(emp);
		tx.commit();
		em.close();
		emf.close();

	}

	public void updateemp(Employee emp) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee employee = em.find(Employee.class, emp.getEid());
		employee.setEname(emp.getEname());
		employee.setEmailid(emp.getEmailid());
		employee.setEsalary(emp.getEsalary());
		em.merge(employee);
		tx.commit();
		em.close();
		emf.close();

	}

	public List<Employee> getallemp() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emf.createEntityManager();

		Query query = (Query) em.createNativeQuery("SELECT * FROM employee ORDER BY ESALARY", Employee.class);
		List<Employee> list = query.getResultList();
		return list;

		/*
		 * List<Employee> employees = new ArrayList<Employee>();
		 * PreparedStatement pstmt = null; ResultSet rs = null; try { pstmt =
		 * con.prepareStatement(SQLqry.SELECT_ALL_QUERY); rs =
		 * pstmt.executeQuery(); while (rs.next()) { Employee emp = new
		 * Employee(); emp.setEid(rs.getInt(1)); emp.setEname(rs.getString(2));
		 * emp.setEmailid(rs.getString(3)); emp.setEsalary(rs.getInt(4));
		 * employees.add(emp); } } catch (SQLException e) { e.printStackTrace();
		 * } finally { DButil.closeresource(null, pstmt, rs); } return
		 * employees; }
		 */
	}

	public Employee getempbyname(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNativeQuery("SELECT * FROM employee WHERE Name=?name", Employee.class)
				.setParameter("name", name);
		Employee emp = (Employee) query.getSingleResult();
		return emp;

	}

}
