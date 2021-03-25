package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Tecnologia;

@Remote
public interface TecnologiasRemote {

	public void crearTecnologia(Tecnologia dato) throws ServiciosException;
	public void borrarTecnologia(Long id) throws ServiciosException;
	public void modificarTecnologia(Tecnologia dato) throws ServiciosException;
	public List<Tecnologia> obtenerTodas() throws ServiciosException;
	
}
