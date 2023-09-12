package ar.edu.unlam;

import java.util.ArrayList;
 
public class Materia {

	private String nombre;
	private ArrayList<Curso> arrayDeCurso = new ArrayList<>();
	
	public Materia(String nombre) {
		this.nombre = nombre;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void ingresarCurso(Curso curso){
		this.arrayDeCurso.add(curso);
	}
	
	public Integer getCantidadDeCursos(){
		return this.arrayDeCurso.size();
	}

	public String getNombreDeCursoEspecifico(Integer lugarDelArray) {
		// TODO Auto-generated method stub
		String identificadorDeCurso=this.arrayDeCurso.get(lugarDelArray).getNombreMateria();
		
		return identificadorDeCurso;
	}
	
	public Integer getIdentificadorDeCursoEspecifico(Integer lugarDelArray) {
		// TODO Auto-generated method stub
		Integer identificadorDeCurso=this.arrayDeCurso.get(lugarDelArray).getCodigoCurso();
		
		return identificadorDeCurso;
	}
	
	
	
	
	
	
	
	
}
