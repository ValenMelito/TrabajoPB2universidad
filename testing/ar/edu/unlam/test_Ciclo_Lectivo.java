package ar.edu.unlam;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class test_Ciclo_Lectivo {

	@Test
	public void queSeIniceUnCicloElectivo() {
		
		LocalDate inicioFechaDeInscripcionPrimerCuatri=LocalDate.parse("2023-03-27");
		
		LocalDate inicioPrimerCiclo=LocalDate.parse("2023-05-02");
		LocalDate finPrimerCiclo=LocalDate.parse("2023-07-12");;
		
		LocalDate inicioSegundoCiclo=LocalDate.parse("2023-07-29");
		LocalDate finSegundoCiclo=LocalDate.parse("2023-11-25");;
		
		
		Ciclo_Lectivo ciclo2023 = new Ciclo_Lectivo(inicioPrimerCiclo, finPrimerCiclo, inicioSegundoCiclo, finSegundoCiclo); 
		
		assertEquals(inicioFechaDeInscripcionPrimerCuatri,ciclo2023.getInicioFechaDeInscripcionPrimerCuatri());
		
	}
}
