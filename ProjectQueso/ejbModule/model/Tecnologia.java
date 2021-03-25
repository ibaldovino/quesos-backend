package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the TECNOLOGIA database table.
 * 
 */
@Entity
@NamedQuery(name="Tecnologia.findAll", query="SELECT t FROM Tecnologia t")
public class Tecnologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_tec", sequenceName="seq_ID_TECNO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_tec")
	@Column(name="ID_TECNO")
	private long idTecno;

	@Column(name="DESCRIP")
	private String descrip;

	@Column(name="REFERENCIA")
	private String referencia;

	/*
	 * //bi-directional many-to-one association to Queso
	 * 
	 * @OneToMany(mappedBy="tecnologia") private List<Queso> quesos;
	 */

	public Tecnologia() {
	}

	public long getIdTecno() {
		return this.idTecno;
	}

	public void setIdTecno(long idTecno) {
		this.idTecno = idTecno;
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
	 * queso.setTecnologia(this);
	 * 
	 * return queso; }
	 * 
	 * public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	 * queso.setTecnologia(null);
	 * 
	 * return queso; }
	 */

}