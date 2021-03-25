package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the PAISES database table.
 * 
 */
@Entity
@Table(name="PAISES")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_pais", sequenceName="seq_ID_PAIS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_pais")
	@Column(name="ID_PAIS")
	private long idPais;

	@Column(name="DESCR_PAIS")
	private String descrPais;

	/*
	 * //bi-directional many-to-one association to Departamento
	 * 
	 * @OneToMany(mappedBy="pais") private List<Departamento> departamentos;
	 */

	public Pais() {
	}

	public long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getDescrPais() {
		return this.descrPais;
	}

	public void setDescrPais(String descrPais) {
		this.descrPais = descrPais;
	}

	/*
	 * public List<Departamento> getDepartamentos() { return this.departamentos; }
	 * 
	 * public void setDepartamentos(List<Departamento> departamentos) {
	 * this.departamentos = departamentos; }
	 * 
	 * public Departamento addDepartamento(Departamento departamento) {
	 * getDepartamentos().add(departamento); departamento.setPais(this);
	 * 
	 * return departamento; }
	 * 
	 * public Departamento removeDepartamento(Departamento departamento) {
	 * getDepartamentos().remove(departamento); departamento.setPais(null);
	 * 
	 * return departamento; }
	 */

}