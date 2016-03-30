/**
 * 
 */
package es.upm.dit.isst.tfg.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Clara
 *
 */
public class EMFService {
	
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	/**
	 * 
	 */
	private EMFService() {
		// TODO Auto-generated constructor stub
	}	
	
	public static EntityManagerFactory get() {
		return emfInstance;
	}


}
