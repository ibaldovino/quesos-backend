package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INSCRIPCIONES database table.
 * 
 */
@Entity
@Table(name="INSCRIPCIONES")
@NamedQuery(name="Inscripcione.findAll", query="SELECT i FROM Inscripcione i")
public class Inscripcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_inscrip", sequenceName="seq_ID_INSC", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_inscrip")
	@Column(name="ID_INSC")
	private long idInsc;

	@Column(name="FECHA_CTE")
	private String fechaCte;

	@Column(name="FECHA_INSC")
	private String fechaInsc;

	@Column(name="HORA_INSC")
	private String horaInsc;

	@Column(name="NRO_CTE")
	private BigDecimal nroCte;

	@Column(name="OBSERV_INSCRIP")
	private String observInscrip;

	@Column(name="OTROS")
	private String otros;

	@Column(name="SERIE_CTE")
	private String serieCte;

	@Column(name="VALOR_CTE")
	private BigDecimal valorCte;

	//bi-directional many-to-one association to Camara
	@ManyToOne
	@JoinColumn(name="ID_CAM")
	private Camara camara;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	@JoinColumn(name="ID_PART")
	private Participante participante;

	//bi-directional many-to-one association to Queso
	@ManyToOne
	@JoinColumn(name="ID_QUESO")
	private Queso queso;

	public Inscripcione() {
	}

	public long getIdInsc() {
		return this.idInsc;
	}

	public void setIdInsc(long idInsc) {
		this.idInsc = idInsc;
	}

	public String getFechaCte() {
		return this.fechaCte;
	}

	public void setFechaCte(String fechaCte) {
		this.fechaCte = fechaCte;
	}

	public String getFechaInsc() {
		return this.fechaInsc;
	}

	public void setFechaInsc(String fechaInsc) {
		this.fechaInsc = fechaInsc;
	}

	public String getHoraInsc() {
		return this.horaInsc;
	}

	public void setHoraInsc(String horaInsc) {
		this.horaInsc = horaInsc;
	}

	public BigDecimal getNroCte() {
		return this.nroCte;
	}

	public void setNroCte(BigDecimal nroCte) {
		this.nroCte = nroCte;
	}

	public String getObservInscrip() {
		return this.observInscrip;
	}

	public void setObservInscrip(String observInscrip) {
		this.observInscrip = observInscrip;
	}

	public String getOtros() {
		return this.otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getSerieCte() {
		return this.serieCte;
	}

	public void setSerieCte(String serieCte) {
		this.serieCte = serieCte;
	}

	public BigDecimal getValorCte() {
		return this.valorCte;
	}

	public void setValorCte(BigDecimal valorCte) {
		this.valorCte = valorCte;
	}

	public Camara getCamara() {
		return this.camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Queso getQueso() {
		return this.queso;
	}

	public void setQueso(Queso queso) {
		this.queso = queso;
	}

}