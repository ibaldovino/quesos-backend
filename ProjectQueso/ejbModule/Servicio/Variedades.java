package Servicio;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Variedad;

/**
 * Session Bean implementation class Variedad
 */
@Stateless
public class Variedades implements VariedadesRemote {

    /**
     * Default constructor. 
     */
    public Variedades() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearVariedad (Variedad dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear la Variedad");
		}
	}

	public void borrarVariedad(Long idaborrar) throws ServiciosException {
		try {
			Variedad objBorrar = em.find(Variedad.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar la Variedad");
		}
	}

	public void modificarVariedad(Variedad dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Variedad");
		}
	}

	public List<Variedad> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Variedad> query = em.createNamedQuery("Variedad.findAll", Variedad.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Variedades");
		}
	}

}
