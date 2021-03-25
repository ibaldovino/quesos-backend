package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



/**
 * The persistent class for the CATEGORIAS database table.
 * 
 */
@Entity
@Table(name="CATEGORIAS")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c ORDER BY c.idCateg")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_cat", sequenceName="seq_ID_CATEG", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cat")
	@Column(name="ID_CATEG")
	private long idCateg;

	@Column(name="DESCRIP")
	private String descrip;

	@Column(name="IDENT_CATEG")
	private String identCateg;

	@Column(name="REFERENCIA")
	private String referencia;

	
	/*
	 * //bi-directional many-to-one association to Juracateg
	 * 
	 * @OneToMany(mappedBy="categoria",fetch=FetchType.EAGER)
	 * 
	 * @OrderColumn(name="ID_JURCAT") private List<Juracateg> juracategs;
	 * 
	 * //bi-directional many-to-one association to Queso
	 * 
	 * @OneToMany(mappedBy="categoria",fetch=FetchType.EAGER)
	 * 
	 * @OrderColumn(name="ID_QUESO") private List<Queso> quesos;
	 */
	 

	public Categoria() {
	}

	public long getIdCateg() {
		return this.idCateg;
	}

	public void setIdCateg(long idCateg) {
		this.idCateg = idCateg;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getIdentCateg() {
		return this.identCateg;
	}

	public void setIdentCateg(String identCateg) {
		this.identCateg = identCateg;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	
	/*
	 * public List<Juracateg> getJuracategs() { return this.juracategs; }
	 * 
	 * public void setJuracategs(List<Juracateg> juracategs) { this.juracategs =
	 * juracategs; }
	 * 
	 * public Juracateg addJuracateg(Juracateg juracateg) {
	 * getJuracategs().add(juracateg); juracateg.setCategoria(this);
	 * 
	 * return juracateg; }
	 * 
	 * public Juracateg removeJuracateg(Juracateg juracateg) {
	 * getJuracategs().remove(juracateg); juracateg.setCategoria(null);
	 * 
	 * return juracateg; }
	 * 
	 * public List<Queso> getQuesos() { return this.quesos; }
	 * 
	 * public void setQuesos(List<Queso> quesos) { this.quesos = quesos; }
	 * 
	 * public Queso addQueso(Queso queso) { getQuesos().add(queso);
	 * queso.setCategoria(this);
	 * 
	 * return queso; }
	 * 
	 * public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	 * queso.setCategoria(null);
	 * 
	 * return queso; }
	 */
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}