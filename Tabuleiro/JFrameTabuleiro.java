package Tabuleiro;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import Celula.Celula;
import Tabuleiro.*;
import configuracoes.JFrameMenu;

import static javax.swing.JOptionPane.showMessageDialog;

public class JFrameTabuleiro extends JFrame {

	//private boolean dificuldades;
	//private Tabuleiro tabuleiro2 = new Tabuleiro(dificuldades);
	private int dif;
	private int puzzleNMaluco = 0;
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
		panel.setLayout(new GridLayout(0,1,80,80));
		panel.setLayout(null);

		this.add(panel);
		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		this.setResizable(false);
		this.setLocation(450, 100);
		panel.setBackground(Color.LIGHT_GRAY);

		//this.setBackground(Color.blue);

		//JButton buttonConfig = new JButton("Configurações");
		JButton buttonJogar = new JButton("JOGAR!");
		buttonJogar.setBounds(65,100,250,45);
		buttonJogar.setBackground(Color.WHITE); 

		JButton buttonDificuldades = new JButton("DIFICULDADES");
		buttonDificuldades.setBounds(65,150,250,45);
		buttonDificuldades.setBackground(Color.WHITE); 

		JButton buttonMaluco = new JButton("MODO PUZZLEN MALUCO");
		buttonMaluco.setBounds(65,200,250,45);
		buttonMaluco.setBackground(Color.WHITE); 

		JButton buttonRanking = new JButton("RANKING");
		buttonRanking.setBounds(65,250,250,45);
		buttonRanking.setBackground(Color.WHITE); 

		JButton buttonSalvos = new JButton("JOGO SALVO");
		buttonSalvos.setBounds(65,300,250,45);
		buttonSalvos.setBackground(Color.WHITE); 

		//buttonJogar.setBounds(200, 200, 200, 200);
		panel.add(buttonJogar);
		panel.add(buttonMaluco);
		panel.add(buttonDificuldades);
		panel.add(buttonRanking);
		panel.add(buttonSalvos);
		panel.setVisible(true);

		//puzzleNMaluco = checkBox.isSelected();

		//System.out.println(checkBox.isSelected());

		buttonJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

			configs(buttonJogar, buttonMaluco, buttonDificuldades, buttonSalvos,buttonRanking, panel);
            }
        });

		buttonDificuldades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

			configsDif(buttonJogar, buttonMaluco, buttonDificuldades, panel);
            }
        });
	}



	public void configsDif(JButton buttonJogar, JButton buttonDificuldades,JButton buttonMaluco, JPanel panel){

		this.remove(buttonJogar);
		this.remove(buttonMaluco);
		this.remove(buttonDificuldades);
		this.remove(panel);
		this.dispose();

		JPanel panelDif = new JPanel();
		panelDif.setLayout(null);
		panelDif.setBackground(Color.LIGHT_GRAY);
		this.add(panelDif);
		this.setTitle("DIFICULDADES");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		this.setResizable(false);
		this.setLocation(450, 100);

		JButton buttonFacil = new JButton("FÁCIL");
		buttonFacil.setBounds(67,100,250,70);
		buttonFacil.setBackground(Color.WHITE);

		JButton buttonMedio = new JButton("MEDIO");
		buttonMedio.setBounds(67,180,250,70);
		buttonMedio.setBackground(Color.WHITE); 

		JButton buttonDificil = new JButton("DIFICIL");
		buttonDificil.setBounds(67,260,250,70);
		buttonDificil.setBackground(Color.WHITE); 

		panelDif.add(buttonFacil);
		panelDif.add(buttonMedio);
		panelDif.add(buttonDificil);
		panelDif.setVisible(true);

		buttonFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				dif = 2;
				//configs(buttonFacil, buttonMedio, buttonDificil, panel, dif);
            }
        });

		buttonMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

		buttonDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
	}









	/*public void atribuirBotaoTabuleiro(int dificuldade){
		tabuleiro = new Tabuleiro(dificuldade);
		JButtonCelula button[][] = new JButtonCelula[tabuleiro.getLinhas()][tabuleiro.getColunas()];
	}*/


	public void configs(JButton buttonJogar,JButton buttonDificuldades,JButton buttonMaluco,JButton buttonSalvos,JButton buttonRanking,JPanel panel) {

		this.remove(panel);
		this.remove(buttonJogar);
		this.remove(buttonMaluco);
		this.remove(buttonDificuldades);
		this.remove(buttonSalvos);
		this.remove(buttonRanking);
		this.dispose();
		
		GridLayout grid = new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()); // linhas e colunas (malha) 
		JButton buttonAjuda = new JButton("Ajuda");
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		//this.setLayout(new GridLayout(2, 1));
		this.setResizable(false);
		this.setLocation(450, 100);
		this.add(panel3);
		this.add(panel2);

		panel2.setLayout(grid);
		//panel3.setSize(100, 100);
		panel3.add(buttonAjuda);
		panel2.setBounds(0, 0, 250, 250);
		panel3.setBounds(0, 0, 250, 250);

		buttonAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

				showMessageDialog(null, "Para que seu jogo funcione, se atente à posição de sequência dos números\n-Caso você tenha escolhido o tabuleiro 3x3, a sequência deve ser: 1   2   3   4   5   6   7   8\n-Caso você tenha escolhido o tabuleiro 4x4, a sequência deve ser 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16.\nOBS: lembre-se que ao colocar os botões no lugar correto, suas peças mudam de cor, o que vai te ajudar a localizar a posição correta das peças!\nBom jogo!");

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

	public int getPuzzleNMaluco(){
		return puzzleNMaluco;
	}

	public void fimDoJogo(){
		showMessageDialog(null, "FIM DE JOGO!");
		reset();
	}

}
