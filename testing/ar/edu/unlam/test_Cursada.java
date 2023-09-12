package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.*;
 

public class test_Cursada {

	@Test
	public void queSePuedaCrearUnaCursada() {
		
		
		Alumno alumno = new Alumno(22, "Juan", "perez");
		Materia materia = new Materia("pb2");
		Nota nota = new Nota();
		Cursada  cursada = new  Cursada (alumno,materia,nota);
		
		

		assertNotNull(cursada);
		
		
		Cursada  cursada1 = new  Cursada (alumno,materia, nota);
		
		
		assertEquals(0, cursada1.getNota().getValor(),0.00);
		
			
	}
	
	@Test
	public void queSePuedaAsiganarUnValorEntreUnoYDiezaUnaNotaDeUnaCursada (){
		
		
		Alumno alumno = new Alumno(22, "Juan", "perez");
		Materia materia = new Materia("pb2");
		Nota nota = new Nota();
		Cursada  cursada = new  Cursada (alumno,materia,nota);

		Integer valor=7;
		cursada.calificar(valor);
		
		Integer vo=cursada.getNota().getValor();
		assertEquals(valor,vo);
		
		
			
	}
}
