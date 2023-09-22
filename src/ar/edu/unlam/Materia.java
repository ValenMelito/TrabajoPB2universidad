package ar.edu.unlam;

import java.util.ArrayList;
 
public class Materia {

	private String nombre;
	private Integer codigoDeMateria;
	private ArrayList<Curso> arrayDeCurso = new ArrayList<>();
	private ArrayList<Materia> arrayDeMateriasCorrelativas = new ArrayList<>();
	
	public Materia(String nombre, Integer codigoDeMateria) {
		this.nombre = nombre;
		this.codigoDeMateria=codigoDeMateria;
		
	}
	
	public String getNombreMateria() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Integer getCodigoDeMateria() {
		return codigoDeMateria;
	}

	public void setCodigoDeMateria(Integer codigoDeMateria) {
		this.codigoDeMateria = codigoDeMateria;
	}
	
    public ArrayList<Curso> getArrayDeCursos() {
        return arrayDeCurso;
    }

	public boolean ingresarCurso(Curso curso){
		boolean pudoIngresar=false;
		boolean duplicado=false;
		boolean estadoDelCurso=curso.getEstadoDelCurso();
		
		if(cursoRegistrado(curso)==true || horarioOcupado(curso)){
			duplicado=true;
		}
		
		if((getCantidadDeCursos()==0 || !duplicado) && estadoDelCurso==true){
			this.arrayDeCurso.add(curso);
			pudoIngresar=true;
		}
		
		return pudoIngresar;
	}
	
	
	public boolean cursoRegistrado(Curso curso){
		boolean existe=false;
		Integer codigoDeCurso=curso.getCodigoCurso();
		Curso cursoBuscadoPorCodigo=buscarCursoPorCodigo(codigoDeCurso);
		if(cursoBuscadoPorCodigo!=null) {
			existe=true;
		}
		return existe;
		
	}
	public boolean horarioOcupado(Curso curso) {
		
		boolean horarioOcupado=false;
		for(int i=0; i<getCantidadDeCursos(); i++){
			if(this.arrayDeCurso.get(i).getTurno()==curso.getTurno()){
				horarioOcupado=true;
			}
		}
		return horarioOcupado;
	}
	
	public Curso buscarCursoPorCodigo(Integer codigoDeCurso) {
		Curso cursoBuscadoPorCodigo=null;
		for(int i=0; i<getCantidadDeCursos(); i++){
			if(this.arrayDeCurso.get(i).getCodigoCurso().equals(codigoDeCurso)){
				cursoBuscadoPorCodigo=this.arrayDeCurso.get(i);
			}
		}
		return cursoBuscadoPorCodigo;
	}
	
	public Integer getCantidadDeCursos(){
		return this.arrayDeCurso.size();
	}
	
	public Materia buscarMateriaCorrelativaPorCodigoDeMateria(Integer codigoDeMateriaCorrelativa) {
		Materia materiaBuscada=null;
		for(int i=0; i<this.arrayDeMateriasCorrelativas.size(); i++) {
			if(this.arrayDeMateriasCorrelativas.get(i).getCodigoDeMateria().equals(codigoDeMateriaCorrelativa)){
				materiaBuscada=this.arrayDeMateriasCorrelativas.get(i);
			}
		}
		
		return materiaBuscada;
		
	}

	public void ingresarMateriaCorrelativa(Materia materiaCorrelativa) {
		this.arrayDeMateriasCorrelativas.add(materiaCorrelativa);
	}
	
	public Integer cantidadDeMateriasCorrelativas(){
		return this.arrayDeMateriasCorrelativas.size();
	}
	
	public void eliminarMateriaCorrelativaPorCodigoDeMateria(Integer codigoDeMateriaCorrelativa) {
		Materia materiaAEliminar=buscarMateriaCorrelativaPorCodigoDeMateria(codigoDeMateriaCorrelativa);
		this.arrayDeMateriasCorrelativas.remove(materiaAEliminar);
	}
	
	
}
