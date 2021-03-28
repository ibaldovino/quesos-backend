package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Roltarea;

@Remote
public interface RoltareasRemote {

	public void crearRoltarea(Roltarea dato) throws ServiciosException;
	public void borrarRoltarea(Long id) throws ServiciosException;
	public void modificarRoltarea(Roltarea dato) throws ServiciosException;
	public List<Roltarea> obtenerTodas() throws ServiciosException;
}
