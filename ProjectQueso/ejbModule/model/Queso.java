package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the QUESOS database table.
 * 
 */
@Entity
@Table(name = "QUESOS")
@NamedQuery(name = "Queso.findAll", query = "SELECT q FROM Queso q ORDER BY q.idQueso")
public class Queso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_qs", sequenceName="seq_ID_QUESO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_qs")
	@Column(name = "ID_QUESO")
	private Long idQueso;

	@Column(name = "CATEGENCONCUR")
	private String categenconcur;

	@Column(name = "CODIGO_AUTO")
	private String codigoAuto;

	@Column(name = "DESCAUTOM")
	private String descautom;

	@Column(name = "DESCMANUAL")
	private String descmanual;

	// bi-directional many-to-one association to Evaluacione
	/*
	 * @OneToMany(mappedBy="queso",fetch=FetchType.EAGER)
	 * 
	 * @OrderColumn(name="ID_EVALUACION") private List<Evaluacione> evaluaciones;
	 * 
	 * //bi-directional many-to-one association to Inscripcione
	 * 
	 * @OneToMany(mappedBy="queso",fetch=FetchType.EAGER)
	 * 
	 * @OrderColumn(name="ID_INSC") private List<Inscripcione> inscripciones;
	 */
	// bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name = "ID_CATEG")
	private Categoria categoria;

	// bi-directional many-to-one association to Humedad
	@ManyToOne
	@JoinColumn(name = "ID_HUMED")
	private Humedad humedad;

	// bi-directional many-to-one association to Maduracion
	@ManyToOne
	@JoinColumn(name = "ID_MADUR")
	private Maduracion maduracion;

	// bi-directional many-to-one association to Subcatego
	@ManyToOne
	@JoinColumn(name = "ID_SUBCATEG")
	private Subcatego subcatego;

	// bi-directional many-to-one association to Tecnologia
	@ManyToOne
	@JoinColumn(name = "ID_TECNO")
	private Tecnologia tecnologia;

	// bi-directional many-to-one association to Tipoleche
	@ManyToOne
	@JoinColumn(name = "ID_TIPLEC")
	private Tipoleche tipoleche;

	// bi-directional many-to-one association to Variedad
	@ManyToOne
	@JoinColumn(name = "ID_VAR")
	private Variedad variedad;

	public Queso() {
	}

	public long getIdQueso() {
		return this.idQueso;
	}

	public void setIdQueso(long idQueso) {
		this.idQueso = idQueso;
	}

	public String getCategenconcur() {
		return this.categenconcur;
	}

	public void setCategenconcur(String categenconcur) {
		this.categenconcur = categenconcur;
	}

	public String getCodigoAuto() {
		return this.codigoAuto;
	}

	public void setCodigoAuto(String codigoAuto) {
		this.codigoAuto = codigoAuto;
	}

	public String getDescautom() {
		return this.descautom;
	}

	public void setDescautom(String descautom) {
		this.descautom = descautom;
	}

	public String getDescmanual() {
		return this.descmanual;
	}

	public void setDescmanual(String descmanual) {
		this.descmanual = descmanual;
	}

	/*
	 * public List<Evaluacione> getEvaluaciones() { return this.evaluaciones; }
	 * 
	 * public void setEvaluaciones(List<Evaluacione> evaluaciones) {
	 * this.evaluaciones = evaluaciones; }
	 * 
	 * 
	 * public Evaluacione addEvaluacione(Evaluacione evaluacione) {
	 * getEvaluaciones().add(evaluacione); evaluacione.setQueso(this);
	 * 
	 * return evaluacione; }
	 * 
	 * public Evaluacione removeEvaluacione(Evaluacione evaluacione) {
	 * getEvaluaciones().remove(evaluacione); evaluacione.setQueso(null);
	 * 
	 * return evaluacione; }
	 * 
	 * public List<Inscripcione> getInscripciones() { return this.inscripciones; }
	 * 
	 * public void setInscripciones(List<Inscripcione> inscripciones) {
	 * this.inscripciones = inscripciones; }
	 * 
	 * public Inscripcione addInscripcione(Inscripcione inscripcione) {
	 * getInscripciones().add(inscripcione); inscripcione.setQueso(this);
	 * 
	 * return inscripcione; }
	 * 
	 * public Inscripcione removeInscripcione(Inscripcione inscripcione) {
	 * getInscripciones().remove(inscripcione); inscripcione.setQueso(null);
	 * 
	 * return inscripcione; }
	 */
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Humedad getHumedad() {
		return this.humedad;
	}

	public void setHumedad(Humedad humedad) {
		this.humedad = humedad;
	}

	public Maduracion getMaduracion() {
		return this.maduracion;
	}

	public void setMaduracion(Maduracion maduracion) {
		this.maduracion = maduracion;
	}

	public Subcatego getSubcatego() {
		return this.subcatego;
	}

	public void setSubcatego(Subcatego subcatego) {
		this.subcatego = subcatego;
	}

	public Tecnologia getTecnologia() {
		return this.tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Tipoleche getTipoleche() {
		return this.tipoleche;
	}

	public void setTipoleche(Tipoleche tipoleche) {
		this.tipoleche = tipoleche;
	}

	public Variedad getVariedad() {
		return this.variedad;
	}

	public void setVariedad(Variedad variedad) {
		this.variedad = variedad;
	}

}