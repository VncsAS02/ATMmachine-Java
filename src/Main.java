import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Atm caixaEletronico = new Atm();

        Scanner scanner = new Scanner(System.in);

        boolean executar = true;

        while (executar) {
            System.out.println("\nBem-vindo ao Caixa Eletrônico!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar conta");
            System.out.println("2. Entrar com conta existente");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome de usuário: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String senha = scanner.nextLine();
                    caixaEletronico.criarConta(usuario, senha);
                    break;

                case 2:
                    System.out.print("Digite seu nome de usuário: ");
                    String usuarioLogin = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senhaLogin = scanner.nextLine();

                    if (caixaEletronico.autenticar(usuarioLogin, senhaLogin)) {
                        System.out.println("Autenticação bem-sucedida! Bem-vindo, " + usuarioLogin);

                        boolean menuUsuario = true;
                        while (menuUsuario) {
                            System.out.println("\nEscolha uma opção:");
                            System.out.println("1. Ver saldo");
                            System.out.println("2. Depositar dinheiro");
                            System.out.println("3. Sacar dinheiro");
                            System.out.println("4. Transferir dinheiro");
                            System.out.println("5. Ver histórico de transações");
                            System.out.println("6. Sair");

                            int opcaoUsuario = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcaoUsuario) {
                                case 1:
                                    System.out.println("Seu saldo é: R$" + caixaEletronico.getSaldo());
                                    break;

                                case 2:
                                    System.out.print("Digite o valor para depósito: R$");
                                    double deposito = scanner.nextDouble();
                                    caixaEletronico.depositar(deposito);
                                    System.out.println("Depósito de R$" + deposito + " realizado com sucesso.");
                                    break;

                                case 3:
                                    System.out.print("Digite o valor para saque: R$");
                                    double saque = scanner.nextDouble();
                                    if (caixaEletronico.sacar(saque)) {
                                        System.out.println("Saque de R$" + saque + " realizado com sucesso.");
                                    } else {
                                        System.out.println("Saldo insuficiente ou limite de saque diário excedido.");
                                    }
                                    break;

                                case 4:
                                    System.out.print("Digite o valor para transferência: R$");
                                    double transferencia = scanner.nextDouble();
                                    Atm contaDestino = new Atm();
                                    caixaEletronico.transferir(contaDestino, transferencia);
                                    System.out.println("Transferência de R$" + transferencia + " realizada com sucesso.");
                                    break;

                                case 5:
                                    System.out.println("Histórico de Transações:");
                                    for (String transacao : caixaEletronico.getHistoricoTransacoes()) {
                                        System.out.println(transacao);
                                    }
                                    break;

                                case 6:
                                    caixaEletronico.deslogar();
                                    System.out.println("Você saiu da conta.");
                                    menuUsuario = false;
                                    break;

                                default:
                                    System.out.println("Opção inválida !!! Tente novamente.");
                            }
                        }

                    } else {
                        System.out.println("Autenticação falhou! Usuário ou senha incorretos.");
                    }
                    break;

                case 3:
                    executar = false;
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
