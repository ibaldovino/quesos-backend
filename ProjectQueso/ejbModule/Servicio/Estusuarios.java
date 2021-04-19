package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Estusuario;

/**
 * Session Bean implementation class Estusuarios
 */
@Stateless
@LocalBean
public class Estusuarios implements EstusuariosRemote {

    /**
     * Default constructor. 
     */
    public Estusuarios() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
   	private EntityManager em;
       
       public void crearEstusuario (Estusuario dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Estusuario");
   		}
   	}

   	public void borrarEstusuario(String idaborrar) throws ServiciosException {
   		try {
   			Estusuario objBorrar = em.find(Estusuario.class, idaborrar);
   			em.remove(objBorrar);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Estusuario");
   		}
   	}

   	public void modificarEstusuario(Estusuario dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Estusuario");
   		}
   	}

   	public List<Estusuario> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Estusuario> query = em.createNamedQuery("Estusuario.findAll", Estusuario.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Estusuarioes");
   		}
   	}
}
