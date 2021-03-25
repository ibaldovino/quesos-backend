package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the MESAS database table.
 * 
 */
@Entity
@Table(name="MESAS")
@NamedQuery(name="Mesa.findAll", query="SELECT m FROM Mesa m")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_mesa", sequenceName="seq_ID_MESA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_mesa")
	@Column(name="ID_MESA")
	private long idMesa;

	@Column(name="NOMBRE_MESA")
	private String nombreMesa;

	@Column(name="UBICACION")
	private String ubicacion;

	/*
	 * //bi-directional many-to-one association to Evaluacione
	 * 
	 * @OneToMany(mappedBy="mesa") private List<Evaluacione> evaluaciones;
	 * 
	 * //bi-directional many-to-one association to Mesajura
	 * 
	 * @OneToMany(mappedBy="mesa") private List<Mesajura> mesajuras;
	 */

	public Mesa() {
	}

	public long getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public String getNombreMesa() {
		return this.nombreMesa;
	}

	public void setNombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/*
	 * public List<Evaluacione> getEvaluaciones() { return this.evaluaciones; }
	 * 
	 * public void setEvaluaciones(List<Evaluacione> evaluaciones) {
	 * this.evaluaciones = evaluaciones; }
	 * 
	 * public Evaluacione addEvaluacione(Evaluacione evaluacione) {
	 * getEvaluaciones().add(evaluacione); evaluacione.setMesa(this);
	 * 
	 * return evaluacione; }
	 * 
	 * public Evaluacione removeEvaluacione(Evaluacione evaluacione) {
	 * getEvaluaciones().remove(evaluacione); evaluacione.setMesa(null);
	 * 
	 * return evaluacione; }
	 * 
	 * public List<Mesajura> getMesajuras() { return this.mesajuras; }
	 * 
	 * public void setMesajuras(List<Mesajura> mesajuras) { this.mesajuras =
	 * mesajuras; }
	 * 
	 * public Mesajura addMesajura(Mesajura mesajura) {
	 * getMesajuras().add(mesajura); mesajura.setMesa(this);
	 * 
	 * return mesajura; }
	 * 
	 * public Mesajura removeMesajura(Mesajura mesajura) {
	 * getMesajuras().remove(mesajura); mesajura.setMesa(null);
	 * 
	 * return mesajura; }
	 */

}