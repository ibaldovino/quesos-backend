package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Maduracion;

@Remote
public interface MaduracionesRemote {
	
	public void crearMaduracion(Maduracion dato) throws ServiciosException;
	public void borrarMaduracion(Long id) throws ServiciosException;
	public void modificarMaduracion(Maduracion dato) throws ServiciosException;
	public List<Maduracion> obtenerTodas() throws ServiciosException;

}
