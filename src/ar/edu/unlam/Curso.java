package ar.edu.unlam;

public class Curso {
	private Integer codigoCurso;
	private String nombreMateria;
	private String turno;
	private int cuatrimestre;
	private Integer numeroDeAula;
	
	
	
	public Curso(Integer codigoCurso, String nombreMateria, String turno, int cuatrimestre, Integer numeroDeAula) {
		// TODO Auto-generated constructor stub
		this.codigoCurso = codigoCurso;
		this.nombreMateria = nombreMateria;
		this.turno = turno;
		this.cuatrimestre = cuatrimestre;
		this.numeroDeAula = numeroDeAula;
	}



	public Integer getCodigoCurso() {
		return codigoCurso;
	}



	public void setCodigoCurso(Integer codigoCurso) {
		this.codigoCurso = codigoCurso;
	}



	public String getNombreMateria() {
		return nombreMateria;
	}



	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}



	public String getTurno() {
		return turno;
	}



	public void setTurno(String turno) {
		this.turno = turno;
	}



	public int getCuatrimestre() {
		return cuatrimestre;
	}



	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}



	public Integer getNumeroDeAula() {
		return numeroDeAula;
	}



	public void setNumeroDeAula(Integer numeroDeAula) {
		this.numeroDeAula = numeroDeAula;
	}
	

	
}
