package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVADESCRIP database table.
 * 
 */
@Entity
@NamedQuery(name="Evadescrip.findAll", query="SELECT e FROM Evadescrip e")
public class Evadescrip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_evdes", sequenceName="seq_ID_DESCRIPT", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_evdes")
	@Column(name="ID_DESCRIPT")
	private long idDescript;

	@Column(name="DESCR_DESCRIPT")
	private String descrDescript;

	//bi-directional many-to-one association to Evatipo
	@ManyToOne
	@JoinColumn(name="ID_EVATIPO")
	private Evatipo evatipo;

	/*
	 * //bi-directional many-to-one association to Evaluacione
	 * 
	 * @OneToMany(mappedBy="evadescrip") private List<Evaluacione> evaluaciones;
	 */

	public Evadescrip() {
	}

	public long getIdDescript() {
		return this.idDescript;
	}

	public void setIdDescript(long idDescript) {
		this.idDescript = idDescript;
	}

	public String getDescrDescript() {
		return this.descrDescript;
	}

	public void setDescrDescript(String descrDescript) {
		this.descrDescript = descrDescript;
	}

	public Evatipo getEvatipo() {
		return this.evatipo;
	}

	public void setEvatipo(Evatipo evatipo) {
		this.evatipo = evatipo;
	}

	/*
	 * public List<Evaluacione> getEvaluaciones() { return this.evaluaciones; }
	 * 
	 * public void setEvaluaciones(List<Evaluacione> evaluaciones) {
	 * this.evaluaciones = evaluaciones; }
	 * 
	 * public Evaluacione addEvaluacione(Evaluacione evaluacione) {
	 * getEvaluaciones().add(evaluacione); evaluacione.setEvadescrip(this);
	 * 
	 * return evaluacione; }
	 * 
	 * public Evaluacione removeEvaluacione(Evaluacione evaluacione) {
	 * getEvaluaciones().remove(evaluacione); evaluacione.setEvadescrip(null);
	 * 
	 * return evaluacione; }
	 */

}