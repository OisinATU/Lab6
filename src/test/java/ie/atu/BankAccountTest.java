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

}
