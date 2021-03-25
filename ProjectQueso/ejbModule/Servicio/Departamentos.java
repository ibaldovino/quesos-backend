package Servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Exception.ServiciosException;
import model.Departamento;

/**
 * Session Bean implementation class Departamentos
 */
@Stateless
@LocalBean
public class Departamentos implements DepartamentosRemote {

    /**
     * Default constructor. 
     */
    public Departamentos() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public void crearDepartamento (Departamento dato) throws ServiciosException {
		try {

			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo crear el Departamento");
		}
	}

	public void borrarDepartamento(Long idaborrar) throws ServiciosException {
		try {
			Departamento objBorrar = em.find(Departamento.class, idaborrar);
			em.remove(objBorrar);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo borrar el Departamento");
		}
	}

	public void modificarDepartamento(Departamento dato) throws ServiciosException {

		try {
			em.merge(dato);
			em.flush();

		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo modificar el Departamento");
		}
	}

	public List<Departamento> obtenerTodas() throws ServiciosException {
		try {
			TypedQuery<Departamento> query = em.createNamedQuery("Departamento.findAll", Departamento.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiciosException("No se puedo listar los Departamentos");
		}
	}

}
