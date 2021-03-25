package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Localidade;

@Remote
public interface LocalidadesRemote {

	public void crearLocalidade(Localidade dato) throws ServiciosException;
	public void borrarLocalidade(Long id) throws ServiciosException;
	public void modificarLocalidade(Localidade dato) throws ServiciosException;
	public List<Localidade> obtenerTodas() throws ServiciosException;
}
