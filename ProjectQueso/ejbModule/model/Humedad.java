package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the HUMEDAD database table.
 * 
 */
@Entity
//@Table(name="HUMEDAD")
@NamedQuery(name="Humedad.findAll", query="SELECT h FROM Humedad h ORDER BY h.idHumed")
public class Humedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_hum", sequenceName="seq_ID_HUMED", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_hum")
	@Column(name="ID_HUMED")
	private long idHumed;

	@Column(name="DESCRIP")
	private String descrip;

	@Column(name="REFERENCIA")
	private String referencia;

	/*
	 * //bi-directional many-to-one association to Queso
	 * 
	 * @OneToMany(mappedBy="humedad") private List<Queso> quesos;
	 */

	public Humedad() {
	}

	public long getIdHumed() {
		return this.idHumed;
	}

	public void setIdHumed(long idHumed) {
		this.idHumed = idHumed;
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
	 * queso.setHumedad(this);
	 * 
	 * return queso; }
	 * 
	 * public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	 * queso.setHumedad(null);
	 * 
	 * return queso; }
	 */

}