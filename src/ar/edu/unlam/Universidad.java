package ar.edu.unlam;

import java.util.ArrayList;

public class Universidad {
	
	private String nombre;
	private ArrayList<Alumno> arrayAlumnos = new ArrayList<>();
	private ArrayList<Aula> arrayAulas = new ArrayList<>();
	private ArrayList<Materia> arrayMaterias = new ArrayList<>();
	private ArrayList<Profesor> arrayProfesores = new ArrayList<>(); 
	private ArrayList<AsignarCursoAlumno> arrayHistorialDeCursadas = new ArrayList<>();
	
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
		
		if(alumnoRegistrado(alumnoAIngresar)==true) {
			duplicado=true;
		}
		
		if(arrayAlumnos.size()==0 || !duplicado) {
			this.arrayAlumnos.add(alumnoAIngresar);
			pudoIngresar=true;
		}

		return pudoIngresar;
	}
	
	
	public Integer alumnosTotales(){
		return arrayAlumnos.size();
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
		
		if(materiaRegistrada(nuevaMateria)==true) {
			codigoDuplicado=true;
		}
		
		if(arrayMaterias.size()==0 || !codigoDuplicado) {
			this.arrayMaterias.add(nuevaMateria);
			pudoIngresar=true;
		}
		
		return pudoIngresar;
	}
	

	public Integer cantidadMaterias() {	
		return this.arrayMaterias.size();

	}
	
	
	public boolean materiaRegistrada(Materia materia){
		boolean existe=false;
		Integer codigoDeMateria=materia.getCodigoDeMateria();
		Materia materiaBuscada=buscarMateriaPorCodigo(codigoDeMateria);
		if(materiaBuscada!=null) {
			existe=true;
		}
		return existe;
		
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
	
	
	public boolean eliminarCorrelativa(Integer idMateria, Integer idMateriaCorrelativa){
		boolean seEliminoCorrectamente=false;
		Materia materia = this.buscarMateriaPorCodigo(idMateria);
		Materia materiaAEliminar = this.buscarMateriaPorCodigo(idMateriaCorrelativa);
		
		if (materiaAEliminar != null && materia != null) {
			materia.eliminarMateriaCorrelativaPorCodigoDeMateria(idMateriaCorrelativa);
			seEliminoCorrectamente=true;
		}
		return seEliminoCorrectamente;
	}
	
	
	public void ingresarHistorialDeCursadas(Alumno alumno, Curso curso){
		if(alumnoRegistrado(alumno)==true) {
			AsignarCursoAlumno historialDeCursada = new AsignarCursoAlumno(alumno, curso);
			arrayHistorialDeCursadas.add(historialDeCursada);
		}
	}
	
	public Integer totalDeHistorialGuardado() {
		return arrayHistorialDeCursadas.size();
	}
	
	
	public Integer obtenerNotaFinal(Integer dniAlumno, Integer idMateria){
		Integer notaFinal=null;
		
		if(buscarAlumnoPorDni(dniAlumno)!=null && buscarMateriaPorCodigo(idMateria)!=null){
			
			Materia materia=buscarMateriaPorCodigo(idMateria);
			ArrayList<Curso> arrayDeCursos=materia.getArrayDeCursos();
			Curso cursoDeLaMateria=null;
			Curso cursoEncontrado=null;
			
			
			//aca busco el curso en el que se encuentra el alumno
			for(int i=0; i<arrayDeCursos.size(); i++){
				cursoDeLaMateria=arrayDeCursos.get(i);	
				for(int j=0; j<cursoDeLaMateria.getArrayDeAlumnos().size(); j++){
					if(cursoDeLaMateria.getArrayDeAlumnos().get(i).getDni().equals(dniAlumno)){
						cursoEncontrado=cursoDeLaMateria;
					}
				}	
			}
			
			//aca ya tengo el curso y el alumno entonces busco en el historial de la carrera con ambos datos
			for(int i=0; i<totalDeHistorialGuardado(); i++){
				if(arrayHistorialDeCursadas.get(i).getAlumno().getDni().equals(dniAlumno) && arrayHistorialDeCursadas.get(i).getCurso().getCodigoCurso().equals(cursoEncontrado.getCodigoCurso())){
					notaFinal=arrayHistorialDeCursadas.get(i).getNotaFinal();
				}
			}
			
		}
		return notaFinal;
	}
	
	
}
