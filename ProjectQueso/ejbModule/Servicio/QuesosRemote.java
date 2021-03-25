package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Queso;


@Remote
public interface QuesosRemote {
	
	public void crearQueso(Queso queso) throws ServiciosException;
	public void borrarQueso(Long idQueso) throws ServiciosException;
	public void modificarQueso(Queso queso) throws ServiciosException;
	public List<Queso> obtenerTodos() throws ServiciosException ;

}
