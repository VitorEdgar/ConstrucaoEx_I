import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GerencArquivosTest {

    @Test
    void formatarSaidaTest01() {
        HashMap<String, ArrayList<Integer>> tokens = new HashMap<>();
        ArrayList<Integer> linhas = new ArrayList<>();
        linhas.add(5);
        tokens.put("palavra", linhas);
        String out = GerencArquivos.formatarSaida(tokens);
        assertEquals("palavra;5\n", out);
    }

    @Test
    void formatarSaidaTest02() {
        HashMap<String, ArrayList<Integer>> tokens = new HashMap<>();
        ArrayList<Integer> linhas = new ArrayList<>();
        linhas.add(5);
        tokens.put("palavra", linhas);
        String out = GerencArquivos.formatarSaida(tokens);
        assertNotEquals("palavra;8", out);
    }
}