package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Usuario;

@Remote
public interface UsuariosRemote {
	
	 public void crearUsuario(Usuario usuario) throws ServiciosException ;
	 public void borrarUsuario(Long idUsuario) throws ServiciosException;
	 public void modificarusuario(Usuario usuario) throws ServiciosException;
	 public List<Usuario> obtenerTodos() throws ServiciosException;

}
