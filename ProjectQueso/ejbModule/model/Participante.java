package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the PARTICIPANTES database table.
 * 
 */
@Entity
@Table(name="PARTICIPANTES")
@NamedQuery(name="Participante.findAll", query="SELECT p FROM Participante p")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_parti", sequenceName="seq_ID_PARTI", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_parti")
	@Column(name="ID_PART")
	private long idPart;

	@Column(name="APELLIDO_PART")
	private String apellidoPart;

	@Column(name="COD_PART")
	private String codPart;

	@Column(name="DIRECCION_PART")
	private String direccionPart;

	@Column(name="EMPRESA_PART")
	private String empresaPart;

	@Column(name="MAIL_PART")
	private String mailPart;

	@Column(name="NOMBRE_PART")
	private String nombrePart;

	@Column(name="RUC_PART")
	private String rucPart;

	@Column(name="TELEFONO_PART")
	private String telefonoPart;

	/*
	 * //bi-directional many-to-one association to Inscripcione
	 * 
	 * @OneToMany(mappedBy="participante") private List<Inscripcione> inscripciones;
	 */

	//bi-directional many-to-one association to Localidade
	@ManyToOne
	@JoinColumn(name="ID_LOCAL")
	private Localidade localidade;

	//bi-directional many-to-one association to Tipindustria
	@ManyToOne
	@JoinColumn(name="ID_TIPIND")
	private Tipindustria tipindustria;

	public Participante() {
	}

	public long getIdPart() {
		return this.idPart;
	}

	public void setIdPart(long idPart) {
		this.idPart = idPart;
	}

	public String getApellidoPart() {
		return this.apellidoPart;
	}

	public void setApellidoPart(String apellidoPart) {
		this.apellidoPart = apellidoPart;
	}

	public String getCodPart() {
		return this.codPart;
	}

	public void setCodPart(String codPart) {
		this.codPart = codPart;
	}

	public String getDireccionPart() {
		return this.direccionPart;
	}

	public void setDireccionPart(String direccionPart) {
		this.direccionPart = direccionPart;
	}

	public String getEmpresaPart() {
		return this.empresaPart;
	}

	public void setEmpresaPart(String empresaPart) {
		this.empresaPart = empresaPart;
	}

	public String getMailPart() {
		return this.mailPart;
	}

	public void setMailPart(String mailPart) {
		this.mailPart = mailPart;
	}

	public String getNombrePart() {
		return this.nombrePart;
	}

	public void setNombrePart(String nombrePart) {
		this.nombrePart = nombrePart;
	}

	public String getRucPart() {
		return this.rucPart;
	}

	public void setRucPart(String rucPart) {
		this.rucPart = rucPart;
	}

	public String getTelefonoPart() {
		return this.telefonoPart;
	}

	public void setTelefonoPart(String telefonoPart) {
		this.telefonoPart = telefonoPart;
	}

	/*
	 * public List<Inscripcione> getInscripciones() { return this.inscripciones; }
	 * 
	 * public void setInscripciones(List<Inscripcione> inscripciones) {
	 * this.inscripciones = inscripciones; }
	 * 
	 * public Inscripcione addInscripcione(Inscripcione inscripcione) {
	 * getInscripciones().add(inscripcione); inscripcione.setParticipante(this);
	 * 
	 * return inscripcione; }
	 * 
	 * public Inscripcione removeInscripcione(Inscripcione inscripcione) {
	 * getInscripciones().remove(inscripcione); inscripcione.setParticipante(null);
	 * 
	 * return inscripcione; }
	 */

	public Localidade getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Tipindustria getTipindustria() {
		return this.tipindustria;
	}

	public void setTipindustria(Tipindustria tipindustria) {
		this.tipindustria = tipindustria;
	}

}