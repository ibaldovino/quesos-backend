package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Humedad;

@Remote
public interface HumedadesRemote {

	public void crearHumedad(Humedad dato) throws ServiciosException;
	public void borrarHumedad(Long id) throws ServiciosException;
	public void modificarHumedad(Humedad dato) throws ServiciosException;
	public List<Humedad> obtenerTodas() throws ServiciosException;
	
}
