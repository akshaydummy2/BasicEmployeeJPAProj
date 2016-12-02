package entity.manager.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManager entityManager;

	public static EntityManager getEm() {
		if (entityManager == null || !entityManager.isOpen()) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public static void closeEm() {
		if (entityManager != null || entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
