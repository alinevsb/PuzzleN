package Tabuleiro;

import javax.swing.*;
import Celula.Celula;
import Tabuleiro.*;

public class JFrameTabuleiro extends JFrame {
	
	Tabuleiro tabuleiro;
	
	public JFrameTabuleiro() {
		
		configs();
		
	}
	
	public void configs() {
		
		this.setTitle("PuzzleN");
		
		this.setSize(1000, 600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		this.getContentPane().add(panel);
		
		this.setVisible(true);
		
		tabuleiro = new Tabuleiro();
		
		for(int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				
				
				
			}
		}
	}

}
