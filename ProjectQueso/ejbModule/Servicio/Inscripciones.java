package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Inscripcione;

/**
 * Session Bean implementation class Inscripcione
 */
@Stateless
@LocalBean
public class Inscripciones implements InscripcionesRemote {

    /**
     * Default constructor. 
     */
    public Inscripciones() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearInscripcione (Inscripcione dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Inscripcione");
   		}
   	}

   	public void borrarInscripcione(Long idaborrar) throws ServiciosException {
   		try {
   			Inscripcione objBorrar = em.find(Inscripcione.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Inscripcione");
   		}
   	}

   	public void modificarInscripcione(Inscripcione dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Inscripcione");
   		}
   	}

   	public List<Inscripcione> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Inscripcione> query = em.createNamedQuery("Inscripcione.findAll", Inscripcione.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Inscripcionees");
   		}
   	}

}
