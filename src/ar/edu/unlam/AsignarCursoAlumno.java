package ar.edu.unlam;

public class AsignarCursoAlumno {

	private Alumno alumno;
	private Curso curso;
	private Nota notaParcial1;
	private Nota notaParcial2;
	private static boolean recupero=false;
	private estadoDeLaCursada estado;
	private Nota notaFinal;
	private static int intentosFinal=0;
	
	public AsignarCursoAlumno(Alumno alumno, Curso curso, Nota notaParcial1, Nota notaParcial2) {
		this.alumno=alumno;
		this.curso=curso;
		this.notaParcial1=notaParcial1;
		this.notaParcial2=notaParcial2;
	}

	public AsignarCursoAlumno(Alumno alumno, Curso curso){
		this.alumno=alumno;
		this.curso=curso;
		this.notaParcial1= new Nota();
		this.notaParcial2= new Nota();
	}
	
	
	
	
	public Alumno getAlumno() {
		return alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void calificarparcial1(Integer valor) {
		notaParcial1.asignarValor(valor);
	}
	
	public void calificarparcial2(Integer valor) {
		notaParcial2.asignarValor(valor);
	}
	
	public boolean puedeDarRecuperatorio(){
		boolean puedeRecuperar=true;
		boolean ambasNotasSonDesaprobadas = this.notaParcial1.getValor()<4 && this.notaParcial2.getValor()<4;
		boolean ambasNotasSonAprobadas = this.notaParcial1.getValor()>7 && this.notaParcial2.getValor()>7;
		if(ambasNotasSonDesaprobadas==true || ambasNotasSonAprobadas==true) {
			puedeRecuperar=false;
		}
		return puedeRecuperar;
	}
	
	public void recuperatorio(Integer valor){
		boolean condicion=puedeDarRecuperatorio();
		if(condicion==true && !recupero) {
			if (this.notaParcial1.getValor()>this.notaParcial2.getValor()) {
				calificarparcial2(valor);
			}
			else {
				calificarparcial1(valor);
				
			}
			recupero=true;
		}
	}
	
	public estadoDeLaCursada setEstadoDeLaCursada(){
		estado=null;
		if(this.notaParcial1.getValor()<4 && this.notaParcial2.getValor()<4 || intentosFinal>=3) {
			estado=estadoDeLaCursada.DESAPROBADO;
		}
		
		else if(this.notaParcial1.getValor()>7 && this.notaParcial2.getValor()>7) {
			estado=estadoDeLaCursada.PROMOCIONADO;
			Integer calificacionFinal =(this.notaParcial1.getValor()+this.notaParcial2.getValor())/2;
			notaFinal.asignarValor(calificacionFinal);
		}
		
		else {
			estado=estadoDeLaCursada.AFinal;
		}
		
		return estado;		
	}
	
	public boolean rendirFinal(){
		boolean puedeRendirFinal=false;
		if(estado==estado.AFinal){
			puedeRendirFinal=true;
		}
		return puedeRendirFinal;
	}
	
	public void calificarFinal(Integer valor) {
		intentosFinal++;
		if(rendirFinal()==true) {
			notaFinal.asignarValor(valor);
			if(notaFinal.getValor()>4) {
				estado=estado.FinalAPROBADO;
			}
		}
	}
	
	public Integer getNotaFinal() {
		return notaFinal.getValor();
	}
	
	
//	promociona= nota1>=7 && nota2>=7;
//	
//	aprobado= (nota1>=4 && nota2>=4) && (nota1<7 || nota2<7);
//	
//	desaprobado= nota1<4 || nota2<4;
	//registrarNota (idComision, idAlumno, nota) 
	//La nota debe estar entre 1 y 10 
	//No se puede asignar Una nota Mayor o igual a 7 si no están todas las correlativas aprobadas (Mayor o igual a 7) 
	//Las notas pueden ser de tipo 1erParc, 2doParc, Rec1Parcial, Rec2Parcial, Final 
	//no puede rendir 2 recuperatorios, es solo 1. 
	//para cargar la nota final, debe tener aprobadas las parciales 

	
}
