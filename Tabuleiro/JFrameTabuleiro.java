package Tabuleiro;

import javax.swing.*;
import java.awt.GridLayout;
import Celula.Celula;
import Tabuleiro.*;

public class JFrameTabuleiro extends JFrame {
	
	Tabuleiro tabuleiro = new Tabuleiro(); 

	JButtonCelula button[][] = new JButtonCelula[tabuleiro.getLinhas()][tabuleiro.getColunas()];

	public JFrameTabuleiro() {
		
		configs();
		
	}
	
	public void configs() {
		
		GridLayout grid = new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()); // linhas e colunas (malha)
		
		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLayout(grid);
		this.setResizable(false);
		
		Celula[][] matriz = tabuleiro.getMatriz();
		
		for(int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				
				int valor = matriz[i][j].getValor();

				if(valor == 0){
					button[i][j] = new JButtonCelula(this);

					this.add(button[i][j]);
				}

				else{
				
				String valorString = Integer.toString(valor);
				
				button[i][j] = new JButtonCelula(valorString, this); 
				
				this.add(button[i][j]);
				}
			}
		}
	}

	public JButtonCelula[][] getButtons(){
		return this.button;
	}

	public Tabuleiro getTabuleiro(){
		return tabuleiro;
	}

}
