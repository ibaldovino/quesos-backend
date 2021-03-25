package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the TIPOLECHE database table.
 * 
 */
@Entity
//@Table(name="TIPOLECHE")
@NamedQuery(name="Tipoleche.findAll", query="SELECT t FROM Tipoleche t ORDER BY t.idTiplec")
public class Tipoleche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_tipol", sequenceName="seq_ID_TIPLEC", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_tipol")
	@Column(name="ID_TIPLEC")
	private long idTiplec;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="REFERENCIA")
	private String referencia;

	/*
	 * //bi-directional many-to-one association to Queso
	 * 
	 * @OneToMany(mappedBy="tipoleche") private List<Queso> quesos;
	 */

	public Tipoleche() {
	}

	public long getIdTiplec() {
		return this.idTiplec;
	}

	public void setIdTiplec(long idTiplec) {
		this.idTiplec = idTiplec;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * queso.setTipoleche(this);
	 * 
	 * return queso; }
	 * 
	 * public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	 * queso.setTipoleche(null);
	 * 
	 * return queso; }
	 */

}