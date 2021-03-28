package Servicio;

import java.util.List;

import javax.ejb.Remote;

import Exception.ServiciosException;
import model.Participante;

@Remote
public interface ParticipantesRemote {
	
	public void crearParticipante(Participante dato) throws ServiciosException;
	public void borrarParticipante(Long id) throws ServiciosException;
	public void modificarParticipante(Participante dato) throws ServiciosException;
	public List<Participante> obtenerTodas() throws ServiciosException;

}
