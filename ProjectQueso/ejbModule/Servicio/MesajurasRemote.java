package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Mesajura;

@Remote
public interface MesajurasRemote {

	public void crearMesajura(Mesajura dato) throws ServiciosException;
	public void borrarMesajura(Long id) throws ServiciosException;
	public void modificarMesajura(Mesajura dato) throws ServiciosException;
	public List<Mesajura> obtenerTodas() throws ServiciosException;
}
