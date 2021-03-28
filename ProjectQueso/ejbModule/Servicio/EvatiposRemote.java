package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Evatipo;

@Remote
public interface EvatiposRemote {
	
	public void crearEvatipo(Evatipo dato) throws ServiciosException;
	public void borrarEvatipo(Long id) throws ServiciosException;
	public void modificarEvatipo(Evatipo dato) throws ServiciosException;
	public List<Evatipo> obtenerTodas() throws ServiciosException;

}
