package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Pais;

/**
 * Session Bean implementation class Pais
 */
@Stateless
@LocalBean
public class Paises implements PaisesRemote {

    /**
     * Default constructor. 
     */
    public Paises() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
	private EntityManager em;
    
    public void crearPais (Pais dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear la Pais");
		}
	}

	public void borrarPais(Long idaborrar) throws ServiciosException {
		try {
			Pais objBorrar = em.find(Pais.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar la Pais");
		}
	}

	public void modificarPais(Pais dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Pais");
		}
	}

	public List<Pais> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Pais> query = em.createNamedQuery("Pais.findAll", Pais.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Paises");
		}
	}
}
