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
	
	
	public void ingresarHistorialDeCursadas(AsignarCursoAlumno historialDeCursada){
			this.arrayHistorialDeCursadas.add(historialDeCursada);
	}
	
	public Integer totalDeHistorialGuardado() {
		return this.arrayHistorialDeCursadas.size();
	}
	
	private AsignarCursoAlumno buscarAlumnoYCursoAsosiados(Integer dniAlumno, Integer codigoCurso){
		AsignarCursoAlumno alumnoAsignado=null;
		//aca ya tengo el curso y el alumno entonces busco en el historial de la carrera con ambos datos
			for(int i=0; i<totalDeHistorialGuardado(); i++){
				if(this.arrayHistorialDeCursadas.get(i).getAlumno().getDni().equals(dniAlumno) && this.arrayHistorialDeCursadas.get(i).getCurso().getCodigoCurso().equals(codigoCurso)){
					alumnoAsignado=this.arrayHistorialDeCursadas.get(i);
				}
			}
		
		return alumnoAsignado;
		
	}
	
	
	public Integer obtenerNotaFinal(Integer dniAlumno, Integer idMateria){
		Integer notaFinal=null;
		
		if(buscarAlumnoPorDni(dniAlumno)!=null && buscarMateriaPorCodigo(idMateria)!=null){
			
			Materia materia=buscarMateriaPorCodigo(idMateria);
			ArrayList<Curso> arrayDeCursos=materia.getArrayDeCursos();
			Curso cursoDeLaMateria=null;
			AsignarCursoAlumno cursoAlumnoEncontrado=null;
			
			
			//aca busco el curso en el que se encuentra el alumno
			for(int i=0; i<arrayDeCursos.size(); i++){
				cursoDeLaMateria=arrayDeCursos.get(i);	
				for(int j=0; j<cursoDeLaMateria.getArrayDeAlumnos().size(); j++){
					if(cursoDeLaMateria.getArrayDeAlumnos().get(j).getDni().equals(dniAlumno)){
						break;
					}
				}	
			}
			
			cursoAlumnoEncontrado=buscarAlumnoYCursoAsosiados(dniAlumno,cursoDeLaMateria.getCodigoCurso());
			if(cursoAlumnoEncontrado!=null) {
				notaFinal=cursoAlumnoEncontrado.getNotaFinal();
			}
			
		}
		return notaFinal;
	}
	
	public ArrayList<Materia> obtenerMateriasAprobada(Integer dniAlumno){
		ArrayList<Materia> materiasAprobadas = new ArrayList<Materia>();
		Materia materiaAprobada;
		ArrayList<Curso> arrayDeCursos=null;
		Curso cursoDeLaMateria=null;
		Integer codigoDeCursoEncontrado=null;
		
		estadoDeLaCursada estado= null;
		
		//busco en todas las materias dentro de todos los cursos a el alumno y verifico si el alumno esta aprobado o no 
		for(int i=0; i<cantidadMaterias(); i++){
			arrayDeCursos=this.arrayMaterias.get(i).getArrayDeCursos();
			
			for(int j=0; j<arrayDeCursos.size(); j++){
				cursoDeLaMateria=arrayDeCursos.get(j);	
				
				for(int m=0; m<cursoDeLaMateria.getArrayDeAlumnos().size(); m++){//vemos el array de alumnos
					Alumno alumno=cursoDeLaMateria.getArrayDeAlumnos().get(m);
					
					if(alumno.getDni().equals(dniAlumno)){//si encontramos al alumno en el curso guardamos el codigo de cursada para buscar en la clase asginaralumnocurso						
						codigoDeCursoEncontrado=cursoDeLaMateria.getCodigoCurso();
						
						AsignarCursoAlumno alumnoAsignado=buscarAlumnoYCursoAsosiados(dniAlumno, codigoDeCursoEncontrado);
						estado=alumnoAsignado.getEstadoDeLaCursada();
						boolean condicionDeAprobado= (estado==estadoDeLaCursada.AFinal || estado==estadoDeLaCursada.FinalAPROBADO || estado==estadoDeLaCursada.PROMOCIONADO);
							
						if(alumnoAsignado!=null && condicionDeAprobado==true){				
							materiaAprobada=this.arrayMaterias.get(i);
							materiasAprobadas.add(materiaAprobada);//aca esta el problema hace todo el bucle bien pero no se guarda en el array
						}
					}
				}			
			}
		}
		
		return materiasAprobadas;
		
	}
	
	public Integer obtenerPromedioDeNotas(Integer dniAlumno) {
		ArrayList<Materia> materiasAprobadasPorAlumno=obtenerMateriasAprobada(dniAlumno);
		Integer promedioDeNotas=0;
		Integer cantidadDeMateriasConFinalAprobado=0;
		ArrayList<Curso> CursoDeMateriasDondeAproboElAlumno=new ArrayList<Curso>();
		
		//buscamos el curso en el que esta el alumno
		for(int i=0; i<materiasAprobadasPorAlumno.size();i++) {
			for(int j=0; j<materiasAprobadasPorAlumno.get(i).getCantidadDeCursos(); j++){
				for(int m=0; m<materiasAprobadasPorAlumno.get(i).getArrayDeCursos().get(j).getArrayDeAlumnos().size();m++) {
					if(materiasAprobadasPorAlumno.get(i).getArrayDeCursos().get(j).getArrayDeAlumnos().get(m).getDni().equals(dniAlumno)){
						CursoDeMateriasDondeAproboElAlumno.add(materiasAprobadasPorAlumno.get(i).getArrayDeCursos().get(j));
					}
				}
				
			}
		}
		System.out.println("vemos la materia: "+CursoDeMateriasDondeAproboElAlumno);
		
		for(int i=0;i<materiasAprobadasPorAlumno.size();i++) {
			AsignarCursoAlumno alumnoAsignado=buscarAlumnoYCursoAsosiados(dniAlumno, CursoDeMateriasDondeAproboElAlumno.get(i).getCodigoCurso());
			if(alumnoAsignado.getNotaFinal()>=4 && materiasAprobadasPorAlumno!=null) {
				promedioDeNotas+=alumnoAsignado.getNotaFinal();
				cantidadDeMateriasConFinalAprobado++;
			}	
		}
		
		promedioDeNotas=promedioDeNotas/cantidadDeMateriasConFinalAprobado;
		
		
		return promedioDeNotas;
	}
	
}
