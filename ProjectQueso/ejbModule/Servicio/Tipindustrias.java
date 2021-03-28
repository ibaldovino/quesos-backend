package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Tipindustria;

/**
 * Session Bean implementation class Tipindustrias
 */
@Stateless
@LocalBean
public class Tipindustrias implements TipindustriasRemote {

    /**
     * Default constructor. 
     */
    public Tipindustrias() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearTipindustria (Tipindustria dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Tipindustria");
   		}
   	}

   	public void borrarTipindustria(Long idaborrar) throws ServiciosException {
   		try {
   			Tipindustria objBorrar = em.find(Tipindustria.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Tipindustria");
   		}
   	}

   	public void modificarTipindustria(Tipindustria dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Tipindustria");
   		}
   	}

   	public List<Tipindustria> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Tipindustria> query = em.createNamedQuery("Tipindustria.findAll", Tipindustria.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Tipindustriaes");
   		}
   	}

}
