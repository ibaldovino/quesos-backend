package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Subcatego;

@Remote
public interface SubCategoriaRemote {
	
	public void crearSubCategoria(Subcatego subcatego) throws ServiciosException;
	public void borrarsubcatego(Long id) throws ServiciosException;
	public void modificarsubcatego(Subcatego subcatego) throws ServiciosException;
	public List<Subcatego> obtenerTodos() throws ServiciosException;
	

}
