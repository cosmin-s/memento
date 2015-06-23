package home.cos.app.memento.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenceHelper {
	
	//as defined in the persistence.xml
	private static final String HMS_PERSISTENCE_UNIT = "memento";
	private static EntityManagerFactory emf;
	
	/**
	 * Gets the same entity manager factory for hms persistence unit at each call. Creates one if it doesn't exist. 
	 * @return An entity manager factory for the hms persistence unit
	 */
	public static EntityManagerFactory getEntityManagerFactory()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory(HMS_PERSISTENCE_UNIT);
		}
		return emf;
	}

}
