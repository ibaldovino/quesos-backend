package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Pais;

@Remote
public interface PaisesRemote {
	
	public void crearPais(Pais dato) throws ServiciosException;
	public void borrarPais(Long id) throws ServiciosException;
	public void modificarPais(Pais dato) throws ServiciosException;
	public List<Pais> obtenerTodas() throws ServiciosException;

}
