package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Localidade;

/**
 * Session Bean implementation class Localidades
 */
@Stateless
@LocalBean
public class Localidades implements LocalidadesRemote {

    /**
     * Default constructor. 
     */
    public Localidades() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearLocalidade (Localidade dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo crear la Localidad");
		}
	}

	public void borrarLocalidade(Long idaborrar) throws ServiciosException {
		try {
			Localidade objBorrar = em.find(Localidade.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo borrar la Localidad");
		}
	}

	public void modificarLocalidade(Localidade dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Localidad");
		}
	}

	public List<Localidade> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Localidade> query = em.createNamedQuery("Localidade.findAll", Localidade.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Localidades");
		}
	}

}
