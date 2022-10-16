package Celula;
import java.util.Random;

import excessoes.PuzzleNExceptions;
import interfaces.celulaInterface;

public class Celula implements celulaInterface {
	
	private int valor;
	private boolean ordenado;
	
	//Coloquei um throws pra tentar resolver o problema que coloquei na linha 28, tenho que ver se deu certo
	public Celula(int valor) {
		
		//Random rand = new Random();
		
		//int valor = rand.nextInt(10);
		this.setValor(valor);
		//this.ordenado = false;
		if(valor==0){
			this.ordenado = true;
		}
		else{
			this.ordenado = false;
		}
	}
	
	//Quando eu coloco o throws PuzzleNExceptions, dá erro dentro do construtor, aparecendo um warning de "Unhandled exception type PuzzleNExceptions"
	public void setValor (int valor) {
		if(valor>0 && valor<16) {			
			this.valor = valor;
		} /*else {
			throw new PuzzleNExceptions();
		}  */	
	}
	
	public void setOrdenado (boolean ordenado) {
		if(ordenado == true || ordenado == false){
		this.ordenado = ordenado;
		} 
		/*else{
			throw new PuzzleNExceptions();
		}*/
	}

	public int getValor () {
		return this.valor;		
	}
	
	public boolean getOrdenado () {
		return this.ordenado;
	}


}
