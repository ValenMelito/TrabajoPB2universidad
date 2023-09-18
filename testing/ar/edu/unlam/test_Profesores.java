package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class test_Profesores {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void crearUnProfesor() {
		Profesor profesor = new Profesor("Jerez", "Martin", 22222222);
		assertNotNull(profesor);
	}

	@Test
	public void verificarQueNoPuedaUnirseADosMateriasConMismoHorario() {
		Profesor profesor = new Profesor("Jerez", "Martin", 22222222);
		Curso curso1 = new Curso(2326, "pb1", "Tarde", 1, 265, true);
		Curso curso2 = new Curso(2327, "pb2", "Tarde", 1, 233, true);
		Curso curso3 = new Curso(2329, "tw1", "Mañana", 1, 233, true);
		
		profesor.ingresarCurso(curso1);
		profesor.ingresarCurso(curso2);
		profesor.ingresarCurso(curso3);
		
		Integer ve=2;
		Integer vo=profesor.getCantidadDeCursos();
		
		assertEquals(ve,vo);
		
	}
	
	
	
}
