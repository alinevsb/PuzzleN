package ranking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ranking {
    private static long tempo;
    //private static String nome;

    public static void salvarRanking(long tempo) throws IOException {

        String dadoString = "Tempo:"+tempo+"s";
        String dados;
        //String path = "C:/Users/danie/Documents/GitHub/PuzzleN/";
        File dir = new File("C:/Users/danie/Documents/GitHub/PuzzleN/ranking");

        if(!dir.exists()){
            dir.mkdirs();
            System.out.println("opa");
        }

        try {
            File f1 = new File("C:/Users/danie/Documents/GitHub/PuzzleN/ranking/Ranking.txt");
            if (f1.createNewFile()) {
            System.out.println("File created: " + f1.getName());
            } else {
            System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Leitor leitor = new Leitor("C:/Users/danie/Documents/GitHub/PuzzleN/ranking/Ranking.txt");

        String data = leitor.lerArquivo();

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/danie/Documents/GitHub/PuzzleN/ranking/Ranking.txt"));
        String dadosNovos = dadoString+data;
        writer.write(dadosNovos);
              
        writer.close();
        //reader.close();
    }
}
