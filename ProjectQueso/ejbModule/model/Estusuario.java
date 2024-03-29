package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the ESTUSUARIOS database table.
 * 
 */
@Entity
@Table(name="ESTUSUARIOS")
@NamedQuery(name="Estusuario.findAll", query="SELECT e FROM Estusuario e")
public class Estusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_esusu", sequenceName="seq_ID_ESTADO_USUARIO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_esusu")
	@Column(name="ID_ESTADO_USUARIO")
	private Long idEstadoUsuario;

	@Column(name="DESCR_ESTADO")
	private String descrEstado;

	/*
	 * //bi-directional many-to-one association to Usuario
	 * 
	 * @OneToMany(mappedBy="estusuario") private List<Usuario> usuarios;
	 */

	public Estusuario() {
	}

	public Long getIdEstadoUsuario() {
		return this.idEstadoUsuario;
	}

	public void setIdEstadoUsuario(Long idEstadoUsuario) {
		this.idEstadoUsuario = idEstadoUsuario;
	}

	public String getDescrEstado() {
		return this.descrEstado;
	}

	public void setDescrEstado(String descrEstado) {
		this.descrEstado = descrEstado;
	}

	/*
	 * public List<Usuario> getUsuarios() { return this.usuarios; }
	 * 
	 * public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
	 * 
	 * public Usuario addUsuario(Usuario usuario) { getUsuarios().add(usuario);
	 * usuario.setEstusuario(this);
	 * 
	 * return usuario; }
	 * 
	 * public Usuario removeUsuario(Usuario usuario) {
	 * getUsuarios().remove(usuario); usuario.setEstusuario(null);
	 * 
	 * return usuario; }
	 */

}