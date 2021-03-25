package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the LOCALIDADES database table.
 * 
 */
@Entity
@Table(name="LOCALIDADES")
@NamedQuery(name="Localidade.findAll", query="SELECT l FROM Localidade l")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_loca", sequenceName="seq_ID_LOCAL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_loca")
	@Column(name="ID_LOCAL")
	private long idLocal;

	@Column(name="DESCR_LOCAL")
	private String descrLocal;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPTO")
	private Departamento departamento;

	/*
	 * //bi-directional many-to-one association to Participante
	 * 
	 * @OneToMany(mappedBy="localidade") private List<Participante> participantes;
	 */
	public Localidade() {
	}

	public long getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}

	public String getDescrLocal() {
		return this.descrLocal;
	}

	public void setDescrLocal(String descrLocal) {
		this.descrLocal = descrLocal;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	/*
	 * public List<Participante> getParticipantes() { return this.participantes; }
	 * 
	 * public void setParticipantes(List<Participante> participantes) {
	 * this.participantes = participantes; }
	 * 
	 * public Participante addParticipante(Participante participante) {
	 * getParticipantes().add(participante); participante.setLocalidade(this);
	 * 
	 * return participante; }
	 * 
	 * public Participante removeParticipante(Participante participante) {
	 * getParticipantes().remove(participante); participante.setLocalidade(null);
	 * 
	 * return participante; }
	 */

}