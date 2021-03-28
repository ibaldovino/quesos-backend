package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Mesajura;

/**
 * Session Bean implementation class Mesajuras
 */
@Stateless
@LocalBean
public class Mesajuras implements MesajurasRemote {

    /**
     * Default constructor. 
     */
    public Mesajuras() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearMesajura (Mesajura dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Mesajura");
   		}
   	}

   	public void borrarMesajura(Long idaborrar) throws ServiciosException {
   		try {
   			Mesajura objBorrar = em.find(Mesajura.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Mesajura");
   		}
   	}

   	public void modificarMesajura(Mesajura dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Mesajura");
   		}
   	}

   	public List<Mesajura> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Mesajura> query = em.createNamedQuery("Mesajura.findAll", Mesajura.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Mesajuraes");
   		}
   	}

}
