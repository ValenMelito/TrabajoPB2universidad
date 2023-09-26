package ar.edu.unlam;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class test_Universidad {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	
	@Test
	public void ingresarAlumnosALaUniversidad(){
		LocalDate fechaDeIngreso = LocalDate.parse("2023-08-04");
		LocalDate fechaDeNacimiento = LocalDate.parse("2002-08-14");
		
		Universidad unlam = new Universidad("unlam");
		Alumno alumno1 = new Alumno(43408686, "Martinez", "Ricardo",fechaDeIngreso,fechaDeNacimiento);
		Alumno alumno2 = new Alumno(40890180, "Luana", "Maria",fechaDeIngreso,fechaDeNacimiento);
		Alumno alumno3 = new Alumno(43408686, "Pascal", "Pedro",fechaDeIngreso,fechaDeNacimiento);
		
		unlam.ingresarAlumno(alumno1);
		unlam.ingresarAlumno(alumno2);
		unlam.ingresarAlumno(alumno3);

		
		Integer vo=2;
		Integer alumnosTotales=unlam.alumnosTotales();
		
//se ingresaron correctamente 2 alumnos y el que tiene numero de documento diferente no lo dejaron registrarse
		assertEquals(vo,alumnosTotales);
		
	}
	
	@Test
	public void buscarAlumnoPorDni() {
		LocalDate fechaDeIngreso = LocalDate.parse("2023-08-04");
		LocalDate fechaDeNacimiento = LocalDate.parse("2002-08-14");
		
		Universidad unlam = new Universidad("unlam");
		Alumno alumno1 = new Alumno(43408686, "Martinez", "Ricardo",fechaDeNacimiento,fechaDeIngreso);
		Alumno alumno2 = new Alumno(40890180, "Luana", "Maria",fechaDeNacimiento,fechaDeIngreso);
		Alumno alumno3 = new Alumno(39701456, "Pascal", "Pedro",fechaDeNacimiento,fechaDeIngreso);
		
		unlam.ingresarAlumno(alumno1);
		unlam.ingresarAlumno(alumno2);
		unlam.ingresarAlumno(alumno3);
		
		String alumnoBuscado=unlam.buscarAlumnoPorDni(39701456).getApellido();
		String apellidoAlumno=alumno3.getApellido();
		
		//hice pruebas buscando el fallo y tambien funciono de que no lo encontro
		assertEquals(apellidoAlumno,alumnoBuscado);
		
	}
	
	@Test
	public void queSePuedaBuscarUnaMateriaPorCodigo() {
		String nombreMateria1 = "Pb2";
		String nombreMateria2 = "Ingles Tecnico 2";
		
		Integer codigoDeMateria1=2623;
		Integer codigoDeMateria2=2627;
		
		//inicializacion de Materias y universidad
		Materia pb2 = new Materia (nombreMateria1,codigoDeMateria1);
		Materia it2 = new Materia (nombreMateria2, codigoDeMateria2);	
		Universidad unlam = new Universidad("unlam");

		
		unlam.ingresarMateria(pb2);
		unlam.ingresarMateria(it2);
		
		String codigoDeMateriaBuscada = unlam.buscarMateriaPorCodigo(2627).getNombreMateria();
		
		assertEquals(nombreMateria2,codigoDeMateriaBuscada);
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

		Universidad unlam = new Universidad("unlam");
		unlam.ingresarMateria(pb2);
		unlam.ingresarMateria(pb1);
		
		
		
		Boolean ve=true;
		Boolean vo=unlam.eliminarCorrelativa(codigoDeMateria1, codigoDeMateria2);
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void agregarMateriasCorrelativasAUnaMateria() {
		
		Materia pb2 = new Materia ("pb2",2324);
		Materia pb1 = new Materia ("pb1",2318);	
		Universidad unlam = new Universidad("unlam");
		
		unlam.ingresarMateria(pb2);
		unlam.ingresarMateria(pb1);
		
		unlam.ingresarMateriaCorrelativa(pb2.getCodigoDeMateria(), pb1.getCodigoDeMateria());
		
		Integer ve=1;
		Integer vo=pb2.cantidadDeMateriasCorrelativas();
		
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void agregarMateriasCorrelativasAUnaMateriaYEliminarla() {
		
		Materia pb2 = new Materia ("pb2",2324);
		Materia pb1 = new Materia ("pb1",2318);	
		Universidad unlam = new Universidad("unlam");
		
		unlam.ingresarMateria(pb2);
		unlam.ingresarMateria(pb1);
		
		unlam.ingresarMateriaCorrelativa(pb2.getCodigoDeMateria(), pb1.getCodigoDeMateria());
		
		unlam.eliminarCorrelativa(pb2.getCodigoDeMateria(), pb1.getCodigoDeMateria());
		
		Integer ve=0;
		Integer vo=pb2.cantidadDeMateriasCorrelativas();
		
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void esperamosQueDeLaNotaFinal() {
//		
		Universidad unlam = new Universidad("unlam");
		Materia pb1 = new Materia ("pb1",2318);
		Curso cursoPB1 = new Curso(3300,"pb1","Mañana",1);
		pb1.ingresarCurso(cursoPB1);
//		
		LocalDate fechaDeIngreso = LocalDate.parse("2023-08-04");
		LocalDate fechaDeNacimiento = LocalDate.parse("2002-08-14");
		
		Alumno alumno1 = new Alumno(43408686, "Martinez", "Ricardo",fechaDeNacimiento,fechaDeIngreso);
		Alumno alumno2 = new Alumno(40890180, "Luana", "Maria",fechaDeNacimiento,fechaDeIngreso);
		Alumno alumno3 = new Alumno(39701456, "Pascal", "Pedro",fechaDeNacimiento,fechaDeIngreso);
		AsignarCursoAlumno historialDeCursada1 = new AsignarCursoAlumno(alumno1, cursoPB1);
		AsignarCursoAlumno historialDeCursada2 = new AsignarCursoAlumno(alumno2, cursoPB1);
		AsignarCursoAlumno historialDeCursada3 = new AsignarCursoAlumno(alumno3, cursoPB1);
	
		//unlam.ingresarHistorialDeCursadas(historialDeCursada1);
		unlam.ingresarHistorialDeCursadas(historialDeCursada1);
		unlam.ingresarHistorialDeCursadas(historialDeCursada2);
		unlam.ingresarHistorialDeCursadas(historialDeCursada3);
		unlam.ingresarAlumno(alumno1);
		unlam.ingresarAlumno(alumno2);
		unlam.ingresarAlumno(alumno3);
		unlam.ingresarMateria(pb1);
	
		historialDeCursada1.calificarparcial1(5);
		historialDeCursada1.calificarparcial2(5);
		//historialDeCursada1.recuperatorio(3);//no recupero porque ya estaba promocionado
		historialDeCursada1.setEstadoDeLaCursada();
		historialDeCursada1.calificarFinal(1);
	
//		boolean ve=true;
//		boolean vo=historialDeCursada1.puedeDarRecuperatorio();
			
		Integer ve= 1;
		Integer vo= historialDeCursada1.getNotaFinal();
//		
//		estadoDeLaCursada ve=estadoDeLaCursada.FinalAPROBADO;
//		estadoDeLaCursada vo=historialDeCursada1.getEstadoDeLaCursada();
		

	
	//	Integer vo=unlam.obtenerNotaFinal(alumno1.getDni(), pb1.getCodigoDeMateria());
		
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void probamosQueSeIngreseArrayDeMateriasAprobadas() {
		Universidad unlam = new Universidad("unlam");
		Materia pb1 = new Materia ("pb1",2318);
		Materia it2 = new Materia ("it2", 2320);
		Materia pb2 = new Materia ("pb2",2325);
		Aula aula1=new Aula(202, 50);
		Aula aula2=new Aula(205, 50);
		Aula aula3=new Aula(120, 50);
		Aula aula4=new Aula(120, 50);
		
		
		Curso cursoPB1 = new Curso(3300,"pb1","Mañana",1);
		cursoPB1.asignarAulaCurso(aula1);
		pb1.ingresarCurso(cursoPB1);
		Curso cursoIT2 = new Curso(2300, "it2", "Mañana",1);
		cursoIT2.asignarAulaCurso(aula2);
		it2.ingresarCurso(cursoIT2);
		Curso cursoIT2Tarde= new Curso(2500, "it2", "Tarde",1);
		cursoIT2Tarde.asignarAulaCurso(aula3);
		it2.ingresarCurso(cursoIT2Tarde);
		Curso cursoPB2= new Curso(4400,"pb2","Tarde",1);
		cursoPB2.asignarAulaCurso(aula4);
		pb2.ingresarCurso(cursoPB2);
		
		LocalDate fechaDeIngreso = LocalDate.parse("2023-08-04");
		LocalDate fechaDeNacimiento = LocalDate.parse("2002-08-14");
		
		Alumno alumno1 = new Alumno(43408686, "Martinez", "Ricardo",fechaDeNacimiento,fechaDeIngreso);
		Alumno alumno2 = new Alumno(40890180, "Luana", "Maria",fechaDeNacimiento,fechaDeIngreso);
		Alumno alumno3 = new Alumno(39701456, "Pascal", "Pedro",fechaDeNacimiento,fechaDeIngreso);
		
		
		AsignarCursoAlumno historialDeCursada1 = new AsignarCursoAlumno(alumno1, cursoPB1);
		AsignarCursoAlumno historialDeCursada2 = new AsignarCursoAlumno(alumno1, cursoIT2);
		AsignarCursoAlumno historialDeCursada3 = new AsignarCursoAlumno(alumno1, cursoPB2);
		AsignarCursoAlumno historialDeCursada4 = new AsignarCursoAlumno(alumno2, cursoIT2);
		AsignarCursoAlumno historialDeCursada5 = new AsignarCursoAlumno(alumno3, cursoIT2Tarde);
		
		unlam.ingresarHistorialDeCursadas(historialDeCursada1);
		unlam.ingresarHistorialDeCursadas(historialDeCursada2);
		unlam.ingresarHistorialDeCursadas(historialDeCursada3);
		unlam.ingresarHistorialDeCursadas(historialDeCursada4);
		unlam.ingresarHistorialDeCursadas(historialDeCursada5);
		
		cursoPB1.ingresarAlumno(alumno1);
		cursoIT2.ingresarAlumno(alumno1);
		cursoPB2.ingresarAlumno(alumno1);
		cursoIT2.ingresarAlumno(alumno2);
		cursoIT2Tarde.ingresarAlumno(alumno3);
		
		unlam.ingresarMateria(pb1);
		unlam.ingresarMateria(it2);
		unlam.ingresarMateria(pb2);
		
		unlam.ingresarAlumno(alumno2);
		unlam.ingresarAlumno(alumno1);
		unlam.ingresarAlumno(alumno3);
		
		
		historialDeCursada1.calificarparcial1(8);
		historialDeCursada1.calificarparcial2(8);
		historialDeCursada1.setEstadoDeLaCursada();
		//historialDeCursada1.calificarFinal(6);
		
		historialDeCursada2.calificarparcial1(4);
		historialDeCursada2.calificarparcial2(5);
		historialDeCursada2.setEstadoDeLaCursada();
		historialDeCursada2.calificarFinal(2);
		
		historialDeCursada3.calificarparcial1(3);
		historialDeCursada3.calificarparcial2(3);
		historialDeCursada3.setEstadoDeLaCursada();
		
		historialDeCursada4.calificarparcial1(3);
		historialDeCursada4.calificarparcial2(4);
		historialDeCursada4.recuperatorio(4);
		historialDeCursada4.setEstadoDeLaCursada();
		
		historialDeCursada5.calificarparcial1(8);
		historialDeCursada5.calificarparcial2(8);
		historialDeCursada5.setEstadoDeLaCursada();
		
		ArrayList<Materia> prueba=unlam.obtenerMateriasAprobada(43408686);
		Integer promedioDeNotas=unlam.obtenerPromedioDeNotas(43408686);
		
		Integer ve=8;//esperamos que de 6
		Integer vo=promedioDeNotas;
//		estadoDeLaCursada ve=estadoDeLaCursada.FinalAPROBADO;
//		estadoDeLaCursada vo=historialDeCursada1.getEstadoDeLaCursada();
		
		for(int i=0; i<prueba.size();i++) {
			System.out.println(prueba.get(i).getNombreMateria());
		}
		assertEquals(ve,vo);
	}
	
	
	
}
