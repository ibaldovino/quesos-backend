package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HABIJURADO database table.
 * 
 */
@Entity
@NamedQuery(name="Habijurado.findAll", query="SELECT h FROM Habijurado h")
public class Habijurado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_habij", sequenceName="seq_ID_HABJUR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_habij")
	@Column(name="ID_HABJUR")
	private long idHabjur;

	@Column(name="OBSERV_HABJUR")
	private String observHabjur;

	//bi-directional many-to-one association to Habilidade
	@ManyToOne
	@JoinColumn(name="ID_HABILI")
	private Habilidade habilidade;

	//bi-directional many-to-one association to Jurado
	@ManyToOne
	@JoinColumn(name="ID_JURADO")
	private Jurado jurado;

	public Habijurado() {
	}

	public long getIdHabjur() {
		return this.idHabjur;
	}

	public void setIdHabjur(long idHabjur) {
		this.idHabjur = idHabjur;
	}

	public String getObservHabjur() {
		return this.observHabjur;
	}

	public void setObservHabjur(String observHabjur) {
		this.observHabjur = observHabjur;
	}

	public Habilidade getHabilidade() {
		return this.habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public Jurado getJurado() {
		return this.jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

}