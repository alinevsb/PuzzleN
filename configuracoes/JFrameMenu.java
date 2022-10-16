package configuracoes;

import javax.swing.*;

public class JFrameMenu extends JFrame {
    
    public JFrameMenu() {

        this.setTitle("PuzzleN");
        this.setVisible(true);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButtonMenu jogoButton = new JButtonMenu("JOGAR");

        this.add(jogoButton);
    }
}
