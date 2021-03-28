package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Roltarea;

/**
 * Session Bean implementation class Roltareas
 */
@Stateless
@LocalBean
public class Roltareas implements RoltareasRemote {

    /**
     * Default constructor. 
     */
    public Roltareas() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearRoltarea (Roltarea dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Roltarea");
   		}
   	}

   	public void borrarRoltarea(Long idaborrar) throws ServiciosException {
   		try {
   			Roltarea objBorrar = em.find(Roltarea.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Roltarea");
   		}
   	}

   	public void modificarRoltarea(Roltarea dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Roltarea");
   		}
   	}

   	public List<Roltarea> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Roltarea> query = em.createNamedQuery("Roltarea.findAll", Roltarea.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Roltareaes");
   		}
   	}

}
