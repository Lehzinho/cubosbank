package br.com.cubosbank;

public class PersonalAccount extends BankAccount{
    
    private String cpf;

    public PersonalAccount(
        String customerName,
        String billinAddress,
        double initialBalance,
        String password,
        String cpf
    ){
        super(customerName, billinAddress, initialBalance, password);
        this.cpf = cpf;
    }

    
    @Override
    public String getAccountDetails() {
        return "Personal Account [CPF: " + this.cpf + "]";
    }

}
