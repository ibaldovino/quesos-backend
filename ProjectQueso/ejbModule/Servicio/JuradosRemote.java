package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Jurado;


@Remote
public interface JuradosRemote {

	public void crearJuez(Jurado dato) throws ServiciosException;
	public void borrarJuez(Long id) throws ServiciosException;
	public void modificarJuez(Jurado dato) throws ServiciosException;
	public List<Jurado> obtenerTodos() throws ServiciosException;
}
