package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Tarea;

/**
 * Session Bean implementation class Tareas
 */
@Stateless
@LocalBean
public class Tareas implements TareasRemote {

    /**
     * Default constructor. 
     */
    public Tareas() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearTarea (Tarea dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Tarea");
   		}
   	}

   	public void borrarTarea(Long idaborrar) throws ServiciosException {
   		try {
   			Tarea objBorrar = em.find(Tarea.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Tarea");
   		}
   	}

   	public void modificarTarea(Tarea dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Tarea");
   		}
   	}

   	public List<Tarea> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Tarea> query = em.createNamedQuery("Tarea.findAll", Tarea.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Tareaes");
   		}
   	}

}
