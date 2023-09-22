package ar.edu.unlam;

import java.time.LocalDate;

public class Ciclo_Lectivo {

	private LocalDate inicioFechaDeInscripcionPrimerCuatri=LocalDate.parse("2023-03-27");
	private LocalDate finFechaDeInscripcionPrimerCuatri=LocalDate.parse("2023-04-01");
	
	private LocalDate inicioPrimerCiclo;
	private LocalDate finPrimerCiclo;
	
	private LocalDate inicioFechaDeInscripcionSegundoCuatri=LocalDate.parse("2023-07-12");
	private LocalDate finFechaDeInscripcionSegundoCuatri=LocalDate.parse("2023-07-25");
	
	private LocalDate inicioSegundoCiclo;
	private LocalDate finSegundoCiclo;
	
	public Ciclo_Lectivo(LocalDate inicioPrimerCiclo, LocalDate finPrimerCiclo,
			LocalDate inicioSegundoCiclo, LocalDate finSegundoCiclo) {
		
		this.inicioPrimerCiclo = inicioPrimerCiclo;
		this.finPrimerCiclo = finPrimerCiclo;
		this.inicioSegundoCiclo = inicioSegundoCiclo;
		this.finSegundoCiclo = finSegundoCiclo;
	}

	public LocalDate getInicioFechaDeInscripcionPrimerCuatri() {
		return inicioFechaDeInscripcionPrimerCuatri;
	}

	public void setInicioFechaDeInscripcionPrimerCuatri(LocalDate inicioFechaDeInscripcionPrimerCuatri) {
		this.inicioFechaDeInscripcionPrimerCuatri = inicioFechaDeInscripcionPrimerCuatri;
	}

	public LocalDate getFinFechaDeInscripcionPrimerCuatri() {
		return finFechaDeInscripcionPrimerCuatri;
	}

	public void setFinFechaDeInscripcionPrimerCuatri(LocalDate finFechaDeInscripcionPrimerCuatri) {
		this.finFechaDeInscripcionPrimerCuatri = finFechaDeInscripcionPrimerCuatri;
	}

	public LocalDate getInicioPrimerCiclo() {
		return inicioPrimerCiclo;
	}

	public void setInicioPrimerCiclo(LocalDate inicioPrimerCiclo) {
		this.inicioPrimerCiclo = inicioPrimerCiclo;
	}

	public LocalDate getFinPrimerCiclo() {
		return finPrimerCiclo;
	}

	public void setFinPrimerCiclo(LocalDate finPrimerCiclo) {
		this.finPrimerCiclo = finPrimerCiclo;
	}

	public LocalDate getInicioFechaDeInscripcionSegundoCuatri() {
		return inicioFechaDeInscripcionSegundoCuatri;
	}

	public void setInicioFechaDeInscripcionSegundoCuatri(LocalDate inicioFechaDeInscripcionSegundoCuatri) {
		this.inicioFechaDeInscripcionSegundoCuatri = inicioFechaDeInscripcionSegundoCuatri;
	}

	public LocalDate getFinFechaDeInscripcionSegundoCuatri() {
		return finFechaDeInscripcionSegundoCuatri;
	}

	public void setFinFechaDeInscripcionSegundoCuatri(LocalDate finFechaDeInscripcionSegundoCuatri) {
		this.finFechaDeInscripcionSegundoCuatri = finFechaDeInscripcionSegundoCuatri;
	}

	public LocalDate getInicioSegundoCiclo() {
		return inicioSegundoCiclo;
	}

	public void setInicioSegundoCiclo(LocalDate inicioSegundoCiclo) {
		this.inicioSegundoCiclo = inicioSegundoCiclo;
	}

	public LocalDate getFinSegundoCiclo() {
		return finSegundoCiclo;
	}

	public void setFinSegundoCiclo(LocalDate finSegundoCiclo) {
		this.finSegundoCiclo = finSegundoCiclo;
	}
	
	
	
	
}
