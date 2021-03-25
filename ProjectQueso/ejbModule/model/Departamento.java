package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the DEPARTAMENTOS database table.
 * 
 */
@Entity
@Table(name="DEPARTAMENTOS")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_dep", sequenceName="seq_ID_DEPTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_dep")
	@Column(name="ID_DEPTO")
	private long idDepto;

	@Column(name="DESCR_DEPTO")
	private String descrDepto;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="ID_PAIS")
	private Pais pais;
	/*
	 * //bi-directional many-to-one association to Localidade
	 * 
	 * @OneToMany(mappedBy="departamento") private List<Localidade> localidades;
	 */

	public Departamento() {
	}

	public long getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(long idDepto) {
		this.idDepto = idDepto;
	}

	public String getDescrDepto() {
		return this.descrDepto;
	}

	public void setDescrDepto(String descrDepto) {
		this.descrDepto = descrDepto;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/*
	 * public List<Localidade> getLocalidades() { return this.localidades; }
	 * 
	 * public void setLocalidades(List<Localidade> localidades) { this.localidades =
	 * localidades; }
	 * 
	 * public Localidade addLocalidade(Localidade localidade) {
	 * getLocalidades().add(localidade); localidade.setDepartamento(this);
	 * 
	 * return localidade; }
	 * 
	 * public Localidade removeLocalidade(Localidade localidade) {
	 * getLocalidades().remove(localidade); localidade.setDepartamento(null);
	 * 
	 * return localidade; }
	 */

}