package br.com.cubosbank;

public class BusinessAccount extends BankAccount{
    private String cnpj;

    public BusinessAccount(
        String customerName,
        String billinAddress,
        double initialBalance,
        String cnpj,
        String password
    ){
        super(customerName, billinAddress, initialBalance, password);
        this.cnpj = cnpj;
    }

    @Override
    public String getAccountDetails() {

        return "Business Account [CNPJ: " + this.cnpj + "]";
    }

}
