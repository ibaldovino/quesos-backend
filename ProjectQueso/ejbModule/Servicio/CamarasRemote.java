package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Camara;

@Remote
public interface CamarasRemote {

	public void crearCamara(Camara dato) throws ServiciosException;
	public void borrarCamara(Long id) throws ServiciosException;
	public void modificarCamara(Camara dato) throws ServiciosException;
	public List<Camara> obtenerTodas() throws ServiciosException;
}
