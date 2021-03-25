package Servicio;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Queso;


/**
 * Session Bean implementation class Quesos
 */
@Stateless
public class Quesos implements QuesosRemote {

    /**
     * Default constructor. 
     */
    public Quesos() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearQueso(Queso queso) throws ServiciosException {
		try {

			em.merge(queso);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear el Queso");
		}
	}

	public void borrarQueso(Long idQueso) throws ServiciosException {
		try {
			Queso Queso = em.find(Queso.class, idQueso);
			em.remove(Queso);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar el Queso");
		}
	}

	public void modificarQueso(Queso queso) throws ServiciosException {

		try {
			em.merge(queso);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar el Queso");
		}
	}

	public List<Queso> obtenerTodos() throws ServiciosException {
		try {
			TypedQuery<Queso> query = em.createNamedQuery("Queso.findAll", Queso.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar los Quesos");
		}
	}

}
