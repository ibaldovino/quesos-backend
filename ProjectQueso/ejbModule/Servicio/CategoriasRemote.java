package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Categoria;

@Remote
public interface CategoriasRemote {
	
	public void crearCategoria(Categoria dato) throws ServiciosException;
	public void borrarCategoria(Long id) throws ServiciosException;
	public void modificarCategoria(Categoria dato) throws ServiciosException;
	public List<Categoria> obtenerTodas() throws ServiciosException;

}
