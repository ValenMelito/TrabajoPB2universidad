package ar.edu.unlam;

public class Nota {
	
	private Integer valor;


	public Nota() {
		this.valor = 0;
	}

	public Integer getValor() {;
		return this.valor;
	}

	public void asignarValor(Integer nuevoValor) {
		// TODO Auto-generated method stub
		if(nuevoValor>0 && nuevoValor<11) {
			this.valor=nuevoValor;
		}
	}

}
