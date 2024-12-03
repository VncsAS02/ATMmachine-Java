# ATM Machine - Simulação de Caixa Eletrônico

Este é um projeto de simulação de caixa eletrônico (ATM) implementado em Java, permitindo a criação de contas, autenticação de usuários, e a realização de operações bancárias como depósitos, saques, transferências e visualização de saldo e histórico de transações.

## Funcionalidades

- **Criação de Conta**: O usuário pode criar uma conta com um nome de usuário e senha únicos.
- **Autenticação**: O usuário pode fazer login usando um nome de usuário e senha.
- **Depósito**: Permite que o usuário deposite dinheiro em sua conta.
- **Saque**: O usuário pode realizar saques, respeitando o saldo e o limite de saque diário.
- **Transferência**: O usuário pode transferir dinheiro para outras contas.
- **Histórico de Transações**: O usuário pode visualizar o histórico de suas transações realizadas (depósitos, saques, transferências).
- **Limite de Saque Diário**: Existe um limite diário para saques, e o total de saques é monitorado.

## Requisitos

- JDK 11 ou superior
- Ambiente de desenvolvimento de sua escolha (IDE como IntelliJ, Eclipse, NetBeans ou terminal)

## Como Rodar o Projeto

### 1. Clonar o Repositório

Clone este repositório para sua máquina local:

```bash
git clone https://github.com/seu-usuario/atm-machine.git
```

### 2. Compilar e Rodar

- Importe o projeto na sua IDE favorita (IntelliJ, Eclipse, NetBeans).
- Execute a classe Main.java como um programa Java.
- Navegue até o diretório do projeto e compile os arquivos .java:

```bash
javac Atm.java Main.java
```

- Execute a classe Main para iniciar o caixa eletrônico:

```bash
java Main
```

### 3. Rodando os Testes (Baseado em TDD)

- O projeto foi desenvolvido seguindo a metodologia Test-Driven Development (TDD), e inclui uma série de testes unitários para validar suas funcionalidades. Para rodar os testes, siga as instruções abaixo:

- Se você estiver utilizando uma IDE (como IntelliJ ou Eclipse), basta localizar a classe de teste (AtmTest.java ou um nome similar) e rodar os testes diretamente da IDE.

- Certifique-se de que você tenha o JUnit configurado no seu projeto. Caso esteja usando Maven ou Gradle, o JUnit pode ser facilmente adicionado como dependência.

### 4. Estrutura do Código

- Atm.java: Contém a lógica de negócios para a simulação do caixa eletrônico, incluindo a criação de contas, autenticação, depósitos, saques, transferências e histórico de transações.
- Main.java: Classe principal que gerencia a interação com o usuário, oferecendo um menu para o usuário criar uma conta, fazer login e realizar operações bancárias.
- AtmTest.java: Contém os testes unitários escritos com JUnit para garantir o bom funcionamento da classe ATMMachine e suas funcionalidades, validando a criação de contas, depósitos, saques, etc.
  













