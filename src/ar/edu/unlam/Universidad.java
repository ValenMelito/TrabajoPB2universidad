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
	//registramos que no se registren dos personas con el mismo dni
	public boolean ingresarAlumno(Alumno alumnoAIngresar) {
		boolean pudoIngresar=false;
		boolean duplicado=false;
		
		if(arrayAlumnos.size()==0) {
			this.arrayAlumnos.add(alumnoAIngresar);
			pudoIngresar=true;
		}
		
		for(int i=0; i<this.arrayAlumnos.size(); i++){
			if(this.arrayAlumnos.get(i).getDni().equals(alumnoAIngresar.getDni())){
				duplicado=true;
			}
		}
		
		if(!duplicado) {
			this.arrayAlumnos.add(alumnoAIngresar);
		}
		return pudoIngresar;
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
	
	public boolean ingresarProfesor(Profesor profesorAIngresar){
		boolean pudoIngresar=false;
		boolean duplicado=false;
		
		if(arrayProfesores.size()==0) {
			this.arrayProfesores.add(profesorAIngresar);
			pudoIngresar=true;
		}
		
		for(int i=0; i<this.arrayProfesores.size(); i++){
			if(this.arrayProfesores.get(i).getDni().equals(profesorAIngresar.getDni())){
				duplicado=true;
			}
		}
		
		if(!duplicado) {
			this.arrayProfesores.add(profesorAIngresar);
		}
		return pudoIngresar;
	}
	
	
	public Integer profesoresTotales() {
		return arrayProfesores.size();
	}
	
	public Profesor buscarProfesorPorDni(Integer dniProfesor){
		Profesor alumnoBuscadoPorDni=null;
		for(int i=0; i<arrayProfesores.size(); i++) {
			if(arrayProfesores.get(i).getDni().equals(dniProfesor)) {
				alumnoBuscadoPorDni=arrayProfesores.get(i);
			}
		}
		return alumnoBuscadoPorDni;
		
	}
	
	public void ingresarAula(Aula aula) {
		this.arrayAulas.add(aula);

	}

	public Integer cantidadAulas() {
		
		return this.arrayAulas.size();

	}
	
	public boolean ingresarMateria(Materia nuevaMateria) {
		boolean pudoIngresar=false;
		boolean codigoDuplicado=false;
		
		if(arrayMaterias.size()==0) {
			this.arrayMaterias.add(nuevaMateria);
			pudoIngresar=true;
		}
		
		for(int i=0; i<this.arrayMaterias.size(); i++){
			if(this.arrayMaterias.get(i).getCodigoDeMateria().equals(nuevaMateria.getCodigoDeMateria())){
				codigoDuplicado=true;
			}
		}
		
		if(codigoDuplicado==false){
			this.arrayMaterias.add(nuevaMateria);
		}
		
		return pudoIngresar;
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
	
	public boolean ingresarMateriaCorrelativa(Integer idMateria, Integer idMateriaCorrelativa){
		boolean seEncontraronLasMaterias=false;
		Materia materiaBuscada=buscarMateriaPorCodigo(idMateria);
		Materia materiaBuscadaParaCorrelativa=buscarMateriaPorCodigo(idMateriaCorrelativa);
		
		if(materiaBuscadaParaCorrelativa != null && materiaBuscada!= null) {
			seEncontraronLasMaterias=true;
			materiaBuscada.ingresarMateriaCorrelativa(materiaBuscadaParaCorrelativa);
		}
		
		return seEncontraronLasMaterias;
	}
	
	
	public Boolean EliminarCorrelativa(Integer idMateria, Integer idMateriaCorrelativa){
		Boolean seEliminoCorrectamente=false;
		Materia materia = this.buscarMateriaPorCodigo(idMateria);
		Materia materiaAEliminar = this.buscarMateriaPorCodigo(idMateriaCorrelativa);
		
		if (materiaAEliminar != null && materia != null) {
			materia.eliminarMateriaCorrelativaPorCodigoDeMateria(idMateriaCorrelativa);
			seEliminoCorrectamente=true;
		}
		return seEliminoCorrectamente;
	}
	
	
}
