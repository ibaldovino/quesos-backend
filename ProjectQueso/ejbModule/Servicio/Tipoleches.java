package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Tipoleche;

/**
 * Session Bean implementation class Tipoleches
 */
@Stateless
@LocalBean
public class Tipoleches implements TipolechesRemote {

    /**
     * Default constructor. 
     */
    public Tipoleches() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearTipoleche (Tipoleche dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear el Tipo de leche");
		}
	}

	public void borrarTipoleche(Long idaborrar) throws ServiciosException {
		try {
			Tipoleche objBorrar = em.find(Tipoleche.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar el Tipo de leche");
		}
	}

	public void modificarTipoleche(Tipoleche dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar el Tipo de leche");
		}
	}

	public List<Tipoleche> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Tipoleche> query = em.createNamedQuery("Tipoleche.findAll", Tipoleche.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar los Tipo de leches");
		}
	}

}
