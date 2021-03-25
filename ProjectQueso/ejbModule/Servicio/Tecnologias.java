package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Subcatego;
import model.Tecnologia;

/**
 * Session Bean implementation class Tecnologias
 */
@Stateless
@LocalBean
public class Tecnologias implements TecnologiasRemote {

    /**
     * Default constructor. 
     */
    public Tecnologias() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearTecnologia (Tecnologia dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo crear la Tecnologia");
		}
	}

	public void borrarTecnologia(Long idaborrar) throws ServiciosException {
		try {
			Tecnologia obj = em.find(Tecnologia.class, idaborrar);
			em.remove(obj);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo borrar la Tecnologia");
		}
	}

	public void modificarTecnologia(Tecnologia dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Tecnologia");
		}
	}

	public List<Tecnologia> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Tecnologia> query = em.createNamedQuery("Tecnologia.findAll", Tecnologia.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Tecnologias");
		}
	}

}
