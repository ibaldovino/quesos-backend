package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SUBCATEGO database table.
 * 
 */
@Entity
//@Table(name="SUBCATEGO")
@NamedQuery(name="Subcatego.findAll", query="SELECT s FROM Subcatego s ORDER BY s.idSubcateg")
public class Subcatego implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_sb", sequenceName="seq_ID_SUBCATEG", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sb")
	@Column(name="ID_SUBCATEG")
	private Long idSubcateg;

	@Column(name="DESCRIP")
	private String descrip;

	@Column(name="IDENT_SCAT")
	private String identScat;

	@Column(name="REFERENCIA")
	private String referencia;

	/*
	 * //bi-directional many-to-one association to Queso
	 * 
	 * @OneToMany(mappedBy="subcatego", fetch=FetchType.EAGER) private List<Queso>
	 * quesos;
	 */

	public Subcatego() {
	}

	public long getIdSubcateg() {
		return this.idSubcateg;
	}

	public void setIdSubcateg(long idSubcateg) {
		this.idSubcateg = idSubcateg;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getIdentScat() {
		return this.identScat;
	}

	public void setIdentScat(String identScat) {
		this.identScat = identScat;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/*
	 * public List<Queso> getQuesos() { return this.quesos; }
	 * 
	 * public void setQuesos(List<Queso> quesos) { this.quesos = quesos; }
	 * 
	 * public Queso addQueso(Queso queso) { getQuesos().add(queso);
	 * queso.setSubcatego(this);
	 * 
	 * return queso; }
	 * 
	 * public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	 * queso.setSubcatego(null);
	 * 
	 * return queso; }
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}