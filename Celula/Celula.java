package Celula;
import java.util.Random;

import excessoes.PuzzleNExceptions;

public class Celula {
	
	private int valor;
	private boolean ordenado;
	
	//Coloquei um throws pra tentar resolver o problema que coloquei na linha 28, tenho que ver se deu certo
	public Celula(int valor) throws PuzzleNExceptions {
		
		//Random rand = new Random();
		
		//int valor = rand.nextInt(10);
		this.setValor(valor);
		this.ordenado = false;
		
	}
	
	public int getValor () {
		
		return this.valor;
		
	}

	//Quando eu coloco o throws PuzzleNExceptions, dá erro dentro do construtor, aparecendo um warning de "Unhandled exception type PuzzleNExceptions"
	public void setValor (int valor) throws PuzzleNExceptions{
		if(valor>0 && valor<10) {			
			this.valor = valor;
		} else {
			throw new PuzzleNExceptions();
		}  		
	}

	/*if(setValor<0 && setValor>10){
		throw new Exception()
}*/
	
	public void setOrdenado (boolean ordenado) throws PuzzleNExceptions{
		if(ordenado = true){
		this.ordenado = ordenado;
		} 
		else{
			throw new PuzzleNExceptions();
		}
	}

	
	public boolean getOrdenado () {
		return this.ordenado;
	}


}
