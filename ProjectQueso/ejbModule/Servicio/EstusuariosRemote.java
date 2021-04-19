package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Estusuario;

@Remote
public interface EstusuariosRemote {

	public void crearEstusuario(Estusuario dato) throws ServiciosException;
	public void borrarEstusuario(String id) throws ServiciosException;
	public void modificarEstusuario(Estusuario dato) throws ServiciosException;
	public List<Estusuario> obtenerTodas() throws ServiciosException;
}
