package ar.edu.unlam;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class test_Alumnos {

	@Test
	public void ingresarAlumnos() {
		String nombre="Jorge";
		String apellido="Gomez";
		Integer dni=43408686;
		LocalDate fechaDeNacimiento = LocalDate.parse("2002-01-20");
		LocalDate fechaDeIngreso = LocalDate.parse("2023-08-04");
		//ejecucion
		
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaDeNacimiento,fechaDeIngreso);
		
		//System.out.print(fechaDeIngreso);
		//validacion
		assertNotEquals(alumno.getFechaDeIngreso(),alumno.getFechaDeNacimiento());
	}

}
