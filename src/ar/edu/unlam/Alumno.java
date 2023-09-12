package ar.edu.unlam;

public class Alumno {
	
	private String nombre;
	private Integer dni;
	private String apellido;
	

	public Alumno(Integer dni, String apellido, String nombre) {
		this.dni=dni;
		this.apellido=apellido;
		this.nombre=nombre;
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	
}
