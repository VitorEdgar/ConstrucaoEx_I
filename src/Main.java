import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]){

        String opa = "fdfre rgkdui %7943 ()*& kdsuy _";
        String aux = opa.replaceAll("[^a-zA-Z0-9_]", " ");
        StringTokenizer st = new StringTokenizer(aux);

        while (st.hasMoreTokens()){
            String auxe = st.nextToken();
            System.out.println(auxe);
        }



    }

}
