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
		
		Alumno alumno = new Alumno(dni, apellido, nombre);
		
		
		//validacion
		assertNotNull(alumno);
		
		assertEquals(nombre, alumno.getNombre());
	}

}
