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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
