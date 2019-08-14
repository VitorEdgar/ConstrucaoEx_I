import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class GerencArquivos {

    public static String formatarSaida(HashMap<String, ArrayList<Integer>> tokens) {
        Set<String> keys = tokens.keySet();
        String out = "";
        ArrayList<Integer> aux;
        for (String ident : keys) {
            out += ident + ";";
            aux = tokens.get(ident);
            out += aux.get(0).toString();
            for (int i = 1; i < aux.size(); i++) {
                out += "," + aux.get(i);
            }
            out += "\n";
        }
        return out;
    }

    private static void salvarArquivo(String nomeArq, String saida) {
        BufferedWriter bw;
        int index = nomeArq.indexOf(".");
        nomeArq = nomeArq.substring(0, index) + "-xref.txt";
        try {
            bw = new BufferedWriter(new FileWriter(nomeArq));
            bw.write(saida);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Análise realizada. Arquivo " + nomeArq + " gerado.");
    }

    public static void gerencArquivo(String nomeArq) {
        HashMap<String, ArrayList<Integer>> map = null;
        try {
            map = AnalisaArquivo.lerArquivo(nomeArq);
            String saida = formatarSaida(map);
            salvarArquivo(nomeArq, saida);
        } catch (IOException e) {
        }


    }
}
