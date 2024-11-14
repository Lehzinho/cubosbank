package br.com.cubosbank;

import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {

    private HashMap<String, BankAccount> accountsDataBase;

    private Scanner scanner;

    public BankSystem(HashMap<String, BankAccount> accountsDataBase, Scanner scanner){
        this.accountsDataBase = accountsDataBase;
        this.scanner = scanner;
    }

    public void login(String identifier, String password){
        if(accountsDataBase.containsKey(identifier)){
            BankAccount bankAccount = accountsDataBase.get(identifier);

            boolean passwordMatch = bankAccount.verifyPassword(password);

            if(passwordMatch){
                System.out.println("Usuário logado com sucesso. Bem vindo(a) " + bankAccount.getCustomerName());
            }else{
                System.out.println("Senha invalida");
            }

        }else{
            System.out.println("Conta não encontrada");
        }
    }

    public void createAccount(){
        System.out.println("Criando uma nova conta:");

        System.out.println("digite o nome do cliente");
        String name= scanner.nextLine();
        
        System.out.println("Digite o endereço de cobrança;");
        String address = scanner.nextLine();
        
        System.out.println("digite o saldo inicial:");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("digite sua Senha");
        String password = scanner.nextLine();

        System.out.println("Digite o tipo da conta (1 para física, 2 para jurídica):");
        int accountType  = scanner.nextInt();
        scanner.nextLine();

        if (accountType == 1){
            System.out.println("Digite o CPF");
            String cpf = scanner.nextLine();
            PersonalAccount personalAccount = new PersonalAccount(name, address, balance, cpf, password);
            accountsDataBase.put(cpf, personalAccount);
            System.out.println("Conta pessoal criada com sucesso!");
        } else if (accountType == 2){
            System.out.println("Digite o CNPJ");
            String cnpj = scanner.nextLine();
            BusinessAccount businessAccount = new BusinessAccount(name, address, balance, cnpj, password);
            accountsDataBase.put(cnpj ,businessAccount );
            System.out.println("Conta jurídica criada com sucesso!");
        
        }else{
            System.out.println("Operação inválida");
        }

    }


    public static void main(String[] args) {
        HashMap<String, BankAccount> accountsDataBase = new HashMap<String, BankAccount>();

        Scanner scanner = new Scanner(System.in);

        BankSystem bankSystem = new BankSystem(accountsDataBase, scanner);


        int option;

        do{
            System.out.println("Seja bem vindo(a) ao CubosBank.");
            System.out.println("1. Login");
            System.out.println("2. Criar conta");
            System.out.println("3. Deletar conta");
            System.out.println("0. Sair");
            System.out.println("digite a opção desejada:");
            
            option = scanner.nextInt();
            
            scanner.nextLine();
            
            switch (option) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                
                default:
                    System.out.println("Operação inválida. Tente novamente.");
                    break;
            }
            
        }while(option != 0);

    }
}