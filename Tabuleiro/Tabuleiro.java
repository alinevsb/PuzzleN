package Tabuleiro;
//import java.util.ArrayList;

import Celula.*;

public class Tabuleiro {
	
	private int linhas = 3;
	private int colunas = 3;
	
	Celula[][] matriz;
	
	public Tabuleiro() {
		
		matriz = new Celula[this.linhas][this.colunas];
		
		for(int i=0; i<this.linhas; i++) {
			for(int j=0; j<this.colunas; j++) {
				
				matriz[i][j] = new Celula();
					
			}
		}
		
	}
	
	// metodo celulas vizinhas
	
}