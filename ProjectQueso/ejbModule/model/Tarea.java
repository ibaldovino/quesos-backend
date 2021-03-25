package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the TAREAS database table.
 * 
 */
@Entity
@Table(name="TAREAS")
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_tarea", sequenceName="seq_ID_TAREA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_tarea")
	@Column(name="ID_TAREA")
	private long idTarea;

	@Column(name="DESCR_TAREA")
	private String descrTarea;

	/*
	 * //bi-directional many-to-one association to Roltarea
	 * 
	 * @OneToMany(mappedBy="tarea") private List<Roltarea> roltareas;
	 */

	public Tarea() {
	}

	public long getIdTarea() {
		return this.idTarea;
	}

	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

	public String getDescrTarea() {
		return this.descrTarea;
	}

	public void setDescrTarea(String descrTarea) {
		this.descrTarea = descrTarea;
	}

	/*
	 * public List<Roltarea> getRoltareas() { return this.roltareas; }
	 * 
	 * public void setRoltareas(List<Roltarea> roltareas) { this.roltareas =
	 * roltareas; }
	 * 
	 * public Roltarea addRoltarea(Roltarea roltarea) {
	 * getRoltareas().add(roltarea); roltarea.setTarea(this);
	 * 
	 * return roltarea; }
	 * 
	 * public Roltarea removeRoltarea(Roltarea roltarea) {
	 * getRoltareas().remove(roltarea); roltarea.setTarea(null);
	 * 
	 * return roltarea; }
	 */

}