package Servicio;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Subcatego;

/**
 * Session Bean implementation class SubCategoria
 */
@Stateless
public class SubCategoria implements SubCategoriaRemote {

    /**
     * Default constructor. 
     */
    public SubCategoria() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearSubCategoria(Subcatego subcatego) throws ServiciosException {
		try {

			em.merge(subcatego);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear la SubCategoria");
		}
	}

	public void borrarsubcatego(Long idSubcateg) throws ServiciosException {
		try {
			Subcatego subcatego = em.find(Subcatego.class, idSubcateg);
			em.remove(subcatego);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar la SubCategoria");
		}
	}

	public void modificarsubcatego(Subcatego subcatego) throws ServiciosException {

		try {
			em.merge(subcatego);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la SubCategoria");
		}
	}

	public List<Subcatego> obtenerTodos() throws ServiciosException {
		try {
			TypedQuery<Subcatego> query = em.createNamedQuery("Subcatego.findAll", Subcatego.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las SubCategorias");
		}
	}

}
