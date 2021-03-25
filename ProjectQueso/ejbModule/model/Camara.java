package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;



/**
 * The persistent class for the CAMARAS database table.
 * 
 */
@Entity
@Table(name="CAMARAS")
@NamedQuery(name="Camara.findAll", query="SELECT c FROM Camara c")
public class Camara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_cam", sequenceName="seq_ID_CAM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cam")
	@Column(name="ID_CAM")
	private long idCam;

	@Column(name="DESC_CORTA_CAM")
	private String descCortaCam;

	@Column(name="DESC_LARGA_CAM")
	private String descLargaCam;

	@Column(name="LUGAR_CAM")
	private String lugarCam;

	@Column(name="NRO_CAM")
	private BigDecimal nroCam;

	@Column(name="TEMPERATURA_CAM")
	private BigDecimal temperaturaCam;

	/*
	 * //bi-directional many-to-one association to Inscripcione
	 * 
	 * @OneToMany(mappedBy="camara") private List<Inscripcione> inscripciones;
	 */

	public Camara() {
	}

	public long getIdCam() {
		return this.idCam;
	}

	public void setIdCam(long idCam) {
		this.idCam = idCam;
	}

	public String getDescCortaCam() {
		return this.descCortaCam;
	}

	public void setDescCortaCam(String descCortaCam) {
		this.descCortaCam = descCortaCam;
	}

	public String getDescLargaCam() {
		return this.descLargaCam;
	}

	public void setDescLargaCam(String descLargaCam) {
		this.descLargaCam = descLargaCam;
	}

	public String getLugarCam() {
		return this.lugarCam;
	}

	public void setLugarCam(String lugarCam) {
		this.lugarCam = lugarCam;
	}

	public BigDecimal getNroCam() {
		return this.nroCam;
	}

	public void setNroCam(BigDecimal nroCam) {
		this.nroCam = nroCam;
	}

	public BigDecimal getTemperaturaCam() {
		return this.temperaturaCam;
	}

	public void setTemperaturaCam(BigDecimal temperaturaCam) {
		this.temperaturaCam = temperaturaCam;
	}

	/*
	 * public List<Inscripcione> getInscripciones() { return this.inscripciones; }
	 * 
	 * public void setInscripciones(List<Inscripcione> inscripciones) {
	 * this.inscripciones = inscripciones; }
	 * 
	 * public Inscripcione addInscripcione(Inscripcione inscripcione) {
	 * getInscripciones().add(inscripcione); inscripcione.setCamara(this);
	 * 
	 * return inscripcione; }
	 * 
	 * public Inscripcione removeInscripcione(Inscripcione inscripcione) {
	 * getInscripciones().remove(inscripcione); inscripcione.setCamara(null);
	 * 
	 * return inscripcione; }
	 */

}