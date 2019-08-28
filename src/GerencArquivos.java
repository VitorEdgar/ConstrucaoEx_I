import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class GerencArquivos {

    /**
     * Recebe um Map contendo os identificadores e um ArrayList com as linhas em que eles aparecem.
     * Retorna uma string com os dados foramatados.
     */
    public static String formatarSaida(HashMap<String, ArrayList<Integer>> tokens) {
        Set<String> keys = tokens.keySet();
        String out = "";
        ArrayList<Integer> aux;
        for (String identificadores : keys) {
            out += identificadores + ";";
            aux = tokens.get(identificadores);
            out += aux.get(0).toString();
            for (int i = 1; i < aux.size(); i++) {
                out += "," + aux.get(i);
            }
            out += "\n";
        }
        return out;
    }

    /**
     * Recebe o nome do arquivo e uam string, salvando o conteudo da string no arquivo.
     */
    private static void salvarArquivo(String nomeArquivo, String saida) {
        BufferedWriter arquivoWriter;
        int index = nomeArquivo.indexOf(".");
        nomeArquivo = nomeArquivo.substring(0, index) + "-xref.txt";

        try {
            arquivoWriter = new BufferedWriter(new FileWriter(nomeArquivo));
            arquivoWriter.write(saida);
            arquivoWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("Análise realizada. Arquivo " + nomeArquivo + " gerado.");
    }

    /**
     * Inicializa um Map e chama os metodos lerArquivo e salvarArquivo com o nome de arquivo recebido.
     */
    public static void gerencArquivo(String nomeArquivo) {
        HashMap<String, ArrayList<Integer>> map = null;
        try {
            AnalisaArquivo.lerArquivo(nomeArquivo);
            map = AnalisaArquivo.identificadores;
            String saida = formatarSaida(map);
            salvarArquivo(nomeArquivo, saida);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
