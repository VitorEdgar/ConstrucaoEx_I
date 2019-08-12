import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AnalisaArquivo {

    private HashMap<String, ArrayList<Integer>> identificadores;

    public static boolean lerArquivo(String nomeArq) {

        int countLinha = 0;
        String nome = nomeArq;

        try {
            FileReader arq = new FileReader(nome);
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
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return true;
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

        return true;
    }

    private static String removerSimbolos(String linha){

        String aux;
        aux = linha.replaceAll("[^a-zA-Z0-9_]", " ");

        return aux;
    }

}
