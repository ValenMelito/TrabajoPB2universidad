package ar.edu.unlam;

import java.util.ArrayList;

public class Universidad {
	
	private String nombre;
	private ArrayList<Alumno> arrayAlumnos = new ArrayList<>();
	private ArrayList<Aula> arrayAulas = new ArrayList<>();
	private ArrayList<Materia> arrayMaterias = new ArrayList<>();
	
	
	public Universidad(String nombre) {
		this.nombre=nombre;

	}
	
	//universidad.registrarAlumno y universidad.registrarMateria
	public void evaluar(Integer dni, String codigoMateria, Integer nota) {
		
		
	}

	public void ingresarAula(Alumno alumnoAIngresar) {
		this.arrayAlumnos.add(alumnoAIngresar);

	}
	
	public Integer alumnosTotales() {
		return arrayAlumnos.size();
	}

	public Integer dniAlumnoBuscado(Integer dniAlumno){
		Integer dniAlumnoBuscado=null;
		for(int i=0; i<arrayAlumnos.size(); i++) {
			if(arrayAlumnos.get(i)()==)
		}
		//dniAlumnoBuscado=arrayAlumnos.;
		return dniAlumnoBuscado;
		
	}
	
	public void ingresarAlumno(Aula aula) {
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
}
