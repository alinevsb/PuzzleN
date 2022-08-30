package Celula;
import java.util.Random;

import Tabuleiro.JFrameTabuleiro;

public class Celula extends JFrameTabuleiro {
	
	private int valor;
	private boolean ordenado;
	
	public Celula() {
		
		Random rand = new Random();
		
		int valor = rand.nextInt(10);
		
		this.setValor(valor);
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


}
