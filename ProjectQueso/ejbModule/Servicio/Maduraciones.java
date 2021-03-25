package Servicio;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;

import model.Maduracion;

/**
 * Session Bean implementation class Maduraciones
 */
@Stateless
public class Maduraciones implements MaduracionesRemote {

    /**
     * Default constructor. 
     */
    public Maduraciones() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearMaduracion (Maduracion dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear la Maduracion");
		}
	}

	public void borrarMaduracion(Long idaborrar) throws ServiciosException {
		try {
			Maduracion objBorrar = em.find(Maduracion.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar la Maduracion");
		}
	}

	public void modificarMaduracion(Maduracion dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Maduracion");
		}
	}

	public List<Maduracion> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Maduracion> query = em.createNamedQuery("Maduracion.findAll", Maduracion.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Maduraciones");
		}
	}

}
