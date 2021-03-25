package Servicio;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Humedad;
import model.Subcatego;

/**
 * Session Bean implementation class Humedad
 */
@Stateless
public class Humedades implements HumedadesRemote {

    /**
     * Default constructor. 
     */
    public Humedades() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
       
       public void crearHumedad (Humedad dato) throws ServiciosException {
   		try {

   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo crear la Humedad");
   		}
   	}

   	public void borrarHumedad(Long idaborrar) throws ServiciosException {
   		try {
   			Humedad obj = em.find(Humedad.class, idaborrar);
   			em.remove(obj);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo borrar la Humedad");
   		}
   	}

   	public void modificarHumedad(Humedad dato) throws ServiciosException {

   		try {
   			em.merge(dato);
   			em.flush();

   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se pudo modificar la Humedad");
   		}
   	}

   	public List<Humedad> obtenerTodas() throws ServiciosException {
   		try {
   			TypedQuery<Humedad> query = em.createNamedQuery("Humedad.findAll", Humedad.class);
   			return query.getResultList();
   		} catch (PersistenceException e) {
   			e.printStackTrace();
   			throw new ServiciosException("No se puedo listar las Humedades");
   		}
   	}

}
