import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Por favor, digite o nome do arquivo-texto de entrada: ");
        String nomeArq = in.nextLine();
        GerencArquivos.gerencArquivo(nomeArq);
    }
}
