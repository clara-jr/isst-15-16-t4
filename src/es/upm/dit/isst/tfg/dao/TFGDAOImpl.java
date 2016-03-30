/**
 * 
 */
package es.upm.dit.isst.tfg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.tfg.model.TFG;

/**
 * @author Clara
 *
 */
public class TFGDAOImpl implements TFGDAO {
	
	private static TFGDAOImpl instance;
	public static TFGDAOImpl getInstance() {
		if (instance == null)
			instance = new TFGDAOImpl();
		return instance;
	} 

	/**
	 * 
	 */
	private TFGDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#create(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public TFG create(String autor, String titulo, String resumen, String tutor, String secretario, String fichero,
			int estado) {
		// TODO Auto-generated method stub
		TFG tfg = null;
		EntityManager em = EMFService.get().createEntityManager();
		tfg = new TFG (autor, titulo, resumen, tutor, secretario, fichero, estado);
		em.persist(tfg);
		em.close();
		return tfg;
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#read()
	 */
	@Override
	public List<TFG> read() {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m");
		List<TFG> res = q.getResultList();
		em.close();
		return res;
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#readTutor(java.lang.String)
	 */
	@Override
	public List<TFG> readTutor(String profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#readSecretario(java.lang.String)
	 */
	@Override
	public List<TFG> readSecretario(String profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#readEstado(int)
	 */
	@Override
	public List<TFG> readEstado(int estado) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#readAlumno(java.lang.String)
	 */
	@Override
	public TFG readAlumno(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#update(es.upm.dit.isst.t4.model.TFG)
	 */
	@Override
	public TFG update(TFG tfg) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see es.dit.upm.isst.t4.dao.TFGDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
