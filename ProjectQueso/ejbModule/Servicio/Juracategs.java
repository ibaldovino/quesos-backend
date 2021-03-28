package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Juracateg;

/**
 * Session Bean implementation class Juracategs
 */
@Stateless
@LocalBean
public class Juracategs implements JuracategsRemote {

    /**
     * Default constructor. 
     */
    public Juracategs() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearJuracateg (Juracateg dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Juracateg");
   		}
   	}

   	public void borrarJuracateg(Long idaborrar) throws ServiciosException {
   		try {
   			Juracateg objBorrar = em.find(Juracateg.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Juracateg");
   		}
   	}

   	public void modificarJuracateg(Juracateg dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Juracateg");
   		}
   	}

   	public List<Juracateg> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Juracateg> query = em.createNamedQuery("Juracateg.findAll", Juracateg.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Juracateges");
   		}
   	}

}
