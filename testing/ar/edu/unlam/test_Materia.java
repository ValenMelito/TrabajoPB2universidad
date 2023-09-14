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
			
			Curso cursos = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula,"activo");
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
		Integer codigoDeMateria=2623;
		Integer cantidadCursos=2;
		
		//inicializacion del Curso
		Materia pb2 = new Materia (nombre, codigoDeMateria);
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		//creo 2 cursos con diferentes variables
		for(int i=0; i<cantidadCursos; i++) {
			
			Curso cursos = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula,"activo");
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
		String nombreMateria2 = "Ingles Tecnico 2";
		
		Integer codigoDeMateria1=2623;
		Integer codigoDeMateria2=2627;
		
		Integer cantidadCursos=2;
		//inicializacion del Curso
		Materia pb2 = new Materia (nombreMateria1,codigoDeMateria1);
		Materia it2 = new Materia (nombreMateria2, codigoDeMateria2);
		
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		
		Curso cursosPB2 = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula,"activo");
		pb2.ingresarCurso(cursosPB2);
		Curso cursosMB = new Curso(codigoCurso,it2.getNombreMateria(),turno,1,numeroDeAula,"activo");
		it2.ingresarCurso(cursosMB);
		
		String nombreDeCurso1=pb2.getNombreDeCursoEspecifico(0);
		String nombreDeCurso2=it2.getNombreDeCursoEspecifico(0);
		assertFalse(nombreDeCurso1==nombreDeCurso2);

	}
	
	@Test
	public void verificarQueHaya1ProfesorCada20Chicos() {
		Materia pb2 = new Materia ("programacion basica 2",2623);
		Integer codigoCurso = 2006;
		String turno = "mañana";
		Integer numeroDeAula=206;
		
		Curso cursoPB2 = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula, "activo");
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
		
		String valorObtenido =cursoPB2.verificarEstadoDelCurso(cursoPB2);
		
		assertEquals("activo",valorObtenido);
		
	}
	
	
	@Test
	public void queUnProfesorSeRepitaEn2CusosAlMismoHorario(){
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
		Curso cursosPB2 = new Curso(codigoCurso,pb2.getNombreMateria(),turno,1,numeroDeAula,"activo");
		pb2.ingresarCurso(cursosPB2);
		Curso cursosMB = new Curso(codigoCurso,it2.getNombreMateria(),turno,1,numeroDeAula,"activo");
		it2.ingresarCurso(cursosMB);
		
		Profesor profesorPB2 = new Profesor("Monteagudo", "JuanMa", 31577809);
		cursosPB2.ingresarProfesor(profesorPB2);
		
		
		
	}
	
	 
	
}
