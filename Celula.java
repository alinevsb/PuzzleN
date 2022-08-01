//import java.util.ArrayList;

public class Celula {
	
	private int valor;
	private boolean ordenado;
	
	//private ArrayList<Celula> celulas;
	
	public Celula() {
		
		int min = 1;
		int max = 9;
		int rand = (int)Math.floor(Math.random()*(max-min+1)+min); // numero aleatorio entre 1 e 9
		
		this.setValor(rand);
		this.ordenado = false;
		
	}
	
	public int getValor (int valor) {
		
		return this.valor;
		
	}

	public void setValor (int valor) {
		
		if(valor>0 && valor<10) {
			
			this.valor = valor;
			
		}
		
	}
	
	public void setOrdenado (boolean ordenado) {
		
		this.ordenado = ordenado;
		
	}
	
	public boolean getOrdenado () {
		
		return this.ordenado;
		
	}
	// ainda vendo se vamos usar essa parte
	/*public void setCelulas (ArrayList<Celula> celulas) {
		
		this.celulas = celulas;
		
	}
	
	public ArrayList<Celula> getCelulas (){
		
		return this.celulas;
	}*/

}
