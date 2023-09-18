package ar.edu.unlam;

import java.util.ArrayList;

public class Curso {
	private Integer codigoCurso;
	private String nombreMateria;
	private String turno;
	private Integer cuatrimestre;
	private Integer numeroDeAula;
	private boolean estadoDelCurso;
	private ArrayList<Alumno> arrayDeAlumnos = new ArrayList<>();
	private ArrayList<Profesor> arrayDeProfesores = new ArrayList<>();
	
	
	
	public Curso(Integer codigoCurso, String nombreMateria,String turno, int cuatrimestre, Integer numeroDeAula, boolean estadoDelCurso) {
		// TODO Auto-generated constructor stub
		this.codigoCurso = codigoCurso;
		this.nombreMateria = nombreMateria;
		this.turno = turno;
		this.cuatrimestre = cuatrimestre;
		this.numeroDeAula = numeroDeAula;
		this.estadoDelCurso = estadoDelCurso;
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

	public Integer getCuatrimestre() {
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

	public void ingresarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		arrayDeProfesores.add(profesor);
	}

	public void ingresarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		arrayDeAlumnos.add(alumno);
	}
	
	public Integer cantidadDeAlumnosEnCurso(){
		return arrayDeAlumnos.size();
	}
	
	public boolean getEstadoDelCurso() {
		return estadoDelCurso;
	}

	public void setEstadoDelCurso(boolean estadoDelCurso) {
		this.estadoDelCurso = estadoDelCurso;
	}

	public boolean verificarEstadoDelCurso(Curso curso) {
		// TODO Auto-generated method stub
		Integer comparacion = arrayDeAlumnos.size()/arrayDeProfesores.size();
		if(comparacion>20){
			curso.setEstadoDelCurso(false);	
		}
		return curso.getEstadoDelCurso();
	}

	
}
