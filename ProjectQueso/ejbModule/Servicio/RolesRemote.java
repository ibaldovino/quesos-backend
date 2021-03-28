package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Role;

@Remote
public interface RolesRemote {

	public void crearRole(Role dato) throws ServiciosException;
	public void borrarRole(Long id) throws ServiciosException;
	public void modificarRole(Role dato) throws ServiciosException;
	public List<Role> obtenerTodas() throws ServiciosException;
}
