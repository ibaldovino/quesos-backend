package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EVALUACIONES database table.
 * 
 */
@Entity
@Table(name="EVALUACIONES")
@NamedQuery(name="Evaluacione.findAll", query="SELECT e FROM Evaluacione e")
public class Evaluacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_eva", sequenceName="seq_ID_EVALUACION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_eva")
	@Column(name="ID_EVALUACION")
	private long idEvaluacion;

	@Column(name="FECHA_EVAL")
	private String fechaEval;

	@Column(name="HORA_EVAL")
	private String horaEval;

	@Column(name="OBSERVAC_EVALUAC")
	private String observacEvaluac;

	@Column(name="TIPO_PLANILLA")
	private String tipoPlanilla;

	@Column(name="VALOR_EVALUAC")
	private BigDecimal valorEvaluac;

	//bi-directional many-to-one association to Evadescrip
	@ManyToOne
	@JoinColumn(name="ID_DESCRIPT")
	private Evadescrip evadescrip;

	//bi-directional many-to-one association to Jurado
	@ManyToOne
	@JoinColumn(name="ID_JURADO")
	private Jurado jurado;

	//bi-directional many-to-one association to Mesa
	@ManyToOne
	@JoinColumn(name="ID_MESA")
	private Mesa mesa;

	//bi-directional many-to-one association to Queso
	@ManyToOne
	@JoinColumn(name="ID_QUESO")
	private Queso queso;

	public Evaluacione() {
	}

	public long getIdEvaluacion() {
		return this.idEvaluacion;
	}

	public void setIdEvaluacion(long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public String getFechaEval() {
		return this.fechaEval;
	}

	public void setFechaEval(String fechaEval) {
		this.fechaEval = fechaEval;
	}

	public String getHoraEval() {
		return this.horaEval;
	}

	public void setHoraEval(String horaEval) {
		this.horaEval = horaEval;
	}

	public String getObservacEvaluac() {
		return this.observacEvaluac;
	}

	public void setObservacEvaluac(String observacEvaluac) {
		this.observacEvaluac = observacEvaluac;
	}

	public String getTipoPlanilla() {
		return this.tipoPlanilla;
	}

	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	public BigDecimal getValorEvaluac() {
		return this.valorEvaluac;
	}

	public void setValorEvaluac(BigDecimal valorEvaluac) {
		this.valorEvaluac = valorEvaluac;
	}

	public Evadescrip getEvadescrip() {
		return this.evadescrip;
	}

	public void setEvadescrip(Evadescrip evadescrip) {
		this.evadescrip = evadescrip;
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

	public Queso getQueso() {
		return this.queso;
	}

	public void setQueso(Queso queso) {
		this.queso = queso;
	}

}