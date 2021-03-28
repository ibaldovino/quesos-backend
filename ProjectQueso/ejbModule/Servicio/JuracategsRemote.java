package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Juracateg;

@Remote
public interface JuracategsRemote {

	public void crearJuracateg(Juracateg dato) throws ServiciosException;
	public void borrarJuracateg(Long id) throws ServiciosException;
	public void modificarJuracateg(Juracateg dato) throws ServiciosException;
	public List<Juracateg> obtenerTodas() throws ServiciosException;
}
