package br.com.cubosbank;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {

    @Mock
    private PrintStream mockPrintStream;

    private PersonalAccount personalAccount;
    private BusinessAccount businessAccount;

    @Before
    public void setUp(){

        System.setOut(mockPrintStream);

        personalAccount = new PersonalAccount("Alexandre Toulios", "Rua 7 de Setembro, 524", 1000, "001.054.671-54", "123123");
        businessAccount = new BusinessAccount("Vivane Castilho", "Rua 2 de Setembro, 123", 10000, "73.798.618/0001-12", "123123");
    }

    @Test
    public void depositMoneyToTheAccount() {
        
        personalAccount.deposit(500);
        businessAccount.deposit(200);
        double expectedValueP = 1500;
        double returnedValueP = personalAccount.getBalance();

        double expectedValueB = 10200;
        double returnedValueB = businessAccount.getBalance();

        double delta = 0.01;

  
        assertEquals(expectedValueP, returnedValueP, delta);
        assertEquals(expectedValueB, returnedValueB, delta);
    }

    @Test
    public void withdrawMoneyFromTheAccount() {

        personalAccount.withdraw(500);
        double expectedValueP = 500;
        double returnedValueP = personalAccount.getBalance();
        
        businessAccount.withdraw(5000);
        double expectedValueB = 5000;
        double returnedValueB = businessAccount.getBalance();

        double delta = 0.01;

  
        assertEquals(expectedValueP, returnedValueP, delta);
        assertEquals(expectedValueB, returnedValueB, delta);
    }

    @Test
    public void testPrintStatement(){
        personalAccount.printStatement();

        verify(mockPrintStream).println("Extrato de Alexandre Toulios");
    }

}
