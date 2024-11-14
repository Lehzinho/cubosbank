package br.com.cubosbank;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private String customerName;
    private String billingAddress;
    private double balance;
    private String password;
    private List<String> transactions;

    public BankAccount(
        String customerName,
        String billingAddress,
        double initialBalance,
        String password
    ){
        this.balance = initialBalance;
        this.billingAddress = billingAddress;
        this.customerName = customerName;
        this.transactions = new ArrayList<String>();
        this.transactions.add("Saldo Inicial: " + initialBalance);
        this.password = password;
    }

    public void deposit(double amount){
        if(amount > 0){

            balance += amount;
            
            transactions.add("Deposito: " + amount);

        }else{
            transactions.add("Falha na tentativa de Depósito: " + amount);
        }
    }


    public void withdraw(double amount){
        if(amount > 0 && amount <= this.balance){
            balance -= amount;

            transactions.add("Saque: " + amount);
        }else{
            transactions.add("Falha na tentativa de Saque: " + amount);
        }
    }

    public void printStatement(){
        System.out.println("Extrato de " + customerName);
        
        for(String transaction: transactions){
            System.out.println(transaction);
        }
        
        System.out.println("Salto atual: " + balance);
    }

    public boolean verifyPassword(String typedPassword){

        if(typedPassword.equals(password))  return true;

        return false;
    }


    // Getter and Setters

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBillingAddress() {
        return this.billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getBalance() {
        return this.balance;
    }

    public List<String> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public abstract String getAccountDetails();


}
