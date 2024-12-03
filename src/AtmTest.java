import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AtmTest {

    @Test
    public void testCriarConta() {
        Atm atm = new Atm();
        atm.criarConta("usuario1", "senha123");
        assertTrue(atm.autenticar("usuario1", "senha123"));
    }

    @Test
    public void testAutenticacaoFalha() {
        Atm atm = new Atm();
        atm.criarConta("usuario1", "senha123");
        assertFalse(atm.autenticar("usuario1", "senhaErrada"));
    }

    @Test
    public void testDepositarDinheiro() {
        Atm atm = new Atm();
        atm.depositar(500);
        assertEquals(500, atm.getSaldo());
    }

    @Test
    public void testSacarDinheiroComSaldoSuficiente() {
        Atm atm = new Atm();
        atm.depositar(1000);
        assertTrue(atm.sacar(500));
        assertEquals(500, atm.getSaldo());
    }

    @Test
    public void testSacarDinheiroComSaldoInsuficiente() {
        Atm atm = new Atm();
        atm.depositar(300);
        assertFalse(atm.sacar(500));
    }

    @Test
    public void testTransferirEntreContas() {
        Atm atm1 = new Atm();
        Atm atm2 = new Atm();
        atm1.criarConta("usuario1", "senha123");
        atm2.criarConta("usuario2", "senha456");

        atm1.depositar(1000);
        atm1.transferir(atm2, 200);

        assertEquals(800, atm1.getSaldo());
        assertEquals(200, atm2.getSaldo());
    }

    @Test
    public void testLimiteSaqueDiario() {
        Atm atm = new Atm();
        atm.depositar(2000);

        assertTrue(atm.sacar(1000));
        assertFalse(atm.sacar(500));

        assertEquals(1000, atm.getSaldo());
        assertEquals(1000, atm.getTotalSaqueDiario());

        atm.resetarLimiteSaqueDiario();
        assertTrue(atm.sacar(500));
    }

    @Test
    public void testHistoricoTransacoes() {
        Atm atm = new Atm();
        atm.depositar(1000);
        atm.sacar(500);
        atm.transferir(new Atm(), 200);

        List<String> historico = atm.getHistoricoTransacoes();

        assertEquals(3, historico.size());
        assertTrue(historico.contains("Depósito de 1000.0"));
        assertTrue(historico.contains("Saque de 500.0"));
        assertTrue(historico.contains("Transferência de 200.0 para outra conta"));
    }
}

