package configuracoes;

import Tabuleiro.*;
import javax.swing.*;

public class Jogo {

	public Jogo() {
		iniciarJogo();
	}

	public void escolherMenu() {
		new JFrameMenu();
	}

	public void escolherNivel() {
		//Preencher esse método com as dificuldades do jogo
	}

	public void iniciarJogo() {
		new JFrameTabuleiro();
	}

}
