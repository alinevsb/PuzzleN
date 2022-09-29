package Tabuleiro;

import javax.swing.JButton;

public class JButtonCelula extends JButton {
	
	public JButtonCelula(String valor) {

		this.setText(valor);
		
		configs();

	}

	public JButtonCelula() {

		this.setText("");

		configs();		
		
	}

	public void configs(){
		this.setOpaque(true);
		/* caracteristicas do botao
		*
		*
		*
		*
		*/ 

		//this.addMouseListener(l);
	}

	// metodos adicionais do jogo

}
