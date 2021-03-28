package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Evadescrip;

/**
 * Session Bean implementation class Evadescrips
 */
@Stateless
@LocalBean
public class Evadescrips implements EvadescripsRemote {

    /**
     * Default constructor. 
     */
    public Evadescrips() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearEvadescrip (Evadescrip dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Evadescrip");
   		}
   	}

   	public void borrarEvadescrip(Long idaborrar) throws ServiciosException {
   		try {
   			Evadescrip objBorrar = em.find(Evadescrip.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Evadescrip");
   		}
   	}

   	public void modificarEvadescrip(Evadescrip dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Evadescrip");
   		}
   	}

   	public List<Evadescrip> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Evadescrip> query = em.createNamedQuery("Evadescrip.findAll", Evadescrip.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Evadescripes");
   		}
   	}

}
