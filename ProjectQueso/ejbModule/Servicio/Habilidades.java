package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Habilidade;

/**
 * Session Bean implementation class Habilidades
 */
@Stateless
@LocalBean
public class Habilidades implements HabilidadesRemote {

    /**
     * Default constructor. 
     */
    public Habilidades() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearHabilidade (Habilidade dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo crear la Habilidad");
		}
	}

	public void borrarHabilidade(Long idaborrar) throws ServiciosException {
		try {
			Habilidade objBorrar = em.find(Habilidade.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo borrar la Habilidad");
		}
	}

	public void modificarHabilidade(Habilidade dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar la Habilidad");
		}
	}

	public List<Habilidade> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Habilidade> query = em.createNamedQuery("Habilidade.findAll", Habilidade.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar las Habilidades");
		}
	}
    

}
