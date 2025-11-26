package ie.atu;

public class BankAccount {

    private String accNo;
    private String name;
    private double balance;

    public BankAccount(String accNo, String name, double balance) {
        if(balance<= 0){
            throw new IllegalArgumentException("Balance must be greater than 0");
        }
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public BankAccount(){

    }

    public String getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Withdraw amount must be greater than 0");
        }
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }


}
