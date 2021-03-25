package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ROLTAREA database table.
 * 
 */
@Entity
@NamedQuery(name="Roltarea.findAll", query="SELECT r FROM Roltarea r")
public class Roltarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_rolt", sequenceName="seq_ID_ROLTAR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_rolt")
	@Column(name="ID_ROLTAR")
	private long idRoltar;

	@Column(name="AUTORIZADO_SN")
	private String autorizadoSn;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ROL")
	private Role role;

	//bi-directional many-to-one association to Tarea
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_TAREA")
	private Tarea tarea;

	public Roltarea() {
	}

	public long getIdRoltar() {
		return this.idRoltar;
	}

	public void setIdRoltar(long idRoltar) {
		this.idRoltar = idRoltar;
	}

	public String getAutorizadoSn() {
		return this.autorizadoSn;
	}

	public void setAutorizadoSn(String autorizadoSn) {
		this.autorizadoSn = autorizadoSn;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

}