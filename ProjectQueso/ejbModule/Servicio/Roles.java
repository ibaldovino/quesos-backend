package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Role;

/**
 * Session Bean implementation class Roles
 */
@Stateless
@LocalBean
public class Roles implements RolesRemote {

    /**
     * Default constructor. 
     */
    public Roles() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearRole (Role dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Role");
   		}
   	}

   	public void borrarRole(Long idaborrar) throws ServiciosException {
   		try {
   			Role objBorrar = em.find(Role.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Role");
   		}
   	}

   	public void modificarRole(Role dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Role");
   		}
   	}

   	public List<Role> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Rolees");
   		}
   	}

}
