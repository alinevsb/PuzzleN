package Tabuleiro;
//import java.util.ArrayList;

import Celula.*;
import javax.swing.*;
import java.awt.*;

public class Tabuleiro {
	
	private int linhas = 3;
	private int colunas = 3;
	
	Celula[][] matriz;
	
	public Tabuleiro() {
		
		matriz = new Celula[this.linhas][this.colunas];
		
		for(int i=0; i<=this.linhas; i++) {
			for(int j=0; j<=this.colunas; j++) {
				matriz[i][j] = new Celula();		
			}
			System.out.println();
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
	
	// metodo celulas vizinhas
	
}
