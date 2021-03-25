package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Departamento;

@Remote
public interface DepartamentosRemote {
	
	public void crearDepartamento(Departamento dato) throws ServiciosException;
	public void borrarDepartamento(Long id) throws ServiciosException;
	public void modificarDepartamento(Departamento dato) throws ServiciosException;
	public List<Departamento> obtenerTodas() throws ServiciosException;

}
