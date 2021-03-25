package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Habilidade;

@Remote
public interface HabilidadesRemote {

	public void crearHabilidade(Habilidade dato) throws ServiciosException;
	public void borrarHabilidade(Long id) throws ServiciosException;
	public void modificarHabilidade(Habilidade dato) throws ServiciosException;
	public List<Habilidade> obtenerTodas() throws ServiciosException;
}
