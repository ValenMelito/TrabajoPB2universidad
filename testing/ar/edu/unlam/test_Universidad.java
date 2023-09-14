package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class test_Universidad {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	
	@Test
	public void ingresarAlumnosALaUniversidad(){
		Universidad unlam = new Universidad("unlam");
		Alumno alumno1 = new Alumno(43408686, "Martinez", "Ricardo");
		Alumno alumno2 = new Alumno(40890180, "Luana", "Maria");
		Alumno alumno3 = new Alumno(39701456, "Pascal", "Pedro");
		
		unlam.ingresarAlumno(alumno1);
		unlam.ingresarAlumno(alumno2);
		unlam.ingresarAlumno(alumno3);
		
		Integer vo=3;
		Integer alumnosTotales=unlam.alumnosTotales();
		
		//se ingresaron correctamente 3 alumnos
		assertEquals(vo,alumnosTotales);
		
	}
	
	@Test
	public void buscarAlumnoPorDni() {
		Universidad unlam = new Universidad("unlam");
		Alumno alumno1 = new Alumno(43408686, "Martinez", "Ricardo");
		Alumno alumno2 = new Alumno(40890180, "Luana", "Maria");
		Alumno alumno3 = new Alumno(39701456, "Pascal", "Pedro");
		
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
	
	
	
	
	
	

	
}
