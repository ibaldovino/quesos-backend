package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Evatipo;

/**
 * Session Bean implementation class Evatipos
 */
@Stateless
@LocalBean
public class Evatipos implements EvatiposRemote {

    /**
     * Default constructor. 
     */
    public Evatipos() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearEvatipo (Evatipo dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Evatipo");
   		}
   	}

   	public void borrarEvatipo(Long idaborrar) throws ServiciosException {
   		try {
   			Evatipo objBorrar = em.find(Evatipo.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Evatipo");
   		}
   	}

   	public void modificarEvatipo(Evatipo dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Evatipo");
   		}
   	}

   	public List<Evatipo> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Evatipo> query = em.createNamedQuery("Evatipo.findAll", Evatipo.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Evatipoes");
   		}
   	}

}
