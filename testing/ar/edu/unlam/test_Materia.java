package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.*;


public class test_Materia {

	@Test
	public void queSePuedeaCrearUnaMateria() {
		String nombre = "Pb2";
		Materia materia = new Materia (nombre);
		
		assertEquals(nombre, materia.getNombre());
	}

	@Test// varios cursos dentro de una materia
	public void quePorCadaMateriaHayaVariosCursos() {
		String nombre = "Pb2";
		Integer cantidadCursos=2;
		//inicializacion del Curso
		Materia pb2 = new Materia (nombre);
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		for(int i=0; i<cantidadCursos; i++) {
			
			Curso cursos = new Curso(codigoCurso,pb2.getNombre(),turno,1,numeroDeAula);
			pb2.ingresarCurso(cursos);
			//otro curso diferente
			codigoCurso=1500;
			turno="tarde";
			numeroDeAula--;//205
		}
		
		Integer vo=pb2.getCantidadDeCursos();
		assertEquals(cantidadCursos,vo);

	}
	
	
	@Test
	public void verificarQueNoSeRepitaElCodigoDeLaMateria() {
		String nombre = "Pb2";
		Integer cantidadCursos=2;
		//inicializacion del Curso
		Materia pb2 = new Materia (nombre);
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		for(int i=0; i<cantidadCursos; i++) {
			
			Curso cursos = new Curso(codigoCurso,pb2.getNombre(),turno,1,numeroDeAula);
			pb2.ingresarCurso(cursos);
			//otro curso diferente
			codigoCurso--;//2005
			turno="tarde";
			numeroDeAula--;//205
		}
		
		Integer codigoDeCurso1=pb2.getIdentificadorDeCursoEspecifico(0);
		Integer codigoDeCurso2=pb2.getIdentificadorDeCursoEspecifico(1);
		assertTrue(codigoDeCurso1>codigoDeCurso2);

	}
	
	@Test
	public void verificarQueNoSeRepitanLasMaterias() {
		String nombreMateria1 = "Pb2";
		String nombreMateria2 = "Matematica Basica";
		Integer cantidadCursos=2;
		//inicializacion del Curso
		Materia pb2 = new Materia (nombreMateria1);
		Materia MB = new Materia (nombreMateria2);
		
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		
		Curso cursosPB2 = new Curso(codigoCurso,pb2.getNombre(),turno,1,numeroDeAula);
		pb2.ingresarCurso(cursosPB2);
		Curso cursosMB = new Curso(codigoCurso,MB.getNombre(),turno,1,numeroDeAula);
		MB.ingresarCurso(cursosMB);
		
		String nombreDeCurso1=pb2.getNombreDeCursoEspecifico(0);
		String nombreDeCurso2=MB.getNombreDeCursoEspecifico(0);
		assertFalse(nombreDeCurso1==nombreDeCurso2);

	}
	
	
	
}
