package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.*;


public class test_Materia {

	@Test
	public void queSePuedeaCrearUnaMateria() {
		String nombre = "Pb2";
		Integer codigoDeMateria=2623;
		
		Materia materia = new Materia (nombre, codigoDeMateria);
		
		assertEquals(nombre, materia.getNombreMateria());
	}
	
	@Test
	public void queNoHaya2MateriasMismoConElMismoID(){
		Materia materia1 = new Materia ("pb2", 2324);
		Materia materia2 = new Materia ("pb1", 2324);
		Universidad unlam = new Universidad("unlam");
		
		unlam.ingresarMateria(materia1);
		unlam.ingresarMateria(materia2);
		
		Integer ve=1;
		Integer vo=unlam.cantidadMaterias();
		
		assertEquals(ve,vo);

	}
	
	@Test// varios cursos dentro de una materia
	public void quePorCadaMateriaHayaVariosCursos() {
		String nombre = "Pb2";
		Integer codigoDeMateria=2623;
		Integer cantidadCursos=2;
		//inicializacion del Curso
		Materia pb2 = new Materia (nombre, codigoDeMateria);
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		for(int i=0; i<cantidadCursos; i++) {
			
			Curso cursos = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula,true);
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
	public void verificarQueHaya1ProfesorCada20Chicos() {
		Materia pb2 = new Materia ("programacion basica 2",2623);
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		
		Curso cursoPB2 = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula,true);
		pb2.ingresarCurso(cursoPB2);
		
		Profesor profesorPB2 = new Profesor("Monteagudo", "JuanMa", 31577809);
		Alumno alumno1 = new Alumno(43408686, "Martinez", "Ricardo");
		Alumno alumno2 = new Alumno(40890180, "Luana", "Maria");
		Alumno alumno3 = new Alumno(39701456, "Pascal", "Pedro");
		
		
		cursoPB2.ingresarProfesor(profesorPB2);

		cursoPB2.ingresarAlumno(alumno1);
		cursoPB2.ingresarAlumno(alumno2);
		cursoPB2.ingresarAlumno(alumno3);
		
		//aca verifique si se modificaba o no y si, anda bien		
		cursoPB2.ingresarProfesor(profesorPB2);
		for(int i = 0; i<20; i++) {
			cursoPB2.ingresarAlumno(alumno1);
		}
		
		boolean valorObtenido =cursoPB2.verificarEstadoDelCurso(cursoPB2);
		
		assertEquals(true,valorObtenido);
		
	}
	
	
	@Test
	public void queUnProfesorNoSeRepitaEn2CusosAlMismoHorario(){
		Universidad unlam = new Universidad("unlam");
		String nombreMateria1 = "Pb2";
		String nombreMateria2 = "Ingles Tecnico 2";
		
		Integer codigoDeMateria1=2623;
		Integer codigoDeMateria2=2627;
		
		//inicializacion de materias
		Materia pb2 = new Materia (nombreMateria1,codigoDeMateria1);
		Materia it2 = new Materia (nombreMateria2, codigoDeMateria2);
		
		unlam.ingresarMateria(pb2);
		unlam.ingresarMateria(it2);
		
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		
		//inicializacion de cursos
		Curso cursoPB2 = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula,true);
		pb2.ingresarCurso(cursoPB2);
		Curso cursoMB = new Curso(codigoCurso,it2.getNombreMateria(),turno,1,numeroDeAula,true);
		it2.ingresarCurso(cursoMB);
		
		Profesor profesorPB2 = new Profesor("Monteagudo", "JuanMa", 31577809);
//		cursoPB2.ingresarProfesor(profesorPB2);
//		cursoMB.ingresarProfesor(profesorPB2);
		profesorPB2.ingresarCurso(cursoMB);
		profesorPB2.ingresarCurso(cursoPB2);
		
		Integer ve=1;
		Integer vo=profesorPB2.getCantidadDeCursos();
			
		assertEquals(ve,vo);
	}
	
	@Test
	public void queSePuedanIngresarMateriasCorrelativas(){
		String nombreMateria1 = "Pb2";
		String nombreMateria2 = "Pb1";
		
		Integer codigoDeMateria1=2623;
		Integer codigoDeMateria2=2627;
		
		//inicializacion de materias
		Materia pb2 = new Materia (nombreMateria1,codigoDeMateria1);
		Materia pb1 = new Materia (nombreMateria2, codigoDeMateria2);
		
		pb2.ingresarMateriaCorrelativa(pb1);
		Integer ve=1;
		Integer vo=pb2.cantidadDeMateriasCorrelativas();
		
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void queSePuedaEliminarMateriasCorrelativas(){
		String nombreMateria1 = "Pb2";
		String nombreMateria2 = "Pb1";
		
		Integer codigoDeMateria1=2623;
		Integer codigoDeMateria2=2627;
		
		//inicializacion de materias
		Materia pb2 = new Materia (nombreMateria1,codigoDeMateria1);
		Materia pb1 = new Materia (nombreMateria2, codigoDeMateria2);
		
		pb2.ingresarMateriaCorrelativa(pb1);
		pb2.eliminarMateriaCorrelativaPorCodigoDeMateria(codigoDeMateria2);
		
		Integer ve=0;
		Integer vo=pb2.cantidadDeMateriasCorrelativas();
		
		assertEquals(ve,vo);
		
	}
	
}
