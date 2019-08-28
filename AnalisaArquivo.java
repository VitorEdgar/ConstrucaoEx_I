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

    /**
     * Le o arquivo cujo nome foi recebido e retorna o Map estatico da classe contendo os identificadores e as linhas
     * onde aparecem.
     */
    public static HashMap<String, ArrayList<Integer>> lerArquivo(String nomeArquivo) throws IOException{

        int countLinha = 0;

        try {
            BufferedReader arquivoReader = new BufferedReader(new FileReader(nomeArquivo));

            String linha = arquivoReader.readLine();
            countLinha++;
            while (linha != null) {
                analisaLinha(linha, countLinha);

                linha = arquivoReader.readLine();
                countLinha++;
            }

            arquivoReader.close();
        } catch (IOException e) {
            System.out.println("ERRO: arquivo de entrada inexistente.");
            throw e;
        }
        return identificadores;
    }

    /**
     * Recebe uma linha do arquivo e seu numero.
     * Remove os caracteres especiais da linha utilizando o metodo removerSimbolos.
     * Cria um tokenizer a partir da linha limpa.
     * Adiciona cada token e o numero da linha no Map da classe com o metodo adicionarIdentificador.
     */
    private static void analisaLinha(String linha, int numLinha){

        String linhaLimpa;
        String token;

        linhaLimpa = removerSimbolos(linha);
        StringTokenizer tokenizer = new StringTokenizer(linhaLimpa);
        while (tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();
            adicionaIndentificador(token, numLinha);
        }
    }

    /**
     * Adiciona o identificador recebido no Map da classe, caso ja não esteja la.
     * Atualiza o lista com os numeros de linha.
     */
    private static void adicionaIndentificador(String identificador, int numLinha){
        if (identificadores.containsKey(identificador)) {
            identificadores.get(identificador).add(numLinha);
        } else {
            ArrayList<Integer> linhas = new ArrayList<>();
            linhas.add(numLinha);
            identificadores.put(identificador, linhas);
        }
    }

    /**
     * Remove os simbolos indesejados da linha, trocando-os por espaços.
     */
    private static String removerSimbolos(String linha){
        String aux;
        aux = linha.replaceAll("[^a-zA-Z0-9_]", " ");
        return aux;
    }

}
