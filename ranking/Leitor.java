package ranking;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Leitor {
    private String path;

    public Leitor(String path) {
        this.path = path;
    }

    public String lerArquivo(){
        Path filePath = Paths.get(this.path);
        Charset charset = StandardCharsets.UTF_8;
        String dados="";
        int i=0;
        try {
            List<String> lines = Files.readAllLines(filePath, charset);
            for(String line: lines) {
                i++;
                System.out.println(line);

                dados = dados+"\n"+line;
            }

            return dados;
        } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
            
            return null;
        }
    }
}

