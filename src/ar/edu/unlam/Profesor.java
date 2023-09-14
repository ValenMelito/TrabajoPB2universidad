package ar.edu.unlam;

import java.util.ArrayList;

public class Profesor {
	
	private String apellido;
	private String nombre;
	private Integer dniProfesor;
	private ArrayList<Curso> cursoQueEnseña= new ArrayList<>();

	public Profesor(String apellido, String nombre, Integer dniProfesor) {
		// TODO Auto-generated constructor stub
		this.apellido = apellido;
		this.nombre = nombre;
		this.dniProfesor = dniProfesor;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getDniProfesor() {
		return dniProfesor;
	}


	public void setDniProfesor(Integer dniProfesor) {
		this.dniProfesor = dniProfesor;
	}
	
	public void ingresarCurso(Curso curso){
		this.cursoQueEnseña.add(curso);
	}
	
	public Integer getCantidadDeCursos(){
		return this.cursoQueEnseña.size();
	}
	
	
	public boolean estaElHorarioDisponibleParaProfesor(String dia, String turno) {
		
		return false;
	}

}
