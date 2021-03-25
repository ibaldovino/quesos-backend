package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the VARIEDAD database table.
 * 
 */
@Entity
//@Table(name="VARIEDAD")
@NamedQuery(name="Variedad.findAll", query="SELECT v FROM Variedad v ORDER BY v.idVar")
public class Variedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_var", sequenceName="seq_ID_VAR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_var")
	@Column(name="ID_VAR")
	private Long idVar;

	@Column(name="NOMBRE_VAR")
	private String nombreVar;

	@Column(name="REFERENCIA")
	private String referencia;

	/*
	 * //bi-directional many-to-one association to Queso
	 * 
	 * @OneToMany(mappedBy="variedad") private List<Queso> quesos;
	 */

	public Variedad() {
	}

	public Long getIdVar() {
		return this.idVar;
	}

	public void setIdVar(Long idVar) {
		this.idVar = idVar;
	}

	public String getNombreVar() {
		return this.nombreVar;
	}

	public void setNombreVar(String nombreVar) {
		this.nombreVar = nombreVar;
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
	 * queso.setVariedad(this);
	 * 
	 * return queso; }
	 * 
	 * public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	 * queso.setVariedad(null);
	 * 
	 * return queso; }
	 */

}