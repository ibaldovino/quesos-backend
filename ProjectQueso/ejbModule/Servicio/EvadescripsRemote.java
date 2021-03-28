package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Evadescrip;

@Remote
public interface EvadescripsRemote {

	public void crearEvadescrip(Evadescrip dato) throws ServiciosException;
	public void borrarEvadescrip(Long id) throws ServiciosException;
	public void modificarEvadescrip(Evadescrip dato) throws ServiciosException;
	public List<Evadescrip> obtenerTodas() throws ServiciosException;
}
