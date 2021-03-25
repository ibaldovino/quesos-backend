package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the JURACATEG database table.
 * 
 */
@Entity
@NamedQuery(name="Juracateg.findAll", query="SELECT j FROM Juracateg j")
public class Juracateg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_jurac", sequenceName="seq_ID_JURCAT", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_jurac")
	@Column(name="ID_JURCAT")
	private long idJurcat;

	@Column(name="OBSERV_JURCAT")
	private String observJurcat;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="ID_CATEG")
	private Categoria categoria;

	//bi-directional many-to-one association to Jurado
	@ManyToOne
	@JoinColumn(name="ID_JURADO")
	private Jurado jurado;

	public Juracateg() {
	}

	public long getIdJurcat() {
		return this.idJurcat;
	}

	public void setIdJurcat(long idJurcat) {
		this.idJurcat = idJurcat;
	}

	public String getObservJurcat() {
		return this.observJurcat;
	}

	public void setObservJurcat(String observJurcat) {
		this.observJurcat = observJurcat;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Jurado getJurado() {
		return this.jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

}