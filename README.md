# Cubos Bank - Sistema Bancário

Este projeto é uma aplicação de sistema bancário simples chamada **Cubos Bank**, desenvolvida em Java com suporte para contas pessoais e jurídicas. A aplicação permite criar contas, realizar depósitos, saques, e visualizar o extrato das contas. O projeto inclui testes unitários utilizando JUnit e Mockito e é gerenciado com o Maven.

## Estrutura do Projeto

### Pacotes e Arquivos

- `BankAccount.java`: Classe abstrata que define os métodos e propriedades comuns para contas bancárias.
- `BusinessAccount.java`: Classe que representa uma conta bancária para pessoa jurídica (CNPJ).
- `PersonalAccount.java`: Classe que representa uma conta bancária para pessoa física (CPF).
- `BankSystem.java`: Classe principal que contém as funcionalidades do sistema, como login e criação de contas.
- `BankAccountTest.java`: Testes unitários para validar as operações de depósito, saque e impressão de extrato das contas.
- `pom.xml`: Arquivo de configuração do Maven, incluindo dependências para JUnit, Mockito e Jacoco para cobertura de testes.

## Funcionalidades

1. **Criar Conta**: Permite ao usuário criar uma conta pessoal ou empresarial com dados básicos como nome, endereço, saldo inicial e senha.
2. **Login**: Verifica se o usuário está registrado e se a senha fornecida está correta.
3. **Depósito**: Adiciona uma quantia ao saldo da conta.
4. **Saque**: Deduz uma quantia do saldo da conta, se houver fundos suficientes.
5. **Extrato**: Exibe todas as transações realizadas na conta e o saldo atual.

## Testes

Os testes estão localizados no arquivo `BankAccountTest.java`. Os principais cenários testados são:

- **Depósito em Conta**: Verifica se o saldo é atualizado corretamente após um depósito.
- **Saque da Conta**: Verifica se o saldo é atualizado corretamente após um saque.
- **Impressão de Extrato**: Testa a saída do método `printStatement()` para assegurar que o extrato é impresso corretamente.

Para executar os testes, utilize o comando Maven:

```bash
mvn test
