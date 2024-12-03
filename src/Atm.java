import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Atm {
    private double saldo;
    private double limiteSaqueDiario;
    private double totalSaqueDiario;
    private List<String> transacoes;

    private Map<String, String> usuarios;

    private String usuarioLogado;

    public Atm() {
        this.saldo = 0;
        this.limiteSaqueDiario = 1000;
        this.totalSaqueDiario = 0;
        this.transacoes = new ArrayList<>();
        this.usuarios = new HashMap<>();
        this.usuarioLogado = null;
    }

    public void criarConta(String usuario, String senha) {
        if (!usuarios.containsKey(usuario)) {
            usuarios.put(usuario, senha);
            System.out.println("Conta criada com sucesso para " + usuario);
        } else {
            System.out.println("Usuário já existe!");
        }
    }

    public boolean autenticar(String usuario, String senha) {
        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
            usuarioLogado = usuario;
            return true;
        }
        return false;
    }

    public void deslogar() {
        usuarioLogado = null;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add("Depósito de R$" + valor);
        }
    }

    public boolean sacar(double valor) {
        if (valor <= saldo && totalSaqueDiario + valor <= limiteSaqueDiario) {
            saldo -= valor;
            totalSaqueDiario += valor;
            transacoes.add("Saque de R$" + valor);
            return true;
        }
        return false;
    }

    public void transferir(Atm destino, double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            destino.depositar(valor);
            transacoes.add("Transferência de R$" + valor + " para outra conta");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getHistoricoTransacoes() {
        return new ArrayList<>(transacoes);
    }

    public void resetarLimiteSaqueDiario() {
        totalSaqueDiario = 0;
    }

    public double getTotalSaqueDiario() {
        return totalSaqueDiario;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }
}
