package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class Dao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAService");
	static EntityManager em = emf.createEntityManager();

	public void readFunction() {
		
		em.getTransaction().begin();
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("hello");

		storedProcedure.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);

		storedProcedure.execute();

		Double tax = (Double) storedProcedure.getOutputParameterValue("tax");
		System.out.println("Tax is: " + tax);
		em.getTransaction().commit();
		em.close();
		
	}

}
