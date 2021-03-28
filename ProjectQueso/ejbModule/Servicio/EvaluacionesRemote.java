package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Evaluacione;

@Remote
public interface EvaluacionesRemote {

	
	public void crearEvaluacione(Evaluacione dato) throws ServiciosException;
	public void borrarEvaluacione(Long id) throws ServiciosException;
	public void modificarEvaluacione(Evaluacione dato) throws ServiciosException;
	public List<Evaluacione> obtenerTodas() throws ServiciosException;
}
