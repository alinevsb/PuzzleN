
public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	
	Celula[][] matriz;
	
	public Tabuleiro() {
		
		matriz = new Celula[this.linhas][this.colunas];
		
		for(int i=0; i<this.linhas; i++) {
			for(int j=0; j<this.colunas; j++) {
				
				matriz[i][j] = new Celula();
				
				// fazer o if
			}
		}
		
	}
	
}
