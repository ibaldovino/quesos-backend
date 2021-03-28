package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Evaluacione;

/**
 * Session Bean implementation class Evaluaciones
 */
@Stateless
@LocalBean
public class Evaluaciones implements EvaluacionesRemote {

    /**
     * Default constructor. 
     */
    public Evaluaciones() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
   	private EntityManager em;
       
       public void crearEvaluacione (Evaluacione dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Evaluacione");
   		}
   	}

   	public void borrarEvaluacione(Long idaborrar) throws ServiciosException {
   		try {
   			Evaluacione objBorrar = em.find(Evaluacione.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Evaluacione");
   		}
   	}

   	public void modificarEvaluacione(Evaluacione dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Evaluacione");
   		}
   	}

   	public List<Evaluacione> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Evaluacione> query = em.createNamedQuery("Evaluacione.findAll", Evaluacione.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Evaluacionees");
   		}
   	}
}
