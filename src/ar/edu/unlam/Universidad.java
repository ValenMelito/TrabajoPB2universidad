package ar.edu.unlam;

import java.util.ArrayList;

public class Universidad {
	
	private String nombre;
	private ArrayList<Alumno> arrayAlumnos = new ArrayList<>();
	private ArrayList<Aula> arrayAulas = new ArrayList<>();
	private ArrayList<Materia> arrayMaterias = new ArrayList<>();
	private ArrayList<Profesor> arrayProfesores = new ArrayList<>(); 
	
	
	public Universidad(String nombre) {
		this.nombre=nombre;

	}
	
	//universidad.registrarAlumno y universidad.registrarMateria
	public void evaluar(Integer dni, String codigoMateria, Integer nota) {
		
		
	}

	public void ingresarAlumno(Alumno alumnoAIngresar) {
		this.arrayAlumnos.add(alumnoAIngresar);

	}
	
	public Integer alumnosTotales(){
		return arrayAlumnos.size();
	}

	public Alumno buscarAlumnoPorDni(Integer dniAlumno){
		Alumno alumnoBuscadoPorDni=null;
		for(int i=0; i<arrayAlumnos.size(); i++) {
			if(arrayAlumnos.get(i).getDni().equals(dniAlumno)) {
				alumnoBuscadoPorDni=arrayAlumnos.get(i);
			}
		}
		return alumnoBuscadoPorDni;
		
	}
	
	public void ingresarProfesor(Profesor profesorAIngresar) {
		this.arrayProfesores.add(profesorAIngresar);
	}
	
	
	public Integer profesoresTotales() {
		return arrayProfesores.size();
	}
	
	public Profesor buscarProfesorPorDni(Integer dniProfesor){
		Profesor alumnoBuscadoPorDni=null;
		for(int i=0; i<arrayProfesores.size(); i++) {
			if(arrayProfesores.get(i).getDniProfesor().equals(dniProfesor)) {
				alumnoBuscadoPorDni=arrayProfesores.get(i);
			}
		}
		return alumnoBuscadoPorDni;
		
	}
	
	public boolean estaElHorarioDisponibleParaProfesor(String dia, String turno) {
		return false;
	}
	
	public void ingresarAula(Aula aula) {
		this.arrayAulas.add(aula);

	}

	public Integer cantidadAulas() {
		
		return this.arrayAulas.size();

	}
	
	public void ingresarMateria(Materia nuevaMateria) {
		this.arrayMaterias.add(nuevaMateria);

	}

	public Integer cantidadMaterias() {	
		return this.arrayMaterias.size();

	}
	
	public Materia buscarMateriaPorCodigo(Integer codigoDeMateria){
		Materia materiaBuscadoPorCodigo=null;
		for(int i=0; i<arrayMaterias.size(); i++) {
			if(arrayMaterias.get(i).getCodigoDeMateria().equals(codigoDeMateria)){
				materiaBuscadoPorCodigo=arrayMaterias.get(i);
			}
		}
		return materiaBuscadoPorCodigo;
		
	}
}
