package ar.edu.unlam;

import java.sql.Date;

public class Alumno {
	
	private String nombre;
	private Integer dni;
	private String apellido;
	private Date fechaDeNacimiento;
	private Date fechaDeIngreso;
	

	public Alumno(Integer dni, String apellido, String nombre, Date fechaDeNacimiento, Date fechaDeIngreso){
		this.dni=dni;
		this.apellido=apellido;
		this.nombre=nombre;
		this.fechaDeIngreso=fechaDeIngreso;
		this.fechaDeNacimiento=fechaDeNacimiento;
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

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Date getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	
}
