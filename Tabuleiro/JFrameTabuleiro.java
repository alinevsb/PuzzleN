package Tabuleiro;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

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
	//private Tabuleiro tabuleiro = new Tabuleiro(puzzleNMaluco); 

	public JFrameTabuleiro() {
		configsMenu();
	}

	public void reset(){
		TabuleiroMain.reset();
		this.dispose();
	}

	public void configsMenu(){

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 0, -50));

		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocation(600, 300);
		this.add(panel);

		//JButton buttonConfig = new JButton("Configurações");
		JCheckBox checkBox = new JCheckBox("PuzzleN maluco?");
		JButton buttonJogar = new JButton("JOGAR!");

		//buttonJogar.setSize(200,200);

		
		panel.add(buttonJogar);
		panel.add(checkBox);

		puzzleNMaluco = checkBox.isSelected();

		//System.out.println(checkBox.isSelected());

		buttonJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

			configs(buttonJogar, checkBox, panel);
            }
        });
	}
	
	public void configs(JButton buttonJogar, JCheckBox checkBox, JPanel panel) {

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
		panel3.setSize(100, 100);
		panel3.add(buttonAjuda);
		
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
