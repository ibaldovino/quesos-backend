package Servicio;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;

import model.Usuario;

/**
 * Session Bean implementation class Usuarios
 */
@Stateless
public class Usuarios implements UsuariosRemote {

    /**
     * Default constructor. 
     */
    public Usuarios() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext
	private EntityManager em;
    
    public void crearUsuario(Usuario usuario) throws ServiciosException {
		try {

			em.merge(usuario);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear el Usuario");
		}
	}

	public void borrarUsuario(Long idUsuario) throws ServiciosException {
		try {
			Usuario subcatego = em.find(Usuario.class, idUsuario);
			em.remove(subcatego);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar el Usuario");
		}
	}

	public void modificarusuario(Usuario usuario) throws ServiciosException {

		try {
			em.merge(usuario);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar el Usuario");
		}
	}

	public List<Usuario> obtenerTodos() throws ServiciosException {
		try {
			TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo listar los Usuarios");
		}
	}
    

}
