package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Camara;

/**
 * Session Bean implementation class Camaras
 */
@Stateless
@LocalBean
public class Camaras implements CamarasRemote {

    /**
     * Default constructor. 
     */
    public Camaras() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearCamara (Camara dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Camara");
   		}
   	}

   	public void borrarCamara(Long idaborrar) throws ServiciosException {
   		try {
   			Camara objBorrar = em.find(Camara.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Camara");
   		}
   	}

   	public void modificarCamara(Camara dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Camara");
   		}
   	}

   	public List<Camara> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Camara> query = em.createNamedQuery("Camara.findAll", Camara.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Camaras");
   		}
   	}

}
