package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Inscripcione;

@Remote
public interface InscripcionesRemote {
	
	public void crearInscripcione(Inscripcione dato) throws ServiciosException;
	public void borrarInscripcione(Long id) throws ServiciosException;
	public void modificarInscripcione(Inscripcione dato) throws ServiciosException;
	public List<Inscripcione> obtenerTodas() throws ServiciosException;

}
