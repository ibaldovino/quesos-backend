package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;



/**
 * The persistent class for the EVATIPO database table.
 * 
 */
@Entity
@NamedQuery(name="Evatipo.findAll", query="SELECT e FROM Evatipo e")
public class Evatipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_evat", sequenceName="seq_ID_EVATIPO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_evat")
	@Column(name="ID_EVATIPO")
	private long idEvatipo;

	@Column(name="DESCR_TIPEVA")
	private String descrTipeva;

	@Column(name="ORDEN_EVAL")
	private BigDecimal ordenEval;

	@Column(name="TIPOEVAL")
	private BigDecimal tipoeval;

	/*
	 * //bi-directional many-to-one association to Evadescrip
	 * 
	 * @OneToMany(mappedBy="evatipo") private List<Evadescrip> evadescrips;
	 */

	public Evatipo() {
	}

	public long getIdEvatipo() {
		return this.idEvatipo;
	}

	public void setIdEvatipo(long idEvatipo) {
		this.idEvatipo = idEvatipo;
	}

	public String getDescrTipeva() {
		return this.descrTipeva;
	}

	public void setDescrTipeva(String descrTipeva) {
		this.descrTipeva = descrTipeva;
	}

	public BigDecimal getOrdenEval() {
		return this.ordenEval;
	}

	public void setOrdenEval(BigDecimal ordenEval) {
		this.ordenEval = ordenEval;
	}

	public BigDecimal getTipoeval() {
		return this.tipoeval;
	}

	public void setTipoeval(BigDecimal tipoeval) {
		this.tipoeval = tipoeval;
	}

	/*
	 * public List<Evadescrip> getEvadescrips() { return this.evadescrips; }
	 * 
	 * public void setEvadescrips(List<Evadescrip> evadescrips) { this.evadescrips =
	 * evadescrips; }
	 * 
	 * public Evadescrip addEvadescrip(Evadescrip evadescrip) {
	 * getEvadescrips().add(evadescrip); evadescrip.setEvatipo(this);
	 * 
	 * return evadescrip; }
	 * 
	 * public Evadescrip removeEvadescrip(Evadescrip evadescrip) {
	 * getEvadescrips().remove(evadescrip); evadescrip.setEvatipo(null);
	 * 
	 * return evadescrip; }
	 */

}