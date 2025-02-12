import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoNaoPerecivelTest {
    ProdutoNaoPerecivel produto;

    @BeforeEach
    public void prepare() {
        produto = new ProdutoNaoPerecivel("Não Perecível Teste", 100.0, 0.2);
    }

    @Test
    public void calculaPrecoCorretamente() {
        assertEquals(120.0, produto.valorVenda(), 0.01);
    }

    @Test
    public void calculaPrecoComMargemPadrao() {
        produto = new ProdutoNaoPerecivel("Não Perecível Teste", 100.0);
        assertEquals(120.0, produto.valorVenda(), 0.01);
    }

    @Test
    public void naoCriaProdutoComDescricaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("Te", 100.0, 0.2));
    }

    @Test
    public void naoCriaProdutoComPrecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("Teste", -100.0, 0.2));
    }

    @Test
    public void naoCriaProdutoComMargemInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("Teste", 100.0, -0.2));
    }
}