package ar.edu.unlam;


public class Cursada {

	private Alumno alumno;
	private Curso curso;
	private Nota nota; 

	public Cursada(Alumno alumno, Curso curso, Nota nota) {
		this.alumno=alumno;
		this.curso=curso;
		this.nota=nota;
	}

	public Cursada(Alumno alumno, Curso curso){
		this.alumno=alumno;
		this.curso=curso;
		this.nota= new Nota();
	}

	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getMateria() {
		return curso.getNombreMateria();
	}

	public void setMateria(String nombreMateria) {
		this.curso.setNombreMateria(nombreMateria);
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
