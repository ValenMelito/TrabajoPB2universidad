package ar.edu.unlam;

import java.util.ArrayList;

public class Curso {
	private Integer codigoCurso;
	private String nombreMateria;
	private String turno;
	private Integer cuatrimestre;
	private Aula aula;
	private boolean estadoDelCurso;
	private ArrayList<Alumno> arrayDeAlumnos = new ArrayList<>();
	private ArrayList<Profesor> arrayDeProfesores = new ArrayList<>();
	
	
	
	public Curso(Integer codigoCurso, String nombreMateria,String turno, int cuatrimestre) {
		// TODO Auto-generated constructor stub
		this.codigoCurso = codigoCurso;
		this.nombreMateria = nombreMateria;
		this.turno = turno;
		this.cuatrimestre = cuatrimestre;
		this.estadoDelCurso = false;
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
		return this.aula.getIdAula();
	}
	
	public boolean asignarAulaCurso(Aula aula) {
		this.aula=aula;
		setEstadoDelCurso(true);
		return true;
	}

	public void ingresarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		arrayDeProfesores.add(profesor);
	}
	
    public ArrayList<Alumno> getArrayDeAlumnos() {
        return arrayDeAlumnos;
    }

	//registramos que no se registren dos personas con el mismo dni
	public boolean ingresarAlumno(Alumno alumnoAIngresar) {
		//TODO Auto-generated method stub
		boolean pudoIngresar=false;
		boolean duplicado=false;
		if(this.aula.getCapacidadAula()>getArrayDeAlumnos().size()) {//si el aula esta llena ya no se puede ingresar
			
			if(alumnoRegistrado(alumnoAIngresar)==true) {
				duplicado=true;
			}
		
			if(arrayDeAlumnos.size()==0 || !duplicado) {
				this.arrayDeAlumnos.add(alumnoAIngresar);
				pudoIngresar=true;
			}
		}
		
		return pudoIngresar;
	}
	
	
	public Integer alumnosTotales(){
		return arrayDeAlumnos.size();
	}
	
	public boolean alumnoRegistrado(Alumno alumno){
		boolean existe=false;
		Integer dniAlumno=alumno.getDni();
		Alumno alumnoBuscado=buscarAlumnoPorDni(dniAlumno);
		if(alumnoBuscado!=null) {
			existe=true;
		}
		return existe;
		
	}
	public Alumno buscarAlumnoPorDni(Integer dniAlumno){
		Alumno alumnoBuscadoPorDni=null;
		for(int i=0; i<arrayDeAlumnos.size(); i++) {
			if(arrayDeAlumnos.get(i).getDni().equals(dniAlumno)) {
				alumnoBuscadoPorDni=arrayDeAlumnos.get(i);
			}
		}
		return alumnoBuscadoPorDni;
		
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



	@Override
	public String toString() {
		return "Curso [codigoCurso=" + codigoCurso + ", nombreMateria=" + nombreMateria + ", turno=" + turno + "]";
	}
	
	

	
}
