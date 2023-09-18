package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class test_Alumnos {

	@Test
	public void ingresarAlumnos() {
		String nombre="Jorge";
		String apellido="Gomez";
		Integer dni=43408686;
		//ejecucion
		
		Alumno alumno = new Alumno(dni, apellido, nombre, 22222222, 11/12/20023);
		
		
		//validacion
		assertNotNull(alumno);
		
		assertEquals(nombre, alumno.getNombre());
	}

}
