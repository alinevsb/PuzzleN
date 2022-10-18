package Tabuleiro;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import Celula.Celula;
import ranking.Leitor;
import ranking.Ranking;

import static javax.swing.JOptionPane.showMessageDialog;

public class JFrameTabuleiro extends JFrame {

	private int dif;
	private boolean puzzleNMaluco = true;
	private Tabuleiro tabuleiro;
	private JButtonCelula button[][];
	private long tempoInicial;
	private long tempoDecorrido;
	private long tempoDecorridoSeg; 
	private String text;

	public JFrameTabuleiro() {
		configsMenu();
	}

	public void reset(){
		TabuleiroMain.reset();
		this.dispose();
	}

	public String getText(){
		Leitor leitor = new Leitor("C:/Users/danie/Documents/GitHub/PuzzleN/ranking/Ranking.txt");

		this.text = leitor.lerArquivo();

		return text;
	}

	public void configsMenu(){

		//JTextField text = new JTextField("Digite seu nome: ", 20);
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

		panel.add(buttonJogar);
		panel.add(buttonMaluco);
		panel.add(buttonDificuldades);
		panel.add(buttonRanking);
		panel.add(buttonSalvos);
		//panel.add(text);
		panel.setVisible(true);

		//puzzleNMaluco = checkBox.isSelected();
		//System.out.println(checkBox.isSelected());

		buttonJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

			configs(buttonJogar, buttonMaluco, buttonDificuldades, buttonSalvos, buttonRanking, panel);

			setDificuldade(0);
			setPuzzleNMaluco(false);
			configs(buttonJogar, buttonMaluco, buttonDificuldades, panel);
            }
        });

		buttonDificuldades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

			configsDif(buttonJogar, buttonMaluco, buttonDificuldades, buttonSalvos,buttonRanking,panel);
            }
        });

		buttonMaluco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
			
			setPuzzleNMaluco(true);
			
			configs(buttonJogar, buttonMaluco, buttonDificuldades, panel);
            }
        });

		buttonRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
			
			configsRanking(buttonJogar, buttonMaluco, buttonDificuldades, buttonSalvos, buttonRanking, panel);
            }
        });
	}

	public void configsDif(JButton buttonJogar, JButton buttonDificuldades,JButton buttonMaluco, JButton buttonSalvos,JButton buttonRanking,JPanel panel){

		this.remove(buttonJogar);
		this.remove(buttonMaluco);
		this.remove(buttonDificuldades);
		this.remove(buttonSalvos);
		this.remove(buttonRanking);
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

		JButton buttonMedio = new JButton("MÉDIO");
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
				setDificuldade(2);
				setPuzzleNMaluco(false);
				configs(buttonFacil, buttonMedio, buttonDificil, panelDif);
            }
        });

		buttonMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				setDificuldade(0);
				setPuzzleNMaluco(false);
				configs(buttonFacil, buttonMedio, buttonDificil, panelDif);
            }
        });

		buttonDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				setDificuldade(1);
				setPuzzleNMaluco(false);
				configs(buttonFacil, buttonMedio, buttonDificil, panelDif);
            }
        });
	}

	public void configsRanking(JButton buttonJogar,JButton buttonDificuldades,JButton buttonMaluco,JButton buttonSalvos,JButton buttonRanking,JPanel panel){
		this.remove(panel);
		this.remove(buttonJogar);
		this.remove(buttonMaluco);
		this.remove(buttonDificuldades);
		this.remove(buttonSalvos);
		this.remove(buttonRanking);
		this.dispose();

		JPanel painel = new JPanel();
		panel.setLayout(new GridLayout(0,1,80,80));
		panel.setLayout(null);

		this.add(painel);
		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		this.setResizable(false);
		this.setLocation(450, 100);
		painel.setBackground(Color.LIGHT_GRAY);

		JLabel label = new JLabel(this.getText());

		painel.add(label);
	}

	public void configs(JButton buttonJogar,JButton buttonDificuldades,JButton buttonMaluco,JButton buttonSalvos,JButton buttonRanking,JPanel panel) {

		this.remove(panel);
		this.remove(buttonJogar);
		this.remove(buttonMaluco);
		this.remove(buttonDificuldades);
		this.remove(buttonSalvos);
		this.remove(buttonRanking);
		this.dispose();
	}
	public void configs(JButton button1, JButton button2,JButton button3, JPanel panel) {

		tabuleiro = new Tabuleiro(this);
		button = new JButtonCelula[tabuleiro.getLinhas()][tabuleiro.getColunas()];

		// temporizador
		tempoInicial = System.currentTimeMillis();

		this.remove(panel);
		this.remove(button1);
		this.remove(button2);
		this.remove(button3);
		this.dispose();

		GridLayout grid = new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas(), 20,20); // linhas e colunas (malha) 

		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		panel3.setLayout(null);
		
		this.setTitle("PuzzleN");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 700);
		//this.setLayout(new GridLayout(2, 1));
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocation(450, 100);
		this.add(panel3);
		this.add(panel2);

		panel2.setLayout(grid);
		panel3.setSize(100, 100);

		JButton buttonAjuda = new JButton("Ajuda");
		buttonAjuda.setBounds(0, 208, 100, 20);
		buttonAjuda.setBackground(Color.MAGENTA);

		panel3.add(buttonAjuda);
		panel3.setBounds(0, 0, 250, 250);
		panel2.setBounds(0, 0, 250, 250);
		panel3.setBounds(0, 0, 250, 250);

		buttonAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

				showMessageDialog(null, "Para que seu jogo funcione, se atente à posição de sequência dos números\n-Caso você tenha escolhido o tabuleiro 3x3, a sequência deve ser: 1   2   3   4   5   6   7   8\n-Caso você tenha escolhido o tabuleiro 4x4, a sequência deve ser 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16.\nOBS: lembre-se que ao colocar os botões no lugar correto, suas peças mudam de cor, o que vai te ajudar a localizar a posição correta das peças!\nBom jogo!");

				// ajuda do botao
            }
        });
		
		Celula[][] matriz = tabuleiro.getMatriz();

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

	public boolean getPuzzleNMaluco(){
		return puzzleNMaluco;
	}

	public void setPuzzleNMaluco(boolean puzzleNMaluco){
		this.puzzleNMaluco = puzzleNMaluco;
	}

	public int getDificuldade(){
		return dif;
	}

	public void setDificuldade(int dif){
		this.dif = dif;
	}

	public void fimDoJogo(){
		showMessageDialog(null, "FIM DE JOGO!");
		tempoDecorrido = System.currentTimeMillis() - tempoInicial;
		tempoDecorridoSeg = tempoDecorrido / 1000;
		try {
			//System.out.println("funfou");
			//System.out.println(tempoDecorridoSeg);
			Ranking.salvarRanking(tempoDecorridoSeg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reset();
	}

}
