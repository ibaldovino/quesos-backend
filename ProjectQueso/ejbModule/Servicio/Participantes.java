package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Participante;

/**
 * Session Bean implementation class Participantes
 */
@Stateless
@LocalBean
public class Participantes implements ParticipantesRemote {

    /**
     * Default constructor. 
     */
    public Participantes() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
   	private EntityManager em;
       
       public void crearParticipante (Participante dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Participante");
   		}
   	}

   	public void borrarParticipante(Long idaborrar) throws ServiciosException {
   		try {
   			Participante objBorrar = em.find(Participante.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Participante");
   		}
   	}

   	public void modificarParticipante(Participante dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Participante");
   		}
   	}

   	public List<Participante> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Participante> query = em.createNamedQuery("Participante.findAll", Participante.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Participantees");
   		}
   	}
}
