package Tabuleiro;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.MouseEvent;

import Celula.Celula;
import excessoes.PuzzleNExceptions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonCelula extends JButton implements MouseInputListener, ActionListener{

	JFrameTabuleiro tabuleiroGrafico;

	public JButtonCelula(String valor, JFrameTabuleiro tg) {

		this.tabuleiroGrafico = tg;
		this.setText(valor);
		
		configs();

	}

	public JButtonCelula(JFrameTabuleiro tg) {

		this.tabuleiroGrafico = tg;
		this.setText("");

		configs();
		
	}

	public void configs(){
		this.setOpaque(true);

		// caracteristicas do botao
		this.setBorderPainted(true);

		addMouseListener(this);

		addActionListener(this);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
		String s = e.getPoint().toString();

		//System.out.println(s);
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	public void actionPerformed(ActionEvent ae){

		Celula celulaTemp;
		String textTemp;
		int linha = 0;
		int coluna = 0;
		int linhaVazia = 0;
		int colunaVazia = 0;
		String s =  ae.getActionCommand().toString();

		//int valor = Integer.parseInt(s);
		
		//System.out.println(s);

		JButtonCelula[][] buttons = tabuleiroGrafico.getButtons();

		for(int i=0; i<tabuleiroGrafico.getTabuleiro().getLinhas(); i++){
			for(int j=0; j<tabuleiroGrafico.getTabuleiro().getColunas(); j++){
				if(buttons[i][j].getText().equals(s)){
					linha = i;
					coluna = j;
				}

				if(buttons[i][j].getText().equals("")){
					linhaVazia = i;
					colunaVazia = j;
				}	
			}
		}
		// colocar um if para limitar as trocas -- apenas celulas vizinhas
		// troca de posições

		if(((linha == 0 && coluna == 0) && ((linhaVazia == 0 && colunaVazia == 1) || (linhaVazia == 1 && colunaVazia == 0))) || ((linha == 0 && coluna == 1) && ((linhaVazia == 0 && colunaVazia == 0) || (linhaVazia == 0 && colunaVazia == 2) || (linhaVazia == 1 && colunaVazia == 1)))
		|| ((linha == 0 && coluna == 2) && ((linhaVazia == 0 && colunaVazia == 1) || (linhaVazia == 1 && colunaVazia == 2))) || ((linha == 1 && coluna == 0) && ((linhaVazia == 1 && colunaVazia == 1) 
		|| (linhaVazia == 2 && colunaVazia == 0) || (linhaVazia == 0 && colunaVazia == 0))) || ((linha == 1 && coluna == 1) && ((linhaVazia == 0 && colunaVazia == 1) || (linhaVazia == 1 && colunaVazia == 0)
		|| (linhaVazia == 1 && colunaVazia == 2) || (linhaVazia == 2 && colunaVazia ==  1))) || ((linha == 1 && coluna == 2) && ((linhaVazia == 0 && colunaVazia == 2) || (linhaVazia == 1 && colunaVazia == 1) || (linhaVazia == 2 && colunaVazia == 2)))
		|| ((linha == 2 && coluna == 0) && ((linhaVazia == 1 && colunaVazia == 0) || (linhaVazia == 2 && colunaVazia == 1))) || ((linha == 2 && coluna == 1) && ((linhaVazia == 1 && colunaVazia == 1) || (linhaVazia == 2 && colunaVazia == 0) || (linhaVazia == 2 && colunaVazia == 2)))
		|| ((linha == 2 && coluna == 2) && ((linhaVazia == 1 && colunaVazia == 2) || (linhaVazia == 2 && colunaVazia ==1)))){
		
			textTemp = buttons[linha][coluna].getText();
			buttons[linha][coluna].setText(buttons[linhaVazia][colunaVazia].getText());
			buttons[linhaVazia][colunaVazia].setText(textTemp);
		
			if(tabuleiroGrafico.getTabuleiro().gameOver()){
				tabuleiroGrafico.fimDoJogo();
			}
		}
		
		Celula[][] matriz = tabuleiroGrafico.getTabuleiro().getMatriz();

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				for(int k=0; k<3; k++){
					for(int l=0; l<3; l++){
						if(isOrdenado(i, j, buttons[i][j])){
							if(matriz[k][l].getValor() == Integer.parseInt(buttons[i][j].getText())){
								matriz[k][l].setOrdenado(true);

								// mudar cor
							}
						}
						else{
							if(!buttons[i][j].getText().equals("")){
								if(matriz[k][l].getValor() == Integer.parseInt(buttons[i][j].getText())){
									matriz[k][l].setOrdenado(false);

									// voltar para cor normal
								}
							}
						}
						
						// teste no console
						//System.out.println(matriz[k][l].getOrdenado()+", "+matriz[k][l].getValor());
					}
				}
			}
		}
	}

	// metodos adicionais do jogo


	// testando
	public boolean isOrdenado(int linha, int coluna, JButtonCelula button){
		if(!button.getText().equals("")){
			if(Integer.parseInt((button.getText())) == (linha*3+coluna+1)){
				//System.out.println("ordenado");
				button.setBackground(Color.red);
				return true;
			}
		}

		button.setBackground(null);
		return false;
	}

}
