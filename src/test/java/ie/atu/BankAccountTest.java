package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {


    BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    void constructorInitialisation(){
        account = new BankAccount("ACC12345", "Oisin", 100);
        assertEquals("ACC12345", account.getAccNo());
        assertEquals("Oisin", account.getName());
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructorNegativeInitialisation(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Oisin", -100));
        assertEquals("Balance must be greater than 0", ex.getMessage());
    }

    @Test
    public void testDeposit_success() {
        account = new BankAccount("ACC12345", "Oisin", 100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testDeposit_failure(){
        account = new BankAccount("ACC12345", "Oisin", 100);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertEquals("Amount must be greater than 0", ex.getMessage());
    }

    @Test
    void testWithdraw_success() {
        account = new BankAccount("ACC12345", "Oisin", 100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void testWithdraw_zeroAmount() {
        account = new BankAccount("ACC12345", "Oisin", 100);
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(0));
        assertEquals("Withdraw amount must be greater than 0", ex.getMessage());
    }

    @Test
    void testWithdraw_negativeAmount() {
        account = new BankAccount("ACC12345", "Oisin", 100);

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-20));

        assertEquals("Withdraw amount must be greater than 0", ex.getMessage());
    }

    @Test
    void testWithdraw_notEnoughFunds() {
        account = new BankAccount("ACC12345", "Oisin", 100);

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(150));

        assertEquals("Insufficient funds", ex.getMessage());
    }



}
