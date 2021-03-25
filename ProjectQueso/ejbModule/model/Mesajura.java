package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MESAJURA database table.
 * 
 */
@Entity
@NamedQuery(name="Mesajura.findAll", query="SELECT m FROM Mesajura m")
public class Mesajura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_mesaj", sequenceName="seq_ID_MESAJUR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_mesaj")
	@Column(name="ID_MESJUR")
	private long idMesjur;
	
	@Column(name="FUNCION")
	private String funcion;

	@Column(name="OBSERV_MESJUR")
	private String observMesjur;

	//bi-directional many-to-one association to Jurado
	@ManyToOne
	@JoinColumn(name="ID_JURADO")
	private Jurado jurado;

	//bi-directional many-to-one association to Mesa
	@ManyToOne
	@JoinColumn(name="ID_MESA")
	private Mesa mesa;

	public Mesajura() {
	}

	public long getIdMesjur() {
		return this.idMesjur;
	}

	public void setIdMesjur(long idMesjur) {
		this.idMesjur = idMesjur;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getObservMesjur() {
		return this.observMesjur;
	}

	public void setObservMesjur(String observMesjur) {
		this.observMesjur = observMesjur;
	}

	public Jurado getJurado() {
		return this.jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}