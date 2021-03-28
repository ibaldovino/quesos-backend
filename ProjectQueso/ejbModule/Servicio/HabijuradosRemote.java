package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Habijurado;

@Remote
public interface HabijuradosRemote {

	public void crearHabijurado(Habijurado dato) throws ServiciosException;
	public void borrarHabijurado(Long id) throws ServiciosException;
	public void modificarHabijurado(Habijurado dato) throws ServiciosException;
	public List<Habijurado> obtenerTodas() throws ServiciosException;
}
