package ar.edu.unlam;

import java.sql.Date;
import java.time.LocalDate;

public class Alumno {
	
	private String nombre;
	private Integer dni;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private LocalDate fechaDeIngreso;
	

	public Alumno(Integer dni, String apellido, String nombre, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso){
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

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	
}
