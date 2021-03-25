package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;



/**
 * The persistent class for the TIPINDUSTRIA database table.
 * 
 */
@Entity
@NamedQuery(name="Tipindustria.findAll", query="SELECT t FROM Tipindustria t")
public class Tipindustria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_tipoi", sequenceName="seq_ID_TIPIND", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_tipoi")
	@Column(name="ID_TIPIND")
	private long idTipind;

	@Column(name="DESCR_TIPIND")
	private String descrTipind;

	@Column(name="PRE_INSC_PRI_QUESO")
	private BigDecimal preInscPriQueso;

	@Column(name="PRE_INSC_SEG_QUESO")
	private BigDecimal preInscSegQueso;

	/*
	 * //bi-directional many-to-one association to Participante
	 * 
	 * @OneToMany(mappedBy="tipindustria") private List<Participante> participantes;
	 */

	public Tipindustria() {
	}

	public long getIdTipind() {
		return this.idTipind;
	}

	public void setIdTipind(long idTipind) {
		this.idTipind = idTipind;
	}

	public String getDescrTipind() {
		return this.descrTipind;
	}

	public void setDescrTipind(String descrTipind) {
		this.descrTipind = descrTipind;
	}

	public BigDecimal getPreInscPriQueso() {
		return this.preInscPriQueso;
	}

	public void setPreInscPriQueso(BigDecimal preInscPriQueso) {
		this.preInscPriQueso = preInscPriQueso;
	}

	public BigDecimal getPreInscSegQueso() {
		return this.preInscSegQueso;
	}

	public void setPreInscSegQueso(BigDecimal preInscSegQueso) {
		this.preInscSegQueso = preInscSegQueso;
	}
	/*
	 * public List<Participante> getParticipantes() { return this.participantes; }
	 * 
	 * public void setParticipantes(List<Participante> participantes) {
	 * this.participantes = participantes; }
	 * 
	 * public Participante addParticipante(Participante participante) {
	 * getParticipantes().add(participante); participante.setTipindustria(this);
	 * 
	 * return participante; }
	 * 
	 * public Participante removeParticipante(Participante participante) {
	 * getParticipantes().remove(participante); participante.setTipindustria(null);
	 * 
	 * return participante; }
	 */

}