package ar.edu.unlam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class test_Nota {

	@Test
	public void queAlCrearUnaNotaSuNotaSeaCero() {
		
		
		Nota nota= new Nota();
		
		Integer ve=0;
		Integer va=nota.getValor();
		assertEquals(va, ve);
	}
	
	@Test
	public void queAlAsignarUnValorEntreUnoYDiezSeLeAsigneELValorALaNota() {
		
		Nota nota = new Nota ();
	
		Integer valor=7;
		nota.asignarValor(valor);
		
		Integer ve= 7;
		Integer vo=nota.getValor();
		assertEquals(ve,vo);
				
	}

 
	@Test
	public void queAlAsignarUnValorQueNoEsteEntreUnoYDiezNoSeLeAsigneELValorALaNota() {

		Nota nota = new Nota ()  ; // valor =0
		
		Integer valor=11;
		nota.asignarValor(valor); // valor = 0 
			
		Integer ve= 0;
		Integer vo=nota.getValor();
		
		assertEquals(ve,vo);
	}
}
