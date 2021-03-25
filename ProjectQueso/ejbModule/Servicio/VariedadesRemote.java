package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Variedad;


@Remote
public interface VariedadesRemote {
	
	public void crearVariedad(Variedad dato) throws ServiciosException;
	public void borrarVariedad(Long id) throws ServiciosException;
	public void modificarVariedad(Variedad dato) throws ServiciosException;
	public List<Variedad> obtenerTodas() throws ServiciosException;

}
