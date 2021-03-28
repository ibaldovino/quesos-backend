package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Tarea;

@Remote
public interface TareasRemote {
	
	public void crearTarea(Tarea dato) throws ServiciosException;
	public void borrarTarea(Long id) throws ServiciosException;
	public void modificarTarea(Tarea dato) throws ServiciosException;
	public List<Tarea> obtenerTodas() throws ServiciosException;

}
