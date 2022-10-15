package Tabuleiro;
//import java.util.ArrayList;

import Celula.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import Tabuleiro.*;
import excessoes.PuzzleNExceptions;

public class Tabuleiro {
	
	private int linhas = 3;
	private int colunas = 3;
	
	private Celula[][] matriz; // private
	
	public Tabuleiro() {
		matriz = new Celula[this.linhas][this.colunas];
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i=0; i<9; i++) lista.add(i); // talvez colocar i=1, nao incluir o zero (celula em branco) no shuffle
        Collections.shuffle(lista);
        
        int cont = -1;
        
		for(int i=0; i<this.linhas; i++) {
			for(int j=0; j<this.colunas; j++) {
				
				cont++;
				
				matriz[i][j] = new Celula(lista.get(cont));	
			}
		}

		// celula em branco como ultima celula
		for(int i=0; i<this.linhas; i++){
			for(int j=0; j<this.colunas; j++){

				if(matriz[i][j].getValor() == 0){
					Celula celulaTemp;

					celulaTemp = matriz[this.linhas-1][this.colunas-1];
					matriz[this.linhas-1][this.colunas-1] = matriz[i][j];
					matriz[i][j] = celulaTemp; 
					
				}
			}
		}
		
	}
	
	public void paintComponent(Graphics tab) {
		tab.setColor(Color.red);
		tab.fillRect(0, 0, 600, 600);
		
		tab.setColor(Color.black);
		tab.drawLine(0, 200, 600, 200);
		tab.drawLine(0, 400, 600, 400);
		
		tab.drawLine(200, 0, 200, 600);
		tab.drawLine(400, 0, 400, 600);
		
		
        matriz = new Celula[this.linhas][this.colunas];
		
		for(int i=0; i<=this.linhas; i++) {
			for(int j=0; j<=this.colunas; j++) {
				tab.drawString("" + matriz[i][j], 50+j*200, 50+i*200);
			}
			System.out.println();
		}
	}

	public int getLinhas() {
		return this.linhas;
	}
	
	public int getColunas() {
		return this.colunas;
	}
	
	public Celula[][] getMatriz() {
		return this.matriz;
	}

	public boolean gameOver(){
		//Celula [][] matriz = this.getMatriz();
		int contagem = 0;
		for(int i = 0; i<this.linhas;i++){
			for(int j = 0; j<this.linhas;j++){
				if(matriz[i][j].getOrdenado()==true){
					contagem++;
				}
			}
		}
		if(contagem>=8){
			//System.out.println("Fim do jogo!");
			return true;
		}
		else{
			return false;
		}
	}

	public boolean podeResolver(){
		int inversoes = 0;
		ArrayList<Integer> valores = new ArrayList<>();

		for(int k=0; k<3; k++){
			for(int l=0; l<3; l++){
				valores.add(matriz[k][l].getValor());
			}
		}

		for(int i=0; i<this.linhas; i++){
			for(int j=0; j<i; j++){
				if(valores.get(j)>valores.get(i)){
					inversoes++;
				}
			}
		}
		//System.out.println(valores);
		//System.out.println(inversoes);
		return inversoes%2 == 0;
	}
	
}
