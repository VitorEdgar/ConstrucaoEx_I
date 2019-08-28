import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalisaArquivoTest {

    @Test
    void removeSimbolosTest01() {
        String linha = "palavra1#palavra2";
        String out = AnalisaArquivo.removerSimbolos(linha);
        assertEquals("palavra1 palavra2", out);
    }

    @Test
    void removeSimbolosTest02() {
        String linha = "palavara1#palavra2";
        String out = AnalisaArquivo.removerSimbolos(linha);
        assertNotEquals("palavra1#palavra2", out);
    }

}