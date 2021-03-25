package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the HABILIDADES database table.
 * 
 */
@Entity
@Table(name="HABILIDADES")
@NamedQuery(name="Habilidade.findAll", query="SELECT h FROM Habilidade h")
public class Habilidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_habi", sequenceName="seq_ID_HABILI", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_habi")
	@Column(name="ID_HABILI")
	private long idHabili;

	@Column(name="DES_HABILDAD")
	private String desHabildad;

	/*
	 * //bi-directional many-to-one association to Habijurado
	 * 
	 * @OneToMany(mappedBy="habilidade") private List<Habijurado> habijurados;
	 */

	public Habilidade() {
	}

	public long getIdHabili() {
		return this.idHabili;
	}

	public void setIdHabili(long idHabili) {
		this.idHabili = idHabili;
	}

	public String getDesHabildad() {
		return this.desHabildad;
	}

	public void setDesHabildad(String desHabildad) {
		this.desHabildad = desHabildad;
	}

	/*
	 * public List<Habijurado> getHabijurados() { return this.habijurados; }
	 * 
	 * public void setHabijurados(List<Habijurado> habijurados) { this.habijurados =
	 * habijurados; }
	 * 
	 * public Habijurado addHabijurado(Habijurado habijurado) {
	 * getHabijurados().add(habijurado); habijurado.setHabilidade(this);
	 * 
	 * return habijurado; }
	 * 
	 * public Habijurado removeHabijurado(Habijurado habijurado) {
	 * getHabijurados().remove(habijurado); habijurado.setHabilidade(null);
	 * 
	 * return habijurado; }
	 */

}