package entity.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager 
{
	public EntityManager getem()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = (EntityManager) emf.createEntityManager();
		return em;
		
	}
	

}
