package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Tipoleche;

@Remote
public interface TipolechesRemote {
	
	public void crearTipoleche(Tipoleche dato) throws ServiciosException;
	public void borrarTipoleche(Long id) throws ServiciosException;
	public void modificarTipoleche(Tipoleche dato) throws ServiciosException;
	public List<Tipoleche> obtenerTodas() throws ServiciosException;

}
