import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AnalisaArquivo {

    private static HashMap<String, ArrayList<Integer>> identificadores = new HashMap<>();

    public static HashMap<String, ArrayList<Integer>> lerArquivo(String arquivo) throws IOException{

        int countLinha = 0;

        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            countLinha++;
            while (linha != null) {
                analisaLinha(linha, countLinha);

                linha = lerArq.readLine();
                countLinha++;
            }

            arq.close();
        } catch (IOException e) {
            System.out.println("ERRO: arquivo de entrada inexistente.");
            throw e;
        }
        return identificadores;
    }

    private static void analisaLinha(String linha, int numLinha){

        String linhaLimpa;
        String token;

        linhaLimpa = removerSimbolos(linha);
        StringTokenizer st = new StringTokenizer(linhaLimpa);
        while (st.hasMoreTokens()){
            token = st.nextToken();
            adicionaIndentificador(token, numLinha);
        }

    }

    private static boolean adicionaIndentificador(String token, int numLinha){

        if (checkMap(token)) {
            identificadores.get(token).add(numLinha);
        } else {
            ArrayList<Integer> linhas = new ArrayList<>();
            linhas.add(numLinha);
            identificadores.put(token, linhas);
        }

        return true;
    }

    private static boolean checkMap(String ident) {
        return identificadores.containsKey(ident);
    }

    private static String removerSimbolos(String linha){

        String aux;
        aux = linha.replaceAll("[^a-zA-Z0-9_]", " ");

        return aux;
    }

}
