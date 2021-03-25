package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Mesa;

@Remote
public interface MesasRemote {
	
	public void crearMesa(Mesa dato) throws ServiciosException;
	public void borrarMesa(Long id) throws ServiciosException;
	public void modificarMesa(Mesa dato) throws ServiciosException;
	public List<Mesa> obtenerTodas() throws ServiciosException;

}
