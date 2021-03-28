package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Tipindustria;

@Remote
public interface TipindustriasRemote {

	public void crearTipindustria(Tipindustria dato) throws ServiciosException;
	public void borrarTipindustria(Long id) throws ServiciosException;
	public void modificarTipindustria(Tipindustria dato) throws ServiciosException;
	public List<Tipindustria> obtenerTodas() throws ServiciosException;
}
