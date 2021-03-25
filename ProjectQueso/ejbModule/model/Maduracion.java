package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MADURACION database table.
 * 
 */
@Entity
@NamedQuery(name="Maduracion.findAll", query="SELECT m FROM Maduracion m")
public class Maduracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_madura", sequenceName="seq_ID_MADUR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_madura")
	@Column(name="ID_MADUR")
	private long idMadur;

	@Column(name="DESCRIP")
	private String descrip;

	@Column(name="REFERENCIA")
	private String referencia;

	/*
	 * //bi-directional many-to-one association to Queso
	 * 
	 * @OneToMany(mappedBy="maduracion") private List<Queso> quesos;
	 */

	public Maduracion() {
	}

	public long getIdMadur() {
		return this.idMadur;
	}

	public void setIdMadur(long idMadur) {
		this.idMadur = idMadur;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
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
	 * queso.setMaduracion(this);
	 * 
	 * return queso; }
	 * 
	 * public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	 * queso.setMaduracion(null);
	 * 
	 * return queso; }
	 */

}