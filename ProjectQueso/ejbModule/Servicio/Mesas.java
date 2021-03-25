package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Mesa;

/**
 * Session Bean implementation class Mesas
 */
@Stateless
@LocalBean
public class Mesas implements MesasRemote {

    /**
     * Default constructor. 
     */
    public Mesas() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearMesa (Mesa dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear la Mesa");
		}
	}

	public void borrarMesa(Long idaborrar) throws ServiciosException {
		try {
			Mesa objBorrar = em.find(Mesa.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar la Mesa");
		}
	}

	public void modificarMesa(Mesa dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Mesa");
		}
	}

	public List<Mesa> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Mesa> query = em.createNamedQuery("Mesa.findAll", Mesa.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Mesas");
		}
	}

}
