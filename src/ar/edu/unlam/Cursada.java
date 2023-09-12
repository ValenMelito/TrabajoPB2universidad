package ar.edu.unlam;


public class Cursada {

	private Alumno alumno;
	private Materia materia;
	private Nota nota; 

	public Cursada(Alumno alumno, Materia materia, Nota nota) {
		this.alumno=alumno;
		this.materia=materia;
		this.nota=nota;
	}

	public Cursada(Alumno alumno, Materia materia) {
		this.alumno=alumno;
		this.materia=materia;
		this.nota= new Nota();
	}


	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public void calificar(Integer valor) {
		
		nota.asignarValor(valor);
		
		
	}

	
	
}
