package ar.edu.unlam;

import java.util.ArrayList;
 
public class Materia {

	private String nombre;
	private Integer codigoDeMateria;
	private ArrayList<Curso> arrayDeCurso = new ArrayList<>();
	private ArrayList<Materia> arrayDeMateriasCorrelativas = new ArrayList<>();
	
	public Materia(String nombre, Integer codigoDeMateria) {
		this.nombre = nombre;
		this.codigoDeMateria=codigoDeMateria;
		
	}
	
	public String getNombreMateria() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Integer getCodigoDeMateria() {
		return codigoDeMateria;
	}

	public void setCodigoDeMateria(Integer codigoDeMateria) {
		this.codigoDeMateria = codigoDeMateria;
	}
	

	public void ingresarCurso(Curso curso){
		this.arrayDeCurso.add(curso);
	}
	
	public Integer getCantidadDeCursos(){
		return this.arrayDeCurso.size();
	}
	
	public Materia buscarMateriaCorrelativaPorCodigoDeMateria(Integer codigoDeMateriaCorrelativa) {
		Materia materiaBuscada=null;
		for(int i=0; i<this.arrayDeMateriasCorrelativas.size(); i++) {
			if(this.arrayDeMateriasCorrelativas.get(i).getCodigoDeMateria().equals(codigoDeMateriaCorrelativa)){
				materiaBuscada=this.arrayDeMateriasCorrelativas.get(i);
			}
		}
		
		return materiaBuscada;
		
	}

	public void ingresarMateriaCorrelativa(Materia materiaCorrelativa) {
		this.arrayDeMateriasCorrelativas.add(materiaCorrelativa);
	}
	
	public Integer cantidadDeMateriasCorrelativas(){
		return this.arrayDeMateriasCorrelativas.size();
	}
	
	public void eliminarMateriaCorrelativaPorCodigoDeMateria(Integer codigoDeMateriaCorrelativa) {
		Materia materiaAEliminar=buscarMateriaCorrelativaPorCodigoDeMateria(codigoDeMateriaCorrelativa);
		this.arrayDeMateriasCorrelativas.remove(materiaAEliminar);
	}
	
	
}
