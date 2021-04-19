package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u ORDER BY u.usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_usu", sequenceName="seq_ID_USUARIO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_usu")
	@Column(name="ID_USUARIO")
	private Long idUsuario;

	@Column(name="APE_USUARIO")
	private String apeUsuario;

	@Column(name="FECALT_USUARIO")
	private String fecaltUsuario;

	@Column(name="FECBAJ_USUARIO")
	private String fecbajUsuario;

	@Column(name="FECSUS_USUARIO")
	private String fecsusUsuario;

	@Column(name="MAIL_USUARIO")
	private String mailUsuario;

	@Column(name="NOM_USUARIO")
	private String nomUsuario;

	@Column(name="PWD_USUARIO")
	private String pwdUsuario;

	@Column(name="TELEF_USUARIO")
	private String telefUsuario;

	@Column(name="USUARIO")
	private String usuario;

	//bi-directional many-to-one association to Estusuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ESTADO_USUARIO")
	private Estusuario estusuario;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ROL")
	private Role role;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApeUsuario() {
		return this.apeUsuario;
	}

	public void setApeUsuario(String apeUsuario) {
		this.apeUsuario = apeUsuario;
	}

	public String getFecaltUsuario() {
		return this.fecaltUsuario;
	}

	public void setFecaltUsuario(String fecaltUsuario) {
		this.fecaltUsuario = fecaltUsuario;
	}

	public String getFecbajUsuario() {
		return this.fecbajUsuario;
	}

	public void setFecbajUsuario(String fecbajUsuario) {
		this.fecbajUsuario = fecbajUsuario;
	}

	public String getFecsusUsuario() {
		return this.fecsusUsuario;
	}

	public void setFecsusUsuario(String fecsusUsuario) {
		this.fecsusUsuario = fecsusUsuario;
	}

	public String getMailUsuario() {
		return this.mailUsuario;
	}

	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}

	public String getNomUsuario() {
		return this.nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getPwdUsuario() {
		return this.pwdUsuario;
	}

	public void setPwdUsuario(String pwdUsuario) {
		this.pwdUsuario = pwdUsuario;
	}

	public String getTelefUsuario() {
		return this.telefUsuario;
	}

	public void setTelefUsuario(String telefUsuario) {
		this.telefUsuario = telefUsuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Estusuario getEstusuario() {
		return this.estusuario;
	}

	public void setEstusuario(Estusuario estusuario) {
		this.estusuario = estusuario;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}