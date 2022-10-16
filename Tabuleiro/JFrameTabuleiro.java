package Tabuleiro;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import Celula.Celula;
import Tabuleiro.*;
import configuracoes.JFrameMenu;

import static javax.swing.JOptionPane.showMessageDialog;

public class JFrameTabuleiro extends JFrame {

	private boolean puzzleNMaluco;
	private Tabuleiro tabuleiro = new Tabuleiro(puzzleNMaluco);
	private JButtonCelula button[][] = new JButtonCelula[tabuleiro.getLinhas()][tabuleiro.getColunas()];

	public JFrameTabuleiro() {
		configsMenu();
	}

	public void reset(){
		TabuleiroMain.reset();
		this.dispose();
	}

	public void configsMenu(){

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		this.add(panel);
		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 650);
		this.setResizable(false);
		this.setLocation(600, 300);
		//this.setBackground(Color.blue);

		//JButton buttonConfig = new JButton("Configurações");
		JButton checkBox = new JButton("PuzzleN maluco?");
		JButton buttonJogar = new JButton("JOGAR!");

		//buttonJogar.setBounds(200, 200, 200, 200);
		panel.add(buttonJogar);
		panel.add(checkBox);
		panel.setVisible(true);

		puzzleNMaluco = checkBox.isSelected();

		//System.out.println(checkBox.isSelected());

		buttonJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

			configs(buttonJogar, checkBox, panel);
            }
        });
	}
	
	public void configs(JButton buttonJogar, JButton checkBox, JPanel panel) {

		this.remove(panel);
		this.remove(buttonJogar);
		this.remove(checkBox);
		this.dispose();
		
		GridLayout grid = new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()); // linhas e colunas (malha) 
		JButton buttonAjuda = new JButton("Ajuda");
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLayout(new GridLayout(2, 1));
		this.setResizable(false);
		this.setLocation(600, 300);
		this.add(panel3);
		this.add(panel2);

		panel2.setLayout(grid);
		//panel3.setSize(100, 100);
		panel3.add(buttonAjuda);
		panel2.setBounds(0, 0, 250, 250);
		panel3.setBounds(0, 0, 250, 250);

		buttonAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

				showMessageDialog(null, "1   2   3   4   5   6   7   8");

				// ajuda do botao
            }
        });
		
		Celula[][] matriz = tabuleiro.getMatriz();

		// mudanças
		if(tabuleiro.podeResolver()){
				
			for(int i=0; i<tabuleiro.getLinhas(); i++) {
				for(int j=0; j<tabuleiro.getColunas(); j++) {
					
					int valor = matriz[i][j].getValor();

					if(valor == 0){
						button[i][j] = new JButtonCelula(this);

						panel2.add(button[i][j]);
					}

					else{
					
						String valorString = Integer.toString(valor);
						
						button[i][j] = new JButtonCelula(valorString, this); 
						
						panel2.add(button[i][j]);
					}
				}
			}
		}
		else{
			reset();
		}
	}

	public JButtonCelula[][] getButtons(){
		return this.button;
	}

	public Tabuleiro getTabuleiro(){
		return tabuleiro;
	}

	public void fimDoJogo(){
		showMessageDialog(null, "FIM DE JOGO!");
		reset();
	}

}
