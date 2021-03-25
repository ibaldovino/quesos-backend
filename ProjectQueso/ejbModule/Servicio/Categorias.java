package Servicio;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Subcatego;
import model.Categoria;

/**
 * Session Bean implementation class Categorias
 */
@Stateless
public class Categorias implements CategoriasRemote {

    /**
     * Default constructor. 
     */
    public Categorias() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearCategoria (Categoria dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo crear la Categoria");
		}
	}

	public void borrarCategoria(Long idaborrar) throws ServiciosException {
		try {
			Subcatego subcatego = em.find(Subcatego.class, idaborrar);
			em.remove(subcatego);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo borrar la Categoria");
		}
	}

	public void modificarCategoria(Categoria dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Categoria");
		}
	}

	public List<Categoria> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Categoria> query = em.createNamedQuery("Categoria.findAll", Categoria.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Categorias");
		}
	}

}
