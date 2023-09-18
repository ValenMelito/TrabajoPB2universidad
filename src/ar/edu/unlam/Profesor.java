package ar.edu.unlam;

import java.util.ArrayList;

public class Profesor {
	
	private String apellido;
	private String nombre;
	private Integer Dni;
	private ArrayList<Curso> cursoQueEnseña= new ArrayList<>();

	public Profesor(String apellido, String nombre, Integer Dni) {
		// TODO Auto-generated constructor stub
		this.apellido = apellido;
		this.nombre = nombre;
		this.Dni = Dni;
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


	public Integer getDni() {
		return Dni;
	}


	public void setDni(Integer dniProfesor) {
		this.Dni = dniProfesor;
	}
	
	//registramos que el profe no puede ingresar si ya tiene una materia en ese dia y horario
	public boolean ingresarCurso(Curso curso){
		boolean pudoRegistrarse=false;
		if(this.cursoQueEnseña.size()==0) {
			this.cursoQueEnseña.add(curso);
			pudoRegistrarse=true;
		}
		for(int i=0; i<this.cursoQueEnseña.size(); i++){
			if((this.cursoQueEnseña.get(i).getTurno()!=curso.getTurno())){
				this.cursoQueEnseña.add(curso);
				pudoRegistrarse=true;
			}
		}
		return pudoRegistrarse;
	}
	
	public Integer getCantidadDeCursos(){
		return this.cursoQueEnseña.size();
	}
	
	
	public boolean estaElHorarioDisponibleParaProfesor(String dia, String turno) {
		
		return false;
	}

}
