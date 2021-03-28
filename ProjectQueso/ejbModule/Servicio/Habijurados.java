package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Habijurado;

/**
 * Session Bean implementation class Habijurados
 */
@Stateless
@LocalBean
public class Habijurados implements HabijuradosRemote {

    /**
     * Default constructor. 
     */
    public Habijurados() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearHabijurado (Habijurado dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Habijurado");
   		}
   	}

   	public void borrarHabijurado(Long idaborrar) throws ServiciosException {
   		try {
   			Habijurado objBorrar = em.find(Habijurado.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Habijurado");
   		}
   	}

   	public void modificarHabijurado(Habijurado dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Habijurado");
   		}
   	}

   	public List<Habijurado> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Habijurado> query = em.createNamedQuery("Habijurado.findAll", Habijurado.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Habijuradoes");
   		}
   	}

}
