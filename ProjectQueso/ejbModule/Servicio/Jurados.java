package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Jurado;


/**
 * Session Bean implementation class Jurado
 */
@Stateless
@LocalBean
public class Jurados implements JuradosRemote {

    /**
     * Default constructor. 
     */
    public Jurados() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearJuez (Jurado dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear el Jurado");
		}
	}

	public void borrarJuez(Long idaborrar) throws ServiciosException {
		try {
			Jurado objBorrar = em.find(Jurado.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar el Jurado");
		}
	}

	public void modificarJuez(Jurado dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar el Jurado");
		}
	}

	public List<Jurado> obtenerTodos() throws ServiciosException {
		try {
			TypedQuery<Jurado> query = em.createNamedQuery("Jurado.findAll", Jurado.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar los Jurados");
		}
	}

}
